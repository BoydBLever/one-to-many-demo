package com.boydlever.onetomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boydlever.onetomanydemo.models.Donation;
import com.boydlever.onetomanydemo.repositories.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepo;
	
	public Donation createDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	// find all
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	//find one
	public Donation oneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
		if(optionalDonation.isPresent()) {
			return optionalDonation.get();
		}else {
			return null;
		}
	}
	//edit
	public Donation editDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	//delete
	public void deleteDonation(Long id) {
		donationRepo.deleteById(id);
	}
}
