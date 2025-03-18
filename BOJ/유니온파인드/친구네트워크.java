package BOJ.유니온파인드;

import java.io.*;
import java.util.*;

/**
 * 문제 친구 네트워크 인덱스가 아닌 문자열로 풀 수 있는 부분
 https://www.acmicpc.net/problem/4195
 */
class 친구네트워크 {
    static Map<String, Friend> friendsMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());
            friendsMap = new HashMap<>();
            for (int index = 0; index < F; index++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();
                Friend friend1 = getFriendByName(name1);
                Friend friend2 = getFriendByName(name2);
                union(friend1, friend2);
                sb.append(friend1.getParentFriendCnt()).append("\n");
            }
        }
        System.out.println(sb);
    }
    public static Friend getFriendByName(String name) {
        if (!friendsMap.containsKey(name)) {
            friendsMap.put(name, new Friend());
        }
        return friendsMap.get(name);
    }
    public static void union(Friend a, Friend b) {
        Friend aParent = a.find();
        Friend bParent = b.find();
        if (aParent != bParent) {
            bParent.parent = aParent;
            aParent.friendCnt += bParent.friendCnt;
        }
    }

}
class Friend {
    Friend parent;
    int friendCnt;

    public Friend() {
        this.parent = this;
        this.friendCnt = 1;
    }

    public Friend find() {
        if (this.parent != this) {
            this.parent = this.parent.find();
        }
        return this.parent;
    }
    public int getParentFriendCnt() {
        Friend parent1 = find();
        return parent1.friendCnt;
    }

}