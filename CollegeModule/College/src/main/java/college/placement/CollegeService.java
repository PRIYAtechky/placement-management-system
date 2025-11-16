package college.placement;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CollegeService {
   @Autowired 
   private CollegeRepo repo;
    
   
   public List<College> getCollege(){
	   return repo.findAll();
			   }
   
  


public College getCollegeId(long id){
	  return repo.findById(id).get() ;

			   }

public void save(College college) {
    repo.save(college);
}

public void delete(Long id) {
	repo.deleteById(id);
}
}
