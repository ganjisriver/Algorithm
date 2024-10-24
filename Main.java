import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] dnaString = br.readLine().toCharArray();
        int[] checkArray = new int[4];
        st = new StringTokenizer(br.readLine());

        for (int index = 0; index < 4; index++) {
            checkArray[index] = Integer.parseInt(st.nextToken());
        }

        // Map을 통해 index와 character 연결
        Map<Character, Integer> indexMap = new HashMap<>();
        indexMap.put('A', 0);
        indexMap.put('C', 1);
        indexMap.put('G', 2);
        indexMap.put('T', 3);

        int[] currentArray = new int[4];
        Deque<Character> dq = new ArrayDeque<>(P);

        // 초기 슬라이딩 윈도우 설정
        for (int index = 0; index < P; index++) {
            char currentCharacter = dnaString[index];
            dq.addLast(currentCharacter);
            currentArray[indexMap.get(currentCharacter)] += 1;
        }

        if (check(checkArray, currentArray)) {
            answer++;
        }
        for (int index = P; index < S; index++) {
            // Deque에서 빼주고, 해당 부분을 currentArray에서 count제거
            char outCharacter = dq.pollFirst();
            currentArray[indexMap.get(outCharacter)] -= 1;
            char inCharacter = dnaString[index];
            dq.addLast(inCharacter);
            currentArray[indexMap.get(inCharacter)] += 1;
            if (check(checkArray, currentArray)) {
                answer++;
            }
        }
        System.out.println(answer);

    }
    public static boolean check(int[] checkArray, int[] currentArray) {
        for (int index = 0; index < 4; index++) {
            if (checkArray[index] > currentArray[index]) {
                return false;
            }
        }
        return true;
    }
}
