package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;

public class LexemeParser extends AbstractParser {

    public LexemeParser(WordParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parseComponent(String sentence, TextComposite textComposite) {
        String[] lexemes = sentence.split("\\s+");
        
        for (String lexeme : lexemes) {
            if (!lexeme.isBlank()) {
                TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
                getNextParser().parseComponent(lexeme.strip(), lexemeComposite);
                textComposite.addComponent(lexemeComposite);
            }
        }
    }
}