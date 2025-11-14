package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;

public class LexemeParser extends AbstractParser {

	public static final String LEXEME_REGEX = "\\s+";

	public LexemeParser(WordParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parseComponent(String sentence, TextComposite textComposite) {
		String[] lexemes = sentence.split(LEXEME_REGEX);

		for (String lexeme : lexemes) {		
			if (!lexeme.isBlank()) {
				TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
				var wordParser = this.getNextParser();
				wordParser.parseComponent(lexeme, lexemeComposite);
				textComposite.addComponent(lexemeComposite);
			}
		}
	}
}