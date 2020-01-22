package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractFlight;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Flight is a class which extends AbstractFlight.
 */
public class Flight extends AbstractFlight {
    //properties

    int flight_number;
    String source;
    String destination;
    String arrival_time;
    String departure_time;

    //constructor

    /**
     * Flight constructor allows us to initialize the Flight object. The flight constructor calls the flightnumberisvalid
     * function to check if the flightnumber is valid integer.
     *
     * @param flightNumber is String
     */
    public Flight(String flightNumber) {
        if (flightnumberisvalid(flightNumber)) {
            this.flight_number = Integer.parseInt(flightNumber);
        } else {
            throw new IllegalArgumentException("Flight number is not set properly");
        }
    }

    //Setters

    /**
     * setSource is a setter function to set the flight source property.
     *
     * @param source is a String
     */
    public void setSource(String source) {
        if (flightsrcdestisvalid(source)) {
            this.source = source;
        } else {
            throw new IllegalArgumentException("Flight source is not set properly");

        }
    }

    /**
     * setDestination is a setter function to set the flight destination property.
     *
     * @param destination is a String
     */
    public void setDestination(String destination) {
        if (flightsrcdestisvalid(destination)) {
            this.destination = destination;
        } else {
            throw new IllegalArgumentException("Flight destination is not set properly");

        }
    }

    /**
     * setArrival_time is a setter function to set the arrival date and time of the flight.date is in the format MM/dd/yyy and time HH:mm.
     *
     * @param arrivalDate is a String
     * @param arrivalTime is a String.
     */
    public void setArrival_time(String arrivalDate, String arrivalTime) {
        if (checkdateandtime("Arrival", arrivalDate, arrivalTime))
            this.arrival_time = arrivalDate + " " + arrivalTime;
    }

    /**
     * setDeparture_time is a setter function to set the departure date and time of the flight.date is in the format MM/dd/yyy and time HH:mm.
     *
     * @param departureDate is a String
     * @param departureTime is a String
     */
    public void setDeparture_time(String departureDate, String departureTime) {
        if (checkdateandtime("Departure", departureDate, departureTime)) {
            this.departure_time = departureDate + " " + departureTime;
        }
    }

    /**
     * getNumber is a getter function inherited from AbstractFlight.
     *
     * @return int flightnumber.
     */
    @Override
    public int getNumber() {
        return this.flight_number;
    }

    /**
     * getSource is a getter function inherited from AbstractFlight.
     *
     * @return String source
     * @throws UnsupportedOperationException if the flight source is null
     */
    @Override
    public String getSource() {
        if (source == null) {
            throw new UnsupportedOperationException("Source not set");

        }
        return this.source;
    }

    /**
     * getDepartureString is a getter function inherited from Abstract flight.
     *
     * @return String departure date datetime
     * @throws UnsupportedOperationException if the departure date and time is null
     */
    @Override
    public String getDepartureString() {
        if (departure_time == null) {
            throw new UnsupportedOperationException("Departure Date and Time not set");
        }
        return this.departure_time;
    }

    /**
     * getDestination is a getter method inherited from the AbstractFlight.
     *
     * @return String destination
     * @throws UnsupportedOperationException is destination is null
     */
    @Override
    public String getDestination() {
        if (destination == null) {
            throw new UnsupportedOperationException("Destination not set");

        }
        return this.destination;
    }

    /**
     * getArrivalString is a getter method inherited from AbstractFlight.
     *
     * @return String arrival datetime
     * @throws UnsupportedOperationException if arrival date or time is null
     */
    @Override
    public String getArrivalString() {
        if (arrival_time == null) {
            throw new UnsupportedOperationException("Arrival Date and Time not set");

        }
        return this.arrival_time;
    }

    /**
     * flightsrcdestisvalid checks if the source or destination String is a 3 letter word and contains only alphabets.
     *
     * @param flightinfo is the source or destination string
     * @return boolean
     */
    private static boolean flightsrcdestisvalid(String flightinfo) {
        if (flightinfo.matches("^[a-zA-Z]*$") && flightinfo.length() == 3) {
            return true;
        }
        return false;
    }

    /**
     * flightnumberisvalid checks if the flight number contains only numeric characters.
     *
     * @param flightnumber is the flight number given during Flight initialization
     * @return boolean
     */
    private static boolean flightnumberisvalid(String flightnumber) {
        String regex = "[0-9]+";
        return flightnumber.matches(regex);
    }

    /**
     * checkdateandtime checks whether the date is in the format MM/dd/yyy and time HH:mm.
     *
     * @param sd   String can either be "arrival" or "departure"
     * @param date in the format MM/dd/yyy
     * @param time in the format HH:mm
     * @return boolean
     * @throws IllegalArgumentException if date and time are not proper
     */
    private static boolean checkdateandtime(String sd, String date, String time) {

        String dateregex = "^(1[0-2]|0[1-9]|[1-9])/(3[01]|[12][0-9]|0[1-9]|[1-9])/[0-9]{4}$";
        Pattern pattern1 = Pattern.compile(dateregex);
        Matcher matcher1 = pattern1.matcher(date);
        boolean correctdate = matcher1.matches();
        if (!correctdate) {
            throw new IllegalArgumentException(sd + " date not set properly");
        }
        try {
            LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            throw new IllegalArgumentException(sd + " time not set properly");
        }
        return true;
    }


}
