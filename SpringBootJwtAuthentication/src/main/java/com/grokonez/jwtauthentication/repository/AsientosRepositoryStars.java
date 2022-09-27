package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grokonez.jwtauthentication.model.AsientoStars;


@Repository
public interface AsientosRepositoryStars  extends JpaRepository<AsientoStars,String>{
@Query("select a from AsientoStars a where a.id_mano= (select max(b.id_mano) from AsientoStars b)")
AsientoStars getAsientosMAxId();
@Query ("select a from AsientoStars a where a.id_mano = (select DISTINCT(max(f.id_mano)) from FechaStars f where f.username=?1)")
AsientoStars getUltimaMano(String username);

}
