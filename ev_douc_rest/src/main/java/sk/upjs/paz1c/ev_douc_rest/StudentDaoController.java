package sk.upjs.paz1c.ev_douc_rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.ed.entity.DoucovanyPredmet;
import sk.upjs.ed.entity.Student;
import sk.upjs.ed.persistent.DaoFactory;
import sk.upjs.ed.persistent.DoucovanyPredmetDao;
import sk.upjs.ed.persistent.StudentDao;

@RestController
public class StudentDaoController {

	private StudentDao student = DaoFactory.INSTANCE.getStudentDao();

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/student")
	public List<Student> getAll() {
		return student.getAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public void add(@RequestBody Student s) {
		student.add(s);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public void saveUser(@RequestBody Student s) {
		student.save(s);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable long id) {
		student.delete(id);
	}
}
