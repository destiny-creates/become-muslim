package com.facebook.react.devsupport;

import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.util.HashMap;
import java.util.Map;

public class MultipartStreamReader {
    private static final String CRLF = "\r\n";
    private final String mBoundary;
    private long mLastProgressEvent;
    private final C7497e mSource;

    public interface ChunkListener {
        void onChunkComplete(Map<String, String> map, C8170c c8170c, boolean z);

        void onChunkProgress(Map<String, String> map, long j, long j2);
    }

    public MultipartStreamReader(C7497e c7497e, String str) {
        this.mSource = c7497e;
        this.mBoundary = str;
    }

    private Map<String, String> parseHeaders(C8170c c8170c) {
        Map<String, String> hashMap = new HashMap();
        for (String str : c8170c.r().split(CRLF)) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
            }
        }
        return hashMap;
    }

    private void emitChunk(C8170c c8170c, boolean z, ChunkListener chunkListener) {
        C6251f a = C6251f.a("\r\n\r\n");
        long b = c8170c.b(a);
        if (b == -1) {
            chunkListener.onChunkComplete(null, c8170c, z);
            return;
        }
        C8170c c8170c2 = new C8170c();
        Object c8170c3 = new C8170c();
        c8170c.read(c8170c2, b);
        c8170c.h((long) a.h());
        c8170c.a(c8170c3);
        chunkListener.onChunkComplete(parseHeaders(c8170c2), c8170c3, z);
    }

    private void emitProgress(Map<String, String> map, long j, boolean z, ChunkListener chunkListener) {
        if (map != null) {
            if (chunkListener != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mLastProgressEvent > 16 || z) {
                    this.mLastProgressEvent = currentTimeMillis;
                    chunkListener.onChunkProgress(map, j, map.get(HttpHeaders.CONTENT_LENGTH) ? Long.parseLong((String) map.get(HttpHeaders.CONTENT_LENGTH)) : 0);
                }
            }
        }
    }

    public boolean readAllParts(ChunkListener chunkListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\r\n--");
        stringBuilder.append(this.mBoundary);
        stringBuilder.append(CRLF);
        C6251f a = C6251f.a(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("\r\n--");
        stringBuilder.append(this.mBoundary);
        stringBuilder.append("--");
        stringBuilder.append(CRLF);
        C6251f a2 = C6251f.a(stringBuilder.toString());
        C6251f a3 = C6251f.a("\r\n\r\n");
        C8170c c8170c = new C8170c();
        long j = 0;
        long j2 = j;
        long j3 = j2;
        Map map = null;
        while (true) {
            boolean z;
            long max = Math.max(j - ((long) a2.h()), j2);
            j = c8170c.a(a, max);
            if (j == -1) {
                j = c8170c.a(a2, max);
                z = true;
            } else {
                z = false;
            }
            if (j == -1) {
                long a4 = c8170c.a();
                if (map == null) {
                    j = c8170c.a(a3, max);
                    if (j >= 0) {
                        r6.mSource.read(c8170c, j);
                        C8170c c8170c2 = new C8170c();
                        c8170c.a(c8170c2, max, j - max);
                        j3 = c8170c2.a() + ((long) a3.h());
                        map = parseHeaders(c8170c2);
                    }
                } else {
                    emitProgress(map, c8170c.a() - j3, false, chunkListener);
                }
                if (r6.mSource.read(c8170c, (long) 4096) <= 0) {
                    return false;
                }
                j = a4;
            } else {
                max = j - j2;
                if (j2 > 0) {
                    C8170c c8170c3 = new C8170c();
                    c8170c.h(j2);
                    c8170c.read(c8170c3, max);
                    C8170c c8170c4 = c8170c3;
                    emitProgress(map, c8170c3.a() - j3, true, chunkListener);
                    emitChunk(c8170c4, z, chunkListener);
                    j3 = 0;
                    map = null;
                } else {
                    ChunkListener chunkListener2 = chunkListener;
                    c8170c.h(j);
                }
                if (z) {
                    return true;
                }
                j2 = (long) a.h();
                j = j2;
            }
        }
    }
}
