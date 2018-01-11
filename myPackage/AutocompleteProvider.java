package myPackage;

import java.util.*;

/**
 * Tool which shows possible words from a beginning fragment
 * 
 * Implemented as a Ternary Search Tree
 * 
 * @author jayro
 */
public class AutocompleteProvider {
    
    private TSTNode root;
 
    
    
    
    /**
     *      Constructor
     * 
     * sets root to null,
     * starts with completely empty TST
     */
    public AutocompleteProvider(){
             root = null;
    }
    
    
    
    
    /**
     *      toString
     * 
     * @return words contained in TST prefaced by "All Words:"
     * calls PriorityQueue toString method
     */
    public String toString()
    {

        PriorityQueue<Candidate> candidates 
            = traverse( new PriorityQueue<Candidate>(10, Collections.reverseOrder()),root, "");
        return "All Words: "+ candidates.toString();
    }

    
    
    
    
    /**
     *          getWords
     * 
     * @param fragment - beginning of word you are searching for
     * @return - ordered list of word candidates | empty list if there are none
     */
    public List<Candidate> getWords(String fragment){
        
        fragment = fragment.toLowerCase();
        TSTNode  tstNode = search(root, fragment.toCharArray(), 0);
        
       if(tstNode == null)
            return null;
          
       
        PriorityQueue<Candidate> words = this.traverse(new PriorityQueue<>(10,Collections.reverseOrder()),
                                                    tstNode.middle,
                                                    String.valueOf(tstNode.data));
        
        LinkedList<Candidate> candidates = new LinkedList();
        
        while(!words.isEmpty())
            candidates.add(words.poll());
        
        return candidates;
    }
     
     

    
     /**
      *         train
      * 
      * @param text all words within text will be added to the AutocompleteProvider
      */
     public void train(String text){
        
       text = text.toLowerCase();
       String[] words = text.split("[ _?!.,:;]");
       
       for(int i = 0; i < words.length; i++)
           root = insert(root, words[i].toCharArray(), 0);
    }   
    
    
    
     /** 
      *         search
      *         helper method
      * 
      * @param r - root to search from
      * @param word - word to search for 
      * @param ptr - pointer to record current place in word
      * @return TSTNode - node of last letter, of the word searched for | null if not found
      */
     private TSTNode search(TSTNode r, char[] word, int ptr){
         
         
         if (r == null)
             return null;

        if (word[ptr] < r.data)
            return search(r.left, word, ptr);

        else if (word[ptr] > r.data)
             return search(r.right, word, ptr);

        else
        {
              if (ptr == word.length - 1)
                 return r;

            else
                return search(r.middle, word, ptr + 1);
        }        

    }
         
    
    
    
    /**
     *              traverse
     *              Helper method
     * 
     * @param r - node to start traversal at
     * @param str - string that contains the traversal
     */
    private PriorityQueue<Candidate> traverse(PriorityQueue<Candidate> candidates, TSTNode r, String str){
         
        if (r != null){

           traverse(candidates, r.left, str);
           str = str + r.data;

           if (r.isEnd)
               candidates.add( new Candidate(str, r.confidence));

           traverse(candidates, r.middle, str);
           str = str.substring(0, str.length() - 1);

            traverse(candidates, r.right, str);
            
       }
        return candidates;
    }

     
     
     
 
     /**
      *         insert
      *         helper method    
      * 
      * @param r
      * @param word
      * @param ptr
      * @return 
      */
     private TSTNode insert(TSTNode r, char[] word, int ptr)  {
         if (r == null)
             r = new TSTNode(word[ptr]);

         if (word[ptr] < r.data)
            r.left = insert(r.left, word, ptr);

        else if (word[ptr] > r.data)
             r.right = insert(r.right, word, ptr);

        else{

            if (ptr + 1 < word.length)
                 r.middle = insert(r.middle, word, ptr + 1);

            else{
                
                r.isEnd = true;
                r.confidence++;
            }
        }

        return r;

    }
     
     
     
     
    /**-------------------------------------------------------------------------
     * 
     *   private class    TST NODE
     * 
     */
     private class TSTNode{

        char data;
        boolean isEnd;
        TSTNode left, middle, right;
        int confidence;
 
        

        /**
         *      constructor
         * 
         * @param data 
         */
        public TSTNode(char data)

        {
            this.data = data;
            this.isEnd = false;
            this.left = null;
            this.middle = null;
            this.right = null;
            
            confidence = 0;
        }        

    }
    
    
    
}


