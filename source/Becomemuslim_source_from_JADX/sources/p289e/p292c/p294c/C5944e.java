package p289e.p292c.p294c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import p289e.p291b.C5918f;
import p289e.p292c.p295e.C5966k;
import p289e.p300f.C5977c;

/* compiled from: GenericScheduledExecutorServiceFactory */
/* renamed from: e.c.c.e */
enum C5944e {
    ;
    
    /* renamed from: a */
    static final C5966k f19672a = null;

    static {
        f19672a = new C5966k("RxScheduledExecutorPool-");
    }

    /* renamed from: a */
    static ThreadFactory m24864a() {
        return f19672a;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m24865b() {
        C5918f c = C5977c.m25073c();
        if (c == null) {
            return C5944e.m24866c();
        }
        return (ScheduledExecutorService) c.call();
    }

    /* renamed from: c */
    static ScheduledExecutorService m24866c() {
        return Executors.newScheduledThreadPool(1, C5944e.m24864a());
    }
}
