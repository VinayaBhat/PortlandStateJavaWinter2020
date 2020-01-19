package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractFlight;

public class Flight extends AbstractFlight {
  //properties
  int flight_number;
  String source;
  String destination;
  String arrival_time;
  String departure_time;

  //constructor
  public Flight(int flightNumber){

    this.flight_number=flightNumber;
  }

  //Setters
  public void setSource(String source){
    this.source=source;
  }

  public void setDestination(String destination){
    this.destination=destination;
  }

  public void setArrival_time(String arrivalTime){
    this.arrival_time=arrivalTime;
  }

  public void setDeparture_time(String departureTime){
    this.departure_time=departureTime;
  }

  @Override
  public int getNumber() {
    return this.flight_number;
  }

  @Override
  public String getSource() {
    if(source!=null)
    return this.source;
    else
      throw new UnsupportedOperationException("Source not specified");
  }

  @Override
  public String getDepartureString() {
    if(departure_time!=null)
      return this.departure_time;
    else
      throw new UnsupportedOperationException("Departure Time not specified");
  }

  @Override
  public String getDestination() {
    if(destination!=null)
      return this.destination;
    else
      throw new UnsupportedOperationException("Destination not specified");
  }

  @Override
  public String getArrivalString() {
    if(arrival_time!=null)
      return this.arrival_time;
    else
      throw new UnsupportedOperationException("Arrival Time not specified");
  }

}
