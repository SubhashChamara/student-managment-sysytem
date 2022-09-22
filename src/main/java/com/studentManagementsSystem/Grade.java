package com.studentManagementsSystem;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Grade {
    public void findGrade() throws FileNotFoundException {
        try{
            HashMap<Students,Integer> totalHash= new HashMap<>();
            TreeSet<Integer> totalMarks=new TreeSet<>();
            File file =new File("E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\");
            String[] fileList = file.list();

            for (String fileName:fileList) {
                ObjectMapper mapper = new ObjectMapper();
                String path="E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\";
                String id = path+fileName;
                Path filePath= Path.of(id);
                Students s= mapper.readValue(filePath.toFile(),Students.class);
//                System.out.println(s);

                FileReader fw = new FileReader(id);
                BufferedReader br = new BufferedReader(fw);
                String lastLine=null;
                br.readLine();
                while (!(br.readLine()==null)){
                    lastLine= br.readLine();
                }


                String[] totalMarkArray =lastLine.split(" ");

                totalMarks.add(Integer.parseInt(totalMarkArray[3]));
                totalHash.put(s,Integer.parseInt(totalMarkArray[3]));


            }

            TreeSet<Integer> totalMarksReverse= (TreeSet<Integer>) totalMarks.descendingSet();


            int place=0;
            for (int mark:totalMarksReverse) {
                place++;
                for (Map.Entry<Students,Integer> entry: totalHash.entrySet()) {
                    if(entry.getValue()==mark){
                        System.out.println("Class " + place + " : " + (entry.getKey()));

                    }
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
