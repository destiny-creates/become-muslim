package com.facebook.react.uimanager.events;

import android.util.SparseIntArray;
import com.facebook.soloader.MinElf;

public class TouchEventCoalescingKeyHelper {
    private final SparseIntArray mDownTimeToCoalescingKey = new SparseIntArray();

    public void addCoalescingKey(long j) {
        this.mDownTimeToCoalescingKey.put((int) j, 0);
    }

    public void incrementCoalescingKey(long j) {
        j = (int) j;
        int i = this.mDownTimeToCoalescingKey.get(j, -1);
        if (i != -1) {
            this.mDownTimeToCoalescingKey.put(j, i + 1);
            return;
        }
        throw new RuntimeException("Tried to increment non-existent cookie");
    }

    public short getCoalescingKey(long j) {
        j = this.mDownTimeToCoalescingKey.get((int) j, -1);
        if (j != -1) {
            return (short) (j & MinElf.PN_XNUM);
        }
        throw new RuntimeException("Tried to get non-existent cookie");
    }

    public void removeCoalescingKey(long j) {
        this.mDownTimeToCoalescingKey.delete((int) j);
    }

    public boolean hasCoalescingKey(long j) {
        return this.mDownTimeToCoalescingKey.get((int) j, -1) == -1 ? 0 : 1;
    }
}
