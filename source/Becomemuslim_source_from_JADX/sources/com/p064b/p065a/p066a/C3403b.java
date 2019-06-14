package com.p064b.p065a.p066a;

import android.content.Context;
import com.p064b.p065a.p066a.C0999s.C0997a;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p355d.C6472d;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import io.p347a.p348a.p349a.p350a.p358g.C6491b;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: AnswersEventsHandler */
/* renamed from: com.b.a.a.b */
class C3403b implements C6472d {
    /* renamed from: a */
    final ScheduledExecutorService f9054a;
    /* renamed from: b */
    C3412r f9055b = new C4531h();
    /* renamed from: c */
    private final C6520i f9056c;
    /* renamed from: d */
    private final Context f9057d;
    /* renamed from: e */
    private final C0988c f9058e;
    /* renamed from: f */
    private final C1001v f9059f;
    /* renamed from: g */
    private final C6484e f9060g;

    /* compiled from: AnswersEventsHandler */
    /* renamed from: com.b.a.a.b$2 */
    class C09832 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3403b f2746a;

        C09832(C3403b c3403b) {
            this.f2746a = c3403b;
        }

        public void run() {
            try {
                C3412r c3412r = this.f2746a.f9055b;
                this.f2746a.f9055b = new C4531h();
                c3412r.mo2802b();
            } catch (Throwable e) {
                C6514c.h().e("Answers", "Failed to disable events", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler */
    /* renamed from: com.b.a.a.b$3 */
    class C09843 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3403b f2747a;

        C09843(C3403b c3403b) {
            this.f2747a = c3403b;
        }

        public void run() {
            try {
                this.f2747a.f9055b.mo2799a();
            } catch (Throwable e) {
                C6514c.h().e("Answers", "Failed to send events files", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler */
    /* renamed from: com.b.a.a.b$4 */
    class C09854 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3403b f2748a;

        C09854(C3403b c3403b) {
            this.f2748a = c3403b;
        }

        public void run() {
            try {
                C1000t a = this.f2748a.f9059f.m3446a();
                C3409o a2 = this.f2748a.f9058e.m3426a();
                a2.a(this.f2748a);
                this.f2748a.f9055b = new C4532i(this.f2748a.f9056c, this.f2748a.f9057d, this.f2748a.f9054a, a2, this.f2748a.f9060g, a);
            } catch (Throwable e) {
                C6514c.h().e("Answers", "Failed to enable events", e);
            }
        }
    }

    /* compiled from: AnswersEventsHandler */
    /* renamed from: com.b.a.a.b$5 */
    class C09865 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C3403b f2749a;

        C09865(C3403b c3403b) {
            this.f2749a = c3403b;
        }

        public void run() {
            try {
                this.f2749a.f9055b.c();
            } catch (Throwable e) {
                C6514c.h().e("Answers", "Failed to flush events", e);
            }
        }
    }

    public C3403b(C6520i c6520i, Context context, C0988c c0988c, C1001v c1001v, C6484e c6484e, ScheduledExecutorService scheduledExecutorService) {
        this.f9056c = c6520i;
        this.f9057d = context;
        this.f9058e = c0988c;
        this.f9059f = c1001v;
        this.f9060g = c6484e;
        this.f9054a = scheduledExecutorService;
    }

    /* renamed from: a */
    public void m10838a(C0997a c0997a) {
        m10839a(c0997a, false, false);
    }

    /* renamed from: b */
    public void m10843b(C0997a c0997a) {
        m10839a(c0997a, false, true);
    }

    /* renamed from: c */
    public void m10845c(C0997a c0997a) {
        m10839a(c0997a, true, false);
    }

    /* renamed from: a */
    public void m10840a(final C6491b c6491b, final String str) {
        m10833b(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C3403b f2745c;

            public void run() {
                try {
                    this.f2745c.f9055b.mo2801a(c6491b, str);
                } catch (Throwable e) {
                    C6514c.h().e("Answers", "Failed to set analytics settings data", e);
                }
            }
        });
    }

    /* renamed from: a */
    public void m10837a() {
        m10833b(new C09832(this));
    }

    /* renamed from: a */
    public void m10841a(String str) {
        m10833b(new C09843(this));
    }

    /* renamed from: b */
    public void m10842b() {
        m10833b(new C09854(this));
    }

    /* renamed from: c */
    public void m10844c() {
        m10833b(new C09865(this));
    }

    /* renamed from: a */
    void m10839a(final C0997a c0997a, boolean z, final boolean z2) {
        Runnable c09876 = new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ C3403b f2752c;

            public void run() {
                try {
                    this.f2752c.f9055b.mo2800a(c0997a);
                    if (z2) {
                        this.f2752c.f9055b.c();
                    }
                } catch (Throwable e) {
                    C6514c.h().e("Answers", "Failed to process event", e);
                }
            }
        };
        if (z) {
            m10831a(c09876);
        } else {
            m10833b(c09876);
        }
    }

    /* renamed from: a */
    private void m10831a(Runnable runnable) {
        try {
            this.f9054a.submit(runnable).get();
        } catch (Runnable runnable2) {
            C6514c.h().e("Answers", "Failed to run events task", runnable2);
        }
    }

    /* renamed from: b */
    private void m10833b(Runnable runnable) {
        try {
            this.f9054a.submit(runnable);
        } catch (Runnable runnable2) {
            C6514c.h().e("Answers", "Failed to submit events task", runnable2);
        }
    }
}
