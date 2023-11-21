package expeditionplanner.model.staff;

import java.util.ArrayList;
import java.util.Collection;

public class Officers extends ArrayList<Officer> {

	/**
	 * UID.
	 */
	private static final long serialVersionUID = 4017018990360366882L;
	
	private Integer seniorOfficerExperience;

	public Officers() {
		super();
	}

	public Officers(Collection<? extends Officer> c) {
		super(c);
	}

	public Officers(int initialCapacity) {
		super(initialCapacity);
	}
	
	/**
	 * Ordena una lista de oficiales en funcion de su experiencia
	 * @return - Retorna el oficial con mayor experiencia
	 */
	public Officer findSeniorOfficer() {
		Officer officer = this.stream().sorted((o, o1) -> o.sortListDescending(o1)).
				findFirst().get();
		setSeniorOfficerExperience(officer.getExperienceYears());
		return officer;
	}

	public Integer getSeniorOfficerExperience() {
		return seniorOfficerExperience;
	}

	public void setSeniorOfficerExperience(Integer seniorOfficerExperience) {
		this.seniorOfficerExperience = seniorOfficerExperience;
	}
}
