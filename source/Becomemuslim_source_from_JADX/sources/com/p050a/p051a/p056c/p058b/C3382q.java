package com.p050a.p051a.p056c.p058b;

import com.p050a.p051a.C0957g;
import com.p050a.p051a.p052a.p053a.C0880b;
import com.p050a.p051a.p052a.p053a.C3361r;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p059c.C4529a;

/* compiled from: ShapeTrimPath */
/* renamed from: com.a.a.c.b.q */
public class C3382q implements C0895b {
    /* renamed from: a */
    private final String f9007a;
    /* renamed from: b */
    private final C0906a f9008b;
    /* renamed from: c */
    private final C4522b f9009c;
    /* renamed from: d */
    private final C4522b f9010d;
    /* renamed from: e */
    private final C4522b f9011e;

    /* compiled from: ShapeTrimPath */
    /* renamed from: com.a.a.c.b.q$a */
    public enum C0906a {
        Simultaneously,
        Individually;

        /* renamed from: a */
        public static C0906a m3188a(int i) {
            switch (i) {
                case 1:
                    return Simultaneously;
                case 2:
                    return Individually;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown trim path type ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public C3382q(String str, C0906a c0906a, C4522b c4522b, C4522b c4522b2, C4522b c4522b3) {
        this.f9007a = str;
        this.f9008b = c0906a;
        this.f9009c = c4522b;
        this.f9010d = c4522b2;
        this.f9011e = c4522b3;
    }

    /* renamed from: a */
    public String m10765a() {
        return this.f9007a;
    }

    /* renamed from: b */
    public C0906a m10766b() {
        return this.f9008b;
    }

    /* renamed from: c */
    public C4522b m10767c() {
        return this.f9010d;
    }

    /* renamed from: d */
    public C4522b m10768d() {
        return this.f9009c;
    }

    /* renamed from: e */
    public C4522b m10769e() {
        return this.f9011e;
    }

    /* renamed from: a */
    public C0880b mo738a(C0957g c0957g, C4529a c4529a) {
        return new C3361r(c4529a, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trim Path: {start: ");
        stringBuilder.append(this.f9009c);
        stringBuilder.append(", end: ");
        stringBuilder.append(this.f9010d);
        stringBuilder.append(", offset: ");
        stringBuilder.append(this.f9011e);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
