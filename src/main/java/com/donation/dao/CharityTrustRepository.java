package com.donation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.model.CharityTrust;

public interface CharityTrustRepository extends JpaRepository<CharityTrust, Integer> {
	
}
