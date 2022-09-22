import com.studentManagementsSystem.Grade;
import com.studentManagementsSystem.Students;
import com.studentManagementsSystem.Subjects;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


            Students student = new Students();
//Add Student
            student.addStudent(new Students("Nimal",20));
            student.addStudent(new Students("Kamal",22));
            student.addStudent(new Students("Amal",24));
            student.addStudent(new Students("Saman",24));


//View Students
            student.viewStudent();

//Search Student
            student.searchStudent("Amal");
            student.searchStudent("amal");

//Delete Student
            student.deleteStudent("amal");

//Add Subject
        Subjects subject = new Subjects();
        subject.addSubject("Maths");
        subject.addSubject("Science");
        subject.addSubject("English");



//View Subjects
        subject.viewSubjects();

//Add Subject Marks to Students
        student.addSubjectMarksToStudent("Nimal");
        student.addSubjectMarksToStudent("Kamal");
        student.addSubjectMarksToStudent("Saman");

//Find the Grade of Students
        Grade grade = new Grade();
        grade.findGrade();



    }
}
