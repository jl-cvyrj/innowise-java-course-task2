package by.paulouskaya.task2.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends TextComponent {

	private final ArrayList<TextComponent> componentArray = new ArrayList<>();

	public TextComposite(TextComponentType type) {
		super(type);
	}

	public void addComponent(TextComponent component) {
		componentArray.add(component);
	}
	
	public List<TextComponent> getChildren() {
    return new ArrayList<>(componentArray);
}

public void setChild(int index, TextComponent component) {
    if (index >= 0 && index < componentArray.size()) {
        componentArray.set(index, component);
    }
}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < componentArray.size(); i++) {
			TextComponent component = componentArray.get(i);
			builder.append(component.toString());

			switch (this.getType()) {
			case TEXT:
				if (i < componentArray.size() - 1) {
            builder.append("\n\t");
				}  
				break;
				
			case PARAGRAPH:
				if (i < componentArray.size() - 1) {
            builder.append(" ");
				}   
				break;

			case SENTENCE:
		    if (i < componentArray.size() - 1) {
		        TextComponent nextComponent = componentArray.get(i + 1);
		        if (nextComponent.getType() == TextComponentType.LEXEME) {
		            builder.append(" ");
		        }
		    }
		    break;

			case LEXEME:
				break;

			case PUNCTUATION:
				break;
				
			case WORD:
				break;

			case SYMBOL:
				break;

			}
		}
		return builder.toString();
	}
	
}