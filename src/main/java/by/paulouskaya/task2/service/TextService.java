package by.paulouskaya.task2.service;

import java.util.List;

import by.paulouskaya.task2.composite.TextComposite;

public interface TextService {

  int findMaxNubmerOfSentencesWithEqualWords(TextComposite textComposite);

  List<TextComposite> sortSentencesByCountLexeme(TextComposite textComposite);
  
  void swapFirstAndLastLexemeInEachSentence(TextComposite textComposite);
  
}
