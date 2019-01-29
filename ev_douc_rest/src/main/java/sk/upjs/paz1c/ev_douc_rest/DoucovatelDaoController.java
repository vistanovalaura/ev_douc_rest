package sk.upjs.paz1c.ev_douc_rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sk.upjs.ed.entity.Doucovatel;
import sk.upjs.ed.persistent.DaoFactory;
import sk.upjs.ed.persistent.DoucovatelDao;

@RestController
public class DoucovatelDaoController {

	private DoucovatelDao doucovatel = DaoFactory.INSTANCE.getDoucovatelDao();

	@RequestMapping("/doucovatel")
	public List<Doucovatel> getAll() {
		return doucovatel.getAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/doucovatel", method = RequestMethod.POST)
	public void add(@RequestBody Doucovatel d) {
		doucovatel.add(d);
	}

	@RequestMapping(value = "/doucovatel", method = RequestMethod.PUT)
	public void save(@RequestBody Doucovatel d) {
		doucovatel.save(d);
	}

	@RequestMapping(value = "/doucovatel/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		doucovatel.delete(id);
	}
}
