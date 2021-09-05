import java.util.Scanner; 

public class arrays {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int columns;
		int rows;
		int max = 10;
		int min = 5;
		// initializing variables 
		
		System.out.print("Enter the number of columns. Must be an integer between 5 and 10: ");
		columns = input.nextInt();
		
		while (columns > max || columns < min) {
				System.out.println("Your input is invalid.");
				System.out.println("Enter the number of columns. Must be an integer between 5 and 10: ");
				columns = input.nextInt();
		}
		//lines 14-20 take and validate input for columns
		
		System.out.println("Enter the number of rows. Must be an integer between 5 and 10: ");
		rows = input.nextInt();
		
		while (rows > max || rows < min) {
			System.out.println("Your input is invalid.");
			System.out.println("Enter the number of rows. Must be an integer between 5 and 10: ");
			rows = input.nextInt();
		}
		// takes and validates input for rows

			int [][] Matrix = new int [rows][columns];
			
			System.out.println("Generating random int array with " + columns + " columns and " + rows + " rows");
			System.out.println("-----------------------------------------");
			
			for (int i = 0; i < Matrix.length; i++) {
				for (int j = 0; j < Matrix[i].length; j++) {
					Matrix[i][j] = (int)((Math.random()* 900) + 100); // Generates array with random numbers in bounds
					
					System.out.print(Matrix[i][j] + " "); // prints random int array
				}
				
				System.out.println(); // formats rows 
			}

			System.out.println("-----------------------------------------");
			System.out.println();
			 // statements to call methods
			rings(Matrix);
			System.out.println("Sum of all elements = " + getsum(Matrix));
			System.out.println("Average of all array elements = " + getaverage(Matrix));
			System.out.println();
			outernums(Matrix);
			System.out.println("Sum of outer ring elements = " + outersum(Matrix));
			System.out.println("Average of outer ring elements = " + outeravg(Matrix));
			
	}
	
	public static void rings (int[][] Matrix) {
		
		int rings;
		
		if (Matrix.length % 2 == 0) {
			rings = (Matrix[0].length / 2);
			System.out.println("The number of rings in the array = " + rings);
		}
		else if ((Matrix.length / 2) != 0) {
			rings = ((Matrix.length / 2) + 1);
			System.out.println("The number of rings in the array = " + rings);
		}
	}
	
	public static int getsum (int [][] Matrix) {
		
		int sum = 0;
		
		for (int i = 0; i < Matrix.length; i++) { //traverses through arrays
			for (int j = 0; j < Matrix[i].length; j++) { // traverses through columns in array indexes 
				sum += Matrix[i][j]; // adds all elements in the matrix
			}
		}
		
		return sum; // returns variable sum with new value
	}
	
	public static double getaverage (int [][] Matrix) {
		
		int elements = 0;
		int sum = 0;
		
		for (int i = 0; i < Matrix.length; i++) { // traverses through rows in matrix
			for (int j = 0; j < Matrix[i].length; j++) { // traverses through columns in row index
				sum += Matrix[i][j]; // adds each element
				elements++; // counts each element
			}
		}
		
		return sum / elements;// returns new value as the average 
	}
	
	public static void outernums (int [][] Matrix) {
		
		int count = 0;
		System.out.println("Outer ring elements listed going counter-clockwise: ");
		
		//traverses through top row and left most column
		for (int i = 0; i < Matrix.length; i++) { // traverses through rows in matrix
			for (int j = Matrix[i].length - 1; j >= 0; j--) { // traverses through columns starting at the highest value and decrements by 1
				if (i == 0 || j == 0) { // if in rows[0] and / or column[0]...
					System.out.print(Matrix[i][j] + " "); // ... print element using its index
					count++; // increment outer element num by 1
				}
			}
		}
		
		//traverses through last row and bottom column
		for (int i = 0; i < Matrix.length; i++) { // traverses through rows in matrix
			for (int j = 0; j < Matrix[i].length; j++) { // traverses through columns starting at the lowest value and increments by 1
				if (i == Matrix.length - 1 && j == 0) // if in bottom left corner...
				System.out.print(""); // print nothing to avoid printing element twice
			else if (i == Matrix.length - 1) { // if not...
				System.out.print(Matrix[i][j] + " "); // .. print the element 
				count++; // add 1 to count
			}	
			}
		}
		
		for (int i = Matrix.length - 1; i >= 0; i--) //traverses through rows starting from the bottom
			for (int j = Matrix[i].length - 1; j >= 0; j--) { //traverses through the column starting from the bottom 
				if (i == Matrix.length - 1 && j == Matrix[i].length - 1) //if in the bottom right corner...
					System.out.print(""); // ...do not print
				else if (i == 0 && j == Matrix[i].length - 1)  //if in the top right corner...
					System.out.print(""); // ...do not print
				else if (j == Matrix[i].length - 1) { // if not...
					System.out.print(Matrix[i][j] + " "); // .. print the element 
					count++; // add 1 to count
				}
			}
		
		System.out.println();
		System.out.println("Number of elements in outer ring = " + count); // display new value for count
	}
	
	public static int outersum (int [][] Matrix) {
		
		int sum = 0;
		
		for (int i = 0; i < Matrix.length; i++) { // traverses through rows in matrix
			for (int j = 0; j < Matrix[i].length; j++) { // traverses through columns in row index
				if (i == 0) 
					sum += Matrix[i][j];
				else if (i == Matrix.length - 1)
					sum += Matrix[i][j];
				else if (j == 0)
					sum += Matrix[i][j];
				else if (j == Matrix[i].length - 1)
					sum += Matrix[i][j];
				// loop to add element to sum if conditions are true
			}
		}
		
		return sum; // returns new value of sum
	}
	
	public static double outeravg (int [][] Matrix) {
		
		int elements = 0;
		int sum = 0;
		
		for (int i = 0; i < Matrix.length; i++) { // traverses through rows in matrix
			for (int j = 0; j < Matrix[i].length; j++) { // traverses through columns in row index
				if (i == 0) {
					sum += Matrix[i][j];
					elements++;
				}
				else if (i == Matrix.length - 1) {
					sum += Matrix[i][j];
					elements++;
				}
				else if (j == 0) {
					sum += Matrix[i][j];
					elements++;
				}
				else if (j == Matrix[i].length - 1) {
					sum += Matrix[i][j];
				elements++;
				}
			}
		} // loop to add element to sum and count num of elements if conditions are true
		
		return sum / elements; // returns average
	}
	
}
