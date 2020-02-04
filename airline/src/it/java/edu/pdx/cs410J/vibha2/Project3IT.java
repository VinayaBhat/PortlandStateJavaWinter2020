package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * To test Project2
 */
public class Project3IT extends InvokeMainTestCase {
    /**
     * Invokes the main method of {@link Project3} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project3.class, args );
    }

    /**
     * Tests that invoking the main method with no arguments issues an error
     */
    @Test
    public void testNoCommandLineArguments() {
        MainMethodResult result = invokeMain();
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Missing command line arguments"));
    }
    /**
     * Test with only -readme option
     */
    @Test
    public void testwithargumentsreadme(){
        String[] args={"-README","Alaska","101","jfk","1/21/2000","10:30","dal","1/22/2000","11:30"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * Test with less arguments
     */
    @Test
    public void testwithlessarg() {
        String[] args = {"Alaska","103","AUS","1/21/2020","10:30","am","BUR","1/21/2020","10:30"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Insufficient command line arguments"));
    }

    /**
     * test with pretty option and less arguments
     */
    @Test
    public void testwithprintlessarg() {
        String[] args = {"-pretty","-","Alaska","103","AUS","1/21/2020","10:30","am","BUR","1/21/2020","10:30"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Number of arguments not correct to populate flight information"));
    }

    /**
     * Test with textfile
     */
    @Test
    public void testwithtextfile(){
        String[] args={"-textFile","ittestfile.txt","Alaska","101","BZE","1/21/2000","10:30","am","CCS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * test with pretty and textFile option
     */
    @Test
    public void testwithtextfileandprintstdout(){
        String[] args={"-textFile","ittestfile.txt","-pretty","-","Alaska","101","ABE","1/21/2000","10:30","am","CCS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * test with pretty file and textFile option
     */
    @Test
    public void testwithtextfileandprintstotext(){
        String[] args={"-textFile","ittestfile.txt","-pretty","prettyprint.txt","Alaska","101","ABQ","1/21/2000","10:30","am","CCS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * test for invalid source code
     */
    @Test
    public void invalidsourcecode(){
        String[] args={"-textFile","ittestfile.txt","-pretty","prettyprint.txt","Alaska","101","hii","1/21/2000","10:30","am","CCS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Source airport code is invalid"));
    }

    /**
     *
     * test with invalid destination code
     */
    @Test
    public void invaliddestcode(){
        String[] args={"-textFile","ittestfile.txt","-pretty","prettyprint.txt","Alaska","101","CCS","1/21/2000","10:30","am","hii","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Destination airport code not valid"));
    }

    /**
     * test with invalid departure date
     */
    @Test
    public void invaliddepdate(){
        String[] args={"-textFile","ittestfile.txt","-pretty","prettyprint.txt","Alaska","101","CCS","1/21/XXXX","10:30","am","AMA","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Departure Date not set properly"));
    }

    /**
     * test with invalid departure time
     */

    @Test
    public void invaliddeptime(){
        String[] args={"-textFile","ittestfile.txt","-pretty","prettyprint.txt","Alaska","101","CCS","1/21/2000","10:XX","am","AMA","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Departure Date not set properly"));
    }

    /**
     * test with invalid arrival date
     */
    @Test
    public void invalidarrdate(){
        String[] args={"-textFile","ittestfile.txt","-pretty","prettyprint.txt","Alaska","101","CCS","1/21/2000","10:30","am","AMA","1/22/XXXX","11:30","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Error while checking setting arrival time Arrival date not set properly"));
    }

    /**
     * test with invalid arrival time
     */
    @Test
    public void invalidarrtime(){
        String[] args={"-textFile","ittestfile.txt","-pretty","prettyprint.txt","Alaska","101","CCS","1/21/2000","10:30","am","AMA","1/22/2000","11:XX","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Error while checking setting arrival time Arrival time not set properly"));
    }

    /**
     * Test with readme and print
     */
    @Test
    public void testwithargumentsreadmeandprint(){
        String[] args={"-README","-print","Alaska","101","jfk","1/21/2000","10:30","am","AUS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * Test with print and readme
     */
    @Test
    public void testwithargumentprintandreadme(){
        String[] args={"-print","-README","Alaska","101","jfk","1/21/2000","10:30","am","AUS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * Testw ith no options
     */
    @Test
    public void testwithnooptions(){
        String[] args={"Alaska","101","jfk","1/21/2000","10:30","am","AUS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * Test without  enough arguments
     */
    @Test
    public void testwithlessargument(){
        String[] args={"Alaska","101","","1/21/2000","10:30","am","AUS","1/22/2000","11:30","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Source airport code is invalid"));
    }


    /**
     * Test with only readme.
     */
    @Test
    public void testwithunknownoption() {
        String[] args = {"-hello"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Unknown command line option"));
    }

    /**
     * Test with only extra commandline arguments.
     */
    @Test
    public void testwithextracmdlinearg() {
        String[] args = {"Alaska","103","AUS","1/21/2020","10:30","am","BUR","1/21/2020","10:30","pm","hi"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Extra unknown command line arguments"));
    }

    /**
     * Test with only extra unknown option commandline arguments.
     */
    @Test
    public void testwithunknownoptionandarg() {
        String[] args = {"-hello","Alaska","103","AUS","1/21/2020","10:30","am","BUR","1/21/2020","10:30","pm"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Unknown command line option"));
    }

    /**
     * Test with only with -textFile
     */
    @Test
    public void testwithtextFile() {
        String[] args = {"-textFile","ittestfile.txt","Alaska","103","AUS","1/21/2020","10:30","am","BUR","1/21/2020","10:30","pm"};
        MainMethodResult result = invokeMain(args);

    }
    /**
     * Test with only with -textFile with less options
     */
    @Test
    public void testwithtextFileandlessoptions() {
        String[] args = {"-textFile","ittestfile.txt","Alaska","103","AUS","1/21/2020","10:30","am","BUR","1/21/2020"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Number of arguments to populate flight information not correct"));

    }

    /**
     * Test with only with -textFile and print
     */
    @Test
    public void testwithtextFileandprint() {
        String[] args = {"-textFile","ittestfile.txt","-print","Alaska","103","AUS","1/21/2020","10:30","am","BUR","1/21/2020","10:30","pm"};
        MainMethodResult result = invokeMain(args);

    }





}
