package edu.pdx.cs410J.vibha2;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the {@link Flight} class.
 */
public class FlightTest {
  
@Test(expected = UnsupportedOperationException.class)
  public void getArrivalStringNeedsToBeImplemented() {
    Flight flight = new Flight("1");
  assertThat(flight.getArrivalString(), is(nullValue()));
  }
  @Test(expected = UnsupportedOperationException.class)
  public void getDepartureStringNeedsToBeImplemented() {
    Flight flight = new Flight("2");
    assertThat(flight.getDepartureString(), is(nullValue()));
}

  @Test(expected = UnsupportedOperationException.class)
  public void getDestinationNeedsToBeImplemented() {
    Flight flight = new Flight("3");
    assertThat(flight.getDestination(), is(nullValue()));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void getSourceNeedsToBeImplemented() {
    Flight flight = new Flight("4");
    assertThat(flight.getSource(), is(nullValue()));
  }

  @Test
  public void settersareworkingproperly() {
    Flight flight = new Flight("5");
    flight.setSource("JFK");
    flight.setDestination("PDX");
    flight.setArrival_time("1/21/2020","10:30");
    flight.setDeparture_time("1/20/2020","15:40");
    assertThat(flight.getNumber(),equalTo(5));
    assertThat(flight.getSource(),equalTo("JFK"));
    assertThat(flight.getDestination(),equalTo("PDX"));
    assertThat(flight.getArrivalString(),equalTo("1/21/2020 10:30"));
    assertThat(flight.getDepartureString(),equalTo("1/20/2020 15:40"));
  }

  @Test
  public void getairlineName(){
  Airline<Flight> a=new Airline<>("Alaska");
  assertThat(a.getName(),equalTo("Alaska"));
  }

  @Test
  public void getairlineFlights(){
    Airline<Flight> a=new Airline<>("Alaska");
    Flight f1=new Flight("101");
    a.addFlight(f1);
    assertThat(a.getFlights().size(),equalTo(1));
  }


  
}
