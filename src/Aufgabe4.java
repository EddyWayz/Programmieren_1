//-------------------------------------------------------------------
// Aufgabe 4
//
// implementieren Sie alle Teilaufgaben der Aufgabe 4 in diesem File
//
// ------------------------------------------------------------------

import java.util.*;




public class Aufgabe4
{

    public static void main(String[] args)
    {
        System.out.println("Aufgabe 4");

    }


}

abstract class Coin {
    private float value;

    public Coin(float value){
        this.value = value;
    }

     public final float getValue(){
        return value;
    }

     public abstract String getLabel();
}

class TwoCents extends Coin {
    private String color;

    public TwoCents() {
        super((float) 0.02);
    }

    public String getColor() {
        return color;
    }

    @Override
    public String getLabel() {
        return "";
    }
}


