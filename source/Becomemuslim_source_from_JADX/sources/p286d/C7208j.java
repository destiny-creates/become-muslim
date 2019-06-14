package p286d;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
/* renamed from: d.j */
public final class C7208j implements C5876t {
    /* renamed from: a */
    private int f25475a = 0;
    /* renamed from: b */
    private final C7204e f25476b;
    /* renamed from: c */
    private final Inflater f25477c;
    /* renamed from: d */
    private final C7209k f25478d;
    /* renamed from: e */
    private final CRC32 f25479e = new CRC32();

    public C7208j(C5876t c5876t) {
        if (c5876t != null) {
            this.f25477c = new Inflater(true);
            this.f25476b = C5870l.m24720a(c5876t);
            this.f25478d = new C7209k(this.f25476b, this.f25477c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long read(C8037c c8037c, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f25475a == 0) {
                m33457a();
                this.f25475a = 1;
            }
            if (this.f25475a == 1) {
                long j2 = c8037c.f29839b;
                j = this.f25478d.read(c8037c, j);
                if (j != -1) {
                    m33458a(c8037c, j2, j);
                    return j;
                }
                this.f25475a = 2;
            }
            if (this.f25475a == 2) {
                m33460b();
                this.f25475a = 3;
                if (this.f25476b.mo6300e() == null) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    private void m33457a() {
        this.f25476b.mo6288a(10);
        byte c = this.f25476b.mo6292b().m38987c(3);
        Object obj = ((c >> 1) & 1) == 1 ? 1 : null;
        if (obj != null) {
            m33458a(r6.f25476b.mo6292b(), 0, 10);
        }
        m33459a("ID1ID2", 8075, r6.f25476b.mo6308i());
        r6.f25476b.mo6309i(8);
        if (((c >> 2) & 1) == 1) {
            r6.f25476b.mo6288a(2);
            if (obj != null) {
                m33458a(r6.f25476b.mo6292b(), 0, 2);
            }
            long l = (long) r6.f25476b.mo6292b().mo6312l();
            r6.f25476b.mo6288a(l);
            if (obj != null) {
                m33458a(r6.f25476b.mo6292b(), 0, l);
            }
            r6.f25476b.mo6309i(l);
        }
        if (((c >> 3) & 1) == 1) {
            long a = r6.f25476b.mo6285a((byte) 0);
            if (a != -1) {
                if (obj != null) {
                    m33458a(r6.f25476b.mo6292b(), 0, a + 1);
                }
                r6.f25476b.mo6309i(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((c >> 4) & 1) == 1) {
            long a2 = r6.f25476b.mo6285a((byte) 0);
            if (a2 != -1) {
                if (obj != null) {
                    m33458a(r6.f25476b.mo6292b(), 0, a2 + 1);
                }
                r6.f25476b.mo6309i(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (obj != null) {
            m33459a("FHCRC", r6.f25476b.mo6312l(), (short) ((int) r6.f25479e.getValue()));
            r6.f25479e.reset();
        }
    }

    /* renamed from: b */
    private void m33460b() {
        m33459a("CRC", this.f25476b.mo6313m(), (int) this.f25479e.getValue());
        m33459a("ISIZE", this.f25476b.mo6313m(), (int) this.f25477c.getBytesWritten());
    }

    public C5877u timeout() {
        return this.f25476b.timeout();
    }

    public void close() {
        this.f25478d.close();
    }

    /* renamed from: a */
    private void m33458a(C8037c c8037c, long j, long j2) {
        c8037c = c8037c.f29838a;
        while (j >= ((long) (c8037c.f19541c - c8037c.f19540b))) {
            j -= (long) (c8037c.f19541c - c8037c.f19540b);
            c8037c = c8037c.f19544f;
        }
        while (j2 > 0) {
            j = (int) (((long) c8037c.f19540b) + j);
            int min = (int) Math.min((long) (c8037c.f19541c - j), j2);
            this.f25479e.update(c8037c.f19539a, j, min);
            j2 -= (long) min;
            c8037c = c8037c.f19544f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m33459a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
