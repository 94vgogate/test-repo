package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileParser {
	
	private static final Logger LOGGER = Logger.getLogger(FileParser.class.getName());
	
	/** Checks if a list contains two numbers that sum to zero
	 * 
	 * @param nums the list of integers
	 * @return true if the list contains two numbers that sum to zero
	 */
	public static boolean containsSumZeroes(List<Integer> nums){
		int len = nums.size();
		if (len<=1){
			return false;
		}
		for (int i=0; i<len; i++){
			for (int j=i+1; j<len; j++){
				if (nums.get(i) + nums.get(j) == 0){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main (String [] args) throws FileNotFoundException{
		 if (args.length==0){
			 System.out.println("Please pass in a file path");
			 System.exit(0);
		 }
		 
		 String path = args[0];
		 File file = new File(path);
		 BufferedReader br = new BufferedReader(new FileReader(file)); 
		 String num;
		 ArrayList <Integer> nums = new ArrayList<Integer>();
		 try {
			while ((num = br.readLine()) != null) {
				nums.add(Integer.valueOf(num));
			}
		 }
		 catch (NumberFormatException e){
		    LOGGER.log(Level.SEVERE, "Error. Input file must contain integers only. Exiting...");
		    System.exit(1);
		 }
		 catch (IOException e) {
			LOGGER.log(Level.SEVERE, "An error occurred while processing the file:", e);
			System.exit(1);
		 } 
		 LOGGER.info("File processing complete. Computing results for input: " + nums);
		 LOGGER.info("Result is: " + containsSumZeroes(nums));
	}
}