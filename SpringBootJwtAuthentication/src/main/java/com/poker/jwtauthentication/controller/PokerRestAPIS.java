
package com.poker.jwtauthentication.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.poker.jwtauthentication.model.AsientoStars;
import com.poker.jwtauthentication.model.AsientoWina;
import com.poker.jwtauthentication.model.Hud;
import com.poker.jwtauthentication.model.Jugador;
import com.poker.jwtauthentication.services.IAsientoStars;
import com.poker.jwtauthentication.services.IAsientoWina;
import com.poker.jwtauthentication.services.IMovimientoStars;
import com.poker.jwtauthentication.services.IMovimientoStars9max;
import com.poker.jwtauthentication.services.IMovimientoStars9maxTournament;
import com.poker.jwtauthentication.services.IMovimientoWina;

import antlr.Utils;




@CrossOrigin(origins = "*")
@RestController
public class PokerRestAPIS {
@Autowired
IAsientoWina asientoServiceWina;
@Autowired
IMovimientoWina movimientoServiceWina;
@Autowired
IMovimientoStars movimientoServiceStars;
@Autowired
IAsientoStars asientoServiceStars;
@Autowired
IMovimientoStars9max movimientoServiceStars9Max;
@Autowired
IMovimientoStars9maxTournament movimientoServiceStars9MaxTournament;


static String getAlphaNumericString(int n)
{

    // chose a Character random from this String
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz";

    // create StringBuffer size of AlphaNumericString
    StringBuilder sb = new StringBuilder(n);

    for (int i = 0; i < n; i++) {

        // generate a random number between
        // 0 to AlphaNumericString variable length
        int index
            = (int)(AlphaNumericString.length()
                    * Math.random());

        // add Character one by one in end of sb
        sb.append(AlphaNumericString
                      .charAt(index));
    }

    return sb.toString();
}


	@PostMapping("/post")
	public Hud uploadMultipartFile(@RequestParam("file") MultipartFile file) {
			try {
				System.out.println("-------------------------------"+file.getOriginalFilename());
		File newfile = new File("C:/"+file.getOriginalFilename());
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+newfile.getAbsolutePath());
		if (newfile.isFile()) {
			newfile.delete();
		}
		file.transferTo(newfile);
        	
    String username = getAlphaNumericString(6);
			//file.transferTo(newfile);
			if (newfile.isFile()) {
		    	if(!("winamax_positioning_file.dat").equals(file.getName())) {
		    		BufferedReader reader = new BufferedReader(new FileReader(newfile.getAbsolutePath()));
		    		String line =reader.readLine();
		    		reader.close();
		    		if(line.indexOf("PokerStars")!=-1){
		    			
		    			BufferedReader reader2 = new BufferedReader(new FileReader(newfile.getAbsolutePath()));
		    			
		    			String line2=reader2.readLine();
		    			line2=reader2.readLine();
		    			
		    			reader2.close();
		    			
		    			
		    			if(line2.indexOf("9-max" )!=-1 && line.indexOf("Tournament" )==-1) {
		    				
		    				movimientoServiceStars9Max.leerFichero(newfile.getAbsolutePath(),username);
			    			AsientoStars asiento =asientoServiceStars.getAsientosUltimaMano(username);
			    			
		    				Hud hud = new Hud();
			    			Jugador jugador1= new Jugador();
			    			jugador1.setNombre(asiento.getP1_nombre());			    			
			    			jugador1.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP1_nombre()));
			    			jugador1.setVpip(movimientoServiceStars9Max.vpip(asiento.getP1_nombre()));
			    			jugador1.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP1_nombre()));
			    			jugador1.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP1_nombre()));
			    			jugador1.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP1_nombre()));
			    			jugador1.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP1_nombre()));
			    			jugador1.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP1_nombre()));
			    			jugador1.setManos( movimientoServiceStars9Max.getManos(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP1_nombre()));
			    			jugador1.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP1_nombre()));
			    			hud.setP1(jugador1);		
			    			
			    			Jugador jugador2= new Jugador();
			    			jugador2.setNombre(asiento.getP2_nombre());
			    			jugador2.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP2_nombre()));
			    			jugador2.setVpip(movimientoServiceStars9Max.vpip(asiento.getP2_nombre()));
			    			jugador2.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP2_nombre()));
			    			jugador2.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP2_nombre()));
			    			jugador2.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP2_nombre()));
			    			jugador2.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP2_nombre()));
			    			jugador2.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP2_nombre()));
			    			jugador2.setManos( movimientoServiceStars9Max.getManos(asiento.getP2_nombre()));
			    			jugador2.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP2_nombre()));
			    			jugador2.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP2_nombre()));
			    			jugador2.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP2_nombre()));
			    			hud.setP2(jugador2);
			    			
			    			
			    			Jugador jugador3= new Jugador();
			    			jugador3.setNombre(asiento.getP3_nombre());
			    			jugador3.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP3_nombre()));
			    			jugador3.setVpip(movimientoServiceStars9Max.vpip(asiento.getP3_nombre()));
			    			jugador3.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP3_nombre()));
			    			jugador3.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP3_nombre()));
			    			jugador3.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP3_nombre()));
			    			jugador3.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP3_nombre()));
			    			jugador3.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP3_nombre()));
			    			jugador3.setManos( movimientoServiceStars9Max.getManos(asiento.getP3_nombre()));
			    			jugador3.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP3_nombre()));
			    			jugador3.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP3_nombre()));
			    			jugador3.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP3_nombre()));
			    			hud.setP3(jugador3);

			    			Jugador jugador4= new Jugador();
			    			jugador4.setNombre(asiento.getP4_nombre());
			    			jugador4.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP4_nombre()));
			    			jugador4.setVpip(movimientoServiceStars9Max.vpip(asiento.getP4_nombre()));
			    			jugador4.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP4_nombre()));
			    			jugador4.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP4_nombre()));
			    			jugador4.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP4_nombre()));
			    			jugador4.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP4_nombre()));
			    			jugador4.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP4_nombre()));
			    			jugador4.setManos( movimientoServiceWina.getManos(asiento.getP4_nombre()));
			    			jugador4.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP4_nombre()));
			    			jugador4.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP4_nombre()));
			    			jugador4.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP4_nombre()));
			    			hud.setP4(jugador4);
			    			
			    			Jugador jugador5= new Jugador();
			    			jugador5.setNombre(asiento.getP5_nombre());
			    			jugador5.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP5_nombre()));
			    			jugador5.setVpip(movimientoServiceStars9Max.vpip(asiento.getP5_nombre()));
			    			jugador5.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP5_nombre()));
			    			jugador5.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP5_nombre()));
			    			jugador5.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP5_nombre()));
			    			jugador5.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP5_nombre()));
			    			jugador5.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP5_nombre()));
			    			jugador5.setManos( movimientoServiceStars9Max.getManos(asiento.getP5_nombre()));
			    			jugador5.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP5_nombre()));
			    			jugador5.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP5_nombre()));
			    			jugador5.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP5_nombre()));
			    			hud.setP5(jugador5);
			    			
			    			Jugador jugador6= new Jugador();
			    			jugador6.setNombre(asiento.getP6_nombre());
			    			jugador6.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP6_nombre()));
			    			jugador6.setVpip(movimientoServiceStars9Max.vpip(asiento.getP6_nombre()));
			    			jugador6.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP6_nombre()));
			    			jugador6.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP6_nombre()));
			    			jugador6.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP6_nombre()));
			    			jugador6.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP6_nombre()));
			    			jugador6.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP6_nombre()));
			    			jugador6.setManos( movimientoServiceStars9Max.getManos(asiento.getP6_nombre()));
			    			jugador6.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP6_nombre()));
			    			jugador6.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP6_nombre()));
			    			jugador6.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP6_nombre()));
			    			hud.setP6(jugador6);
			    			
			    			Jugador jugador7= new Jugador();
			    			jugador7.setNombre(asiento.getP7_nombre());
			    			jugador7.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP7_nombre()));
			    			jugador7.setVpip(movimientoServiceStars9Max.vpip(asiento.getP7_nombre()));
			    			jugador7.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP7_nombre()));
			    			jugador7.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP7_nombre()));
			    			jugador7.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP7_nombre()));
			    			jugador7.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP7_nombre()));
			    			jugador7.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP7_nombre()));
			    			jugador7.setManos( movimientoServiceStars9Max.getManos(asiento.getP7_nombre()));
			    			jugador7.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP7_nombre()));
			    			jugador7.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP7_nombre()));
			    			jugador7.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP7_nombre()));
			    			hud.setP7(jugador7);
			    			
			    			
			    			
			    			
			    			Jugador jugador8= new Jugador();
			    			jugador8.setNombre(asiento.getP8_nombre());
			    			jugador8.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP8_nombre()));
			    			jugador8.setVpip(movimientoServiceStars9Max.vpip(asiento.getP8_nombre()));
			    			jugador8.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP8_nombre()));
			    			jugador8.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP8_nombre()));
			    			jugador8.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP8_nombre()));
			    			jugador8.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP8_nombre()));
			    			jugador8.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP8_nombre()));
			    			jugador8.setManos( movimientoServiceStars9Max.getManos(asiento.getP8_nombre()));
			    			jugador8.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP8_nombre()));
			    			jugador8.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP8_nombre()));
			    			jugador8.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP8_nombre()));
			    			hud.setP8(jugador8);
			    			
			    			
			    			Jugador jugador9= new Jugador();
			    			jugador9.setNombre(asiento.getP9_nombre());
			    			jugador9.setCbet(movimientoServiceStars9Max.getCbet(asiento.getP9_nombre()));
			    			jugador9.setVpip(movimientoServiceStars9Max.vpip(asiento.getP9_nombre()));
			    			jugador9.setMediaCantFlop(movimientoServiceStars9Max.getMediaCantFlop(asiento.getP9_nombre()));
			    			jugador9.setMediaCantTurn(movimientoServiceStars9Max.getMediaCantTurn(asiento.getP9_nombre()));
			    			jugador9.setMediaCantRiver(movimientoServiceStars9Max.getMediaCantRiver(asiento.getP9_nombre()));
			    			jugador9.setPfr(movimientoServiceStars9Max.getPfr(asiento.getP9_nombre()));
			    			jugador9.setBet3(movimientoServiceStars9Max.get3Bet(asiento.getP9_nombre()));
			    			jugador9.setManos( movimientoServiceStars9Max.getManos(asiento.getP9_nombre()));
			    			jugador9.setCbetCall(movimientoServiceStars9Max.getCbetCall(asiento.getP9_nombre()));
			    			jugador9.setCbetCallTurn(movimientoServiceStars9Max.getCbetCallTurn(asiento.getP9_nombre()));
			    			jugador9.setFoldCbet(movimientoServiceStars9Max.getfoldCbet(asiento.getP9_nombre()));
			    			hud.setP9(jugador9);
			    			hud.setNombre_mesa(asiento.getNombre_mesa());
			    			return hud;
		    			}
		    			else if(line2.indexOf("9-max")!=-1&& line.indexOf("Tournament" )!=-1){
		    				
			    			System.out.println("pokerstars---------------------------------------------"+newfile.getAbsolutePath());
			    			movimientoServiceStars9MaxTournament.leerFichero(newfile.getAbsolutePath(),username);
			    			AsientoStars asiento =asientoServiceStars.getAsientosUltimaMano(username);
			    			Hud hud = new Hud();
			    			Jugador jugador1= new Jugador();
			    			jugador1.setNombre(asiento.getP1_nombre());
			    			
			    			jugador1.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP1_nombre()));
			    			jugador1.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP1_nombre()));
			    			jugador1.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP1_nombre()));
			    			jugador1.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP1_nombre()));
			    			jugador1.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP1_nombre()));
			    			jugador1.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP1_nombre()));
			    			jugador1.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP1_nombre()));
			    			jugador1.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP1_nombre()));
			    			jugador1.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP1_nombre()));
			    			hud.setP1(jugador1);		
			    			
			    			Jugador jugador2= new Jugador();
			    			jugador2.setNombre(asiento.getP2_nombre());
			    			jugador2.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP2_nombre()));
			    			jugador2.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP2_nombre()));
			    			jugador2.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP2_nombre()));
			    			jugador2.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP2_nombre()));
			    			jugador2.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP2_nombre()));
			    			jugador2.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP2_nombre()));
			    			jugador2.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP2_nombre()));
			    			jugador2.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP2_nombre()));
			    			jugador2.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP2_nombre()));
			    			jugador2.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP2_nombre()));
			    			jugador2.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP2_nombre()));
			    			hud.setP2(jugador2);
			    			
			    			Jugador jugador3= new Jugador();
			    			jugador3.setNombre(asiento.getP3_nombre());
			    			jugador3.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP3_nombre()));
			    			jugador3.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP3_nombre()));
			    			jugador3.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP3_nombre()));
			    			jugador3.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP3_nombre()));
			    			jugador3.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP3_nombre()));
			    			jugador3.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP3_nombre()));
			    			jugador3.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP3_nombre()));
			    			jugador3.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP3_nombre()));
			    			jugador3.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP3_nombre()));
			    			jugador3.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP3_nombre()));
			    			jugador3.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP3_nombre()));
			    			hud.setP3(jugador3);
			    			
			    			Jugador jugador4= new Jugador();
			    			jugador4.setNombre(asiento.getP4_nombre());
			    			jugador4.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP4_nombre()));
			    			jugador4.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP4_nombre()));
			    			jugador4.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP4_nombre()));
			    			jugador4.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP4_nombre()));
			    			jugador4.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP4_nombre()));
			    			jugador4.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP4_nombre()));
			    			jugador4.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP4_nombre()));
			    			jugador4.setManos( movimientoServiceWina.getManos(asiento.getP4_nombre()));
			    			jugador4.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP4_nombre()));
			    			jugador4.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP4_nombre()));
			    			jugador4.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP4_nombre()));
			    			hud.setP4(jugador4);
			    			
			    			Jugador jugador5= new Jugador();
			    			jugador5.setNombre(asiento.getP5_nombre());
			    			jugador5.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP5_nombre()));
			    			jugador5.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP5_nombre()));
			    			jugador5.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP5_nombre()));
			    			jugador5.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP5_nombre()));
			    			jugador5.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP5_nombre()));
			    			jugador5.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP5_nombre()));
			    			jugador5.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP5_nombre()));
			    			jugador5.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP5_nombre()));
			    			jugador5.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP5_nombre()));
			    			jugador5.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP5_nombre()));
			    			jugador5.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP5_nombre()));
			    			hud.setP5(jugador5);
			    			
			    			Jugador jugador6= new Jugador();
			    			jugador6.setNombre(asiento.getP6_nombre());
			    			jugador6.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP6_nombre()));
			    			jugador6.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP6_nombre()));
			    			jugador6.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP6_nombre()));
			    			jugador6.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP6_nombre()));
			    			jugador6.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP6_nombre()));
			    			jugador6.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP6_nombre()));
			    			jugador6.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP6_nombre()));
			    			jugador6.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP6_nombre()));
			    			jugador6.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP6_nombre()));
			    			jugador6.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP6_nombre()));
			    			jugador6.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP6_nombre()));
			    			hud.setP6(jugador6);
			    			
			    			
			    			Jugador jugador7= new Jugador();
			    			jugador7.setNombre(asiento.getP7_nombre());
			    			jugador7.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP7_nombre()));
			    			jugador7.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP7_nombre()));
			    			jugador7.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP7_nombre()));
			    			jugador7.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP7_nombre()));
			    			jugador7.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP7_nombre()));
			    			jugador7.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP7_nombre()));
			    			jugador7.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP7_nombre()));
			    			jugador7.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP7_nombre()));
			    			jugador7.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP7_nombre()));
			    			jugador7.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP7_nombre()));
			    			jugador7.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP7_nombre()));
			    			hud.setP7(jugador7);
			    			
			    			
			    			
			    			
			    			Jugador jugador8= new Jugador();
			    			jugador8.setNombre(asiento.getP8_nombre());
			    			jugador8.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP8_nombre()));
			    			jugador8.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP8_nombre()));
			    			jugador8.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP8_nombre()));
			    			jugador8.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP8_nombre()));
			    			jugador8.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP8_nombre()));
			    			jugador8.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP8_nombre()));
			    			jugador8.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP8_nombre()));
			    			jugador8.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP8_nombre()));
			    			jugador8.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP8_nombre()));
			    			jugador8.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP8_nombre()));
			    			jugador8.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP8_nombre()));
			    			hud.setP8(jugador8);
			    			
			    			
			    			Jugador jugador9= new Jugador();
			    			jugador9.setNombre(asiento.getP9_nombre());
			    			jugador9.setCbet(movimientoServiceStars9MaxTournament.getCbet(asiento.getP9_nombre()));
			    			jugador9.setVpip(movimientoServiceStars9MaxTournament.vpip(asiento.getP9_nombre()));
			    			jugador9.setMediaCantFlop(movimientoServiceStars9MaxTournament.getMediaCantFlop(asiento.getP9_nombre()));
			    			jugador9.setMediaCantTurn(movimientoServiceStars9MaxTournament.getMediaCantTurn(asiento.getP9_nombre()));
			    			jugador9.setMediaCantRiver(movimientoServiceStars9MaxTournament.getMediaCantRiver(asiento.getP9_nombre()));
			    			jugador9.setPfr(movimientoServiceStars9MaxTournament.getPfr(asiento.getP9_nombre()));
			    			jugador9.setBet3(movimientoServiceStars9MaxTournament.get3Bet(asiento.getP9_nombre()));
			    			jugador9.setManos( movimientoServiceStars9MaxTournament.getManos(asiento.getP9_nombre()));
			    			jugador9.setCbetCall(movimientoServiceStars9MaxTournament.getCbetCall(asiento.getP9_nombre()));
			    			jugador9.setCbetCallTurn(movimientoServiceStars9MaxTournament.getCbetCallTurn(asiento.getP9_nombre()));
			    			jugador9.setFoldCbet(movimientoServiceStars9MaxTournament.getfoldCbet(asiento.getP9_nombre()));
			    			
			    			hud.setP9(jugador9);
			    			hud.setNombre_mesa(asiento.getNombre_mesa());			    			
			    			
			    			return hud;
			    		}else if(line2.indexOf("6-max")!=-1&& line.indexOf("Tournament" )==-1&& line.indexOf("Zoom")==-1) {
			    			
			    			movimientoServiceStars.leerFichero(newfile.getAbsolutePath(),username);
			    			AsientoStars asiento =asientoServiceStars.getAsientosUltimaMano(username);
			    			
		    				Hud hud = new Hud();
		    				if(asiento.getP1_nombre()!=null) {
			    			Jugador jugador1= new Jugador();
			    			jugador1.setNombre(asiento.getP1_nombre());			    			
			    			jugador1.setCbet(movimientoServiceStars.getCbet(asiento.getP1_nombre()));
			    			jugador1.setVpip(movimientoServiceStars.vpip(asiento.getP1_nombre()));
			    			jugador1.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP1_nombre()));
			    			jugador1.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP1_nombre()));
			    			jugador1.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP1_nombre()));
			    			jugador1.setPfr(movimientoServiceStars.getPfr(asiento.getP1_nombre()));
			    			jugador1.setBet3(movimientoServiceStars.get3Bet(asiento.getP1_nombre()));
			    			jugador1.setManos( movimientoServiceStars.getManos(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars.getCbetCallTurn(asiento.getP1_nombre()));
			    			jugador1.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP1_nombre()));
			    			hud.setP1(jugador1);		
		    				}
		    				if(asiento.getP2_nombre()!=null) {
			    			Jugador jugador2= new Jugador();
			    			jugador2.setNombre(asiento.getP2_nombre());
			    			jugador2.setCbet(movimientoServiceStars.getCbet(asiento.getP2_nombre()));
			    			jugador2.setVpip(movimientoServiceStars.vpip(asiento.getP2_nombre()));
			    			jugador2.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP2_nombre()));
			    			jugador2.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP2_nombre()));
			    			jugador2.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP2_nombre()));
			    			jugador2.setPfr(movimientoServiceStars.getPfr(asiento.getP2_nombre()));
			    			jugador2.setBet3(movimientoServiceStars.get3Bet(asiento.getP2_nombre()));
			    			jugador2.setManos( movimientoServiceStars.getManos(asiento.getP2_nombre()));
			    			jugador2.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP2_nombre()));
			    			jugador2.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP2_nombre()));
			    			jugador2.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP2_nombre()));
			    			hud.setP2(jugador2);
		    				}
		    				if(asiento.getP3_nombre()!=null) {
			    			Jugador jugador3= new Jugador();
			    			jugador3.setNombre(asiento.getP3_nombre());
			    			jugador3.setCbet(movimientoServiceStars.getCbet(asiento.getP3_nombre()));
			    			jugador3.setVpip(movimientoServiceStars.vpip(asiento.getP3_nombre()));
			    			jugador3.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP3_nombre()));
			    			jugador3.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP3_nombre()));
			    			jugador3.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP3_nombre()));
			    			jugador3.setPfr(movimientoServiceStars.getPfr(asiento.getP3_nombre()));
			    			jugador3.setBet3(movimientoServiceStars.get3Bet(asiento.getP3_nombre()));
			    			jugador3.setManos( movimientoServiceStars.getManos(asiento.getP3_nombre()));
			    			jugador3.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP3_nombre()));
			    			jugador3.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP3_nombre()));
			    			jugador3.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP3_nombre()));
			    			hud.setP3(jugador3);
		    				}
			    			Jugador jugador4= new Jugador();
			    			jugador4.setNombre(asiento.getP4_nombre());
			    			jugador4.setCbet(movimientoServiceStars.getCbet(asiento.getP4_nombre()));
			    			jugador4.setVpip(movimientoServiceStars.vpip(asiento.getP4_nombre()));
			    			jugador4.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP4_nombre()));
			    			jugador4.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP4_nombre()));
			    			jugador4.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP4_nombre()));
			    			jugador4.setPfr(movimientoServiceStars.getPfr(asiento.getP4_nombre()));
			    			jugador4.setBet3(movimientoServiceStars.get3Bet(asiento.getP4_nombre()));
			    			jugador4.setManos( movimientoServiceWina.getManos(asiento.getP4_nombre()));
			    			jugador4.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP4_nombre()));
			    			jugador4.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP4_nombre()));
			    			jugador4.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP4_nombre()));
			    			hud.setP4(jugador4);
			    			if(asiento.getP5_nombre()!=null) {
			    			Jugador jugador5= new Jugador();
			    			jugador5.setNombre(asiento.getP5_nombre());
			    			jugador5.setCbet(movimientoServiceStars.getCbet(asiento.getP5_nombre()));
			    			jugador5.setVpip(movimientoServiceStars.vpip(asiento.getP5_nombre()));
			    			jugador5.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP5_nombre()));
			    			jugador5.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP5_nombre()));
			    			jugador5.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP5_nombre()));
			    			jugador5.setPfr(movimientoServiceStars.getPfr(asiento.getP5_nombre()));
			    			jugador5.setBet3(movimientoServiceStars.get3Bet(asiento.getP5_nombre()));
			    			jugador5.setManos( movimientoServiceStars.getManos(asiento.getP5_nombre()));
			    			jugador5.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP5_nombre()));
			    			jugador5.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP5_nombre()));
			    			jugador5.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP5_nombre()));
			    			hud.setP5(jugador5);
			    			}
			    			if(asiento.getP1_nombre()!=null) {
			    			Jugador jugador6= new Jugador();
			    			jugador6.setNombre(asiento.getP6_nombre());
			    			jugador6.setCbet(movimientoServiceStars.getCbet(asiento.getP6_nombre()));
			    			jugador6.setVpip(movimientoServiceStars.vpip(asiento.getP6_nombre()));
			    			jugador6.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP6_nombre()));
			    			jugador6.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP6_nombre()));
			    			jugador6.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP6_nombre()));
			    			jugador6.setPfr(movimientoServiceStars.getPfr(asiento.getP6_nombre()));
			    			jugador6.setBet3(movimientoServiceStars.get3Bet(asiento.getP6_nombre()));
			    			jugador6.setManos( movimientoServiceStars.getManos(asiento.getP6_nombre()));
			    			jugador6.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP6_nombre()));
			    			jugador6.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP6_nombre()));
			    			jugador6.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP6_nombre()));
			    			hud.setP6(jugador6);
			    			}
			    			hud.setP7(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setP8(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setP9(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			

			    			hud.setNombre_mesa(asiento.getNombre_mesa());
			    			return hud;
			    		}else if(line2.indexOf("6-max")!=-1&& line.indexOf("Tournament" )==-1&&line.indexOf("Zoom")!=-1) {
			    			
			    			movimientoServiceStars.leerFicheroZoom(newfile.getAbsolutePath(),username);
			    			AsientoStars asiento =asientoServiceStars.getAsientosUltimaMano(username);
			    			
		    				Hud hud = new Hud();
			    			Jugador jugador1= new Jugador();
			    			jugador1.setNombre(asiento.getP1_nombre());			    			
			    			jugador1.setCbet(movimientoServiceStars.getCbet(asiento.getP1_nombre()));
			    			jugador1.setVpip(movimientoServiceStars.vpip(asiento.getP1_nombre()));
			    			jugador1.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP1_nombre()));
			    			jugador1.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP1_nombre()));
			    			jugador1.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP1_nombre()));
			    			jugador1.setPfr(movimientoServiceStars.getPfr(asiento.getP1_nombre()));
			    			jugador1.setBet3(movimientoServiceStars.get3Bet(asiento.getP1_nombre()));
			    			jugador1.setManos( movimientoServiceStars.getManos(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceStars.getCbetCallTurn(asiento.getP1_nombre()));
			    			jugador1.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP1_nombre()));
			    			hud.setP1(jugador1);		
			    			
			    			Jugador jugador2= new Jugador();
			    			jugador2.setNombre(asiento.getP2_nombre());
			    			jugador2.setCbet(movimientoServiceStars.getCbet(asiento.getP2_nombre()));
			    			jugador2.setVpip(movimientoServiceStars.vpip(asiento.getP2_nombre()));
			    			jugador2.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP2_nombre()));
			    			jugador2.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP2_nombre()));
			    			jugador2.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP2_nombre()));
			    			jugador2.setPfr(movimientoServiceStars.getPfr(asiento.getP2_nombre()));
			    			jugador2.setBet3(movimientoServiceStars.get3Bet(asiento.getP2_nombre()));
			    			jugador2.setManos( movimientoServiceStars.getManos(asiento.getP2_nombre()));
			    			jugador2.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP2_nombre()));
			    			jugador2.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP2_nombre()));
			    			jugador2.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP2_nombre()));
			    			hud.setP2(jugador2);
			    			
			    			
			    			Jugador jugador3= new Jugador();
			    			jugador3.setNombre(asiento.getP3_nombre());
			    			jugador3.setCbet(movimientoServiceStars.getCbet(asiento.getP3_nombre()));
			    			jugador3.setVpip(movimientoServiceStars.vpip(asiento.getP3_nombre()));
			    			jugador3.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP3_nombre()));
			    			jugador3.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP3_nombre()));
			    			jugador3.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP3_nombre()));
			    			jugador3.setPfr(movimientoServiceStars.getPfr(asiento.getP3_nombre()));
			    			jugador3.setBet3(movimientoServiceStars.get3Bet(asiento.getP3_nombre()));
			    			jugador3.setManos( movimientoServiceStars.getManos(asiento.getP3_nombre()));
			    			jugador3.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP3_nombre()));
			    			jugador3.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP3_nombre()));
			    			jugador3.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP3_nombre()));
			    			hud.setP3(jugador3);

			    			Jugador jugador4= new Jugador();
			    			jugador4.setNombre(asiento.getP4_nombre());
			    			jugador4.setCbet(movimientoServiceStars.getCbet(asiento.getP4_nombre()));
			    			jugador4.setVpip(movimientoServiceStars.vpip(asiento.getP4_nombre()));
			    			jugador4.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP4_nombre()));
			    			jugador4.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP4_nombre()));
			    			jugador4.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP4_nombre()));
			    			jugador4.setPfr(movimientoServiceStars.getPfr(asiento.getP4_nombre()));
			    			jugador4.setBet3(movimientoServiceStars.get3Bet(asiento.getP4_nombre()));
			    			jugador4.setManos( movimientoServiceWina.getManos(asiento.getP4_nombre()));
			    			jugador4.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP4_nombre()));
			    			jugador4.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP4_nombre()));
			    			jugador4.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP4_nombre()));
			    			hud.setP4(jugador4);
			    			
			    			Jugador jugador5= new Jugador();
			    			jugador5.setNombre(asiento.getP5_nombre());
			    			jugador5.setCbet(movimientoServiceStars.getCbet(asiento.getP5_nombre()));
			    			jugador5.setVpip(movimientoServiceStars.vpip(asiento.getP5_nombre()));
			    			jugador5.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP5_nombre()));
			    			jugador5.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP5_nombre()));
			    			jugador5.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP5_nombre()));
			    			jugador5.setPfr(movimientoServiceStars.getPfr(asiento.getP5_nombre()));
			    			jugador5.setBet3(movimientoServiceStars.get3Bet(asiento.getP5_nombre()));
			    			jugador5.setManos( movimientoServiceStars.getManos(asiento.getP5_nombre()));
			    			jugador5.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP5_nombre()));
			    			jugador5.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP5_nombre()));
			    			jugador5.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP5_nombre()));
			    			hud.setP5(jugador5);
			    			
			    			Jugador jugador6= new Jugador();
			    			jugador6.setNombre(asiento.getP6_nombre());
			    			jugador6.setCbet(movimientoServiceStars.getCbet(asiento.getP6_nombre()));
			    			jugador6.setVpip(movimientoServiceStars.vpip(asiento.getP6_nombre()));
			    			jugador6.setMediaCantFlop(movimientoServiceStars.getMediaCantFlop(asiento.getP6_nombre()));
			    			jugador6.setMediaCantTurn(movimientoServiceStars.getMediaCantTurn(asiento.getP6_nombre()));
			    			jugador6.setMediaCantRiver(movimientoServiceStars.getMediaCantRiver(asiento.getP6_nombre()));
			    			jugador6.setPfr(movimientoServiceStars.getPfr(asiento.getP6_nombre()));
			    			jugador6.setBet3(movimientoServiceStars.get3Bet(asiento.getP6_nombre()));
			    			jugador6.setManos( movimientoServiceStars.getManos(asiento.getP6_nombre()));
			    			jugador6.setCbetCall(movimientoServiceStars.getCbetCall(asiento.getP6_nombre()));
			    			jugador6.setCbetCallTurn(movimientoServiceStars.getCbetCallTurn(asiento.getP6_nombre()));
			    			jugador6.setFoldCbet(movimientoServiceStars.getfoldCbet(asiento.getP6_nombre()));
			    			hud.setP6(jugador6);
			    			hud.setP7(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setP8(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setP9(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			

			    			hud.setNombre_mesa(asiento.getNombre_mesa());
			    			return hud;
			    		}
			    		
		    			
		    		
		    		}else if (line.indexOf("Winamax Poker")!=-1){
			    			
			    			
			    			System.out.println("wina---------------------------------------------"+newfile.getAbsolutePath());
			    			movimientoServiceWina.leerFichero(newfile.getAbsolutePath(),username);
			    			AsientoWina asiento =asientoServiceWina.getAsientosUltimaMano(username);
			    			Hud hud = new Hud();
			    			Jugador jugador1= new Jugador();
			    			jugador1.setNombre(asiento.getP1_nombre());
			    			jugador1.setCbet(movimientoServiceWina.getCbet(asiento.getP1_nombre()));
			    			jugador1.setVpip(movimientoServiceWina.vpip(asiento.getP1_nombre()));
			    			jugador1.setMediaCantFlop(movimientoServiceWina.getMediaCantFlop(asiento.getP1_nombre()));
			    			jugador1.setMediaCantTurn(movimientoServiceWina.getMediaCantTurn(asiento.getP1_nombre()));
			    			jugador1.setMediaCantRiver(movimientoServiceWina.getMediaCantRiver(asiento.getP1_nombre()));
			    			jugador1.setPfr(movimientoServiceWina.getPfr(asiento.getP1_nombre()));
			    			jugador1.setBet3(movimientoServiceWina.get3Bet(asiento.getP1_nombre()));
			    			jugador1.setManos( movimientoServiceWina.getManos(asiento.getP1_nombre()));
			    			jugador1.setCbetCall(movimientoServiceWina.getCbetCall(asiento.getP1_nombre()));
			    			jugador1.setCbetCallTurn(movimientoServiceWina.getCbetCallTurn(asiento.getP1_nombre()));
			    			jugador1.setFoldCbet(movimientoServiceWina.getfoldCbet(asiento.getP1_nombre()));
			    			hud.setP1(jugador1);		
			    			
			    			Jugador jugador2= new Jugador();
			    			jugador2.setNombre(asiento.getP2_nombre());
			    			jugador2.setCbet(movimientoServiceWina.getCbet(asiento.getP2_nombre()));
			    			jugador2.setVpip(movimientoServiceWina.vpip(asiento.getP2_nombre()));
			    			jugador2.setMediaCantFlop(movimientoServiceWina.getMediaCantFlop(asiento.getP2_nombre()));
			    			jugador2.setMediaCantTurn(movimientoServiceWina.getMediaCantTurn(asiento.getP2_nombre()));
			    			jugador2.setMediaCantRiver(movimientoServiceWina.getMediaCantRiver(asiento.getP2_nombre()));
			    			jugador2.setPfr(movimientoServiceWina.getPfr(asiento.getP2_nombre()));
			    			jugador2.setBet3(movimientoServiceWina.get3Bet(asiento.getP2_nombre()));
			    			jugador2.setManos( movimientoServiceWina.getManos(asiento.getP2_nombre()));
			    			jugador2.setCbetCall(movimientoServiceWina.getCbetCall(asiento.getP2_nombre()));
			    			jugador2.setCbetCallTurn(movimientoServiceWina.getCbetCallTurn(asiento.getP2_nombre()));
			    			jugador2.setFoldCbet(movimientoServiceWina.getfoldCbet(asiento.getP2_nombre()));
			    			hud.setP2(jugador2);
			    			
			    			Jugador jugador3= new Jugador();
			    			jugador3.setNombre(asiento.getP3_nombre());
			    			jugador3.setCbet(movimientoServiceWina.getCbet(asiento.getP3_nombre()));
			    			jugador3.setVpip(movimientoServiceWina.vpip(asiento.getP3_nombre()));
			    			jugador3.setMediaCantFlop(movimientoServiceWina.getMediaCantFlop(asiento.getP3_nombre()));
			    			jugador3.setMediaCantTurn(movimientoServiceWina.getMediaCantTurn(asiento.getP3_nombre()));
			    			jugador3.setMediaCantRiver(movimientoServiceWina.getMediaCantRiver(asiento.getP3_nombre()));
			    			jugador3.setPfr(movimientoServiceWina.getPfr(asiento.getP3_nombre()));
			    			jugador3.setBet3(movimientoServiceWina.get3Bet(asiento.getP3_nombre()));
			    			jugador3.setManos( movimientoServiceWina.getManos(asiento.getP3_nombre()));
			    			jugador3.setCbetCall(movimientoServiceWina.getCbetCall(asiento.getP3_nombre()));
			    			jugador3.setCbetCallTurn(movimientoServiceWina.getCbetCallTurn(asiento.getP3_nombre()));
			    			jugador3.setFoldCbet(movimientoServiceWina.getfoldCbet(asiento.getP3_nombre()));
			    			hud.setP3(jugador3);
			    			
			    			Jugador jugador4= new Jugador();
			    			jugador4.setNombre(asiento.getP4_nombre());
			    			jugador4.setCbet(movimientoServiceWina.getCbet(asiento.getP4_nombre()));
			    			jugador4.setVpip(movimientoServiceWina.vpip(asiento.getP4_nombre()));
			    			jugador4.setMediaCantFlop(movimientoServiceWina.getMediaCantFlop(asiento.getP4_nombre()));
			    			jugador4.setMediaCantTurn(movimientoServiceWina.getMediaCantTurn(asiento.getP4_nombre()));
			    			jugador4.setMediaCantRiver(movimientoServiceWina.getMediaCantRiver(asiento.getP4_nombre()));
			    			jugador4.setPfr(movimientoServiceWina.getPfr(asiento.getP4_nombre()));
			    			jugador4.setBet3(movimientoServiceWina.get3Bet(asiento.getP4_nombre()));
			    			jugador4.setManos( movimientoServiceWina.getManos(asiento.getP4_nombre()));
			    			jugador4.setCbetCall(movimientoServiceWina.getCbetCall(asiento.getP4_nombre()));
			    			jugador4.setCbetCallTurn(movimientoServiceWina.getCbetCallTurn(asiento.getP4_nombre()));
			    			jugador4.setFoldCbet(movimientoServiceWina.getfoldCbet(asiento.getP4_nombre()));
			    			hud.setP4(jugador4);
			    			
			    			Jugador jugador5= new Jugador();
			    			jugador5.setNombre(asiento.getP5_nombre());
			    			jugador5.setCbet(movimientoServiceWina.getCbet(asiento.getP5_nombre()));
			    			jugador5.setVpip(movimientoServiceWina.vpip(asiento.getP5_nombre()));
			    			jugador5.setMediaCantFlop(movimientoServiceWina.getMediaCantFlop(asiento.getP5_nombre()));
			    			jugador5.setMediaCantTurn(movimientoServiceWina.getMediaCantTurn(asiento.getP5_nombre()));
			    			jugador5.setMediaCantRiver(movimientoServiceWina.getMediaCantRiver(asiento.getP5_nombre()));
			    			jugador5.setPfr(movimientoServiceWina.getPfr(asiento.getP5_nombre()));
			    			jugador5.setBet3(movimientoServiceWina.get3Bet(asiento.getP5_nombre()));
			    			jugador5.setManos( movimientoServiceWina.getManos(asiento.getP5_nombre()));
			    			jugador5.setCbetCall(movimientoServiceWina.getCbetCall(asiento.getP5_nombre()));
			    			jugador5.setCbetCallTurn(movimientoServiceWina.getCbetCallTurn(asiento.getP5_nombre()));
			    			jugador5.setFoldCbet(movimientoServiceWina.getfoldCbet(asiento.getP5_nombre()));
			    			hud.setP5(jugador5);
			    			
			    			hud.setP6(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setP7(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setP8(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setP9(new Jugador("", 0.0, 0.0, 0.0, 0.0, 0.0,
			    					0.0, 0.0, 0.0,0.0, 0.0, 0.0));
			    			hud.setNombre_mesa(asiento.getNombre_mesa());
			    			return hud;
			    		}
		    		}
		    		
		    		
		    			
		    	
		    	 System.out.println(newfile.getAbsolutePath());
		    	}
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				File filelogreader = new File("C:/Users/Administrator/AppData/Local/Ficheros/starscontroler.log");
				PrintStream psreader;
				psreader = new PrintStream(filelogreader);
				e.printStackTrace(psreader);
				psreader.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
        System.out.println(file.getName());
       
		}
		return null;
   
	
	
	    
	}
	
		}
