package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact> findAll() {
		
		return (List<Contact>)contactRepository.findAll();
	}
	
	@Override
	public Page<Contact> list(int pageNumber) {
		
		int pageSize = 3;
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);	
		
		return contactRepository.findAll(pageable);
	}

	@Override
	public void save(Contact contact) {
		
		String name = contact.getName();
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();		
		contact.setName(name);
		
		contactRepository.save(contact);		
	}

	@Override
	public Contact findById(int id) {
		
		Optional<Contact> optionalContact = contactRepository.findById(id);
		Contact contact = optionalContact.get();
		
		return contact;
	}

	@Override
	public void delete(int id) {
		
		Contact contact = findById(id);
		contactRepository.delete(contact);		
	}
}
