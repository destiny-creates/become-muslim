package com.facebook.ads.internal.p101p.p103b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.p101p.p103b.p104a.C3601b;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.ads.internal.p.b.g */
final class C1472g {
    /* renamed from: a */
    private final AtomicInteger f4339a = new AtomicInteger(0);
    /* renamed from: b */
    private final String f4340b;
    /* renamed from: c */
    private volatile C3604e f4341c;
    /* renamed from: d */
    private final List<C1462b> f4342d = new CopyOnWriteArrayList();
    /* renamed from: e */
    private final C1462b f4343e;
    /* renamed from: f */
    private final C1463c f4344f;

    /* renamed from: com.facebook.ads.internal.p.b.g$a */
    private static final class C3605a extends Handler implements C1462b {
        /* renamed from: a */
        private final String f9613a;
        /* renamed from: b */
        private final List<C1462b> f9614b;

        public C3605a(String str, List<C1462b> list) {
            super(Looper.getMainLooper());
            this.f9613a = str;
            this.f9614b = list;
        }

        /* renamed from: a */
        public void mo991a(File file, String str, int i) {
            Message obtainMessage = obtainMessage();
            obtainMessage.arg1 = i;
            obtainMessage.obj = file;
            sendMessage(obtainMessage);
        }

        public void handleMessage(Message message) {
            for (C1462b a : this.f9614b) {
                a.mo991a((File) message.obj, this.f9613a, message.arg1);
            }
        }
    }

    public C1472g(String str, C1463c c1463c) {
        this.f4340b = (String) C1473j.m5210a(str);
        this.f4344f = (C1463c) C1473j.m5210a(c1463c);
        this.f4343e = new C3605a(str, this.f4342d);
    }

    /* renamed from: c */
    private synchronized void m5204c() {
        this.f4341c = this.f4341c == null ? m5206e() : this.f4341c;
    }

    /* renamed from: d */
    private synchronized void m5205d() {
        if (this.f4339a.decrementAndGet() <= 0) {
            this.f4341c.m5223a();
            this.f4341c = null;
        }
    }

    /* renamed from: e */
    private C3604e m5206e() {
        C3604e c3604e = new C3604e(new C3606h(this.f4340b), new C3601b(this.f4344f.m5174a(this.f4340b), this.f4344f.f4315c));
        c3604e.m11753a(this.f4343e);
        return c3604e;
    }

    /* renamed from: a */
    public void m5207a() {
        this.f4342d.clear();
        if (this.f4341c != null) {
            this.f4341c.m11753a(null);
            this.f4341c.m5223a();
            this.f4341c = null;
        }
        this.f4339a.set(0);
    }

    /* renamed from: a */
    public void m5208a(C1464d c1464d, Socket socket) {
        m5204c();
        try {
            this.f4339a.incrementAndGet();
            this.f4341c.m11754a(c1464d, socket);
        } finally {
            m5205d();
        }
    }

    /* renamed from: b */
    public int m5209b() {
        return this.f4339a.get();
    }
}
