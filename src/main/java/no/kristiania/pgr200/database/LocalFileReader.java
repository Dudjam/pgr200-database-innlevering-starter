package no.kristiania.pgr200.database;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LocalFileReader {

	public LocalFileReader() {
		
	}
	
	//Temporary .properties reader solution...
	/*public String readProperties() throws IOException{
		
		String dbUrl = "";
		File file = new File("innlevering.properties");
		
		try ( Scanner sc = new Scanner(file) ) {
		    dbUrl = sc.nextLine();
		}
		
		return dbUrl;
		
	}*/
}
