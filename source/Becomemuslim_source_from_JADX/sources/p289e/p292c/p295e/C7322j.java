package p289e.p292c.p295e;

import java.io.PrintStream;
import java.util.Queue;
import p289e.C5989l;
import p289e.p290a.C5904c;
import p289e.p292c.p293a.C5937h;
import p289e.p292c.p295e.p296a.C7309d;
import p289e.p292c.p295e.p297b.C8364q;
import p289e.p292c.p295e.p297b.C8365i;
import p289e.p292c.p295e.p297b.ae;

/* compiled from: RxRingBuffer */
/* renamed from: e.c.e.j */
public class C7322j implements C5989l {
    /* renamed from: b */
    public static final int f25717b;
    /* renamed from: a */
    public volatile Object f25718a;
    /* renamed from: c */
    private Queue<Object> f25719c;
    /* renamed from: d */
    private final int f25720d;

    static {
        int i = C5964i.m24943a() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to set 'rx.buffer.size' with value ");
                stringBuilder.append(property);
                stringBuilder.append(" => ");
                stringBuilder.append(e.getMessage());
                printStream.println(stringBuilder.toString());
            }
        }
        f25717b = i;
    }

    /* renamed from: c */
    public static C7322j m33673c() {
        if (ae.m24923a()) {
            return new C7322j(false, f25717b);
        }
        return new C7322j();
    }

    private C7322j(Queue<Object> queue, int i) {
        this.f25719c = queue;
        this.f25720d = i;
    }

    private C7322j(boolean z, int i) {
        this.f25719c = z ? new C8365i(i) : new C8364q(i);
        this.f25720d = i;
    }

    /* renamed from: d */
    public synchronized void m33676d() {
    }

    public void U_() {
        m33676d();
    }

    C7322j() {
        this(new C7309d(f25717b), f25717b);
    }

    /* renamed from: a */
    public void m33674a(Object obj) {
        synchronized (this) {
            Queue queue = this.f25719c;
            int i = 1;
            if (queue != null) {
                obj = queue.offer(C5937h.m24848a(obj)) ^ 1;
                i = 0;
            } else {
                obj = null;
            }
        }
        if (i != 0) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (obj != null) {
            throw new C5904c();
        }
    }

    /* renamed from: e */
    public boolean m33677e() {
        Queue queue = this.f25719c;
        if (queue != null) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public java.lang.Object m33678f() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.f25719c;	 Catch:{ all -> 0x001d }
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        return r1;
    L_0x0008:
        r2 = r0.poll();	 Catch:{ all -> 0x001d }
        r3 = r4.f25718a;	 Catch:{ all -> 0x001d }
        if (r2 != 0) goto L_0x001b;
    L_0x0010:
        if (r3 == 0) goto L_0x001b;
    L_0x0012:
        r0 = r0.peek();	 Catch:{ all -> 0x001d }
        if (r0 != 0) goto L_0x001b;
    L_0x0018:
        r4.f25718a = r1;	 Catch:{ all -> 0x001d }
        r2 = r3;
    L_0x001b:
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        return r2;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.e.j.f():java.lang.Object");
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return this.f25719c == null;
    }
}
