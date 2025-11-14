package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class SymbolParserTest {

    @Test
    public void testParseComponent_EnglishWord_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("survived", composite);
        
        String expected = "survived";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithApostrophe_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("It's", composite);
        
        String expected = "It's";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithHyphen_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("more-or-less", composite);
        
        String expected = "more-or-less";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithComma_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("here,", composite);
        
        String expected = "here,";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_TechnicalTerm_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("PageMaker", composite);
        
        String expected = "PageMaker";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithDigits_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("electronic5", composite);
        
        String expected = "electronic5";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_SingleLetter_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("a", composite);
        
        String expected = "a";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_UpperCaseWord_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("LOREM", composite);
        
        String expected = "LOREM";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordWithPeriod_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("Bye.", composite);
        
        String expected = "Bye.";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ComplexWord_Structure() {
        SymbolParser parser = new SymbolParser();
        
        TextComposite composite = new TextComposite(TextComponentType.WORD);
        parser.parseComponent("reader's", composite);
        
        String expected = "reader's";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }
}