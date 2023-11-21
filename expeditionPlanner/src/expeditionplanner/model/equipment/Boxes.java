package expeditionplanner.model.equipment;

public class Boxes extends Equipment {

	private Integer boxesNumber;
	
	public Boxes() {
		super();
	}

	public Boxes(Integer amount) {
		super(amount);
	}
	
	public Integer getBoxesNumber() {
		return boxesNumber;
	}

	public void setBoxesNumber(Integer boxesNumber) {
		this.boxesNumber = boxesNumber;
	}

	@Override
	public String printOtput() {
		return "N\u00FAmero de cajas: "
				.concat(String.valueOf(getBoxesNumber()))
				.concat("\r\n")
				.concat("\r\n");
	}
}