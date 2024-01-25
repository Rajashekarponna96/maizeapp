package com.maizeapp.maize.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="role")
public class Role {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
