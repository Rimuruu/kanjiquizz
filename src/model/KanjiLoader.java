package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.atilika.kuromoji.Token;
import org.atilika.kuromoji.Tokenizer;

public class KanjiLoader{
	static FileReader DATA;
	static HashMap<String,String> kanjis;
	
	public static void loadKanji() throws IOException  {
		KanjiLoader.kanjis = new HashMap<String,String>();
		InputStreamReader stream;
		try {
			stream = new InputStreamReader(new BufferedInputStream(KanjiLoader.class.getClassLoader().getResourceAsStream("joyo_kanji.csv")),"UTF-8");
		
		System.out.println(KanjiLoader.class.getClassLoader().getResourceAsStream("joyo_kanji.csv"));
		BufferedReader br = new BufferedReader(stream);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(br);
		
	    for (CSVRecord record : records) {
	    	//System.out.println(record.get(1));
	        Tokenizer tokenizer = Tokenizer.builder().build();
	        Token token = tokenizer.tokenize(record.get(1)).get(0);
	        String reading = token.getReading();
	        if(reading != null) {
	        	KanjiLoader.kanjis.put(record.get(1),reading);
	        }
	     }
	    stream.close();
	 
	     
	     Iterator<Entry<String, String>> it = kanjis.entrySet().iterator();
	     while (it.hasNext()) {
	         @SuppressWarnings({ "rawtypes", "unused" })
			Map.Entry pair = (Map.Entry)it.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	      
	}
	     System.out.println(KanjiLoader.kanjis.size());
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}
}