
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;  

public void addRecord(String fileName){
        try{
            FileWriter file = new FileWriter(fileName, true);
            BufferedWriter writer = new BufferedWriter(file);
            
            File checkFile = new File(fileName);
            if (checkFile.exists() && checkFile.length() == 0) {
                writer.write(" |    DATE    |" + "     AMOUNT   \n");
                writer.write(" -----------------------------\n");
            }
                
            writer.write(" | " + date + " | ");
            writer.write(amount + "\n");
            
            writer.close();
        }
        catch(IOException e) {
            System.err.println("Error writting to file: " + e.getMessage());
        }
}