package expeditionplanner.model.equipment;

public class Backpacks extends Equipment {

	private Integer backPacksNumber;
	
	public Backpacks() {
		super();
	}

	public Backpacks(Integer amount) {
		super(amount);
	}
	
	public Integer getBackPacksNumber() {
		return backPacksNumber;
	}

	public void setBackPacksNumber(Integer backPacksNumber) {
		this.backPacksNumber = backPacksNumber;
	}

	@Override
	public String printOtput() {
		return "N\u00FAmero de mochilas: "
				.concat(String.valueOf(getBackPacksNumber()))
				.concat("\r\n")
				.concat("\r\n");
	}
}