package com.younet.analysis;

import vn.hus.nlp.tokenizer.VietTokenizer;

public class RunVntokenizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VietTokenizer vntoken = new VietTokenizer();
		vntoken.turnOnSentenceDetection();
		vntoken.tokenize("inputFile.txt", "output.txt");
	}

}
