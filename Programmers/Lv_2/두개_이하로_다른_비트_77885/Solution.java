package Programmers.Lv_2.두개_이하로_다른_비트_77885;

public class Solution {
    // 규칙성을 찾아서 정답 구하는 방식으로 시간 초과 방지함.
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int idx = 0;

        for(long number :numbers) {
            for(long i=1;;i<<=1)
                // i는 비트의 자리수
                // number가 0인 자리수를 찾게 된다면
                if((number&i)==0) {
                    // 0이었던 부분은 1로 바꾼다.
                    number |= i;
                    // XOR 연산을 활용해서 i의 뒷자리를 0으로 바꾼다.
                    number^=(i>>1);
                    break;
                }
            answer[idx++]=number;
        }
        return answer;
    }


    // 10번과 11번에서 시간 초과나는 답안
    // 단순히 1씩 늘려서 체크하는 것이 아닌 규칙성을 찾아서 효율성을 고려해야할 듯
    class TimeOverSolution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            int size = numbers.length;
            for (int idx = 0; idx < size; idx++) {
                long number = numbers[idx];
                long candidate = number+1;
                while(true) {
                    if(check(number, candidate)) {
                        answer[idx] = candidate;
                        break;
                    }
                    candidate++;
                }

            }
            return answer;
        }

        private boolean check(long number, long candidate) {
            String numberBinary = Long.toBinaryString(number);
            String candidateBinary = Long.toBinaryString(candidate);

            int numberSize = numberBinary.length();
            int candidateSize = candidateBinary.length();

            int count = 0;
            for (int idx = 1; idx <= candidateSize; idx++) {
                char numberValue = numberSize-idx >= 0 ? numberBinary.charAt(numberSize-idx) : '0';
                char candidateValue = candidateBinary.charAt(candidateSize-idx);
                if (numberValue != candidateValue) {
                    count++;
                }
                if (count > 2) {
                    return false;
                }
            }
            return true;
        }
    }
}

