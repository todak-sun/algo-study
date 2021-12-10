package io.todak.study.codingtest.programmers.courses._30.lessons._67256;

import java.util.Arrays;

enum Keypad {

        ONE("1", new Position(0, 0)),
        TWO("2", new Position(1, 0)),
        THREE("3", new Position(2, 0)),
        FOUR("4", new Position(0, 1)),
        FIVE("5", new Position(1, 1)),
        SIX("6", new Position(2, 1)),
        SEVEN("7", new Position(0, 2)),
        EIGHT("8", new Position(1, 2)),
        NINE("9", new Position(2, 2)),
        STAR("*", new Position(0, 3)),
        ZERO("0", new Position(1, 3)),
        SHARP("#", new Position(2, 3));

        private final String number;
        private final Position position;

        Keypad(String number, Position position) {
            this.number = number;
            this.position = position;
        }

        public Position getPosition() {
            return position;
        }

        public static Keypad ofNumber(String number) {
            return Arrays.stream(values()).filter(keypad -> keypad.number.equals(number))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
        }

        public static Keypad ofNumber(int number) {
            return Keypad.ofNumber(String.valueOf(number));
        }

    }