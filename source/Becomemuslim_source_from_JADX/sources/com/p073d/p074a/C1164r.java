package com.p073d.p074a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Stats */
/* renamed from: com.d.a.r */
class C1164r {
    /* renamed from: a */
    final HandlerThread f3280a = new HandlerThread("Segment-Stats", 10);
    /* renamed from: b */
    final C1163a f3281b;
    /* renamed from: c */
    long f3282c;
    /* renamed from: d */
    long f3283d;
    /* renamed from: e */
    long f3284e;
    /* renamed from: f */
    long f3285f;
    /* renamed from: g */
    Map<String, Long> f3286g = new HashMap();

    /* compiled from: Stats */
    /* renamed from: com.d.a.r$a */
    private static class C1163a extends Handler {
        /* renamed from: a */
        private final C1164r f3279a;

        C1163a(Looper looper, C1164r c1164r) {
            super(looper);
            this.f3279a = c1164r;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f3279a.m4120b(message.arg1);
                    return;
                case 2:
                    this.f3279a.m4118a((Pair) message.obj);
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown Stats handler message: ");
                    stringBuilder.append(message);
                    throw new AssertionError(stringBuilder.toString());
            }
        }
    }

    C1164r() {
        this.f3280a.start();
        this.f3281b = new C1163a(this.f3280a.getLooper(), this);
    }

    /* renamed from: a */
    void m4117a(int i) {
        this.f3281b.sendMessage(this.f3281b.obtainMessage(1, i, 0));
    }

    /* renamed from: b */
    void m4120b(int i) {
        this.f3282c++;
        this.f3283d += (long) i;
    }

    /* renamed from: a */
    void m4119a(String str, long j) {
        this.f3281b.sendMessage(this.f3281b.obtainMessage(2, new Pair(str, Long.valueOf(j))));
    }

    /* renamed from: a */
    void m4118a(Pair<String, Long> pair) {
        this.f3284e++;
        this.f3285f += ((Long) pair.second).longValue();
        Long l = (Long) this.f3286g.get(pair.first);
        if (l == null) {
            this.f3286g.put(pair.first, pair.second);
        } else {
            this.f3286g.put(pair.first, Long.valueOf(l.longValue() + ((Long) pair.second).longValue()));
        }
    }
}
