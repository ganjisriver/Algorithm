# [Level.2] 게임 맵 최단거리

## 문제 유형
- BFS

## 문제 링크
https://school.programmers.co.kr/learn/courses/30/lessons/1829

## 고민 사항 및 알게된 점, 느낀 점
- dfs 사용할 때와, bfs 사용할 때를 효율성 측면에서 잘 구분하자.
- bfs를 사용할 때, visited를 boolean배열로 활용할 경우 visited가 겹칠 수 있기 때문에 최단 경로를 구할 때는 int배열로 기록하는 방식으로 갑시다.
- 그리고 queue에 넣을 때 visited를 할지 말지 잘 결정해야한다.

https://school.programmers.co.kr/questions/51849

