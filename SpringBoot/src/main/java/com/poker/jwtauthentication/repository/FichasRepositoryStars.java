package com.poker.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poker.jwtauthentication.model.FichasStars;
import com.poker.jwtauthentication.model.IdFichasStars;
@Repository
public interface FichasRepositoryStars extends JpaRepository<FichasStars,IdFichasStars>{

}
