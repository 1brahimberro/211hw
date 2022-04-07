public class Exercise_13_07 {

	public static void main(String[] args) {

		GeometricObject[] squares = {new Square(4.5), new Square(14), 
			new Square(8.2), new Square(12), new Square(10)};

		for (int i = 0; i < squares.length; i++) {
		 	System.out.println("\nSquare #" + (i + 1));
		 	System.out.println("Area: " + squares[i].getArea());
		 	System.out.println("How to color: " + ((Square)squares[i]).howToColor());
		 } 
	}
}


public interface Colorable {

	String howToColor();
}


public abstract class GeometricObject {
	private String color = "while";
	private boolean filled;
	private java.util.Date dateCreated;


	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}


	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
			" and filled: " + filled;
	}


	public abstract double getArea();


	public abstract double getPerimeter();
}

public class Square extends GeometricObject implements Colorable {
	private double side;

	public Square() {
	}

	public Square(double side) {
		this.side = side;
	}

	public Square(double side, String color, boolean filled) {
		super(color, filled);
		setSide(side);
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	@Override
	public double getArea() {
		return Math.pow(side, 2);
	}

	@Override
	public double getPerimeter() {
		return side * 4;
	}

	@Override
	public String howToColor() {
		return "Color all four sides";
	}

	@Override
	public String toString() {
		return super.toString() + "\nSide: " + side + "\nArea: " + getArea()
			+ "\nPerimeter: " + getPerimeter();
	}
}