    package placement.studentmodule;
    import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	@Entity
	@Table(name = "student")
	public class Student {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String email;
	    private String degree;
	    private Integer graduationYear;

	    // Getters and setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getDegree() {
	        return degree;
	    }

	    public void setDegree(String degree) {
	        this.degree = degree;
	    }

	    public Integer getGraduationYear() {
	        return graduationYear;
	    }

	    public void setGraduationYear(Integer graduationYear) {
	        this.graduationYear = graduationYear;
	    }
	}	
