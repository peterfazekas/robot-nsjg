package hu.robot.controller;

import java.util.List;
import java.util.stream.Collectors;

import hu.robot.model.domain.Program;
import hu.robot.model.service.ProgramTransformer;

public class Robot {

	private final ProgramTransformer programTransformer;
	private final List<Program> programs;

	public Robot(ProgramTransformer programTransformer, List<Program> programs) {
		this.programTransformer = programTransformer;
		this.programs = programs;
	}

	public String isSimplified(int id) {
		return getProgram(id).couldBeSimplified();
	}
	
	public String getShortestWayBackToOrigin(int id) {
		return getProgram(id).getShortestWayBackToOrigin();
	}
	
	public String getFarestStepDetail(int id) {
		return getProgram(id).getFarestStepDetail();
	}
	
	public String getLowCapacityBatteryAwarePrograms() {
		return programs.stream()
				.filter(Program::isSmallBatteryCompatible)
				.map(Program::toString)
				.collect(Collectors.joining("\r\n"));
	}
	
	private Program getProgram(int id) {
		return programs.stream().filter(i -> i.getId() == id).findAny().get();
	}
	
	public List<String> transformAllToNewFormat() {
		return programs.stream()
				.map(Program::getCode)
				.map(programTransformer::transformToNewFormat)
				.collect(Collectors.toList());
	}
	
	public String transformtoOldFormat(String program) {
		return programTransformer.transformToOldFormat(program);
	}
}
