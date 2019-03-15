package hu.robot.model.domain;

public class Coordinate {

	private final int x;
	private final int y;
	
	public Coordinate() {
		this(0, 0);
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Coordinate moveTo(Coordinate vector) {
		return new Coordinate(x + vector.getX(), y + vector.getY());
	}
	
	public double getDistance() {
		return Math.sqrt(x * x + y * y);
	}

	@Override
	public String toString() {
		return String.format("%d l�p�s kell tenni az ED, %d l�p�st a KN tengely ment�n.", Math.abs(y), Math.abs(x));
	}
	
	
}
