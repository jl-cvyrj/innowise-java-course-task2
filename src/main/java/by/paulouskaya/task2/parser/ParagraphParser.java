package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComponentType;
import by.paulouskaya.task2.composite.TextComposite;

public class ParagraphParser extends AbstractParser {

	public static final String PARAGRAPH_REGEX = "\n\\s*\n";

	public ParagraphParser(SentenceParser nextParser) {
		super(nextParser);
	}

	@Override
	public void parseComponent(String text, TextComposite textComposite) {
		String[] paragraphArray = text.split(PARAGRAPH_REGEX);

		for (String paragraph : paragraphArray) {
			if (!paragraph.isBlank()) {
				TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
				getNextParser().parseComponent(paragraph.trim(), paragraphComposite);
				textComposite.addComponent(paragraphComposite);
			}
		}

	}

}
