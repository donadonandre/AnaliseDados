package br.com.donadon.process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import br.com.donadon.io.Report;
import br.com.donadon.model.Customer;
import br.com.donadon.model.Sale;
import br.com.donadon.model.SaleItem;
import br.com.donadon.model.Seller;

public class DataProcessing implements Runnable {
	
	private File file;
	private DataAnalisis da;
	
	public DataProcessing( File file ) {
		this.file = file;
		
		da = new DataAnalisis();
	}
	
	@Override
	public void run() {
		this.execute();
	}
	
	private void execute() {
		try {
			Scanner scanner = new Scanner(this.file, "UTF-8");
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter("ç");
				
				String column1 = lineScanner.next();
				String column2 = lineScanner.next();
				String column3 = lineScanner.next();
				String column4 = lineScanner.next();
				
				if ( "002".equals( column1 ) ) {
					long cnpj = Long.parseLong( column2 );
					String nameBusiness = column3;
					String area = column4;
					
					da.add( new Customer(cnpj, nameBusiness, area) );
				}
				else if ( "001".equals( column1 ) ) {
					long cpf = Long.parseLong( column2 );
					String name = column3;
					double salary = Double.parseDouble(column4);
					
					da.add( new Seller(cpf, name, salary) );
				}
				else {
					int idSale = Integer.parseInt( column2 );
					String hashItems = column3;
					String salesmanName = column4;
					
					da.add( new Sale(idSale, SaleItem.getItems(hashItems), salesmanName) );
				}
				
				lineScanner.close();
			}
			scanner.close();
			
			Report report = new Report( this.file.getName(), da);
			report.write();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
