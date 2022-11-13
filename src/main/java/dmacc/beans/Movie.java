/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 12, 2022
 */
package dmacc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Movie class
 */
public class Movie {
	// Movie details
	String title;
	String yearReleased;
	String rating;
	List<String> availOn;

	// Store details
	int copies;
	boolean available;
	// TODO: add rentPrice

	// Default no-args constructor
	public Movie() {
		this.availOn = new ArrayList<String>();
	}

	// Main constructor
	public Movie(String title, String yearReleased, String rating, List<String> availOn, int copies) {
		// TODO: input validation
		super();
		this.title = title;
		this.yearReleased = yearReleased;
		this.rating = rating;
		this.copies = copies;
		this.availOn = availOn;
		if (this.copies > 0)
			this.available = true;
		else
			this.available = false;
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

	public List<String> getAvailOn() {
		return availOn;
	}

	public void setAvailOn(List<String> availOn) {
		this.availOn = availOn;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", yearReleased=" + yearReleased + ", rating=" + rating + ", availOn="
				+ availOn.toString() + ", copies=" + copies + ", available=" + available + "]";
	}

}
