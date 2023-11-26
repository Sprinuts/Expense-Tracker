import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class expense{
    private String date;
    private int essential;
    private int nonEssential;
    
    // constructor for all variables in add user
    public expense(String date, int essential, int nonEssential){
        this.date = date;
        this.essential = essential;
        this.nonEssential = nonEssential;
    }
    
    //return value of date
    public String getDate(){
        return date;
    }
    //return value of essential
    public int getEssential(){
        return essential;
    }
    //return value of nonEssential
    public int getNonEssential(){
        return nonEssential;
    }
    
    public void addRecord(String fileName){
        try{
            FileWriter file = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(file);
            
            writer.write("Date: " + date + "\n");
            writer.write("Essential: " + essential + "\n");
            writer.write("Non-Essential: " + nonEssential + "\n");
            
            writer.close();
        }
        catch(IOException e) {
            System.err.println("Error writting to file: " + e.getMessage());
        }
    }
}

class totalEssential{
    
    public int add(int num1){
        return num1;
    }
    
    public int add(int num1, int num2){
        return num1 + num2;
    }
    
    public int add(int num1, int num2, int num3){
        return num1 + num2 + num3;
    }
    
    public int add(int num1, int num2, int num3, int num4){
        return num1 + num2 + num3 + num4;
    }
}
