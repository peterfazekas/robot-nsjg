package hu.robot.model.service;

import java.util.ArrayList;
import java.util.List;

import hu.robot.model.domain.Coordinate;
import hu.robot.model.domain.Direction;
import hu.robot.model.domain.Step;

public class StepFactory {

	public List<Step> create(String code) {
		List<Step> steps = new ArrayList<>();
		Step lastStep = createStep(String.valueOf(code.charAt(0)));
		steps.add(lastStep);
		for (int i = 1; i < code.length(); i++) {
			Step step = createStep(lastStep, String.valueOf(code.charAt(i)));
			steps.add(step);
			lastStep = step;
		}
		return steps;
	}
	
	private Step createStep(String dir) {
		Direction direction = Direction.getDirection(dir);
		Coordinate coordinate = direction.getCoordinate(); 
		return new Step(1, coordinate, 3, direction);
	}
	
	private Step createStep(Step lastStep, String dir) {
		Direction direction = Direction.getDirection(dir);
		Coordinate coordinate = lastStep.getCoordinate().moveTo(direction.getCoordinate());
		int id = lastStep.getId() + 1;
		int capacity = lastStep.getCapacity() + (lastStep.getDirection().equals(direction) ? 1 : 3) ;
		return new Step(id, coordinate, capacity, direction);
	}
	
}
