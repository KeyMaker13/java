package dataStructures;

public class LevelElement <T>{
	private T element;
	private int level;
	private boolean leaf;
	
	public LevelElement(T element, int level, boolean leaf) { //O(1)
		this.element = element;
		this.level = level;
		this.leaf = leaf;
	}
	
	public T getElement() { //O(1)
		return element;
	}
	
	public int getLevel() { //O(1)
		return level;
	}
	
	public boolean isLeaf () { //O(1)
		return leaf;
	}
	
	public String toString() { //O(1)
		return element + ": level = " + level + ", isLeaf = " + isLeaf();
	}
}
