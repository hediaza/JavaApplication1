package javaapplication1;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author hernanchodiaz
 */
public class wf {
    public static void main( String[] args ) {
        String fileName = "/Users/hernanchodiaz/algoritmos_evo/JavaApplication1/student.csv";
        
        FileWriter fileWriter = null;
				
        try {
                fileWriter = new FileWriter(fileName);

                //Add a new line separator after the header
                fileWriter.append("\n");

                fileWriter.append(",");
                fileWriter.append("1");

                fileWriter.append(",");
                fileWriter.append("1");

                System.out.println("CSV file was created successfully !!!");

        } catch (IOException e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
        } finally {			
            try {
                    fileWriter.flush();
                    fileWriter.close();
            } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter !!!");
                    e.printStackTrace();
            }		
        }
        
        System.out.println("bye");  
    }
}
