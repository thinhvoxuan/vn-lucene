package com.younet.social.analysis;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import vn.hus.nlp.tokenizer.VietTokenizer;
import vn.hus.nlp.utils.UTF8FileUtility;

public class TestAnalysis {
	public static String filename = "inputFile.txt";
	public static String[] inputString = UTF8FileUtility.getAllLines(filename);
	public static String input = join(inputString, "\n");
	
	public static String join(String [] lsString, String delim){
	    StringBuilder sb = new StringBuilder();
	    String loopDelim = "";
	    for(String s : lsString) {
	        sb.append(loopDelim);
	        sb.append(s);
	        loopDelim = delim;
	    }
	    return sb.toString();
	}
	
	public static void main(String[] str) {
		VietTokenizer vietTokenizer = new VietTokenizer();
		vietTokenizer.turnOnSentenceDetection();
		String [] list = vietTokenizer.tokenize(input);
		for(String e: list){
			System.out.println(e);
		}		
	}
	
	public static void runtest(){
		TestAnalysis.displayTokenizer(new WhitespaceAnalyzer(Version.LUCENE_47));
	}

	public static void displayTokenizer(Analyzer an) {
		TokenStream ts;
		try {
			ts = an.tokenStream("content", input);
			CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
			OffsetAttribute offsetAtt = ts.addAttribute(OffsetAttribute.class);
			ts.reset();
			while (ts.incrementToken()) {
				int start = offsetAtt.startOffset();
				int end = offsetAtt.endOffset();
				System.out.println(String.format("start:%d [ %s ] end:%d", start, termAtt.toString(), end));
			}
			ts.end();
			ts.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
