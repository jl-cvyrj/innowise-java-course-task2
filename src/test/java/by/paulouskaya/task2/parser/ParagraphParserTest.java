package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParagraphParserTest {

    @Test
    public void testParseComponent_TwoParagraphs_Structure() {
        System.out.println("=== testParseComponent_TwoParagraphs_Structure ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        String input = "First.\n\nSecond.";
        System.out.println("Input: '" + input + "'");
        
        parser.parseComponent(input, composite);
        
        String expected = "First.\n\tSecond.";
        String actual = composite.toString();
        
        System.out.println("Expected: '" + expected + "'");
        System.out.println("Actual: '" + actual + "'");
        System.out.println("Match: " + expected.equals(actual));
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_SingleParagraph_Structure() {
        System.out.println("=== testParseComponent_SingleParagraph_Structure ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        String input = "Single paragraph.";
        System.out.println("Input: '" + input + "'");
        
        parser.parseComponent(input, composite);
        
        String expected = "Single paragraph.";
        String actual = composite.toString();
        
        System.out.println("Expected: '" + expected + "'");
        System.out.println("Actual: '" + actual + "'");
        System.out.println("Match: " + expected.equals(actual));
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_MultipleNewlines_Structure() {
        System.out.println("=== testParseComponent_MultipleNewlines_Structure ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        String input = "A.\n\n\nB.\n\nC.";
        System.out.println("Input: '" + input + "'");
        
        parser.parseComponent(input, composite);
        
        String expected = "A.\n\tB.\n\tC.";
        String actual = composite.toString();
        
        System.out.println("Expected: '" + expected + "'");
        System.out.println("Actual: '" + actual + "'");
        System.out.println("Match: " + expected.equals(actual));
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_EmptyText_Structure() {
        System.out.println("=== testParseComponent_EmptyText_Structure ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        String input = "";
        System.out.println("Input: '" + input + "'");
        
        parser.parseComponent(input, composite);
        
        String expected = "";
        String actual = composite.toString();
        
        System.out.println("Expected: '" + expected + "'");
        System.out.println("Actual: '" + actual + "'");
        System.out.println("Match: " + expected.equals(actual));
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_OnlySpaces_Structure() {
        System.out.println("=== testParseComponent_OnlySpaces_Structure ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        String input = "   \n\n   ";
        System.out.println("Input: '" + input + "'");
        
        parser.parseComponent(input, composite);
        
        String expected = "";
        String actual = composite.toString();
        
        System.out.println("Expected: '" + expected + "'");
        System.out.println("Actual: '" + actual + "'");
        System.out.println("Match: " + expected.equals(actual));
        
        assertEquals(expected, actual);
    }

    @Test
    public void testParseComponent_ParagraphsWithContent_Structure() {
        System.out.println("=== testParseComponent_ParagraphsWithContent_Structure ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser parser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        String input = "Hello world.\n\nHow are you?";
        System.out.println("Input: '" + input + "'");
        
        parser.parseComponent(input, composite);
        
        String expected = "Hello world.\n\tHow are you?";
        String actual = composite.toString();
        
        System.out.println("Expected: '" + expected + "'");
        System.out.println("Actual: '" + actual + "'");
        System.out.println("Match: " + expected.equals(actual));
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testParseFullText_Structure() {
        System.out.println("=== testParseFullText_Structure ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        
        TextComposite fullTextComposite = new TextComposite(TextComponentType.TEXT);
        
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with the\s");
        inputBuilder.append("release of Letraset sheets containing Lorem Ipsum passages, and more recently with ");
        inputBuilder.append("desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n");
        inputBuilder.append("It is a long established fact that a reader will be distracted by the readable ");
        inputBuilder.append("content of a page when looking at its layout. The point of using Ipsum is that it has a ");
        inputBuilder.append("more-or-less normal distribution of letters, as opposed to using 'Content here, content ");
        inputBuilder.append("here', making it look like readable English.\n");
        inputBuilder.append("It is a established fact that a reader will be of a page when looking at its ");
        inputBuilder.append("layout.\n");
        inputBuilder.append("Bye.");
        
        String input = inputBuilder.toString();
        System.out.println("Input length: " + input.length());
        System.out.println("First 100 chars of input: '" + input.substring(0, Math.min(100, input.length())) + "'");
        
        StringBuilder expectedBuilder = new StringBuilder();
        expectedBuilder.append("It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the with the\s");
        expectedBuilder.append("release of Letraset sheets containing Lorem Ipsum passages, and more recently with ");
        expectedBuilder.append("desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\t");
        expectedBuilder.append("It is a long established fact that a reader will be distracted by the readable ");
        expectedBuilder.append("content of a page when looking at its layout. The point of using Ipsum is that it has a ");
        expectedBuilder.append("more-or-less normal distribution of letters, as opposed to using 'Content here, content ");
        expectedBuilder.append("here', making it look like readable English.\n\t");
        expectedBuilder.append("It is a established fact that a reader will be of a page when looking at its ");
        expectedBuilder.append("layout.\n\t");
        expectedBuilder.append("Bye.");
        
        String expected = expectedBuilder.toString();
        System.out.println("Expected length: " + expected.length());
        System.out.println("First 100 chars of expected: '" + expected.substring(0, Math.min(100, expected.length())) + "'");
        
        paragraphParser.parseComponent(input, fullTextComposite);
        String actual = fullTextComposite.toString();
        
        System.out.println("Actual length: " + actual.length());
        System.out.println("First 100 chars of actual: '" + actual.substring(0, Math.min(100, actual.length())) + "'");
        
        int minLength = Math.min(Math.min(expected.length(), actual.length()), 200);
        for (int i = 0; i < minLength; i++) {
            if (expected.charAt(i) != actual.charAt(i)) {
                System.out.println("First difference at position " + i);
                System.out.println("Expected char: '" + expected.charAt(i) + "' (code: " + (int)expected.charAt(i) + ")");
                System.out.println("Actual char: '" + actual.charAt(i) + "' (code: " + (int)actual.charAt(i) + ")");
                System.out.println("Context: '..." + expected.substring(Math.max(0, i-10), Math.min(expected.length(), i+10)) + "...'");
                break;
            }
        }
        
        System.out.println("Result: " + (expected.equals(actual) ? "PASS" : "FAIL"));
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testDebugParagraphs() {
        System.out.println("=== testDebugParagraphs ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        
        TextComposite fullTextComposite = new TextComposite(TextComponentType.PARAGRAPH);
        
        String input = "First sentence. Second sentence.\nThird paragraph.";
        System.out.println("Input: '" + input + "'");
        
        String[] paragraphs = input.split("(\\R)+");
        System.out.println("Paragraphs found by split: " + paragraphs.length);
        for (int i = 0; i < paragraphs.length; i++) {
            System.out.println("Para " + i + ": '" + paragraphs[i] + "'");
        }
        
        paragraphParser.parseComponent(input, fullTextComposite);
        String actual = fullTextComposite.toString();
        
        System.out.println("Final result: '" + actual + "'");
        System.out.println("Result length: " + actual.length());
    }
    
    @Test
    public void testDebugSentences() {
        System.out.println("=== testDebugSentences ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        
        TextComposite composite = new TextComposite(TextComponentType.PARAGRAPH);
        
        String input = "First sentence. Second sentence.";
        System.out.println("Input: '" + input + "'");
        
        String[] sentences = input.split("(?<=[.!?])\\s+");
        System.out.println("Sentences found: " + sentences.length);
        for (int i = 0; i < sentences.length; i++) {
            System.out.println("Sentence " + i + ": '" + sentences[i] + "'");
        }
        
        sentenceParser.parseComponent(input, composite);
        String actual = composite.toString();
        
        System.out.println("Final result: '" + actual + "'");
        System.out.println("Result length: " + actual.length());
    }
    
    @Test
    public void testDebugLexemes() {
        System.out.println("=== testDebugLexemes ===");
        
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        
        TextComposite composite = new TextComposite(TextComponentType.SENTENCE);
        
        String input = "First sentence with words";
        System.out.println("Input: '" + input + "'");
        
        String[] lexemes = input.split("\\s+");
        System.out.println("Lexemes found: " + lexemes.length);
        for (int i = 0; i < lexemes.length; i++) {
            System.out.println("Lexeme " + i + ": '" + lexemes[i] + "'");
        }
        
        lexemeParser.parseComponent(input, composite);
        String actual = composite.toString();
        
        System.out.println("Final result: '" + actual + "'");
        System.out.println("Result length: " + actual.length());
    }
}