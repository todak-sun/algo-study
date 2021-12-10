package io.todak.study.codingtest.programmers.courses._30.lessons._64061;

public class App {

    public static void main(String[] args) {

        int solution = new Solution().solution(
                new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}
                },
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});

        System.out.println(solution);
    }
}
