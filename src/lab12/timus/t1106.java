package lab12.timus;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://acm.timus.ru/problem.aspx?space=1&num=1106">1106. Две команды</a>
 */
public class t1106 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);

    static List<Integer>[] friends;
    static int[] teamColor;

    public static void main(String[] args) {
        try {
            run();
        } finally {
            in.close();
            out.flush();
        }
    }

    static void run() {
        int peopleCount = in.nextInt();
        friends = new ArrayList[peopleCount];

        for (int i = 0; i < peopleCount; i++) {
            friends[i] = new ArrayList<>();
        }

        for (int person = 0; person < peopleCount; person++) {
            while (true) {
                int friend = in.nextInt();
                if (friend == 0) break;
                friends[person].add(friend - 1);
            }
        }

        teamColor = new int[peopleCount];
        Arrays.fill(teamColor, -1);

        for (int person = 0; person < peopleCount; person++) {
            if (teamColor[person] == -1) {
                dfs(person, 0);
            }
        }

        List<Integer> firstTeam = new ArrayList<>();
        for (int person = 0; person < peopleCount; person++) {
            if (teamColor[person] == 0) {
                firstTeam.add(person + 1);
            }
        }

        if (firstTeam.isEmpty() || firstTeam.size() == peopleCount) {
            System.out.println(0);
            return;
        }

        System.out.println(firstTeam.size());
        for (int person : firstTeam) {
            System.out.print(person + " ");
        }
    }

    static void dfs(int person, int color) {
        teamColor[person] = color;

        for (int friend : friends[person]) {
            if (teamColor[friend] == -1) {
                dfs(friend, color ^ 1);
            }
        }
    }
}
