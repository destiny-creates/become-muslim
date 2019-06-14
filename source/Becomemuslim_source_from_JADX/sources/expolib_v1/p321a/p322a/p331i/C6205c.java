package expolib_v1.p321a.p322a.p331i;

import com.facebook.imageutils.JfifUtil;
import com.facebook.internal.Utility;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* compiled from: WebSocketReader */
/* renamed from: expolib_v1.a.a.i.c */
final class C6205c {
    /* renamed from: a */
    final boolean f20064a;
    /* renamed from: b */
    final C7497e f20065b;
    /* renamed from: c */
    final C6204a f20066c;
    /* renamed from: d */
    boolean f20067d;
    /* renamed from: e */
    int f20068e;
    /* renamed from: f */
    long f20069f;
    /* renamed from: g */
    long f20070g;
    /* renamed from: h */
    boolean f20071h;
    /* renamed from: i */
    boolean f20072i;
    /* renamed from: j */
    boolean f20073j;
    /* renamed from: k */
    final byte[] f20074k = new byte[4];
    /* renamed from: l */
    final byte[] f20075l = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];

    /* compiled from: WebSocketReader */
    /* renamed from: expolib_v1.a.a.i.c$a */
    public interface C6204a {
        /* renamed from: b */
        void mo5308b(int i, String str);

        /* renamed from: b */
        void mo5309b(C6251f c6251f);

        /* renamed from: b */
        void mo5310b(String str);

        /* renamed from: c */
        void mo5311c(C6251f c6251f);

        /* renamed from: d */
        void mo5312d(C6251f c6251f);
    }

    C6205c(boolean z, C7497e c7497e, C6204a c6204a) {
        if (c7497e == null) {
            throw new NullPointerException("source == null");
        } else if (c6204a != null) {
            this.f20064a = z;
            this.f20065b = c7497e;
            this.f20066c = c6204a;
        } else {
            throw new NullPointerException("frameCallback == null");
        }
    }

    /* renamed from: a */
    void m25539a() {
        m25536c();
        if (this.f20072i) {
            m25537d();
        } else {
            m25538e();
        }
    }

    /* renamed from: c */
    private void m25536c() {
        if (this.f20067d) {
            throw new IOException("closed");
        }
        long N_ = this.f20065b.timeout().N_();
        this.f20065b.timeout().P_();
        try {
            int i = this.f20065b.mo6388i() & JfifUtil.MARKER_FIRST_BYTE;
            this.f20071h = N_ != null;
            this.f20072i = (i & 8) != 0;
            if (this.f20072i) {
                if (!this.f20071h) {
                    throw new ProtocolException("Control frames must be final.");
                }
            }
            Object obj = (i & 64) != 0 ? 1 : null;
            Object obj2 = (i & 32) != 0 ? 1 : null;
            Object obj3 = (i & 16) != 0 ? 1 : null;
            if (obj == null && obj2 == null && obj3 == null) {
                int i2 = this.f20065b.mo6388i() & JfifUtil.MARKER_FIRST_BYTE;
                if ((i2 & 128) != 0) {
                }
                this.f20073j = true;
                if (this.f20073j == this.f20064a) {
                    throw new ProtocolException(this.f20064a ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                }
                this.f20069f = (long) (i2 & 127);
                if (this.f20069f == 126) {
                    this.f20069f = ((long) this.f20065b.mo6390j()) & 65535;
                } else if (this.f20069f == 127) {
                    this.f20069f = this.f20065b.mo6392l();
                    if (this.f20069f < 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Frame length 0x");
                        stringBuilder.append(Long.toHexString(this.f20069f));
                        stringBuilder.append(" > 0x7FFFFFFFFFFFFFFF");
                        throw new ProtocolException(stringBuilder.toString());
                    }
                }
                this.f20070g = 0;
                if (this.f20072i) {
                    if (this.f20069f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    }
                }
                if (this.f20073j) {
                    this.f20065b.mo6375b(this.f20074k);
                    return;
                }
                return;
            }
            throw new ProtocolException("Reserved flags are unsupported.");
        } finally {
            this.f20065b.timeout().mo5349a(N_, TimeUnit.NANOSECONDS);
        }
    }

    /* renamed from: d */
    private void m25537d() {
        int a;
        C8170c c8170c = new C8170c();
        if (this.f20070g < this.f20069f) {
            if (this.f20064a) {
                this.f20065b.mo6374b(c8170c, this.f20069f);
            } else {
                while (this.f20070g < this.f20069f) {
                    a = this.f20065b.mo6365a(this.f20075l, 0, (int) Math.min(this.f20069f - this.f20070g, (long) this.f20075l.length));
                    if (a != -1) {
                        long j = (long) a;
                        C6203b.m25528a(this.f20075l, j, this.f20074k, this.f20070g);
                        c8170c.m39605b(this.f20075l, 0, a);
                        this.f20070g += j;
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }
        switch (this.f20068e) {
            case 8:
                a = 1005;
                String str = "";
                long a2 = c8170c.m39582a();
                if (a2 != 1) {
                    if (a2 != 0) {
                        a = c8170c.mo6390j();
                        str = c8170c.mo6400r();
                        String a3 = C6203b.m25527a(a);
                        if (a3 != null) {
                            throw new ProtocolException(a3);
                        }
                    }
                    this.f20066c.mo5308b(a, str);
                    this.f20067d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f20066c.mo5311c(c8170c.m39646q());
                return;
            case 10:
                this.f20066c.mo5312d(c8170c.m39646q());
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown control opcode: ");
                stringBuilder.append(Integer.toHexString(this.f20068e));
                throw new ProtocolException(stringBuilder.toString());
        }
    }

    /* renamed from: e */
    private void m25538e() {
        int i = this.f20068e;
        if (i != 1) {
            if (i != 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown opcode: ");
                stringBuilder.append(Integer.toHexString(i));
                throw new ProtocolException(stringBuilder.toString());
            }
        }
        C8170c c8170c = new C8170c();
        m25535a(c8170c);
        if (i == 1) {
            this.f20066c.mo5310b(c8170c.mo6400r());
        } else {
            this.f20066c.mo5309b(c8170c.m39646q());
        }
    }

    /* renamed from: b */
    void m25540b() {
        while (!this.f20067d) {
            m25536c();
            if (this.f20072i) {
                m25537d();
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m25535a(C8170c c8170c) {
        while (!this.f20067d) {
            long a;
            if (this.f20070g == this.f20069f) {
                if (!this.f20071h) {
                    m25540b();
                    if (this.f20068e != 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Expected continuation opcode. Got: ");
                        stringBuilder.append(Integer.toHexString(this.f20068e));
                        throw new ProtocolException(stringBuilder.toString());
                    } else if (this.f20071h && this.f20069f == 0) {
                        return;
                    }
                }
                return;
            }
            long j = this.f20069f - this.f20070g;
            if (this.f20073j) {
                a = (long) this.f20065b.mo6365a(this.f20075l, 0, (int) Math.min(j, (long) this.f20075l.length));
                if (a != -1) {
                    C6203b.m25528a(this.f20075l, a, this.f20074k, this.f20070g);
                    c8170c.m39605b(this.f20075l, 0, (int) a);
                } else {
                    throw new EOFException();
                }
            }
            a = this.f20065b.read(c8170c, j);
            if (a == -1) {
                throw new EOFException();
            }
            this.f20070g += a;
        }
        throw new IOException("closed");
    }
}
