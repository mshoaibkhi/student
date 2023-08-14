package stdmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import stdmgmt.models.Student;
import stdmgmt.services.StudentService;

@Controller
public class StudentController {
	@Autowired
    StudentService _studentservice;
	@GetMapping("/")
	public String homepage (Model _model) {
		_model.addAttribute("studentlist", _studentservice.getAllSudents());
		return  "index";
	}
	@GetMapping("/show/{id}")
	public String show (@PathVariable(value="id") long _id,Model _model) {
		Student _student = null;
		if(_id==0)
		{
			_student =new Student();
		}
		else
		{
		_student = _studentservice.getStudent(_id);
		}
		 _model.addAttribute("student",_student);
		
		return  "save";
	}
	@GetMapping("/remove/{id}")
	public String remove (@PathVariable(value="id") long _id,Model _model) {
		
		 _studentservice.removeStudent(_id);
		
		 
		
		 return  "redirect:/";
	}
	@PostMapping("/save")
	public String save (@ModelAttribute("student") Student _student) {
		//Student _student = new Student();
		//_student= (Student) _model.getAttribute("student");
		_studentservice.saveStudent(_student);
		return  "redirect:/";
	}
}
