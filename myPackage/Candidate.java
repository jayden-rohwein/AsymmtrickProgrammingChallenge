package myPackage;

/**
 *represents a possible auto-complete word 
 * 
 *      contains String value of a word
 *      and its confidence level
 * 
 * @author jayro
 */
public class Candidate implements Comparable<Candidate> {
    
    
    private String value;
    private int confidence;
    
    
    
    
    /**
     *      Constructor
     * 
     * @param value - the word represented by this candidate
     * candidates are initialized with a confidence level of 0
     */
    public Candidate(String value){
        this.value = value;
        confidence = 0;
    }
    
    
    
    
    
     /**
     * 
     *      Constructor
     * 
     * @param value - the word represented by this candidate
     * @param confidence - confidence level for candidate
     **/
    public Candidate(String value, int confidence){
        this.value = value;
        this.confidence = confidence;
    }
    
    
    
    
    /**
     *          getValue
     * 
     * @return the String of the word represented 
     */
    public String getValue(){
        return value;
    }
    
    
    
    
    /**
     *      incConfidence
     * 
     * increments the confidence level,
     * used when the same word occurs again
     */
    public void incConfidence(){
        confidence++;
    }
     
    
    
    
    /**
     *      getcConfidence
     * 
     * @return confidence of a word
     */
    public int getConfidence(){
        return confidence;
    }
    
    
    
    
    /**
     *          toString
     * 
     * @return String of the word and its confidence value: word(confidence)
     */
    public String toString(){
        return " " + value + "(" + confidence + ")";
    }
    
    
    
    
    /**
     *          compareTo
     * 
     * compares confidence levels of a word
     * @param word - other candidate to compare to
     * @return 0 equal confidence | 1  this confidence is greater | -1  this confidence is lesser
     */
    public int compareTo(Candidate word){
        
        if(this.getConfidence() == word.getConfidence())
            return 0;
        
        else if(this.getConfidence() > word.getConfidence())
            return 1;
        
        return -1;
    }
    

    


    
}

