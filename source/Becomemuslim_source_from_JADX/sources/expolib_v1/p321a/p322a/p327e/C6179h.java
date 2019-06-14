package expolib_v1.p321a.p322a.p327e;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p327e.C6173d.C6171a;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C6259t;
import expolib_v1.p332b.C7497e;
import expolib_v1.p332b.C8170c;
import java.io.Closeable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Reader */
/* renamed from: expolib_v1.a.a.e.h */
final class C6179h implements Closeable {
    /* renamed from: a */
    static final Logger f19994a = Logger.getLogger(C6174e.class.getName());
    /* renamed from: b */
    final C6171a f19995b = new C6171a(4096, this.f19997d);
    /* renamed from: c */
    private final C7497e f19996c;
    /* renamed from: d */
    private final C7462a f19997d = new C7462a(this.f19996c);
    /* renamed from: e */
    private final boolean f19998e;

    /* compiled from: Http2Reader */
    /* renamed from: expolib_v1.a.a.e.h$b */
    interface C6178b {
        /* renamed from: a */
        void mo5269a();

        /* renamed from: a */
        void mo5270a(int i, int i2, int i3, boolean z);

        /* renamed from: a */
        void mo5271a(int i, int i2, List<C6170c> list);

        /* renamed from: a */
        void mo5272a(int i, long j);

        /* renamed from: a */
        void mo5273a(int i, C6169b c6169b);

        /* renamed from: a */
        void mo5274a(int i, C6169b c6169b, C6251f c6251f);

        /* renamed from: a */
        void mo5275a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo5276a(boolean z, int i, int i2, List<C6170c> list);

        /* renamed from: a */
        void mo5277a(boolean z, int i, C7497e c7497e, int i2);

        /* renamed from: a */
        void mo5278a(boolean z, C6186n c6186n);
    }

    /* compiled from: Http2Reader */
    /* renamed from: expolib_v1.a.a.e.h$a */
    static final class C7462a implements C6258s {
        /* renamed from: a */
        int f25890a;
        /* renamed from: b */
        byte f25891b;
        /* renamed from: c */
        int f25892c;
        /* renamed from: d */
        int f25893d;
        /* renamed from: e */
        short f25894e;
        /* renamed from: f */
        private final C7497e f25895f;

        public void close() {
        }

        public C7462a(C7497e c7497e) {
            this.f25895f = c7497e;
        }

        public long read(C8170c c8170c, long j) {
            while (this.f25893d == 0) {
                this.f25895f.mo6387h((long) this.f25894e);
                this.f25894e = (short) 0;
                if ((this.f25891b & 4) != 0) {
                    return -1;
                }
                m33883a();
            }
            c8170c = this.f25895f.read(c8170c, Math.min(j, (long) this.f25893d));
            if (c8170c == -1) {
                return -1;
            }
            this.f25893d = (int) (((long) this.f25893d) - c8170c);
            return c8170c;
        }

        public C6259t timeout() {
            return this.f25895f.timeout();
        }

        /* renamed from: a */
        private void m33883a() {
            int i = this.f25892c;
            int a = C6179h.m25401a(this.f25895f);
            this.f25893d = a;
            this.f25890a = a;
            byte i2 = (byte) (this.f25895f.mo6388i() & JfifUtil.MARKER_FIRST_BYTE);
            this.f25891b = (byte) (this.f25895f.mo6388i() & JfifUtil.MARKER_FIRST_BYTE);
            if (C6179h.f19994a.isLoggable(Level.FINE)) {
                C6179h.f19994a.fine(C6174e.m25359a(true, this.f25892c, this.f25890a, i2, this.f25891b));
            }
            this.f25892c = this.f25895f.mo6391k() & Integer.MAX_VALUE;
            if (i2 != (byte) 9) {
                throw C6174e.m25360b("%s != TYPE_CONTINUATION", Byte.valueOf(i2));
            } else if (this.f25892c != i) {
                throw C6174e.m25360b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    public C6179h(C7497e c7497e, boolean z) {
        this.f19996c = c7497e;
        this.f19998e = z;
    }

    /* renamed from: a */
    public void m25413a(C6178b c6178b) {
        if (!this.f19998e) {
            c6178b = this.f19996c.mo6378c((long) C6174e.f19960a.mo5366h());
            if (f19994a.isLoggable(Level.FINE)) {
                f19994a.fine(C6165c.m25308a("<< CONNECTION %s", c6178b.mo5364f()));
            }
            if (!C6174e.f19960a.equals(c6178b)) {
                throw C6174e.m25360b("Expected a connection header but was %s", c6178b.mo5355a());
            }
        } else if (m25414a(true, c6178b) == null) {
            throw C6174e.m25360b("Required SETTINGS preface not received", new Object[0]);
        }
    }

    /* renamed from: a */
    public boolean m25414a(boolean r7, expolib_v1.p321a.p322a.p327e.C6179h.C6178b r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.f19996c;	 Catch:{ IOException -> 0x0096 }
        r2 = 9;	 Catch:{ IOException -> 0x0096 }
        r1.mo6370a(r2);	 Catch:{ IOException -> 0x0096 }
        r1 = r6.f19996c;
        r1 = expolib_v1.p321a.p322a.p327e.C6179h.m25401a(r1);
        r2 = 1;
        if (r1 < 0) goto L_0x0087;
    L_0x0011:
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        if (r1 > r3) goto L_0x0087;
    L_0x0015:
        r3 = r6.f19996c;
        r3 = r3.mo6388i();
        r3 = r3 & 255;
        r3 = (byte) r3;
        if (r7 == 0) goto L_0x0033;
    L_0x0020:
        r7 = 4;
        if (r3 != r7) goto L_0x0024;
    L_0x0023:
        goto L_0x0033;
    L_0x0024:
        r7 = new java.lang.Object[r2];
        r8 = java.lang.Byte.valueOf(r3);
        r7[r0] = r8;
        r8 = "Expected a SETTINGS frame but was %s";
        r7 = expolib_v1.p321a.p322a.p327e.C6174e.m25360b(r8, r7);
        throw r7;
    L_0x0033:
        r7 = r6.f19996c;
        r7 = r7.mo6388i();
        r7 = r7 & 255;
        r7 = (byte) r7;
        r0 = r6.f19996c;
        r0 = r0.mo6391k();
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r0 = r0 & r4;
        r4 = f19994a;
        r5 = java.util.logging.Level.FINE;
        r4 = r4.isLoggable(r5);
        if (r4 == 0) goto L_0x0059;
    L_0x0050:
        r4 = f19994a;
        r5 = expolib_v1.p321a.p322a.p327e.C6174e.m25359a(r2, r0, r1, r3, r7);
        r4.fine(r5);
    L_0x0059:
        switch(r3) {
            case 0: goto L_0x0083;
            case 1: goto L_0x007f;
            case 2: goto L_0x007b;
            case 3: goto L_0x0077;
            case 4: goto L_0x0073;
            case 5: goto L_0x006f;
            case 6: goto L_0x006b;
            case 7: goto L_0x0067;
            case 8: goto L_0x0063;
            default: goto L_0x005c;
        };
    L_0x005c:
        r7 = r6.f19996c;
        r0 = (long) r1;
        r7.mo6387h(r0);
        goto L_0x0086;
    L_0x0063:
        r6.m25412i(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0067:
        r6.m25411h(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x006b:
        r6.m25410g(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x006f:
        r6.m25409f(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0073:
        r6.m25408e(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0077:
        r6.m25407d(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x007b:
        r6.m25406c(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x007f:
        r6.m25404a(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0083:
        r6.m25405b(r8, r1, r7, r0);
    L_0x0086:
        return r2;
    L_0x0087:
        r7 = new java.lang.Object[r2];
        r8 = java.lang.Integer.valueOf(r1);
        r7[r0] = r8;
        r8 = "FRAME_SIZE_ERROR: %s";
        r7 = expolib_v1.p321a.p322a.p327e.C6174e.m25360b(r8, r7);
        throw r7;
    L_0x0096:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: expolib_v1.a.a.e.h.a(boolean, expolib_v1.a.a.e.h$b):boolean");
    }

    /* renamed from: a */
    private void m25404a(C6178b c6178b, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.f19996c.mo6388i() & JfifUtil.MARKER_FIRST_BYTE);
            }
            if ((b & 32) != 0) {
                m25403a(c6178b, i2);
                i -= 5;
            }
            c6178b.mo5276a(z, i2, (int) (byte) -1, m25402a(C6179h.m25400a(i, b, s), s, b, i2));
            return;
        }
        throw C6174e.m25360b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    /* renamed from: a */
    private List<C6170c> m25402a(int i, short s, byte b, int i2) {
        C7462a c7462a = this.f19997d;
        this.f19997d.f25893d = i;
        c7462a.f25890a = i;
        this.f19997d.f25894e = s;
        this.f19997d.f25891b = b;
        this.f19997d.f25892c = i2;
        this.f19995b.m25344a();
        return this.f19995b.m25345b();
    }

    /* renamed from: b */
    private void m25405b(C6178b c6178b, int i, byte b, int i2) {
        Object obj = 1;
        short s = (short) 0;
        boolean z = (b & 1) != 0;
        if ((b & 32) == 0) {
            obj = null;
        }
        if (obj == null) {
            if ((b & 8) != 0) {
                s = (short) (this.f19996c.mo6388i() & JfifUtil.MARKER_FIRST_BYTE);
            }
            c6178b.mo5277a(z, i2, this.f19996c, C6179h.m25400a(i, b, s));
            this.f19996c.mo6387h((long) s);
            return;
        }
        throw C6174e.m25360b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    }

    /* renamed from: c */
    private void m25406c(C6178b c6178b, int i, byte b, int i2) {
        if (i != 5) {
            throw C6174e.m25360b("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(i)});
        } else if (i2 != 0) {
            m25403a(c6178b, i2);
        } else {
            throw C6174e.m25360b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    /* renamed from: a */
    private void m25403a(C6178b c6178b, int i) {
        int k = this.f19996c.mo6391k();
        c6178b.mo5270a(i, k & Integer.MAX_VALUE, (this.f19996c.mo6388i() & JfifUtil.MARKER_FIRST_BYTE) + 1, (LinearLayoutManager.INVALID_OFFSET & k) != 0);
    }

    /* renamed from: d */
    private void m25407d(C6178b c6178b, int i, byte b, int i2) {
        if (i != 4) {
            throw C6174e.m25360b("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(i)});
        } else if (i2 != 0) {
            C6169b a = C6169b.m25329a(this.f19996c.mo6391k());
            if (a != null) {
                c6178b.mo5273a(i2, a);
            } else {
                throw C6174e.m25360b("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(i)});
            }
        } else {
            throw C6174e.m25360b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m25408e(C6178b c6178b, int i, byte b, int i2) {
        if (i2 != 0) {
            throw C6174e.m25360b("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & (byte) 1) != (byte) 0) {
            if (i == 0) {
                c6178b.mo5269a();
            } else {
                throw C6174e.m25360b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
        } else if (i % 6 == (byte) 0) {
            C6186n c6186n = new C6186n();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int j = this.f19996c.mo6390j();
                int k = this.f19996c.mo6391k();
                switch (j) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (k == 0) {
                            continue;
                        } else if (k == 1) {
                            break;
                        } else {
                            throw C6174e.m25360b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        j = 4;
                        break;
                    case 4:
                        j = 7;
                        if (k >= 0) {
                            break;
                        }
                        throw C6174e.m25360b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    case 5:
                        if (k >= 16384 && k <= 16777215) {
                            break;
                        }
                        throw C6174e.m25360b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(k)});
                        break;
                    default:
                        break;
                }
                c6186n.m25464a(j, k);
            }
            c6178b.mo5278a(false, c6186n);
        } else {
            throw C6174e.m25360b("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(i)});
        }
    }

    /* renamed from: f */
    private void m25409f(C6178b c6178b, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.f19996c.mo6388i() & JfifUtil.MARKER_FIRST_BYTE);
            }
            c6178b.mo5271a(i2, this.f19996c.mo6391k() & Integer.MAX_VALUE, m25402a(C6179h.m25400a(i - 4, b, s), s, b, i2));
            return;
        }
        throw C6174e.m25360b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    /* renamed from: g */
    private void m25410g(C6178b c6178b, int i, byte b, int i2) {
        boolean z = false;
        if (i != 8) {
            throw C6174e.m25360b("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(i)});
        } else if (i2 == 0) {
            i = this.f19996c.mo6391k();
            i2 = this.f19996c.mo6391k();
            if ((b & (byte) 1) != (byte) 0) {
                z = true;
            }
            c6178b.mo5275a(z, i, i2);
        } else {
            throw C6174e.m25360b("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    /* renamed from: h */
    private void m25411h(C6178b c6178b, int i, byte b, int i2) {
        if (i < 8) {
            throw C6174e.m25360b("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(i)});
        } else if (i2 == 0) {
            i2 = this.f19996c.mo6391k();
            i -= 8;
            C6169b a = C6169b.m25329a(this.f19996c.mo6391k());
            if (a != null) {
                C6251f c6251f = C6251f.f20378b;
                if (i > 0) {
                    c6251f = this.f19996c.mo6378c((long) i);
                }
                c6178b.mo5274a(i2, a, c6251f);
                return;
            }
            throw C6174e.m25360b("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(r2)});
        } else {
            throw C6174e.m25360b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    /* renamed from: i */
    private void m25412i(C6178b c6178b, int i, byte b, int i2) {
        if (i == 4) {
            long k = ((long) this.f19996c.mo6391k()) & 2147483647L;
            if (k != 0) {
                c6178b.mo5272a(i2, k);
                return;
            } else {
                throw C6174e.m25360b("windowSizeIncrement was 0", new Object[]{Long.valueOf(k)});
            }
        }
        throw C6174e.m25360b("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(i)});
    }

    public void close() {
        this.f19996c.close();
    }

    /* renamed from: a */
    static int m25401a(C7497e c7497e) {
        return (c7497e.mo6388i() & JfifUtil.MARKER_FIRST_BYTE) | (((c7497e.mo6388i() & JfifUtil.MARKER_FIRST_BYTE) << 16) | ((c7497e.mo6388i() & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    /* renamed from: a */
    static int m25400a(int i, byte b, short s) {
        if ((b & 8) != (byte) 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw C6174e.m25360b("PROTOCOL_ERROR padding %s > remaining length %s", new Object[]{Short.valueOf(s), Integer.valueOf(s2)});
    }
}
