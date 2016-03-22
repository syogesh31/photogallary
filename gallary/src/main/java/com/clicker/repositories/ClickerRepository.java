package com.clicker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clicker.model.Clicker;

public interface ClickerRepository extends JpaRepository<Clicker, Long> {

	List<Clicker> findClickerByEmail(String email);

	List<Clicker> findClickerByUserName(String userName);

	Clicker findFirstClickerByUserName(String userName);
}
