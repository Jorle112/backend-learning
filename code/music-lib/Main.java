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

        Scanner sc = new Scanner(System.in,"GBK");
        while(true){
            System.out.println( "===== 音乐库菜单 =====" );
            System.out.println( "1. 查看全部歌曲" );
            System.out.println( "2. 按歌名查找" );
            System.out.println( "3. 删除歌曲" );
            System.out.println( "4. 已收藏歌曲" );
            System.out.println( "5. 收藏切换" );
            System.out.println( "0. 退出" );
            System.out.print( "请选择：" );

            String choice = sc.nextLine();
            
            if(choice.equals("1")){
                for(Song song : songs){
                    song.b();
                }
            }else if(choice.equals("2")){
                System.out.println("请输入要查找的歌曲：");
                String target = sc.nextLine();
                boolean found = false;
                for(Song song : songs){
                    if(song.getTitle().equals(target)){
                        song.b();
                        found = true;
                    }
                }
                if(found != true){
                    System.out.println( "未找到歌曲" );
                }
            }else if(choice.equals("3")){
                System.out.println("请输入要删除的歌名：");
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
                }
            }else if(choice.equals("4")){
                int favCount = 0;

                for(Song song : songs){
                    if(song.isFavorite()){
                        song.b();
                        favCount++;
                    }
                }
                System.out.println("收藏歌曲数"+favCount);
            }else if(choice.equals("5")){
                System.out.println("请输入要切换收藏的歌名：");
                String target = sc.nextLine();
                boolean found = false;
                for(Song song : songs){
                    if(song.getTitle().equals(target)){
                        found = true;
                        song.setFavorite(!song.isFavorite());
                        System.out.println("已切换收藏状态");
                    }
                }
                if(!found){
                        System.out.println("未找到歌曲");
                }
            }else if(choice.equals("0")){
                break;
            }else{
                System.out.println( "无效选项，请重新输入" );
            }
        }
        sc.close();
    }   
}
