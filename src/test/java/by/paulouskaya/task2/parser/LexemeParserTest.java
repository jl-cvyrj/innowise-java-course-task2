package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LexemeParserTest {

    @Test
    public void testParseComponent_MultipleWords_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("It has survived", composite);
        
        String expected = "It has survived";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordsWithPunctuation_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("unchanged. It was", composite);
        
        String expected = "unchanged. It was";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ComplexLexemes_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("more-or-less normal distribution", composite);
        
        String expected = "more-or-less normal distribution";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordsWithCommas_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("content here, content here", composite);
        
        String expected = "content here, content here";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_TechnicalTerms_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("Letraset sheets PageMaker", composite);
        
        String expected = "Letraset sheets PageMaker";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_SingleWord_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("Bye.", composite);
        
        String expected = "Bye.";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_WordsWithApostrophes_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("reader's layout", composite);
        
        String expected = "reader's layout";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_MixedCaseWords_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("Lorem Ipsum passages", composite);
        
        String expected = "Lorem Ipsum passages";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ExtraSpaces_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser parser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        parser.parseComponent("  electronic   typesetting  ", composite);
        
        String expected = "electronic typesetting";
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
}