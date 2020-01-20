package edu.pdx.cs410J.vibha2;


/**
 * The main class for the CS410J airline Project
 */
public class Project1 {

  public static void main(String[] args) {
    if(args.length==1){
      if(args[0].equalsIgnoreCase("-README")){
        readme();
      }
    }else if(args.length==0 || args.length<8){
      System.err.println("Missing command line arguments");
      System.exit(1);
    }else {
      if (args[0].equalsIgnoreCase("-print")) {
        if (args[1].equalsIgnoreCase("-README")) {
          int i = 2;
          populateinformation(args, i,true);
          readme();
        } else {
          int i = 1;
          populateinformation(args, i,true);
        }
      } else if (args[0].equalsIgnoreCase("-README")) {
        if (args[1].equalsIgnoreCase("-print")) {
          readme();
          int i = 2;
          populateinformation(args, i,true);
        } else {
          readme();
        }
      } else {

        populateinformation(args, 0,false);
      }
    }
  }


private static void  populateinformation(String[] args,int i,boolean print) {
try {
  String airlinename = args[i];
  String flightnumber = args[i + 1];
  String flightsrc = args[i + 2];
  String depardate = args[i + 3];
  String departime = args[i + 4];
  String flightdest = args[i + 5];
  String arrivaldate = args[i + 6];
  String arrrivaltime = args[i + 7];
  Airline<Flight> a1 = new Airline<>(airlinename);
  Flight flight = new Flight(flightnumber);
  flight.setSource(flightsrc);
  flight.setDeparture_time(depardate, departime);
  flight.setDestination(flightdest);
  flight.setArrival_time(arrivaldate, arrrivaltime);
  a1.addFlight(flight);
  if (print) {
    System.out.println(flight.toString());
  }
}catch (Exception e){
  System.err.println(e.getMessage());
  System.exit(1);
}
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


