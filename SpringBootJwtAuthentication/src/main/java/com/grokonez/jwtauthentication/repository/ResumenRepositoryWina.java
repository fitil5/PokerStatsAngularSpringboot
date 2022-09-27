package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.ResumenWina;
@Repository
public interface ResumenRepositoryWina extends JpaRepository<ResumenWina, String>{

}
