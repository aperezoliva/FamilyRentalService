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
 * Movie class
 */
@Entity
public class Movie {
	// Movie details
	@Id
	@GeneratedValue
	long ID;
	String title;
	String yearReleased;
	String rating;

	// Store details
	int copies;
	boolean available;
	//For now rentalDate will show the current date, will change it later to show a specific date to avoid confusion (Example: 12/01/1965)
	@Column(columnDefinition = "DATE")
	LocalDate rentalDate;
	// TODO: add rentPrice

	// Default no-args constructor
	public Movie() {
		super();
		this.rentalDate = LocalDate.now();
	}
	
	public Movie(String title, String yearReleased, String rating, int copies) {
		// TODO: input validation
		super();
		this.title = title;
		this.yearReleased = yearReleased;
		this.rating = rating;
		this.copies = copies;
		if (this.copies > 0)
			this.available = true;
		else
			this.available = false;	

	}
	
	public Movie(long ID, String title, String yearReleased, String rating, int copies, LocalDate rentalDate) {
		// TODO: input validation
		this.ID = ID;
		this.title = title;
		this.yearReleased = yearReleased;
		this.rating = rating;
		this.copies = copies;
		if (this.copies > 0)
			this.available = true;
		else
			this.available = false;	
	
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

	// return a copy
	// could be replaced with addCopies()
	public void returnMovie() {
		this.copies++;
	}

	// add new copies
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
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

	@Override
	public String toString() {
		return "Movie [ID=" + ID + ", title=" + title + ", yearReleased=" + yearReleased + ", rating=" + rating
				+ ", copies=" + copies + ", available=" + available + ", rentalDate=" + rentalDate + "]";
	}

}
