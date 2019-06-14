package com.facebook.cache.disk;

import com.facebook.cache.disk.DiskStorage.Entry;

public class DefaultEntryEvictionComparatorSupplier implements EntryEvictionComparatorSupplier {

    /* renamed from: com.facebook.cache.disk.DefaultEntryEvictionComparatorSupplier$1 */
    class C37121 implements EntryEvictionComparator {
        C37121() {
        }

        public int compare(Entry entry, Entry entry2) {
            long timestamp = entry.getTimestamp();
            entry = entry2.getTimestamp();
            if (timestamp < entry) {
                return -1;
            }
            return entry == timestamp ? null : 1;
        }
    }

    public EntryEvictionComparator get() {
        return new C37121();
    }
}
