package de.thro.inf.prg3.a03;

import de.thro.inf.prg3.a03.states.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public class Animal {

	private static final Logger logger = LogManager.getLogger();

	private State state;

	/// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	/// money you make, when people watch your animal
	private final int collectionAmount;
	private final GenusSpecies genusSpecies;

	/// those species this animal likes to eat
	private final GenusSpecies[] devours;

	public Animal(GenusSpecies genusSpecies, String name, GenusSpecies[] devours, int sleep, int awake, int digest, int collectionAmount) {
		if(awake < digest) throw new IllegalArgumentException("Makes no sense that an animal needs more time for digesting that it is awake!");
		this.name = name;
		this.genusSpecies = genusSpecies;
		this.devours = devours;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.collectionAmount = collectionAmount;
		this.state = new SleepingState(this, sleep);

		Arrays.sort(this.devours);
	}

	public void tick(){
		this.state = state.tick();
	}

	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");
		HungryState hungryState = (HungryState)state;
		this.state = hungryState.feed();
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
		this.state = new SleepingState(this, sleep);
		return collectionAmount;
	}

	public int getSleeping() {
		return sleep;
	}

	public int getAwake(){
		return awake;
	}

	public int getDigest(){
		return digest;
	}

	public boolean isAsleep() {
		return state instanceof SleepingState;
	}

	public boolean isPlayful() {
		return state instanceof PlayfulState;
	}

	public boolean isHungry() {
		return state instanceof HungryState;
	}

	public boolean isDigesting() {
		return state instanceof DigestingState;
	}

	public boolean isDead() {
		return state instanceof DeadState;
	}
}
