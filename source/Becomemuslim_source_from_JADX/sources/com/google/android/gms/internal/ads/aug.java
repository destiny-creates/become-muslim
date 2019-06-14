package com.google.android.gms.internal.ads;

import com.facebook.stetho.server.http.HttpStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public final class aug {
    /* renamed from: a */
    public final int f15004a;
    /* renamed from: b */
    public final byte[] f15005b;
    /* renamed from: c */
    public final Map<String, String> f15006c;
    /* renamed from: d */
    public final List<aqg> f15007d;
    /* renamed from: e */
    public final boolean f15008e;
    /* renamed from: f */
    private final long f15009f;

    private aug(int i, byte[] bArr, Map<String, String> map, List<aqg> list, boolean z, long j) {
        this.f15004a = i;
        this.f15005b = bArr;
        this.f15006c = map;
        this.f15007d = list == null ? null : Collections.unmodifiableList(list);
        this.f15008e = z;
        this.f15009f = j;
    }

    @Deprecated
    public aug(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        List list;
        if (map == null) {
            list = null;
        } else if (map.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList(map.size());
            for (Entry entry : map.entrySet()) {
                list.add(new aqg((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(i, bArr, map, list, z, j);
    }

    public aug(int i, byte[] bArr, boolean z, long j, List<aqg> list) {
        Map map;
        if (list == null) {
            map = null;
        } else if (list.isEmpty()) {
            map = Collections.emptyMap();
        } else {
            map = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (aqg aqg : list) {
                map.put(aqg.m18748a(), aqg.m18749b());
            }
        }
        this(i, bArr, map, list, z, j);
    }

    @Deprecated
    public aug(byte[] bArr, Map<String, String> map) {
        this((int) HttpStatus.HTTP_OK, bArr, (Map) map, false, 0);
    }
}
