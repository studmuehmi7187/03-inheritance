package de.thro.inf.prg3.a03;

public class HungryState extends State {

    @Override
    State successor(Cat c) {

        if(c.getTime() == (c.getAwake() + c.getSleep())){
            return new DeathState();
        }else if(c.getTime() == 0){
            return new DigestingState();
        }

        return new HungryState();

    }

    @Override
    public boolean equals(Object o){

        if(o == null){
            return false;
        }
        else if(o instanceof HungryState){
            return true;
        }
        else{
            return false;
        }

    }

}
