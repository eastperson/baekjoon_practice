package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DFS와 BFS
 *
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다.
 * 정점 번호는 1번부터 N번까지이다.
 *
 */

public class Problem1260 {

        //함수에서 사용할 변수들
        static int[][] check; //간선 연결상태

        // 확인여부는 배열로 사용한다.
        static boolean[] checked; //확인 여부
        static int n; //정점개수
        static int m; //간선개수
        static int start; //시작정점

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        check = new int[1001][1001];
        checked = new boolean[1001];


        for(int i = 0; i < m; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 해당 간선이 있으면 1을 대입한다.
            check[x][y] = check[y][x] = 1;
        }

        dfs(start); //dfs호출

        checked = new boolean[1001]; //확인상태 초기화
        System.out.println(); //줄바꿈

        bfs(); //bfs호출


    }

    //시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
    // 재귀호출을 함수 콜 스택으로 이해할 수 있다.
    public static void dfs(int i) {
        // 방문을 함과 동시에 출력
        checked[i] = true;
        System.out.print(i + " ");

        // 시작하는 정점(i)을 기준으로 연결되어있는 정점을 조회한다.
        for(int j = 1; j <= n; j++) {
            // 간선이 있고, 방문하지 않았으면 dfs 실
            if(check[i][j] == 1 && checked[j] == false) {
                // 간선으로 연결되어 있는 정점이 있으면 콜스택
                dfs(j);
            }
        }
    }


    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start); //시작점도 Queue에 넣어야 함
        checked[start] = true;
        System.out.print(start + " ");

        //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int j = 1; j <= n; j++) {
                if (check[temp][j] == 1 && checked[j] == false) {
                    queue.offer(j);
                    checked[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
