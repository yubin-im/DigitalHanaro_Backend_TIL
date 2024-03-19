import java.util.Random;
import java.util.Scanner;

// 미니 프로젝트 2: 지뢰찾기 게임
public class mini02 {
    public static void main(String[] args) {
        makeMap();
    }

    static void makeMap() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("가로열 개수: ");
        int width = scanner.nextInt();
        System.out.print("세로열 개수: ");
        int length = scanner.nextInt();

        // 맵 생성 및 초기화
        int[][] map = new int[width][length];
        int landmine = (width / 10) * 10;  // 지뢰 개수

        // 랜덤 위치에 20개 지뢰 배치
        for (int i = 0; i < landmine; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(length);

            // 지뢰 위치는 -1로 지정
            if (map[x][y] != -1) {
                map[x][y] = -1;
            } else {
                i--;
            }
        }

        // 나머지 칸에 0부터 5까지의 랜덤 값 할당
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != -1) {
                    map[i][j] = random.nextInt(6);
                }
            }
        }

        // 맵 출력
        for (int[] row : map) {
            for (int cell : row) {
                if (cell == -1) {
                    System.out.print("* ");
                } else {
                    System.out.print(cell + " ");
                }
            }
            System.out.println();
        }
    }
}
