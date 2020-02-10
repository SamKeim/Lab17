package co.grandcircus;

import java.nio.file.Paths;

import co.grandcircus.LineConverter;

public class Country implements Comparable<Country>{
	private String name;
	private long population;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public Country(String name, long population) {
		this.name = name;
		this.population = population;
	}
	public Country() {
	}
	@Override
	public String toString() {
		return String.format("%20s   ||   %,d\n", name, population);
	}
	
	@Override
	public int compareTo(Country country) {
		return this.getName().compareTo(country.getName());
	}
	
}
