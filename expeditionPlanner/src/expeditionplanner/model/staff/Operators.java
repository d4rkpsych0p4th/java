package expeditionplanner.model.staff;

public class Operators {
	
	private Integer operatorsNumber;

	public Operators() {
		super();
	}

	public Operators(Integer operatorsNumber) {
		super();
		this.operatorsNumber = operatorsNumber;
	}

	public Integer getOperatorsNumber() {
		return operatorsNumber;
	}

	public void setOperatorsNumber(Integer operatorsNumber) {
		this.operatorsNumber = operatorsNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((operatorsNumber == null) ? 0 : operatorsNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operators other = (Operators) obj;
		if (operatorsNumber == null) {
			if (other.operatorsNumber != null)
				return false;
		} else if (!operatorsNumber.equals(other.operatorsNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operators [operatorsNumber = " + operatorsNumber + "]";
	}
	
	public String printOtput() {
		return "N\u00FAmero de operarios: "
				.concat(String.valueOf(operatorsNumber))
				.concat("\r\n");
	}
}
