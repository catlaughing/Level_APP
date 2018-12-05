package id.sikogrup.level_app;

import java.util.*;

public class Quest {
    private String nama;
    private String deskripsi;
    private int rewardPoint;
    private int rewardExp;
    private String gmKey;
    private String key;
    private HashMap<Adventurer,String> pengumpulan = new HashMap();

    private int tipe;
    private String startDate;
    private String endDate;

    public Quest() {
    }

    public Quest(String nama, String deskripsi, int rewardPoint, int rewardExp, String gmKey) {
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.rewardPoint = rewardPoint;
        this.rewardExp = rewardExp;
        this.gmKey = gmKey;
    }



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGmKey() {
        return gmKey;
    }

    public void setGmKey(String gmKey) {
        this.gmKey = gmKey;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public HashMap<Adventurer, String> getPengumpulan() {
        return pengumpulan;
    }

    public void setPengumpulan(HashMap<Adventurer, String> pengumpulan) {
        this.pengumpulan = pengumpulan;
    }

    public int getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(int rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public int getRewardExp() {
        return rewardExp;
    }

    public void setRewardExp(int rewardExp) {
        this.rewardExp = rewardExp;
    }

    public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void printTipe() {
        switch (getTipe()) {
            case 1:
                System.out.println("Normal Quest");
                break;
            case 2:
                System.out.println("Daily Quest");
                break;
            default:
                System.out.println("Grand Quest");
                break;
        }
    }

    public void submitQuest(Adventurer adventurer,String answer){
        pengumpulan.put(adventurer, answer);
    }

    public void showSubmitQuest(){
        for (Adventurer kumpul : pengumpulan.keySet()){
            String jawaban = pengumpulan.get(kumpul);
            System.out.println(kumpul.getName() + " || Jawaban : " + jawaban);
        }
    }

}
