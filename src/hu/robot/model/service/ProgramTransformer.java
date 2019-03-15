package hu.robot.model.service;

public class ProgramTransformer {

	public String transformToNewFormat(String program) {
		String oldFormat = program + " ";
		int counter = 1;
		StringBuilder newFormat = new StringBuilder();
		for (int i = 0; i < program.length(); i++) {
			if (oldFormat.charAt(i) == oldFormat.charAt(i + 1)) {
				counter++;
			} else {
				if (counter > 1) {
					newFormat.append(counter);
				}
				newFormat.append(oldFormat.charAt(i));
				counter = 1;
			}
		}
		return newFormat.toString();
	}
	
	public String transformToOldFormat(String program) {
		StringBuilder oldFormat = new StringBuilder();
		StringBuilder number = new StringBuilder();
		for (int i = 0; i < program.length(); i++) {
			char character = program.charAt(i);
			if (isNumber(character)) {
				number.append(character);
			} else {
				int limit = number.length() > 0 ? Integer.parseInt(number.toString()) : 1; 
				for (int db = 0; db < limit; db++) {
					oldFormat.append(character);
				}
				number = new StringBuilder();
			}
		}
		return oldFormat.toString();
	}
	
	private boolean isNumber(char character) {
		return character >= '0' && character <= '9';
	}
}
