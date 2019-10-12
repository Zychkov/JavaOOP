package ru.zychkov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String toString() {
        return "{" + from + ", " + to + "}";
    }

    /*
    public double getLength() {
        return to - from;
    }

    public boolean isInside(double point) {
        return point >= from && point <= to;
    }
    */

    public Range getIntersection(double from1, double to1, double from2, double to2) {
        if (Math.max(from1, from2) > Math.min(to1, to2)) {
            return null;
        } else {
            return new Range(Math.max(from1, from2), Math.min(to1, to2));
        }
    }

    public Range[] getUnion(double from1, double to1, double from2, double to2) {
        if (Math.min(to1, to2) >= Math.max(from1, from2)) {
            return new Range[]{new Range(Math.min(from1, from2), Math.max(to1, to2))};
        } else {
            return new Range[]{new Range(Math.min(from1, from2), Math.min(to1, to2)), (new Range(Math.max(from1, from2), Math.max(to1, to2)))};
        }
    }

    public Range[] getDifference(double from1, double to1, double from2, double to2) {
        if (from2 <= from1 && to1 <= to2) {
            return new Range[]{};
        } else if (to1 <= from2 || from1 >= to2) {
            return new Range[]{new Range(from1, to1)};
        } else if (from2 <= to1 && to2 >= to1) {
            return new Range[]{new Range(from1, from2)};
        } else if (from1 >= from2 && to2 <= to1) {
            return new Range[]{new Range(to2, to1)};
        } else {
            return new Range[]{(new Range(from1, from2)), new Range(to2, to1)};
        }
    }
}