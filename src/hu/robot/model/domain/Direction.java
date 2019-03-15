package hu.robot.model.domain;

public enum Direction {

	E(new Coordinate(0, 1)),
	D(new Coordinate(0, -1)),
	K(new Coordinate(1, 0)),
	N(new Coordinate(-1, 0));
	
	private final Coordinate coordinate;

	private Direction(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public static Direction getDirection(String dir) {
		return Direction.valueOf(dir);
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
}
