package io.todak.study.codingtest.programmers.courses._30.lessons._67256;

class Position {
        private final double x;
        private final double y;

        public Position(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distanceFrom(Position other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
        }
    }