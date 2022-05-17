package com.donation.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.donation.dao.DonateRepository;
import com.donation.dto.MessageDTO;
import com.donation.model.Donate;
import com.donation.service.DonateService;

@RestController
public class DonateController {
	@Autowired
	DonateRepository donateRepository;
	
	@Autowired
	DonateService donateService;
	@PostMapping("donate/save")
	public ResponseEntity<?> save(@RequestBody Donate donate) {
		try {
			System.out.println("donate"+donate);
			donateService.save(donate);
			MessageDTO message = new MessageDTO("Success");
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			MessageDTO message = new MessageDTO(e.getMessage());
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("donate/list")
	public List<Donate> findAll() {
		List<Donate> donatelist = null;
		try {
			donatelist = donateService.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return donatelist;
	}
}
