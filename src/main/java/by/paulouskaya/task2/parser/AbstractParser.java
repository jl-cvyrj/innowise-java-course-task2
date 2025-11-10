package by.paulouskaya.task2.parser;

import by.paulouskaya.task2.composite.TextComposite;

public abstract class AbstractParser {
	
	private AbstractParser nextParser;
	
	public AbstractParser(AbstractParser nextParser) {
		this.nextParser = nextParser;
	}
	
	public AbstractParser getNextParser() {
		return nextParser;
	}

	public void setNextParser(AbstractParser nextParser) {
		this.nextParser = nextParser;
	}

	public abstract void parseComponent(String component, TextComposite textComposite);

}
