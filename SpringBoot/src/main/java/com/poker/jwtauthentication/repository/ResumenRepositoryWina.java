package com.poker.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poker.jwtauthentication.model.ResumenWina;
@Repository
public interface ResumenRepositoryWina extends JpaRepository<ResumenWina, String>{

}
