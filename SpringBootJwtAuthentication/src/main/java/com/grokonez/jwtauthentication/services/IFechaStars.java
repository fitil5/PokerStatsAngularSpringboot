package com.grokonez.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.model.FechaWina;
import com.grokonez.jwtauthentication.repository.FechaRepositoryWina;



public interface IFechaStars {
	void save(FechaWina fecha);
	@Service
	public class FechaClass implements IFechaStars{
		@Autowired
		FechaRepositoryWina fechaRepository;

		@Override
		public void save(FechaWina fecha) {
			// TODO Auto-generated method stub
			fechaRepository.save(fecha);
		}
	}
	
}
