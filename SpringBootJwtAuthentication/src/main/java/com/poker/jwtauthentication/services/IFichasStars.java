package com.poker.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.jwtauthentication.model.FichasStars;
import com.poker.jwtauthentication.repository.FichasRepositoryStars;
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
