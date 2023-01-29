package com.poker.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.jwtauthentication.model.FechaWina;
import com.poker.jwtauthentication.repository.FechaRepositoryWina;



public interface IFechaWina {
	void save(FechaWina fecha);
	@Service
	public class FechaClass implements IFechaWina{
		@Autowired
		FechaRepositoryWina fechaRepository;

		@Override
		public void save(FechaWina fecha) {
			// TODO Auto-generated method stub
			fechaRepository.save(fecha);
		}
	}
	
}
