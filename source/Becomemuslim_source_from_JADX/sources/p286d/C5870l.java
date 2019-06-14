package p286d;

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
/* renamed from: d.l */
public final class C5870l {
    /* renamed from: a */
    static final Logger f19531a = Logger.getLogger(C5870l.class.getName());

    /* compiled from: Okio */
    /* renamed from: d.l$1 */
    class C72101 implements C5875s {
        /* renamed from: a */
        final /* synthetic */ C5877u f25484a;
        /* renamed from: b */
        final /* synthetic */ OutputStream f25485b;

        C72101(C5877u c5877u, OutputStream outputStream) {
            this.f25484a = c5877u;
            this.f25485b = outputStream;
        }

        public void write(C8037c c8037c, long j) {
            C5878v.m24746a(c8037c.f29839b, 0, j);
            while (j > 0) {
                this.f25484a.throwIfReached();
                C5873p c5873p = c8037c.f29838a;
                int min = (int) Math.min(j, (long) (c5873p.f19541c - c5873p.f19540b));
                this.f25485b.write(c5873p.f19539a, c5873p.f19540b, min);
                c5873p.f19540b += min;
                long j2 = (long) min;
                j -= j2;
                c8037c.f29839b -= j2;
                if (c5873p.f19540b == c5873p.f19541c) {
                    c8037c.f29838a = c5873p.m24740c();
                    C5874q.m24743a(c5873p);
                }
            }
        }

        public void flush() {
            this.f25485b.flush();
        }

        public void close() {
            this.f25485b.close();
        }

        public C5877u timeout() {
            return this.f25484a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sink(");
            stringBuilder.append(this.f25485b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    /* compiled from: Okio */
    /* renamed from: d.l$2 */
    class C72112 implements C5876t {
        /* renamed from: a */
        final /* synthetic */ C5877u f25486a;
        /* renamed from: b */
        final /* synthetic */ InputStream f25487b;

        C72112(C5877u c5877u, InputStream inputStream) {
            this.f25486a = c5877u;
            this.f25487b = inputStream;
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
                try {
                    this.f25486a.throwIfReached();
                    C5873p e = c8037c.m38995e(1);
                    j = this.f25487b.read(e.f19539a, e.f19541c, (int) Math.min(j, (long) (8192 - e.f19541c)));
                    if (j == -1) {
                        return -1;
                    }
                    e.f19541c += j;
                    j = (long) j;
                    c8037c.f29839b += j;
                    return j;
                } catch (AssertionError e2) {
                    if (C5870l.m24728a(e2) != null) {
                        throw new IOException(e2);
                    }
                    throw e2;
                }
            }
        }

        public void close() {
            this.f25487b.close();
        }

        public C5877u timeout() {
            return this.f25486a;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("source(");
            stringBuilder.append(this.f25487b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    /* compiled from: Okio */
    /* renamed from: d.l$3 */
    class C72123 implements C5875s {
        public void close() {
        }

        public void flush() {
        }

        C72123() {
        }

        public void write(C8037c c8037c, long j) {
            c8037c.mo6309i(j);
        }

        public C5877u timeout() {
            return C5877u.NONE;
        }
    }

    /* compiled from: Okio */
    /* renamed from: d.l$4 */
    class C80384 extends C7202a {
        /* renamed from: a */
        final /* synthetic */ Socket f29840a;

        C80384(Socket socket) {
            this.f29840a = socket;
        }

        protected IOException newTimeoutException(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        protected void timedOut() {
            Logger logger;
            Level level;
            StringBuilder stringBuilder;
            try {
                this.f29840a.close();
            } catch (Throwable e) {
                logger = C5870l.f19531a;
                level = Level.WARNING;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to close timed out socket ");
                stringBuilder.append(this.f29840a);
                logger.log(level, stringBuilder.toString(), e);
            } catch (AssertionError e2) {
                if (C5870l.m24728a(e2)) {
                    logger = C5870l.f19531a;
                    level = Level.WARNING;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to close timed out socket ");
                    stringBuilder.append(this.f29840a);
                    logger.log(level, stringBuilder.toString(), e2);
                    return;
                }
                throw e2;
            }
        }
    }

    private C5870l() {
    }

    /* renamed from: a */
    public static C7204e m24720a(C5876t c5876t) {
        return new C8040o(c5876t);
    }

    /* renamed from: a */
    public static C7203d m24719a(C5875s c5875s) {
        return new C8039n(c5875s);
    }

    /* renamed from: a */
    public static C5875s m24722a(OutputStream outputStream) {
        return C5870l.m24723a(outputStream, new C5877u());
    }

    /* renamed from: a */
    private static C5875s m24723a(OutputStream outputStream, C5877u c5877u) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (c5877u != null) {
            return new C72101(c5877u, outputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C5875s m24724a(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C5877u c = C5870l.m24731c(socket);
            return c.sink(C5870l.m24723a(socket.getOutputStream(), c));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    /* renamed from: a */
    public static C5876t m24726a(InputStream inputStream) {
        return C5870l.m24727a(inputStream, new C5877u());
    }

    /* renamed from: a */
    private static C5876t m24727a(InputStream inputStream, C5877u c5877u) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (c5877u != null) {
            return new C72112(c5877u, inputStream);
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    /* renamed from: a */
    public static C5876t m24725a(File file) {
        if (file != null) {
            return C5870l.m24726a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: b */
    public static C5875s m24729b(File file) {
        if (file != null) {
            return C5870l.m24722a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: c */
    public static C5875s m24732c(File file) {
        if (file != null) {
            return C5870l.m24722a(new FileOutputStream(file, true));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: a */
    public static C5875s m24721a() {
        return new C72123();
    }

    /* renamed from: b */
    public static C5876t m24730b(Socket socket) {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C5877u c = C5870l.m24731c(socket);
            return c.source(C5870l.m24727a(socket.getInputStream(), c));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    /* renamed from: c */
    private static C7202a m24731c(Socket socket) {
        return new C80384(socket);
    }

    /* renamed from: a */
    static boolean m24728a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }
}
