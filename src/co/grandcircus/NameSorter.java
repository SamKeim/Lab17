package co.grandcircus;

import java.util.Comparator;

public class NameSorter implements Comparator<Country>{
	public int compare(Country c1, Country c2) {
		return c1.getName().compareTo(c2.getName());
	}
}
