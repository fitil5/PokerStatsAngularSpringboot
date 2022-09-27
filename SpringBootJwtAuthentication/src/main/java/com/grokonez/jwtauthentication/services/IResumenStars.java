package com.grokonez.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.model.ResumenWina;
import com.grokonez.jwtauthentication.repository.ResumenRepositoryWina;

public interface IResumenStars {
	public void save(ResumenWina resumen);
@Service
public class ResumenClass implements IResumenStars {
	
	@Autowired 
	ResumenRepositoryWina resumenRepository;

	@Override
	public void save(ResumenWina resumen) {
		// TODO Auto-generated method stub
		resumenRepository.saveAndFlush(resumen);
	}
	}
}
