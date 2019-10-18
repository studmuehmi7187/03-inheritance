package de.thro.inf.prg3.a03;

public class PlayfulState extends State {

    @Override
    State successor(Cat c) {

        return new SleepingState();
        //return new PlayfulState();

    }

    @Override
    public boolean equals(Object o){

        if(o == null){
            return false;
        }
        else if(o instanceof PlayfulState){
            return true;
        }
        else{
            return false;
        }

    }

}
