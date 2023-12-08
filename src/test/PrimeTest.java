package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Prime;

class PrimeTest {
	
	private Prime prime;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
    }
    
    @DisplayName("Testing the Prime-constructor and the getPrimes method")
    @Test
    public void testConstructorAndGetPrimes() {
    	prime = new Prime(1, 10);
        List<Integer> primes = prime.getPrimes();

        assertNotNull(primes);
        assertEquals(List.of(2, 3, 5, 7), primes);
    }
    
    @DisplayName("Testing an invalid interval of numbers")
    @Test
    public void testInvalidInterval() {
    	prime = new Prime(5, 1);
        List<Integer> primes = prime.getPrimes();

        
        assertNotNull(primes);
        assertEquals(List.of(), primes);
    }
    
    @DisplayName("Testing the smallest possible interval")
    @Test
    public void testSmallestInterval() {
    	prime = new Prime(0, 1);
        List<Integer> primes = prime.getPrimes();

        
        assertNotNull(primes);
        assertEquals(List.of(), primes);
    }
    
    @DisplayName("Testing the largest possible interval")
    @Test
    public void testLargestInterval() {
    	prime = new Prime(0, 1000);
        List<Integer> primes = prime.getPrimes();

        assertNotNull(primes);
        assertEquals(76127, prime.getSumOfPrimes());
    }
    
    @DisplayName("Test for specific prime numbers")
    @Test
    public void testSpecificPrimes() {
    	prime = new Prime(1, 20);
        List<Integer> primes = prime.getPrimes();

        
        assertNotNull(primes);
        assertTrue(primes.contains(2));
        assertTrue(primes.contains(3));
        assertTrue(primes.contains(5));
        assertFalse(primes.contains(4));
    }
    
    @DisplayName("Test for numbers that are not prime numbers")
    @Test
    public void testNonPrimes() {
    	prime = new Prime(21, 25);
        List<Integer> primes = prime.getPrimes();

        
        assertNotNull(primes);
        assertFalse(primes.contains(22));
        assertFalse(primes.contains(24));
    }
    
    @DisplayName("Testing negative interval values")
    @Test
    public void testNegativeInterval() {
        prime = new Prime(-10, 10);
        List<Integer> primes = prime.getPrimes();

        assertNotNull(primes);
        assertEquals(List.of(), primes);
    }
    
    @DisplayName("Testing zero interval")
    @Test
    public void testZeroInterval() {
        prime = new Prime(0, 0);
        List<Integer> primes = prime.getPrimes();

        assertNotNull(primes);
        assertEquals(List.of(), primes);
    }
    
    @DisplayName("Testing values larger than 1000")
    @Test
    public void testValuesLargerThan1000() {
        prime = new Prime(1001, 2000);
        List<Integer> primes = prime.getPrimes();

        assertNotNull(primes);
        assertEquals(List.of(), primes);
    }
    

    @DisplayName("Testing getCount method")
    @Test
    public void testGetCount() {
        prime = new Prime(1, 10);

        int countOfPrimes = prime.getCount();

        assertEquals(4, countOfPrimes);
    }
    
    @DisplayName("Testing printCount method")
    @Test
    public void testPrintCount() {
        prime = new Prime(1, 10);
        
        prime.printCount();

        assertEquals("Hej, det finns 4 primtal mellan 0 och 1000!\n", outContent.toString());
    }
    
    @DisplayName("Testing printSum method")
    @Test
    public void testPrintSum() {
        prime = new Prime(1, 10);
        
        prime.printSum();

        assertEquals("Och den totala summan av dessa primtal är 17.\n", outContent.toString());
    }

}
