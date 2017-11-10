package Controller;

/**
 * This static class creates and writes a log file
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

/** 
 * @author Java Summer 2018
 * 
 */
public final class Logger{
	
	/** An output file */
	static private File outputLogFile;
	static private long latestMessage;
	
	/** A file writer buffer */
	static private FileWriter writer; 
	
	/**
	 * Creates a file and a writer for logging
	 */
	public static void initializeMyFileWriter(){
		outputLogFile = new File("output.txt");
		try {
			writer = new FileWriter(outputLogFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Writes given text message to the log file.
	 * @param message The text to be written in the log
	 * @param isSeparatorNeeded True if seperator is needed
	 */
	
	public static void log(String message){
		Logger.log(message, false);
	}
	
	public static void log(String message, boolean isSeparatorNeeded){
		try {
			Date dateNow = new Date();
			SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss"); 
			String dateprefix = dt.format(dateNow);
			

			if(latestMessage > 0 && System.currentTimeMillis() - latestMessage > 5000)
				writeAsteriskSeparatorToLogFile();
			
			latestMessage = System.currentTimeMillis();
			
			writer.write(dateprefix+"\t"+message+"\n");
			System.out.println(dateprefix+"\t"+message+"\n");

			writer.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Writes separator to log file.
	 */
	public static void writeHyphenSeparatorToLogFile(){
		try {
			writer.write("\n-----------------------------------------------------------------------------");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes separator to log file.
	 */
	public static void writeAsteriskSeparatorToLogFile(){
		try {
			writer.write("****************************************************************************\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves the log file (by closing the file writer).
	 */
	public static void saveLogFile(){
		try {
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
