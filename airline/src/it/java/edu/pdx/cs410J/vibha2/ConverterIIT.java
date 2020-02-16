package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class ConverterIIT  extends InvokeMainTestCase {
    /**
     * Invokes the main method of {@link Converter} with the given arguments.
     */
    private InvokeMainTestCase.MainMethodResult invokeMain(String... args) {
        return invokeMain(Converter.class, args);
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testNoCommandLineArguments() {
        InvokeMainTestCase.MainMethodResult result = invokeMain();
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments for Converter"));
    }

    /**
     * Tests that invoking the main method with less arguments issues an error
     */
    @Test
    public void testLessCommandLineArguments() {
        String[] args={"vinayaiitconvertertextfile.txt"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
       assertThat(result.getTextWrittenToStandardError(), containsString("Insufficient command line arguments for Converter"));
    }

    /**
     * Tests that invoking the main method with more arguments issues an error
     */
    @Test
    public void testMoreCommandLineArguments() {
        String[] args={"A.txt","B.txt","C.txt"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Extra command line arguments for Converter"));
    }

    /**
     * Tests that invoking the main method with two arguments issues an error
     */
    @Test
    public void testTwoCommandLineArguments() {
        String[] args={"vinayaiittextfile.txt","vinayaiitxmlfile.xml"};
        Airline<Flight> airline=new Airline<>("Alaska");
        Flight flight = new Flight("5");
        flight.setSource("JFK");
        flight.setDestination("PDX");
        flight.setXmldeparture("1/20/2020 11:30");
        flight.setXmlarrival("1/21/2020 10:30");
        TextDumper td=new TextDumper();
        td.writeToText("vinayaiittextfile.txt",airline);

        MainMethodResult result = invokeMain(args);

    }
}
