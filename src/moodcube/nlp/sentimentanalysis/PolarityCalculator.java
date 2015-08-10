package moodcube.nlp.sentimentanalysis;

import moodcube.nlp.text.Tokenizer;

/**
 * This class provides polarity calculation functionality.
 * @author omazhary
 * @version 1.0
 * @since 11/06/2013
 */
public class PolarityCalculator {
    
    private AdjectiveList adjectives;
    private Tokenizer tokenizer;
    
    /**
     * Returns an object of type PolarityCalculator.
     */
    public PolarityCalculator(){
        this.adjectives = new AdjectiveList();
        this.tokenizer = new Tokenizer();
    }
    
    /**
     * Calculates the positive and negative polarities of a certain text.
     * @param text The text in question.
     * @return An array of double where the first element is the average positive polarity and the second element is the average negative polarity.
     */
    public double[] getPolarityStats(String text){
        double[] result = new double[4];
        
        // First, we tokenize the text:
        this.tokenizer.setText(text);
        String[] words = this.tokenizer.tokenizeWords();
        
        // Then, we search for adjectives:
        double totalAdjectives = 0; // Counts the total number of adjectives so we can calculate the average later on.
        for(int i = 0; i < words.length; i++){
            if(this.adjectives.contains(words[i])){
                double[] stats = this.adjectives.getStatisticsByAdjective(words[i]);
                if(stats != null){
                    // Here, we calculate stats for each adjective in this text.
                    // Angry polarity = angry occurances / total occurances
                    // Sad polarity = sad occurances / total occurances
                    // Happy polarity = happy occurances / total occurances
                    // Romantic polarity = romantic occurances / total occurances
                    // To avoid a division by zero error, we increment stats[4] by 1.
                    if(stats[4] == 0.0){
                        stats[4]++;
                    }
                    result[0] += stats[0] / stats[4]; // Angry polarity.
                    result[1] += stats[1] / stats[4]; // Happy polarity.
                    result[2] += stats[2] / stats[4]; // Sad polarity.
                    result[3] += stats[3] / stats[4]; // Romantic polarity.
                    totalAdjectives++;
                }
            }
        }
        
        result[0] = result[0] / totalAdjectives;
        result[1] = result[1] / totalAdjectives;
        result[2] = result[2] / totalAdjectives;
        result[3] = result[3] / totalAdjectives;
        
        return result;
    }
    
}
