package hu.robot.model.domain;

import java.util.Comparator;
import java.util.List;

public class Program {

	private static final String[] OPPOSITIONS = {"ED", "DE", "KN", "NK"};
	
	private final int id;
	private final String code;
	private final List<Step> steps;
	
	public Program(int id, String code, List<Step> steps) {
		this.id = id;
		this.code = code;
		this.steps = steps;
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String couldBeSimplified() {
		return isSimplified() ? "A program egyszerűsíthető" : "A program nem egszerűsíthető";
	}
	
	private boolean isSimplified() {
		boolean simplified = false;
		for (String opposition : OPPOSITIONS) {
			simplified |= code.contains(opposition);
		}
		return simplified;
	}
	
	public String getShortestWayBackToOrigin() {
		return getLastStep().toString();
	}
	
	public String getFarestStepDetail() {
		return String.format("A program futása során a %d. lépésben volt legtávolabb, tavolsága: %5.3f cm", 
				getFarestStep().getId(), getFarestStep().getDistance());
	}
	
	private Step getFarestStep() {
		return steps.stream()
				.sorted(Comparator.comparing(Step::getDistance).reversed())
				.findFirst()
				.get();
	}
	
	private Step getLastStep() {
		return steps.get(steps.size() - 1);
	}

	public boolean isSmallBatteryCompatible() {
		return getLastStep().getCapacity() <= 100;
	}
	
	@Override
	public String toString() {
		return id + " " + getLastStep().getCapacity();
	}
	
	
}
	
