import java.util.*;
import java.io.*;

public class Exercise_12_12 {

	public static void main(String[] args) throws Exception {

		if (args.length != 1) {
			System.out.println("Java Exercise_12_12 file");
			System.exit(1);
		}


		File file = new File(args[0]);


		if (!file.exists()) {
			System.out.println("File " + args[0] + " does not exist");
			System.exit(2);
		}


		ArrayList<String> list = new ArrayList<>();
		String stringOne = "";
		String stringTwo = "";

		try (

			Scanner input = new Scanner(file);
		) {

			stringOne = input.nextLine();
			while (input.hasNext()) {
				stringTwo = input.nextLine();
				if (stringTwo.length() > 0 && 
					 stringTwo.charAt(stringTwo.length() - 1) == '{') {
					list.add(stringOne.concat(" {"));
					stringOne = input.nextLine();
				}
				else {
					list.add(stringOne);
					stringOne = stringTwo;
				}
			}
			list.add(stringOne);
		}


		try (

			PrintWriter output = new PrintWriter(file);
		) {
			for (int i = 0; i < list.size(); i++) {
				output.println(list.get(i));
			}
		}
	}
}