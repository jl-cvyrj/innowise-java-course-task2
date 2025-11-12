package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LexemeParserTest {

    @Test
    public void testParseComponent_MultipleLexemes_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("hello world test", composite);
        
        String expected = "hello world test";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_SingleLexeme_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("single", composite);
        
        String expected = "single";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ExtraSpaces_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("  hello---world  ", composite);
        
        String expected = "hello world";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_TabsAndSpaces_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("hello\tworld", composite);
        
        String expected = "hello world";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_EmptyString_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("", composite);
        
        String expected = "";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_MixedContent_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("hello world! test?", composite);
        
        String expected = "hello world test";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }
}