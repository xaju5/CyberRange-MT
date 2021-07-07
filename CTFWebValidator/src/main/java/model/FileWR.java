package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWR {

	private PrintWriter pw;
    private String filename;
    private BufferedReader bf;
    
    public FileWR(String filename, boolean overwrite){
        //USE THIS CONSTRUCTOR FOR WRITING A FILE
        this.filename = filename;
        FileWriter fw = null;
        
        try {
            fw = new FileWriter(filename,overwrite);
        } catch (IOException ex) {
            Logger.getLogger(FileWR.class.getName()).log(Level.SEVERE, null, ex);
        }     
        pw =  new PrintWriter(fw);
        bf = null;       
    }
    
    public FileWR (String filename){
    	//USE THIS CONSTRUCTOR FOR READING A FILE
        this.filename = filename;
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileWR.class.getName()).log(Level.SEVERE, null, ex);
        }
        bf = new BufferedReader(fr);
        pw = null;  
    }
    
    public FileWR(){
    	filename = null;
        pw = null;
        bf = null;
    }
    
    ///////////////
    //WRITE METHODS
    ///////////////
    
    public void writeString(String data){
        pw.write(data);
    }
    
    public void closeWriter(){
        pw.close();
    }
    
	///////////////
	//READ METHODS
	///////////////
	
    public String readLine(){
        
        String line = "";
         
        try {
            line = bf.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FileWR.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }
    public String readText(){
        String text = "";
        String line;
        
        try {
            while((line = bf.readLine()) != null)
            	text = text + line + "\n";
        } catch (IOException ex) {
            Logger.getLogger(FileWR.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return text;
    }
    
    public void closeReader(){
        try {
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(FileWR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	///////////////
	//COMMON METHODS
	///////////////
    
	public String getFileName() {
		return filename;
	}
	
	public float getSize(){
        File f = new File(filename);
        float size = f.length();
        return size;
    }
}
