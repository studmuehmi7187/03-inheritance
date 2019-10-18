package de.thro.inf.prg3.a03;

import java.util.logging.Logger;

public abstract class State {

    static Logger logger;
    int t;
    int duration;

    final State tick(Cat c){

        return successor(c);

    }

    abstract State successor(Cat c);

}
