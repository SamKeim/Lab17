package co.grandcircus;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {
	private static FileHelper<Country> fileHelper = new FileHelper<>("src/Countries.txt", new CountryLineConverter());

	public static void main(String[] args) {
		// Make file if it does not exist
		Path filePath = Paths.get("src/Countries.txt");
		try {
			if (Files.notExists(filePath)) {
				Files.createFile(filePath);
			}
		} catch (Exception e) {
			System.out.println("Error!");
		}
		
		CountriesApp ca = new CountriesApp();
		boolean cont = true;
		int userChoice;
		Scanner scnr = new Scanner(System.in);
		List<Country> countries = fileHelper.readAll();
		
		
		// use validators
		
		// delete country from list
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		do {
			ca.printMenu();
			userChoice = Validator.getInt(scnr, 1, 5);
			switch(userChoice) {
			case 1:
				System.out.println("Sort by [1] Name [2] Population [3] Unsorted");
				int userInt = Validator.getInt(scnr, 1, 3);
				ca.listCountries(countries, userInt);
				break;
			case 2:
				countries = ca.addCountry(scnr, countries);
				break;
			case 3:
				ca.deleteCountry(scnr, countries);
			case 4:
				//edit country
				ca.editCountry(scnr, countries);
				break;
			default:
				cont = false;
			}
		} while (cont);
		fileHelper.rewrite(countries);
		System.out.println("Thank you, goodbye.");
	}
	
	public List<Country> deleteCountry(Scanner scnr, List<Country> countries){
		CountriesApp ca = new CountriesApp();
		ca.listCountries(countries);
		System.out.println("Select a country:");
		int choice = Validator.getInt(scnr, 1, countries.size());
		countries.get(choice - 1);
		System.out.println("Confirm Delete (Y/N):");
		boolean delete = Validator.yesOrNo(scnr);
		if (delete) {
			countries.remove(choice - 1);
		}
		return countries;
	}
	
	public void printMenu() {
		System.out.println("1. View List");
		System.out.println("2. Add to List");
		System.out.println("3. Delete from List");
		System.out.println("4. Modify Country");
		System.out.println("5. Exit");
		System.out.println("");
		System.out.println("Enter menu option:");
	}
	public void listCountries(List<Country> countries, int key) {
		int i = 1;
		switch(key){
			case 1:
				Collections.sort(countries);
				break;
			case 2:
				System.out.println("Fixme");
				break;
			default:
				break;				
		}
		for (Country country : countries) {
			System.out.printf("%3d. %s", i++, country);
		}

	}
	public void listCountries(List<Country> countries) {
		int i = 1;
		for (Country country : countries) {
			System.out.printf("%3d. %s", i++, country);
		}
	}
	public List<Country> addCountry(Scanner scnr, List<Country> countries) {
		System.out.println("Enter Country Name:");
		String name = scnr.nextLine();
		System.out.println("Enter Population:");
		long population = Validator.getLong(scnr);
		countries.add(new Country(name, population));
		return countries;
	}
	public List<Country> editCountry(Scanner scnr, List<Country> countries){
		CountriesApp ca = new CountriesApp();
		ca.listCountries(countries);
		System.out.println("Select a country to edit:");
		int choiceIndex = Validator.getInt(scnr, 1, countries.size()) - 1;
		countries.get(choiceIndex);
		System.out.println("Select [1] Name [2] Population");
		int choice = Validator.getInt(scnr, 1, 2);
		switch(choice) {
		case 1:
			System.out.println("Enter name:");
			String name = scnr.nextLine();
			countries.get(choiceIndex).setName(name);
			break;
		default:
			System.out.println("Enter population:");
			long population = Validator.getLong(scnr);
			countries.get(choiceIndex).setPopulation(population);
		}
		return countries;
	}
}
