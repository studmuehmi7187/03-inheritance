package de.thro.inf.prg3.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import de.thro.inf.prg3.a03.State;


public class Cat {

	private int sleep;
	private int awake;
	private int digest;
	private int time = 0;

	private State currentState;

	private String name;

	public Cat(String name, int sleep, int awake, int digest){

		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		currentState = new SleepingState();

	}

	public void feed(){
		time = 0;
		if(this.isHungry()){
			this.currentState = currentState.successor(this);
		}else{
			throw new IllegalStateException("Can't stuff a full cat");
		}

	}

	public void tick(){
		time++;
		this.currentState = currentState.successor(this);
	}

	public boolean isAsleep(){
		return currentState.equals(new SleepingState());
	}
	public boolean isAwake(){
		return !isAsleep();
	}
	public boolean isPlayful(){
		return currentState.equals(new PlayfulState());
	}
	public boolean isHungry(){
		return currentState.equals(new HungryState());
	}
	public boolean isDigesting(){
		return currentState.equals(new DigestingState());
	}
	public boolean isDead(){
		return currentState.equals(new DeathState());
	}

	int getSleep(){return sleep;}
	int getDigest(){return digest;}
	int getAwake(){return awake;}
	String getName(){return name;}

	int getTime(){return time;}
























	//private static final Logger logger = LogManager.getLogger();

	// valid states
	//public enum State {SLEEPING, HUNGRY, DIGESTING, PLAYFUL, DEAD}

	// initially, animals are sleeping
	//private State state = State.SLEEPING;

	// state durations (set via constructor), ie. the number of ticks in each state
	/*private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	private int time = 0;
	private int timeDigesting = 0;*/

	/*public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
	}*/

	/*public void tick(){
		logger.info("tick()");
		time = time + 1;

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
				timeDigesting = timeDigesting + 1;
				if (timeDigesting == digest) {
					logger.info("Getting in a playful mood!");
					state = PLAYFUL;
				}
				break;
			case PLAYFUL:
				if (time >= awake) {
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

	}*/

	/*
	 * This would be a user interaction: feed the cat to change its state!
	 */
	/*public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");

		logger.info("You feed the cat...");

		// change state and reset the timer
		state = State.DIGESTING;
		timeDigesting = 0;
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

	@Override
	public String toString() {
		return name;
	}*/

}
