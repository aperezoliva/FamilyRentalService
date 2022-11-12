/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 12, 2022
 */
package dmacc.beans;

/**
 * Movie class
 */
public class Movie {
	// Movie details
	String title;
	String yearReleased;
	String rating;

	// Store details
	int copies;
	boolean available;

	public Movie() {
	}

	public Movie(String title, String yearReleased, String rating, int copies) {
		super();
		this.title = title;
		this.yearReleased = yearReleased;
		this.rating = rating;
		this.copies = copies;
		if (copies > 0)
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

	@Override
	public String toString() {
		return "Movie [title=" + title + ", yearReleased=" + yearReleased + ", rating=" + rating + ", copies=" + copies
				+ ", available=" + available + "]";
	}

}
