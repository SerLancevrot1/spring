package org.example;

public class MusicPlayer {
     private Music music;

     public  MusicPlayer(Music music){
         this.music = music;
     }

     public void platMusic(){
         System.out.printf("Play- " + music.getSong() );
         //asd
     }
}
