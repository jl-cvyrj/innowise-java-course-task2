package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import by.paulouskaya.task2.composite.TextLeaf;

public class SymbolParser extends AbstractParser {

	public SymbolParser() {
		super(null);
	}

	@Override
	public void parseComponent(String word, TextComposite textComposite) {
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TextComponentType type = Character.isLetter(character) ? TextComponentType.LETTER : TextComponentType.SYMBOL;

			TextLeaf symbolLeaf = new TextLeaf(character, type);
			textComposite.addComponent(symbolLeaf);
		}
	}
}