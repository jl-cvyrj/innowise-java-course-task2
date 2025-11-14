package by.paulouskaya.task2.service.impl;

import by.paulouskaya.task2.composite.TextComponent;
import by.paulouskaya.task2.composite.TextComposite;
import by.paulouskaya.task2.composite.TextComponentType;
import by.paulouskaya.task2.service.TextService;

import java.util.*;

public class TextServiceImpl implements TextService {

	@Override
	public int findMaxNubmerOfSentencesWithEqualWords(TextComposite textComposite) {
		List<TextComposite> sentences = extractSentences(textComposite);

		int maxCount = 0;
		for (TextComposite sentence : sentences) {
			int sameWordsCount = findMaxSameWordsCount(sentence);
			if (sameWordsCount > maxCount) {
				maxCount = sameWordsCount;
			}
		}

		int sentenceCount = 0;
		for (TextComposite sentence : sentences) {
			if (findMaxSameWordsCount(sentence) == maxCount) {
				sentenceCount++;
			}
		}

		return sentenceCount;
	}

	@Override
	public List<TextComposite> sortSentencesByCountLexeme(TextComposite textComposite) {
		List<TextComposite> sentences = extractSentences(textComposite);
		sentences.sort(Comparator.comparingInt(this::countLexemesInSentence));
		return sentences;
	}

	@Override
	public void swapFirstAndLastLexemeInEachSentence(TextComposite textComposite) {
		List<TextComposite> sentences = extractSentences(textComposite);

		for (TextComposite sentence : sentences) {
			swapFirstAndLastLexeme(sentence);
		}
	}

	private List<TextComposite> extractSentences(TextComposite composite) {
		List<TextComposite> sentences = new ArrayList<>();
		extractSentencesRecursive(composite, sentences);
		return sentences;
	}

	private void extractSentencesRecursive(TextComposite composite, List<TextComposite> sentences) {
		if (composite.getType() == TextComponentType.SENTENCE) {
			sentences.add(composite);
			return;
		}

		for (TextComponent child : composite.getChildren()) {
			if (child instanceof TextComposite) {
				extractSentencesRecursive((TextComposite) child, sentences);
			}
		}
	}

	private int countLexemesInSentence(TextComposite sentence) {
		int count = 0;
		for (TextComponent child : sentence.getChildren()) {
			if (child instanceof TextComposite && child.getType() == TextComponentType.LEXEME) {
				count++;
			}
		}
		return count;
	}

	private int findMaxSameWordsCount(TextComposite sentence) {
		Map<String, Integer> wordCount = new HashMap<>();
		countWordsInSentence(sentence, wordCount);

		int maxCount = 0;
		for (int count : wordCount.values()) {
			if (count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}

	private void countWordsInSentence(TextComposite composite, Map<String, Integer> wordCount) {
		if (composite.getType() == TextComponentType.WORD) {
			String word = composite.toString().toLowerCase();
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
			return;
		}

		for (TextComponent child : composite.getChildren()) {
			if (child instanceof TextComposite) {
				countWordsInSentence((TextComposite) child, wordCount);
			}
		}
	}

	private void swapFirstAndLastLexeme(TextComposite sentence) {
		List<TextComponent> children = sentence.getChildren();
		List<Integer> lexemeIndices = new ArrayList<>();

		for (int i = 0; i < children.size(); i++) {
			TextComponent child = children.get(i);
			if (child instanceof TextComposite && child.getType() == TextComponentType.LEXEME) {
				lexemeIndices.add(i);
			}
		}

		if (lexemeIndices.size() >= 2) {
			int firstLexemeIndex = lexemeIndices.get(0);
			int lastLexemeIndex = lexemeIndices.get(lexemeIndices.size() - 1);

			TextComponent firstLexeme = children.get(firstLexemeIndex);
			TextComponent lastLexeme = children.get(lastLexemeIndex);

			sentence.setChild(firstLexemeIndex, lastLexeme);
			sentence.setChild(lastLexemeIndex, firstLexeme);
		}
	}
}