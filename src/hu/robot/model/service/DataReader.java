package hu.robot.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hu.robot.model.domain.Program;

public class DataReader {

	private final StepFactory stepFactory;
	private int id;
	
	public DataReader(StepFactory stepFactory) {
		this.stepFactory = stepFactory;
		id = 0;
	}

	public List<Program> getPrograms(String fileName) {
		return parse(read(fileName));
	}
	
	private List<Program> parse(List<String> lines) {
		lines.remove(0);
		return lines.stream().map(this::createProgram).collect(Collectors.toList());
	}
	
	private Program createProgram(String line) {
		return new Program(++id, line, stepFactory.create(line));
	}
	
	private List<String> read(String fileName) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
