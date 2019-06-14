package io.p347a.p348a.p349a.p350a.p358g;

import android.content.Context;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6424g;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6430k;
import io.p347a.p348a.p349a.p350a.p352b.C6431l;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p352b.C7607s;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings */
/* renamed from: io.a.a.a.a.g.q */
public class C6504q {
    /* renamed from: a */
    private final AtomicReference<C6507t> f20958a;
    /* renamed from: b */
    private final CountDownLatch f20959b;
    /* renamed from: c */
    private C6506s f20960c;
    /* renamed from: d */
    private boolean f20961d;

    /* compiled from: Settings */
    /* renamed from: io.a.a.a.a.g.q$a */
    static class C6502a {
        /* renamed from: a */
        private static final C6504q f20957a = new C6504q();
    }

    /* compiled from: Settings */
    /* renamed from: io.a.a.a.a.g.q$b */
    public interface C6503b<T> {
        /* renamed from: b */
        T m26607b(C6507t c6507t);
    }

    /* renamed from: a */
    public static C6504q m26608a() {
        return C6502a.f20957a;
    }

    private C6504q() {
        this.f20958a = new AtomicReference();
        this.f20959b = new CountDownLatch(1);
        this.f20961d = false;
    }

    /* renamed from: a */
    public synchronized C6504q m26610a(C6520i c6520i, C6436o c6436o, C6484e c6484e, String str, String str2, String str3) {
        C6504q c6504q = this;
        C6520i c6520i2 = c6520i;
        synchronized (this) {
            if (c6504q.f20961d) {
                return c6504q;
            }
            if (c6504q.f20960c == null) {
                Context E = c6520i.m26655E();
                String c = c6436o.m26407c();
                String a = new C6424g().m26341a(E);
                String j = c6436o.m26414j();
                C6430k c7607s = new C7607s();
                C6509v c7623k = new C7623k();
                C6496g c7621i = new C7621i(c6520i2);
                String k = C6428i.m26387k(E);
                String str4 = str3;
                C6511x c7624l = new C7624l(c6520i2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c}), c6484e);
                str4 = c6436o.m26411g();
                c = c6436o.m26410f();
                String str5 = c;
                String str6 = str2;
                String str7 = str;
                C6520i c6520i3 = c6520i;
                c6504q.f20960c = new C7622j(c6520i3, new C6510w(a, str4, str5, c6436o.m26409e(), c6436o.m26417m(), c6436o.m26406b(), c6436o.m26418n(), C6428i.m26362a(C6428i.m26389m(E)), str6, str7, C6431l.m26393a(j).m26394a(), k), c7607s, c7623k, c7621i, c7624l);
            }
            c6504q.f20961d = true;
            return c6504q;
        }
    }

    /* renamed from: a */
    public <T> T m26611a(C6503b<T> c6503b, T t) {
        C6507t c6507t = (C6507t) this.f20958a.get();
        return c6507t == null ? t : c6503b.m26607b(c6507t);
    }

    /* renamed from: b */
    public io.p347a.p348a.p349a.p350a.p358g.C6507t m26612b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f20959b;	 Catch:{ InterruptedException -> 0x000e }
        r0.await();	 Catch:{ InterruptedException -> 0x000e }
        r0 = r3.f20958a;	 Catch:{ InterruptedException -> 0x000e }
        r0 = r0.get();	 Catch:{ InterruptedException -> 0x000e }
        r0 = (io.p347a.p348a.p349a.p350a.p358g.C6507t) r0;	 Catch:{ InterruptedException -> 0x000e }
        return r0;
    L_0x000e:
        r0 = io.p347a.p348a.p349a.C6514c.m26634h();
        r1 = "Fabric";
        r2 = "Interrupted while waiting for settings data.";
        r0.mo5479e(r1, r2);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.g.q.b():io.a.a.a.a.g.t");
    }

    /* renamed from: c */
    public synchronized boolean m26613c() {
        C6507t a;
        a = this.f20960c.mo5467a();
        m26609a(a);
        return a != null;
    }

    /* renamed from: d */
    public synchronized boolean m26614d() {
        C6507t a;
        a = this.f20960c.mo5468a(C6505r.SKIP_CACHE_LOOKUP);
        m26609a(a);
        if (a == null) {
            C6514c.m26634h().mo5480e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a != null;
    }

    /* renamed from: a */
    private void m26609a(C6507t c6507t) {
        this.f20958a.set(c6507t);
        this.f20959b.countDown();
    }
}
