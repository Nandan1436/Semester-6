package math;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.FileIO;

/**
 * The MyMath provides simple methods such as computing a factorial or finding
 * whether an integer is prime
 *
 * @author pandeliskirpoglou
 * @version 1.0
 * @since 2020-04-18
 */

public class ArrayOperations {

	/**
	 * Gets one integer and returns true if it is prime and false if it is not.
	 * 
	 * @param fileio   instance for reading a file
	 * @param filepath path for file that needs to be checked
	 * @param myMath   instance for checking whether a number is prime
	 * @return arrayOfPrimeNumbers the array of prime numbers that where in the file
	 */

	public int[] findPrimesInFile(FileIO fileio, String filepath, MyMath myMath) {
		try {
			int[] arrayOfNumbers = fileio.readFile(filepath);
			List<Integer> arrayOfPrimeNumbers = new ArrayList<>();
			for (int num : arrayOfNumbers) {
				try {
					if (myMath.isPrime(num)) {
						arrayOfPrimeNumbers.add(num);
					}
				} catch (IllegalArgumentException e) {
					// Skip invalid numbers (e.g. < 2)
				}
			}
			return arrayOfPrimeNumbers.stream().mapToInt(i -> i).toArray();
		} catch (IllegalArgumentException e) {
			// Handles empty file or file not found
			return new int[0];
		}
	}


}
