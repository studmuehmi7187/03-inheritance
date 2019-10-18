package de.thro.inf.prg3.a03;

public class DigestingState extends State {

    @Override
    State successor(Cat c) {

        if(c.getTime() == c.getDigest()){

            return new PlayfulState();

        }

        return new DigestingState();

    }

    @Override
    public boolean equals(Object o){

        if(o == null){
            return false;
        }
        else if(o instanceof DigestingState){
            return true;
        }
        else{
            return false;
        }

    }

}
