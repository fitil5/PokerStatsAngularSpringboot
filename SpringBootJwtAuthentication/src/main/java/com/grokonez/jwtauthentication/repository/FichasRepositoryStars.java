package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.FichasStars;
import com.grokonez.jwtauthentication.model.IdFichasStars;
@Repository
public interface FichasRepositoryStars extends JpaRepository<FichasStars,IdFichasStars>{

}
