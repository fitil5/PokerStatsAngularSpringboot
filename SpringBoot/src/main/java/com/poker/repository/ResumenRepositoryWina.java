package com.poker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poker.model.ResumenWina;
@Repository
public interface ResumenRepositoryWina extends JpaRepository<ResumenWina, String>{

}
