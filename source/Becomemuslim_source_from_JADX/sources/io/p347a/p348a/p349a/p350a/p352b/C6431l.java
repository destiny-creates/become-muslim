package io.p347a.p348a.p349a.p350a.p352b;

/* compiled from: DeliveryMechanism */
/* renamed from: io.a.a.a.a.b.l */
public enum C6431l {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    /* renamed from: e */
    private final int f20777e;

    private C6431l(int i) {
        this.f20777e = i;
    }

    /* renamed from: a */
    public int m26394a() {
        return this.f20777e;
    }

    public String toString() {
        return Integer.toString(this.f20777e);
    }

    /* renamed from: a */
    public static C6431l m26393a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
