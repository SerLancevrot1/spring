package org.example;

import org.postgresql.jdbc.PgConnection;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Music music = context.getBean("musicBean" , Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(music);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.platMusic();



        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/books",
                    "postgres", "0000");

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from book");
            while (resultSet.next()){
                System.out.printf(resultSet.getString("title"));
            }
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        context.close();

    }
}
