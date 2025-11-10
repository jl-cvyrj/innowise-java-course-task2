package by.paulouskaya.task2.composite;

public abstract class TextComponent {

	private TextComponentType type;

	public TextComponent(TextComponentType type) {
		this.type = type;
	}

	public TextComponentType getType() {
		return type;
	}

	public void setType(TextComponentType type) {
		this.type = type;
	}

	public abstract String toString();
}
