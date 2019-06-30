
public class Player {

protected String number;
protected String name;
protected String position;
protected String height;
protected String weight;
protected String birthdate;
protected String nationality;
protected String yearsexperience;
protected String college;
	
	Player(String number, String name, String position, String height, String weight, String birthdate, String nationality, String yearsexperience, String college){
		this.number = number;
		this.name = name;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.birthdate = birthdate;
		this.nationality = nationality;
		this.yearsexperience = yearsexperience;
		this.college = college;
		
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getHeight() {
		return height;
	}

	public String getWeight() {
		return weight;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getNationality() {
		return nationality;
	}

	public String getYearsexperience() {
		return yearsexperience;
	}

	public String getCollege() {
		return college;
	}
}
