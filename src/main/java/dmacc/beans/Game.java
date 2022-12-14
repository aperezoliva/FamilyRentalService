/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 12, 2022
 */
package dmacc.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Game class
 */
@Entity
public class Game {
	// Game details
	@Id
	@GeneratedValue
	long ID;
	String title;
	String yearReleased;
	String esrbRating;
	String description;
	// have to use full name here instead of abbreviating to desc as 'desc' is a
	// reserved word and will crash
	String genre;
	// Store details
	int copies;
	boolean available;
	@Column(columnDefinition = "DATE")
	LocalDate rentalDate;

	// Not sure how to implement this in relationship with the customer, will just
	// leave it as is for now and worry about it the next week
	boolean isRented;
	double price;

	// Default no-args constructor
	public Game() {
		super();
		// For now rentalDate will show the current date, will change it later to show a
		// specific date to avoid confusion (Example: 12/01/1965)
		this.rentalDate = LocalDate.now();
	}

	// Main constructor
	public Game(String title, String yearReleased, String esrbRating, String description, int copies) {
		// TODO: input validation
		super();
		this.title = title;
		this.yearReleased = yearReleased;
		this.esrbRating = esrbRating;
		this.copies = copies;
		this.description = description;
		if (this.copies > 0)
			this.available = true;
		else
			this.available = false;
	}

	public Game(String title, String yearReleased, String esrbRating, String description, int copies, double price,
			LocalDate rentalDate) {
		// TODO: input validation
		super();
		this.title = title;
		this.yearReleased = yearReleased;
		this.esrbRating = esrbRating;
		this.description = description;
		this.copies = copies;
		if (this.copies > 0)
			this.available = true;
		else
			this.available = false;
		this.price = price;
		this.rentalDate = rentalDate;
	}

	// Check if movie can be rented then reduce copies
	public boolean rent() {
		if (this.copies >= 1) {
			this.copies--;
			return true;
		} else
			return false;
	}
	
	//Changes game rental date from seven days to now
	//Only run when it's being rented
	public void changeRentDate() {
		this.rentalDate = LocalDate.now().plusDays(7);
	}

	// Return game
	// could be replaced with addCopies()
	public void returnGame() {
		this.copies++;
	}

	// Add new copies
	public void addCopies(int copiesToAdd) {
		this.copies += copiesToAdd;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(String yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getEsrbRating() {
		return esrbRating;
	}

	public void setEsrbRating(String esrbRating) {
		this.esrbRating = esrbRating;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	// used to display rented
	public String toString() {
		return ID + " | " + title + "(" + yearReleased + ") Rated:" + esrbRating + " Genre:" + genre + ". About:"
				+ description;
	}

}
