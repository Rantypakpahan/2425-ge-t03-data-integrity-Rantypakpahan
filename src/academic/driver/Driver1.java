package academic.driver;

import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import java.util.*;

/**
 * @author 12S23008 Ranty Insen Pakpahan
 * @author 12S23048 Grace Caldera Situmorang
 */

public class Driver1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollment> enrollments = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            if (parts.length > 1) {
                String command = parts[0];

                switch (command) {
                    case "course-add":
                        if (parts.length == 5) {
                            String code = parts[1];
                            String courseName = parts[2];
                            int kredit = Integer.parseInt(parts[3]);
                            String grade = parts[4];

                            // Cek apakah course sudah ada
                            boolean exists = courses.stream().anyMatch(c -> c.getCode().equals(code));

                            if (!exists) {
                                courses.add(new Course(code, courseName, kredit, grade));
                            }
                        }
                        break;

                    case "student-add":
                        if (parts.length == 5) {
                            String nim = parts[1];
                            String nama = parts[2];
                            int tahun = Integer.parseInt(parts[3]);
                            String jurusan = parts[4];

                            // Cek apakah student sudah ada
                            boolean exists = students.stream().anyMatch(s -> s.getNim().equals(nim));

                            if (!exists) {
                                students.add(new Student(nim, nama, tahun, jurusan));
                            }
                        }
                        break;

                    case "enrollment-add":
                        if (parts.length == 5 || parts.length == 6) {
                            String kodeMatkul = parts[1];
                            String nim = parts[2];
                            String tahunAjaran = parts[3];
                            String semester = parts[4];
                            String status = (parts.length == 6) ? parts[5] : "None";

                            // Validasi apakah course dan student ada
                            boolean courseExists = courses.stream().anyMatch(c -> c.getCode().equals(kodeMatkul));
                            boolean studentExists = students.stream().anyMatch(s -> s.getNim().equals(nim));

                            if (!courseExists) {
                                System.out.println("invalid course|" + kodeMatkul);
                            } else if (!studentExists) {
                                System.out.println("invalid student|" + nim);
                            } else {
                                enrollments.add(new Enrollment(kodeMatkul, nim, tahunAjaran, semester));
                            }
                        }
                        break;
                }
            }
        }

        // Sort Course by code
        courses.sort(Comparator.comparing(Course::getCode));
        for (Course c : courses) {
            System.out.println(c.getCode() + "|" + c.getCourseName() + "|" + c.getKredit() + "|" + c.getGrade());
        }

        // Sort Student by name in reverse
        students.sort(Comparator.comparing(Student::getNama).reversed());
        for (Student s : students) {
            System.out.println(s.getNim() + "|" + s.getNama() + "|" + s.getTahun() + "|" + s.getJurusan());
        }   

        // Sort Enrollment by kodeMatkul in reverse
        enrollments.reversed();
 
        for (Enrollment e : enrollments) {
            System.out.println(e.getKodeMatkul() + "|" + e.getNim() + "|" + e.getTahunAjaran() + "|" + e.getSemester() + "|" + e.getStatus());
        }

        scanner.close(); 
    }
}