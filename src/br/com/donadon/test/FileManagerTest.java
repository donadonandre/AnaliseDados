package br.com.donadon.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.donadon.io.DirectoryScan;
import br.com.donadon.io.FileManager;

public class FileManagerTest {
	
	DirectoryScan ds = new DirectoryScan();
	
	@Test
	void existsPaths() {
		Assert.assertEquals(true, ds.getFileManager().createDirectories());
	}
	
	@Test
	void testsTxt() {
		File file = new File( FileManager.getInDirectory() );
		
		boolean test = false;
		
		for (File f : file.listFiles() ) {
			if ( !f.isDirectory() && "txt".equalsIgnoreCase( ds.getFileExtension( f.getName() ) ) ) {
				test = testFileColumns(f);
				break;
			}
		}
		
		Assert.assertEquals(true, test);
	}

	@Test
	void testsId() {
		File file = new File( FileManager.getInDirectory() );
		
		boolean test = false;
		
		for (File f : file.listFiles() ) {
			if ( !f.isDirectory() && "txt".equalsIgnoreCase( ds.getFileExtension( f.getName() ) ) ) {
				test = testFileId(f);
				break;
			}
		}
		
		Assert.assertEquals(true, test);
	}
	
	@Test
	void scanInAndOutDirectory() {
		File dirIn = new File( FileManager.getInDirectory() );
		File dirOut = new File( FileManager.getOutDirectory() );
		
		List<String> txtsInDir = new ArrayList<String>();
		List<String> txtsOutDir = new ArrayList<String>();
		
		for (File f : dirIn.listFiles() ) {
			if ( "txt".equalsIgnoreCase( ds.getFileExtension( f.getName() ) ) ) {
				txtsInDir.add(f.getName());
			}
		}

		for (File f : dirOut.listFiles() ) {
			if ( "txt".equalsIgnoreCase( ds.getFileExtension( f.getName() ) ) ) {
				txtsOutDir.add(f.getName());
			}
		}
		
		Assert.assertEquals(txtsInDir , txtsOutDir );
	}
	
	/*
	 * PRIVATE FUNCTIONS
	 */
	private boolean testFileColumns(File file)  {
		Scanner scanner;
		boolean has4Columns = true;

		try {
			scanner = new Scanner(file, "UTF-8");
		
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if ( line.split("ç").length != 4 ) {
					has4Columns = false;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return has4Columns;
	}

	private boolean testFileId(File file)  {
		Scanner scanner;
		boolean ids = true;
		
		try {
			scanner = new Scanner(file, "UTF-8");
			
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				String id = line.split("ç")[0];
				
				if ( !( "001".equals(id) || "002".equals(id) || "003".equals(id) ) ) {
					ids = false;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return ids;
	}
	
	

}
