package com.poker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.poker.model.IdMovimientoStars;
import com.poker.model.MovimientoStars;
import com.poker.model.MovimientoStars9Max;
@Repository
public interface Movimiento9maxRepository extends JpaRepository<MovimientoStars9Max,IdMovimientoStars>{
	@Query(
	        value = "select count(distinct(mov.id_mano)) from movimientos_9max_stars mov where mov.ronda=1 and mov.nombre_jugador= ?1 and( mov.tipo='raises' or mov.tipo='calls' or mov.tipo='bets') ", 
	        nativeQuery=true
	    )
	public Double getVpip(String nombre_jugador);
	@Query(
	        value = "select count(distinct(mov.id_mano)) from movimientos_9max_stars mov where mov.ronda=1 and mov.nombre_jugador= ?1", 
	        nativeQuery=true
	    )
	public Double getVpipTotal(String nombre_jugador);

	@Query(
	        value = "select (sum(mov.cant)/sum(mov.pot))*100  from movimientos_9max_stars mov where mov.ronda=2 and mov.nombre_jugador= ?1 and  mov.tipo='bets'", 
	        nativeQuery=true
	    )
	public Double getMediaCantFlop(String nombre_jugador);
	@Query(
	        value = "select (sum(mov.cant)/sum(mov.pot))*100  from movimientos_9max_stars mov where mov.ronda=3 and mov.nombre_jugador= ?1 and  mov.tipo='bets'", 
	        nativeQuery=true
	    )
	public Double getMediaCantTurn(String nombre_jugador);
	@Query(
	        value = "select (sum(mov.cant)/sum(mov.pot))*100 from movimientos_9max_stars mov where mov.ronda=4 and mov.nombre_jugador= ?1 and  mov.tipo='bets'", 
	        nativeQuery=true
	    )
	public Double getMediaCantRiver(String nombre_jugador);
	@Query(
	        value = "select count(distinct(mov.id_mano))  from movimientos_9max_stars mov where mov.ronda=1 and mov.nombre_jugador= ?1 and( mov.tipo='raises' or mov.tipo='bets')", 
	        nativeQuery=true
	    )
	public Double getPfr(String nombre_jugador);
	@Query(
	        value = "select count(distinct(mov.id_mano)) from movimientos_9max_stars mov where mov.ronda=1 and mov.nombre_jugador= ?1 ", 
	        nativeQuery=true
	    )
	public Double getPfrTotal(String nombre_jugador);
	@Query(
	        value = "select count(distinct(mov.id_mano)) from movimientos_9max_stars mov where mov.nombre_jugador= ?1 ", 
	        nativeQuery=true
	    )
	public Double getManos(String nombre_jugador);

	@Procedure(procedureName ="bet3_stars9max")
	public Double get3Bet(String p_jugador);
	@Procedure(procedureName ="cbet_stars9max")
	public Double getCbet(String p_jugador);
	@Procedure(procedureName ="cbetcall_stars9max")
	public Double getCbetCall(String p_jugador);
	@Procedure(procedureName ="cbetcallturn_stars9max")
	public Double getCbetCallTurn(String p_jugador);
	@Procedure(procedureName ="foldcbet_stars9max")
	public Double getfoldCbet(String p_jugador);
}
