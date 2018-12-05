package id.sikogrup.level_app;

import java.util.*;
import java.lang.Math.*;

public class Adventurer extends User implements Comparable<Adventurer> {
    private int exp,level;
    private ArrayList<String> takenGuild;
    private Map<String,Integer> points; //ini juga gw bikin jadi maps, baca docs nya di geeksforgeeks
    private ArrayList<String> takenQuest;

    public Adventurer() {
    }

    public Adventurer(String username, String email, String name, String phone, String uID, int exp, int level) {
        super(username, email, name, phone, uID);
        this.exp = exp;
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<String> getTakenGuild() {
        return takenGuild;
    }

    public void setTakenGuild(ArrayList<String> takenGuild) {
        this.takenGuild = takenGuild;
    }

    public Map<String, Integer> getPoints() {
        return points;
    }

    public void setPoints(Map<String, Integer> points) {
        this.points = points;
    }

    public ArrayList<String> getTakenQuest() {
        return takenQuest;
    }

    public void setTakenQuest(ArrayList<String> takenQuest) {
        this.takenQuest = takenQuest;
    }

    public float nextLevel()
    {
        return Math.round((4 * Math.pow(this.level, 3)) / 5);
    }

//    public void joinGuild(Guild g){
//        g.addAdventurer(this); //Nambahin dia ke guild
//        this.takenGuild.add(g); //Nambahin guild nya ke list guild yang pernah dia ambil
//        this.points.put(g, 0); //bikin object baru dalam map key nya guild itu value nya 0
//    }



    public void updateExp(int exp){
        //buat update exp kalau lebih dari 100 naik level
        while (this.exp >= nextLevel())
        {
            this.exp -= nextLevel();
            this.level++;
        }
    }
    public int getExp(){
        return this.exp;
    }



    @Override
    public int compareTo(Adventurer o) {
        return o.getName().compareTo(this.getName());
    }
}
