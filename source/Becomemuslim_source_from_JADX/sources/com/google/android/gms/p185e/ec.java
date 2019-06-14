package com.google.android.gms.p185e;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.internal.p210i.ck;

/* renamed from: com.google.android.gms.e.ec */
final class ec implements eb {
    /* renamed from: a */
    final /* synthetic */ dy f11708a;
    /* renamed from: b */
    private Handler f11709b;

    private ec(dy dyVar) {
        this.f11708a = dyVar;
        this.f11709b = new ck(this.f11708a.f11695b.getMainLooper(), new ed(this));
    }

    /* renamed from: a */
    public final void mo2553a() {
        this.f11709b.removeMessages(1, dy.f11693a);
        this.f11709b.sendMessage(m14557c());
    }

    /* renamed from: b */
    public final void mo2555b() {
        this.f11709b.removeMessages(1, dy.f11693a);
    }

    /* renamed from: a */
    public final void mo2554a(long j) {
        this.f11709b.removeMessages(1, dy.f11693a);
        this.f11709b.sendMessageDelayed(m14557c(), j);
    }

    /* renamed from: c */
    private final Message m14557c() {
        return this.f11709b.obtainMessage(1, dy.f11693a);
    }
}
