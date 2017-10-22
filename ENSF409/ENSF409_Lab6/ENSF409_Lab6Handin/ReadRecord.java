/** 
 * Started by M. Moussavi
 * March 2015
 * Completed by: STUDENT(S) NAME
 */

import java.io.EOFException;
import java.lang.ClassNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ReadRecord {

    private ObjectInputStream input;
    
    /**
     *  opens an ObjectInputStream using a FileInputStream
     */
    
    private void readObjectsFromFile(String name)
    {
        
        try
        {
            input = new ObjectInputStream(new FileInputStream( name ) );
        }
        catch ( IOException ioException )
        {
            System.err.println( "Error opening file." );
        }
        
        /* The following loop is supposed to use readObject method of of
         * ObjectInputSteam to read a MusicRecord object from a binary file that
         * contains several reords.
         * Loop should terminate when an EOFException is thrown.
         */
        try
        {
            while ( true )
            {
                MusicRecord record = (MusicRecord)input.readObject();
                System.out.println(record.getYear()+"  "+record.getSongName()+"  "+record.getSingerName()+"  "+record.getPurchasePrice());         
            }
              
        }
        catch (EOFException e) {
        }
        catch (ClassNotFoundException c){
            System.err.println("Error reading file. ClassNotFoundException");
        }
        catch (IOException i){
            System.err.println("Error reading file. IOException");
        }
    }
    
    
    public static void main(String [] args)
    {
        ReadRecord d = new ReadRecord();
        d.readObjectsFromFile("allSongs.ser");
    }
}