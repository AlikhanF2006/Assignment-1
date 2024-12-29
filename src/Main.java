import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        School school = new School();
        File fileStudents = new File("src/students.txt");
        File fileTeachers = new File("src/teachers.txt");

        List<Student> students = readStudentsFromFile(fileStudents);
        List<Teacher> teachers = readTeachersFromFile(fileTeachers);

        for (Student student : students) {
            school.addMember(student);
        }

        for (Teacher teacher : teachers) {
            school.addMember(teacher);
        }

        System.out.println(school);
    }

    public static List<Student> readStudentsFromFile(File file) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length >= 5) {
                    String name = parts[0];
                    String surname = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    boolean gender = parts[3].equalsIgnoreCase("Male");
                    List<Integer> grades = new ArrayList<>();
                    for (int i = 4; i < parts.length; i++) {
                        grades.add(Integer.parseInt(parts[i]));
                    }
                    students.add(new Student(name, surname, age, gender, grades));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading students file: " + e.getMessage());
        }
        return students;
    }

    public static List<Teacher> readTeachersFromFile(File file) {
        List<Teacher> teachers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length >= 7) {
                    String name = parts[0];
                    String surname = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    boolean gender = parts[3].equalsIgnoreCase("Male");
                    String subject = parts[4];
                    int yearsOfExperience = Integer.parseInt(parts[5]);
                    int salary = Integer.parseInt(parts[6]);
                    teachers.add(new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading teachers file: " + e.getMessage());
        }
        return teachers;
    }
}
