package de.thro.inf.prg3.a03.states;

import de.thro.inf.prg3.a03.Animal;
import de.thro.inf.prg3.a03.State;

/**
 * @author Peter Kurfer
 * Created on 10/13/17.
 */
public class PlayfulState extends State {

    PlayfulState(Animal animal, int duration) {
        super(animal, duration);
    }

    @Override
    public State successor() {
        logger.info("Yoan... getting tired!");
        return new SleepingState(animal, animal.getSleeping());
    }
}
