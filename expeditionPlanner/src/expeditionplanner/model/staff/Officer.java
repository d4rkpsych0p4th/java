package expeditionplanner.model.staff;

public class Officer extends Staff {
	
	private Integer experienceYears;
	private Integer age;
	
	public Officer() {
		super();
	}
	
	public Officer(Officer o) {
		super(o.getName());
		this.experienceYears = o.getExperienceYears();
		this.age = o.getAge();
	}

	public Officer(String name, Integer experienceYears, Integer age) {
		super(name);
		this.experienceYears = experienceYears;
		this.age = age;
	}
	
	public Integer getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(Integer experienceYears) {
		this.experienceYears = experienceYears;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((experienceYears == null) ? 0 : experienceYears.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Officer other = (Officer) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (experienceYears == null) {
			if (other.experienceYears != null)
				return false;
		} else if (!experienceYears.equals(other.experienceYears))
			return false;
		return true;
	}
	
	 
	public int sortListDescending(Object o) {
		Officer otra = (Officer) o;
		return (-1) * this.getExperienceYears()
				.compareTo(otra.getExperienceYears());
	}
	
	public int sortListAscending(Object o) {
		Officer otra = (Officer) o;
		return this.getAge()
				.compareTo(otra.getAge());
	}
	
	@Override
	public String toString() {
		return super.toString() + " Officer [experienceYears = " + experienceYears + ", age = " + age + "]";
	}

	@Override
	public String printOtput() {
		return "Nombre: "
				.concat(this.getName())
				.concat("\r\nPuesto: Capit\u00E1n")
				.concat("\r\n")
				.concat("\r\n");
	}
}
