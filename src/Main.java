import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File fileStudents = new File("src/students.txt");
        File fileTeachers = new File("src/teachers.txt");

        List<Student> students = readStudentsFromFile(fileStudents);
        List<Teacher> teachers = readTeachersFromFile(fileTeachers);

        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nTeachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
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
                    Student student = new Student(name, surname, age, gender, grades);
                    students.add(student);
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
                    Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
                    teachers.add(teacher);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading teachers file: " + e.getMessage());
        }
        return teachers;
    }
}
