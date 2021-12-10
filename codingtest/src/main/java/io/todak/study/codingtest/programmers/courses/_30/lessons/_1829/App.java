package io.todak.study.codingtest.programmers.courses._30.lessons._1829;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {


//        int[] solution = new Solution().solution(6, 4, new int[][]{
//                {1, 1, 1, 0},
//                {1, 2, 2, 0},
//                {1, 0, 0, 1},
//                {0, 0, 0, 1},
//                {0, 0, 0, 3},
//                {0, 0, 0, 3}
//        });
//
//        System.out.println(Arrays.toString(solution));

        int[] solution1 = new Solution().solution(6, 4, new int[][]{
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        });
        System.out.println(Arrays.toString(solution1));

        System.out.println(Arrays.toString(
                new Solution().solution(3, 3, new int[][]{
                        {0, 1, 0},
                        {1, 1, 0},
                        {0, 0, 0}
                })
        ));



    }

}
