package com.poker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.model.ResumenWina;
import com.poker.repository.ResumenRepositoryWina;

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
