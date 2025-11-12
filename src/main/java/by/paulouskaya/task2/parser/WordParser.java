package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;

public class WordParser extends AbstractParser {
	
	public static final String WORD_REGEX = "[^a-zA-Zа-яА-ЯёЁ]";
  public static final String WORD_REPLACEMENT = " ";
  public static final String WORD_SPLIT_REGEX = "\\s+";

	public WordParser(SymbolParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parseComponent(String lexeme, TextComposite textComposite) {
		String cleanedLexeme = lexeme.replaceAll(WORD_REGEX, WORD_REPLACEMENT);
		String[] words = cleanedLexeme.split(WORD_SPLIT_REGEX);

		for (String word : words) {
			if (!word.isBlank()) {
				TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
				getNextParser().parseComponent(word, wordComposite);
				textComposite.addComponent(wordComposite);
			}
		}
	}
}