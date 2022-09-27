package com.grokonez.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.repository.FichasRepositoryStars;
import com.grokonez.jwtauthentication.model.FichasStars;
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
