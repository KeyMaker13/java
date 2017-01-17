class Counter {    
	public Counter() {       
		count = 0;   
	} 
	public void increment() {      
		count = count + 1;    
	}    
	public int getValue() {
		return count;    
	}    
	public void reset() {
		count = 0;    
	}    
	private int count = 0; 
}

