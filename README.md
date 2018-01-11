# AsymmtrickProgrammingChallenge


Auto-complete Provider



What is this

        Auto-complete Provider use is to analyze passages of text, in order to create
        a list of word-suggestions for future use. It can then suggest possible words
        from the beginning fragment of a word. Auto-complete Provider prioritizes 
        the frequency of words.




How to Test

        Test the Auto-complete Provider using the console
        user may: 1 - search | 2 - train | 3 - print all words & confidences | e -exit

        search - searches for words that match the fragment
                 (contain fragment starting at 0 index)

        train - add these words to the list of words to train from
                 words must be separted by " _?!.,:;"
                 all other characters will be seen as part of the alphabet


How to Use
      
        these are the only two methods required to achieve the function
        of Auto-complete Provider.

        
        LinkedList<Candidates> getWords(String fragment)
            @param fragment - beginning of word you are searching for
            @return - ordered list of word candidates | empty list if there are none


      
        void train(text)
            param text - the passage containing all words 
            that will be added to the AutocompleteProvider

            doesn't return anything, just adds the words
            to Autocomplete Providers "dictionary"



Constraint
Specification

    We are developing a keyboard autocomplete algorithm to be used in various 
    mobile devices. This algorithm will analyze the passages typed by the user 
    in order to suggest a set of candidate autocomplete words given a word fragment

        Candidate
            String getWord() : returns the autocomplete candidate
            Integer getConfidence() : returns the confidence* for the candidate

        AutocompleteProvider
            List<Candidate> getWords(String fragment) : returns list of candidates ordered by confidence*
            void train(String passage) : trains the algorithm with the provided passage




Implementation 


    Autocomplete Provider is implemented as a  Ternary Search Tree, this is an 
    efficient solution given that many words "share letters" or nodes. While this
    does contain more overhead then other solutions, the vast quantity of words 
    justifies its use.

    The TST implementation does not play nice with the Candidate specification, as
    there would be no need to store complete words explicitly with a TST, given the
    restraints of the problem I still feel this was an effective solution.

    a priorityQueue is used to sort the candidates based on there confidence. This
    does not inherit from List and must be placed in a Linked List. Depending on
    the context of the problem this might have been better handled. Given my interpretation,
    I "assumed" only a the few top results are useful for word suggestion, and 
    exact ordering might not be that important given this is only a mobile keyboard. 
    I thought a heap would be the most efficient way to handle such a problem.





  
  
 author jayro
 
