package expeditionplanner.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import expeditionplanner.exceptions.CustomizeException;
import expeditionplanner.model.equipment.Backpacks;
import expeditionplanner.model.equipment.Boxes;
import expeditionplanner.model.equipment.Chests;
import expeditionplanner.model.equipment.Vehicles;
import expeditionplanner.model.equipment.Weapons;
import expeditionplanner.model.staff.Guard;
import expeditionplanner.model.staff.Guards;
import expeditionplanner.model.staff.Officer;
import expeditionplanner.model.staff.Officers;
import expeditionplanner.model.staff.SubOfficers;
import expeditionplanner.utils.FileUtilities;

public class Service {
	
	public static Logger logger = Logger.getLogger(Service.class.getName());
	
	public static final Integer ALLOWED_WEIGHT_BY_VEHICLE = 1000;
	
	private Guards guards;
	private Officers officers;
	private Guard guard;
	private Officer officer;
	private Integer officersNumber;
	private Integer subofficerNumber;
	private Integer guardsNumber;
	private Weapons weapons;
	private Vehicles vehicles;
	private Chests chests;
	private Boxes boxes;
	private Backpacks backpacks;
	private Integer expeditionMembers;
	private Boolean isDangerous;
	private Integer materialWeight;
	public List<String> output;

	
	
	public Service(Integer expeditionMembers, Boolean isDangerous, Integer materialWeight) {
		super();
		this.expeditionMembers = expeditionMembers;
		this.isDangerous = isDangerous;
		this.materialWeight = materialWeight;
		officers = new Officers();
		guards = new Guards();
		output = new ArrayList<>();
		officersNumber = 0 ;
		subofficerNumber = 0;
		guardsNumber = 0;
		
	}


	public List<String> calculateExpeditionResources(String pathFile){

		String method = "calculateExpeditionResources () - ";
		logger.info("START" +  method);
		
		try {

			processData(pathFile);

			assignOfficer();

			assignSubOfficer();

			assignGuards();

			assignWeapons();

			assignBoxes();

			assignVehicles();

			assignBackPacks();

			assignChest();

		} catch (CustomizeException e) {
			output.clear();
			output.add(e.getMessage());
		} finally {
			logger.info("END" + method);
		}

		return output;
	}

	private List<String> processData(String pathFile) throws CustomizeException {
		String method = "processData () - ";
		logger.info("START" +  method);
		
		String data = FileUtilities.getInputFromFile(pathFile);
		
		logger.info("DATA: " + (data));
		
		if (data == null || data.isEmpty()) {
			throw new CustomizeException("El archivo " + pathFile + " esta vacio");
		}
		
		List<String> dataList = Arrays.asList( data.split("//"));
		
		if (dataList != null && !dataList.isEmpty()) {
			dataList.forEach(e -> assignData(e));
		} 
		
		logger.info("Output: " +  method);
		
		logger.info("END " +  method);
		return output;	
	}
	
	private void assignData(String data) {
		String method = "assignData () - ";
		logger.info("Start" +  method);
		
		List<String> dataList = Arrays.asList( data.split(";"));
		
		switch(dataList.get(0)) {
		
			case "officer": { // oficial;nombre;experiencia;edad
				officer = new Officer(dataList.get(1), Integer.valueOf(dataList.get(2)), Integer.valueOf(dataList.get(3)));
				officers.add(officer);
				break;
			}
			case "guard": { // guardia;nombre;aptitud
				guard = new Guard(dataList.get(1), Integer.valueOf(dataList.get(2)));
				guards.add(guard);
				break;
			}
			case "weapons": { // armas;disponibles
				weapons = new Weapons(Integer.valueOf(dataList.get(1)));
				break;
			}
			case "boxes": { // cajas;disponibles
				boxes = new Boxes(Integer.valueOf(dataList.get(1)));
				break;
			}
			case "vehicles": { // vehiculos;disponibles
				vehicles = new Vehicles(Integer.valueOf(dataList.get(1)));
				break;
			}
			case "backpacks": { // mochilas;disponibles
				backpacks = new Backpacks(Integer.valueOf(dataList.get(1)));
				break;
			}
			case "chests": { // arcones;disponibles
				chests = new Chests(Integer.valueOf(dataList.get(1)));
				break;
			}
		}
		
		logger.info("End" +  method);
	}
	
	private void assignOfficer() throws CustomizeException {

		if (officersNumber > officers.size()) {
			throw new CustomizeException("No hay oficiales suficientes");
		} else {
			Officer officer = officers.findSeniorOfficer();
			output.add(officer.printOtput());
			officersNumber++;
		}
		
		
	}
	
	private void assignSubOfficer() throws CustomizeException {

		Integer totalSubOficiales = expeditionMembers / 20;

		if (totalSubOficiales > officers.size()) {
			throw new CustomizeException("No hay suboficiales suficientes");
		} else {

			List<Officer> officersFilter = officers.stream()
					.filter(e -> e.getExperienceYears() < officers.getSeniorOfficerExperience())
					.sorted((o, o1) -> o.sortListAscending(o1)).collect(Collectors.toList());

			List<SubOfficers> subOfficers = new ArrayList<>();

			officersFilter.forEach(e -> {
				SubOfficers subOfficer = new SubOfficers(e);
				subOfficers.add(subOfficer);

			});

			for (int i = 0; i < totalSubOficiales; i++) {
				output.add(subOfficers.get(i).printOtput());
				subofficerNumber++;
			}
		}
	}

	private void assignGuards() throws CustomizeException {

		Integer totalGuards = (isDangerous) ? ((expeditionMembers * 2) / 10) : (expeditionMembers / 10);

		if (totalGuards > guards.size()) {
			throw new CustomizeException("No hay guardias suficientes");
		} else {
			
			List<Guard> guardsFilter = guards.stream()
					.sorted((o, o1) -> o.sortListDescending(o1)).collect(Collectors.toList());

			for (int i = 0; i < totalGuards; i++) {
				output.add(guardsFilter.get(i).printOtput());
				guardsNumber++;
			}
		}
	}
	
	private void assignWeapons() throws CustomizeException {
		
		// Un arma para cada guardia y cada oficial.
		Integer totalWeapons = officersNumber 
				+ subofficerNumber 
				+ guardsNumber;
		
		if (totalWeapons > weapons.getAmount()) {
			throw new CustomizeException("No hay armas suficientes");
		} else {
			weapons.setWeaponsNumber(totalWeapons);
			output.add(weapons.printOtput());
		}
	}
	
	private void assignBoxes() throws CustomizeException {
		// Una caja por cada 100 kg de carga.
		
		Integer totalBoxes =  materialWeight / 100;
		
		if (totalBoxes > boxes.getAmount()) {
			throw new CustomizeException("No hay cajas suficientes");
		} else {
			boxes.setBoxesNumber(totalBoxes);
			output.add(boxes.printOtput());
		}
	}
	
	private void assignVehicles() throws CustomizeException {
		
		//Un vehiculo por cada 10 miembros de la expedicion o 1000kg de carga
	
		Integer vehiclesByMembers = expeditionMembers / 10;
		Integer vehiclesByKg = materialWeight / ALLOWED_WEIGHT_BY_VEHICLE;
		
		Integer totalVehicles = vehiclesByMembers + vehiclesByKg;
		
		if(totalVehicles > vehicles.getAmount()) {
			throw new CustomizeException("Numero de vehiculos insuficientes");	
		} else {
			vehicles.setVehiclesNumber(totalVehicles);
			output.add(vehicles.printOtput());
		}
	}
	
	private void assignBackPacks() throws CustomizeException {
		
		// Una mochila por cada miembro de la expedicion, salvo para los oficiales.
		
		Integer totalBackPacks = guardsNumber;
		
		if (totalBackPacks > backpacks.getAmount()) {
			throw new CustomizeException("Numero de mochilas insuficientes");
		} else {
			backpacks.setBackPacksNumber(totalBackPacks);
			output.add(backpacks.printOtput());
		}
	}
	
	private void assignChest() throws CustomizeException {
		// Un arcon para cada oficial.
		
		Integer totalChest = officersNumber + subofficerNumber;
		
		if (totalChest > chests.getAmount()) {
			throw new CustomizeException("Numero de arcones insuficientes");
		}
	}
}
