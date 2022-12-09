package com.boydlever.onetomanydemo.services;

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
}
