package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractAirline;
import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

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
        AbstractAirline<Flight> a1=tp.parse();
        assertThat(a1, is(nullValue()));
    }

    /**
     * Testing the dump functions which writes to text file
     */
    @Test
    public void testingtextdump() throws ParseException {
        TextDumper td=new TextDumper();
        Airline<Flight> a1=new Airline<>("Alaska");
        Flight flight = new Flight("5");
        flight.setSource("JFK");
        flight.setDestination("PDX");
        flight.setDeparture_time("1/20/2020", "11:40 am");
        flight.setArrival_time("1/21/2020", "10:30 am");
        a1.addFlight(flight);
        td.writeToText("file.txt",a1);

    }


}
