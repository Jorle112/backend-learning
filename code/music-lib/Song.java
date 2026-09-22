public class Song{
    private int id;
    private String title;
    private String artist;
    private String genre;
    private int duration;

    public Song(int id,String title,String artist,String genre,int duration){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle(){
        return title;
    }

    public void b(){
       System.out.println(id + " " + title + " " + artist + " " + genre + " " + duration);
    }
}