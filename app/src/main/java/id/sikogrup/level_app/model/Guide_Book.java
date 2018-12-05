package id.sikogrup.level_app;

public class Guide_Book {
    private String id_GuideBook;
    private static int i=1;
    private GuildMaster gm;
    private Guild guild;
    private String judul;
    private String isi;
    private int rewardExp;
    private int rewardPoint;

    public Guide_Book(GuildMaster gm, Guild guild, String judul, String isi,int rewardExp, int rewardPoint){
        this.id_GuideBook = ("GuideBook_"+(i++));
        this.gm=gm;
        this.isi=isi;
        this.judul=judul;
        this.guild=guild;
        this.rewardExp=rewardExp;
        this.rewardPoint=rewardPoint;
    }

    public GuildMaster getGm(){
        return gm;
    }

    public String getId_GuideBook() {
        return id_GuideBook;
    }

    public Guild getGuild(){
        return guild;
    }

    public String getJudul(){
        return judul;
    }

    public void setJudul(String judul){
        this.judul=judul;
    }

    public String getIsi(){
        return isi;
    }

    public void setIsi (String isi){
        this.isi=isi;
    }


    public int getRewardExp(){
        return rewardExp;
    }

    public int getRewardPoint(){
        return rewardPoint;
    }
}
