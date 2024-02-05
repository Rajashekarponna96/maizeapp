package com.maizeapp.maize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maizeapp.maize.entity.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long>{

	

}
