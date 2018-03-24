package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

import it.polito.tdp.spellchecker.model.RichWord;

public class Dictionary {
	
	public Dictionary() {
		
	}
	
	List<String> dizionario = new ArrayList<String>() ;

	
	
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



	public List<RichWord> spellCheckText(List<String> inputTextList) {
		
		List<RichWord> parole = new LinkedList<RichWord>();
		
		boolean flag;
		for(String p : inputTextList) {
			flag = false;
			for(String d : dizionario)
				if(p.compareTo(d) == 0)
					flag = true; 
			if(flag == false) {
				RichWord r = new RichWord(p, false);
				parole.add(r);}
		
		}
					
			
				
			
		
		return parole;
		
	}

}
