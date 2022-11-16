/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 14, 2022
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Customer;
import dmacc.repository.CustomerRepository;

@Controller
public class WebController {
	@Autowired
	CustomerRepository repo;

	// Create customer with model
	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "input";
	}

	// Create customer with actual data
	@PostMapping("/inputCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		repo.save(c);
		return viewAllCustomers(model);
	}

	// View all
	@GetMapping("/viewAll")
	public String viewAllCustomers(Model model) {
		if (repo.findAll().isEmpty())
			return addNewCustomer(model);
		model.addAttribute("customers", repo.findAll());
		return "results";
	}

	// Edit customer info
	@GetMapping("/edit/{ID}")
	public String showUpdateContact(@PathVariable("ID") long ID, Model model) {
		Customer c = repo.findById(ID).orElse(null);
		model.addAttribute("newCustomer", c);
		return "input";
	}

	// Update customer
	@PostMapping("/update/{ID}")
	public String reviseCustomer(Customer c, Model model) {
		repo.save(c);
		return viewAllCustomers(model);
	}

	// Delete customer
	@GetMapping("/delete/{ID}")
	public String deleteCustomer(@PathVariable("ID") long ID, Model model) {
		Customer c = repo.findById(ID).orElse(null);
		repo.delete(c);
		return viewAllCustomers(model);
	}

}
