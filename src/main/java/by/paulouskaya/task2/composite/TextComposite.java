package by.paulouskaya.task2.composite;

import java.util.ArrayList;

public class TextComposite extends TextComponent {

	private final ArrayList<TextComponent> components = new ArrayList<>();

	public TextComposite(TextComponentType type) {
		super(type);
	}

	public void addComponent(TextComponent component) {
		components.add(component);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < components.size(); i++) {
			TextComponent component = components.get(i);
			builder.append(component.toString());

			switch (getType()) {
			case PARAGRAPH:
				if (i < components.size() - 1) {
					builder.append("\n\t");
				}   
				break;

			case SENTENCE:
				if (i < components.size() - 1) {
					builder.append(". ");
				}
				break;

			case LEXEME:
				if (i < components.size() - 1) {
					builder.append(" ");
				}
				break;

			case WORD:
				if (i < components.size() - 1) {
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
