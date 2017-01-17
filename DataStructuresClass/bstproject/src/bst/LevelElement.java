package bst;

public class LevelElement <T>{
	private T element;
	private int level;
	private boolean leaf;
	
	public LevelElement(T element, int level, boolean leaf) {
		this.element = element;
		this.level = level;
		this.leaf = leaf;
	}
	
	public T getElement() {
		return element;
	}
	
	public int getLevel() {
		return level;
	}
	
	public boolean isLeaf () {
		return leaf;
	}
	
	public String toString() {
		return element + ": level = " + level + ", isLeaf = " + isLeaf();
	}
}
