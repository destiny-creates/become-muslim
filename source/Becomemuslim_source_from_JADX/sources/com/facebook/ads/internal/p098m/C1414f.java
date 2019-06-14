package com.facebook.ads.internal.p098m;

/* renamed from: com.facebook.ads.internal.m.f */
public enum C1414f {
    TEST("test"),
    BROWSER_SESSION("browser_session"),
    CLOSE("close"),
    IMPRESSION("impression"),
    INVALIDATION("invalidation"),
    STORE("store"),
    OFF_TARGET_CLICK("off_target_click"),
    OPEN_LINK("open_link"),
    NATIVE_VIEW("native_view"),
    VIDEO("video"),
    USER_RETURN("user_return");
    
    /* renamed from: l */
    private String f4150l;

    private C1414f(String str) {
        this.f4150l = str;
    }

    /* renamed from: a */
    public static C1414f m4896a(String str) {
        for (C1414f c1414f : C1414f.values()) {
            if (c1414f.f4150l.equalsIgnoreCase(str)) {
                return c1414f;
            }
        }
        return null;
    }

    public String toString() {
        return this.f4150l;
    }
}
