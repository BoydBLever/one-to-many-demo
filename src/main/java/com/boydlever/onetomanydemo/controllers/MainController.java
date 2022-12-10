package com.boydlever.onetomanydemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
		// render the list of user so that we can pick user from the list
		List<User> userList = userService.allUsers();
		model.addAttribute(userList);
		
		return "createDonationForm.jsp";
	}
	//process user form
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
	//dashboard for donations
	@GetMapping("/")
	public String donationDashboard(Model model) {
		model.addAttribute("userList", userService.allUsers());
		model.addAttribute("donationList", donationService.allDonations());
		return "donationDashboard.jsp";
	}
	
	//find one user {localhost:8080/users/4)
	@GetMapping("/users/{id}")
	public String oneUser(@PathVariable("id")Long id, Model model) {
		model.addAttribute("user", userService.oneUser(id));
		return "userDetails.jsp";
	}
	//find one donation
	@GetMapping("/donations/{id}")
	public String oneDonation(@PathVariable("id")Long id, Model model) {
		model.addAttribute("donation", donationService.oneDonation(id));
		return "donationDetails.jsp";
	}
	// edit: findOne + create 1. find the donation by id 2. form 3. process
	@GetMapping("/donations/edit/{id}")
	public String editDonationForm(@PathVariable("id")Long id, Model model){
		model.addAttribute("donation", donationService.oneDonation(id));
		return "editDonation.jsp";
	}
	//process
	@PutMapping("/donations/edit/{id}")
	public String processEditDonation(
			@Valid @ModelAttribute("donation")Donation donation,
			BindingResult result, @PathVariable("id")Long id) {
		if(result.hasErrors()) {
			return "editDonation.jsp";
		} else {
			donationService.editDonation(donation);
			return "redirect:/donations/{id}";
		}
		
	}
	//delete
	@DeleteMapping("/donations/delete/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		donationService.deleteDonation(id);
		return "redirect:/";
	}
}
