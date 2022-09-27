package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.AsientoWina;


@Repository
public interface AsientosRepositoryWina  extends JpaRepository<AsientoWina,String>{
@Query("select a from AsientoWina a where a.id_mano= (select max(b.id_mano) from AsientoWina b)")
AsientoWina getAsientosMAxId();
@Query ("select a from AsientoWina a where a.id_mano = (select DISTINCT(max(f.id_mano)) from FechaWina f where f.username=?1)")
AsientoWina getUltimaMano(String username);

}
