package moodcube.nlp.sentimentanalysis;

import moodcube.nlp.text.Tokenizer;
import moodcube.physicalmedia.TextFile;

/**
 * This class trains the engine and populates its statistics tables using positive and negative polarity.
 * @author omazhary
 * @version 1.0
 * @since 10/06/2013
 */
public class Trainer {
    
    private AdjectiveList adjectives;
    private String[] trainingSource;
    private String trainingMode;
    private Tokenizer tokenizer;
    
    /**
     * Returns an object of type Trainer.
     * @param files The files to be used for this exercise.
     * @param trainingMode Angry, Happy, Sad or Romantic.
     */
    public Trainer(String[] files, String trainingMode){
        this.trainingSource = files;
        this.trainingMode = trainingMode;
        this.adjectives = new AdjectiveList();
        this.tokenizer = new Tokenizer();
    }
    
    /**
     * Starts the training process
     */
    public void train(){
        // Loop over the files available:
        for(int i = 0; i < this.trainingSource.length; i++){
            // Read and tokenize file:
            TextFile file = new TextFile(this.trainingSource[i], 0);
            file.read();
            this.tokenizer.setText(file.getContents());
            String[] tokenizedText = this.tokenizer.tokenizeWords();
            // For each tokenized word, we determine if it's an adjective, if so, we increase the corresponding statistics.
            for(int j = 0; j < tokenizedText.length; j++){
                if(this.adjectives.contains(tokenizedText[j])){
                    double[] stats = this.adjectives.getStatisticsByAdjective(tokenizedText[j]);
                    //System.out.println(i + ", " + j + ", " + tokenizedText[j]);
                    if(stats != null){
                        switch(this.trainingMode){
                            case "Angry":
                                stats[0]++;
                                break;
                            case "Happy":
                                stats[1]++;
                                break;
                            case "Sad":
                                stats[2]++;
                                break;
                            case "Romantic":
                                stats[3]++;
                                break;
                            default:
                                return;
                        }
                        stats[4]++;
                    }
                }
            }
            file.close();
        }
        // Save the statistics to file:
        this.adjectives.saveAdjectiveList();
    }
    
}
