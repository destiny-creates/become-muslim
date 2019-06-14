package com.google.p217b.p222b;

import java.util.List;

/* compiled from: DecoderResult */
/* renamed from: com.google.b.b.e */
public final class C5205e {
    /* renamed from: a */
    private final byte[] f17575a;
    /* renamed from: b */
    private int f17576b;
    /* renamed from: c */
    private final String f17577c;
    /* renamed from: d */
    private final List<byte[]> f17578d;
    /* renamed from: e */
    private final String f17579e;
    /* renamed from: f */
    private Integer f17580f;
    /* renamed from: g */
    private Integer f17581g;
    /* renamed from: h */
    private Object f17582h;
    /* renamed from: i */
    private final int f17583i;
    /* renamed from: j */
    private final int f17584j;

    public C5205e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public C5205e(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f17575a = bArr;
        if (bArr == null) {
            bArr = null;
        } else {
            bArr = bArr.length * 8;
        }
        this.f17576b = bArr;
        this.f17577c = str;
        this.f17578d = list;
        this.f17579e = str2;
        this.f17583i = i2;
        this.f17584j = i;
    }

    /* renamed from: a */
    public byte[] m22023a() {
        return this.f17575a;
    }

    /* renamed from: b */
    public int m22024b() {
        return this.f17576b;
    }

    /* renamed from: a */
    public void m22020a(int i) {
        this.f17576b = i;
    }

    /* renamed from: c */
    public String m22026c() {
        return this.f17577c;
    }

    /* renamed from: d */
    public List<byte[]> m22027d() {
        return this.f17578d;
    }

    /* renamed from: e */
    public String m22028e() {
        return this.f17579e;
    }

    /* renamed from: a */
    public void m22021a(Integer num) {
        this.f17580f = num;
    }

    /* renamed from: b */
    public void m22025b(Integer num) {
        this.f17581g = num;
    }

    /* renamed from: f */
    public Object m22029f() {
        return this.f17582h;
    }

    /* renamed from: a */
    public void m22022a(Object obj) {
        this.f17582h = obj;
    }

    /* renamed from: g */
    public boolean m22030g() {
        return this.f17583i >= 0 && this.f17584j >= 0;
    }

    /* renamed from: h */
    public int m22031h() {
        return this.f17583i;
    }

    /* renamed from: i */
    public int m22032i() {
        return this.f17584j;
    }
}
