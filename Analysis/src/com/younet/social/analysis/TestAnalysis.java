package com.younet.social.analysis;

import vn.hus.nlp.tokenizer.VietTokenizer;

public class TestAnalysis {
	
	public static String input = ReadInputFile.getString();
	
	public static void main(String[] str) {
		VietTokenizer vietTokenizer = new VietTokenizer();
		vietTokenizer.turnOnSentenceDetection();
		String [] list = vietTokenizer.tokenize(input);
		for(String e: list){
			System.out.println(e);
		}		
	}
}
