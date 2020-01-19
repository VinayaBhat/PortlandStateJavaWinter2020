package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractFlight;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Flight extends AbstractFlight {
  //properties
  int flight_number;
  String source;
  String destination;
  String arrival_time;
  String departure_time;

  //constructor
  public Flight(String flightNumber){
   if(flightnumberisvalid(flightNumber)) {
     this.flight_number = Integer.parseInt(flightNumber);
   }else{
     System.err.println("Flight number is not set properly");
     System.exit(1);
   }
  }

  //Setters
  public void setSource(String source){
    if(flightsrcdestisvalid(source)) {
      this.source = source;
    }else{
      System.err.println("Flight source is not set properly");
      System.exit(1);
    }
  }

  public void setDestination(String destination){
    if(flightsrcdestisvalid(destination)) {
      this.destination = destination;
    }else{
      System.err.println("Flight destination is not set properly");
      System.exit(1);
    }
  }

  public void setArrival_time(String arrivalDate,String arrivalTime){
    if(checkdateandtime("Arrival",arrivalDate,arrivalTime))
      this.arrival_time = arrivalDate + " " + arrivalTime;
    else{
      System.err.println("Flight Arrival Time is not set properly");
      System.exit(1);
    }
  }

  public void setDeparture_time(String departureDate,String departureTime){
    if(checkdateandtime("Departure",departureDate,departureTime)) {
      this.departure_time=departureDate+" "+departureTime;
    }else{
      System.err.println("Flight Departure Time is not set properly");
      System.exit(1);
    }
  }

  @Override
  public int getNumber() {
    return this.flight_number;
  }

  @Override
  public String getSource() {
    if(source==null)
      {
        System.err.println("Source is not set");
        System.exit(1);
      }
    return this.source;
  }

  @Override
  public String getDepartureString() {
    if(departure_time==null)
        {
      System.err.println("Departure Time is not set");
      System.exit(1);
    }
    return this.departure_time;
  }

  @Override
  public String getDestination() {
    if(destination==null)
    {
      System.err.println("Destination is not set");
      System.exit(1);
    }
    return this.destination;
  }

  @Override
  public String getArrivalString() {
    if(arrival_time==null)
    {
      System.err.println("Arrival Time is not set");
      System.exit(1);
    }
    return this.arrival_time;
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


}
