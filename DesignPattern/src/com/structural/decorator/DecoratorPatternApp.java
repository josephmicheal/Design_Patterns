package com.structural.decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DecoratorPatternApp {

	public static void main(String[] args) {

		DataSource ds = new CompressDataSourceDecorator(new EncodeDataSourceDecorator(new FileDataSourceDecorator("")));
		System.out.println(ds.readData());
	}

}

interface DataSource{
	String readData();
	void writeData();
}

class EncodeDataSourceDecorator implements DataSource{
	private DataSource dataSource;
	
	public EncodeDataSourceDecorator(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String readData() {
		return "decode started.." + dataSource.readData()+"..decode ended.";  
	}
	

	@Override
	public void writeData() {
		try {
			Files.write(Path.of(""), "fileContent".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

class CompressDataSourceDecorator implements DataSource{
	private DataSource dataSource;
	
	public CompressDataSourceDecorator(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public String readData() {
		return "extract started.." + dataSource.readData()+"..extract ended."; 
	}
	

	@Override
	public void writeData() {
		try {
			Files.write(Path.of(""), "fileContent".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

class FileDataSourceDecorator implements DataSource{
	
	String fileName;
	
	FileDataSourceDecorator(String fileName){
		this.fileName = fileName;
	}

	@Override
	public String readData() {
		return "file Content";
	}

	@Override
	public void writeData() {
		try {
			Files.write(Path.of(fileName), "fileContent".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}