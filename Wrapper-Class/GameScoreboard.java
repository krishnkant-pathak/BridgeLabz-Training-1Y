public class GameScoreboard {
    public static void main(String[] args) {
        Integer[] scores = {10, null, 20, null};

        int notPlayed = 0, total = 0;

        for (Integer s : scores) {
            if (s == null) notPlayed++;
            else total += s;
        }

        System.out.println("Not played: " + notPlayed);
        System.out.println("Total score: " + total);
    }
}