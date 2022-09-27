package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grokonez.jwtauthentication.model.FechaStars;
import com.grokonez.jwtauthentication.model.IdFichasStars;


@Repository
public interface FechaRepositoryStars extends JpaRepository<FechaStars,IdFichasStars>{
	
}
