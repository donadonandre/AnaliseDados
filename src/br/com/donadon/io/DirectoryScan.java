package br.com.donadon.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.com.donadon.process.DataProcessing;

public class DirectoryScan {

	private List<String> filesNames;
	private FileManager fm;
	
	public DirectoryScan() {
		filesNames = new ArrayList<>();
		
		fm = new FileManager();
		
		fm.createDirectories();
	}
	
	public FileManager getFileManager() {
		return this.fm;
	}
	
	public void monitoring() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				scanDir();
			}
		}, 0, 3000);
	}
	
	private void scanDir() {
		File dirIn = new File(FileManager.getInDirectory());
		
		for ( File f : dirIn.listFiles() ) {
			if ( !f.isDirectory() && "txt".equalsIgnoreCase( getFileExtension( f.getName() ) ) ) {
				
				
				if ( !existFiles(f.getName()) ) {
					filesNames.add( f.getName() );
					
					Thread thread = new Thread(new DataProcessing(f));
					thread.start();
				}
				else {
					continue;
				}
			}
		}
	}
	
	public String getFileExtension(String fullName) {
	    if ( fullName.isBlank() || fullName.isEmpty() ) {
	    	return "";
	    }
	    int dotIndex = fullName.lastIndexOf('.');
	    return (dotIndex == -1) ? "" : fullName.substring(dotIndex + 1);
	}
	
	public boolean existFiles( String name ) {
		return filesNames.stream().anyMatch(name::contains);
	}
	
	

}
