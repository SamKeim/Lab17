package co.grandcircus;

public class CountryLineConverter implements LineConverter<Country> {

	@Override
	public String toLine(Country object) {
		return String.format("%s\t%d", object.getName(), object.getPopulation());
	}

	@Override
	public Country fromLine(String line) {
		String[] arr = line.split("\t");
		String name = arr[0];
		long population = Long.parseLong(arr[1]);
		return new Country(name, population);
	}
	

}
