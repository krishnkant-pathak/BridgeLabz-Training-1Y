import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw";
        }

        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {

        String[][] stats = new String[2][3];

        double userPercentage = (userWins * 100.0) / totalGames;
        double computerPercentage = (computerWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf(userPercentage);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(computerPercentage);

        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {

        System.out.println("Game\tUser\tComputer\tWinner");
        System.out.println("------------------------------------------------");

        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + "\t" +
                    gameResults[i][0] + "\t" +
                    gameResults[i][1] + "\t\t" +
                    gameResults[i][2]);
        }

        System.out.println("\nStatistics:");
        System.out.println("Player\tWins\tWin Percentage");
        System.out.println("-------------------------------------");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" +
                    stats[i][1] + "\t" +
                    stats[i][2] + "%");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] gameResults = new String[n][3];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < n; i++) {

            System.out.print("Enter your choice (Rock/Paper/Scissors): ");
            String userChoice = sc.nextLine();

            String computerChoice = getComputerChoice();

            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        String[][] stats = calculateStats(userWins, computerWins, n);

        displayResults(gameResults, stats);

        sc.close();
    }
}

