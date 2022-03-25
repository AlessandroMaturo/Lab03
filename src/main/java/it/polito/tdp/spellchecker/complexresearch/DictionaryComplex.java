package it.polito.tdp.spellchecker.complexresearch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.spellchecker.model.RichWord;

public class DictionaryComplex {
	
	private List<String> dictionary;
	
	public void loadDictionaryLinked(String language) {
		dictionary = new LinkedList<String>();
		
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
	
	public void loadDictionaryArray(String language) {
		dictionary = new ArrayList<String>();
		
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
	
	public List<RichWord> spellCheckTextLinearLinked(List<String> inputTextList){
		
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
	
	public List<RichWord> spellCheckTextLinearArray(List<String> inputTextList){
		
		List<RichWord> richWords = new ArrayList<RichWord>();
		
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
	
    public List<RichWord> spellCheckTextDichotomicArray(List<String> inputTextList){
		
		List<RichWord> richWords = new ArrayList<RichWord>();
		
		for(String si:inputTextList) {
			boolean ok = false;
			int lo=0;
			int hi=dictionary.size()-1;
			
			while(lo<=hi && ok==false) {
				int mid=lo + (hi-lo)/2;
				
				if (si.compareTo(dictionary.get(mid))==0)
	                ok = true;

	            if (si.compareTo(dictionary.get(mid))>=0)
	                lo = mid + 1;

	            else
	                hi = mid - 1;
			}
			
			richWords.add(new RichWord(si,ok));
		}
		return richWords;
    }
    
    /*lo e hi sono i due indici che sono gli estremi di cui lo è estremo inferiore;
     * fai il ciclo fino a che lo<=hi e dentro ci metti anche fino a che non hai trovato ok dentro la parola
     * dentro dichiari la metà come lo + (hi-lo)/2 
     * se la parola è uguale a quella del dizionario imposti ok = true 
     * se invece sta dopo metti come indice inferiore la metà più uno
     * se invece laparola sta prima metti cme indice superiore la metà meno uno
     * ovviamente confronti con l'elemento che hai messo come indice metà
     */
		

    public List<RichWord> spellCheckTextDichotomicList(List<String> inputTextList){
		
		List<RichWord> richWords = new LinkedList<RichWord>();
		
		for(String si:inputTextList) {
			boolean ok = false;
			int lo=0;
			int hi=dictionary.size()-1;
			
			while(lo<=hi && ok==false) {
				int mid=lo + (hi-lo)/2;
				
				if (si.compareTo(dictionary.get(mid))==0)
	                ok = true;

	            if (si.compareTo(dictionary.get(mid))>=0)
	                lo = mid + 1;

	            else
	                hi = mid - 1;
			}
			
			richWords.add(new RichWord(si,ok));
		}
		return richWords;
    }	
	
		
	
    
    public List<RichWord> spellCheckTextContainsLinked(List<String> inputTextList){
		
		List<RichWord> richWords = new LinkedList<RichWord>();
		
		for(String si:inputTextList) {
			richWords.add(new RichWord(si,dictionary.contains(si)));
		}
		
		return richWords;
    }
    
    public List<RichWord> spellCheckTextContainsArray(List<String> inputTextList){
		
		List<RichWord> richWords = new ArrayList<RichWord>();
		
		for(String si:inputTextList) {
			richWords.add(new RichWord(si,dictionary.contains(si)));
		}
		
		return richWords;
    }
    
}