package de.fhro.inf.prg3.inheritance;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import static de.fhro.inf.prg3.inheritance.Animal.State.*;

/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public class Animal {

	private static final Logger logger = LogManager.getLogger();

	public enum State {SLEEPING, HUNGRY, DIGESTING, PLAYFUL, DEAD}

	private State state = State.SLEEPING;

	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	private final int collectionAmount;
	private final GenusSpecies genusSpecies;
	private final GenusSpecies[] devours;

	private int time = 0;

	public Animal(GenusSpecies genusSpecies, String name, GenusSpecies[] devours, int sleep, int awake, int digest, int collectionAmount) {
		this.name = name;
		this.genusSpecies = genusSpecies;
		this.devours = devours;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.collectionAmount = collectionAmount;

		Arrays.sort(this.devours);
	}

	public void tick(){
		logger.info("tick()");
		time++;
		switch (state) {
			case SLEEPING:
				if (time == sleep) {
					logger.info("Yoan... getting hungry!");
					state = HUNGRY;
					time = 0;
				}
				break;
			case HUNGRY:
				if(time == awake){
					logger.info("I've starved for a too long time...good bye...");
					state = DEAD;
				}
				break;
			case DIGESTING:
				if (time == digest) {
					logger.info("Getting in a playful mood!");
					state = PLAYFUL;
					time = 0;
				}
				break;
			case PLAYFUL:
				if (time == awake) {
					logger.info("Yoan... getting tired!");
					state = SLEEPING;
					time = 0;
				}
				break;

			case DEAD:
				break;
			default:
				throw new IllegalStateException("Unknown cat state " + state.name());
		}

		logger.info(state.name());

	}

	public void feed(){
		if (!state.equals(State.HUNGRY))
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");
		time = 0;
		state = State.DIGESTING;

	}

	public boolean devours(Animal other){
		return Arrays.binarySearch(this.devours, other.genusSpecies) >= 0;
	}

	public String getName() {
		return name;
	}

	public int collect() {
		if(!isPlayful()){
			throw new IllegalStateException("One does not simply collect if the animal is not playful!");
		}
		return collectionAmount;
	}

	public boolean isAsleep() {
		return state.equals(State.SLEEPING);
	}

	public boolean isPlayful() {
		return state.equals(State.PLAYFUL);
	}

	public boolean isHungry() {
		return state.equals(State.HUNGRY);
	}

	public boolean isDigesting() {
		return state.equals(State.DIGESTING);
	}

	public boolean isDead() {
		return state == State.DEAD;
	}
}
