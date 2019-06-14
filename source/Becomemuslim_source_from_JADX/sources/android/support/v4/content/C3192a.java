package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.util.C0465n;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* compiled from: AsyncTaskLoader */
/* renamed from: android.support.v4.content.a */
public abstract class C3192a<D> extends C0369c<D> {
    /* renamed from: a */
    volatile C3191a f8232a;
    /* renamed from: b */
    volatile C3191a f8233b;
    /* renamed from: c */
    long f8234c;
    /* renamed from: d */
    long f8235d;
    /* renamed from: e */
    Handler f8236e;
    /* renamed from: o */
    private final Executor f8237o;

    /* compiled from: AsyncTaskLoader */
    /* renamed from: android.support.v4.content.a$a */
    final class C3191a extends C0381e<Void, Void, D> implements Runnable {
        /* renamed from: a */
        boolean f8229a;
        /* renamed from: b */
        final /* synthetic */ C3192a f8230b;
        /* renamed from: d */
        private final CountDownLatch f8231d = new CountDownLatch(1);

        C3191a(C3192a c3192a) {
            this.f8230b = c3192a;
        }

        /* renamed from: a */
        protected D m9652a(Void... voidArr) {
            try {
                return this.f8230b.m9663e();
            } catch (Void[] voidArr2) {
                if (m1156c()) {
                    return null;
                }
                throw voidArr2;
            }
        }

        /* renamed from: a */
        protected void mo221a(D d) {
            try {
                this.f8230b.m9659b(this, d);
            } finally {
                this.f8231d.countDown();
            }
        }

        /* renamed from: b */
        protected void mo222b(D d) {
            try {
                this.f8230b.m9656a(this, d);
            } finally {
                this.f8231d.countDown();
            }
        }

        public void run() {
            this.f8229a = false;
            this.f8230b.m9661c();
        }
    }

    /* renamed from: a */
    public void m9657a(D d) {
    }

    /* renamed from: d */
    public abstract D mo3268d();

    /* renamed from: f */
    public void m9664f() {
    }

    public C3192a(Context context) {
        this(context, C0381e.f1000c);
    }

    private C3192a(Context context, Executor executor) {
        super(context);
        this.f8235d = -10000;
        this.f8237o = executor;
    }

    /* renamed from: a */
    protected void mo223a() {
        super.mo223a();
        m1127k();
        this.f8232a = new C3191a(this);
        m9661c();
    }

    /* renamed from: b */
    protected boolean mo225b() {
        if (this.f8232a == null) {
            return false;
        }
        if (!this.j) {
            this.m = true;
        }
        if (this.f8233b != null) {
            if (this.f8232a.f8229a) {
                this.f8232a.f8229a = false;
                this.f8236e.removeCallbacks(this.f8232a);
            }
            this.f8232a = null;
            return false;
        } else if (this.f8232a.f8229a) {
            this.f8232a.f8229a = false;
            this.f8236e.removeCallbacks(this.f8232a);
            this.f8232a = null;
            return false;
        } else {
            boolean a = this.f8232a.m1151a(false);
            if (a) {
                this.f8233b = this.f8232a;
                m9664f();
            }
            this.f8232a = null;
            return a;
        }
    }

    /* renamed from: c */
    void m9661c() {
        if (this.f8233b == null && this.f8232a != null) {
            if (this.f8232a.f8229a) {
                this.f8232a.f8229a = false;
                this.f8236e.removeCallbacks(this.f8232a);
            }
            if (this.f8234c <= 0 || SystemClock.uptimeMillis() >= this.f8235d + this.f8234c) {
                this.f8232a.m1147a(this.f8237o, (Void[]) null);
            } else {
                this.f8232a.f8229a = true;
                this.f8236e.postAtTime(this.f8232a, this.f8235d + this.f8234c);
            }
        }
    }

    /* renamed from: a */
    void m9656a(C3191a c3191a, D d) {
        m9657a(d);
        if (this.f8233b == c3191a) {
            m1136t();
            this.f8235d = SystemClock.uptimeMillis();
            this.f8233b = null;
            m1123g();
            m9661c();
        }
    }

    /* renamed from: b */
    void m9659b(C3191a c3191a, D d) {
        if (this.f8232a != c3191a) {
            m9656a(c3191a, d);
        } else if (m1124h() != null) {
            m9657a(d);
        } else {
            m1135s();
            this.f8235d = SystemClock.uptimeMillis();
            this.f8232a = null;
            m1120b(d);
        }
    }

    /* renamed from: e */
    protected D m9663e() {
        return mo3268d();
    }

    /* renamed from: a */
    public void mo224a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo224a(str, fileDescriptor, printWriter, strArr);
        if (this.f8232a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f8232a);
            printWriter.print(" waiting=");
            printWriter.println(this.f8232a.f8229a);
        }
        if (this.f8233b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f8233b);
            printWriter.print(" waiting=");
            printWriter.println(this.f8233b.f8229a);
        }
        if (this.f8234c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            C0465n.m1482a(this.f8234c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            C0465n.m1481a(this.f8235d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
}
