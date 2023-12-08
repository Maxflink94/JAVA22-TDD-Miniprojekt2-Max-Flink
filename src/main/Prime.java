package main;

import java.util.ArrayList;
import java.util.List;

/**
 * This program counts the sum and the number of prime (int) numbers in interval
 * 0-1000
 */
public class Prime {

	private List<Integer> primes;
	private int count = 0;
	private int sumOfPrimes = 0;

	public Prime(int firstNumber, int lastNumber) {
		primes = new ArrayList<>();
		if(isValidRange(firstNumber, lastNumber)) {
			calculatePrimes(firstNumber, lastNumber);
		} else {
			System.out.println("Hoppsan, felaktigt intervall angivet!");
		}
	}
	
	private boolean isValidRange(int firstNumber, int lastNumber) {
		return firstNumber >= 0 && firstNumber <= 1000 && lastNumber >= 0 && lastNumber <= 1000 && firstNumber <= lastNumber;
	}

	private boolean numIsPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	private void calculatePrimes(int firstNumber, int lastNumber) {
		for (int current = firstNumber; current <= lastNumber; current++ ) {
			if(numIsPrime(current)) {
				primes.add(current);
				count++;
				sumOfPrimes += current;
			}
		}
	}
	
	public List<Integer> getPrimes(){
		return primes;
	}
	
	public int getCount() {
        return count;
    }

	public int getSumOfPrimes() {
		return sumOfPrimes;
	}
	
	public void printCount() {
        System.out.println("Hej, det finns " + getCount() + " primtal mellan 0 och 1000!");
    }
	
	public void printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + getSumOfPrimes() + ".");
    }

//	public static void main(String[] args) {
//		Prime prime = new Prime(1, 10);
//		prime.printCount();
//		prime.printSum();
//		System.out.println("Listan av alla primtalen: " + prime.getPrimes());
//	}
}
