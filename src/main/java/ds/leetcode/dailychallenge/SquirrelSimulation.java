package ds.leetcode.dailychallenge;

/**
 * There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid.
 * Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one.
 * The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell.
 * The distance is represented by the number of moves.
 * <p>
 * All given positions won't overlap.
 * The squirrel can take at most one nut at one time.
 * The given positions of nuts have no order.
 * Height and width are positive integers. 3 <= height * width <= 10,000.
 * The given positions contain at least one nut, only one tree and one squirrel.
 */

public class SquirrelSimulation {
    //构造最小求和数列的问题
    //dist1 = dist(squirrel, nut)
    //dist2 = dist(nut, tree)
    //total_dist2 = 2 * (dist2_1 + dist2_2 + ...)
    //dist = total_dist2 - (dist2 - dist1)
    //so find the largest dist2 - dist1

    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int value = height * width;
        if (nuts.length > 0) {
            int maxDiff = Integer.MIN_VALUE;
            int total = 0;
            for (int[] nut : nuts) {
                int dist1 = dist(squirrel, nut);
                int dist2 = dist(nut, tree);
                total += dist2 * 2;
                maxDiff = Math.max(maxDiff, dist2 - dist1);
            }
            value = total - maxDiff;
        }
        return value;
    }

    private int dist(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }

    public static void main(String[] args) {
        int height = 10;
        int width = 10;
        int[] tree = {2, 2};
        int[] squirrel = {4, 4};
        int[][] nuts = {{2, 3}, {2, 5}};
        new SquirrelSimulation().minDistance(height, width, tree, squirrel, nuts);
    }

}
