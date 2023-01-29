package com.poker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poker.model.FichasStars;
import com.poker.model.IdFichasStars;
@Repository
public interface FichasRepositoryStars extends JpaRepository<FichasStars,IdFichasStars>{

}
