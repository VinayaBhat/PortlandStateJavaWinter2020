package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractAirline;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * The main class for the CS410J airline Project
 */
public class Project1 {

  public static void main(String[] args) {
    if(args.length<6){
      System.err.println("Missing command line arguments");
      System.exit(1);
    }
    if (args[0].equalsIgnoreCase("-print")) {
      if (args[1].equalsIgnoreCase("-README")) {
        int i = 2;
        printoption(args, i);
        readme();
      } else {
        int i = 1;
        printoption(args, i);
      }
    } else if (args[0].equalsIgnoreCase("-README")) {
      if (args[1].equalsIgnoreCase("-print")) {
        readme();
        int i = 2;
        printoption(args, i);
      } else {
        readme();
      }
    } else {
      System.err.println("Options not provided");
      System.exit(1);
    }
  }

private static void  printoption(String[] args,int i) {

  String airlinename = args[i];
  String flightnumber = args[i + 1];
  String flightsrc = args[i + 2];
  String depardate = args[i + 3];
  String departime = args[i + 4];
  String flightdest = args[i + 5];
  String arrivaldate = args[i + 6];
  String arrrivaltime = args[i + 7];
  if (airlinename.length() == 0) {
    System.err.println("Airline Name not given properly");
    System.exit(1);
  }
  Airline<Flight> a1 = new Airline<>(airlinename);
  if (!flightnumberisvalid(flightnumber)) {
    System.err.println("Flight Number not given properly");
    System.exit(1);
  }
  Flight flight = new Flight(Integer.parseInt(flightnumber));
  if (!flightsrcdestisvalid(flightsrc)) {
    System.err.println("Flight source not given properly");
    System.exit(1);
  }
  flight.setSource(flightsrc);
    //Checking if format is correct
   //if(checkdateandtime("Departure",depardate,departime)){
  if(true){
     String departdatetime = depardate + " " + departime;
     flight.setDeparture_time(departdatetime);
   }

  if (!flightsrcdestisvalid(flightdest)) {
    System.err.println("Flight destination not given properly");
    System.exit(1);
  }
  flight.setDestination(flightdest);

    //Checking if format is correct
   // if (checkdateandtime("Arrival", arrivaldate, arrrivaltime)) {
  if(true){
      String arrdatetime = arrivaldate + " " + arrrivaltime;
      flight.setArrival_time(arrdatetime);
    }
    a1.addFlight(flight);
    System.out.println(flight.toString());

  }
  private static boolean flightsrcdestisvalid (String flightinfo){
    if (flightinfo.matches("^[a-zA-Z]*$") && flightinfo.length() == 3) {
      return true;
    }
    return false;
  }

  private static boolean flightnumberisvalid (String flightnumber){
    String regex = "[0-9]+";
    return flightnumber.matches(regex);
  }

  private static boolean checkdateandtime (String sd, String date, String time){
    try {
      System.out.println((sd));
      System.out.println((sd));
      Date date1 = new SimpleDateFormat("mm/dd/yyyy").parse(date);
      int yearlen = String.valueOf(date1.getYear()).length();
      int day = date1.getDay();
      int month = date1.getMonth();
      if (yearlen != 4 || day < 1 || day > 31 || month < 1 || month > 12) {
        System.err.println(sd + " date not set properly");
        System.exit(1);
      }

    } catch (Exception e) {
      System.err.println(sd + " date not set properly");
      System.exit(1);
    }
    try {
      LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    } catch (Exception e) {
      System.err.println(sd + " time not set properly");
      System.exit(1);
    }
    return true;
  }

  public static void readme(){
    System.out.println("Author: Vinaya D Bhat");
    System.out.println("Project 1: Designing an Airline Application");
    System.out.println("This project contains two classes: Airline and Flight");
    System.out.println("Airline class: This class extends the AbstractAirline class from the package edu.pdx.cs410J. " +
            "The AbstractAirline class has the abstract methods of getName(), addFlight(Flight flight) and " +
            "getFlights().The toString() in AbstractAirline is implemented." +
            "The Airline class implements the abstract methods of AbstractAirline class. The Airline class is instantiated" +
            " by invoking the Airline constructor passing the airlinename as argument");
    System.out.println("Flight class: This class extends the AbstractFlight class from the package edu.pdx.cs410J. " +
            "The AbstractFlight class has the abstract methods of getNumber(), getSource(), " +
            "getDestination ,getArrivalString() and getDepartureString(). " +
            "The toString() in AbstractFlight is implemented." +
            "The Flight class implements the abstract methods of AbstractFlight class. The Flight class is instantiated" +
            " by invoking the Flight constructor passing the flight number as argument. The setters for the flight properties source, destination, arrival time and date, departure time and date are implemented.");
  }

}


