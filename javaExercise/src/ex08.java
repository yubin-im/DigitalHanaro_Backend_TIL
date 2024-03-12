import java.util.Arrays;
import java.util.stream.Stream;

// 8번 문제: 자리 배치
public class ex08 {
    public static void main(String[] args) {
        String data = "9 6 160 165 164 165 150 165 168 145 170";
        int[] dataArr = Stream.of(data.split(" ")).mapToInt(Integer::parseInt).toArray();

        // 학생들의 키만 분리 후 오름차순 정렬
        int[] heightArr = Arrays.copyOfRange(dataArr, 2, dataArr.length);
        Arrays.sort(heightArr);

        int row = (int) Math.ceil((double) dataArr[0] / dataArr[1]);  // 행
        int[][] seat = new int[row][dataArr[1]];

        int index = 0;  // heightArr 값을 가져올 인덱스

        // 자리배치
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (index < heightArr.length) {
                    seat[i][j] = heightArr[index];
                    index++;
                    System.out.print(seat[i][j] + " ");
                } else {
                    System.out.println("  ");
                }
            }
            System.out.println();
        }
    }
}
