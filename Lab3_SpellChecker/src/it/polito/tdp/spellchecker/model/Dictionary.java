package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

import it.polito.tdp.spellchecker.model.RichWord;

public class Dictionary {
	
	public Dictionary() {
		
	}
	
	List<String> dizionario = new ArrayList<String>();

	
	
	public void loadDictionary(String language) {
		
		try {
			FileReader fr = new FileReader("rsc/" + language + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dizionario.add(word.toLowerCase());
				
			}
			
			Collections.sort(dizionario);
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		
		
	}


	
	public List<RichWord> spellCheckTextLinear(List<String> inputTextList) {
		
		long ti = System.nanoTime();

		
	List<RichWord> parole = new LinkedList<RichWord>();
		
		boolean flag;
		for(String p : inputTextList) {
			flag = false;
			for(String d : dizionario)
				if(p.compareTo(d) == 0)
					flag = true; 
			if(flag == false) {
				RichWord r = new RichWord(p, false);
				parole.add(r);
			}}
	
		long tf = System.nanoTime();
		long res = (long) ((tf-ti)/1E3);
		System.out.println(res+" microsecondi");
		
			return parole; 
	}
					
	
public List<RichWord> spellCheckTextDichotomic(List<String> inputTextList) {
		
		long ti = System.nanoTime();

		List<RichWord> parole = new LinkedList<RichWord>();
		
		RichWord r;
		for (String s : inputTextList) {
			
			
				if (binarySearch(s.toLowerCase())) 
					r = new RichWord(s, true);
				else 
					r = new RichWord(s, false);
				parole.add(r);
	
		}
		
		long tf = System.nanoTime();
		long res = (long) ((tf-ti)/1E3);
		System.out.println(res+" microsecondi");
		
		return parole;
	}
				
			
	private boolean binarySearch(String stemp) {
		
		int inizio = 0;
	    int fine = dizionario.size();

	     
	     while (inizio!=fine){
	         int medio = inizio + (fine - inizio)/2;
	         if (stemp.compareToIgnoreCase(dizionario.get(medio))==0){
	             return true;
	         } else if (stemp.compareToIgnoreCase(dizionario.get(medio))>0){
	               inizio=medio +1;
	           } else {
	               fine=medio;
	           }
	     }
		
	     
		return false;
	}
		
		
	

}
