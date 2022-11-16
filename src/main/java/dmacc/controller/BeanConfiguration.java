/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 14, 2022
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Customer;
import dmacc.beans.Game;
import dmacc.beans.Movie;

/**
 * Bean config
 */
@Configuration
public class BeanConfiguration {

	// Customer bean
	@Bean
	public Customer customer() {
		Customer bean = new Customer();
		return bean;
	}

	// Movie bean
	@Bean
	public Movie movie() {
		Movie bean = new Movie();
		return bean;
	}

}
