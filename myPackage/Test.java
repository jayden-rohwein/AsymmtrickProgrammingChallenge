package myPackage;
import java.util.*;
/**
 *
 * Test the Auto-complete Provider using the console
 * user may: 1 - search | 2 - train | 3 - print all words & confidences | e -exit
 * 
 * search - searches for words that match the fragment
 *          (contain fragment starting at 0 index)
 * 
 * train - add these words to the list of words to train from
 *          words must be separted by " _?!.,:;"
 *          all other characters will be seen as part of the alphabet
 * 
 * 
 * @author jayro
 */
public class Test {

    



     public static void main(String[] args)
     {
         
        
        Scanner scan = new Scanner(System.in);
        AutocompleteProvider acp = new AutocompleteProvider();
        String input;
    
        do{
            
        System.out.println("1 - search | 2 - train | 3 - print out | e - exit");
        input = scan.nextLine();
        if(input.equals("1")){
            
            System.out.println("enter fragment to seach for");
            System.out.println(acp.getWords(scan.nextLine()));
            
        }else if(input.equals("2")){
            System.out.println("enter word(s) to train");
            acp.train(scan.nextLine());        
    
        }else if(input.equals("3")){
            System.out.println(acp.toString());
            
        }else if(input.equals("e")){
            break;
        }else{
            System.out.println("invalid input");
        }
        }while(true);
        
     }

       
}
