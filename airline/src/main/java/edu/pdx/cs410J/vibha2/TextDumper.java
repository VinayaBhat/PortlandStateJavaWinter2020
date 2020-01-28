package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.AirlineDumper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * TextDumper implements AirlineDumper
 */
public class TextDumper<T extends AbstractAirline> implements AirlineDumper<T>{
    FileWriter writer;

    /**
     *dump writes to text file
     * @param abstractAirline airline to write to the file
     *
     */
    @Override
    public void dump(AbstractAirline abstractAirline){
        try{
        String airlinename=abstractAirline.getName();
        Collection<Flight> flight=abstractAirline.getFlights();
        for(Flight flightinfo:flight){
            int flightnum=flightinfo.getNumber();
            String src=flightinfo.getSource();
            String dest=flightinfo.getDestination();
            String arrival_time=flightinfo.getArrivalString();
            String departure_time=flightinfo.getDepartureString();
            writer.write(airlinename+";"+flightnum+";"+src+";"+departure_time+";"+dest+";"+arrival_time+System.getProperty("line.separator"));
        }
     writer.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * writetotext creates or opens a file before validating and dumping data to file.
     * @param filePath path to text file
     * @param abstractAirline airline to write to file
     */
    public void writeToText(String filePath,AbstractAirline abstractAirline){
        try{

            TextParser td=new TextParser();
            td.validateData(filePath);
            AbstractAirline<Flight> fileairline=td.parse();
            if(fileairline!=null && !fileairline.getName().equals(abstractAirline.getName())){
                throw new Exception("Airline name not found in file");
            }
            File file= new File (filePath);
            if (file.exists())
            {
                writer= new FileWriter(file,true);//if file exists append to file. Works fine.
                System.out.println("Writing to an existing file  "+file.getAbsoluteFile());
            }
            else
            {
                file.createNewFile();
                writer = new FileWriter(file);
                System.out.println("A new file created  "+file.getAbsoluteFile());


            }

            dump(abstractAirline);
        }catch (Exception e){
            System.err.println("Error occured in TextDumper "+e.getMessage());
            System.exit(1);
        }
    }
}
