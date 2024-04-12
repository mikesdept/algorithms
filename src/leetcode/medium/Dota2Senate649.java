package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate649 {

    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                rQueue.add(i);
            } else if (c == 'D') {
                dQueue.add(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();
            if (r < d) {
                rQueue.add(r + senate.length());
            } else {
                dQueue.add(d + senate.length());
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        Dota2Senate649 dota2Senate649 = new Dota2Senate649();
        System.out.println(dota2Senate649.predictPartyVictory("RD")); // Radiant
        System.out.println(dota2Senate649.predictPartyVictory("RDD")); // Dire
        System.out.println(dota2Senate649.predictPartyVictory("RDDRRRDDRDDDDRDR")); // Dire
    }
}
