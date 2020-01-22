package edu.pdx.cs410J.vibha2;

/**
 * The main class for the CS410J airline Project
 */
public class Project1 {
  /**
   * Project.main when called checks the arguments and executes the options.
   * @param args options arguments in order airlinename flightnumber source departureDate departureTime destination arrivalDate arrivalTime
   */
  public static void main(String[] args) {
    if(args.length==0){
      System.err.println("Missing command line arguments");
      System.exit(1);
    }
    int countoptions=0;
    for(int i=0;i<args.length;i++){
      if(args[i].startsWith("-")){
        countoptions=countoptions+1;
      }
    }

    if(countoptions==0){
      if(args.length==8){
        populateinformation(args,0,false);
      }else if(args.length<8){
        System.err.println("Insufficient command line arguments");
        System.exit(1);
      }else if(args.length>8){
        System.err.println("Extra unknown command line arguments");
        System.exit(1);
      }
    }

    for(int j=0;j<countoptions;j++) {
      if (args[j].equalsIgnoreCase("-print")) {
        populateinformation(args, countoptions, true);
      } else if (args[j].equalsIgnoreCase("-README")) {
        readme();
      } else {
        System.err.println("Unknown command line option");
        System.exit(1);
      }
    }
  }


  /**
   * populateinformation performs the parsing of arguments and executes print function.
   * @param args Program arguments
   * @param i index of start of arguments
   * @param print boolean indicates if the function has print option
   * @throws Exception and exits with status 1
   */
  private static void  populateinformation(String[] args,int i,boolean print) {
try {
  if(args.length-i!=8){
    System.err.println("Insufficient arguments to populate flight information");
    System.exit(1);
  }
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

  /**
   * readme is a function which prints the Author and Project information which is hardcoded.
   *
   */
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


