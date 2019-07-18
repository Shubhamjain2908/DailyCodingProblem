/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DCP_2;

/**
 * Facebook
 *
 * @author SHUBHAM In chess, the Elo rating system is used to calculate player
 * strengths based on game results. A simplified description of the Elo system
 * is as follows. Every player begins at the same score. For each subsequent
 * game, the loser transfers some points to the winner, where the amount of
 * points transferred depends on how unlikely the win is. For example, a
 * 1200-ranked player should gain much more points for beating a 2000-ranked
 * player than for beating a 1300-ranked player. Implement this system.
 */
public class P328_EloSystemChess {

    private static final int K = 40;
    
    public static void main(String[] args) {
        Player p1 = new Player("Shubham", 2000);
        Player p2 = new Player("Harsh", 1200);
        PlayerDTO p = new PlayerDTO(p1, p2, 1);
        PlayerDTO updatedRating = getUpdatedPlayers(p);
        System.out.println(updatedRating);
    }
    
    private static PlayerDTO getUpdatedPlayers(PlayerDTO p) {
        double player1Rating = p.player1.rating;
        double player2Rating = p.player2.rating;
        int winner = p.winner;
        double diff = getRatingDiff(player1Rating, player2Rating, winner);
        if (winner == 1) {
            player1Rating = player1Rating + diff;
            player2Rating = player2Rating - diff;
        } else if(winner == 2) {
            player2Rating = player2Rating + diff;
            player1Rating = player1Rating - diff;
        }
        p.player1.rating = player1Rating;
        p.player2.rating = player2Rating;
        return p;
    }
    
    private static double getRatingDiff(double r1, double r2, int player) {
        double prob = 0;
        if (player == 1) {
            prob = getProbability(r1, r2);
        } else if(player == 2){
            prob = getProbability(r2, r1);
        }
        return K * (1 - prob);
    }
    
    private static double getProbability(double r1, double r2) {
        return (double) Math.round((1.0 / (1.0 + Math.pow(10, (r1-r2)/400))) * 100) / 100;
    }
    
    static class Player {
        String name;
        double rating;
        public Player(String name, double rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "Player{" + "name=" + name + ", rating=" + rating + '}';
        }
        
    }
    static class PlayerDTO {
        Player player1;
        Player player2;
        int winner;

        public PlayerDTO(Player player1, Player player2, int winner) {
            this.player1 = player1;
            this.player2 = player2;
            this.winner = winner;
        }

        @Override
        public String toString() {
            return "PlayerDTO{" + "player1=" + player1 + ", player2=" + player2 + ", winner=" + winner + '}';
        }
        
    }
}
