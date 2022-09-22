package com.studentManagementsSystem;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Subjects {

    public void addSubject(String subject) throws IOException {
        try{
            File file = new File("E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Subjects\\Subjects.txt");
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write(subject);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewSubjects() throws IOException {
        try{

            Path filePath = Paths.get("E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Subjects\\Subjects.txt");
            String content= Files.readString(filePath);
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteSubject(String subject) {

    }

}
