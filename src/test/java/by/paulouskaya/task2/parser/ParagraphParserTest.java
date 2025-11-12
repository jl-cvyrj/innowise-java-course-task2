package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParagraphParserTest {

    @Test
    public void testParseComponent_TwoParagraphs_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        parser.parseComponent("First.\n\nSecond.", composite);
        
        String expected = "First.\n\tSecond.";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_SingleParagraph_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        parser.parseComponent("Single paragraph.", composite);
        
        String expected = "Single paragraph.";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_MultipleNewlines_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        parser.parseComponent("A\n\n\nB\n\nC", composite);
        
        String expected = "A\n\tB\n\tC";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_EmptyText_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        parser.parseComponent("", composite);
        
        String expected = "";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_OnlySpaces_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        parser.parseComponent("   \n\n   ", composite);
        
        String expected = "";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ParagraphsWithContent_Structure() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        parser.parseComponent("Hello world.\n\nHow are you?", composite);
        
        String expected = "Hello world.\n\tHow are you?";
        String actual = composite.toString();
        
        assertEquals(expected, actual);
    }
}