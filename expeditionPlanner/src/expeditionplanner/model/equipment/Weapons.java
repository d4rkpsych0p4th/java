package expeditionplanner.model.equipment;

public class Weapons extends Equipment {
	
	
	private Integer weaponsNumber;
	
	public Weapons() {
		super();
	}

	public Weapons(Integer amount) {
		super(amount);
	}
	
	
	public Integer getWeaponsNumber() {
		return weaponsNumber;
	}

	public void setWeaponsNumber(Integer weaponsNumber) {
		this.weaponsNumber = weaponsNumber;
	}

	@Override
	public String printOtput() {
		return "N\u00FAmero de armas: "
				.concat(String.valueOf(getWeaponsNumber()))
				.concat("\r\n")
				.concat("\r\n");
	}
	
}
