package com.poker.jwtauthentication.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poker.jwtauthentication.Utilidades.Utils;
import com.poker.jwtauthentication.model.AsientoStars;
import com.poker.jwtauthentication.model.FechaStars;
import com.poker.jwtauthentication.model.MovimientoStars;
import com.poker.jwtauthentication.model.MovimientoStars9Max;
import com.poker.jwtauthentication.model.ResumenStars;
import com.poker.jwtauthentication.repository.AsientosRepositoryStars;
import com.poker.jwtauthentication.repository.FechaRepositoryStars;
import com.poker.jwtauthentication.repository.Movimiento9maxRepository;
import com.poker.jwtauthentication.repository.ResumenRepositoryStars;

public interface IMovimientoStars9max  {
	public double  vpip(String nombre_jugador);

	double getCbetCallTurn(String nombre_jugador);

	double getfoldCbet(String nombre_jugador);

	public double  getMediaCantFlop(String nombre_jugador);

	public double  getMediaCantTurn(String nombre_jugador);

	public double  getMediaCantRiver(String nombre_jugador);

	public double  getPfr(String nombre_jugador);

	public void save(MovimientoStars9Max movimiento);

	public double  get3Bet(String nombre_jugador);

	public double  getCbet(String nombre_jugador);

	public void leerFichero(String fichero,String randomString);

	public double  getManos(String nombre_jugador);
	
	public double  getCbetCall(String nombre_jugador);
	
@Service	
	public class Movimiento9maxClass implements IMovimientoStars9max {
	@Autowired
	Movimiento9maxRepository movimiento9maxRepository;
	@Autowired
	FechaRepositoryStars fechaRepository;
	@Autowired
	AsientosRepositoryStars asientosRepository;
	@Autowired
	ResumenRepositoryStars resumenRepository;
	
	@Override
	public void save(MovimientoStars9Max movimiento) {
		// TODO Auto-generated method stub
		movimiento9maxRepository.save(movimiento);
	}

	@Override

	public double  vpip(String nombre_jugador) {
		
		try {
			double resultado = 0;
			double vpip = movimiento9maxRepository.getVpip(nombre_jugador);
			double vpipTotal = movimiento9maxRepository.getVpipTotal(nombre_jugador);
			resultado = (vpip / vpipTotal) * 100;
			return Utils.round(resultado, 0);
		} catch (Exception e) {
			return 0;
		}
		// movimiento9maxRepository.vpip(nombre_jugador);
	}

	@Override

	public double  getMediaCantFlop(String nombre_jugador) {
		// TODO Auto-generated method stub
		try {
			Double resultado = movimiento9maxRepository.getMediaCantFlop(nombre_jugador);
			return Utils.round(resultado, 0);
		} catch (Exception e) {
			return 0;

		}
	}

	@Override

	public double  getMediaCantTurn(String nombre_jugador) {
		// TODO Auto-generated method stub
		try {
			return Utils.round(movimiento9maxRepository.getMediaCantTurn(nombre_jugador), 0);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public double getMediaCantRiver(String nombre_jugador) {
		try {
			return Utils.round(movimiento9maxRepository.getMediaCantRiver(nombre_jugador), 0);
		} catch (Exception e) {
			return 0;
		} // TODO Auto-generated method stub

	}

	@Override
	public double  getPfr(String nombre_jugador) {
		// TODO Auto-generated method stub
		double resultado = 0;
		try {
			double pfr = movimiento9maxRepository.getPfr(nombre_jugador);
			double pfrTotal = movimiento9maxRepository.getPfrTotal(nombre_jugador);

			resultado = (pfr / pfrTotal) * 100;
			return Utils.round(resultado, 0);
		} catch (Exception e) {
			return 0;
		}

	}
	
	@Override
	public double  get3Bet(String nombre_jugador) {
		// TODO Auto-generated method stub

		try {
			
			return Utils.round(movimiento9maxRepository.get3Bet(nombre_jugador),0);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public double  getManos(String nombre_jugador) {
		// TODO Auto-generated method stub
		try {

			return Utils.round(movimiento9maxRepository.getManos(nombre_jugador), 0);
		} catch (Exception e) {
			return 0;
		}

	}
	
	@Override
	public double  getCbet(String nombre_jugador) {
		// TODO Auto-generated method stub
		try {
			
			

			return Utils.round(movimiento9maxRepository.getCbet(nombre_jugador), 0);
		} catch (Exception e) {
			
			return 0;
		}
	}
	@Override
	public double  getCbetCall(String nombre_jugador) {
		// TODO Auto-generated method stub
		try {
			
			

			return Utils.round(movimiento9maxRepository.getCbetCall(nombre_jugador), 0);
		} catch (Exception e) {
		
			return 0;
		}
	}
	@Override
	public double  getCbetCallTurn(String nombre_jugador) {
		// TODO Auto-generated method stub
		try {
			
			

			return Utils.round(movimiento9maxRepository.getCbetCallTurn(nombre_jugador), 0);
		} catch (Exception e) {
			
			return 0;
		}
	}
	@Override
	public double  getfoldCbet(String nombre_jugador) {
		// TODO Auto-generated method stub
		try {
			
			

			return Utils.round(movimiento9maxRepository.getfoldCbet(nombre_jugador), 0);
		} catch (Exception e) {
			
			return 0;
		}
	}
	
	String p1Nombre = "";
	String p2Nombre = "";
	String p3Nombre = "";
	String p4Nombre = "";
	String p5Nombre = "";
	String p6Nombre = "";
	String p7Nombre = "";
	String p8Nombre = "";
	String p9Nombre = "";
	
	
	Double p1Stack;
	Double p2Stack;
	Double p3Stack;
	Double p4Stack;
	Double p5Stack;
	Double p6Stack;
	Double p7Stack;
	Double p8Stack;
	Double p9Stack;
	
	BufferedReader reader;
	@Transactional
	public void leerFichero(String fichero,String randomString) {
	try {
		
		String idMano = "";
		
		String fecha = "";
		String mesa="";
		int posicion = 0;
		String line = "";
		int linea = 0;
		int ronda = 0;
		Double pot = 0.0;
		String tipo;
		Double cant = 0.0;
		char cha = 0;
		String jugador = "";

		File file = new File(fichero);
		FileInputStream fis = new FileInputStream(fichero);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();

		String str = new String(data, "windows-1252");
		if (str.indexOf("Incognito") == -1 && str.indexOf("Tournament")==-1) {
			reader = new BufferedReader(new FileReader(fichero));

			while (line != null) {

				while (line.indexOf("PokerStars") == -1) {

					line = reader.readLine();
					System.out.println("-----" + line);

				}
				System.out.println("ÇÇ" + line);
				try {
					System.out.println(idMano+"-------------------------------");
				idMano = Utils.primerosnum(line);
				
				
				System.out.println(fecha+"-------------------------------");
				fecha = Utils.ultimosnumfecha(line);
				line = reader.readLine();
				mesa= line.substring(line.indexOf("'")+1,line.lastIndexOf("'"));
				}catch(Exception e) {
					File filelog2 = new File("C:/Users/Administrator/AppData/Local/Ficheros/startsprincipio.log");
					PrintStream ps2;
					ps2 = new PrintStream(filelog2);
					e.printStackTrace(ps2);
					ps2.close();
				}
				while (line.indexOf("*** HOLE CARDS ***") == -1) {
					System.out.println("*");
try {
					if (line.indexOf("Seat 1:") != -1) {
						p1Nombre =Utils.nombreJugadorPrincipio(line);
						p1Stack = Double.parseDouble(Utils.ultimosnum(line));
										
					} else if (line.indexOf("Seat 2:") != -1) {
						p2Nombre = Utils.nombreJugadorPrincipio(line);
						p2Stack =Double.parseDouble( Utils.ultimosnum(line));
					} else if (line.indexOf("Seat 3:") != -1) {
						p3Nombre = Utils.nombreJugadorPrincipio(line);
						p3Stack =Double.parseDouble(Utils.ultimosnum(line));
					} else if (line.indexOf("Seat 4:") != -1) {
						p4Nombre = Utils.nombreJugadorPrincipio(line);
						p4Stack = Double.parseDouble(Utils.ultimosnum(line));
					} else if (line.indexOf("Seat 5:") != -1) {
						p5Nombre = Utils.nombreJugadorPrincipio(line);
						p5Stack = Double.parseDouble(Utils.ultimosnum(line));
					}else if (line.indexOf("Seat 6:") != -1) {
						p6Nombre = Utils.nombreJugadorPrincipio(line);
						p6Stack =Double.parseDouble(Utils.ultimosnum(line));
					}else if (line.indexOf("Seat 7:") != -1) {
						p7Nombre = Utils.nombreJugadorPrincipio(line);
						p7Stack =Double.parseDouble(Utils.ultimosnum(line));
					}else if (line.indexOf("Seat 8:") != -1) {
						p8Nombre = Utils.nombreJugadorPrincipio(line);
						p8Stack =Double.parseDouble(Utils.ultimosnum(line));
					}else if (line.indexOf("Seat 9:") != -1) {
						p9Nombre = Utils.nombreJugadorPrincipio(line);
						p9Stack =Double.parseDouble(Utils.ultimosnum(line));
					}
}catch(Exception e) {
File filelog2 = new File("C:/Users/Administrator/AppData/Local/Ficheros/startsnombrestars.log");
PrintStream ps2;
ps2 = new PrintStream(filelog2);
e.printStackTrace(ps2);
ps2.close();
}
					
					if (line.indexOf("small blind") != -1) {
						System.out.println("smalblind");
						ronda = 0;
						jugador = Utils.nombreJugador(line);
						linea = linea + 1;
						cant = Double.parseDouble(Utils.ultimosnum(line));

						MovimientoStars9Max movimiento = new MovimientoStars9Max();
						movimiento.setId_mano(idMano);
						movimiento.setLinea(linea);
						movimiento.setNombre_jugador(jugador);
						movimiento.setPosicion(asiento(jugador));
						movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
						movimiento.setRonda(ronda);
						movimiento.setPot(pot);
						movimiento.setCant(Utils.round(cant, 2));
						movimiento.setTipo("small blind");
						System.out.println("save........idmano:" + idMano + " linea:" + linea + " jugador:"
								+ jugador + " assiento:" + asiento(jugador) + " stackresta:"
								+ stacksresta(jugador, cant) + " ronda:" + ronda + " pot:" + pot + " cant:"
								+ cant);
						movimiento9maxRepository.save(movimiento);

						pot = pot + cant;
					} else if (line.indexOf("big blind") != -1) {
						ronda = 0;
						jugador = Utils.nombreJugador(line);
						linea = linea + 1;
						cant = Double.parseDouble(Utils.ultimosnum(line));

						posicion = asiento(jugador);
						MovimientoStars9Max movimiento = new MovimientoStars9Max();
						movimiento.setId_mano(idMano);
						movimiento.setLinea(linea);
						movimiento.setNombre_jugador(jugador);
						movimiento.setPosicion(asiento(jugador));
						movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
						movimiento.setRonda(ronda);
						movimiento.setPot(pot);
						movimiento.setCant(Utils.round(cant, 2));
						movimiento.setTipo("big blind");
						movimiento9maxRepository.save(movimiento);
						pot = pot + cant;
					} 
					line = reader.readLine();
				}
				

				while (line.indexOf("*** SUMMARY ***") == -1) {
					System.out.println("sumary" + line);
					 if (line.indexOf("raises") != -1) {
						 jugador = Utils.nombreJugador(line);
						linea = linea + 1;

						cant = Double.parseDouble(Utils.ultimosnum(line));

						posicion = asiento(jugador);
						MovimientoStars9Max movimiento = new MovimientoStars9Max();
						movimiento.setId_mano(idMano);
						movimiento.setLinea(linea);
						movimiento.setNombre_jugador(jugador);
						movimiento.setPosicion(asiento(jugador));
						movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
						movimiento.setRonda(ronda);
						movimiento.setPot(pot);
						movimiento.setCant(Utils.round(cant, 2));
						movimiento.setTipo("raises");
						movimiento9maxRepository.save(movimiento);
						pot = pot + cant;
					}  else if (line.indexOf("calls") != -1) {
						jugador = Utils.nombreJugador(line);
						linea = linea + 1;

						cant = Double.parseDouble(Utils.ultimosnum(line));

						posicion = asiento(jugador);
						MovimientoStars9Max movimiento = new MovimientoStars9Max();
						movimiento.setId_mano(idMano);
						movimiento.setLinea(linea);
						movimiento.setNombre_jugador(jugador);
						movimiento.setPosicion(asiento(jugador));
						movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
						movimiento.setRonda(ronda);
						movimiento.setPot(pot);
						movimiento.setCant(Utils.round(cant, 2));
						movimiento.setTipo("calls");
						movimiento9maxRepository.save(movimiento);
						pot = pot + cant;
					} else if (line.indexOf("checks") != -1) {
						jugador = Utils.nombreJugador(line);
						linea = linea + 1;

						cant = 0.0;

						MovimientoStars9Max movimiento = new MovimientoStars9Max();
						movimiento.setId_mano(idMano);
						movimiento.setLinea(linea);
						movimiento.setNombre_jugador(jugador);
						movimiento.setPosicion(asiento(jugador));
						movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
						movimiento.setRonda(ronda);
						movimiento.setPot(pot);
						movimiento.setCant(Utils.round(cant, 2));
						movimiento.setTipo("checks");
						movimiento9maxRepository.save(movimiento);
						pot = pot + cant;
					} else if (line.indexOf("folds") != -1) {
						jugador = Utils.nombreJugador(line);
						linea = linea + 1;
						posicion = asiento(jugador);
						cant = 0.0;

						MovimientoStars9Max movimiento = new MovimientoStars9Max();
						movimiento.setId_mano(idMano);
						movimiento.setLinea(linea);
						movimiento.setNombre_jugador(jugador);
						movimiento.setPosicion(asiento(jugador));
						movimiento.setStack(stacksresta(jugador, Utils.round(cant, 2)));
						movimiento.setRonda(ronda);
						movimiento.setPot(pot);
						movimiento.setCant(Utils.round(cant, 2));
						movimiento.setTipo("folds");
						movimiento9maxRepository.save(movimiento);
						pot = pot + cant;

					}else if (line.indexOf("bets") != -1) {
						jugador = Utils.nombreJugador(line);
						linea = linea + 1;

						cant = Double.parseDouble(Utils.ultimosnum(line));

						posicion = asiento(jugador);
						MovimientoStars9Max movimiento = new MovimientoStars9Max();
						movimiento.setId_mano(idMano);
						movimiento.setLinea(linea);
						movimiento.setNombre_jugador(jugador);
						movimiento.setPosicion(asiento(jugador));
						movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
						movimiento.setRonda(ronda);
						movimiento.setPot(pot);
						movimiento.setCant(Utils.round(cant, 2));
						movimiento.setTipo("bets");
						movimiento9maxRepository.save(movimiento);
						pot = pot + cant;
					}
					if (line.indexOf("*** HOLE CARDS ***") != -1) {
						ronda = 1;
					} else if (line.indexOf("*** FLOP ***") != -1) {
						ronda = 2;
					} else if (line.indexOf("*** TURN ***") != -1) {
						ronda = 3;
					} else if (line.indexOf("*** RIVER ***") != -1) {
						ronda = 4;
					}

					line = reader.readLine();

				}

				try {
					while (line.indexOf("PokerStars") == -1) {
						line = reader.readLine();
						
					}
					
				} catch (Exception e) {
					File filelog2 = new File("C:/Users/Administrator/AppData/Local/Ficheros/startsreader.log");
					PrintStream ps2;
					ps2 = new PrintStream(filelog2);
					e.printStackTrace(ps2);
					ps2.close();
				}
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				
				System.out.println(fecha);
				try {
				fechaRepository.save(new FechaStars(idMano,formatter1.parse(fecha),randomString));
				
				asientosRepository.save(new AsientoStars(idMano, p1Nombre, p2Nombre, p3Nombre, p4Nombre, p5Nombre,p6Nombre,p7Nombre,p8Nombre,p9Nombre,mesa));
				resumenRepository.save (new ResumenStars(idMano,formatter1.parse(fecha),fichero));
				}catch(Exception e) {
					File filelog2 = new File("C:/Users/Administrator/AppData/Local/Ficheros/save.log");
					PrintStream ps2;
					ps2 = new PrintStream(filelog2);
					e.printStackTrace(ps2);
					ps2.close();
				}
				
				idMano = "";
				
				fecha = "";
				posicion = 0;
				linea = 0;
				ronda = 0;
				pot = 0.0;
				tipo = "";
				cant = 0.0;
				
			}
//				System.out.println(stake);
//				System.out.println(idMano);
//				System.out.println(fecha);
			// System.out.println(p1Nombre);
			// System.out.println(p2Nombre);
			// System.out.println(p3Nombre);
			// System.out.println(p4Nombre);
			// System.out.println(p5Nombre);
			reader.close();
			
		}
		
	} catch (Exception e) {
		File filelog = new File("C:/Users/Administrator/AppData/Local/Ficheros/starstest.log");
		PrintStream ps;
		try {
			ps = new PrintStream(filelog);
			e.printStackTrace(ps);
			ps.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("try2");
		
	}
	System.out.println("fin");
	try {
		reader.close();
	} catch (Exception e) {
		File filelogreader = new File("C:/Users/Administrator/AppData/Local/Ficheros/starstestReader.log");
		PrintStream psreader;
		try {
			psreader = new PrintStream(filelogreader);
			e.printStackTrace(psreader);
			psreader.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	return;
}

	public int asiento(String name) {

		int num = 0;
		if (name.equals(p1Nombre)) {
			num = 1;
		} else if (name.equals(p2Nombre)) {
			num = 2;
		} else if (name.equals(p3Nombre)) {
			num = 3;
		} else if (name.equals(p4Nombre)) {
			num = 4;
		} else if (name.equals(p5Nombre)) {
			num = 5;
		} else if (name.equals(p6Nombre)) {
			num = 6;
		}
		 else if (name.equals(p7Nombre)) {
			num = 7;
		}
		 else if (name.equals(p8Nombre)) {
			num = 8;
		}
		 else if (name.equals(p9Nombre)) {
			num = 9;
		}
		
		return num;
	}

	public Double stacksresta(String name, Double cant) {
		
		
		if (name.equals(p1Nombre)) {
			p1Stack = p1Stack - cant;
			return p1Stack;
		} else if (name.equals(p2Nombre)) {
			p2Stack = p2Stack - cant;
			return p2Stack;
		} else if (name.equals(p3Nombre)) {
			p3Stack =p3Stack - cant;
			return p3Stack;
		} else if (name.equals(p4Nombre)) {
			p4Stack  = p4Stack - cant;
			return p4Stack;
		} else if (name.equals(p5Nombre)) {
			p5Stack = p5Stack - cant;
			return p5Stack;
		}else if (name.equals(p6Nombre)) {
			p6Stack = p6Stack - cant;
			return p6Stack;
		}else if (name.equals(p7Nombre)) {
			p7Stack = p7Stack - cant;
			return p7Stack;
		}else if (name.equals(p8Nombre)) {
			p8Stack = p8Stack - cant;
			return p8Stack;
		}else if (name.equals(p9Nombre)) {
			p9Stack = p9Stack - cant;
			return p9Stack;
		}

		else {
			return 0.0;
		}
	}

}
	
	
}

