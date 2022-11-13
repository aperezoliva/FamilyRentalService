/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 12, 2022
 */
package controller;

import java.util.ArrayList;
import java.util.List;

import dmacc.beans.Game;

// Testing 
public class tester {

	public static void main(String[] args) {
		List<String> avail = new ArrayList<String>();
		avail.add("XboxOne");
		avail.add("PC");
		Game test = new Game("Test Title", "2022", "M", avail, 5);

		System.out.println(test.toString());

	}

}
