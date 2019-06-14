package com.p064b.p065a.p066a;

import android.app.Activity;
import java.util.Collections;
import java.util.Map;

/* compiled from: SessionEvent */
/* renamed from: com.b.a.a.s */
final class C0999s {
    /* renamed from: a */
    public final C1000t f2780a;
    /* renamed from: b */
    public final long f2781b;
    /* renamed from: c */
    public final C0998b f2782c;
    /* renamed from: d */
    public final Map<String, String> f2783d;
    /* renamed from: e */
    public final String f2784e;
    /* renamed from: f */
    public final Map<String, Object> f2785f;
    /* renamed from: g */
    public final String f2786g;
    /* renamed from: h */
    public final Map<String, Object> f2787h;
    /* renamed from: i */
    private String f2788i;

    /* compiled from: SessionEvent */
    /* renamed from: com.b.a.a.s$a */
    static class C0997a {
        /* renamed from: a */
        final C0998b f2764a;
        /* renamed from: b */
        final long f2765b = System.currentTimeMillis();
        /* renamed from: c */
        Map<String, String> f2766c = null;
        /* renamed from: d */
        String f2767d = null;
        /* renamed from: e */
        Map<String, Object> f2768e = null;
        /* renamed from: f */
        String f2769f = null;
        /* renamed from: g */
        Map<String, Object> f2770g = null;

        public C0997a(C0998b c0998b) {
            this.f2764a = c0998b;
        }

        /* renamed from: a */
        public C0997a m3441a(Map<String, String> map) {
            this.f2766c = map;
            return this;
        }

        /* renamed from: a */
        public C0999s m3442a(C1000t c1000t) {
            return new C0999s(c1000t, this.f2765b, this.f2764a, this.f2766c, this.f2767d, this.f2768e, this.f2769f, this.f2770g);
        }
    }

    /* compiled from: SessionEvent */
    /* renamed from: com.b.a.a.s$b */
    enum C0998b {
        START,
        RESUME,
        PAUSE,
        STOP,
        CRASH,
        INSTALL,
        CUSTOM,
        PREDEFINED
    }

    /* renamed from: a */
    public static C0997a m3444a(C0998b c0998b, Activity activity) {
        return new C0997a(c0998b).m3441a(Collections.singletonMap("activity", activity.getClass().getName()));
    }

    /* renamed from: a */
    public static C0997a m3443a() {
        return new C0997a(C0998b.INSTALL);
    }

    /* renamed from: a */
    public static C0997a m3445a(String str) {
        return new C0997a(C0998b.CRASH).m3441a(Collections.singletonMap("sessionId", str));
    }

    private C0999s(C1000t c1000t, long j, C0998b c0998b, Map<String, String> map, String str, Map<String, Object> map2, String str2, Map<String, Object> map3) {
        this.f2780a = c1000t;
        this.f2781b = j;
        this.f2782c = c0998b;
        this.f2783d = map;
        this.f2784e = str;
        this.f2785f = map2;
        this.f2786g = str2;
        this.f2787h = map3;
    }

    public String toString() {
        if (this.f2788i == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(getClass().getSimpleName());
            stringBuilder.append(": ");
            stringBuilder.append("timestamp=");
            stringBuilder.append(this.f2781b);
            stringBuilder.append(", type=");
            stringBuilder.append(this.f2782c);
            stringBuilder.append(", details=");
            stringBuilder.append(this.f2783d);
            stringBuilder.append(", customType=");
            stringBuilder.append(this.f2784e);
            stringBuilder.append(", customAttributes=");
            stringBuilder.append(this.f2785f);
            stringBuilder.append(", predefinedType=");
            stringBuilder.append(this.f2786g);
            stringBuilder.append(", predefinedAttributes=");
            stringBuilder.append(this.f2787h);
            stringBuilder.append(", metadata=[");
            stringBuilder.append(this.f2780a);
            stringBuilder.append("]]");
            this.f2788i = stringBuilder.toString();
        }
        return this.f2788i;
    }
}
