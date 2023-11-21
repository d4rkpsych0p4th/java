package expeditionplanner.model.staff;

public class SubOfficers extends Officer {


	public SubOfficers() {
		super();
	}
	
	public SubOfficers(Officer officer) {
		super(officer);
	}
	
	
	
	public SubOfficers(String name, Integer experienceYears, Integer age) {
		super(name, experienceYears, age);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String printOtput() {
		return "Nombre: "
				.concat(this.getName())
				.concat("\r\nPuesto: Suboficial")
				.concat("\r\n")
				.concat("\r\n");
	}
}
