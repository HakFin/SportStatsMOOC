/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabrijel
 */
public class Game {
    private String homeTeam;
    private String awayTeam;
    private int htScore;
    private int atScore;
    
    public Game(String homeTeam, String awayTeam, int htScore, int atScore){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.htScore = htScore;
        this.atScore = atScore;
    }
    
    public String getHomeTeam(){
        return homeTeam ;
    }
    
    public String getAwayTeam(){
        return awayTeam;
    }
    
    public int getHtScore(){
        return htScore;
    }
    
    public int getAtScore(){
        return atScore;
    }
}
