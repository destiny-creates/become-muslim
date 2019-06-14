package expolib_v1.p321a.p322a.p327e;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p327e.C6173d.C6172b;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C8170c;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Http2Writer */
/* renamed from: expolib_v1.a.a.e.j */
final class C6181j implements Closeable {
    /* renamed from: b */
    private static final Logger f20012b = Logger.getLogger(C6174e.class.getName());
    /* renamed from: a */
    final C6172b f20013a = new C6172b(this.f20016e);
    /* renamed from: c */
    private final C7496d f20014c;
    /* renamed from: d */
    private final boolean f20015d;
    /* renamed from: e */
    private final C8170c f20016e = new C8170c();
    /* renamed from: f */
    private int f20017f = 16384;
    /* renamed from: g */
    private boolean f20018g;

    public C6181j(C7496d c7496d, boolean z) {
        this.f20014c = c7496d;
        this.f20015d = z;
    }

    /* renamed from: a */
    public synchronized void m25436a() {
        if (this.f20018g) {
            throw new IOException("closed");
        } else if (this.f20015d) {
            if (f20012b.isLoggable(Level.FINE)) {
                f20012b.fine(C6165c.m25308a(">> CONNECTION %s", C6174e.f19960a.mo5364f()));
            }
            this.f20014c.mo6380d(C6174e.f19960a.mo5368i());
            this.f20014c.flush();
        }
    }

    /* renamed from: a */
    public synchronized void m25443a(C6186n c6186n) {
        if (this.f20018g) {
            throw new IOException("closed");
        }
        this.f20017f = c6186n.m25473d(this.f20017f);
        if (c6186n.m25470c() != -1) {
            this.f20013a.m25351a(c6186n.m25470c());
        }
        m25438a(0, 0, (byte) 4, (byte) 1);
        this.f20014c.flush();
    }

    /* renamed from: a */
    public synchronized void m25439a(int i, int i2, List<C6170c> list) {
        if (this.f20018g) {
            throw new IOException("closed");
        }
        this.f20013a.m25354a((List) list);
        long a = this.f20016e.m39582a();
        list = (int) Math.min((long) (this.f20017f - 4), a);
        long j = (long) list;
        int i3 = (a > j ? 1 : (a == j ? 0 : -1));
        m25438a(i, list + 4, (byte) 5, i3 == 0 ? (byte) 4 : (byte) 0);
        this.f20014c.mo6383g(i2 & Integer.MAX_VALUE);
        this.f20014c.mo5257a(this.f20016e, j);
        if (i3 > 0) {
            m25435b(i, a - j);
        }
    }

    /* renamed from: b */
    public synchronized void m25448b() {
        if (this.f20018g) {
            throw new IOException("closed");
        }
        this.f20014c.flush();
    }

    /* renamed from: a */
    public synchronized void m25445a(boolean z, int i, int i2, List<C6170c> list) {
        if (this.f20018g == 0) {
            m25447a(z, i, (List) list);
        } else {
            throw new IOException("closed");
        }
    }

    /* renamed from: a */
    public synchronized void m25441a(int i, C6169b c6169b) {
        if (this.f20018g) {
            throw new IOException("closed");
        } else if (c6169b.f19930g != -1) {
            m25438a(i, 4, (byte) 3, (byte) 0);
            this.f20014c.mo6383g(c6169b.f19930g);
            this.f20014c.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: c */
    public int m25450c() {
        return this.f20017f;
    }

    /* renamed from: a */
    public synchronized void m25446a(boolean z, int i, C8170c c8170c, int i2) {
        if (this.f20018g) {
            throw new IOException("closed");
        }
        byte b = (byte) 0;
        if (z) {
            b = (byte) true;
        }
        m25437a(i, b, c8170c, i2);
    }

    /* renamed from: a */
    void m25437a(int i, byte b, C8170c c8170c, int i2) {
        m25438a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f20014c.mo5257a(c8170c, (long) i2);
        }
    }

    /* renamed from: b */
    public synchronized void m25449b(C6186n c6186n) {
        if (this.f20018g) {
            throw new IOException("closed");
        }
        int i = (byte) 0;
        m25438a(0, c6186n.m25468b() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (c6186n.m25467a(i)) {
                int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                this.f20014c.mo6386h(i2);
                this.f20014c.mo6383g(c6186n.m25469b(i));
            }
            i++;
        }
        this.f20014c.flush();
    }

    /* renamed from: a */
    public synchronized void m25444a(boolean z, int i, int i2) {
        if (this.f20018g) {
            throw new IOException("closed");
        }
        m25438a(0, 8, (byte) 6, (byte) z);
        this.f20014c.mo6383g(i);
        this.f20014c.mo6383g(i2);
        this.f20014c.flush();
    }

    /* renamed from: a */
    public synchronized void m25442a(int i, C6169b c6169b, byte[] bArr) {
        if (this.f20018g) {
            throw new IOException("closed");
        } else if (c6169b.f19930g != -1) {
            m25438a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f20014c.mo6383g(i);
            this.f20014c.mo6383g(c6169b.f19930g);
            if (bArr.length > 0) {
                this.f20014c.mo6380d(bArr);
            }
            this.f20014c.flush();
        } else {
            throw C6174e.m25357a("errorCode.httpCode == -1", new Object[0]);
        }
    }

    /* renamed from: a */
    public synchronized void m25440a(int i, long j) {
        if (this.f20018g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw C6174e.m25357a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            m25438a(i, 4, (byte) 8, (byte) 0);
            this.f20014c.mo6383g((int) j);
            this.f20014c.flush();
        }
    }

    /* renamed from: a */
    public void m25438a(int i, int i2, byte b, byte b2) {
        if (f20012b.isLoggable(Level.FINE)) {
            f20012b.fine(C6174e.m25359a(false, i, i2, b, b2));
        }
        if (i2 > this.f20017f) {
            throw C6174e.m25357a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f20017f), Integer.valueOf(i2));
        } else if ((LinearLayoutManager.INVALID_OFFSET & i) == 0) {
            C6181j.m25434a(this.f20014c, i2);
            this.f20014c.mo6389i(b & JfifUtil.MARKER_FIRST_BYTE);
            this.f20014c.mo6389i(b2 & JfifUtil.MARKER_FIRST_BYTE);
            this.f20014c.mo6383g(i & (byte) -1);
        } else {
            throw C6174e.m25357a("reserved bit set: %s", Integer.valueOf(i));
        }
    }

    public synchronized void close() {
        this.f20018g = true;
        this.f20014c.close();
    }

    /* renamed from: a */
    private static void m25434a(C7496d c7496d, int i) {
        c7496d.mo6389i((i >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        c7496d.mo6389i((i >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        c7496d.mo6389i(i & JfifUtil.MARKER_FIRST_BYTE);
    }

    /* renamed from: b */
    private void m25435b(int i, long j) {
        while (j > 0) {
            int min = (int) Math.min((long) this.f20017f, j);
            long j2 = (long) min;
            j -= j2;
            m25438a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f20014c.mo5257a(this.f20016e, j2);
        }
    }

    /* renamed from: a */
    void m25447a(boolean z, int i, List<C6170c> list) {
        if (this.f20018g) {
            throw new IOException("closed");
        }
        this.f20013a.m25354a((List) list);
        long a = this.f20016e.m39582a();
        int min = (int) Math.min((long) this.f20017f, a);
        long j = (long) min;
        int i2 = (a > j ? 1 : (a == j ? 0 : -1));
        byte b = i2 == 0 ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        m25438a(i, min, (byte) true, b);
        this.f20014c.mo5257a(this.f20016e, j);
        if (i2 > 0) {
            m25435b(i, a - j);
        }
    }
}
