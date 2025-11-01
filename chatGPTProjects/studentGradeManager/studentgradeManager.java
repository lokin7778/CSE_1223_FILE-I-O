package chatGPTProjects.studentGradeManager; // directs it to the package

// imported all the necessary modules required for this project
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

            // Arraylist to hold the student marks
            ArrayList<Integer> sMarks = new ArrayList<>(); 

            // nested for-loop to enter the marks for individual subjects
            for (int i = 1; i <= noOfSub; i++){

                System.out.print("Enter marks for subject " + i);
                int sMarki = Integer.parseInt(console.nextLine());

                sMarks.add(sMarki);
            }

            try(BufferedWriter writer = new BufferedWriter(new FileWriter ("studentGrades.txt",true))){

                writer.write(sName);
                for (int j = 0; j < sMarks.size(); j++){

                    writer.write(sMarks.get(j));
                }
                
            }
            catch(IOException e){
                System.err.println("ERROR: " + e.getMessage());
            }

            System.out.println("RECORD SUCCESSFULLY ADDED!");

            System.out.print("Do you want to continue? (Y/N): ");
            String choice = console.nextLine();
            if (choice.equalsIgnoreCase("N")){
                optionToContinue = "N";
            }
            
        }

        console.close();

    }
}