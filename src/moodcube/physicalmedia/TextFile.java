package moodcube.physicalmedia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class deals with text files.
 * @author omazhary
 * @version 1.0
 * @since 16/03/2013
 */
public class TextFile {
    
    /**
     * This variable stores the path to the physical file located on the media.
     */
    private String path;
    /**
     * This variable stores the contents of the text file.
     */
    private String contents;
    
    /**
     * This variable checks if the instantiation went OK.
     */
    private boolean status;
    
    /**
     * This variable stores the file's open mode.
     */
    private int mode;
    
    /**
     * This object stores the physical link to the file.
     */
    private Object myFile;
    
    /**
     * The class constructor initializes the object's values and creates a link to the medium.
     * @param path The path to the file to be used.
     * @param mode 0 indicates reading, 1 indicates writing.
     */
    public TextFile(String path, int mode){
        try {
            this.path = path;
            this.mode = mode;
            this.contents = "";
            this.status = false;
            switch(this.mode){
                case 0:
                    this.myFile = new BufferedReader(new FileReader(this.path));
                    this.status = true;
                    break;
                case 1:
                    this.myFile = new BufferedWriter(new FileWriter(this.path));
                    this.status = true;
                    break;
                default:
                    this.myFile = new Object();
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File Error!!\n" + ex.getMessage());
        }
    }
    
    /**
     * Returns the path of the file as a string.
     * @return The file's path as a string.
     */
    public String getPath(){
        return this.path;
    }
    
    /**
     * Returns the file contents as a string.
     * @return The file's contents as a string.
     */
    public String getContents(){
        return this.contents;
    }
    
    /**
     * Returns the file's mode.
     * @return The mode in which the file is opened.
     */
    public int getMode(){
        return this.mode;
    }
    
    /**
     * Returns the status of the file.
     * @return True means the link to the file was established and vice versa.
     */
    public boolean getStatus(){
        return this.status;
    }
    
    /**
     * Reads the contents of the file into the object.
     * @exception IOException might throw an IOException.
     */
    public void read(){
        if(this.mode == 0){
            BufferedReader reader = (BufferedReader) this.myFile;
            try {
                String temp = reader.readLine();
                while(temp != null){
                    this.contents += temp + "\n";
                    temp = reader.readLine();
                }
            } catch (IOException ex) {
                Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error while reading!!\n" + ex.getMessage());
            }
        } else {
            System.out.println("Invalid mode for reading!!");
        }
    }
    
    /**
     * Writes the text to the file.
     * @param text The text to be written to the file.
     * @exception Exception might throw an exception if the file is unreachable.
     */
    public void write(String text){
        if(this.mode == 1){
            BufferedWriter writer = (BufferedWriter) this.myFile;
            try{
                writer.write(text);
                writer.flush();
            } catch (Exception ex){
                System.out.println("Error while writing!!\n" + ex.getMessage());
            }
        } else {
            System.out.println("Invalid mode for writing!!");
        }
    }
    
    /**
     * Closes the file.
     * @exception Exception Throws an exception if the file has a problem.
     */
    public void close(){
        try {
            switch(this.mode){
                case 0:
                    BufferedReader reader = (BufferedReader) this.myFile;
                    reader.close();
                    break;
                case 1:
                    BufferedWriter writer = (BufferedWriter) this.myFile;
                    writer.close();
            }
        } catch (Exception ex){
            System.out.println("Error closing file!!\n" + ex.getMessage());
        }
    }
    
    /**
     * Switches the mode in which the file is opened.
     */
    public void switchMode(){
        this.status = false;
        try {
            this.close();
            switch (this.mode){
                case 0:
                    this.myFile = new BufferedWriter(new FileWriter(this.path));
                    this.mode = 1;
                    this.status = true;
                    break;
                case 1:
                    this.myFile = new BufferedReader(new FileReader(this.path));
                    this.mode = 0;
                    this.status = true;
                    break;
                default:
                    System.out.println("Erroneous Mode!!");
                    break;
            }
        } catch (Exception ex){
            System.out.println("Error switching mode!!\n" + ex.getMessage());
        }
    }
}
