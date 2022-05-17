package com.donation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donation.model.Donate;

public interface DonateRepository extends JpaRepository<Donate, Integer> {

}
