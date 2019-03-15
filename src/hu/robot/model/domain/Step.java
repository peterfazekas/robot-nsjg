package hu.robot.model.domain;

public class Step {

	private final int id;
	private final Coordinate coordinate;
	private final int capacity;
	private final Direction direction;

	public Step(int id, Coordinate coordinate, int capacity, Direction direction) {
		this.id = id;
		this.coordinate = coordinate;
		this.capacity = capacity;
		this.direction = direction;
	}

	public int getId() {
		return id;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public int getCapacity() {
		return capacity;
	}

	public Direction getDirection() {
		return direction;
	}
	
	public double getDistance() {
		return coordinate.getDistance();
	}

	@Override
	public String toString() {
		return coordinate.toString();
	}
	
}
