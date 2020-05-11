import java.util.Scanner;
import java.util.Random;

public class MathTutor{

	// Function to print the heading.
	public static void printIntro(){
		System.out.println("**********************************");
		System.out.println("     Electronic Math Tutor     ");
		System.out.println("**********************************");
	}

	//Function to display the menu, loop over until user decides to end.
	public static void displayMenu(Scanner sc){
		boolean iterate = true;
		while(iterate == true){
			//choice will hold the user menu option selected.
			//largestOperand will hold the user specified largest operand.
			//numOfProblems will hold the amount of problems to solve.
			int choice, largestOperand, numOfProblems;
			System.out.println("Choose the type of problem: ");
			System.out.println("1. Addition");
			System.out.println("2. Multiplication");
			System.out.println("3. Mixed");
			System.out.println("4. Quit");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			//Determining to continue if user did not select option 4 in the menu to quit.
			if(choice != 4){
				System.out.print("How many problems? ");
				numOfProblems = sc.nextInt();
				sc.nextLine();
				System.out.print("Largest operand? ");
				largestOperand = sc.nextInt();
				sc.nextLine();
				//Calling the problemGame function to the corresponding menu option selected by the user.
				problemGame(choice, largestOperand, numOfProblems, sc);
				System.out.println(" ");
			}else{
				System.out.println(" ");
				System.out.println("Thanks for playing.");
				System.out.println(" ");
				iterate = false;
			}
		
		}
	}

	//Function if user enters choices (1, 2, or 3)
	public static void problemGame(int choice, int largestOperand, int numOfProblems, Scanner sc){
		Random rnd = new Random();
		//oprandOne, operandTwo will hold the random generated numbers up to the largest operand the user enters.
		//userAnswer holds the answer the user types in.
		//answer holds the true answer.
		//questionsRight holds the amount of times the user entered the correct answer.
		int operandOne, operandTwo, userAnswer, answer, questionsRight;
		questionsRight = 0;
		if (choice == 1){
			//Calling choiceOne function to play the addition game. Will return questionsRight.
			questionsRight = choiceOne(largestOperand, numOfProblems, sc);
		}else if(choice == 2){
			//Calling choiceTwo function to play the Multiplication game. Will return questionsRight.
			questionsRight = choiceTwo(largestOperand, numOfProblems, sc);
		}else{
			for(int i = 0; i < numOfProblems; i++){
				//Random number from 0 and 1. 0 will determine Addition. 1 will determine Multiplication.
				int randomMixed = rnd.nextInt(2);
				//Calling choiceThree function to play the mixed game. Will return questionsRight.
				questionsRight += choiceThree(largestOperand, numOfProblems, sc, randomMixed);
			}
		}
		//AFTER THE GAME CHOICE(S) END, PROGRAM WILL CONTINUE HERE.
		//percentageOfScore holds the percentace of the total score.
		double percentageOfScore = ((double) questionsRight / numOfProblems) * 100;
		System.out.println(" ");
		System.out.printf("You answered %d of %d correctly.\n", questionsRight, numOfProblems);
		System.out.printf("Your percentage score was a %.2f.\n", percentageOfScore);
	}
	//Function for if the user enters choice one.
	public static int choiceOne(int largestOperand, int numOfProblems, Scanner sc){
		Random rnd = new Random();
		//oprandOne, operandTwo will hold the random generated numbers up to the largest operand the user enters.
		//userAnswer holds the answer the user types in.
		//answer holds the true answer.
		//questionsRight holds the amount of times the user entered the correct answer.
		int operandOne, operandTwo, userAnswer, answer, questionsRight;
		questionsRight = 0;
			for(int i = 0; i < numOfProblems; i++){
				operandOne = 1 + rnd.nextInt(largestOperand);
				operandTwo = 1 + rnd.nextInt(largestOperand);
				System.out.printf("%d + %d = ? ", operandOne, operandTwo);
				userAnswer = sc.nextInt();
				sc.nextLine();
				answer = operandOne + operandTwo;
				//Displaying to the user if the answer typed was correct/incorrect.
				if(userAnswer == answer){
					System.out.println("Correct!");
					questionsRight += 1;
				} else{
					System.out.printf("Incorrect. The answer is: %d.\n", answer);
					}
				}
		return questionsRight;
	}
	//Function for if the user enters choice two.
	public static int choiceTwo(int largestOperand, int numOfProblems, Scanner sc){
		Random rnd = new Random();
		//oprandOne, operandTwo will hold the random generated numbers up to the largest operand the user enters.
		//userAnswer holds the answer the user types in.
		//answer holds the true answer.
		//questionsRight holds the amount of times the user entered the correct answer.
		int operandOne, operandTwo, userAnswer, answer, questionsRight;
		questionsRight = 0;
			for(int i = 0; i < numOfProblems; i++){
				operandOne = 1 + rnd.nextInt(largestOperand);
				operandTwo = 1 + rnd.nextInt(largestOperand);
				System.out.printf("%d * %d = ? ", operandOne, operandTwo);
				userAnswer = sc.nextInt();
				sc.nextLine();
				answer = operandOne * operandTwo;
				//Displaying to the user if the answer typed was correct/incorrect.
				if(userAnswer == answer){
					System.out.println("Correct!");
					questionsRight += 1;
				} else{
					System.out.printf("Incorrect. The answer is: %d.\n", answer);
					}
				}
		return questionsRight;
	}
	//Function for if the user enters choice three.
	public static int choiceThree(int largestOperand, int numOfProblems, Scanner sc, int randomMixed){
		Random rnd = new Random();
		//oprandOne, operandTwo will hold the random generated numbers up to the largest operand the user enters.
		//userAnswer holds the answer the user types in.
		//answer holds the true answer.
		//questionsRight holds the amount of times the user entered the correct answer.
		int operandOne, operandTwo, userAnswer, answer, questionsRight;
		questionsRight = 0;
		if(randomMixed == 0){
			//Do Addition.
			operandOne = 1 + rnd.nextInt(largestOperand);
			operandTwo = 1 + rnd.nextInt(largestOperand);
			System.out.printf("%d + %d = ? ", operandOne, operandTwo);
			userAnswer = sc.nextInt();
			sc.nextLine();
			answer = operandOne + operandTwo;
			//Displaying to the user if the answer typed was correct/incorrect.
			if(userAnswer == answer){
				System.out.println("Correct!");
				questionsRight += 1;
			}else{
				System.out.printf("Incorrect. The answer is: %d.\n", answer);
				}
		}else{
			//Do Multiplication.
			operandOne = 1 + rnd.nextInt(largestOperand);
			operandTwo = 1 + rnd.nextInt(largestOperand);
			System.out.printf("%d * %d = ? ", operandOne, operandTwo);
			userAnswer = sc.nextInt();
			sc.nextLine();
			answer = operandOne * operandTwo;
			//Displaying to the user if the answer typed was correct/incorrect.
			if(userAnswer == answer){
				System.out.println("Correct!");
				questionsRight += 1;
			} else{
				System.out.printf("Incorrect. The answer is: %d.\n", answer);
				}
			}

			return questionsRight;
		} 


	//MAIN
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		printIntro();
		displayMenu(sc);
	}
}