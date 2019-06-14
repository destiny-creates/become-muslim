package host.exp.exponent.p339f;

import host.exp.exponent.experience.C8366b;
import host.exp.exponent.notifications.C6396c;
import host.exp.exponent.p334a.C6289b;

/* compiled from: KernelConstants */
/* renamed from: host.exp.exponent.f.l */
public class C6352l {
    /* renamed from: a */
    public static final String f20613a = "l";
    /* renamed from: b */
    public static Class f20614b;

    /* compiled from: KernelConstants */
    /* renamed from: host.exp.exponent.f.l$a */
    public static class C6349a {
        /* renamed from: a */
        public final String f20606a;

        public C6349a(String str) {
            this.f20606a = str;
        }
    }

    /* compiled from: KernelConstants */
    /* renamed from: host.exp.exponent.f.l$b */
    public static class C6350b {
        /* renamed from: a */
        public final String f20607a;
        /* renamed from: b */
        public final String f20608b;

        public C6350b(String str, String str2) {
            this.f20607a = str;
            this.f20608b = str2;
        }
    }

    /* compiled from: KernelConstants */
    /* renamed from: host.exp.exponent.f.l$c */
    public static class C6351c {
        /* renamed from: a */
        public final String f20609a;
        /* renamed from: b */
        public final String f20610b;
        /* renamed from: c */
        public final String f20611c;
        /* renamed from: d */
        public final C6396c f20612d;

        public C6351c(String str, String str2, String str3) {
            this.f20609a = str;
            this.f20610b = str2;
            this.f20611c = str3;
            this.f20612d = null;
        }

        public C6351c(String str, String str2, String str3, C6396c c6396c) {
            this.f20609a = str;
            this.f20610b = str2;
            this.f20611c = str3;
            this.f20612d = c6396c;
        }
    }

    static {
        f20614b = C8366b.class;
        try {
            f20614b = Class.forName("host.exp.exponent.MainActivity");
        } catch (Exception e) {
            String str = f20613a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find MainActivity, falling back to DetachActivity: ");
            stringBuilder.append(e.getMessage());
            C6289b.m25953c(str, stringBuilder.toString());
        }
    }
}
