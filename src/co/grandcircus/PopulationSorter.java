package co.grandcircus;

import java.util.Comparator;

public class PopulationSorter implements Comparator<Country>{
	public int compare(Country c1, Country c2) {
		Long val1 = c1.getPopulation();
		Long val2 = c2.getPopulation();
		
		return val2.compareTo(val1);
	}
}

