package placementproject;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "placements")

public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int collegeId;  

    private LocalDate date;

    private String qualification;

    private int year;

	public int getid() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getQualification() {
		return qualification;
	}

	public int getYear() {
		return year;
	}

	public void setName(String name) {
		this.name=name;
	}

	public void setCollegeId(int name) {
		this.collegeId=collegeId;
	}

	public void setDate(LocalDate date) {
		this.date=date;
	}

	public void setQualification(String qualification) {
		this.qualification=qualification;
	}

	public void setYear(int year) {
		this.year=year;
	}
}
