package com.facebook.react.common;

public class LongArray {
    private static final double INNER_ARRAY_GROWTH_FACTOR = 1.8d;
    private long[] mArray;
    private int mLength = 0;

    public static LongArray createWithInitialCapacity(int i) {
        return new LongArray(i);
    }

    private LongArray(int i) {
        this.mArray = new long[i];
    }

    public void add(long j) {
        growArrayIfNeeded();
        long[] jArr = this.mArray;
        int i = this.mLength;
        this.mLength = i + 1;
        jArr[i] = j;
    }

    public long get(int i) {
        if (i < this.mLength) {
            return this.mArray[i];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(i);
        stringBuilder.append(" >= ");
        stringBuilder.append(this.mLength);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public void set(int i, long j) {
        if (i < this.mLength) {
            this.mArray[i] = j;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(i);
        stringBuilder.append(" >= ");
        stringBuilder.append(this.mLength);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int size() {
        return this.mLength;
    }

    public boolean isEmpty() {
        return this.mLength == 0;
    }

    public void dropTail(int i) {
        if (i <= this.mLength) {
            this.mLength -= i;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to drop ");
        stringBuilder.append(i);
        stringBuilder.append(" items from array of length ");
        stringBuilder.append(this.mLength);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    private void growArrayIfNeeded() {
        if (this.mLength == this.mArray.length) {
            Object obj = new long[Math.max(this.mLength + 1, (int) (((double) this.mLength) * INNER_ARRAY_GROWTH_FACTOR))];
            System.arraycopy(this.mArray, 0, obj, 0, this.mLength);
            this.mArray = obj;
        }
    }
}
