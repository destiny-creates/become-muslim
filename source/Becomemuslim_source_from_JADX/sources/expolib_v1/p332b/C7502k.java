package expolib_v1.p332b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
/* renamed from: expolib_v1.b.k */
public final class C7502k implements C6258s {
    /* renamed from: a */
    private final C7497e f26044a;
    /* renamed from: b */
    private final Inflater f26045b;
    /* renamed from: c */
    private int f26046c;
    /* renamed from: d */
    private boolean f26047d;

    C7502k(C7497e c7497e, Inflater inflater) {
        if (c7497e == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f26044a = c7497e;
            this.f26045b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public long read(C8170c c8170c, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f26047d != null) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            C6255o e;
            while (true) {
                j = m34075a();
                try {
                    e = c8170c.m39620e(1);
                    int inflate = this.f26045b.inflate(e.f20385a, e.f20387c, 8192 - e.f20387c);
                    if (inflate > 0) {
                        e.f20387c += inflate;
                        long j2 = (long) inflate;
                        c8170c.f30353b += j2;
                        return j2;
                    } else if (this.f26045b.finished()) {
                        break;
                    } else if (this.f26045b.needsDictionary()) {
                        break;
                    } else if (j != null) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (C8170c c8170c2) {
                    throw new IOException(c8170c2);
                }
            }
            m34074b();
            if (e.f20386b == e.f20387c) {
                c8170c2.f30352a = e.m25872a();
                C6256p.m25878a(e);
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean m34075a() {
        if (!this.f26045b.needsInput()) {
            return false;
        }
        m34074b();
        if (this.f26045b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f26044a.mo6382f()) {
            return true;
        } else {
            C6255o c6255o = this.f26044a.mo6372b().f30352a;
            this.f26046c = c6255o.f20387c - c6255o.f20386b;
            this.f26045b.setInput(c6255o.f20385a, c6255o.f20386b, this.f26046c);
            return false;
        }
    }

    /* renamed from: b */
    private void m34074b() {
        if (this.f26046c != 0) {
            int remaining = this.f26046c - this.f26045b.getRemaining();
            this.f26046c -= remaining;
            this.f26044a.mo6387h((long) remaining);
        }
    }

    public C6259t timeout() {
        return this.f26044a.timeout();
    }

    public void close() {
        if (!this.f26047d) {
            this.f26045b.end();
            this.f26047d = true;
            this.f26044a.close();
        }
    }
}
