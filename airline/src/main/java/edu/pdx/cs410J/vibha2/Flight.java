package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractFlight;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
     throw new IllegalArgumentException("Flight number is not set properly");
   }
  }

  //Setters
  public void setSource(String source){
    if(flightsrcdestisvalid(source)) {
      this.source = source;
    }else{
      throw new IllegalArgumentException("Flight source is not set properly");

    }
  }

  public void setDestination(String destination){
    if(flightsrcdestisvalid(destination)) {
      this.destination = destination;
    }else{
      throw new IllegalArgumentException("Flight destination is not set properly");

    }
  }

  public void setArrival_time(String arrivalDate,String arrivalTime){
    if(checkdateandtime("Arrival",arrivalDate,arrivalTime))
      this.arrival_time = arrivalDate + " " + arrivalTime;
  }

  public void setDeparture_time(String departureDate,String departureTime){
    if(checkdateandtime("Departure",departureDate,departureTime)) {
      this.departure_time=departureDate+" "+departureTime;
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
        throw new UnsupportedOperationException("Source not set");

      }
    return this.source;
  }

  @Override
  public String getDepartureString() {
    if(departure_time==null)
        {
     throw new UnsupportedOperationException("Departure Time not set");
    }
    return this.departure_time;
  }

  @Override
  public String getDestination() {
    if(destination==null)
    {
      throw new UnsupportedOperationException("Destination not set");

    }
    return this.destination;
  }

  @Override
  public String getArrivalString() {
    if(arrival_time==null)
    {
      throw new UnsupportedOperationException("Arrival Time not set");

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
      Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(date);
      Calendar cdate = Calendar.getInstance();
      cdate.setTime(date1);
      int day=cdate.get(Calendar.DAY_OF_MONTH);
     int year=cdate.get(Calendar.YEAR);
      int month=cdate.get(Calendar.MONTH);
      month=month+1;
      if (String.valueOf(year).length() != 4 || day < 1 || day > 31 || month < 1 || month > 12) {
        throw new IllegalArgumentException(sd + " date not set properly");
      }

    } catch (Exception e) {
      throw new IllegalArgumentException(sd + " date not set properly");
    }

    try {
      LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    } catch (Exception e) {
      throw new IllegalArgumentException(sd +" time not set properly");
    }
    return true;
  }


}
