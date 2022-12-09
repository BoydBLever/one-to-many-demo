package com.boydlever.onetomanydemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boydlever.onetomanydemo.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository <Donation, Long> {
	
	List<Donation> findAll();
}
