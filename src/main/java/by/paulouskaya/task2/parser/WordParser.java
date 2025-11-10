package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import by.paulouskaya.task2.composite.TextLeaf;

public class WordParser extends AbstractParser {

		public WordParser() {
		    super(null); 
		}

		@Override
    public void parseComponent(String lexeme, TextComposite textComposite) {
        TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
        
        for (int i = 0; i < lexeme.length(); i++) {
            char character = lexeme.charAt(i);
            TextComponentType type = Character.isLetter(character) ? 
                TextComponentType.LETTER : TextComponentType.SYMBOL;
            
            TextLeaf symbolLeaf = new TextLeaf(character, type);
            wordComposite.addComponent(symbolLeaf);
        }
        
        textComposite.addComponent(wordComposite);
    }
}