
public class Rectangle {
	
	private static double length;
	private static double width;
	
	public Rectangle(double len,double wid){
		length = len;
		width = wid;
	}
	public static double area (){
		double area = length * width;
		return area;
	}
	public static double perimeter(){
		double perimeter = (length + length)+(width + width);
		return perimeter;
	}
	public static double getLength() {
		return length;
	}
	public static double getWidth() {
		return width;
	}
	public static void setLength(double length) {
		Rectangle.length = length;
		
	}
	public static void setWidth(double width) {
		Rectangle.width = width;
		
	}
	
	

}
