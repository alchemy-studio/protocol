package io.alchemystudio.protocol;

public class Time {

    private long val;

    public long getVal() {
        return val;
    }

    public void setVal(long val) {
        this.val = val;
    }

    public static long now() {
        return System.currentTimeMillis();
    }
}
