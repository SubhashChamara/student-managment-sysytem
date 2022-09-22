package com.studentManagementsSystem;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Students {

    private String name;
    private int age;
    public Students() {

    }

    public Students(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void addStudent(Students student) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String path = "E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\";
            String id = path + student.getName() + ".txt";
            Path file1 = Path.of(id);
            mapper.writeValue(file1.toFile(), student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void viewStudent() throws IOException {

        try{
            File file =new File("E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\");
            String[] fileList= file.list();

            for (String fileName:fileList) {
                ObjectMapper mapper = new ObjectMapper();
                String path = "E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\";
                String id = path + fileName ;
                Path file1 = Path.of(id);
                Students s = mapper.readValue(file1.toFile(), Students.class);
                System.out.println(s.toString());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void searchStudent(String name) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String path = "E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\";
            String id = path + name + ".txt";
            Path file1 = Paths.get(id);
            Students s = mapper.readValue(file1.toFile(), Students.class);
            System.out.println(s.toString());


        } catch(FileNotFoundException e){
            System.out.println("Student Name "+ name + " is not Exist");;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteStudent(String name) {
        String path = "E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\";
        String id = path + name + ".txt";
        File file = new File(id);
        file.delete();
        System.out.println("Student " + name + " is deleted now");
    }

    public void addSubjectMarksToStudent(String name) throws FileNotFoundException {
        int sum=0;
        try{
            File file = new File("E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Subjects\\Subjects.txt");
            Scanner scnSubject = new Scanner(file);
            Scanner scnMark = new Scanner(System.in);
            ObjectMapper mapper = new ObjectMapper();
            while (scnSubject.hasNextLine()) {
                String subject = scnSubject.nextLine();
                System.out.print("Please Enter " + name + " " + subject + " Marks: ");
                int mark = scnMark.nextInt();
                this.writeMarksToFile(name, subject, mark);
                sum = sum + mark;
            }

            this.writeMarksToFile(name,"Total",sum);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeMarksToFile(String name, String subject, int mark) throws IOException {
        try {
            String path = "E:\\JAVA\\java\\Kuppi Vimukthi Ayya\\Practice Codes\\java 08\\Home Work\\src\\main\\resources\\Students\\";
            String id = path+name+".txt";
            File file = new File(id);
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(subject +" Marks : " +mark);

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}
