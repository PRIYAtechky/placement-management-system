package college.placement;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("college")
public class CollegeController {

    @Autowired
    private CollegeService ser;
    
    @GetMapping
    public List<College> getAllCollege() {
		return ser.getCollege();

	}
    
    @GetMapping("/{id}")
    public ResponseEntity<College> get(@PathVariable Long id) {
		try {
			College cl = ser.getCollegeId(id);
			return new ResponseEntity<College>(cl, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
		}
	}
    
    @PostMapping
    public void add(@RequestBody College college) {
        ser.save(college);  // This will save all fields including collegeName
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody College college, @PathVariable Long id) {
        try {
            College cl = ser.getCollegeId(id);
            if (cl != null)
                ser.save(college);
            return new ResponseEntity<>(cl, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		ser.delete(id);

	}
}
