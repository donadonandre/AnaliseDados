package br.com.donadon.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import br.com.donadon.process.DataAnalisis;

public class Report {
	
	private String fileName;
	private DataAnalisis data;
	
	public Report(String fileName, DataAnalisis da) {
		this.fileName = fileName;
		this.data = da;
	}
	
	public void write() {
		try {
			FileWriter fw = new FileWriter( 
					String.join( 
							String.valueOf( File.separatorChar ), 
							FileManager.getOutDirectory(), 
							this.fileName ), 
					Charset.forName("UTF-8"));
			
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write( "Quantity of Customers: " + this.data.getAllCustomers() );
			bw.newLine();
			bw.write( "Quantity of Sellers: " + this.data.getAllSellers() );
			bw.newLine();
			bw.write( "Id of most expensive sale: " + this.data.getHighestSale() );
			bw.newLine();
			bw.write( "Worst Seller: " + this.data.getWorstSeller() );
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
