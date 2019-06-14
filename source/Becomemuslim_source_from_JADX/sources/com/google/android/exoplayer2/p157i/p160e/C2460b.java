package com.google.android.exoplayer2.p157i.p160e;

import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: TtmlNode */
/* renamed from: com.google.android.exoplayer2.i.e.b */
final class C2460b {
    /* renamed from: a */
    public final String f6222a;
    /* renamed from: b */
    public final String f6223b;
    /* renamed from: c */
    public final boolean f6224c;
    /* renamed from: d */
    public final long f6225d;
    /* renamed from: e */
    public final long f6226e;
    /* renamed from: f */
    public final C2463e f6227f;
    /* renamed from: g */
    public final String f6228g;
    /* renamed from: h */
    private final String[] f6229h;
    /* renamed from: i */
    private final HashMap<String, Integer> f6230i;
    /* renamed from: j */
    private final HashMap<String, Integer> f6231j;
    /* renamed from: k */
    private List<C2460b> f6232k;

    /* renamed from: a */
    public static C2460b m6792a(String str) {
        return new C2460b(null, C2462d.m6805a(str), -9223372036854775807L, -9223372036854775807L, null, null, "");
    }

    /* renamed from: a */
    public static C2460b m6793a(String str, long j, long j2, C2463e c2463e, String[] strArr, String str2) {
        return new C2460b(str, null, j, j2, c2463e, strArr, str2);
    }

    private C2460b(String str, String str2, long j, long j2, C2463e c2463e, String[] strArr, String str3) {
        this.f6222a = str;
        this.f6223b = str2;
        this.f6227f = c2463e;
        this.f6229h = strArr;
        this.f6224c = str2 != null ? true : null;
        this.f6225d = j;
        this.f6226e = j2;
        this.f6228g = (String) C2516a.m7015a((Object) str3);
        this.f6230i = new HashMap();
        this.f6231j = new HashMap();
    }

    /* renamed from: a */
    public boolean m6802a(long j) {
        return (!(this.f6225d == -9223372036854775807L && this.f6226e == -9223372036854775807L) && ((this.f6225d > j || this.f6226e != -9223372036854775807L) && ((this.f6225d != -9223372036854775807L || j >= this.f6226e) && (this.f6225d > j || j >= this.f6226e)))) ? 0 : 1;
    }

    /* renamed from: a */
    public void m6801a(C2460b c2460b) {
        if (this.f6232k == null) {
            this.f6232k = new ArrayList();
        }
        this.f6232k.add(c2460b);
    }

    /* renamed from: a */
    public C2460b m6799a(int i) {
        if (this.f6232k != null) {
            return (C2460b) this.f6232k.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: a */
    public int m6798a() {
        return this.f6232k == null ? 0 : this.f6232k.size();
    }

    /* renamed from: b */
    public long[] m6803b() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        m6797a(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            int i2 = i + 1;
            jArr[i] = ((Long) it.next()).longValue();
            i = i2;
        }
        return jArr;
    }

    /* renamed from: a */
    private void m6797a(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.f6222a);
        if (z || equals) {
            if (this.f6225d != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f6225d));
            }
            if (this.f6226e != -9223372036854775807L) {
                treeSet.add(Long.valueOf(this.f6226e));
            }
        }
        if (this.f6232k != null) {
            for (int i = 0; i < this.f6232k.size(); i++) {
                boolean z2;
                C2460b c2460b = (C2460b) this.f6232k.get(i);
                if (!z) {
                    if (!equals) {
                        z2 = false;
                        c2460b.m6797a((TreeSet) treeSet, z2);
                    }
                }
                z2 = true;
                c2460b.m6797a((TreeSet) treeSet, z2);
            }
        }
    }

    /* renamed from: a */
    public List<C2458b> m6800a(long j, Map<String, C2463e> map, Map<String, C2461c> map2) {
        Map treeMap = new TreeMap();
        m6794a(j, false, this.f6228g, treeMap);
        m6796a((Map) map, treeMap);
        j = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            C2461c c2461c = (C2461c) map2.get(entry.getKey());
            j.add(new C2458b(m6790a((SpannableStringBuilder) entry.getValue()), null, c2461c.f6235c, c2461c.f6236d, c2461c.f6237e, c2461c.f6234b, LinearLayoutManager.INVALID_OFFSET, c2461c.f6238f));
        }
        return j;
    }

    /* renamed from: a */
    private void m6794a(long j, boolean z, String str, Map<String, SpannableStringBuilder> map) {
        this.f6230i.clear();
        this.f6231j.clear();
        String str2 = this.f6228g;
        if (!"".equals(str2)) {
            str = str2;
        }
        if (this.f6224c && z) {
            C2460b.m6791a(str, (Map) map).append(this.f6223b);
        } else if ("br".equals(this.f6222a) && z) {
            C2460b.m6791a(str, (Map) map).append('\n');
        } else if (!"metadata".equals(this.f6222a)) {
            if (m6802a(j)) {
                boolean equals = "p".equals(this.f6222a);
                for (Entry entry : map.entrySet()) {
                    this.f6230i.put(entry.getKey(), Integer.valueOf(((SpannableStringBuilder) entry.getValue()).length()));
                }
                for (int i = 0; i < m6798a(); i++) {
                    boolean z2;
                    C2460b a = m6799a(i);
                    if (!z) {
                        if (!equals) {
                            z2 = false;
                            a.m6794a(j, z2, str, (Map) map);
                        }
                    }
                    z2 = true;
                    a.m6794a(j, z2, str, (Map) map);
                }
                if (equals) {
                    C2462d.m6806a(C2460b.m6791a(str, (Map) map));
                }
                for (Entry entry2 : map.entrySet()) {
                    this.f6231j.put(entry2.getKey(), Integer.valueOf(((SpannableStringBuilder) entry2.getValue()).length()));
                }
            }
        }
    }

    /* renamed from: a */
    private static SpannableStringBuilder m6791a(String str, Map<String, SpannableStringBuilder> map) {
        if (!map.containsKey(str)) {
            map.put(str, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder) map.get(str);
    }

    /* renamed from: a */
    private void m6796a(Map<String, C2463e> map, Map<String, SpannableStringBuilder> map2) {
        for (Entry entry : this.f6231j.entrySet()) {
            String str = (String) entry.getKey();
            m6795a((Map) map, (SpannableStringBuilder) map2.get(str), this.f6230i.containsKey(str) ? ((Integer) this.f6230i.get(str)).intValue() : 0, ((Integer) entry.getValue()).intValue());
            for (int i = 0; i < m6798a(); i++) {
                m6799a(i).m6796a((Map) map, (Map) map2);
            }
        }
    }

    /* renamed from: a */
    private void m6795a(Map<String, C2463e> map, SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        if (i != i2) {
            map = C2462d.m6804a(this.f6227f, this.f6229h, map);
            if (map != null) {
                C2462d.m6807a(spannableStringBuilder, i, i2, map);
            }
        }
    }

    /* renamed from: a */
    private SpannableStringBuilder m6790a(SpannableStringBuilder spannableStringBuilder) {
        int i;
        int i2 = 0;
        int length = spannableStringBuilder.length();
        for (i = 0; i < length; i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i3 = i + 1;
                int i4 = i3;
                while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                    i4++;
                }
                i4 -= i3;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i + i4);
                    length -= i4;
                }
            }
        }
        if (length > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
            length--;
        }
        i = 0;
        while (true) {
            i3 = length - 1;
            if (i >= i3) {
                break;
            }
            if (spannableStringBuilder.charAt(i) == '\n') {
                i3 = i + 1;
                if (spannableStringBuilder.charAt(i3) == ' ') {
                    spannableStringBuilder.delete(i3, i + 2);
                    length--;
                }
            }
            i++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i3) == ' ') {
            spannableStringBuilder.delete(i3, length);
            length--;
        }
        while (true) {
            i = length - 1;
            if (i2 >= i) {
                break;
            }
            if (spannableStringBuilder.charAt(i2) == ' ') {
                i = i2 + 1;
                if (spannableStringBuilder.charAt(i) == '\n') {
                    spannableStringBuilder.delete(i2, i);
                    length--;
                }
            }
            i2++;
        }
        if (length > 0 && spannableStringBuilder.charAt(i) == '\n') {
            spannableStringBuilder.delete(i, length);
        }
        return spannableStringBuilder;
    }
}
