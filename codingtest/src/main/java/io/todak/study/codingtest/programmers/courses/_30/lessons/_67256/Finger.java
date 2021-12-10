package io.todak.study.codingtest.programmers.courses._30.lessons._67256;

class Finger {
        private final String string;
        private Keypad keypad;

        public Finger(String string, Keypad keypad) {
            this.string = string;
            this.keypad = keypad;
        }

        public void setKeypad(Keypad keypad) {
            this.keypad = keypad;
        }

        public String getString() {
            return string;
        }

        public double distanceFrom(Keypad keypad) {
            return this.keypad.getPosition().distanceFrom(keypad.getPosition());
        }
    }