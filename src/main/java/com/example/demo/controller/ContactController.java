package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value = {"/", "/{pageNumber}"})
	public String getContacts(Model model, @PathVariable(name="pageNumber", required = false) Integer pageNumber) {
		
		if(pageNumber == null)
			pageNumber = 1;
		
		Page<Contact> page = contactService.list(pageNumber);
		var contacts = page.getContent();
		
		model.addAttribute("contacts", contacts);
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", page.getTotalPages());
		
		return "contacts";
	}	
	
	@RequestMapping("/get-add-contact")
	public String addContact(Model model) {
		
		model.addAttribute("contact", new Contact());
		return "contact";
	}
	
	@RequestMapping("/save-contact")
	public String saveContact(@ModelAttribute @Valid Contact contact, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("contact", contact);
			return "contact";
		}
		
		contactService.save(contact);
		return "redirect:/";
	}
	
	@RequestMapping("/get-update-contact")
	public ModelAndView getUpdateContact(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("contact");
		mav.addObject("contact", contactService.findById(id));
		
		return mav;
	}
	
	@RequestMapping("delete-contact")
	public String deleteContact(@RequestParam int id) {
		
		contactService.delete(id);
		return "redirect:/";
	}
}
