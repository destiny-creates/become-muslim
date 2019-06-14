package com.google.p217b.p231e.p232a.p233a.p234a;

import com.google.p217b.p222b.C5196a;

/* compiled from: AbstractExpandedDecoder */
/* renamed from: com.google.b.e.a.a.a.j */
public abstract class C5236j {
    /* renamed from: a */
    private final C5196a f17674a;
    /* renamed from: b */
    private final C5242s f17675b;

    /* renamed from: a */
    public abstract String mo4869a();

    C5236j(C5196a c5196a) {
        this.f17674a = c5196a;
        this.f17675b = new C5242s(c5196a);
    }

    /* renamed from: b */
    protected final C5196a m22181b() {
        return this.f17674a;
    }

    /* renamed from: c */
    protected final C5242s m22182c() {
        return this.f17675b;
    }

    /* renamed from: a */
    public static C5236j m22179a(C5196a c5196a) {
        if (c5196a.m21959a(1)) {
            return new C7898g(c5196a);
        }
        if (!c5196a.m21959a(2)) {
            return new C6868k(c5196a);
        }
        switch (C5242s.m22197a(c5196a, 1, 4)) {
            case 4:
                return new C8340a(c5196a);
            case 5:
                return new C8341b(c5196a);
            default:
                switch (C5242s.m22197a(c5196a, 1, 5)) {
                    case 12:
                        return new C7896c(c5196a);
                    case 13:
                        return new C7897d(c5196a);
                    default:
                        switch (C5242s.m22197a(c5196a, 1, 7)) {
                            case 56:
                                return new C8230e(c5196a, "310", "11");
                            case 57:
                                return new C8230e(c5196a, "320", "11");
                            case 58:
                                return new C8230e(c5196a, "310", "13");
                            case 59:
                                return new C8230e(c5196a, "320", "13");
                            case 60:
                                return new C8230e(c5196a, "310", "15");
                            case 61:
                                return new C8230e(c5196a, "320", "15");
                            case 62:
                                return new C8230e(c5196a, "310", "17");
                            case 63:
                                return new C8230e(c5196a, "320", "17");
                            default:
                                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(c5196a)));
                        }
                }
        }
    }
}
