import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Song s1 = new Song(1,"夜曲","周杰伦","流行",225);
        Song s2 = new Song(2,"pink+white","frankocean","R&B",255);
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        for(Song song : songs){
            song.b();
        }

        System.out.println("请输入要查找的歌名：");
        Scanner sc = new Scanner(System.in,"GBK");
        String target = sc.nextLine();
        

        for(Song song : songs){
            if(target.equals(song.getTitle())){
                song.b();
            }
        }
        sc.close();
    }   
}
