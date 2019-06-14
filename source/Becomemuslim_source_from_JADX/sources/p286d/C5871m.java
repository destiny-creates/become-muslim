package p286d;

import java.io.IOException;

/* compiled from: Pipe */
/* renamed from: d.m */
public final class C5871m {
    /* renamed from: a */
    final long f19532a;
    /* renamed from: b */
    final C8037c f19533b = new C8037c();
    /* renamed from: c */
    boolean f19534c;
    /* renamed from: d */
    boolean f19535d;
    /* renamed from: e */
    private final C5875s f19536e = new C7213a(this);
    /* renamed from: f */
    private final C5876t f19537f = new C7214b(this);

    /* compiled from: Pipe */
    /* renamed from: d.m$a */
    final class C7213a implements C5875s {
        /* renamed from: a */
        final C5877u f25488a = new C5877u();
        /* renamed from: b */
        final /* synthetic */ C5871m f25489b;

        C7213a(C5871m c5871m) {
            this.f25489b = c5871m;
        }

        public void write(C8037c c8037c, long j) {
            synchronized (this.f25489b.f19533b) {
                if (this.f25489b.f19534c) {
                    throw new IllegalStateException("closed");
                }
                while (j > 0) {
                    if (this.f25489b.f19535d) {
                        throw new IOException("source is closed");
                    }
                    long a = this.f25489b.f19532a - this.f25489b.f19533b.m38961a();
                    if (a == 0) {
                        this.f25488a.waitUntilNotified(this.f25489b.f19533b);
                    } else {
                        long min = Math.min(a, j);
                        this.f25489b.f19533b.write(c8037c, min);
                        j -= min;
                        this.f25489b.f19533b.notifyAll();
                    }
                }
            }
        }

        public void flush() {
            synchronized (this.f25489b.f19533b) {
                if (this.f25489b.f19534c) {
                    throw new IllegalStateException("closed");
                }
                if (this.f25489b.f19535d) {
                    if (this.f25489b.f19533b.m38961a() > 0) {
                        throw new IOException("source is closed");
                    }
                }
            }
        }

        public void close() {
            synchronized (this.f25489b.f19533b) {
                if (this.f25489b.f19534c) {
                    return;
                }
                if (this.f25489b.f19535d) {
                    if (this.f25489b.f19533b.m38961a() > 0) {
                        throw new IOException("source is closed");
                    }
                }
                this.f25489b.f19534c = true;
                this.f25489b.f19533b.notifyAll();
            }
        }

        public C5877u timeout() {
            return this.f25488a;
        }
    }

    /* compiled from: Pipe */
    /* renamed from: d.m$b */
    final class C7214b implements C5876t {
        /* renamed from: a */
        final C5877u f25490a = new C5877u();
        /* renamed from: b */
        final /* synthetic */ C5871m f25491b;

        C7214b(C5871m c5871m) {
            this.f25491b = c5871m;
        }

        public long read(C8037c c8037c, long j) {
            synchronized (this.f25491b.f19533b) {
                if (this.f25491b.f19535d) {
                    throw new IllegalStateException("closed");
                }
                while (this.f25491b.f19533b.m38961a() == 0) {
                    if (this.f25491b.f19534c) {
                        return -1;
                    }
                    this.f25490a.waitUntilNotified(this.f25491b.f19533b);
                }
                c8037c = this.f25491b.f19533b.read(c8037c, j);
                this.f25491b.f19533b.notifyAll();
                return c8037c;
            }
        }

        public void close() {
            synchronized (this.f25491b.f19533b) {
                this.f25491b.f19535d = true;
                this.f25491b.f19533b.notifyAll();
            }
        }

        public C5877u timeout() {
            return this.f25490a;
        }
    }

    public C5871m(long j) {
        if (j >= 1) {
            this.f19532a = j;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxBufferSize < 1: ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    /* renamed from: a */
    public C5876t m24733a() {
        return this.f19537f;
    }

    /* renamed from: b */
    public C5875s m24734b() {
        return this.f19536e;
    }
}
