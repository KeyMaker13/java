
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] l ={12,5,6,7,12,53,523,1235,2,1,0};
		
		iSort(l);
		for(int i = 0 ; i<l.length; i++){
			System.out.println(l[i]);
		}
		
		

	}
	
	public static void sSort(int [] list) {
	      for (int index = 0; index < list.length - 1; index++) {
	          int min = findMinPosition(list, index);
	          int temp = list[min];
	          list[min] = list[index];
	          list[index] = temp;
	      }
	   }

	   public static int findMinPosition(int [] list, int start) {
	      int min = start;
	      for (int scan = start + 1; scan < list.length; scan++)
	         if (list[min] > list[scan])
	            min = scan;
	      return min;
	   }
	   
	   
	   public static void iSort (int [] list) {
		      for (int index = 1; index < list.length; index++) {
		         insertItem(list, index);
		      }
		   }

		   public static void insertItem(int [] list, int index) {
		       int key = list[index];
		       int position = index;
		 
		         // shift larger values to the right
		       while (position > 0 && key <(list[position-1]))   {
		          list[position] = list[position-1];
		          position--;
		       }
		       list[position] = key;
		    }

		
		
	

}
