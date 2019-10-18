package de.thro.inf.prg3.a03;

public class DeathState extends State{

    @Override
    State successor(Cat c) {
        return null;
    }

    @Override
    public boolean equals(Object o){

        if(o == null){
            return false;
        }
        else if(o instanceof DeathState){
            return true;
        }
        else{
            return false;
        }

    }

}
