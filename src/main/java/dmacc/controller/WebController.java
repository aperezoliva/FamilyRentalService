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
import dmacc.beans.Game;
import dmacc.beans.Movie;
import dmacc.repository.CustomerRepository;
import dmacc.repository.GameRepository;
import dmacc.repository.MovieRepository;

@Controller
public class WebController {
	@Autowired
	CustomerRepository repoCustomer;
	@Autowired
	MovieRepository repoMovie;
	@Autowired
	GameRepository repoGame;

	/* ================ */
	/* !!! CUSTOMER !!! */
	/* ================ */

	// Create customer with model
	@GetMapping("/inputCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "inputCustomer";
	}

	// Create customer with actual data
	@PostMapping("/inputCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		repoCustomer.save(c);
		return viewAllCustomers(model);
	}

	// View all
	@GetMapping("/viewAllCustomers")
	public String viewAllCustomers(Model model) {
		if (repoCustomer.findAll().isEmpty())
			return addNewCustomer(model);
		model.addAttribute("customers", repoCustomer.findAll());
		return "resultsCustomer";
	}

	// Edit customer info
	@GetMapping("/editCustomer/{ID}")
	public String showUpdateContactCustomer(@PathVariable("ID") long ID, Model model) {
		Customer c = repoCustomer.findById(ID).orElse(null);
		model.addAttribute("newCustomer", c);
		return "inputCustomer";
	}

	// Update customer
	@PostMapping("/updateCustomer/{ID}")
	public String reviseCustomer(Customer c, Model model) {
		repoCustomer.save(c);
		return viewAllCustomers(model);
	}

	// Delete customer
	@GetMapping("/deleteCustomer/{ID}")
	public String deleteCustomer(@PathVariable("ID") long ID, Model model) {
		Customer c = repoCustomer.findById(ID).orElse(null);
		repoCustomer.delete(c);
		return viewAllCustomers(model);
	}

	/* ============= */
	/* !!! MOVIE !!! */
	/* ============= */

	// Create movie with model
	@GetMapping("/inputMovie")
	public String addNewMovie(Model model) {
		Movie m = new Movie();
		model.addAttribute("newMovie", m);
		return "inputMovie";
	}

	// Create movie with actual data
	@PostMapping("/inputMovie")
	public String addNewMovie(@ModelAttribute Movie m, Model model) {
		repoMovie.save(m);
		return viewAllMovies(model);
	}

	// View all
	@GetMapping("/viewAllMovies")
	public String viewAllMovies(Model model) {
		if (repoMovie.findAll().isEmpty())
			return addNewMovie(model);
		model.addAttribute("movies", repoMovie.findAll());
		return "resultsMovie";
	}
	
	// Shows rental dates -- differs from the one above because the web page below should just show movie titles + day it was rented
	@GetMapping("/viewMovieRentals")
	public String viewMovieRentals(Model model) {
		if (repoMovie.findAll().isEmpty())
			return addNewMovie(model);
		model.addAttribute("movies", repoMovie.findAll());
		return "rentalsMovie";
	}
	
	//Sorts movies
	@GetMapping("/sortMovies")
	public String sortMovies(Model model) {
		model.addAttribute("movies", repoMovie.findByOrderByRentalDateAsc());
		return "rentalMoviesSorted";
	}
	
	// Edit movie info
	@GetMapping("/editMovie/{ID}")
	public String showUpdateContactMovie(@PathVariable("ID") long ID, Model model) {
		Movie m = repoMovie.findById(ID).orElse(null);
		model.addAttribute("newMovie", m);
		return "inputMovie";
	}

	// Update movie
	@PostMapping("/updateMovie/{ID}")
	public String reviseMovie(Movie m, Model model) {
		repoMovie.save(m);
		return viewAllMovies(model);
	}

	// Delete movie
	@GetMapping("/deleteMovie/{ID}")
	public String deleteMovie(@PathVariable("ID") long ID, Model model) {
		Movie m = repoMovie.findById(ID).orElse(null);
		repoMovie.delete(m);
		return viewAllMovies(model);
	}

	/* ============ */
	/* !!! GAME !!! */
	/* ============ */

	// Create game with model
	@GetMapping("/inputGame")
	public String addNewGame(Model model) {
		Game g = new Game();
		model.addAttribute("newGame", g);
		return "inputGame";
	}

	// Create game with actual data
	@PostMapping("/inputGame")
	public String addNewGame(@ModelAttribute Game g, Model model) {
		repoGame.save(g);
		return viewAllGames(model);
	}

	// View all
	@GetMapping("/viewAllGames")
	public String viewAllGames(Model model) {
		if (repoGame.findAll().isEmpty())
			return addNewGame(model);
		model.addAttribute("games", repoGame.findAll());
		return "resultsGame";
	}
	
	// Get game rentals
	@GetMapping("/viewGameRentals")
	public String viewGameRentals(Model model) {
		if (repoMovie.findAll().isEmpty())
			return addNewGame(model);
		model.addAttribute("games", repoGame.findAll());
		return "rentalsGame";
	}
	
	//Sorts Games
	@GetMapping("/sortGames")
	public String sortGames(Model model) {
		model.addAttribute("games", repoGame.findByOrderByRentalDateAsc());
		return "rentalGamesSorted";
	}
	
	// Edit game info
	@GetMapping("/editGame/{ID}")
	public String showUpdateContactGame(@PathVariable("ID") long ID, Model model) {
		Game g = repoGame.findById(ID).orElse(null);
		model.addAttribute("newGame", g);
		return "inputGame";
	}

	// Update game
	@PostMapping("/updateGame/{ID}")
	public String reviseGame(Game g, Model model) {
		repoGame.save(g);
		return viewAllGames(model);
	}

	// Delete game
	@GetMapping("/deleteGame/{ID}")
	public String deleteGame(@PathVariable("ID") long ID, Model model) {
		Game g = repoGame.findById(ID).orElse(null);
		repoGame.delete(g);
		return viewAllGames(model);
	}
	

	/* ===================== */
	/* !!! SHOPPING CART !!! */
	/* ===================== */
	
	@GetMapping("/shoppingCart")
	public String viewSelections(Model model) {
		//Simple checks if repo is empty, if empty add the other repo, else just add both repos
		//its simple enough that it should work lol
		if (repoMovie.findAll().isEmpty())
			if(repoGame.findAll().isEmpty())
				return "inputMovie";
			else
				model.addAttribute("games", repoGame.findAll());
		else if (repoGame.findAll().isEmpty())
			if(repoMovie.findAll().isEmpty())
				return "inputGame";
			else
				model.addAttribute("games", repoGame.findAll());
		else
			model.addAttribute("games", repoGame.findAll());
			model.addAttribute("movies", repoMovie.findAll());
		
		return "shoppingCart";
	}
	
	@PostMapping("/shoppingCheckout")
	public String getSelections(@ModelAttribute(value="games") Game game, @ModelAttribute(value="movies") Movie movie, Model model) {
		model.getAttribute("games");
		model.getAttribute("movies");
		return "shoppingCheckout";
	}
}
