package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.common.internal.VisibleForTesting;

public class ScoreBasedEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {
    private final float mAgeWeight;
    private final float mSizeWeight;

    /* renamed from: com.facebook.cache.disk.ScoreBasedEvictionComparatorSupplier$1 */
    class C37141 implements EntryEvictionComparator {
        long now = System.currentTimeMillis();

        C37141() {
        }

        public int compare(Entry entry, Entry entry2) {
            entry = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry, this.now);
            entry2 = ScoreBasedEvictionComparatorSupplier.this.calculateScore(entry2, this.now);
            if (entry < entry2) {
                return 1;
            }
            return entry2 == entry ? null : -1;
        }
    }

    public ScoreBasedEvictionComparatorSupplier(float f, float f2) {
        this.mAgeWeight = f;
        this.mSizeWeight = f2;
    }

    public EntryEvictionComparator get() {
        return new C37141();
    }

    @VisibleForTesting
    float calculateScore(Entry entry, long j) {
        return (this.mAgeWeight * ((float) (j - entry.getTimestamp()))) + (this.mSizeWeight * ((float) entry.getSize()));
    }
}
