import java.io.File;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class TwoDArrayFun {

	// Global variables.
	static int rows;
	static int cols;
	static int highestAvgRow = 0;
	static int highestAvgCol = 0;
	static int lowestAvgRow = 0;
	static int lowestAvgCol = 0;

	// Displaying Menu each time until user enter '-1'
	final static String USER_MENU = "Option 1: Enter number of Rows, Columns, and Range for array values.\n"
			+ "Option 2: Enter file name. \n" + "Option 3: Enter -1 to exit. \n"
			+ "Enter (1 or 2 or -1) as your choice: ";

	// Main Method is holding minimum code.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Looping till the user enter '-1' to exit.
		do {
			System.out.print(USER_MENU);

			// Allows user to input a number
			int choice = input.nextInt();

			switch (choice) {
			case 1:
				option1();
				break;
			case 2:
				option2();
				break;
			case -1:
				System.out.println("Exiting..."); // exit if user enter '-1'
													// otherwise loop
				System.exit(0);
			default:
				System.out.println("Wrong choice. Please try again!"); // Handle wrong input value
				break;
			}
		} while (true);
	}

	// Logic for option 1
	public static void option1() {

		Scanner input = new Scanner(System.in);

		System.out.println("\nEnter the number of rows : ");
		rows = input.nextInt();

		if (rows <= 0) {
			System.out.println("Sorry, that is an invalid input, program will now close");
			System.exit(1);
		}

		System.out.println("Enter the number of columns : ");
		cols = input.nextInt();

		if (cols <= 0) {
			System.out.println("Sorry, that is an invalid input, program will now close");
			System.exit(1);
		}

		System.out.println("Enter the minimum of the range : ");
		int minimum = input.nextInt();

		if (minimum < 0) {
			System.out.println("Sorry, that is an invalid input, program will now close");
			System.exit(1);
		}

		System.out.println("Enter the maximum of the range : ");
		int maximum = input.nextInt();

		if (maximum <= minimum) {
			System.out.println("The maximum value should be greater than minimum value.");
			System.exit(1);
		}

		int[][] myArray = new int[rows][cols];

		// Fill array with random numbers.
		for (int row = 0; row < myArray.length; row++) {
			for (int column = 0; column < myArray[row].length; column++) {
				myArray[row][column] = minimum + (int) (Math.random() * ((maximum - minimum) + 1));
			}

		}

		// Calling this function to display consolidated result for current array values.
		showResult(myArray);

	}

	// 7: Display the row and col with the lowest average.
	private static void lowestAverage() {
		System.out.println("Lowest average of row = " + lowestAvgRow);
		System.out.println("Lowest average of column = " + lowestAvgCol);
	}

	// 6 : Display the row and col with the highest average.
	private static void highestAverage() {
		System.out.println("Highest average of row = " + highestAvgRow);
		System.out.println("Highest average of column = " + highestAvgCol);
	}

	// 5:Calculate and display the sum and average of the major and minor diagonals
	private static void sumAvgOfDiagonals(int[][] arr) {

		int sumOfMajorDiagonal = 0;
		int sumOfMinorDiagonal = 0;
		int count = 0;
		for (int i = 0, j = 0; i < rows && j < cols; i++, j++) {
			sumOfMajorDiagonal = sumOfMajorDiagonal + arr[i][j];
			count++;

		}
		System.out.println("Sum of major diagonal = " + sumOfMajorDiagonal);
		if (count != 0)
			System.out.println("Average of major diagonal = " + sumOfMajorDiagonal / count);

		count = 0;
		for (int i = 0, j = cols - 1; i < rows && j >= 0; i++, j--) {
			sumOfMinorDiagonal = sumOfMinorDiagonal + arr[i][j];
			count++;

		}
		System.out.println("Sum of minor diagonal = " + sumOfMinorDiagonal);
		if (count != 0)
			System.out.println("Average of minor diagonal = " + sumOfMinorDiagonal / count);

	}

	// 4: Calculate and display the sum and average of each column.
	private static void sumAvgOfEachColumn(int[][] arr) {

		for (int column = 0; column < cols; column++) {
			int sum = 0;
			int count = 0;
			int avg;

			for (int row = 0; row < rows; row++) {
				sum = sum + arr[row][column];
				count++;
			}

			System.out.println("Sum of column" + column + " = " + sum);
			avg = sum / count;
			System.out.println("Average of column" + column + " = " + avg);

			if (avg > highestAvgCol) {
				highestAvgCol = avg;
			}

			if (column == 0)
				lowestAvgCol = avg;

			if (avg < lowestAvgCol) {
				lowestAvgCol = avg;
			}
		}
	}

	// 3 : Calculate and display the sum and average of each row.
	private static void sumAvgOfEachRow(int[][] arr) {
		for (int row = 0; row < rows; row++) {
			int sum = 0;
			int count = 0;
			int avg;
			for (int column = 0; column < cols; column++) {
				sum = sum + arr[row][column];
				count++;
			}

			System.out.println("Sum of row" + row + " = " + sum);
			avg = sum / count;
			System.out.println("Average of row" + row + " = " + avg);

			if (avg > highestAvgRow) {
				highestAvgRow = avg;
			}

			if (row == 0)
				lowestAvgRow = avg;

			if (avg < lowestAvgRow) {
				lowestAvgRow = avg;
			}
		}
	}

	// 2: Calculate and display the sum and average of the entire array.
	private static void sumAvgOfArray(int[][] arr) {
		int sum = 0;
		int count = 0;

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < cols; column++) {
				sum = sum + arr[row][column];
				count++;
			}
		}

		System.out.println("Sum = " + sum);
		System.out.println("Average = " + sum / count);
	}

	// 1: Printing the array
	public static void print2DArray(int[][] arr) {
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < cols; column++) {
				System.out.print("[" + arr[row][column] + "]" + "  ");
			}
			System.out.println();
		}
	}

	// Logic for option 2 which is holding option A and B further.
	public static void option2() {
		Scanner input = new Scanner(System.in);

		System.out.println("Press 1. To enter the name of the file");
		System.out.println("Press 2. To use JFileChooser to read data from an input file");
		System.out.println("Enter (1 or 2)");

		// Allows user to input a number
		int choice = input.nextInt();

		// Switch method
		switch (choice) {
		case 1:
			option2A();
			break;
		case 2:
			option2B();
			break;
		default:
			System.out.println("Wrong choice. Please try again!"); // Handle wrong input value
			break;
		}
	}

	// Option 2B. To use JFileChooser to read data from an input file
	public static void option2B() {
		String selectedFile;

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		/*
		 * This will display the JFileChooser dialog box and all the user to
		 * choose a file. We want to store the int returned so we can make a
		 * decision based on that.
		 */
		int jfcUserOption = jfc.showOpenDialog(null);

		// Option for when the user correctly chose the file
		if (jfcUserOption == JFileChooser.APPROVE_OPTION) {
			File chosenFile = jfc.getSelectedFile();
			selectedFile = chosenFile.getAbsolutePath();
			System.out.println("The file you chose was: " + selectedFile);

			Scanner sc;
			try {
				File file = new File(selectedFile);
				sc = new Scanner(file);

				rows = sc.nextInt();
				cols = sc.nextInt();
				int[][] myArray = new int[rows][cols];

				for (int row = 0; row < rows; row++) {
					for (int column = 0; column < cols; column++) {
						myArray[row][column] = sc.nextInt();
					}
				}

				// Calling this function to display consolidated result for current
				// array values.
				showResult(myArray);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// option if the user chose the cancel button
		else if (jfcUserOption == JFileChooser.CANCEL_OPTION) {
			System.out.println("You chose cancel");
			System.exit(-1);
		}
		// option if there was some kind of error
		else if (jfcUserOption == JFileChooser.ERROR_OPTION) {
			System.out.println("There was some error!");
			System.exit(-1);
		}
	}

	// Option 2A : Reading input array from file
	public static void option2A() {
		Scanner input = new Scanner(System.in);
		Scanner sc;
		try {
			System.out.print("Enter the file name with extension : ");

			String str = input.next();
			File file = new File(str);
			sc = new Scanner(file);

			rows = sc.nextInt();
			cols = sc.nextInt();
			int[][] myArray = new int[rows][cols];

			for (int row = 0; row < rows; row++) {
				for (int column = 0; column < cols; column++) {
					myArray[row][column] = sc.nextInt();
				}
			}
			// Calling this function to display consolidated result for current
			// array values.
			showResult(myArray);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void showResult(int[][] myArray) {
		System.out.println("\n-------------------------------------------------------");
		System.out.println("1: The array in table format");
		print2DArray(myArray);
		System.out.println("-------------------------------------------------------\n\n");

		System.out.println("\n-------------------------------------------------------");
		System.out.println("2: Sum and Average of the entire array");
		sumAvgOfArray(myArray);
		System.out.println("-------------------------------------------------------\n\n");

		System.out.println("\n-------------------------------------------------------");
		System.out.println("3: Sum and Average of each row");
		sumAvgOfEachRow(myArray);
		System.out.println("-------------------------------------------------------\n\n");

		System.out.println("\n-------------------------------------------------------");
		System.out.println("4: Sum and Average of each column");
		sumAvgOfEachColumn(myArray);
		System.out.println("-------------------------------------------------------\n\n");

		System.out.println("\n-------------------------------------------------------");
		System.out.println("5: Sum and Average of the major and minor diagonals");
		sumAvgOfDiagonals(myArray);
		System.out.println("-------------------------------------------------------\n\n");

		System.out.println("\n-------------------------------------------------------");
		System.out.println("6: Row and Col with the highest average.");
		highestAverage();
		System.out.println("-------------------------------------------------------\n\n");

		System.out.println("\n-------------------------------------------------------");
		System.out.println("7: Row and Col with the lowest average.");
		lowestAverage();
		System.out.println("-------------------------------------------------------\n\n");
	}
}