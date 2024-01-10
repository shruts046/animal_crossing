/* Tells java that we will need to use the Scanner object, which is
 * in the util library */
import java.util.Scanner;

public class AnimalCrossingMain{
   
   // The main method. This is what runs when the red running man is clicked.
   public static void main(String[] args){
   
      /* Here we initialize the Scanner we will use later, and call it 'scan'.
       * We specify that it will get input from the console by giving it 
       * 'System.in' as a parameter in the constructor */
      Scanner scan = new Scanner(System.in);
      
      /* We also make our town generator so we can use it later, and call
       * it 'townGen'. This statment calls the constructor for AnimalCrossing
       * to create a new AnimalCrossing object that we can use */
      AnimalCrossing townGen = new AnimalCrossing();
   
      System.out.println("Welcome to your town!");
      
      /* The location the user's input will be stored. We initialize it
       * to a value it cannot be in the future so that we know there has not
       * been a choice yet by the user.This value will get overriden almost
       * imediately by our code */
      int userAnswer = -1;
      
      /* A while loop runs whatever is in the code block next to it as long as 
       * the condition inside the parenthises is true. In this case, we want
       * the code to run as long as the user has not chosen 5, which is when
       * they want to quit */
      while(userAnswer != 5){
         // As a note, '\t' is the equivalent of pressing the "tab" key
         System.out.println("Would you like to:");
         System.out.println("\t1) Add an animal to the town");
         System.out.println("\t2) Print your town");
         System.out.println("\t3) Print your total friendship");
         System.out.println("\t4) Reset the town");
         System.out.println("\t5) Quit");
         
         /* We have the scanner wait for the user to put in an int,
          * then assign it to userAnswer */
         userAnswer = Integer.parseInt(scan.nextLine());
         
         // If the user wants to add an animal to the town:
         if(userAnswer == 1){
            // First we want to get the name of the animal
            System.out.println("Please enter the name of your animal:"); 
            String name = scan.nextLine();
            
            // Second we want to get the friendship of the animal
            System.out.println("Please enter the friendship between you and your animal:"); 
            double friendship = Double.parseDouble(scan.nextLine());
            
            /* Once we have the data, we tell the generator to add it to it's running total
             * and take the total friendship calculated and print it */
            townGen.addNewAnimal(name, friendship);
            double totalFriendship = townGen.getTotalFriendship();
            System.out.println("Your current total is: " + totalFriendship);
         }
         // If the user wants to print their town
         else if(userAnswer == 2){
            /* Call the getTown method from the AnimalCrossing object we made.
             * This method returns a String representing the entire town, which we can 
             * then print directly */
            System.out.println("Your town: ");
            System.out.println(townGen.getTown());
         }
         // If the user wants to print their total
         else if(userAnswer == 3){
            /* Call the getTotalFriendship method from the AnimalCrossing object we made.
             * This method returns a int, so we simply print it directly */
            System.out.println("Your current total is: " + townGen.getTotalFriendship());
         }
         // If the user wants to reset their town
         else if(userAnswer == 4){
            /* Unlike it's other methods, AnimalCrossing's reset() method does not
             * return anything, so we don't assign it to a variable or print it's 
             * output */
            townGen.reset();
            System.out.println("Town has been reset");
         }
         /* If the user is done and wants to exit we don't do anything, and when
          * we reach the end of the while loop it will check the condition (which 
          * will be false) and not run the loop again */
          
      } // End of while loop
      
      System.out.println("Goodbye! See you tomorrow!");
   
   }

}