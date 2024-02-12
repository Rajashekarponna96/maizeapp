
package com.maizeapp.maize.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maizeapp.maize.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	User findByUsername(String userName);

	User findByUsernameAndPassword(String username, String password);

	User findByEmailAndPassword(String email, String password);

	User findByPassword(String password);

	User findByAddressId(Long long1);

	// User findByUser(User user);
	
	Optional<User> findById(Long id);

}
