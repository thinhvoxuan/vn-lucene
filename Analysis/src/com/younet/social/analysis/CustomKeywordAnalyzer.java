package com.younet.social.analysis;

import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;

public final class CustomKeywordAnalyzer extends Analyzer {
	public CustomKeywordAnalyzer() {
		
	}	
	@Override
	protected TokenStreamComponents createComponents(final String fieldName,
			final Reader reader) {
		return new TokenStreamComponents(new CustomKeywordTokenizer(reader));
	}
}