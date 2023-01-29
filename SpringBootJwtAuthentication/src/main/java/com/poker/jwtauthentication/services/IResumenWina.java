package com.poker.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.jwtauthentication.model.ResumenWina;
import com.poker.jwtauthentication.repository.ResumenRepositoryWina;

public interface IResumenWina {
	public void save(ResumenWina resumen);
@Service
public class ResumenClass implements IResumenWina {
	
	@Autowired 
	ResumenRepositoryWina resumenRepository;

	@Override
	public void save(ResumenWina resumen) {
		// TODO Auto-generated method stub
		resumenRepository.saveAndFlush(resumen);
	}
	}
}
