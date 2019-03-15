package hu.robot;

import java.util.Scanner;

import hu.robot.controller.Robot;
import hu.robot.model.service.Console;
import hu.robot.model.service.DataReader;
import hu.robot.model.service.DataWriter;
import hu.robot.model.service.ProgramTransformer;
import hu.robot.model.service.StepFactory;

public class App {

	private final Robot robot;
	private final Console console;
	private final DataWriter writer;
	
	public App() {
		DataReader data = new DataReader(new StepFactory());
		console = new Console(new Scanner(System.in));
		robot = new Robot(new ProgramTransformer(), data.getPrograms("program.txt"));
		writer = new DataWriter("ujprog.txt");
	}
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		int id = console.readInt("2. feladat: Kérem adja meg a program sorszámát: ");
		System.out.println("  a. " + robot.isSimplified(id));
		System.out.println("  b. " + robot.getShortestWayBackToOrigin(id));
		System.out.println("  c. " + robot.getFarestStepDetail(id));
		System.out.println("3. feladat: Kis kapacitású akkuval futtatható programok:\n" + robot.getLowCapacityBatteryAwarePrograms());
		writer.printAll(robot.transformAllToNewFormat());
		String code = console.read("5. feladat: kérem adja meg az új formátumú kódot: ");
		System.out.println(robot.transformtoOldFormat(code));
	}

}
