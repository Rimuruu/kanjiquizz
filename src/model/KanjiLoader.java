package model;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class KanjiLoader{
	static FileReader DATA;
	static HashMap<String,String> kanjis;
	
	public static void loadKanji() throws CsvValidationException, IOException
	{
		KanjiLoader.DATA  = new FileReader("./src/asset/joyo_kanji.csv");
		CSVReader reader = new CSVReader(DATA);
		String [] nextLine;
	     while ((nextLine = reader.readNext()) != null) {
	        // nextLine[] is an array of values from the line
	        System.out.println(nextLine[0] + nextLine[1] + "etc...");
	     }
	}
}