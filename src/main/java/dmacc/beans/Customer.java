/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 12, 2022
 */
package dmacc.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Customer class
 */
@Entity
public class Customer {
	// TODO: input validation
	// Customer details
	@Id
	@GeneratedValue
	int ID;
	String fName;
	String lName;
	String dob; // Maybe replace with better date format?
	String address; // Maybe replace with a separate address class?

	// Store details
	@ElementCollection(targetClass = Movie.class)
	List<Movie> moviesRented;
	@ElementCollection(targetClass = Game.class)
	List<Game> gamesRented;
	double amountDue;
	// TODO: incorporate rent price from game and movie
	// into amountDue OR have a separate class for charges

	// Default no args constructor
	public Customer() {
		this.moviesRented = new ArrayList<Movie>();
		this.gamesRented = new ArrayList<Game>();
	}

	// Main constructor
	public Customer(String fName, String lName, String dob, String address) {
		// TODO: input validation
		super();
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.address = address;
		this.moviesRented = new ArrayList<Movie>();
		this.gamesRented = new ArrayList<Game>();
	}

	// Add a movie to moviesRented list
	public void rentMovie(Movie movie) {
		// TODO: input validation and double adding check
		this.moviesRented.add(movie);
		// TODO: add rent price to amountDue;
	}

	// Add a game to gamesRented list
	public void rentGame(Game game) {
		// TODO: input validation and double adding check
		this.gamesRented.add(game);
		// TODO: add rent price to amountDue;
	}

	// Return a movie
	public void returnMovie(Movie movie) throws Exception {
		// TODO: input validation
		if (this.moviesRented.contains(movie))
			this.moviesRented.remove(movie);
		else
			throw new Exception();
	}

	// Return a game
	public void returnGame(Game game) throws Exception {
		// TODO: input validation
		if (this.gamesRented.contains(game))
			this.gamesRented.remove(game);
		else
			throw new Exception();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Movie> getMoviesRented() {
		return moviesRented;
	}

	public void setMoviesRented(List<Movie> moviesRented) {
		this.moviesRented = moviesRented;
	}

	public List<Game> getGamesRented() {
		return gamesRented;
	}

	public void setGamesRented(List<Game> gamesRented) {
		this.gamesRented = gamesRented;
	}

	public double getAmountDue() {
		return amountDue;
	}

	public void setAmountDue(double amountDue) {
		this.amountDue = amountDue;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", fName=" + fName + ", lName=" + lName + ", dob=" + dob + ", address=" + address
				+ ", moviesRented=" + moviesRented.toString() + ", gamesRented=" + gamesRented.toString()
				+ ", amountDue=" + amountDue + "]";
	}

}
