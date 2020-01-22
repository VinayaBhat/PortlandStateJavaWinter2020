package edu.pdx.cs410J.vibha2;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * An integration test for the {@link Project1} main class.
 */
public class Project1IT extends InvokeMainTestCase {

    /**
     * Invokes the main method of {@link Project1} with the given arguments.
     */
    private MainMethodResult invokeMain(String... args) {
        return invokeMain( Project1.class, args );
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
     * Test with only -print option
     */
  @Test
    public void testwithargumentsprint(){
      String[] args={"-print","Alaska","101","jfk","1/21/2000","10:30","dal","1/22/2000","11:30"};
        MainMethodResult result = invokeMain(args);
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
     * Test with readme and print
     */
    @Test
    public void testwithargumentsreadmeandprint(){
        String[] args={"-README","-print","Alaska","101","jfk","1/21/2000","10:30","dal","1/22/2000","11:30"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * Test with print and readme
     */
    @Test
    public void testwithargumentprintandreadme(){
        String[] args={"-print","-README","Alaska","101","jfk","1/21/2000","10:30","dal","1/22/2000","11:30"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * Testw ith no options
     */
    @Test
    public void testwithnooptions(){
        String[] args={"Alaska","101","jfk","1/21/2000","10:30","dal","1/22/2000","11:30"};
        MainMethodResult result = invokeMain(args);
    }

    /**
     * Test without  enough arguments
     */
    @Test
    public void testwithlessargument(){
        String[] args={"Alaska","101","","1/21/2000","10:30","dal","1/22/2000","11:30"};
        MainMethodResult result = invokeMain(args);
        assertThat(result.getExitCode(), equalTo(1));
        assertThat(result.getTextWrittenToStandardError(), containsString("Flight source is not set properly"));
        }

    /**
     * Test with only readme.
     */
    @Test
    public void testwithonylreadme() {
        String[] args = {"-README"};
        MainMethodResult result = invokeMain(args);
    }
}