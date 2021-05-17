package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Contact;


public interface ContactService {

	List<Contact> findAll();
	
	Page<Contact> list(int page);
	
	void save(Contact contact);
	
	Contact findById(int id); 
	
	void delete(int id);
}
