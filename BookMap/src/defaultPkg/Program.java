package defaultPkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Gets the frequency for words in a book
 * @author s-mroe
 *
 */

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		Scanner bookScan = openBook(console);
		//make a map to store each word frequency
		Map<String, Integer> bookMap = new TreeMap<String, Integer>();
		
		//read each line of the book
		while(bookScan.hasNextLine()) {
			String line = bookScan.nextLine();
			line = formatWord(line);
			//make a scanner of the current line
			Scanner lineScan = new Scanner(line);
			while(lineScan.hasNext()) {
				//read it word by word
				String w = lineScan.next();
				//is this word already in the map?
				if(bookMap.containsKey(w)) {
					//if so add one to the occurrence
					int curVal = bookMap.get(w);
					bookMap.put(w, curVal + 1);
				} else { 
					//otherwise add to the map with one occurrence
					bookMap.put(w, 1);
				}
				
			}
			lineScan.close();
			//read it word by word
			
		}
		bookScan.close();
		console.close();

	}
	
	/**
	 * Retirms a scanner to a book
	 * @param console
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public static Scanner openBook(Scanner console) throws FileNotFoundException {
		System.out.print("Give me the book file name");
		File f = new File(console.nextLine());
		Scanner s = new Scanner(f);
		return s;
	}
	
	/**
	 * Strips punctuation from our words
	 * @param s
	 * @return
	 */
	public static String formatWord(String line) {
		line = line.toLowerCase();
		//converts the line to easily readable words
		line = line.replace('!', ' ');
		line = line.replace(',', ' ');
		line = line.replace('.', ' ');
		line = line.replace(';', ' ');
		line = line.replace('?', ' ');
		line = line.replace('(', ' ');
		line = line.replace(')', ' ');
		line = line.replace(':', ' ');
		return line;
	}

}
