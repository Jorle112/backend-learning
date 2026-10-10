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

        int favCount = 0;

        s1.setFavorite(true);
        for(Song song : songs){
            if(song.isFavorite()){
                song.b();
                favCount++;
            }
        }
        System.out.println("收藏歌曲数"+favCount);
        /* System.out.println("请输入要删除的歌名：");
        Scanner sc = new Scanner(System.in,"GBK");
        String target = sc.nextLine();
        
        int remove = -1;
        for(int i = 0;i < songs.size();i++){
            if(songs.get(i).getTitle().equals(target)){
                remove = i;
                break;
            }
        }
        
        if(remove == -1){
            System.out.println("未找到歌曲");
        }
        else{
            songs.remove(remove);
            System.out.println("已删除");
        }*/
        
    }   
}
