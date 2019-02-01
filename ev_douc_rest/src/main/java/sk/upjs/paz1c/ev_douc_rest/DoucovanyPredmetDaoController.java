package sk.upjs.paz1c.ev_douc_rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.ed.entity.DoucovanyPredmet;
import sk.upjs.ed.persistent.DaoFactory;
import sk.upjs.ed.persistent.DoucovanyPredmetDao;

import org.springframework.http.HttpStatus;

@RestController
public class DoucovanyPredmetDaoController {

	private DoucovanyPredmetDao dp = DaoFactory.INSTANCE.getPredmetDao();

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/doucovanePredmety")
	public List<DoucovanyPredmet> getAll() {
		return dp.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/doucovanePredmety", method = RequestMethod.POST)
	public void add(@RequestBody DoucovanyPredmet p) {
		dp.add(p);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/doucovanePredmety", method = RequestMethod.PUT)
	public void save(@RequestBody DoucovanyPredmet p) {
		dp.save(p);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/doucovanePredmety/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		dp.delete(id);
	}

}
