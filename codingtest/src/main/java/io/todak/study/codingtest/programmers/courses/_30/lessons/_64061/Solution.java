package io.todak.study.codingtest.programmers.courses._30.lessons._64061;


import java.util.*;

class Solution {

    static class CraneBoard {
        Map<Integer, Queue<Doll>> maps;

        public CraneBoard(int size) {
            this.maps = new HashMap<>();
            for (int i = 0; i < size; i++) {
                this.maps.put(i + 1, new LinkedList<>());
            }
        }

        public void addDolls(int[][] boards) {
            for (int[] board : boards) {
                for (int j = 0; j < board.length; j++) {
                    if (board[j] != 0) {
                        maps.get(j + 1).add(new Doll(board[j]));
                    }
                }
            }
        }

        public Optional<Doll> get(int lineNum) {
            Queue<Doll> line = this.maps.get(lineNum);
            if (line.isEmpty()) {
                return Optional.empty();
            } else {
                return Optional.ofNullable(line.poll());
            }
        }
    }

    static class PeekedBoard {
        private final Stack<Doll> dolls = new Stack<>();

        public int putOrRemove(Doll doll) {
            if (this.dolls.isEmpty()) {
                this.dolls.push(doll);
                return 0;
            }

            Doll top = this.dolls.peek();
            if (top.equals(doll)) {
                this.dolls.pop();
                return 2;
            }

            this.dolls.push(doll);
            return 0;
        }

    }


    static class Doll {
        private final int id;

        public Doll(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Doll{" +
                    "id=" + id +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Doll doll = (Doll) o;
            return id == doll.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public int solution(int[][] board, int[] moves) {
        CraneBoard craneBoard = new CraneBoard(board.length);
        craneBoard.addDolls(board);

        PeekedBoard peekedBoard = new PeekedBoard();
        return Arrays.stream(moves)
                .mapToObj(craneBoard::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .mapToInt(peekedBoard::putOrRemove)
                .sum();
    }

}
