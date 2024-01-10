import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.*;


public class AnimalCrossingTest {

   AnimalCrossing gen;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      gen = new AnimalCrossing();
   }


   /* Tests to make sure that the constructor is initializing the receipt variable correctly.
    * If you are seeing "PLACEHOLDER_STRING" as your actual value, you either aren't initializing 
    * it at all, or you changed the name of the variable */
   @Test public void constructorTest1(){
      String town = "PLACEHOLDER_STRING";
      try{
         /* Note that you do not need to understand how this test works. This is some
          * fancy stuff to get around the fact that these variables are private. You
          * should not try to do this outside of testing, as it defeats the purpose of
          * things being private */
         Field receiptField = AnimalCrossing.class.getDeclaredField("town");
         receiptField.setAccessible(true);
         town = (String)receiptField.get(gen);
      } catch (Exception e){}
      //                   Message for the test                              Expected, Actual
      Assert.assertEquals("town is initialized correctly by constructor", ""      , town);
   }
   
   /* Tests to make sure that the constructor is initializing the total variable correctly.
    * If you are seeing -1 as your actual value, you either aren't initializing it at all,
    * or you changed the name of the variable */
   @Test public void constructorTest2(){
      double total = -1;
      try{
         /* Note that you do not need to understand how this test works. This is some
          * fancy stuff to get around the fact that these variables are private. You
          * should not try to do this outside of testing, as it defeats the purpose of
          * things being private */
         Field totalField = AnimalCrossing.class.getDeclaredField("total");
         totalField.setAccessible(true);
         total = (double)totalField.get(gen);
      } catch (Exception e){}
      // Note that int assertions don't need an acceptable margin of error
      //                   Message for the test                            Expected, Actual, acceptable tolerance
      Assert.assertEquals("total is initialized correctly by constructor", 0       , total , 0.0);
   }
   
   /* Checks to make sure that getTown() returns the correct value after the AnimalCrossing has been created */
   @Test public void getTownTest1(){
      Assert.assertEquals("getTown returns the correct value of the town after initialization", "", gen.getTown());
   }
   
   /* Checks to make sure that getTotalFriendship() returns the correct value after the AnimalCrossing has been created */
   @Test public void getTotalFriendshipTest1(){
      Assert.assertEquals("getTotalFriendship returns the correct value of the total after initialization", 0.0, gen.getTotalFriendship(), 0.0);
   }
   
   /* Checks to make sure that addNewAnimal() returns the correct total after it has been updated*/
   @Test public void addNewAnimalTest1(){
      gen.addNewAnimal("Lucky", 19.43);
      double result = gen.getTotalFriendship();
      Assert.assertEquals("addNewAnimal() returns the correct total after it has been updated the first time", 19.43, result, 0.0);
   }
      
   /* Checks to make sure that addNewAnimal() returns the correct total after it has been updated repeatedly*/
   @Test public void addNewAnimalTest2(){
      gen.addNewAnimal("Lucky", 19.43);
      gen.addNewAnimal("Candy", 0.57);
      gen.addNewAnimal("No.1", 706000000000.0); // see https://en.wikipedia.org/wiki/Build_the_Enterprise
      double result = gen.getTotalFriendship();
      double expected = (19.43 + 0.57 + 706000000000.0);
      Assert.assertEquals("addNewAnimal returns the correct total after being updated multiple times", expected, result, 0.0001);
   }
   
   /* Checks to make sure reset() resets total correctly */
   @Test public void resetTest1(){
      gen.addNewAnimal("Lucky", 19.43);
      gen.addNewAnimal("Candy Candy", 0.57);
      gen.addNewAnimal("No.1", 38000.0);
      gen.reset();
      double result = gen.getTotalFriendship();
      double expected = 0;
      Assert.assertEquals("reset correctly resets the total", expected, result, 0);
   }

}
     