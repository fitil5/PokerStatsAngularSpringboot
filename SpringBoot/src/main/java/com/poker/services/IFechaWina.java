package com.poker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.model.FechaWina;
import com.poker.repository.FechaRepositoryWina;



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
