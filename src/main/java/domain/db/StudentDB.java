package domain.db;

import domain.model.Student;

import java.util.ArrayList;

public class StudentDB {
    private ArrayList<Student> students;

    public StudentDB() {
        students = new ArrayList<>(0);
    }

    public void voegStudentToe(Student s) {
        if (s == null) throw new IllegalArgumentException("Student mag niet leeg zijn");
        students.add(s);
    }

    public boolean bevatStudent(String naam, String voornaam) {
        for (Student s : students) {
            if (s != null && s.getNaam().equals(naam) && s.getVoornaam().equals(voornaam)) {
                return true;
            }
        }
        return false;
    }

    public Student getStudent(String naam, String voornaam) {
        for (Student s : students) {
            if (s != null && s.getNaam().equals(naam) && s.getVoornaam().equals(voornaam)) {
                return s;
            }
        }
        return null;
    }
}
