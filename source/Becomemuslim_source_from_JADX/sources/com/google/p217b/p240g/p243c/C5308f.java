package com.google.p217b.p240g.p243c;

import com.facebook.stetho.server.http.HttpStatus;
import com.google.p217b.p240g.p241a.C5288f;
import com.google.p217b.p240g.p241a.C5290h;
import com.google.p217b.p240g.p241a.C5294j;

/* compiled from: QRCode */
/* renamed from: com.google.b.g.c.f */
public final class C5308f {
    /* renamed from: a */
    private C5290h f17918a;
    /* renamed from: b */
    private C5288f f17919b;
    /* renamed from: c */
    private C5294j f17920c;
    /* renamed from: d */
    private int f17921d = -1;
    /* renamed from: e */
    private C5303b f17922e;

    /* renamed from: b */
    public static boolean m22557b(int i) {
        return i >= 0 && i < 8;
    }

    /* renamed from: a */
    public C5303b m22558a() {
        return this.f17922e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(HttpStatus.HTTP_OK);
        stringBuilder.append("<<\n");
        stringBuilder.append(" mode: ");
        stringBuilder.append(this.f17918a);
        stringBuilder.append("\n ecLevel: ");
        stringBuilder.append(this.f17919b);
        stringBuilder.append("\n version: ");
        stringBuilder.append(this.f17920c);
        stringBuilder.append("\n maskPattern: ");
        stringBuilder.append(this.f17921d);
        if (this.f17922e == null) {
            stringBuilder.append("\n matrix: null\n");
        } else {
            stringBuilder.append("\n matrix:\n");
            stringBuilder.append(this.f17922e);
        }
        stringBuilder.append(">>\n");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void m22561a(C5290h c5290h) {
        this.f17918a = c5290h;
    }

    /* renamed from: a */
    public void m22560a(C5288f c5288f) {
        this.f17919b = c5288f;
    }

    /* renamed from: a */
    public void m22562a(C5294j c5294j) {
        this.f17920c = c5294j;
    }

    /* renamed from: a */
    public void m22559a(int i) {
        this.f17921d = i;
    }

    /* renamed from: a */
    public void m22563a(C5303b c5303b) {
        this.f17922e = c5303b;
    }
}
