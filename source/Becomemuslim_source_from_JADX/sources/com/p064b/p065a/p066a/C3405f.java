package com.p064b.p065a.p066a;

import io.p347a.p348a.p349a.p350a.p353c.p354a.C6455e;
import io.p347a.p348a.p349a.p350a.p353c.p354a.C7609b;
import io.p347a.p348a.p349a.p350a.p353c.p354a.C7610c;
import io.p347a.p348a.p349a.p350a.p355d.C6474f;
import java.io.File;
import java.util.List;

/* compiled from: AnswersRetryFilesSender */
/* renamed from: com.b.a.a.f */
class C3405f implements C6474f {
    /* renamed from: a */
    private final C3410p f9063a;
    /* renamed from: b */
    private final C0994m f9064b;

    /* renamed from: a */
    public static C3405f m10853a(C3410p c3410p) {
        return new C3405f(c3410p, new C0994m(new C6455e(new C3407l(new C7610c(1000, 8), 0.1d), new C7609b(5))));
    }

    C3405f(C3410p c3410p, C0994m c0994m) {
        this.f9063a = c3410p;
        this.f9064b = c0994m;
    }

    /* renamed from: a */
    public boolean m10854a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.f9064b.m3439a(nanoTime)) {
            return false;
        }
        if (this.f9063a.m10863a(list) != null) {
            this.f9064b.m3438a();
            return true;
        }
        this.f9064b.m3440b(nanoTime);
        return false;
    }
}
