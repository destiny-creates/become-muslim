package com.google.p217b.p225c.p228c;

import com.facebook.imageutils.JfifUtil;
import com.google.p217b.C5281f;
import java.nio.charset.StandardCharsets;

/* compiled from: EncoderContext */
/* renamed from: com.google.b.c.c.h */
final class C5227h {
    /* renamed from: a */
    int f17641a;
    /* renamed from: b */
    private final String f17642b;
    /* renamed from: c */
    private C5231l f17643c;
    /* renamed from: d */
    private C5281f f17644d;
    /* renamed from: e */
    private C5281f f17645e;
    /* renamed from: f */
    private final StringBuilder f17646f;
    /* renamed from: g */
    private int f17647g;
    /* renamed from: h */
    private C5230k f17648h;
    /* renamed from: i */
    private int f17649i;

    C5227h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder stringBuilder = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & JfifUtil.MARKER_FIRST_BYTE);
            if (c == '?') {
                if (str.charAt(i) != '?') {
                    throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
                }
            }
            stringBuilder.append(c);
        }
        this.f17642b = stringBuilder.toString();
        this.f17643c = C5231l.FORCE_NONE;
        this.f17646f = new StringBuilder(str.length());
        this.f17647g = -1;
    }

    /* renamed from: a */
    public void m22116a(C5231l c5231l) {
        this.f17643c = c5231l;
    }

    /* renamed from: a */
    public void m22117a(C5281f c5281f, C5281f c5281f2) {
        this.f17644d = c5281f;
        this.f17645e = c5281f2;
    }

    /* renamed from: a */
    public String m22113a() {
        return this.f17642b;
    }

    /* renamed from: a */
    public void m22115a(int i) {
        this.f17649i = i;
    }

    /* renamed from: b */
    public char m22119b() {
        return this.f17642b.charAt(this.f17641a);
    }

    /* renamed from: c */
    public StringBuilder m22121c() {
        return this.f17646f;
    }

    /* renamed from: a */
    public void m22118a(String str) {
        this.f17646f.append(str);
    }

    /* renamed from: a */
    public void m22114a(char c) {
        this.f17646f.append(c);
    }

    /* renamed from: d */
    public int m22123d() {
        return this.f17646f.length();
    }

    /* renamed from: e */
    public int m22124e() {
        return this.f17647g;
    }

    /* renamed from: b */
    public void m22120b(int i) {
        this.f17647g = i;
    }

    /* renamed from: f */
    public void m22125f() {
        this.f17647g = -1;
    }

    /* renamed from: g */
    public boolean m22126g() {
        return this.f17641a < m22112l();
    }

    /* renamed from: l */
    private int m22112l() {
        return this.f17642b.length() - this.f17649i;
    }

    /* renamed from: h */
    public int m22127h() {
        return m22112l() - this.f17641a;
    }

    /* renamed from: i */
    public C5230k m22128i() {
        return this.f17648h;
    }

    /* renamed from: j */
    public void m22129j() {
        m22122c(m22123d());
    }

    /* renamed from: c */
    public void m22122c(int i) {
        if (this.f17648h == null || i > this.f17648h.m22159f()) {
            this.f17648h = C5230k.m22149a(i, this.f17643c, this.f17644d, this.f17645e, true);
        }
    }

    /* renamed from: k */
    public void m22130k() {
        this.f17648h = null;
    }
}
