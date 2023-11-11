package stdmgmt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stdmgmt.models.Student;
import stdmgmt.repository.StudentRepository;

@Service
@RestController


//@CrossOrigin(origins =  "http://10.5.0.6:3000")
//
//@CrossOrigin(origins =  "http://192.168.99.100:3000")
@CrossOrigin(origins =  "http://${cors}")
@RequestMapping("/student/api/")
public class StudentApi implements StudentService{
	@Autowired
    StudentRepository  _studentrepo ;
	@Override
	@GetMapping("/list")
	public List<Student> getAllSudents() {
		// TODO Auto-generated method stub
		return _studentrepo.findAll();
	}
	@Override
	@PostMapping("/save")
	public void saveStudent(@RequestBody Student _student) {
		
		_studentrepo.save(_student);
		
		// TODO Auto-generated method stub
		
	}
	@Override
	@GetMapping("/show/{id}")
	public Student getStudent(@PathVariable(value="id") long _id) {
		Optional<Student> _studentopt = 		_studentrepo.findById(_id);
		// TODO Auto-generated method stub
		Student _student = null;
		 if(_studentopt.isPresent())
		 {
			 _student = _studentopt.get();
		 }
		 else
		 {
			 throw new RuntimeException("Employee not found");
		 }
		 return _student;
	}
	@Override
	@GetMapping("/remove/{id}")
	public void removeStudent(@PathVariable(value="id") long _id) {
		// TODO Auto-generated method stub
		Optional<Student> _studentopt = 		_studentrepo.findById(_id);
		// TODO Auto-generated method stub
		Student _student = null;
		 if(!_studentopt.isPresent())
		 {
		
			 throw new RuntimeException("Employee not found");
		 }
		 _studentrepo.deleteById(_id);;
	}

}
