package com.google.p217b;

import java.util.EnumMap;
import java.util.Map;

/* compiled from: Result */
/* renamed from: com.google.b.q */
public final class C5314q {
    /* renamed from: a */
    private final String f17941a;
    /* renamed from: b */
    private final byte[] f17942b;
    /* renamed from: c */
    private final int f17943c;
    /* renamed from: d */
    private C5316s[] f17944d;
    /* renamed from: e */
    private final C5193a f17945e;
    /* renamed from: f */
    private Map<C5315r, Object> f17946f;
    /* renamed from: g */
    private final long f17947g;

    public C5314q(String str, byte[] bArr, C5316s[] c5316sArr, C5193a c5193a) {
        this(str, bArr, c5316sArr, c5193a, System.currentTimeMillis());
    }

    public C5314q(String str, byte[] bArr, C5316s[] c5316sArr, C5193a c5193a, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, c5316sArr, c5193a, j);
    }

    public C5314q(String str, byte[] bArr, int i, C5316s[] c5316sArr, C5193a c5193a, long j) {
        this.f17941a = str;
        this.f17942b = bArr;
        this.f17943c = i;
        this.f17944d = c5316sArr;
        this.f17945e = c5193a;
        this.f17946f = null;
        this.f17947g = j;
    }

    /* renamed from: a */
    public String m22571a() {
        return this.f17941a;
    }

    /* renamed from: b */
    public byte[] m22575b() {
        return this.f17942b;
    }

    /* renamed from: c */
    public C5316s[] m22576c() {
        return this.f17944d;
    }

    /* renamed from: d */
    public C5193a m22577d() {
        return this.f17945e;
    }

    /* renamed from: e */
    public Map<C5315r, Object> m22578e() {
        return this.f17946f;
    }

    /* renamed from: a */
    public void m22572a(C5315r c5315r, Object obj) {
        if (this.f17946f == null) {
            this.f17946f = new EnumMap(C5315r.class);
        }
        this.f17946f.put(c5315r, obj);
    }

    /* renamed from: a */
    public void m22573a(Map<C5315r, Object> map) {
        if (map != null) {
            if (this.f17946f == null) {
                this.f17946f = map;
                return;
            }
            this.f17946f.putAll(map);
        }
    }

    /* renamed from: a */
    public void m22574a(C5316s[] c5316sArr) {
        Object obj = this.f17944d;
        if (obj == null) {
            this.f17944d = c5316sArr;
            return;
        }
        if (c5316sArr != null && c5316sArr.length > 0) {
            Object obj2 = new C5316s[(obj.length + c5316sArr.length)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            System.arraycopy(c5316sArr, 0, obj2, obj.length, c5316sArr.length);
            this.f17944d = obj2;
        }
    }

    public String toString() {
        return this.f17941a;
    }
}
