package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;

public class WordParser extends AbstractParser {
	
	public static final String WORD_AND_PUNCTUATION_REGEX = "(?<=\\p{Punct})(?<!['-])|(?=\\p{Punct})(?!['-])";

	public WordParser(SymbolParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parseComponent(String lexeme, TextComposite textComposite) {
		String[] wordAndPunctuationArray = lexeme.split(WORD_AND_PUNCTUATION_REGEX);

		for (String wordOrPunctuation : wordAndPunctuationArray) {
			TextComposite wordOrPunctuationComposite = new TextComposite(TextComponentType.WORD);

			if (wordOrPunctuation.matches("\\p{Punct}")) {
				wordOrPunctuationComposite = new TextComposite(TextComponentType.PUNCTUATION);
			} else {
				wordOrPunctuationComposite = new TextComposite(TextComponentType.WORD);
			}
			
			var wordOrPunctuationParser = this.getNextParser();
			wordOrPunctuationParser.parseComponent(wordOrPunctuation.strip(), wordOrPunctuationComposite);
			textComposite.addComponent(wordOrPunctuationComposite);
		}
	}
}