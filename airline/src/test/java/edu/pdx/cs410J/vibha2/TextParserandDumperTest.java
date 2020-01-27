package edu.pdx.cs410J.vibha2;

import org.junit.Test;

/**
 * File to test TextParser and TextDumper
 */
public class TextParserandDumperTest {

    /**
     * Testing the parse functions which returns airline
     */
    @Test
    public void testingparsefunction(){
        TextParser tp=new TextParser();
        tp.parse();
    }

    /**
     * Testing the dump functions which writes to text file
     */
    @Test
    public void testingtextdump(){
        TextDumper td=new TextDumper();
        Airline<Flight> a1=new Airline<>("Alaska");
        Flight flight = new Flight("5");
        flight.setSource("JFK");
        flight.setDestination("PDX");
        flight.setArrival_time("1/21/2020", "10:30");
        flight.setDeparture_time("1/20/2020", "15:40");
        a1.addFlight(flight);
        td.writeToText("A.txt",a1);
    }


}
