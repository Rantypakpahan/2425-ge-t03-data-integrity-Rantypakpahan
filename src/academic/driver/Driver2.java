package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

/**
 * @author 12S23008 Ranty Insen Pakpahan
 * @author 12S23048 Grace Caldera Situmorang
 */

public class Driver2 {
    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);

        ArrayList<Course> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Enrollment> enrollments = new ArrayList<>();

        while (true){
            String command = scn.nextLine();
            if (command.equals("---")){
                break;
            }

            String[] temp = command.split("#");
            String perintah = temp[0];

            switch (perintah) {
                case "course-add":
                    courses.add(new Course(temp[1], temp[2], Integer.parseInt(temp[3]), temp[4]));
                    break;
                case "student-add":
                    students.add(new Student(temp[1], temp[2], Integer.parseInt(temp[3]), temp[4]));
                    break;
                case "enrollment-add":
                    String kodeMatkul = temp[1];
                    String nim = temp[2];
                    Boolean cekNim = cekStudent(students, nim);
                    Boolean cekKodeMatkul = cekCourse(courses, kodeMatkul);
                    if (!cekKodeMatkul){
                        System.out.println("invalid course|"+kodeMatkul);
                        break;
                    }
                    if (!cekNim){
                        System.out.println("invalid student|"+nim);
                        break;
                    }
                    
                    enrollments.add(new Enrollment(kodeMatkul,nim, temp[3], temp[4]));
                    break;
            }


        }

        for (int i = courses.size()-1; i >= 0; i--){
            System.out.println(courses.get(i).toString());
        }

        for (int i= 0; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }

        for (int i= 0; i < enrollments.size(); i++){
            System.out.println(enrollments.get(i).toString());
        }



    }


    public static Boolean cekStudent(ArrayList<Student> students, String nim){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getNim().equals(nim)){
                return true;
            }
        }
        return false;
    }

    public static Boolean cekCourse(ArrayList<Course> courses, String kodeMatkul){
        for (int i = 0; i < courses.size(); i++){
            if (courses.get(i).getCode().equals(kodeMatkul)){
                return true;
            }
        }
        return false;
    }
}




