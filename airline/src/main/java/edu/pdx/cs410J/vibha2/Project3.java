package edu.pdx.cs410J.vibha2;

import java.util.ArrayList;

public class Project3 {

    public static void main(String[] args) {
        boolean textfile=false;
        int filepathindex=0;
        if(args.length==0){
            System.err.println("Missing command line arguments");
            System.exit(1);
        }
        int countoptions=0;
        boolean dashpresent=false;
        boolean prettyfilepresent=false;
        String prettypath="";
        ArrayList<String> options=new ArrayList<>();
        for(int i=0;i<args.length;i++){
            if(args[i].startsWith("-")){
                if(args[i].startsWith("-textFile")){
                    textfile=true;
                    filepathindex=i+1;
                }
                if(args[i].startsWith("-pretty")) {
                    if (args[i + 1].contains(".")) {
                        prettypath = args[i + 1];
                        prettyfilepresent=true;
                    }
                }
                if(args[i].equals("-")){
                    dashpresent=true;
                }
                options.add(args[i]);
                countoptions=countoptions+1;

            }
        }
        if(dashpresent) {
            countoptions = countoptions - 1;
            options.remove("-");
        }
        if(countoptions==0){
            if(args.length==10){
                populateinformation(args,0,false);
            }else if(args.length<10){
                System.err.println("Insufficient command line arguments");
                System.exit(1);
            }else if(args.length>10){
                System.err.println("Extra unknown command line arguments");
                System.exit(1);
            }
        }

        for(int j=0;j<countoptions;j++) {
            if (options.get(j).equalsIgnoreCase("-print")) {
                int argindex=countoptions;
                if(textfile){
                    argindex=argindex+1;
                    if(prettyfilepresent){
                        argindex=argindex+1;
                    }
                }
                populateinformation(args, argindex, true);
            } else if (options.get(j).equalsIgnoreCase("-README")) {
                readme();
            }else if (options.get(j).equalsIgnoreCase("-textFile")) {
                int numberofargs=0;
                numberofargs = countoptions;
                if (dashpresent || prettyfilepresent) {
                     numberofargs = numberofargs + 1;
                }
                if (textfile) {
                    numberofargs = numberofargs+1;
                }
                textfilereadandwrite(args, args[filepathindex], numberofargs);
            }else if(options.get(j).equalsIgnoreCase("-pretty")){
                if(dashpresent) {
                    int numberofargs = countoptions + 1;
                    if (textfile) {
                        numberofargs = numberofargs+1;
                    }
                    prettyprint(args,prettypath,args[filepathindex],numberofargs);
                }


                if(prettyfilepresent){
                    int numberofargs=countoptions+1;
                    if(textfile){
                        numberofargs=numberofargs+1;
                    }
                    prettyprint(args,prettypath,args[filepathindex],numberofargs);
                }
            }
            else {
                System.err.println("Unknown command line option");
                System.exit(1);
            }
        }
    }

    /**
     * prettyprint option call
     * @param args input args
     * @param filepath to pretty print file
     * @param textfile to text file
     * @param i index of args
     */
    private static void prettyprint(String[] args, String filepath, String textfile,int i) {
        try {
            if(args.length-i!=10){
                System.err.println("Number of arguments not correct to populate flight information");
                System.exit(1);
            }
            String airlinename = args[i];
            String flightnumber = args[i + 1];
            String flightsrc = args[i + 2];
            String depardate = args[i + 3];
            String departime = args[i + 4]+" "+args[i+5];
            String flightdest = args[i + 6];
            String arrivaldate = args[i + 7];
            String arrrivaltime = args[i + 8]+" "+args[i+9];
            Airline<Flight> a1 = new Airline<>(airlinename);
            Flight flight = new Flight(flightnumber);
            flight.setSource(flightsrc);
            flight.setDeparture_time(depardate, departime);
            flight.setDestination(flightdest);
            flight.setArrival_time(arrivaldate, arrrivaltime);
            a1.addFlight(flight);
            if(filepath.length()==0){
                PrettyPrinter p=new PrettyPrinter(textfile,new Airline(airlinename));
            }else{
                PrettyPrinter p=new PrettyPrinter(filepath,textfile,new Airline(airlinename));

            }

        }catch (Exception e){
            System.err.println("Error in pretty print" +e.getMessage());
            System.exit(1);
        }
    }

    /**
     * textfilereadandwrite textfile option call
     * @param args inout args
     * @param filepath path of textFile
     * @param i start of args
     */
    private static void textfilereadandwrite(String[] args, String filepath, int i) {
        try {
            if(args.length-i!=10){
                System.err.println("Number of arguments to populate flight information not correct");
                System.exit(1);
            }
            String airlinename = args[i];
            String flightnumber = args[i + 1];
            String flightsrc = args[i + 2];
            String depardate = args[i + 3];
            String departime = args[i + 4]+" "+args[i+5];
            String flightdest = args[i + 6];
            String arrivaldate = args[i + 7];
            String arrrivaltime = args[i + 8]+" "+args[i+9];
            Airline<Flight> a1 = new Airline<>(airlinename);
            Flight flight = new Flight(flightnumber);
            flight.setSource(flightsrc);
            flight.setDeparture_time(depardate, departime);
            flight.setDestination(flightdest);
            flight.setArrival_time(arrivaldate, arrrivaltime);
            a1.addFlight(flight);
            TextDumper td=new TextDumper();
            td.writeToText(filepath,a1);

        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
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
            if(args.length-i!=10){
                System.err.println("Insufficient arguments to populate flight information");
                System.exit(1);
            }
            String airlinename = args[i];
            String flightnumber = args[i + 1];
            String flightsrc = args[i + 2];
            String depardate = args[i + 3];
            String departime = args[i + 4]+" "+args[i+5];
            String flightdest = args[i + 6];
            String arrivaldate = args[i + 7];
            String arrrivaltime = args[i + 8]+" "+args[i+9];
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
        System.out.println("Project 3: Designing an Airline Application");
        System.out.println("This project contains Five classes: Airline,Flight,TextDumper,TextParser and PrettyPrint");
        System.out.println("We are populating the airline and flight information such that one " +
                "airline contains multiple flights. We are writing the flight information to a " +
                "textfile if the -textFile option is given. We are sorting the flight information based on the " +
                "departure airport and the departure time and storing it in a file if -pretty option is given");
        System.out.println("Airline class conatins methods to add airline name, add flights thay belong to the airline and get flights that belong to the airline");
        System.out.println("Flight class contains getters and setters to populate flight information of source, destination, number, arrival and departure time");
        System.out.println("Text Parser validates flight information in the file and parses incoming flight information");
        System.out.println("Text Dumper class allowd to write the flight information to the text file");
        System.out.println("Pretty Printer class either writes to stdout or to a pretty print file");
    }

}
