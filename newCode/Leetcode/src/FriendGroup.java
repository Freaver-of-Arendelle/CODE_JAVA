import org.junit.jupiter.api.Test;

/**
 * @author Freaver
 * @date 07/06/2021 23:39
 */
public class FriendGroup {


    public static void main(String[] args) {
        int[][] isConnected1 = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] isConnected2 = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        FriendGroup friendGroup = new FriendGroup();
        int circleNum1 = friendGroup.findCircleNum(isConnected1);
        System.out.println(circleNum1);
        int circleNum2 = friendGroup.findCircleNum(isConnected2);
        System.out.println(circleNum2);
    }

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int num = 0;
        int[] provinces = new int[len];
        for (int i = 0; i < len; i++) {
            provinces[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(provinces, i, j);
                }
            }
        }


        for (int i = 0; i < len; i++) {
            if (provinces[i] == i) {
                num++;
            }
        }
        return num;
    }

    public void union(int[] parents, int xi, int yi) {
        parents[find(yi, parents)] = find(xi, parents);
    }

    public int find(int c, int[] parents) {
        if (parents[c] == c) {
//            return find(parents[c], parents);
            return c;
        }

        return find(parents[c], parents);
    }
}
