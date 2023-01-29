package com.poker.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poker.jwtauthentication.model.IdMovimientoWina;
import com.poker.jwtauthentication.model.MovimientoWina;

@Repository
public interface MovimientoRepositoryWina extends JpaRepository<MovimientoWina,IdMovimientoWina>{
//@Query("((select count(distinct(m.id_mano)) from Movimiento m where m.ronda=1 and m.tipo='raise' and m.nombre_jugador=?1)/(select count(distinct(m2.id_mano)) from Movimiento m2 where m2.ronda=1 and m2.nombre_jugador=?1))*100")
//int vpip(String nombre_jugador);
//@Query("select count(distinct(mov.id_mano)) from Movimiento mov where mov.ronda=1 and mov.tipo='raises' or mov.tipo='calls' and mov.nombre_jugador= ?1")
//Estadisticas getCountVpip(String nombre_jugador);
//(select count(distinct(m2.id_mano)) from Movimiento m2 where m2.ronda=1 and m2.nombre_jugador=?1)
@Query(
        value = "select count(distinct(mov.id_mano)) from movimientos_wina mov where mov.ronda=1 and mov.nombre_jugador= ?1 and( mov.tipo='raises' or mov.tipo='calls' or mov.tipo='bets') ", 
        nativeQuery=true
    )
public Double getVpip(String nombre_jugador);
@Query(
        value = "select count(distinct(mov.id_mano)) from movimientos_wina mov where mov.ronda=1 and mov.nombre_jugador= ?1", 
        nativeQuery=true
    )
public Double getVpipTotal(String nombre_jugador);

@Query(
        value = "select (sum(mov.cant)/sum(mov.pot))*100  from movimientos_wina mov where mov.ronda=2 and mov.nombre_jugador= ?1 and (mov.tipo='raises' or mov.tipo='bets')", 
        nativeQuery=true
    )
public Double getMediaCantFlop(String nombre_jugador);
@Query(
        value = "select (sum(mov.cant)/sum(mov.pot))*100  from movimientos_wina mov where mov.ronda=3 and mov.nombre_jugador= ?1 and (mov.tipo='raises' or mov.tipo='bets')", 
        nativeQuery=true
    )
public Double getMediaCantTurn(String nombre_jugador);
@Query(
        value = "select (sum(mov.cant)/sum(mov.pot))*100  from movimientos_wina mov where mov.ronda=4 and mov.nombre_jugador= ?1 and (mov.tipo='raises' or mov.tipo='bets')", 
        nativeQuery=true
    )
public Double getMediaCantRiver(String nombre_jugador);
@Query(
        value = "select count(distinct(mov.id_mano))  from movimientos_wina mov where mov.ronda=1 and mov.nombre_jugador= ?1 and( mov.tipo='raises' or mov.tipo='bets')", 
        nativeQuery=true
    )
public Double getPfr(String nombre_jugador);
@Query(
        value = "select count(distinct(mov.id_mano)) from movimientos_wina mov where mov.ronda=1 and mov.nombre_jugador= ?1 ", 
        nativeQuery=true
    )
public Double getPfrTotal(String nombre_jugador);
@Query(
        value = "select count(distinct(mov.id_mano)) from movimientos_wina mov where mov.nombre_jugador= ?1 ", 
        nativeQuery=true
    )
public Double getManos(String nombre_jugador);

@Procedure(procedureName ="bet3_wina")
public Double get3Bet(String p_jugador);
@Procedure(procedureName ="cbet_wina")
public Double getCbet(String p_jugador);
@Procedure(procedureName ="cbetcall_wina")
public Double getCbetCall(String p_jugador);
@Procedure(procedureName ="cbetcallturn_wina")
public Double getCbetCallTurn(String p_jugador);
@Procedure(procedureName ="foldcbet_wina")
public Double getfoldCbet(String p_jugador);


}

