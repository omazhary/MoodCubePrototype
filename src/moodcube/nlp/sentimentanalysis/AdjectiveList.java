package moodcube.nlp.sentimentanalysis;

import moodcube.physicalmedia.TextFile;

/**
 * This class contains a list of adjectives and their statistics.
 * @author omazhary
 * @version 1.0
 * @since 
 */
public class AdjectiveList {
    
    private String filePath;
    private String[] adjectives;
    private double[][] statistics;
    
    /**
     * Returns an object of type AdjectiveList.
     */
    public AdjectiveList(){
        // Get the contents of the file:
        this.filePath = "resources//adjStats.txt";
        TextFile file = new TextFile(this.filePath, 0);
        file.read();
        String[] temp = file.getContents().split("\n");
        // Set up the statistics tables:
        this.adjectives = new String[temp.length];
        this.statistics = new double[temp.length][5];
        for(int i = 0; i < temp.length; i++){
            String[] innerTemp = temp[i].split("\t");
            if(innerTemp.length < 3){
                this.statistics[i][0] = 0;
                this.statistics[i][1] = 0;
            } else {
                this.statistics[i][0] = Double.parseDouble(innerTemp[1]);
                this.statistics[i][1] = Double.parseDouble(innerTemp[2]);
                this.statistics[i][2] = Double.parseDouble(innerTemp[3]);
                this.statistics[i][3] = Double.parseDouble(innerTemp[4]);
                this.statistics[i][4] = Double.parseDouble(innerTemp[5]);
            }
            this.adjectives[i] = innerTemp[0];
        }
        file.close();
    }
    
    /**
     * Searches for a certain adjective's statistics
     * @param adjective The adjective in question.
     * @return An array containing the statistics if the adjective is found, null otherwise.
     */
    public double[] getStatisticsByAdjective(String adjective){
        int i = -1;
        for(int j = 0; j < this.adjectives.length; j++){
            if(this.adjectives[j].equalsIgnoreCase(adjective)){
                i = j;
                break;
            }
        }
        if(i >= 0){
            return this.statistics[i];
        } else {
            return null;
        }
    }
    
    /**
     * Adjective getter.
     * @param index The index of the required adjective.
     * @return A String containing the required adjective.
     */
    public String getAdjective(int index){
        return this.adjectives[index];
    }
    
    /**
     * List size getter.
     * @return The number of adjective currently in the list.
     */
    public int getAdjectiveNumber(){
        return this.adjectives.length;
    }
    
    /**
     * Checks if a given adjective is in the list.
     * @param adjective The adjective in question.
     * @return True if it is in the list, false otherwise.
     */
    public boolean contains(String adjective){
        boolean result = false;
        for(int i = 0 ; i < this.adjectives.length; i++){
            if(this.adjectives[i].equalsIgnoreCase(adjective)){
                result = true;
                break;
            }
        }
        return result;
    }
    
    /**
     * Saves the adjective list to file.
     */
    public void saveAdjectiveList(){
        TextFile file = new TextFile(this.filePath, 1);
        String output = "";
        for(int i = 0; i < this.adjectives.length; i++){
            output += this.adjectives[i] + "\t" + this.statistics[i][0] + "\t" + this.statistics[i][1] + "\t" + this.statistics[i][2] + "\t" + this.statistics[i][3] + "\t" + this.statistics[i][4] + "\n";
        }
        file.write(output);
        file.close();
    }
    
}
