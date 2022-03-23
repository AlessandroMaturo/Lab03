package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	List<String> dictionary = new LinkedList<String>();
	
	public void loadDictionary(String language) {
		
		try {
			FileReader fr = new FileReader(language);
			BufferedReader br = new BufferedReader(fr);
			
			String word;
			while((word = br.readLine())!=null) {
				dictionary.add(word);
				//System.out.println(word+"\n");
			}
			
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> richWords = new LinkedList<RichWord>();
		
		for(String si:inputTextList) {
			boolean ok = false;
			for(String di: dictionary) {
				if(si.compareTo(di)==0) {
					ok=true;
					break;
				}
			}
			richWords.add(new RichWord(si,ok));
		}
		
		return richWords;
	}

}
