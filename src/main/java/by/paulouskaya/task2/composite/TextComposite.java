package by.paulouskaya.task2.composite;

import java.util.ArrayList;

public class TextComposite extends TextComponent {

	private final ArrayList<TextComponent> componentArray = new ArrayList<>();

	public TextComposite(TextComponentType type) {
		super(type);
	}

	public void addComponent(TextComponent component) {
		componentArray.add(component);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < componentArray.size(); i++) {
			TextComponent component = componentArray.get(i);
			builder.append(component.toString());

			switch (getType()) {
			case PARAGRAPH:
				if (i < componentArray.size() - 1) {
					builder.append("\n\t");
				}   
				break;

			case SENTENCE:
				if (i < componentArray.size() - 1) {
					builder.append(". ");
				}
				break;

			case LEXEME:
				if (i < componentArray.size() - 1) {
					builder.append(" ");
				}
				break;

			case WORD:
				if (i < componentArray.size() - 1) {
					builder.append(" ");
				}
				break;

			case SYMBOL:
				break;

			}

		}
		return builder.toString();
	}

}
