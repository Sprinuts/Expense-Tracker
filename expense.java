class expense{
    private int essential;
    private int nonEssential;
    private String date;
    
    // constructor for all variables in add user
    public expense(int essential, int nonEssential, String date){
        this.essential = essential;
        this.nonEssential = nonEssential;
        this.date = date;
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
    
    public void addRecord(){
        
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
