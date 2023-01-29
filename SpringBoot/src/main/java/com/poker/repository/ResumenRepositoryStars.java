package com.poker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poker.model.ResumenStars;
@Repository
public interface ResumenRepositoryStars extends JpaRepository<ResumenStars, String>{

}
