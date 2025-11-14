package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;

public class SentenceParser extends AbstractParser {

	public static final String SENTENCE_REGEX = "(?<=[.!?])\\s+";

	public SentenceParser(LexemeParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parseComponent(String paragraph, TextComposite textComposite) {
		String[] sentenceArray = paragraph.split(SENTENCE_REGEX);

		for (String sentence : sentenceArray) {
			TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
			var lexemeParser = this.getNextParser();
			lexemeParser.parseComponent(sentence.strip(), sentenceComposite);
			textComposite.addComponent(sentenceComposite);
		}
	}
}