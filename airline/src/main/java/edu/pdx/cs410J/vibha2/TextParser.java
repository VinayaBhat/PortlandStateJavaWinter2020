package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.AirlineParser;
import edu.pdx.cs410J.ParserException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Text parser implements AirlineParser
 */
public class TextParser implements AirlineParser {
    BufferedReader br;
    String airlinename;
    AbstractAirline<Flight> airline;

    /**
     *parse() returns the airline read from the text file
     * @return Airline object
     */
    @Override
    public AbstractAirline parse() {
 return this.airline;
    }

    /**
     * validateData validates the flight data is correctly formatted
     * @param filepath is the path to the file
     */
    public void validateData(String filepath){
        List<Flight> flightsinfile=new ArrayList<>();

        try{
            File file= new File (filepath);
            if(file.exists()) {
                br = new BufferedReader(new FileReader(filepath));
                String line;

                while ((line = br.readLine()) != null) {
                    String[] airlineinfo = line.split(";");
                    if (airlineinfo.length != 6) {
                        throw new Exception("File has corrupt data");
                    }
                    if (airlinename == null) {
                        airlinename = airlineinfo[0];
                        airline = new Airline<>(airlinename);
                    } else {
                        if (!airlinename.equals(airlineinfo[0])) {
                            throw new Exception("Airline not present in file");
                        }
                    }
                    Flight flight = new Flight(airlineinfo[1]);
                    flight.setSource(airlineinfo[2]);
                    String[] datetime = airlineinfo[3].split(" ");
                    flight.setDeparture_time(datetime[0], datetime[1]);
                    flight.setDestination(airlineinfo[4]);
                    String[] datetime2 = airlineinfo[5].split(" ");
                    flight.setArrival_time(datetime2[0], datetime2[1]);
                    flightsinfile.add(flight);
                }
            }

        }catch (Exception e){
            System.err.println("Could not parse file "+e.getMessage());
            System.exit(1);
        }
    }


}
