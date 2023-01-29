package com.poker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.model.FichasStars;
import com.poker.repository.FichasRepositoryStars;
public interface IFichasStars {
void save(FichasStars fichasStars);
@Service
public class FichasStarsClass implements IFichasStars{
@Autowired
FichasRepositoryStars fichasRepositoryStars;

@Override
public void save(FichasStars fichasStars) {
	fichasRepositoryStars.save(fichasStars);
}
	
}
}
