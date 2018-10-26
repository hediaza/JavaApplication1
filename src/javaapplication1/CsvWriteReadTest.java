/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author hernanchodiaz
 */
public class CsvWriteReadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String fileName = System.getProperty("user.home")+"/student.csv";
		
		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);

	}

}
