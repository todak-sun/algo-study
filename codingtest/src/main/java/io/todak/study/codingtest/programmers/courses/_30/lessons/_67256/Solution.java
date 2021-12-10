package io.todak.study.codingtest.programmers.courses._30.lessons._67256;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Solution {

        Set<Keypad> LSet = Set.of(Keypad.ONE, Keypad.FOUR, Keypad.SEVEN);
        Set<Keypad> RSet = Set.of(Keypad.THREE, Keypad.SIX, Keypad.NINE);

        public String solution(int[] numbers, String hand) {

            List<String> result = new ArrayList<>();
            Finger fingerL = new Finger("L", Keypad.STAR);
            Finger fingerR = new Finger("R", Keypad.SHARP);
            Finger fingerFromHand = "left".equals(hand) ? fingerL : fingerR;

            for (int num : numbers) {
                Keypad currentKeypad = Keypad.ofNumber(num);
                System.out.println(currentKeypad);
                if (LSet.contains(currentKeypad)) {
                    result.add(fingerL.getString());
                    fingerL.setKeypad(currentKeypad);
                } else if (RSet.contains(currentKeypad)) {
                    result.add(fingerR.getString());
                    fingerR.setKeypad(currentKeypad);
                } else {
                    double distanceL = fingerL.distanceFrom(currentKeypad);
                    double distanceR = fingerR.distanceFrom(currentKeypad);

                    Finger selectedFinger = distanceL < distanceR ? fingerL
                            : distanceR < distanceL ? fingerR
                            : fingerFromHand;
                    System.out.println("distanceL : " + distanceL + ", distanceR : " + distanceR + ", selectedFinger : " + selectedFinger.getString());
                    result.add(selectedFinger.getString());
                    selectedFinger.setKeypad(currentKeypad);
                }
            }
            return String.join("", result);
        }
    }