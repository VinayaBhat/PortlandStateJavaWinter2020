package edu.pdx.cs410J.vibha2;
import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.AbstractFlight;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Airline class inherits methods from AbstractAirline class.
 * @param <T> parameterized input
 */
public class Airline<T extends AbstractFlight> extends AbstractAirline<T>{
    //Properties of Airline
    String airline_name;
    List<AbstractFlight> flights=new ArrayList<>();

    /**
     * Airline constructor takes the airline name and initializes Airline object.
     * @param name is a String.
     * @throws IllegalArgumentException if the name is of length 0
     */
    //Airline constructor
    public Airline(String name){
        if(name.length()!=0){
        this.airline_name=name;}
        else {
            throw new IllegalArgumentException("Airline name is not set");
        }
    }

    /**
     * getName is the a getter function inherited from AbstractAirline.
     * @return airline name.
     */
    @Override
    public String getName() {
        return this.airline_name;
    }

    /**
     * addFlight is a setter function inherited from AbstractFlight. It adds the Flight object to the list of flights under the airline.
     * @param abstractFlight is Flight object
     */
    @Override
    public void addFlight(AbstractFlight abstractFlight) {
        flights.add(abstractFlight);
    }

    /**
     * getFlights is a getter function inherited from the AbstractAirline.
     * @return collection (ArrayList) of all flights under the airline.
     */
    @Override
    public Collection getFlights() {
        return flights;
    }

}
