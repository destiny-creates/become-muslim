package p286d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
/* renamed from: d.k */
public final class C7209k implements C5876t {
    /* renamed from: a */
    private final C7204e f25480a;
    /* renamed from: b */
    private final Inflater f25481b;
    /* renamed from: c */
    private int f25482c;
    /* renamed from: d */
    private boolean f25483d;

    C7209k(C7204e c7204e, Inflater inflater) {
        if (c7204e == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater != null) {
            this.f25480a = c7204e;
            this.f25481b = inflater;
        } else {
            throw new IllegalArgumentException("inflater == null");
        }
    }

    public long read(C8037c c8037c, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.f25483d) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            C5873p e;
            while (true) {
                boolean a = m33462a();
                try {
                    e = c8037c.m38995e(1);
                    i = this.f25481b.inflate(e.f19539a, e.f19541c, (int) Math.min(j, (long) (8192 - e.f19541c)));
                    if (i > 0) {
                        e.f19541c += i;
                        long j2 = (long) i;
                        c8037c.f29839b += j2;
                        return j2;
                    } else if (this.f25481b.finished()) {
                        break;
                    } else if (this.f25481b.needsDictionary()) {
                        break;
                    } else if (a) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (C8037c c8037c2) {
                    throw new IOException(c8037c2);
                }
            }
            m33461b();
            if (e.f19540b == e.f19541c) {
                c8037c2.f29838a = e.m24740c();
                C5874q.m24743a(e);
            }
            return -1;
        }
    }

    /* renamed from: a */
    public boolean m33462a() {
        if (!this.f25481b.needsInput()) {
            return false;
        }
        m33461b();
        if (this.f25481b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        } else if (this.f25480a.mo6300e()) {
            return true;
        } else {
            C5873p c5873p = this.f25480a.mo6292b().f29838a;
            this.f25482c = c5873p.f19541c - c5873p.f19540b;
            this.f25481b.setInput(c5873p.f19539a, c5873p.f19540b, this.f25482c);
            return false;
        }
    }

    /* renamed from: b */
    private void m33461b() {
        if (this.f25482c != 0) {
            int remaining = this.f25482c - this.f25481b.getRemaining();
            this.f25482c -= remaining;
            this.f25480a.mo6309i((long) remaining);
        }
    }

    public C5877u timeout() {
        return this.f25480a.timeout();
    }

    public void close() {
        if (!this.f25483d) {
            this.f25481b.end();
            this.f25483d = true;
            this.f25480a.close();
        }
    }
}
