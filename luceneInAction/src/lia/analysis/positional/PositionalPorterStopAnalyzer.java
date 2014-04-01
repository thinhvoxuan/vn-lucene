package lia.analysis.positional;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseTokenizer;
import org.apache.lucene.analysis.PorterStemFilter;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;

import java.io.Reader;
import java.util.Set;

public class PositionalPorterStopAnalyzer extends Analyzer {
  private Set stopWords;

  public PositionalPorterStopAnalyzer() {
    this(StopAnalyzer.ENGLISH_STOP_WORDS);
  }

  public PositionalPorterStopAnalyzer(String[] stopList) {
    stopWords = StopFilter.makeStopSet(stopList);
  }

  public TokenStream tokenStream(String fieldName, Reader reader) {
    return new PorterStemFilter(
        new PositionalStopFilter(
          new LowerCaseTokenizer(reader), stopWords));
  }
}
