/* This class keeps track of the information for a AnimalCrossing town, namely a "town:,
 * which is a String that lists the names and friendships of individual animal that have been joined, 
 * and the total of all friendship for animals in the town.
 * It's methods provide a way to enter and store the names and friendship of the animal joined, 
 * as well as provide a report of each animal and its friendship and the friendship total.
 */
public class AnimalCrossing{
   
   /* Instance variable declarations. */
   private String town;
   private double total;
   
   /* Constructor. Initializes the instance variables to default values. */
   public AnimalCrossing() {
     //TODO 1: Initialize town to the empty string and total to 0.0. 
      town = "";
      total = 0.0;
   }
   
   /* This method adds the name and friendship of an animal to the town and the friendship to the running total.
    * Parameters: name, friendship.
    * For receipt, we want to add the name of the animal, a colon (':'), a tab ('\t'), the friendship, then a newline ('\n').
    *    Example: If name is "Lucky", friendship is 1.50, and the town is empty, after adding
    *    the animal should hold the value "Lucky:\t1.50\n" which, when printed,
    *    will look like "Lucky:   1.50"
    */
   public void addNewAnimal(String name, double friendship){
      //TODO 2: Update the instance variables using the 'name' and 'friendship' parameters.
      town += name + ":" + "\t" + friendship + "\n";
      total = total + friendship;
   }

   /* Returns the town String. */
   public String getTown(){
      //TODO 3: Implement this method.
      return town;
   }
   
   /* Returns the running total.  */
   public double getTotalFriendship(){
      //TODO 4: Implement this method.
      return total;
   }
   
   /* This method resets the instance variables to their default values. */
   public void reset(){
      //TODO 5: Implement this method.
      town = "";
      total = 0.0;
   }
}