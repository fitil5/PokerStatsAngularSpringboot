package com.poker.Utilidades;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class Utils {
 public static boolean isNumeric(Character strNum) {
    if (strNum==null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum.toString());
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
 public static String ultimosnum(String linea)
 {
     int g = linea.length() - 1;
     String cant = "";
     int i = 0;
     while (isNumeric(linea.charAt(g)) == false)
     {
         g = g - 1;
     }
     while (isNumeric(linea.charAt(g)) == true || linea.charAt(g) == '.')
     {
         cant = linea.charAt(g) + cant;
         g = g - 1;
     }
     return cant;
 }
 public static String primerosnum(String linea)
 {
     int g = 0;
     String cant = "";
     int i = 0;
     while (isNumeric(linea.charAt(g)) == false)
     {
         g = g + 1;
     }
     while (isNumeric(linea.charAt(g)) == true || linea.charAt(g) == '.')
     {
         cant =   cant + linea.charAt(g);
         g = g + 1;
     }
     return cant;
 }
 public static String ultimosnumfecha(String linea)
 {
     int g = linea.length() - 1;
     String cant = "";
     int i = 0;
     while (isNumeric(linea.charAt(g)) == false)
     {
         g = g - 1;
     }
     while (isNumeric(linea.charAt(g)) == true || linea.charAt(g) == ':' || linea.charAt(g) == '/'|| linea.charAt(g) ==' ')
     {
         cant = linea.charAt(g) + cant;
         g = g - 1;
     }
     return cant;
 }
 public static String nombreMesa(String linea)
 {
     int g = linea.length() - 1;
     String cant = "";
     int i = 0;
     while (linea.charAt(g) != (char)39)
     {
         g = g - 1;
     }
     while (linea.charAt(g) != (char)39)
     {
         cant = linea.charAt(g) + cant;
         g = g - 1;
     }
     return cant;
 }
 public static String nombreJugador(String linea)
 {
     int g = 0;
     String cant = "";
     int i = 0;
     while (linea.charAt(g) != ':')
     {
    	 cant =  cant +linea.charAt(g);
         g = g + 1;
     }
    
     return cant;
 }

 public static String nombreJugadorPrincipio(String linea)
 {
     int g = 0;
     String cant = "";
     int i = 0;
     while (linea.charAt(g) != ':')
     {
         g = g + 1;
     }
     g = g + 2;
     while (linea.charAt(g) != ' ')
     {
         cant =  cant+linea.charAt(g) ;
         g = g + 1;
     }
     return cant;
 }
 public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
 public static Date utcToCet(Date dateToConvert) {
	 Calendar cal = Calendar.getInstance(); // creates calendar
	 cal.setTime(dateToConvert);               // sets calendar time/date
	 cal.add(Calendar.HOUR, -1);      // adds one hour
     return  cal.getTime();
 }
 public static String getAlphaNumericString(int n)
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
 public static String obtenerStake(String linea) {
	 int g=linea.length()-1;
	 String stake="";
	 while (linea.charAt(g) != ')')
     {
         g = g - 1;
     } while (isNumeric(linea.charAt(g)) == false)
     {
         g = g - 1;
     }
     while (isNumeric(linea.charAt(g)) == true || linea.charAt(g)=='.')
     {
    	 stake=linea.charAt(g)+stake ;
    	 g = g - 1;
     }
     
     return stake;
	 
 }
}
