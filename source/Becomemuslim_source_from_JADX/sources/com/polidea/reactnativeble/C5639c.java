package com.polidea.reactnativeble;

/* compiled from: RefreshGattMoment */
/* renamed from: com.polidea.reactnativeble.c */
enum C5639c {
    ON_CONNECTED("OnConnected");
    
    /* renamed from: b */
    private final String f18876b;

    private C5639c(String str) {
        this.f18876b = str;
    }

    /* renamed from: a */
    static C5639c m23967a(String str) {
        for (C5639c c5639c : C5639c.values()) {
            if (c5639c.f18876b.equals(str)) {
                return c5639c;
            }
        }
        return null;
    }
}
