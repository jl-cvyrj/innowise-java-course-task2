package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class SentenceParserTest {

    @Test
    public void testParseComponent_MultipleSentences_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser parser = new SentenceParser(lexemeParser);
        
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parseComponent("First. Second! Third?", composite);
        
        String expected = "First. Second! Third?";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_SingleSentence_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser parser = new SentenceParser(lexemeParser);
        
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parseComponent("Hello world.", composite);
        
        String expected = "Hello world.";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_NoEndingPunctuation_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser parser = new SentenceParser(lexemeParser);
        
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parseComponent("No ending here", composite);
        
        String expected = "No ending here";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_EmptyInput_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser parser = new SentenceParser(lexemeParser);
        
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parseComponent("", composite);
        
        String expected = "";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ExtraSpaces_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser parser = new SentenceParser(lexemeParser);
        
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parseComponent("First.   Second!", composite);
        
        String expected = "First. Second!";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_VariousEndings_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser parser = new SentenceParser(lexemeParser);
        
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        parser.parseComponent("Hello! How are you? I'm fine.", composite);
        
        String expected = "Hello! How are you? I'm fine.";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }
}