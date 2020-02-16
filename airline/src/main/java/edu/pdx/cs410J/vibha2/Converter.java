package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractAirline;

import java.util.Collection;
import java.util.List;

public class Converter {
    public static void main(String[] args){
        if(args.length==0){
            System.err.println("Missing command line arguments for Converter");
            System.exit(1);
        }else if(args.length<2){
            System.err.println("Insufficient command line arguments for Converter");
            System.exit(1);
        }else if(args.length>2){
            System.err.println("Extra command line arguments for Converter");
            System.exit(1);
        }else{
            try {
                String textfile = args[0];
                String xmlfile = args[1];
                TextParser tp = new TextParser();
                tp.validateData(textfile);
                AbstractAirline<Flight> airline = tp.parse();
                Collection<Flight> flight=airline.getFlights();
                for(Flight f:flight){
                    String departure=f.getDepartureString();
                    f.setXmldeparture(departure.substring(0,departure.length()-2));
                    String arrival=f.getArrivalString();
                    f.setXmlarrival(arrival.substring(0,arrival.length()-2));
                }
                XmlDumper xd = new XmlDumper(xmlfile);
                xd.dump(airline);
            }catch (Exception e){
                System.err.println("Error in Converter " +e.getMessage());
                System.exit(1);
            }




        }

    }
}
