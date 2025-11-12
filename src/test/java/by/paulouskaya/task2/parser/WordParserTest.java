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
    public void testParseComponent_WordWithPunctuation_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("hello!", composite);
        
        String expected = "hello";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_OnlyPunctuation_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("!@#$", composite);
        
        String expected = "";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithNumbers_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("word123", composite);
        
        String expected = "word";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_MixedCharacters_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("a1b2c3!", composite);
        
        String expected = "abc";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_CyrillicWord_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser parser = new WordParser(symbolParser);
        
        TextComposite composite = new TextComposite(TextComponentType.LEXEME);
        parser.parseComponent("hi123!", composite);
        
        String expected = "hi";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }
}