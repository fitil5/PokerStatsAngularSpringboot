package com.poker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poker.model.AsientoStars;
import com.poker.model.AsientoWina;
import com.poker.repository.AsientosRepositoryStars;
import com.poker.repository.AsientosRepositoryWina;



public interface IAsientoStars {

	void save(AsientoStars asiento);
	AsientoStars getAsientosUltimaMano(String username);
	@Service
	public class AsientoClass implements IAsientoStars{
@Autowired
AsientosRepositoryStars asientoRepository;
		@Override
		public void save(AsientoStars asiento) {
			// TODO Auto-generated method stub
			asientoRepository.save(asiento);
		}
		@Override
		public AsientoStars getAsientosUltimaMano(String username) {
			// TODO Auto-generated method stub
			return asientoRepository.getUltimaMano(username);
		}
		
	}
}
