package moodcube.system;

import java.io.File;
import moodcube.gui.FormSAInput;
import moodcube.nlp.sentimentanalysis.PolarityCalculator;
import moodcube.nlp.sentimentanalysis.Trainer;
import moodcube.nlp.text.Tokenizer;
import moodcube.physicalmedia.TextFile;

/**
 * This class initializes and starts the program.
 * @author omazhary
 * @version 1.0
 * @since 10/06/2013
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(args.length == 0){
            return;
        }
        
        if(args[0].equalsIgnoreCase("train")){
            String trainingMode = args[1];
            String rootDir = "";
            File folder = null;
            String[] files = new String[1];
            /*if(args[1].equalsIgnoreCase("positive")){
                trainingMode = true;
                rootDir = "resources/pos/";
            } else {
                trainingMode = false;
                rootDir = "resources/neg/";
            }*/
            switch(args[1]){
                case "Happy":
                    files[0] = "resources/feelings/Happy.txt";
                    break;
                case "Sad":
                    files[0] = "resources/feelings/Sad.txt";
                    break;
                case "Angry":
                    files[0] = "resources/feelings/Angry.txt";
                    break;
                case "Romantic":
                    files[0] = "resources/feelings/Romantic.txt";
                    break;
                default:
                    System.out.println("Parameter Error!!");
                    return;
            }

            /*folder = new File(rootDir);
            File[] folderFiles = folder.listFiles();
            files = new String[folderFiles.length];
            for(int i = 0; i < files.length; i++){
                files[i] = folderFiles[i].getAbsolutePath();
            }*/
            Trainer test = new Trainer(files, trainingMode);
            test.train();
        } else if(args[0].equalsIgnoreCase("calculate")){
            /*TextFile file = new TextFile("resources/input.txt", 0);
            file.read();
            PolarityCalculator calculator = new PolarityCalculator();
            double[] result = calculator.getPolarityStats(file.getContents());
            System.out.println("Angry Polarity = " + result[0] + "\tHappy Polarity = " + result[1]);
            System.out.println("Sad Polarity = " + result[2] + "\tRomantic Polarity = " + result[3]);
            file.close();*/
            String[] additionalArgs = new String[1];
            FormSAInput frmInput = new FormSAInput();
            
            frmInput.main(additionalArgs);
        }
    }
}
