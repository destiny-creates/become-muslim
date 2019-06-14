package com.p064b.p065a.p066a;

import android.content.Context;
import com.facebook.react.uimanager.ViewProps;
import com.p064b.p065a.p066a.C0999s.C0997a;
import com.p064b.p065a.p066a.C0999s.C0998b;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6424g;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p355d.C6474f;
import io.p347a.p348a.p349a.p350a.p355d.C6475i;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import io.p347a.p348a.p349a.p350a.p358g.C6491b;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: EnabledSessionAnalyticsManagerStrategy */
/* renamed from: com.b.a.a.i */
class C4532i implements C3412r {
    /* renamed from: a */
    final C1000t f12250a;
    /* renamed from: b */
    C6474f f12251b;
    /* renamed from: c */
    C6424g f12252c = new C6424g();
    /* renamed from: d */
    C0993j f12253d = new C3406k();
    /* renamed from: e */
    boolean f12254e = true;
    /* renamed from: f */
    boolean f12255f = true;
    /* renamed from: g */
    volatile int f12256g = -1;
    /* renamed from: h */
    private final C6520i f12257h;
    /* renamed from: i */
    private final C6484e f12258i;
    /* renamed from: j */
    private final Context f12259j;
    /* renamed from: k */
    private final C3409o f12260k;
    /* renamed from: l */
    private final ScheduledExecutorService f12261l;
    /* renamed from: m */
    private final AtomicReference<ScheduledFuture<?>> f12262m = new AtomicReference();

    public C4532i(C6520i c6520i, Context context, ScheduledExecutorService scheduledExecutorService, C3409o c3409o, C6484e c6484e, C1000t c1000t) {
        this.f12257h = c6520i;
        this.f12259j = context;
        this.f12261l = scheduledExecutorService;
        this.f12260k = c3409o;
        this.f12258i = c6484e;
        this.f12250a = c1000t;
    }

    /* renamed from: a */
    public void mo2801a(C6491b c6491b, String str) {
        this.f12251b = C3405f.m10853a(new C3410p(this.f12257h, str, c6491b.f20905a, this.f12258i, this.f12252c.a(this.f12259j)));
        this.f12260k.m10860a(c6491b);
        this.f12254e = c6491b.f20910f;
        str = C6514c.h();
        String str2 = "Answers";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Custom event tracking ");
        stringBuilder.append(this.f12254e ? ViewProps.ENABLED : "disabled");
        str.a(str2, stringBuilder.toString());
        this.f12255f = c6491b.f20911g;
        str = C6514c.h();
        str2 = "Answers";
        stringBuilder = new StringBuilder();
        stringBuilder.append("Predefined event tracking ");
        stringBuilder.append(this.f12255f ? ViewProps.ENABLED : "disabled");
        str.a(str2, stringBuilder.toString());
        if (c6491b.f20913i > 1) {
            C6514c.h().a("Answers", "Event sampling enabled");
            this.f12253d = new C3408n(c6491b.f20913i);
        }
        this.f12256g = c6491b.f20906b;
        m15418a((long) null, (long) this.f12256g);
    }

    /* renamed from: a */
    public void mo2800a(C0997a c0997a) {
        c0997a = c0997a.m3442a(this.f12250a);
        StringBuilder stringBuilder;
        if (!this.f12254e && C0998b.CUSTOM.equals(c0997a.f2782c)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Custom events tracking disabled - skipping event: ");
            stringBuilder.append(c0997a);
            C6514c.h().a("Answers", stringBuilder.toString());
        } else if (!this.f12255f && C0998b.PREDEFINED.equals(c0997a.f2782c)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Predefined events tracking disabled - skipping event: ");
            stringBuilder.append(c0997a);
            C6514c.h().a("Answers", stringBuilder.toString());
        } else if (this.f12253d.mo744a(c0997a)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Skipping filtered event: ");
            stringBuilder.append(c0997a);
            C6514c.h().a("Answers", stringBuilder.toString());
        } else {
            try {
                this.f12260k.a(c0997a);
            } catch (Throwable e) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Failed to write event: ");
                stringBuilder2.append(c0997a);
                C6514c.h().e("Answers", stringBuilder2.toString(), e);
            }
            m15424e();
        }
    }

    /* renamed from: e */
    public void m15424e() {
        if ((this.f12256g != -1 ? 1 : null) != null) {
            m15418a((long) this.f12256g, (long) this.f12256g);
        }
    }

    /* renamed from: a */
    public void mo2799a() {
        if (this.f12251b == null) {
            C6428i.a(this.f12259j, "skipping files send because we don't yet know the target endpoint");
            return;
        }
        C6428i.a(this.f12259j, "Sending all files");
        List e = this.f12260k.e();
        int i = 0;
        while (e.size() > 0) {
            try {
                C6428i.a(this.f12259j, String.format(Locale.US, "attempt to send batch of %d files", new Object[]{Integer.valueOf(e.size())}));
                boolean a = this.f12251b.a(e);
                if (a) {
                    i += e.size();
                    this.f12260k.a(e);
                }
                if (!a) {
                    break;
                }
                e = this.f12260k.e();
            } catch (Throwable e2) {
                Context context = this.f12259j;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to send batch of analytics files to server: ");
                stringBuilder.append(e2.getMessage());
                C6428i.a(context, stringBuilder.toString(), e2);
            }
        }
        if (i == 0) {
            this.f12260k.g();
        }
    }

    /* renamed from: d */
    public void m15423d() {
        if (this.f12262m.get() != null) {
            C6428i.a(this.f12259j, "Cancelling time-based rollover because no events are currently being generated.");
            ((ScheduledFuture) this.f12262m.get()).cancel(false);
            this.f12262m.set(null);
        }
    }

    /* renamed from: b */
    public void mo2802b() {
        this.f12260k.f();
    }

    /* renamed from: c */
    public boolean m15422c() {
        try {
            return this.f12260k.d();
        } catch (Throwable e) {
            C6428i.a(this.f12259j, "Failed to roll file over.", e);
            return false;
        }
    }

    /* renamed from: a */
    void m15418a(long j, long j2) {
        if ((this.f12262m.get() == null ? 1 : null) != null) {
            Runnable c6475i = new C6475i(this.f12259j, this);
            Context context = this.f12259j;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Scheduling time based file roll over every ");
            stringBuilder.append(j2);
            stringBuilder.append(" seconds");
            C6428i.a(context, stringBuilder.toString());
            try {
                this.f12262m.set(this.f12261l.scheduleAtFixedRate(c6475i, j, j2, TimeUnit.SECONDS));
            } catch (long j3) {
                C6428i.a(this.f12259j, "Failed to schedule time based file roll over", j3);
            }
        }
    }
}
