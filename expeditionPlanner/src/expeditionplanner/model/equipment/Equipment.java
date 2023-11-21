package expeditionplanner.model.equipment;

/**
 * 
 * @author Alvaro
 *
 */
public abstract class Equipment {
	
	private Integer amount;
	
	public Equipment() {
		super();
	}

	public Equipment(Integer amount) {
		super();
		this.amount = amount;
	}
	
	public abstract String printOtput();

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
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
		Equipment other = (Equipment) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipment [amount=" + amount + "]";
	}
}