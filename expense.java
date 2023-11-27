/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectoop;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import static java.lang.Integer.parseInt;

class expense{
    private String date;
    private int food, transport, electricity, housing;
    private int essential;
    private int nonEssential;
    
    // constructor for all variables in add user
    public expense(String date,int food, int transport, int electricity, int housing, 
            int essential, int nonEssential){
        this.food = food;
        this.transport = transport;
        this.electricity = electricity;
        this.housing = housing;
        this.date = date;
        this.essential = essential;
        this.nonEssential = nonEssential;
    }
    
    //return value's
    public String getDate(){
        return date;
    }
    public int getFood(){
        return food;
    }
    public int getTransport(){
        return transport;
    }
    public int getElectricity(){
        return electricity;
    }
    public int getHousing(){
        return housing;
    }
    public int getEssential(){
        return essential;
    }
    public int getNonEssential(){
        return nonEssential;
    }
    
    public void addRecord(String fileName){
        File file = new File(fileName);
        int count = 2;
        if(file.exists()){
            while(file.exists()){
                fileName = "Record" + count + ".txt";
                file = new File(fileName);
                count++;
            }
        }
        //make file writter
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(food + "\n");
            writer.write(transport + "\n");
            writer.write(electricity + "\n");
            writer.write(housing + "\n");
            writer.write(essential + "\n");
            writer.write(nonEssential + "\n");
            writer.close();
            System.out.println("Record Saved!");
        }
        catch(IOException e) {
            System.err.println("Error writting to file: " + e.getMessage());
        }
    }
}

class previewFiles{
    protected String fileName;
    
    public previewFiles(String fileName){
        this.fileName = fileName;
    }

    public void previewRecord(){
        
        File file = new File(fileName);
        int count = 2;
        int fileCount = 1;
        while(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                String dateText = reader.readLine();

                System.out.println(fileCount + ") " + dateText);
                fileName = "Record" + count + ".txt";
                file = new File (fileName);
                count++;
                fileCount++;
            }
            catch(IOException e){
                System.err.println("Error Reading File: " + e.getMessage());
            }
        }
    }
}

class viewFile{
    protected int fileCount;
    protected String date;
    protected int food, transport, electricity, housing;
    protected int essential;
    protected int nonEssential;
    
    public viewFile(int fileCount){
        this.fileCount = fileCount;
    }
    
    public void viewRecord(){
        String fileName = "Record" + fileCount + ".txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            date = reader.readLine();
            food = parseInt(reader.readLine());
            transport = parseInt(reader.readLine());
            electricity = parseInt(reader.readLine());
            housing = parseInt(reader.readLine());
            essential = parseInt(reader.readLine());
            nonEssential = parseInt(reader.readLine());
            System.out.println(date);
            System.out.println("Food: " + food);
            System.out.println("Transport: " + transport);
            System.out.println("Electricity: " + electricity);
            System.out.println("Housing: " + housing);
            System.out.println("Total Expenses: " + essential);
            System.out.println("Other Expenses: " + nonEssential);
            reader.close();
        }catch(IOException e){
            System.out.println("Error Reaading File: " + e.getMessage());
        }
    }
}

class editFile extends viewFile{
    private int newFood, newTransport, newElectricity, newHousing, newEssential, newNonEssential;
    private int editChoose;
    
    //contructor
    public editFile(int fileCount, int editChoose){
        super(fileCount);
        this.editChoose = editChoose;
    }
    
    private int addTotal(int value1, int value2){
        return value1 + value2;
    }
    private int reduceTotal(int value1, int value2){
        return value1 - value2;
    }
    
    public void editRecord(int newFood, int newTransport, int newElectricity,
            int newHousing, int newNonEssential){
        String fileName = "Record" + fileCount + ".txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
        String line;
        date = reader.readLine();
        food = parseInt(reader.readLine());
        transport = parseInt(reader.readLine());
        electricity = parseInt(reader.readLine());
        housing = parseInt(reader.readLine());
        essential = parseInt(reader.readLine());
        nonEssential = parseInt(reader.readLine());
        reader.close();
        }catch(IOException e) {
            System.err.println("Error writting to file: " + e.getMessage());
        }
        if(editChoose == 1){
            newFood = addTotal(food, newFood);
            newTransport = addTotal(transport, newTransport);
            newElectricity = addTotal(electricity, newElectricity);
            newHousing = addTotal(housing, newHousing);
            newEssential = newFood + newTransport + newElectricity + newHousing;
            newNonEssential = addTotal(nonEssential, newNonEssential);
            
            File file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(newFood + "\n");
            writer.write(newTransport + "\n");
            writer.write(newElectricity + "\n");
            writer.write(newHousing + "\n");
            writer.write(newEssential + "\n");
            writer.write(newNonEssential + "\n");
            writer.close();
            System.out.println("Edit Saved!");
            }catch(IOException e) {
                System.err.println("Error writting to file: " + e.getMessage());
            }
        }
        else if(editChoose == 2){
            newFood = reduceTotal(food, newFood);
            newTransport = reduceTotal(transport, newTransport);
            newElectricity = reduceTotal(electricity, newElectricity);
            newHousing = reduceTotal(housing, newHousing);
            newEssential = newFood + newTransport + newElectricity + newHousing;
            newNonEssential = reduceTotal(nonEssential, newNonEssential);
            
            File file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            //if filename not existing then next :-D
            writer.write(date + "\n");
            writer.write(newFood + "\n");
            writer.write(newTransport + "\n");
            writer.write(newElectricity + "\n");
            writer.write(newHousing + "\n");
            writer.write(newEssential + "\n");
            writer.write(newNonEssential + "\n");
            writer.close();
            System.out.println("Edit Saved!");
            }catch(IOException e) {
                System.err.println("Error writting to file: " + e.getMessage());
            }
        }
    }
    public void deleteRecord(){
        String fileName = "Record" + fileCount + ".txt";
        File file = new File(fileName);
        file.delete();
        System.out.println("The file has been deleted!");
        fileCount++;
        fileName = "Record" + fileCount + ".txt";
        file = new File(fileName);
        while(file.exists()){
            try(BufferedReader reader = new BufferedReader(new FileReader(file))){
                date = reader.readLine();
                food = parseInt(reader.readLine());
                transport = parseInt(reader.readLine());
                electricity = parseInt(reader.readLine());
                housing = parseInt(reader.readLine());
                essential = parseInt(reader.readLine());
                nonEssential = parseInt(reader.readLine());
                reader.close();
            }catch(IOException e){
                System.err.println("Failed to Retreive file: " + e.getMessage());
            }
            file.delete();
            fileCount--;
            fileName = "Record" + fileCount + ".txt";
            file = new File(fileName);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
                //if filename not existing then next :-D
                writer.write(date + "\n");
                writer.write(food + "\n");
                writer.write(transport + "\n");
                writer.write(electricity + "\n");
                writer.write(housing + "\n");
                writer.write(essential + "\n");
                writer.write(nonEssential + "\n");
                writer.close();
            }catch(IOException e) {
                System.err.println("Error writting to file: " + e.getMessage());
            }
            fileCount++;
            fileCount++;
            fileName = "Record" + fileCount + ".txt";
            file = new File(fileName);
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