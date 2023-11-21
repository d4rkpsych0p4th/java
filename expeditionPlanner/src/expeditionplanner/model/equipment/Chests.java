package expeditionplanner.model.equipment;

public class Chests extends Equipment implements Changeable{
	
	private Integer chestNumber;

	public Chests() {
		super();
	}

	public Chests(Integer amount) {
		super(amount);
	}
	
	public Integer getChestNumber() {
		return chestNumber;
	}

	public void setChestNumber(Integer chestNumber) {
		this.chestNumber = chestNumber;
	}

	@Override
	public String printOtput() {
		return "N\u00FAmero de arcones: "
				.concat(String.valueOf(getChestNumber()))
				.concat("\r\n")
				.concat("\r\n");
	}

	@Override
	public void changeable() {
		
	}
}