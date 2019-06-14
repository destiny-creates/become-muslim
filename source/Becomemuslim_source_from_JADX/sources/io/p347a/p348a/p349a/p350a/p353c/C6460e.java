package io.p347a.p348a.p349a.p350a.p353c;

/* compiled from: Priority */
/* renamed from: io.a.a.a.a.c.e */
public enum C6460e {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    /* renamed from: a */
    static <Y> int m26484a(C6462i c6462i, Y y) {
        if (y instanceof C6462i) {
            y = ((C6462i) y).mo5441b();
        } else {
            y = NORMAL;
        }
        return y.ordinal() - c6462i.mo5441b().ordinal();
    }
}
