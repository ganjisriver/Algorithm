package Programmers.Lv_2.k진수에서_소수_개수_구하기_92335;

class Solution {
    private int count;
    public int solution(int n, int k) {
        count = 0;
        execute(n, k);
        return count;
    }

    private void execute(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % k == 0) {
                sb = judgeCount(sb);
                n /= k;
                continue;
            }
            sb.append(n % k);
            n /= k;
        }
        judgeCount(sb);
    }

    private StringBuilder judgeCount(StringBuilder sb) {
        String str = sb.reverse().toString();

        if(str.length() > 0 && isPrime(Long.parseLong(str))) {
            count++;
        }
        return new StringBuilder();
    }

    private boolean isPrime(long candidate) {
        if (candidate == 1L) {
            return false;
        }
        if (candidate == 2L) {
            return true;
        }
        long sqrtNum = (long) Math.sqrt(candidate);
        for (long i = 2; i <= sqrtNum; i++) {
            if(candidate % i == 0) {
                return false;
            }
        }
        return true;
    }
}
