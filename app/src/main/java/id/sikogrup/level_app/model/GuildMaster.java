package id.sikogrup.level_app;

import java.util.*;

public class GuildMaster extends User {

    public GuildMaster(String username, String email, String name, String phone, String uID) {
        super(username, email, name, phone, uID);
    }

    //Membuat list adventurer dan guide book baru, membuat guild baru dan memasukkan ke list guild
//    public void makeGuild(String name, String subject, int levelRequirement){
//        Guild guild = new Guild(name,subject,levelRequirement,this);
//        this.listGuild.add(guild);
//    }

    //Membuat list adventurer dan guide book baru, membuat guild baru dan memasukkan ke list guild
//    public void makeQuest(Guild guild, String name, String deskripsi, int tipe, String deadline, String startDate, int rewardPoint, int rewardExp){
//        Quest quest = new Quest(name,deskripsi,tipe,deadline,startDate,rewardPoint,rewardExp,this,guild);
//        guild.addQuest(quest);
//    }

    //Membuat guidebookbaru dan memasukkan ke guild
    public void makeGuideBook(Guild guild, String judul, String isi, int rewardExp, int rewardPoint){
        Guide_Book guideBook = new Guide_Book(this,guild,judul,isi,rewardExp,rewardPoint);
//        guild.addGuideBook(guideBook);
    }



    @Override
    public String toString(){
        return "Name : "+super.getName()+"|| Contact : "+super.getPhone();
    }
}
