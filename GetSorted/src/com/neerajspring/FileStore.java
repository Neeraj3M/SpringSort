package com.neerajspring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class FileStore {
    private static final String TAB_DELIMITER = "/";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Numlist,SortedNumlist,ChangeNo,TimeTaken";

	public void storeObject(numberlist num) throws IOException {
            try(Writer writer = new OutputStreamWriter(new FileOutputStream("D:\\gitrepo\\SpringMVC\\Output.json") , "UTF-8")){
                Gson gson = new GsonBuilder().create();
                gson.toJson(num, writer);                 
            }
        }
     
    public numberlist displayObjects()throws IOException{         
    	 try(Reader reader = new InputStreamReader(new FileInputStream("D:\\gitrepo\\SpringMVC\\Output.json"), "UTF-8")){
             Gson gson = new GsonBuilder().create();
             numberlist n = gson.fromJson(reader, numberlist.class);
             System.out.println(n.toString());
             return n;
         }
     }
   
    public void storeCSV(numberlist num) throws IOException{
    	 FileWriter fileWriter = null;    	
    	 File file = new File("Output.csv");
    	         try {
    	        	 boolean empty = file.length()==0;
    	             fileWriter = new FileWriter(file, true);
    	             //Write the CSV file header
    	             if (empty){
    	            	 fileWriter.append(FILE_HEADER.toString());  	 
        	             //Add a new line separator after the header
        	             fileWriter.append(NEW_LINE_SEPARATOR);
    	            	 
    	             }
    	             
    	             //Write a new student object list to the CSV file
    	            
    	                 fileWriter.append(String.valueOf(num.getNumlist()));
    	                 fileWriter.append(TAB_DELIMITER);
    	                 fileWriter.append(String.valueOf(num.getSortedNumlist()));
    	                 fileWriter.append(TAB_DELIMITER);
    	                 fileWriter.append(String.valueOf(num.getChangeNo()));
    	                 fileWriter.append(TAB_DELIMITER);
    	                 fileWriter.append(String.valueOf(num.getTimeTaken()));
    	                 fileWriter.append(NEW_LINE_SEPARATOR);
    	             
    	             System.out.println("CSV file was created successfully !!!");
    	         } catch (Exception e) {
    	             System.out.println("Error in CsvFileWriter !!!");
    	             e.printStackTrace();
    	         } finally {
    	             try {
    	                 fileWriter.flush();
    	                 fileWriter.close();
    	             } catch (IOException e) {
    	                 System.out.println("Error while flushing/closing fileWriter !!!");
    	                 e.printStackTrace();
    	                 }
                     }
                  }
    public List<numberlist> readCSV(){
    	    int NumList_IDX = 0;
    	    int NumSortList_IDX = 1;
    	    int CheckNo_IDX = 2;
    	    int TimeTaken_IDX = 3;
    		BufferedReader fileReader = null;
    		        try {
    		            
    		            List<numberlist> NumList = new ArrayList<numberlist>();
    		            String line = "";
    		            //Create the file reader
    		            fileReader = new BufferedReader(new FileReader("Output.csv"));
    		            //Read the CSV file header to skip it
    		            fileReader.readLine();    		             
    		            //Read the file line by line starting from the second line
    		            while ((line = fileReader.readLine()) != null) {
    		                //Get all tokens available in line
    		                String[] tokens = line.split(TAB_DELIMITER);
    		                if (tokens.length > 0) {
    	
    		                    numberlist n = new numberlist();
    		                    n.setChangeNo(Integer.parseInt(tokens[CheckNo_IDX]));
    		                    System.out.println(Integer.parseInt(tokens[CheckNo_IDX]));
    		                    n.setNumlist(tokens[NumList_IDX].toString());
    		                    System.out.println(tokens[NumList_IDX].toString());
    		                    n.setSortedNumlist(tokens[NumSortList_IDX].toString());
    		                    n.setTimeTaken(Long.parseLong(tokens[TimeTaken_IDX]));
    		                    NumList.add(n);
    		                }
    		            }
    		  
    		            return NumList;
    		        }
    		        catch (Exception e) {
    		            System.out.println("Error in CsvFileReader !!!");
    		            e.printStackTrace();
    		            return null;
    		        } finally {
    		            try {
    		                fileReader.close();
    		            } catch (IOException e) {
    		                System.out.println("Error while closing fileReader !!!");
    		                e.printStackTrace();
    		            }
    		        }
    		    }

    }
    
    

