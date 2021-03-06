/**
 * Started by M. Moussavi
 * March 2015
 * Completed by: STUDENT(S) NAME
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.Serializable;

public class WriteRecord {

	ObjectOutputStream objectOut = null;
	MusicRecord record = null;
	Scanner stdin = null;
	Scanner textFileIn = null;

	/**
	 * Creates an blank MusicRecord object
	 */
	public WriteRecord() {
		record = new MusicRecord();
	}

	/**
	 * initializes the data fields of a record object
	 * @param year - year that song was purchased
	 * @param songName - name of the song
	 * @param singerName - singer's name
	 * @param price - CD price
	 */
	public void setRecord(int year, String songName, String singerName,
                                                                 double price) {
		record.setSongName(songName);
		record.setSingerName(singerName);
		record.setYear(year);
		record.setPrice(price);
	}
    
	/**
	 * Opens a file input stream, using the data field texFileIn
	 * @param textFileName name of text file to open
	 */
	public void openFileInputStream(String textFileName) {
        
		try {
			textFileIn = new Scanner(new File(textFileName));
		} catch (FileNotFoundException e) {
			System.err.println("Error opening file.");
		}
	}

	/**
	 * Opens an ObjectOutputStream using objectOut data field
	 * @param objectFileName name of the object file to be created
	 */
	public void openObjectOutputStream(String objectFileName) {
        
		try{
			objectOut = new ObjectOutputStream( new FileOutputStream(objectFileName));
		}
		catch ( IOException ioException )
		{
			System.err.println( "Error opening file." );
		}

	}
	
	/**
	 * Reads records from given text file, fills the blank MusicRecord
	 * created by the constructor with the existing data in the text
	 * file and serializes each record object into a binary file
	 */
	public void createObjectFile() {

		while (textFileIn.hasNext()) // loop until end of text file is reached
		{

			int year = Integer.parseInt(textFileIn.nextLine());
			System.out.print(year + "  ");       // echo data read from text file
            
			String songName = textFileIn.nextLine();
			System.out.print(songName + "  ");  // echo data read from text file
            
			String singerName = textFileIn.nextLine();
			System.out.print(singerName + "  "); // echo data read from text file
            
			double price = Double.parseDouble(textFileIn.nextLine());
			System.out.println(price + "  ");    // echo data read from text file
            
			textFileIn.nextLine();   // read the dashed lines and do nothing
			this.record = new MusicRecord(year, songName, singerName, price);

			try {
				objectOut.writeObject(record);
				objectOut.flush();
			} catch (IOException ioException) {
				System.err.println("Error writing to file.");
			} catch (NoSuchElementException elementException) {
				System.err.println("Invalid input. Please try again.");
			}
		}
		try { // Close the file
			if (objectOut != null)
				objectOut.close();
		} catch (IOException ioException) {
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}

	public static void main(String[] args) throws IOException {
        
		WriteRecord d = new WriteRecord();
        
		String textFileName = "someSongs.txt"; // Name of a text file that contains
                                               // song records
        
		String objectFileName = "mySongs.ser"; // Name of the binary file to
                                               // serialize record objects
        
		d.openFileInputStream(textFileName);   // open the text file to read from
        
		d.openObjectOutputStream(objectFileName); // open the object file to
                                                  // write music recosds into it
        
		d.createObjectFile();   // read records from opened text file, and write
                                // them into the object file.
	}
}
