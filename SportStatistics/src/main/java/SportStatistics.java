
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {
    
    public static ArrayList<Game> recordGamesFromFile(String file){
        ArrayList<Game> games = new ArrayList<>();
        
        try(Scanner fileScanner = new Scanner(Paths.get(file))){
            while(fileScanner.hasNextLine()){
                String string = fileScanner.nextLine();
                
                String[] parts = string.split(",");
                String homeTeam = parts[0];
                String awayTeam = parts[1];
                int htScore = Integer.valueOf(parts[2]);
                int atScore = Integer.valueOf(parts[3]);
                
                games.add(new Game(homeTeam, awayTeam, htScore, atScore));
            }

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return games;
    }
     
    public static String lookForGamesPlayed(ArrayList<Game> games, String team){
        int gamesPlayed = 0;
        
        for(Game game : games){
            if(game.getHomeTeam().equals(team) || game.getAwayTeam().equals(team)){
                gamesPlayed++;
            }
        }
        
        return "Games: " + gamesPlayed;
    }
    
    public static String lookForWinsAndLosses(ArrayList<Game> games, String team){
        int wins = 0;
        int losses = 0;
        
        for(Game game : games){
            if(game.getHomeTeam().equals(team) && game.getHtScore() > game.getAtScore()){
                wins++;
            }
            if(game.getHomeTeam().equals(team) && game.getHtScore() < game.getAtScore()){
                losses++;
            }
            if(game.getAwayTeam().equals(team) && game.getHtScore() < game.getAtScore()){
                wins++;
            }
            if(game.getAwayTeam().equals(team) && game.getHtScore() > game.getAtScore()){
                losses++;
            }
        }
        String string = "Wins: " + wins + "\n" + "Losses: " + losses;
        return string;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("File: ");
        String file = scan.nextLine();
        
        ArrayList<Game> gameRecord = recordGamesFromFile(file);
        
        System.out.println("Team: ");
        String team = scan.nextLine();

        System.out.println(lookForGamesPlayed(gameRecord, team));
        System.out.println(lookForWinsAndLosses(gameRecord, team));

    }

}

   