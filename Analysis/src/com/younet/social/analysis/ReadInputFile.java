package com.younet.social.analysis;
import vn.hus.nlp.utils.UTF8FileUtility;


public class ReadInputFile {

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
	
	public static String getString(){
		return input;
	}
	public static void main(String[] args) {
		System.out.println(input);
	}

}
