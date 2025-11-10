package by.paulouskaya.task2.composite;

public class TextLeaf extends TextComponent {

	private char leaf;

	public TextLeaf(char leaf, TextComponentType type) {
		super(type);
		this.leaf = leaf;
	}

	@Override
	public String toString() {

		return String.valueOf(leaf);
	}
}
