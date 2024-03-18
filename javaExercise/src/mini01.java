import java.util.Scanner;

// 미니 프로젝트 1: 캐릭터 움직이기
public class mini01 {
    public static void main(String[] args) {
        gameStart();
    }

    static int[][] map = {
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 1, 0, 0, 3, 1},
            {1, 0, 1, 0, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1},
    };

    static void makeMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    System.out.print("■ ");
                } else if (map[i][j] == 2) {
                    System.out.print("● ");
                } else if (map[i][j] == 3) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static boolean checkGoal(int x, int y) {
        boolean game;

        if (map[x][y] == 3) {
            map[x][y] = 0;
            System.out.println("GOAL IN!!!");
            makeMap(map);
            game = false;
        } else {
            game = true;
            map[x][y] = 2;
            makeMap(map);
        }
        return game;
    }

    static void gameStart() {
        Scanner scanner = new Scanner(System.in);

        // 시작 위치
        int x = 1;
        int y = 1;
        boolean game = true;

        // 시작 map 출력
        makeMap(map);

        while (game) {
            System.out.print("이동 방향을 입력해주세요. (a: 좌, d: 우, w: 위, s: 아래): ");
            String input = scanner.nextLine();

            if (input.equals("a")) {
                map[x][y] = 0;
                y -= 1;
                game = checkGoal(x, y);
                map[x][y] = 2;
            } else if (input.equals("d")) {
                map[x][y] = 0;
                y += 1;
                game = checkGoal(x, y);
                map[x][y] = 2;
            } else if (input.equals("w")) {
                map[x][y] = 0;
                x -= 1;
                game = checkGoal(x, y);
                map[x][y] = 2;
            } else if (input.equals("s")) {
                map[x][y] = 0;
                x += 1;
                game = checkGoal(x, y);
                map[x][y] = 2;
            }

            if (game == true) makeMap(map);
        }
        scanner.close();
    }
}
