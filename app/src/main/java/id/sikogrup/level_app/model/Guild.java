package id.sikogrup.level_app;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Guild implements Serializable {
    private String gmKey;
    private String nameGuild;
    private String subject;
    private int levelRequirement;
    private String key;
    private SortedMap<String,Integer> listAdventurer;
    private ArrayList<String> listGuide_Book;
    private ArrayList<String> listQuest;

    public Guild() {
    }

    public Guild(String gmKey, String nameGuild, String subject, int levelRequirement) {
        this.gmKey = gmKey;
        this.nameGuild = nameGuild;
        this.subject = subject;
        this.levelRequirement = levelRequirement;
    }

    public String getGmKey() {
        return gmKey;
    }

    public void setGmKey(String gmKey) {
        this.gmKey = gmKey;
    }

    public String getNameGuild() {
        return nameGuild;
    }

    public void setNameGuild(String nameGuild) {
        this.nameGuild = nameGuild;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SortedMap<String, Integer> getListAdventurer() {
        return listAdventurer;
    }

    public void setListAdventurer(SortedMap<String, Integer> listAdventurer) {
        this.listAdventurer = listAdventurer;
    }

    public ArrayList<String> getListGuide_Book() {
        return listGuide_Book;
    }

    public void setListGuide_Book(ArrayList<String> listGuide_Book) {
        this.listGuide_Book = listGuide_Book;
    }

    public ArrayList<String> getListQuest() {
        return listQuest;
    }

    public void setListQuest(ArrayList<String> listQuest) {
        this.listQuest = listQuest;
    }

    @Override
    public String toString(){
        return "Name : "+this.getNameGuild()+"|| Subject : "+this.subject+"|| Level Req : "+this.levelRequirement;
    }

    public static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
}
