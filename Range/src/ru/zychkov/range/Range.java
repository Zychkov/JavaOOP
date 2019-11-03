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

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double point) {
        return point >= from && point <= to;
    }

    public Range getIntersection(Range range) {
        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);

        if (maxFrom >= minTo) {
            return null;
        }

        return new Range(maxFrom, minTo);
    }

    public Range[] getUnion(Range range) {
        double minFrom = Math.min(from, range.from);
        double maxFrom = Math.max(from, range.from);
        double minTo = Math.min(to, range.to);
        double maxTo = Math.max(to, range.to);

        if (minTo >= maxFrom) {
            return new Range[]{new Range(minFrom, maxTo)};
        }

        return new Range[]{new Range(minFrom, minTo), new Range(maxFrom, maxTo)};
    }

    public Range[] getDifference(Range range) {
        if (range.from <= from && to <= range.to) {
            return new Range[]{};
        }

        if (to <= range.from || from >= range.to) {
            return new Range[]{new Range(from, to)};
        }

        if (range.from <= to && range.to >= to) {
            return new Range[]{new Range(from, range.from)};
        }

        if (from >= range.from && range.to <= to) {
            return new Range[]{new Range(range.to, to)};
        }

        return new Range[]{(new Range(from, range.from)), new Range(range.to, to)};
    }
}