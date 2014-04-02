package com.younet.social.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.io.StringReader;

public class AnalyzerUtils {

	public static String input = ReadInputFile.getString();

	public static void displayTokensWithFullDetails(Analyzer analyzer,
			String text) throws IOException {

		TokenStream stream = analyzer.tokenStream("contents", new StringReader(
				text));

		CharTermAttribute term = stream.addAttribute(CharTermAttribute.class);
		PositionIncrementAttribute posIncr = stream
				.addAttribute(PositionIncrementAttribute.class);
		OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
		TypeAttribute type = stream.addAttribute(TypeAttribute.class);

		int position = 0;
		stream.reset();
		while (stream.incrementToken()) {

			int increment = posIncr.getPositionIncrement();
			if (increment > 0) {
				position = position + increment;
				System.out.println();
				System.out.print(position + ": ");
			}

			System.out.print("[" + term.toString() + ":" + offset.startOffset()
					+ "->" + offset.endOffset() + ":" + type.type()
					+ ", PosInc: " + increment + "] ");
		}
		stream.end();
		stream.close();
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		AnalyzerUtils.displayTokensWithFullDetails(new WhitespaceAnalyzer(
				Version.LUCENE_47), input);
	}
}
