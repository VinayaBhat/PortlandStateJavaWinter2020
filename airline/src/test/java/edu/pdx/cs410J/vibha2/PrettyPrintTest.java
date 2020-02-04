package edu.pdx.cs410J.vibha2;

import org.junit.Test;

import java.text.ParseException;

/**
 * Testing pretty option
 */
public class PrettyPrintTest {
    /**
     *testingprettyprintandfile dumps to textfile and orders and writes to pretty print file
     *
     */
    @Test
    public void testingprettyprintandfile(){
        String textpath="prettyprinttestText.txt";
        String prettypreintfile="prettyprint.txt";
        Airline<Flight> a1=new Airline<>("Alaska");
        Flight flight = new Flight("5");
        flight.setSource("PDX");
        flight.setDestination("JFK");
        flight.setDeparture_time("1/22/2020", "1:40 pm");
        flight.setArrival_time("1/23/2020", "10:30 am");
        a1.addFlight(flight);
        PrettyPrinter p=new PrettyPrinter(prettypreintfile,textpath,a1);
    }

    /**
     *testingprettyprint orders and writes to existing pretty print file
     *
     */
    @Test
    public void testingprettyprint() throws ParseException {
        String textpath="prettyprinttestText.txt";
        Airline<Flight> a1=new Airline<>("Alaska");
        Flight flight = new Flight("5");
        flight.setSource("JFK");
        flight.setDestination("PDX");
        flight.setDeparture_time("1/20/2020", "1:40 pm");
        flight.setArrival_time("1/21/2020", "10:30 am");
        a1.addFlight(flight);
        TextDumper<Airline> td=new TextDumper<Airline>();
        td.writeToText(textpath,a1);
        PrettyPrinter p=new PrettyPrinter(textpath,a1);
    }


}
