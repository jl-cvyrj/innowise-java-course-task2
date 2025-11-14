package by.paulouskaya.task2.service.impl;

import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import by.paulouskaya.task2.parser.*;
import by.paulouskaya.task2.service.impl.TextServiceImpl;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TextServiceImplTest {

    private TextServiceImpl createTextService() {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        return new TextServiceImpl();
    }

    private TextComposite parseText(String text) {
        SymbolParser symbolParser = new SymbolParser();
        WordParser wordParser = new WordParser(symbolParser);
        LexemeParser lexemeParser = new LexemeParser(wordParser);
        SentenceParser sentenceParser = new SentenceParser(lexemeParser);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        
        TextComposite composite = new TextComposite(TextComponentType.TEXT);
        paragraphParser.parseComponent(text, composite);
        return composite;
    }

    @Test
    public void testFindMaxNubmerOfSentencesWithEqualWords_NoRepeatedWords() {
        TextServiceImpl textService = createTextService();
        String text = "Hello world. How are you? I'm fine.";
        TextComposite composite = parseText(text);
        
        int expected = 3;
        int actual = textService.findMaxNubmerOfSentencesWithEqualWords(composite);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxNubmerOfSentencesWithEqualWords_OneSentenceWithRepeats() {
        TextServiceImpl textService = createTextService();
        String text = "Cat cat cat. Dog mouse. Bird fish.";
        TextComposite composite = parseText(text);
        
        int expected = 1;
        int actual = textService.findMaxNubmerOfSentencesWithEqualWords(composite);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxNubmerOfSentencesWithEqualWords_MultipleSentencesWithSameMax() {
        TextServiceImpl textService = createTextService();
        String text = "Hello hello. World world. Test test.";
        TextComposite composite = parseText(text);
        
        int expected = 3;
        int actual = textService.findMaxNubmerOfSentencesWithEqualWords(composite);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxNubmerOfSentencesWithEqualWords_DifferentCaseWords() {
        TextServiceImpl textService = createTextService();
        String text = "Hello HELLO hello. Test test.";
        TextComposite composite = parseText(text);
        
        int expected = 2;
        int actual = textService.findMaxNubmerOfSentencesWithEqualWords(composite);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxNubmerOfSentencesWithEqualWords_ComplexText() {
        TextServiceImpl textService = createTextService();
        String text = "This is a test. Test test test. Simple text. Test again test.";
        TextComposite composite = parseText(text);
        
        int expected = 2;
        int actual = textService.findMaxNubmerOfSentencesWithEqualWords(composite);
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSortSentencesByCountLexeme_AscendingOrder() {
        TextServiceImpl textService = createTextService();
        String text = "Short. Medium length sentence. Very long sentence with many words.";
        TextComposite composite = parseText(text);
        
        List<TextComposite> result = textService.sortSentencesByCountLexeme(composite);
        
        int expected = 1;
        int actual = textService.countLexemesInSentence(result.get(0));
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSortSentencesByCountLexeme_EqualLengthSentences() {
        TextServiceImpl textService = createTextService();
        String text = "One two. Three four. Five six.";
        TextComposite composite = parseText(text);
        
        List<TextComposite> result = textService.sortSentencesByCountLexeme(composite);
        
        int expected = 3;
        int actual = result.size();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSortSentencesByCountLexeme_SingleSentence() {
        TextServiceImpl textService = createTextService();
        String text = "Just one sentence.";
        TextComposite composite = parseText(text);
        
        List<TextComposite> result = textService.sortSentencesByCountLexeme(composite);
        
        int expected = 1;
        int actual = result.size();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSortSentencesByCountLexeme_VaryingLexemeCount() {
        TextServiceImpl textService = createTextService();
        String text = "A. B C. D E F G. H I.";
        TextComposite composite = parseText(text);
        
        List<TextComposite> result = textService.sortSentencesByCountLexeme(composite);
        
        int expected = 4;
        int actual = textService.countLexemesInSentence(result.get(3));
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSortSentencesByCountLexeme_WithPunctuation() {
        TextServiceImpl textService = createTextService();
        String text = "Hello! How are you? I'm fine, thanks.";
        TextComposite composite = parseText(text);
        
        List<TextComposite> result = textService.sortSentencesByCountLexeme(composite);
        
        int expected = 3;
        int actual = result.size();
        
        assertEquals(expected, actual);
    }

    @Test
    public void testSwapFirstAndLastLexemeInEachSentence_TwoLexemes() {
        TextServiceImpl textService = createTextService();
        String text = "Hello world.";
        TextComposite composite = parseText(text);
        
        textService.swapFirstAndLastLexemeInEachSentence(composite);
        String result = composite.toString();
        
        assertTrue(result.contains("world") && result.contains("Hello"));
    }

    @Test
    public void testSwapFirstAndLastLexemeInEachSentence_ThreeLexemes() {
        TextServiceImpl textService = createTextService();
        String text = "One two three.";
        TextComposite composite = parseText(text);
        
        textService.swapFirstAndLastLexemeInEachSentence(composite);
        String result = composite.toString();
        
        assertTrue(result.contains("three") && result.contains("One"));
    }

    @Test
    public void testSwapFirstAndLastLexemeInEachSentence_MultipleSentences() {
        TextServiceImpl textService = createTextService();
        String text = "First sentence. Second test.";
        TextComposite composite = parseText(text);
        
        textService.swapFirstAndLastLexemeInEachSentence(composite);
        String result = composite.toString();
        
        assertTrue(result.contains("sentence") && result.contains("test"));
    }

    @Test
    public void testSwapFirstAndLastLexemeInEachSentence_SingleLexeme() {
        TextServiceImpl textService = createTextService();
        String text = "Hello.";
        TextComposite composite = parseText(text);
        
        String before = composite.toString();
        textService.swapFirstAndLastLexemeInEachSentence(composite);
        String after = composite.toString();
        
        assertEquals(before, after);
    }

    @Test
    public void testSwapFirstAndLastLexemeInEachSentence_SimpleCase() {
        TextServiceImpl textService = createTextService();
        String text = "A B.";
        TextComposite composite = parseText(text);
        
        textService.swapFirstAndLastLexemeInEachSentence(composite);
        String result = composite.toString();
        
        assertTrue(result.contains("B") && result.contains("A"));
    }
}