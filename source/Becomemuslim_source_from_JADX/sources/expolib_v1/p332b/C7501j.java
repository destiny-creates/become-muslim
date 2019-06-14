package expolib_v1.p332b;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
/* renamed from: expolib_v1.b.j */
public final class C7501j implements C6258s {
    /* renamed from: a */
    private int f26039a = 0;
    /* renamed from: b */
    private final C7497e f26040b;
    /* renamed from: c */
    private final Inflater f26041c;
    /* renamed from: d */
    private final C7502k f26042d;
    /* renamed from: e */
    private final CRC32 f26043e = new CRC32();

    public C7501j(C6258s c6258s) {
        if (c6258s != null) {
            this.f26041c = new Inflater(true);
            this.f26040b = C6252l.m25859a(c6258s);
            this.f26042d = new C7502k(this.f26040b, this.f26041c);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long read(C8170c c8170c, long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i == 0) {
            return 0;
        } else {
            if (this.f26039a == 0) {
                m34070a();
                this.f26039a = 1;
            }
            if (this.f26039a == 1) {
                long j2 = c8170c.f30353b;
                j = this.f26042d.read(c8170c, j);
                if (j != -1) {
                    m34071a(c8170c, j2, j);
                    return j;
                }
                this.f26039a = 2;
            }
            if (this.f26039a == 2) {
                m34073b();
                this.f26039a = 3;
                if (this.f26040b.mo6382f() == null) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    /* renamed from: a */
    private void m34070a() {
        this.f26040b.mo6370a(10);
        byte b = this.f26040b.mo6372b().m39601b(3);
        Object obj = ((b >> 1) & 1) == 1 ? 1 : null;
        if (obj != null) {
            m34071a(r6.f26040b.mo6372b(), 0, 10);
        }
        m34072a("ID1ID2", 8075, r6.f26040b.mo6390j());
        r6.f26040b.mo6387h(8);
        if (((b >> 2) & 1) == 1) {
            r6.f26040b.mo6370a(2);
            if (obj != null) {
                m34071a(r6.f26040b.mo6372b(), 0, 2);
            }
            long m = (long) r6.f26040b.mo6372b().mo6395m();
            r6.f26040b.mo6370a(m);
            if (obj != null) {
                m34071a(r6.f26040b.mo6372b(), 0, m);
            }
            r6.f26040b.mo6387h(m);
        }
        if (((b >> 3) & 1) == 1) {
            long a = r6.f26040b.mo6366a((byte) 0);
            if (a != -1) {
                if (obj != null) {
                    m34071a(r6.f26040b.mo6372b(), 0, a + 1);
                }
                r6.f26040b.mo6387h(a + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((b >> 4) & 1) == 1) {
            long a2 = r6.f26040b.mo6366a((byte) 0);
            if (a2 != -1) {
                if (obj != null) {
                    m34071a(r6.f26040b.mo6372b(), 0, a2 + 1);
                }
                r6.f26040b.mo6387h(a2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (obj != null) {
            m34072a("FHCRC", r6.f26040b.mo6395m(), (short) ((int) r6.f26043e.getValue()));
            r6.f26043e.reset();
        }
    }

    /* renamed from: b */
    private void m34073b() {
        m34072a("CRC", this.f26040b.mo6396n(), (int) this.f26043e.getValue());
        m34072a("ISIZE", this.f26040b.mo6396n(), (int) this.f26041c.getBytesWritten());
    }

    public C6259t timeout() {
        return this.f26040b.timeout();
    }

    public void close() {
        this.f26042d.close();
    }

    /* renamed from: a */
    private void m34071a(C8170c c8170c, long j, long j2) {
        c8170c = c8170c.f30352a;
        while (j >= ((long) (c8170c.f20387c - c8170c.f20386b))) {
            j -= (long) (c8170c.f20387c - c8170c.f20386b);
            c8170c = c8170c.f20390f;
        }
        while (j2 > 0) {
            j = (int) (((long) c8170c.f20386b) + j);
            int min = (int) Math.min((long) (c8170c.f20387c - j), j2);
            this.f26043e.update(c8170c.f20385a, j, min);
            j2 -= (long) min;
            c8170c = c8170c.f20390f;
            j = 0;
        }
    }

    /* renamed from: a */
    private void m34072a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
