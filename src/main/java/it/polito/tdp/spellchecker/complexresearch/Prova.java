package it.polito.tdp.spellchecker.complexresearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.spellchecker.model.RichWord;

public class Prova {

	public static void main(String[] args) {
		
		DictionaryComplex dictionary = new DictionaryComplex();
		List<RichWord> richWords;
		long time_start, time_end, time;
		
    	
    	//CONTAINS CON ARRAYLIST
		time_start=System.currentTimeMillis();
		
		dictionary.loadDictionaryArray("C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\English.txt");

    	richWords = dictionary.spellCheckTextContainsArray(setTextArray());
    	controlloErrori(richWords);
    	
    	time_end = System.currentTimeMillis();
    	time = time_end-time_start;
    	System.out.println("CONTAINS CON ARRAYLIST");
    	System.out.println(time+ " milliseconds\n");
    
    	
    	//CONTAINS CON LINKEDSLIST
    	time_start=System.currentTimeMillis();
		
		dictionary.loadDictionaryLinked("C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\English.txt");
		    	
    	richWords = dictionary.spellCheckTextContainsLinked(setTextLinked());
    	controlloErrori(richWords);
    	
    	time_end = System.currentTimeMillis();
    	time = time_end-time_start;
    	System.out.println("CONTAINS CON LINKEDLIST");
    	System.out.println(time+ " milliseconds\n");
    	
    	//RICERCA LINEARE CON ARRAYLIST
    	time_start=System.currentTimeMillis();
		
		dictionary.loadDictionaryArray("C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\English.txt");
		    	
    	richWords = dictionary.spellCheckTextLinearArray(setTextArray());
    	controlloErrori(richWords);
    	
    	time_end = System.currentTimeMillis();
    	time = time_end-time_start;
    	System.out.println("RICERCA LINEARE CON ARRAYLIST");
    	System.out.println(time+ " milliseconds\n");
    	
    	//RICERCA LINEARE CON LINKEDLIST
    	time_start=System.currentTimeMillis();
		
		dictionary.loadDictionaryLinked("C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\English.txt");
		    	
    	richWords = dictionary.spellCheckTextLinearLinked(setTextLinked());
    	controlloErrori(richWords);
    	
    	time_end = System.currentTimeMillis();
    	time = time_end-time_start;
    	System.out.println("RICERCA LINEARE CON LINKEDLIST");
    	System.out.println(time+ " milliseconds\n");

    	//RICERCA DICOTOMICA CON ARRAYLIST
    	time_start=System.currentTimeMillis();
		
		dictionary.loadDictionaryArray("C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\English.txt");
		    	
    	richWords = dictionary.spellCheckTextDichotomicArray(setTextLinked());
    	controlloErrori(richWords);
    	
    	time_end = System.currentTimeMillis();
    	time = time_end-time_start;
    	System.out.println("RICERCA DICOTOMICA CON ARRAYLIST");
    	System.out.println(time+ " milliseconds\n");
    	
    	//RICERCA DICOTOMICA CON LINKEDLIST
    	time_start=System.currentTimeMillis();
		
		dictionary.loadDictionaryLinked("C:\\Users\\User\\git\\Lab03\\src\\main\\resources\\English.txt");
		    	
    	richWords = dictionary.spellCheckTextDichotomicArray(setTextLinked());
    	controlloErrori(richWords);
    	
    	time_end = System.currentTimeMillis();
    	time = time_end-time_start;
    	System.out.println("RICERCA DICOTOMICA CON LINKEDLIST");
    	System.out.println(time+ " milliseconds\n");
    	
    	
	}
	
	public static void controlloErrori(List<RichWord> richWords) {
		
		int nErrori=0;
    	for(RichWord ri:richWords) {
    		if(!ri.isCorrect()) {
    			nErrori++;
    		}
    	}
		
	}
	
	public static List<String> setTextLinked() {
		List<String> textList = new LinkedList<String>();
		String text = "Hi! How arre yu?";
		String[] textVet = text.split(" ");
    	
    	for(int i=0;i<textVet.length;i++) {
    		textList.add(textVet[i]);
    	}
    	
    	return textList;
	}
	
	public static List<String> setTextArray() {
		List<String> textList = new ArrayList<String>();
		String text = "Hi! How arre yu?";
		String[] textVet = text.split(" ");
    	
    	for(int i=0;i<textVet.length;i++) {
    		textList.add(textVet[i]);
    	}
    	
    	return textList;
	}

}
