package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.AbstractFlight;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Airline<T extends AbstractFlight> extends AbstractAirline<T>{
    //Properties of Airline
    String airline_name;
    List<AbstractFlight> flights=new ArrayList<>();

    //Airline constructor
    public Airline(String name){
        if(name.length()!=0){
        this.airline_name=name;}
        else {
            throw new IllegalArgumentException("Airline name is not set");
        }
    }

    @Override
    public String getName() {
        return this.airline_name;
    }

    @Override
    public void addFlight(AbstractFlight abstractFlight) {
        flights.add(abstractFlight);
    }

    @Override
    public Collection getFlights() {
        return flights;
    }

}
