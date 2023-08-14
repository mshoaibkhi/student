package stdmgmt.services;

import java.util.List;

import stdmgmt.models.Student;

public interface StudentService {
    List<Student> getAllSudents();
    void  saveStudent (Student _student);
	Student getStudent(long _id);
	void removeStudent(long _id);
}
