package dlsu.module7;

import javafx.scene.image.Image;
import java.io.*;
import java.util.*;


public class Pokemon {
    private final String name;
    private final String type;
    private final String height;
    private final String weight;
    private final double attack;
    private final double defense;
    private final double stamina;
    public Pokemon(String[] dataset){
        name = dataset[0];
        height = dataset[1];
        weight = dataset[2];
        type = dataset[3];
        attack = Double.parseDouble(dataset[4]);
        defense = Double.parseDouble(dataset[5]);
        stamina = Double.parseDouble(dataset[6]);
    }
    String getPokeName() {return name;}
    String getType() {return type;}
    String getPokeHeight() {return height;}
    String getPokeWeight() {return weight;}
    double getPokeAttack() {return attack;}
    double getPokeDefense() {return defense;}
    double getPokeStamina() {return stamina;}
}
