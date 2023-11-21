package expeditionplanner.model.equipment;

public class Vehicles extends Equipment implements Changeable{
	
	private Integer vehiclesNumber;
	
	public Vehicles() {
		super();
	}

	public Vehicles(Integer amount) {
		super(amount);
	}
	
	public Integer getVehiclesNumber() {
		return vehiclesNumber;
	}

	public void setVehiclesNumber(Integer vehiclesNumber) {
		this.vehiclesNumber = vehiclesNumber;
	}

	@Override
	public String printOtput() {
		return "N\u00FAmero de veh\u00EDculos: "
				.concat(String.valueOf(getVehiclesNumber()))
				.concat("\r\n")
				.concat("\r\n");
	}

	@Override
	public void changeable() {
		
	}
}