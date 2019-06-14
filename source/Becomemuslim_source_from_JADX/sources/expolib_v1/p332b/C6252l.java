package expolib_v1.p332b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Okio */
/* renamed from: expolib_v1.b.l */
public final class C6252l {
    /* renamed from: a */
    static final Logger f20382a = Logger.getLogger(C6252l.class.getName());

    /* compiled from: Okio */
    /* renamed from: expolib_v1.b.l$1 */
    class C75031 implements C6257r {
        /* renamed from: a */
        final /* synthetic */ C6259t f26048a;
        /* renamed from: b */
        final /* synthetic */ OutputStream f26049b;

        C75031(C6259t c6259t, OutputStream outputStream) {
            this.f26048a = c6259t;
            this.f26049b = outputStream;
        }

        /* renamed from: a */
        public void mo5257a(C8170c c8170c, long j) {
            C6260u.m25887a(c8170c.f30353b, 0, j);
            while (j > 0) {
                this.f26048a.mo5352g();
                C6255o c6255o = c8170c.f30352a;
                int min = (int) Math.min(j, (long) (c6255o.f20387c - c6255o.f20386b));
                this.f26049b.write(c6255o.f20385a, c6255o.f20386b, min);
                c6255o.f20386b += min;
                long j2 = (long) min;
                j -= j2;
                c8170c.f30353b -= j2;
                if (c6255o.f20386b == c6255o.f20387c) {
                    c8170c.f30352a = c6255o.m25872a();
                    C6256p.m25878a(c6255o);
                }
            }
        }

        public void flush() {
            this.f26049b.flush();
        }

        public void close() {
            this.f26049b.close();
        }

        public C6259t timeout() {
            return this.f26048a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sink(");
            stringBuilder.append(this.f26049b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    /* compiled from: Okio */
    /* renamed from: expolib_v1.b.l$2 */
    class C75042 implements C6258s {
        /* renamed from: a */
        final /* synthetic */ C6259t f26050a;
        /* renamed from: b */
        final /* synthetic */ InputStream f26051b;

        C75042(C6259t c6259t, InputStream inputStream) {
            this.f26050a = c6259t;
            this.f26051b = inputStream;
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
                try {
                    this.f26050a.mo5352g();
                    C6255o e = c8170c.m39620e(1);
                    j = this.f26051b.read(e.f20385a, e.f20387c, (int) Math.min(j, (long) (8192 - e.f20387c)));
                    if (j == -1) {
                        return -1;
                    }
                    e.f20387c += j;
                    j = (long) j;
                    c8170c.f30353b += j;
                    return j;
                } catch (AssertionError e2) {
                    if (C6252l.m25867a(e2) != null) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public void close() {
            this.f26051b.close();
        }

        public C6259t timeout() {
            return this.f26050a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("source(");
            stringBuilder.append(this.f26051b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    /* compiled from: Okio */
    /* renamed from: expolib_v1.b.l$3 */
    class C75053 implements C6257r {
        public void close() {
        }

        public void flush() {
        }

        C75053() {
        }

        /* renamed from: a */
        public void mo5257a(C8170c c8170c, long j) {
            c8170c.mo6387h(j);
        }

        public C6259t timeout() {
            return C6259t.f20394c;
        }
    }

    /* compiled from: Okio */
    /* renamed from: expolib_v1.b.l$4 */
    class C81714 extends C7495a {
        /* renamed from: a */
        final /* synthetic */ Socket f30354a;

        C81714(Socket socket) {
            this.f30354a = socket;
        }

        /* renamed from: a */
        protected IOException mo6363a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* renamed from: a */
        protected void mo6364a() {
            Logger logger;
            Level level;
            StringBuilder stringBuilder;
            try {
                this.f30354a.close();
            } catch (Throwable e) {
                logger = C6252l.f20382a;
                level = Level.WARNING;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to close timed out socket ");
                stringBuilder.append(this.f30354a);
                logger.log(level, stringBuilder.toString(), e);
            } catch (AssertionError e2) {
                if (C6252l.m25867a(e2)) {
                    logger = C6252l.f20382a;
                    level = Level.WARNING;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to close timed out socket ");
                    stringBuilder.append(this.f30354a);
                    logger.log(level, stringBuilder.toString(), e2);
                    return;
                }
                throw e2;
            }
        }
    }

    private C6252l() {
    }

    /* renamed from: a */
    public static C7497e m25859a(C6258s c6258s) {
        return new C8173n(c6258s);
    }

    /* renamed from: a */
    public static C7496d m25858a(C6257r c6257r) {
        return new C8172m(c6257r);
    }

    /* renamed from: a */
    public static C6257r m25861a(OutputStream outputStream) {
        return C6252l.m25862a(outputStream, new C6259t());
    }

    /* renamed from: a */
    private static C6257r m25862a(OutputStream outputStream, C6259t c6259t) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (c6259t != null) {
            return new C75031(c6259t, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C6257r m25863a(Socket socket) {
        if (socket != null) {
            C6259t c = C6252l.m25870c(socket);
            return c.m34015a(C6252l.m25862a(socket.getOutputStream(), c));
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* renamed from: a */
    public static C6258s m25865a(InputStream inputStream) {
        return C6252l.m25866a(inputStream, new C6259t());
    }

    /* renamed from: a */
    private static C6258s m25866a(InputStream inputStream, C6259t c6259t) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (c6259t != null) {
            return new C75042(c6259t, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C6258s m25864a(File file) {
        if (file != null) {
            return C6252l.m25865a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: b */
    public static C6257r m25868b(File file) {
        if (file != null) {
            return C6252l.m25861a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: c */
    public static C6257r m25871c(File file) {
        if (file != null) {
            return C6252l.m25861a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C6257r m25860a() {
        return new C75053();
    }

    /* renamed from: b */
    public static C6258s m25869b(Socket socket) {
        if (socket != null) {
            C6259t c = C6252l.m25870c(socket);
            return c.m34016a(C6252l.m25866a(socket.getInputStream(), c));
        }
        throw new IllegalArgumentException("socket == null");
    }

    /* renamed from: c */
    private static C7495a m25870c(Socket socket) {
        return new C81714(socket);
    }

    /* renamed from: a */
    static boolean m25867a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }
}
