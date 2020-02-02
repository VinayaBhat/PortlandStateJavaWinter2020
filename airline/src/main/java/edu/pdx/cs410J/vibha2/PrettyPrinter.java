package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.AirlineDumper;

import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * PrettyPrinter prints airline information to text file or stdout
 */
public class PrettyPrinter implements AirlineDumper<AbstractAirline> {
    FileWriter writer;
    Airline<Flight> airline;

    /**
     * PrettyPrinter constructor for printing to text file
     * @param filepath path of prettyprint file
     * @param textfilepath path of textfile
     * @param airline1 input airline
     */
    public PrettyPrinter(String filepath,String textfilepath,Airline airline1){
        try{
        File file= new File (filepath);
        if (file.exists())
        {
            writer= new FileWriter(file,true);//if file exists append to file. Works fine.
            System.out.println("Writing to an pretty print existing file  "+file.getAbsoluteFile());
        }
        else
        {
            file.createNewFile();
            writer = new FileWriter(file);
            System.out.println("A new pretty print file created  "+file.getAbsoluteFile());


        ;}

            TextParser tp=new TextParser();
            List<Flight> flights=tp.validateData(textfilepath);
            airline=airline1;
            Collections.sort(flights);
            for(Flight f:flights){
                airline.addFlight(f);
            }
            dump(airline);


        }catch (Exception e){
            System.err.println("Pretty print file error "+e.getMessage());
            System.exit(1);
        }


    }

    /**
     * PrettyPrinter prints to stdout
     * @param textfilepath path of textFile
     * @param airline1 input airline
     */
    public PrettyPrinter(String textfilepath,Airline airline1){
        TextParser tp=new TextParser();
        List<Flight> flights=tp.validateData(textfilepath);
        String airlinename=airline1.getName();
        Airline<Flight> airline=new Airline<>(airlinename);
        if(flights.size()!=0) {
            Collections.sort(flights);
            for (Flight f : flights) {
                System.out.println(airline.AirlinetoString(f));
            }
        }
    }

    /**
     * dump airline information to pretty print file
     * @param abstractAirline input airline information
     */
    @Override
    public void dump(AbstractAirline abstractAirline) {
        try{
            Airline a1=new Airline(abstractAirline.getName());
            Collection<Flight> flight=abstractAirline.getFlights();
            for(Flight f:flight){
                writer.append(a1.AirlinetoString(f)+System.lineSeparator());
            }
            writer.close();
        }catch (Exception e){
            System.err.println("Not able to write to pretty print file "+e.getMessage());
            System.exit(1);
        }

    }




}
