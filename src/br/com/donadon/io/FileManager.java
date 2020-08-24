package br.com.donadon.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
	
	public boolean createDirectories() {
		Path path = Paths.get( String.valueOf( File.separatorChar ), System.getProperty("user.home"), "data" );
		
		try {
			if ( Files.notExists(path) ) {
					Files.createDirectory(path);
			}
			
			path = Paths.get( getInDirectory() );
			
			if ( Files.notExists(path) ) {
				Files.createDirectory(path);
			}
	
			path = Paths.get( getOutDirectory() );
			
			if ( Files.notExists(path) ) {
				Files.createDirectory(path);
			}
			
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String getInDirectory() {
		return String.join( String.valueOf( File.separatorChar ), System.getProperty("user.home"), "data", "in" );
	}
	
	public static String getOutDirectory() {
		return String.join( String.valueOf( File.separatorChar ), System.getProperty("user.home"), "data", "out" );
	}
	
	
}
