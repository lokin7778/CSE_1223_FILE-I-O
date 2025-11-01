package chatGPTProjects.studentGradeManager; // directs it to the package

// imported all the necessary modules required for this project
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class studentgradeManager{

    public static void main(String[] args) {
        
        // creates a scanner object 'console'
        Scanner console = new Scanner(System.in);

        // creates a variable to be the while-loop counter variable
        String optionToContinue = "Y";

        // while-loop to ask the user input
        while(optionToContinue.equalsIgnoreCase("Y")){

            System.out.print("Enter the student name: ");
            String sName = console.nextLine();

            System.out.print("Enter how many subjects do you want to enter the grades for: ");
            int noOfSub = Integer.parseInt(console.nextLine()); 

            // try block to carry out the executions we want
            try(BufferedWriter writer = new BufferedWriter(new FileWriter ("studentGrades.txt",true))){

                writer.write(sName); // writes the student's marks into the .txt file
                writer.write("\t\t");

                // nested for-loop to enter the marks for individual subjects
                for (int i = 1; i <= noOfSub; i++){

                    System.out.print("Enter marks for subject " + i + ": ");
                    int sMarki = Integer.parseInt(console.nextLine());
                    writer.write(sMarki + ", "); // writes the marks onto the .txt file
                }

                writer.newLine(); // goes to a newline for the next-record if entered
            }
            catch(IOException e){
                System.err.println("ERROR: " + e.getMessage()); // exception handling 
            }

            System.out.println("RECORD SUCCESSFULLY ADDED!");

            System.out.print("Do you want to continue? (Y/N): ");
            String choice = console.nextLine();
            if (choice.equalsIgnoreCase("N")){
                optionToContinue = "N"; // exits the while-loop as well as the program
                
            }
        }
        console.close(); // closes the scanner object 'console'

    }
}