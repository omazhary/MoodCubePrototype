package moodcube.nlp.text;

/**
 * This class tokenizes text to various degrees.
 * @author omazhary
 * @version 1.0
 * @since 10/06/2013
 */
public class Tokenizer {
    
    private String text;
    
    /**
     * Returns an object of type "Tokenizer".
     */
    public Tokenizer(){
        this.text = "";
    }
    
    /**
     * Text setter.
     * @param text The text to be tokenized.
     */
    public void setText(String text){
        this.text = text;
    }
    
    /**
     * Text getter.
     * @return The original text.
     */
    public String getText(){
        return this.text;
    }
    
    /**
     * Tokenizes the string based on its words.
     * @return A string array containing all the separate words.
     */
    public String[] tokenizeWords(){
        // Remove punctuation:
        String temp = this.removePunctuation(this.text);
        // Split based on spaces:
        return temp.split(" ");
    }
    
    /**
     * Removes punctuation marks from a passage.
     * @param passage The passage from which the punctuation marks will result += characters[i];be removed.
     * @return The string without punctuation.
     */
    private String removePunctuation(String passage){
        String result = "";
        char[] characters = passage.toCharArray();
        
        // Loop over the characters and remove any non-letter or non-space characters.
        for(int i = 0; i < characters.length; i++){
            int charValue = (int) characters[i];
            if(charValue >= 65 && charValue <= 90){ // Upper-case letters
                result += characters[i];
            } else if(charValue >= 97 && charValue <= 122){ // Lower-case letters
                result += characters[i];
            } else if(charValue == 32){ // Space
                result += characters[i];
            }
        }        
        
        return result;
    }
    
}
