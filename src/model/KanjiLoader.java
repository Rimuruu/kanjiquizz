package model;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class KanjiLoader{
	static FileReader DATA;
	static HashMap<String,String> kanjis;
	
	public static void loadKanji() throws CsvValidationException, IOException
	{
		KanjiLoader.kanjis = new HashMap<String,String>();
		KanjiLoader.DATA  = new FileReader("./src/asset/joyo_kanji.csv");
		CSVReader reader = new CSVReader(DATA);
		String [] nextLine;
	     while ((nextLine = reader.readNext()) != null) {
	        // nextLine[] is an array of values from the line
	        //System.out.println(nextLine[0] + nextLine[1] + nextLine[1] + "etc...");
	        Tokenizer tokenizer = Tokenizer.builder().build();
	        Token token = tokenizer.tokenize(nextLine[1]).get(0);
	        String reading = token.getReading();
	        //System.out.println(nextLine[1] + " = " + reading);
	        if(reading != null) {
	        	KanjiLoader.kanjis.put(nextLine[1],reading);
	        }
	     }
	     
	     Iterator it = kanjis.entrySet().iterator();
	     while (it.hasNext()) {
	         Map.Entry pair = (Map.Entry)it.next();
	         System.out.println(pair.getKey() + " = " + pair.getValue());
	         //it.remove(); // avoids a ConcurrentModificationException
	}
	     System.out.println(KanjiLoader.kanjis.size());
	}
}