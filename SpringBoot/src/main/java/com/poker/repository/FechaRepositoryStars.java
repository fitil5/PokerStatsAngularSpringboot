package com.poker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poker.model.FechaStars;
import com.poker.model.IdFichasStars;


@Repository
public interface FechaRepositoryStars extends JpaRepository<FechaStars,IdFichasStars>{
	
}
