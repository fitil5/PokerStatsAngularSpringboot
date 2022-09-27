package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.ResumenStars;
@Repository
public interface ResumenRepositoryStars extends JpaRepository<ResumenStars, String>{

}
