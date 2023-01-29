package com.poker.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poker.jwtauthentication.model.FechaWina;


@Repository
public interface FechaRepositoryWina  extends JpaRepository<FechaWina,String>{
	
}
