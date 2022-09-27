package com.grokonez.jwtauthentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.model.AsientoWina;
import com.grokonez.jwtauthentication.repository.AsientosRepositoryWina;



public interface IAsientoWina {

	void save(AsientoWina asiento);
	AsientoWina getAsientosUltimaMano(String username);
	@Service
	public class AsientoClass implements IAsientoWina{
@Autowired
AsientosRepositoryWina asientoRepository;
		@Override
		public void save(AsientoWina asiento) {
			// TODO Auto-generated method stub
			asientoRepository.save(asiento);
		}
		@Override
		public AsientoWina getAsientosUltimaMano(String username) {
			// TODO Auto-generated method stub
			return asientoRepository.getUltimaMano(username);
		}
		
	}
}
