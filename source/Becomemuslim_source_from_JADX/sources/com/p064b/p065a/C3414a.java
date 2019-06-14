package com.p064b.p065a;

import com.p064b.p065a.p066a.C3402a;
import com.p064b.p065a.p067b.C3417c;
import com.p064b.p065a.p068c.C3424f;
import com.p064b.p065a.p068c.C3424f.C1030a;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.C6521j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* compiled from: Crashlytics */
/* renamed from: com.b.a.a */
public class C3414a extends C6520i<Void> implements C6521j {
    /* renamed from: a */
    public final C3402a f9077a;
    /* renamed from: b */
    public final C3417c f9078b;
    /* renamed from: c */
    public final C3424f f9079c;
    /* renamed from: d */
    public final Collection<? extends C6520i> f9080d;

    /* compiled from: Crashlytics */
    /* renamed from: com.b.a.a$a */
    public static class C0981a {
        /* renamed from: a */
        private C3402a f2739a;
        /* renamed from: b */
        private C3417c f2740b;
        /* renamed from: c */
        private C3424f f2741c;
        /* renamed from: d */
        private C1030a f2742d;

        /* renamed from: a */
        public C0981a m3424a(C3424f c3424f) {
            if (c3424f == null) {
                throw new NullPointerException("CrashlyticsCore Kit must not be null.");
            } else if (this.f2741c == null) {
                this.f2741c = c3424f;
                return this;
            } else {
                throw new IllegalStateException("CrashlyticsCore Kit already set.");
            }
        }

        /* renamed from: a */
        public C3414a m3425a() {
            if (this.f2742d != null) {
                if (this.f2741c == null) {
                    this.f2741c = this.f2742d.m3556a();
                } else {
                    throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
                }
            }
            if (this.f2739a == null) {
                this.f2739a = new C3402a();
            }
            if (this.f2740b == null) {
                this.f2740b = new C3417c();
            }
            if (this.f2741c == null) {
                this.f2741c = new C3424f();
            }
            return new C3414a(this.f2739a, this.f2740b, this.f2741c);
        }
    }

    /* renamed from: a */
    public String m10886a() {
        return "2.5.5.97";
    }

    /* renamed from: b */
    public String m10887b() {
        return "com.crashlytics.sdk.android:crashlytics";
    }

    /* renamed from: d */
    protected Void m10889d() {
        return null;
    }

    /* renamed from: f */
    protected /* synthetic */ Object m10890f() {
        return m10889d();
    }

    public C3414a() {
        this(new C3402a(), new C3417c(), new C3424f());
    }

    C3414a(C3402a c3402a, C3417c c3417c, C3424f c3424f) {
        this.f9077a = c3402a;
        this.f9078b = c3417c;
        this.f9079c = c3424f;
        this.f9080d = Collections.unmodifiableCollection(Arrays.asList(new C6520i[]{c3402a, c3417c, c3424f}));
    }

    /* renamed from: c */
    public Collection<? extends C6520i> m10888c() {
        return this.f9080d;
    }

    /* renamed from: e */
    public static C3414a m10884e() {
        return (C3414a) C6514c.a(C3414a.class);
    }

    /* renamed from: a */
    public static void m10883a(Throwable th) {
        C3414a.m10885g();
        C3414a.m10884e().f9079c.m10952a(th);
    }

    /* renamed from: a */
    public static void m10882a(String str, String str2) {
        C3414a.m10885g();
        C3414a.m10884e().f9079c.m10951a(str, str2);
    }

    /* renamed from: g */
    private static void m10885g() {
        if (C3414a.m10884e() == null) {
            throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
        }
    }
}
