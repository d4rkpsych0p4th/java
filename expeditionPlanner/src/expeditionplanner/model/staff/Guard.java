package expeditionplanner.model.staff;

public class Guard extends Staff {
	
	private Integer aptitude;

	public Guard() {
		super();
	}

	public Guard(Integer aptitude) {
		super();
		this.aptitude = aptitude;
	}
	
	public Guard(String name, Integer aptitude) {
		super(name);
		this.aptitude = aptitude;
	}

	
	
	public Integer getAptitude() {
		return aptitude;
	}

	public void setAptitude(Integer aptitude) {
		this.aptitude = aptitude;
	}

	@Override
	public String toString() {
		return  super.toString() + " Guard [aptitude = " + aptitude + "]";
	}
	
	public int sortListDescending(Object o) {
		Guard otra = (Guard) o;
		return (-1) * this.getAptitude()
				.compareTo(otra.getAptitude());
	}

	@Override
	public String printOtput() {
		return "Nombre: "
				.concat(this.getName())
				.concat("\r\nPuesto: Guardia")
				.concat("\r\n")
				.concat("\r\n");
	}
}
