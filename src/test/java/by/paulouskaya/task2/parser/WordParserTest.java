package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class WordParserTest {

    @Test
    public void testParseComponent_CleanWord_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("hello", composite);
        
        String expected = "hello";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithExclamation_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("hello!", composite);
        
        String expected = "hello!";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithComma_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("hello,", composite);
        
        String expected = "hello,";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithPeriod_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("Bye.", composite);
        
        String expected = "Bye.";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithApostrophe_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("don't", composite);
        
        String expected = "don't";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithHyphen_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("more-or-less", composite);
        
        String expected = "more-or-less";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_MultiplePunctuation_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("hello!!!", composite);
        
        String expected = "hello!!!";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_PunctuationBetweenWords_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("hello,world", composite);
        
        String expected = "hello,world";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_OnlyPunctuation_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("!", composite);
        
        String expected = "!";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ComplexExample_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("reader's,", composite);
        
        String expected = "reader's,";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithQuotes_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("\"hello\"", composite);
        
        String expected = "\"hello\"";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_MixedContent_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("content,'", composite);
        
        String expected = "content,'";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }
}