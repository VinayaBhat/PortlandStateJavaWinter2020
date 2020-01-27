package edu.pdx.cs410J.vibha2;

import org.junit.Rule;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the {@link Flight} class.
 */
public class FlightTest {
  /**
   * getArrivalStringNeedsToBeImplemented is used to test the scenario when ArrivalDateandTime is not set.
   */
  @Test(expected = UnsupportedOperationException.class)
  public void getArrivalStringNeedsToBeImplemented() {
    Flight flight = new Flight("1");
    assertThat(flight.getArrivalString(), is(nullValue()));
  }

  /**
   * getDepartureStringNeedsToBeImplemented is used to test the scenario when DepartureDateandTime is not set.
   */
  @Test(expected = UnsupportedOperationException.class)
  public void getDepartureStringNeedsToBeImplemented() {
    Flight flight = new Flight("2");
    assertThat(flight.getDepartureString(), is(nullValue()));
  }

  /**
   * getDestinationNeedsToBeImplemented is used to test the scenario when Destination is not set.
   */
  @Test(expected = UnsupportedOperationException.class)
  public void getDestinationNeedsToBeImplemented() {
    Flight flight = new Flight("3");
    assertThat(flight.getDestination(), is(nullValue()));
  }

  /**
   * getSourceNeedsToBeImplemented is used to test the scenario when Source is not set.
   */
  @Test(expected = UnsupportedOperationException.class)
  public void getSourceNeedsToBeImplemented() {
    Flight flight = new Flight("4");
    assertThat(flight.getSource(), is(nullValue()));
  }

  /**
   * settersareworkingproperly is used to test whether the setters are working as expected.
   */
  @Test
  public void settersareworkingproperly() {
    Flight flight = new Flight("5");
    flight.setSource("JFK");
    flight.setDestination("PDX");
    flight.setArrival_time("1/21/2020", "10:30");
    flight.setDeparture_time("1/20/2020", "15:40");
    assertThat(flight.getNumber(), equalTo(5));
    assertThat(flight.getSource(), equalTo("JFK"));
    assertThat(flight.getDestination(), equalTo("PDX"));
    assertThat(flight.getArrivalString(), equalTo("1/21/2020 10:30"));
    assertThat(flight.getDepartureString(), equalTo("1/20/2020 15:40"));
  }

  /**
   * getairlineName is used to test whether airline name is set properly.
   */
  @Test
  public void getairlineName() {
    Airline<Flight> a = new Airline<>("Alaska");
    String airlinename=a.getName();
    assertThat(airlinename, equalTo("Alaska"));
  }

  /**
   * getairlineFlights is used to test whether flights under the airline are added properly.
   */
  @Test
  public void getairlineFlights() {
    Airline<Flight> a = new Airline<>("Alaska");
    Flight f1 = new Flight("101");
    a.addFlight(f1);
    Collection flightlist=a.getFlights();
    assertThat(flightlist.size(), equalTo(1));
  }

  /**
   * wrongairlinename is used to test what happens when airline name is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void wrongairlinename() {
    Airline<Flight> a = new Airline<>("");
  }

  /**
   * wrongflightnumber is used to test what happens when alphabets are in flightnumber.
   */
  @Test(expected = IllegalArgumentException.class)
  public void wrongflightnumber() {
    Flight flight = new Flight("ss0");
  }

  /**
   * sourcenamedoesnotmatchspecification is used to test when src name is not a 3 letter word
   */
  @Test(expected = IllegalArgumentException.class)
  public void sourcenamedoesnotmatchspecification() {
    Flight flight = new Flight("1");
    flight.setSource("dallas");
  }

  /**
   * destinationnamesdoesnotmatchspecification is used to test when destination name is not a 3 letter word
   */
  @Test(expected = IllegalArgumentException.class)
  public void destinationnamesdoesnotmatchspecification() {
    Flight flight = new Flight("1");
    flight.setDestination("new jersey");
  }

  /**
   * arrivaldateoesnotmatchspecification is used to test when arrival date is not given in correct format.
   */
  @Test(expected = IllegalArgumentException.class)
  public void arrivaldateoesnotmatchspecification() {
    Flight flight = new Flight("1");
    flight.setArrival_time("21-1-2010", "10:30");
  }

  /**
   * arrivaltimeoesnotmatchspecification is used to test when arrival time is not given in correct format.
   */
  @Test(expected = Exception.class)
  public void arrivaltimeoesnotmatchspecification() {
    Flight flight = new Flight("1");
    flight.setArrival_time("1/21/2010", "10:30:60");
  }

  /**
   * departuredateoesnotmatchspecification is used to test when destination name is not a 3 letter word
   */
  @Test(expected = IllegalArgumentException.class)
  public void departuredateoesnotmatchspecification() {
    Flight flight = new Flight("1");
    flight.setDeparture_time("21-1-2010", "10:30");
  }

  /**
   * departuretimeoesnotmatchspecification is used to test when arrival time is not given in correct format.
   */
  @Test(expected = Exception.class)
  public void departuretimeoesnotmatchspecification() {
    Flight flight = new Flight("1");
    flight.setDeparture_time("1/21/2010", "10:30:60");
  }



}