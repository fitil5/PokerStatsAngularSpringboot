package com.grokonez.jwtauthentication.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grokonez.jwtauthentication.Utilidades.Utils;
import com.grokonez.jwtauthentication.model.AsientoWina;
import com.grokonez.jwtauthentication.model.FechaWina;
import com.grokonez.jwtauthentication.model.MovimientoWina;
import com.grokonez.jwtauthentication.model.ResumenWina;
import com.grokonez.jwtauthentication.repository.AsientosRepositoryWina;
import com.grokonez.jwtauthentication.repository.FechaRepositoryWina;
import com.grokonez.jwtauthentication.repository.MovimientoRepositoryWina;
import com.grokonez.jwtauthentication.repository.ResumenRepositoryWina;



public interface IMovimientoWina {
	public double  vpip(String nombre_jugador);

	double getCbetCallTurn(String nombre_jugador);

	double getCbetCall(String nombre_jugador);

	double getfoldCbet(String nombre_jugador);

	public double  getMediaCantFlop(String nombre_jugador);

	public double  getMediaCantTurn(String nombre_jugador);

	public double  getMediaCantRiver(String nombre_jugador);

	public double  getPfr(String nombre_jugador);

	public void save(MovimientoWina movimiento);

	public double  get3Bet(String nombre_jugador);

	public double  getCbet(String nombre_jugador);

	public void leerFichero(String fichero, String randomString);

	public double  getManos(String nombre_jugador);

	@Service
	
	public class MovimientoClass implements IMovimientoWina {
		@Autowired
		MovimientoRepositoryWina movimientoRepository;
		@Autowired
		FechaRepositoryWina fechaRepository;
		@Autowired
		AsientosRepositoryWina asientosRepository;
		@Autowired
		ResumenRepositoryWina resumenRepository;

		@Override

		public void save(MovimientoWina movimiento) {
			// TODO Auto-generated method stub
			movimientoRepository.save(movimiento);
		}

		@Override

		public double  vpip(String nombre_jugador) {
			double resultado = 0;
			
			try {
				double vpip = movimientoRepository.getVpip(nombre_jugador);
				double vpipTotal = movimientoRepository.getVpipTotal(nombre_jugador);
				resultado = (vpip / vpipTotal) * 100;
				return Utils.round(resultado, 0);
			} catch (Exception e) {
				return 0;
			}
			// movimientoRepository.vpip(nombre_jugador);
		}

		@Override

		public double  getMediaCantFlop(String nombre_jugador) {
			// TODO Auto-generated method stub
			try {
				Double resultado = movimientoRepository.getMediaCantFlop(nombre_jugador);
				return Utils.round(resultado, 0);
			} catch (Exception e) {
				return 0;

			}
		}

		@Override

		public double  getMediaCantTurn(String nombre_jugador) {
			// TODO Auto-generated method stub
			try {
				return Utils.round(movimientoRepository.getMediaCantTurn(nombre_jugador), 0);
			} catch (Exception e) {
				return 0;
			}
		}

		@Override
		public double getMediaCantRiver(String nombre_jugador) {
			try {
				return Utils.round(movimientoRepository.getMediaCantRiver(nombre_jugador), 0);
			} catch (Exception e) {
				return 0;
			} // TODO Auto-generated method stub

		}

		@Override
		public double  getPfr(String nombre_jugador) {
			// TODO Auto-generated method stub
			double resultado = 0;
			try {
				double pfr = movimientoRepository.getPfr(nombre_jugador);
				double pfrTotal = movimientoRepository.getPfrTotal(nombre_jugador);

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
				
				return Utils.round(movimientoRepository.get3Bet(nombre_jugador),0);
			} catch (Exception e) {
				
				return 0;
			}

		}

		@Override
		public double  getManos(String nombre_jugador) {
			// TODO Auto-generated method stub
			try {

				return Utils.round(movimientoRepository.getManos(nombre_jugador), 0);
			} catch (Exception e) {
				return 0;
			}

		}
		
		@Override
		public double  getCbet(String nombre_jugador) {
			// TODO Auto-generated method stub
			try {
				
				

				return Utils.round(movimientoRepository.getCbet(nombre_jugador), 0);
			} catch (Exception e) {
				
				return 0;
			}
		}
		@Override
		public double  getCbetCall(String nombre_jugador) {
			// TODO Auto-generated method stub
			try {
				
				

				return Utils.round(movimientoRepository.getCbetCall(nombre_jugador), 0);
			} catch (Exception e) {
				
				return 0;
			}
		}
		@Override
		public double  getCbetCallTurn(String nombre_jugador) {
			// TODO Auto-generated method stub
			try {
				
				

				return Utils.round(movimientoRepository.getCbetCallTurn(nombre_jugador), 0);
			} catch (Exception e) {
				
				return 0;
			}
		}
		@Override
		public double  getfoldCbet(String nombre_jugador) {
			// TODO Auto-generated method stub
			try {
				
				

				return Utils.round(movimientoRepository.getfoldCbet(nombre_jugador), 0);
			} catch (Exception e) {
				
				return 0;
			}
		}

		String p1Nombre = "";
		String p2Nombre = "";
		String p3Nombre = "";
		String p4Nombre = "";
		String p5Nombre = "";
		Double p1Stack;
		Double p2Stack;
		Double p3Stack;
		Double p4Stack;
		Double p5Stack;
		BufferedReader reader;
		@Transactional
		public void leerFichero(String fichero, String randomString) {
			try {
				String idMano = "";
				String stake = "";
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

				File file = new File(fichero);
				FileInputStream fis = new FileInputStream(fichero);
				byte[] data = new byte[(int) file.length()];
				fis.read(data);
				fis.close();

				String str = new String(data, "UTF-8");
				if (str.indexOf("Incognito") == -1 && str.indexOf("Tournament summary")==-1) {
					 reader = new BufferedReader(new FileReader(fichero));

					while (line != null) {

						while (line.indexOf("Winamax Poker - CashGame - HandId: #") == -1) {

							line = reader.readLine();
							System.out.println("-----" + line);

						}
						System.out.println("ÇÇ" + line);
						idMano = line.substring(line.indexOf("#") + 1, line.indexOf("Holdem") - 3);

						stake = line.substring(line.indexOf('(') + 1, line.indexOf(')'));

						fecha = line.substring(line.lastIndexOf('-') + 2, line.indexOf("UTC") + 3);
						line = reader.readLine();
						mesa= line.substring(line.indexOf("'")+1,line.lastIndexOf("'"));

						while (line.indexOf("*** ANTE/BLINDS ***") == -1) {
							System.out.println("*");

							if (line.indexOf("Seat 1:") != -1) {
								p1Nombre = line.substring(line.indexOf(':') + 2, line.lastIndexOf('(') - 1);
								p1Stack = Double.parseDouble(Utils.ultimosnum(line));
							} else if (line.indexOf("Seat 2:") != -1) {
								p2Nombre = line.substring(line.indexOf(':') + 2, line.lastIndexOf('(') - 1);
								p2Stack = Double.parseDouble(Utils.ultimosnum(line));
							} else if (line.indexOf("Seat 3:") != -1) {
								p3Nombre = line.substring(line.indexOf(':') + 2, line.lastIndexOf('(') - 1);
								p3Stack =Double.parseDouble(Utils.ultimosnum(line));
							} else if (line.indexOf("Seat 4:") != -1) {
								p4Nombre = line.substring(line.indexOf(':') + 2, line.lastIndexOf('(') - 1);
								p4Stack = Double.parseDouble(Utils.ultimosnum(line));
							} else if (line.indexOf("Seat 5:") != -1) {
								p5Nombre = line.substring(line.indexOf(':') + 2, line.lastIndexOf('(') - 1);
								p5Stack = Double.parseDouble(Utils.ultimosnum(line));
							}
							line = reader.readLine();
						}
						String jugador = "";

						while (line.indexOf("*** SUMMARY ***") == -1) {
							System.out.println("sumary" + line);
							if (line.indexOf("small blind") != -1) {
								ronda = 0;
								jugador = line.substring(0, line.indexOf("posts") - 1);
								linea = linea + 1;
								cant = Double.parseDouble(Utils.ultimosnum(line));

								MovimientoWina movimiento = new MovimientoWina();
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
								movimientoRepository.save(movimiento);

								pot = pot + cant;
							} else if (line.indexOf("big blind") != -1) {
								ronda = 0;
								jugador = line.substring(0, line.indexOf("posts") - 1);
								linea = linea + 1;
								cant = Double.parseDouble(Utils.ultimosnum(line));

								posicion = asiento(jugador);
								MovimientoWina movimiento = new MovimientoWina();
								movimiento.setId_mano(idMano);
								movimiento.setLinea(linea);
								movimiento.setNombre_jugador(jugador);
								movimiento.setPosicion(asiento(jugador));
								movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
								movimiento.setRonda(ronda);
								movimiento.setPot(pot);
								movimiento.setCant(Utils.round(cant, 2));
								movimiento.setTipo("big blind");
								movimientoRepository.saveAndFlush(movimiento);
								pot = pot + cant;
							} else if (line.indexOf("raises") != -1) {
								jugador = line.substring(0, line.indexOf("raises") - 1);
								linea = linea + 1;

								cant = Double.parseDouble(Utils.ultimosnum(line));

								posicion = asiento(jugador);
								MovimientoWina movimiento = new MovimientoWina();
								movimiento.setId_mano(idMano);
								movimiento.setLinea(linea);
								movimiento.setNombre_jugador(jugador);
								movimiento.setPosicion(asiento(jugador));
								movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
								movimiento.setRonda(ronda);
								movimiento.setPot(pot);
								movimiento.setCant(Utils.round(cant, 2));
								movimiento.setTipo("raises");
								movimientoRepository.save(movimiento);
								pot = pot + cant;
							} else if (line.indexOf("bets") != -1) {
								jugador = line.substring(0, line.indexOf("bets") - 1);
								linea = linea + 1;

								cant = Double.parseDouble(Utils.ultimosnum(line));

								posicion = asiento(jugador);
								MovimientoWina movimiento = new MovimientoWina();
								movimiento.setId_mano(idMano);
								movimiento.setLinea(linea);
								movimiento.setNombre_jugador(jugador);
								movimiento.setPosicion(asiento(jugador));
								movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
								movimiento.setRonda(ronda);
								movimiento.setPot(pot);
								movimiento.setCant(Utils.round(cant, 2));
								movimiento.setTipo("bets");
								movimientoRepository.save(movimiento);
								pot = pot + cant;
							} else if (line.indexOf("calls") != -1) {
								jugador = line.substring(0, line.indexOf("calls") - 1);
								linea = linea + 1;

								cant = Double.parseDouble(Utils.ultimosnum(line));

								posicion = asiento(jugador);
								MovimientoWina movimiento = new MovimientoWina();
								movimiento.setId_mano(idMano);
								movimiento.setLinea(linea);
								movimiento.setNombre_jugador(jugador);
								movimiento.setPosicion(asiento(jugador));
								movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
								movimiento.setRonda(ronda);
								movimiento.setPot(pot);
								movimiento.setCant(Utils.round(cant, 2));
								movimiento.setTipo("calls");
								movimientoRepository.save(movimiento);
								pot = pot + cant;
							} else if (line.indexOf("checks") != -1) {
								jugador = line.substring(0, line.indexOf("checks") - 1);
								linea = linea + 1;

								cant = 0.0;

								MovimientoWina movimiento = new MovimientoWina();
								movimiento.setId_mano(idMano);
								movimiento.setLinea(linea);
								movimiento.setNombre_jugador(jugador);
								movimiento.setPosicion(asiento(jugador));
								movimiento.setStack(Utils.round(stacksresta(jugador, cant), 2));
								movimiento.setRonda(ronda);
								movimiento.setPot(pot);
								movimiento.setCant(Utils.round(cant, 2));
								movimiento.setTipo("checks");
								movimientoRepository.save(movimiento);
								pot = pot + cant;
							} else if (line.indexOf("folds") != -1) {
								jugador = line.substring(0, line.indexOf("fold") - 1);
								linea = linea + 1;
								posicion = asiento(jugador);
								cant = 0.0;

								MovimientoWina movimiento = new MovimientoWina();
								movimiento.setId_mano(idMano);
								movimiento.setLinea(linea);
								movimiento.setNombre_jugador(jugador);
								movimiento.setPosicion(asiento(jugador));
								movimiento.setStack(stacksresta(jugador, Utils.round(cant, 2)));
								movimiento.setRonda(ronda);
								movimiento.setPot(pot);
								movimiento.setCant(Utils.round(cant, 2));
								movimiento.setTipo("folds");
								movimientoRepository.save(movimiento);
								pot = pot + cant;

							}
							if (line.indexOf("*** PRE-FLOP ***") != -1) {
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
							while (line.indexOf("Winamax Poker - CashGame - HandId: #") == -1) {
								line = reader.readLine();
								System.out.println("++++" + line);
							}

						} catch (Exception e) {
							File filelog2 = new File("C:/Users/Administrator/AppData/Local/Ficheros/winasreader.log");
							PrintStream ps2;
							ps2 = new PrintStream(filelog2);
							e.printStackTrace(ps2);
							ps2.close();
						}
						SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss z");
						
						String username =  randomString;
						fechaRepository.save(new FechaWina(idMano,Utils.utcToCet(formatter1.parse(fecha)),username));
						
						asientosRepository.save(new AsientoWina(idMano, p1Nombre, p2Nombre, p3Nombre, p4Nombre, p5Nombre,mesa));
						resumenRepository.save (new ResumenWina(idMano,Utils.utcToCet(formatter1.parse(fecha)),fichero));

						idMano = "";
						stake = "";
						fecha = "";
						posicion = 0;
						linea = 0;
						ronda = 0;
						pot = 0.0;
						tipo = "";
						cant = 0.0;
						p1Nombre="";
						p2Nombre="";
						p3Nombre="";
						p4Nombre="";
						p5Nombre="";
						
					}
//						System.out.println(stake);
//						System.out.println(idMano);
//						System.out.println(fecha);
					// System.out.println(p1Nombre);
					// System.out.println(p2Nombre);
					// System.out.println(p3Nombre);
					// System.out.println(p4Nombre);
					// System.out.println(p5Nombre);
					reader.close();
				}

			} catch (Exception e) {
				File filelog = new File("C:/Users/Administrator/AppData/Local/Ficheros/winatest.log");
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				File filelogreader = new File("C:/Users/Administrator/AppData/Local/Ficheros/winatestReader.log");
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
			}
			return num;
		}

		public double stacksresta(String name, double cant) {

			if (name.equals(p1Nombre)) {
				p1Stack = p1Stack - cant;
				return p1Stack;
			} else if (name.equals(p2Nombre)) {
				p2Stack = p2Stack - cant;
				return p2Stack;
			} else if (name.equals(p3Nombre)) {
				p3Stack = p3Stack - cant;
				return p3Stack;
			} else if (name.equals(p4Nombre)) {
				p4Stack = p4Stack - cant;
				return p4Stack;
			} else if (name.equals(p5Nombre)) {
				p5Stack = p5Stack - cant;
				return p5Stack;
			}

			else {
				return 0;
			}
		}

	}
}
