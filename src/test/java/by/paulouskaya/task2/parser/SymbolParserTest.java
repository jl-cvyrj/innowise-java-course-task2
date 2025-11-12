package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class SymbolParserTest {

    @Test
    public void testParseComponent_WordWithOnlyLetters_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("hello", composite);
        
        String expected = "hello";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithMixedCharacters_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("h1e2l3", composite);
        
        String expected = "h1e2l3";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_SingleCharacter_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("a", composite);
        
        String expected = "a";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithHyphen_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("test-word", composite);
        
        String expected = "test-word";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_EmptyString_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("", composite);
        
        String expected = "";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithApostrophe_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("don't", composite);
        
        String expected = "don't";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }
}