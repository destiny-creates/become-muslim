package com.p064b.p065a.p066a;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.p064b.p065a.p066a.C0992g.C0991a;
import com.p064b.p065a.p066a.C0999s.C0998b;
import io.p347a.p348a.p349a.C6512a;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6434n;
import io.p347a.p348a.p349a.p350a.p352b.C6436o;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import io.p347a.p348a.p349a.p350a.p356e.C7615b;
import io.p347a.p348a.p349a.p350a.p357f.C7618b;
import io.p347a.p348a.p349a.p350a.p358g.C6491b;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: SessionAnalyticsManager */
/* renamed from: com.b.a.a.q */
class C3411q implements C0991a {
    /* renamed from: a */
    final C3403b f9072a;
    /* renamed from: b */
    final C6512a f9073b;
    /* renamed from: c */
    final C0992g f9074c;
    /* renamed from: d */
    final C0989e f9075d;
    /* renamed from: e */
    private final long f9076e;

    /* renamed from: b */
    public void m10871b(String str) {
    }

    /* renamed from: a */
    public static C3411q m10864a(C6520i c6520i, Context context, C6436o c6436o, String str, String str2, long j) {
        Context context2 = context;
        C6436o c6436o2 = c6436o;
        C1001v c1001v = new C1001v(context, c6436o, str, str2);
        C6520i c6520i2 = c6520i;
        C0988c c0988c = new C0988c(context, new C7618b(c6520i));
        C6484e c7615b = new C7615b(C6514c.h());
        C6512a c6512a = new C6512a(context);
        ScheduledExecutorService b = C6434n.b("Answers Events Handler");
        C0992g c0992g = new C0992g(b);
        return new C3411q(new C3403b(c6520i2, context, c0988c, c1001v, c7615b, b), c6512a, c0992g, C0989e.m3427a(context), j);
    }

    C3411q(C3403b c3403b, C6512a c6512a, C0992g c0992g, C0989e c0989e, long j) {
        this.f9072a = c3403b;
        this.f9073b = c6512a;
        this.f9074c = c0992g;
        this.f9075d = c0989e;
        this.f9076e = j;
    }

    /* renamed from: b */
    public void m10870b() {
        this.f9072a.m10842b();
        this.f9073b.a(new C3404d(this, this.f9074c));
        this.f9074c.m3434a((C0991a) this);
        if (m10869a(this.f9076e)) {
            m10874d();
            this.f9075d.m3428a();
        }
    }

    /* renamed from: c */
    public void m10873c() {
        this.f9073b.a();
        this.f9072a.m10837a();
    }

    /* renamed from: a */
    public void m10868a(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C6514c.h().a("Answers", "Logged crash");
            this.f9072a.m10845c(C0999s.m3445a(str));
            return;
        }
        throw new IllegalStateException("onCrash called from main thread!!!");
    }

    /* renamed from: d */
    public void m10874d() {
        C6514c.h().a("Answers", "Logged install");
        this.f9072a.m10843b(C0999s.m3443a());
    }

    /* renamed from: a */
    public void m10866a(Activity activity, C0998b c0998b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Logged lifecycle event: ");
        stringBuilder.append(c0998b.name());
        C6514c.h().a("Answers", stringBuilder.toString());
        this.f9072a.m10838a(C0999s.m3444a(c0998b, activity));
    }

    /* renamed from: a */
    public void mo745a() {
        C6514c.h().a("Answers", "Flush events when app is backgrounded");
        this.f9072a.m10844c();
    }

    /* renamed from: a */
    public void m10867a(C6491b c6491b, String str) {
        this.f9074c.m3435a(c6491b.f20912h);
        this.f9072a.m10840a(c6491b, str);
    }

    /* renamed from: a */
    boolean m10869a(long j) {
        return (this.f9075d.m3429b() || m10872b(j) == null) ? 0 : 1;
    }

    /* renamed from: b */
    boolean m10872b(long j) {
        return System.currentTimeMillis() - j < 3600000 ? 1 : 0;
    }
}
