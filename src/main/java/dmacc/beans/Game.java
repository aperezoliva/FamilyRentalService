/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 12, 2022
 */
package dmacc.beans;

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

	// Store details
	int copies;
	boolean available;
	// TODO: add rentPrice

	// Default no-args constructor
	public Game() {
	}

	// Main constructor
	public Game(String title, String yearReleased, String esrbRating, int copies) {
		// TODO: input validation
		super();
		this.title = title;
		this.yearReleased = yearReleased;
		this.esrbRating = esrbRating;
		this.copies = copies;
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

	@Override
	public String toString() {
		return "Game [ID=" + ID + ", title=" + title + ", yearReleased=" + yearReleased + ", esrbRating=" + esrbRating
				+ ", copies=" + copies + ", available=" + available + "]";
	}

}
