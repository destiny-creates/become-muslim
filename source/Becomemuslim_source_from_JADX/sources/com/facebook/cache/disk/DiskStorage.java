package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.WriterCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DiskStorage {

    public static class DiskDumpInfo {
        public List<DiskDumpInfoEntry> entries = new ArrayList();
        public Map<String, Integer> typeCounts = new HashMap();
    }

    public static class DiskDumpInfoEntry {
        public final String firstBits;
        public final String path;
        public final float size;
        public final String type;

        protected DiskDumpInfoEntry(String str, String str2, float f, String str3) {
            this.path = str;
            this.type = str2;
            this.size = f;
            this.firstBits = str3;
        }
    }

    public interface Entry {
        String getId();

        BinaryResource getResource();

        long getSize();

        long getTimestamp();
    }

    public interface Inserter {
        boolean cleanUp();

        BinaryResource commit(Object obj);

        void writeData(WriterCallback writerCallback, Object obj);
    }

    void clearAll();

    boolean contains(String str, Object obj);

    DiskDumpInfo getDumpInfo();

    Collection<Entry> getEntries();

    BinaryResource getResource(String str, Object obj);

    String getStorageName();

    Inserter insert(String str, Object obj);

    boolean isEnabled();

    boolean isExternal();

    void purgeUnexpectedResources();

    long remove(Entry entry);

    long remove(String str);

    boolean touch(String str, Object obj);
}
