package io.todak.study.codingtest.programmers.courses._30.lessons._1829;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    static class Pixel {
        private final int x;
        private final int y;
        private final int color;

        public int getColor() {
            return color;
        }

        public Pixel(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public boolean isLinkable(Pixel other) {
            return Math.abs(this.x - other.x) + Math.abs(this.y - other.y) <= 1;
        }
    }

    static class AreaGroup {
        private final Map<Integer, Area> group;
        private int groupIndex;

        public AreaGroup(Pixel pixel) {
            this.group = new HashMap<>();
            this.groupIndex = 0;
            this.push(pixel);
        }

        public void push(Pixel pixel) {
            if (group.isEmpty()) {
                this.group.put(this.groupIndex++, new Area(pixel));
            } else {
                this.group.values().stream()
                        .filter(area -> area.linkable(pixel))
                        .findFirst()
                        .ifPresentOrElse(
                                (area) -> area.push(pixel),
                                () -> this.group.put(this.groupIndex++, new Area(pixel)));
            }
        }

        public List<Area> getArea() {
            return new ArrayList<>(this.group.values());
        }

        @Override
        public String toString() {
            return "AreaGroup{" +
                    "group=" + group +
                    ", groupIndex=" + groupIndex +
                    '}';
        }
    }

    static class Area {
        private final List<Pixel> pixels;

        public int getSize() {
            return this.pixels.size();
        }

        public Area(Pixel pixel) {
            this.pixels = new ArrayList<>();
            this.pixels.add(pixel);
        }

        public boolean linkable(Pixel pixel) {
            return this.pixels.stream()
                    .anyMatch(member -> member.isLinkable(pixel));
        }

        public void push(Pixel pixel) {
            this.pixels.add(pixel);
        }

    }

    static class Canvas {
        private final int height;
        private final int width;
        private final Map<Integer, AreaGroup> areas;

        public Canvas(int height, int width) {
            this.height = height;
            this.width = width;
            this.areas = new HashMap<>();
        }

        public void setPixels(int[][] picture) {
            for (int i = 0; i < picture.length; i++) {
                for (int j = 0; j < picture[i].length; j++) {
                    if (picture[i][j] != 0) {
                        this.pushToArea(new Pixel(j, i, picture[i][j]));
                    }
                }
            }
        }

        private void pushToArea(Pixel pixel) {
            if (this.areas.containsKey(pixel.getColor())) {
                AreaGroup areaGroup = this.areas.get(pixel.getColor());
                areaGroup.push(pixel);
            } else {
                this.areas.put(pixel.getColor(), new AreaGroup(pixel));
            }
            System.out.println(areas);
        }

        public List<Area> getAreas() {
            return this.areas.values()
                    .stream()
                    .flatMap(group -> group.getArea().stream())
                    .collect(Collectors.toList());
        }
    }


    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        Canvas canvas = new Canvas(m, n);
        canvas.setPixels(picture);
        List<Area> areas = canvas.getAreas();

        numberOfArea = areas.size();
        maxSizeOfOneArea = areas.stream().mapToInt(Area::getSize).max().orElse(0);

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}