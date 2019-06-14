package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

final class mo {
    /* renamed from: a */
    long f15810a;
    /* renamed from: b */
    final String f15811b;
    /* renamed from: c */
    final String f15812c;
    /* renamed from: d */
    final long f15813d;
    /* renamed from: e */
    final long f15814e;
    /* renamed from: f */
    final long f15815f;
    /* renamed from: g */
    final long f15816g;
    /* renamed from: h */
    final List<aqg> f15817h;

    mo(String str, agz agz) {
        List list;
        agz agz2 = agz;
        String str2 = agz2.f14506b;
        long j = agz2.f14507c;
        long j2 = agz2.f14508d;
        long j3 = agz2.f14509e;
        long j4 = agz2.f14510f;
        if (agz2.f14512h != null) {
            list = agz2.f14512h;
        } else {
            Map map = agz2.f14511g;
            List arrayList = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                arrayList.add(new aqg((String) entry.getKey(), (String) entry.getValue()));
            }
            list = arrayList;
        }
        this(str, str2, j, j2, j3, j4, list);
        this.f15810a = (long) agz2.f14505a.length;
    }

    private mo(String str, String str2, long j, long j2, long j3, long j4, List<aqg> list) {
        this.f15811b = str;
        if ("".equals(str2)) {
            str2 = null;
        }
        this.f15812c = str2;
        this.f15813d = j;
        this.f15814e = j2;
        this.f15815f = j3;
        this.f15816g = j4;
        this.f15817h = list;
    }

    /* renamed from: a */
    static mo m19912a(np npVar) {
        if (ln.m30877a((InputStream) npVar) == 538247942) {
            return new mo(ln.m30879a(npVar), ln.m30879a(npVar), ln.m30885b((InputStream) npVar), ln.m30885b((InputStream) npVar), ln.m30885b((InputStream) npVar), ln.m30885b((InputStream) npVar), ln.m30886b(npVar));
        }
        throw new IOException();
    }

    /* renamed from: a */
    final boolean m19913a(OutputStream outputStream) {
        try {
            ln.m30880a(outputStream, 538247942);
            ln.m30882a(outputStream, this.f15811b);
            ln.m30882a(outputStream, this.f15812c == null ? "" : this.f15812c);
            ln.m30881a(outputStream, this.f15813d);
            ln.m30881a(outputStream, this.f15814e);
            ln.m30881a(outputStream, this.f15815f);
            ln.m30881a(outputStream, this.f15816g);
            List<aqg> list = this.f15817h;
            if (list != null) {
                ln.m30880a(outputStream, list.size());
                for (aqg aqg : list) {
                    ln.m30882a(outputStream, aqg.m18748a());
                    ln.m30882a(outputStream, aqg.m18749b());
                }
            } else {
                ln.m30880a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            eg.m19390b("%s", e.toString());
            return false;
        }
    }
}
