package de.fhro.inf.prg3.inheritance;

/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public enum GenusSpecies {

	GENUS_SPECIES_LION("Panthera leo", "Lion"),
	GENUS_SPECIES_GAZELLE("Gazella leptoceros", "Gazelle"),
	GENUS_SPECIES_FLAMINGO("Phoenicopterus jamesi", "Flamingo");

	private String readableType;
	private String type;

	GenusSpecies(String readableType, String type) {
		this.readableType = readableType;
		this.type = type;
	}

	public String getReadableType() {
		return readableType;
	}

	public String getType() {
		return type;
	}

}
