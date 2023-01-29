package com.poker.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poker.jwtauthentication.model.FechaStars;
import com.poker.jwtauthentication.model.IdFichasStars;


@Repository
public interface FechaRepositoryStars extends JpaRepository<FechaStars,IdFichasStars>{
	
}
