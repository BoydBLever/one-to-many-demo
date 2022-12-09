package com.boydlever.onetomanydemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boydlever.onetomanydemo.models.Donation;
import com.boydlever.onetomanydemo.models.User;
import com.boydlever.onetomanydemo.services.DonationService;
import com.boydlever.onetomanydemo.services.UserService;

@Controller
public class MainController {

	@Autowired
	private DonationService donationService;
	
	@Autowired
	private UserService userService;
	
	//create user
	//--display user form--
	@GetMapping("/users/new")
	public String newUserForm(Model model) {
		model.addAttribute("newUser", new User());
		return "createUserForm.jsp";
	}
	
	// Process user form
	@PostMapping("/users/new")
	public String processUserForm(
			@Valid @ModelAttribute("newUser")User newUser, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "createUserForm.jsp";
		}else {
			userService.createUser(newUser);
			return "redirect:/";
		}
	}
	//create donations
	// display form
	@GetMapping("/donations/new")
	public String newDonationForm(@ModelAttribute("newDonation")Donation newDonation,
			Model model) {
		List<User> userList = userService.allUsers();
		model.addAttribute(userList);
		return "createDonationForm.jsp";
	}
	//route to process user form
	@PostMapping("/donations/new")
	public String processDonationForm(@Valid @ModelAttribute("newDonation") Donation newDonation,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<User> userList = userService.allUsers();
			model.addAttribute(userList);
			return "createDonationForm.jsp";
		}else {
			donationService.createDonation(newDonation);
			return "redirect:/";
		}
		
	}
}
