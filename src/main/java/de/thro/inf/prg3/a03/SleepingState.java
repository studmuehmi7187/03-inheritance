package de.thro.inf.prg3.a03;

public class SleepingState extends State {

    @Override
    State successor(Cat c) {
        if(c.getSleep() == c.getTime()){
            return new HungryState();
        }
        return new SleepingState();
    }

    @Override
    public boolean equals(Object o){

        if(o == null){
            return false;
        }
        else if(o instanceof SleepingState){
            return true;
        }
        else{
            return false;
        }

    }
}
