/**
 * @author Elijah Edlund - ezedlund
 * CIS175 - Fall 2021
 * Nov 16, 2022
 */
package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	List<Movie> findByOrderByRentalDateAsc();
}
