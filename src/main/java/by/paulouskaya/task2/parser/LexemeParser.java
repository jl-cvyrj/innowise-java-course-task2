package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;

public class LexemeParser extends AbstractParser {

    public LexemeParser(WordParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseComponent(String text, TextComposite textComposite) {
        String[] lexemes = text.split("\\s+");
        
        for (String lexeme : lexemes) {
            if (!lexeme.trim().isEmpty()) {
                TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
                getNextParser().parseComponent(lexeme.trim(), lexemeComposite);
                textComposite.addComponent(lexemeComposite);
            }
        }
    }
}