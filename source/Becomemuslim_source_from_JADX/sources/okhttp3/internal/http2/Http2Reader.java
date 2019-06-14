package okhttp3.internal.http2;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.imageutils.JfifUtil;
import com.facebook.soloader.MinElf;
import java.io.Closeable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import p286d.C5869f;
import p286d.C5876t;
import p286d.C5877u;
import p286d.C7204e;
import p286d.C8037c;

final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation = new ContinuationSource(this.source);
    final Reader hpackReader = new Reader(4096, this.continuation);
    private final C7204e source;

    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, C5869f c5869f, String str2, int i2, long j);

        void data(boolean z, int i, C7204e c7204e, int i2);

        void goAway(int i, ErrorCode errorCode, C5869f c5869f);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list);

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    static final class ContinuationSource implements C5876t {
        byte flags;
        int left;
        int length;
        short padding;
        private final C7204e source;
        int streamId;

        public void close() {
        }

        ContinuationSource(C7204e c7204e) {
            this.source = c7204e;
        }

        public long read(C8037c c8037c, long j) {
            while (this.left == 0) {
                this.source.mo6309i((long) this.padding);
                this.padding = (short) 0;
                if ((this.flags & 4) != 0) {
                    return -1;
                }
                readContinuationHeader();
            }
            c8037c = this.source.read(c8037c, Math.min(j, (long) this.left));
            if (c8037c == -1) {
                return -1;
            }
            this.left = (int) (((long) this.left) - c8037c);
            return c8037c;
        }

        public C5877u timeout() {
            return this.source.timeout();
        }

        private void readContinuationHeader() {
            int i = this.streamId;
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte h = (byte) (this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE);
            this.flags = (byte) (this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, h, this.flags));
            }
            this.streamId = this.source.mo6310j() & Integer.MAX_VALUE;
            if (h != (byte) 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(h));
            } else if (this.streamId != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    Http2Reader(C7204e c7204e, boolean z) {
        this.source = c7204e;
        this.client = z;
    }

    public void readConnectionPreface(Handler handler) {
        if (!this.client) {
            handler = this.source.mo6299d((long) Http2.CONNECTION_PREFACE.mo5110h());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", handler.mo5108f()));
            }
            if (!Http2.CONNECTION_PREFACE.equals(handler)) {
                throw Http2.ioException("Expected a connection header but was %s", handler.mo5099a());
            }
        } else if (nextFrame(true, handler) == null) {
            throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
        }
    }

    public boolean nextFrame(boolean r7, okhttp3.internal.http2.Http2Reader.Handler r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.source;	 Catch:{ IOException -> 0x0096 }
        r2 = 9;	 Catch:{ IOException -> 0x0096 }
        r1.mo6288a(r2);	 Catch:{ IOException -> 0x0096 }
        r1 = r6.source;
        r1 = readMedium(r1);
        r2 = 1;
        if (r1 < 0) goto L_0x0087;
    L_0x0011:
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        if (r1 > r3) goto L_0x0087;
    L_0x0015:
        r3 = r6.source;
        r3 = r3.mo6304h();
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
        r7 = okhttp3.internal.http2.Http2.ioException(r8, r7);
        throw r7;
    L_0x0033:
        r7 = r6.source;
        r7 = r7.mo6304h();
        r7 = r7 & 255;
        r7 = (byte) r7;
        r0 = r6.source;
        r0 = r0.mo6310j();
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r0 = r0 & r4;
        r4 = logger;
        r5 = java.util.logging.Level.FINE;
        r4 = r4.isLoggable(r5);
        if (r4 == 0) goto L_0x0059;
    L_0x0050:
        r4 = logger;
        r5 = okhttp3.internal.http2.Http2.frameLog(r2, r0, r1, r3, r7);
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
        r7 = r6.source;
        r0 = (long) r1;
        r7.mo6309i(r0);
        goto L_0x0086;
    L_0x0063:
        r6.readWindowUpdate(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0067:
        r6.readGoAway(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x006b:
        r6.readPing(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x006f:
        r6.readPushPromise(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0073:
        r6.readSettings(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0077:
        r6.readRstStream(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x007b:
        r6.readPriority(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x007f:
        r6.readHeaders(r8, r1, r7, r0);
        goto L_0x0086;
    L_0x0083:
        r6.readData(r8, r1, r7, r0);
    L_0x0086:
        return r2;
    L_0x0087:
        r7 = new java.lang.Object[r2];
        r8 = java.lang.Integer.valueOf(r1);
        r7[r0] = r8;
        r8 = "FRAME_SIZE_ERROR: %s";
        r7 = okhttp3.internal.http2.Http2.ioException(r8, r7);
        throw r7;
    L_0x0096:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.nextFrame(boolean, okhttp3.internal.http2.Http2Reader$Handler):boolean");
    }

    private void readHeaders(Handler handler, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE);
            }
            if ((b & 32) != 0) {
                readPriority(handler, i2);
                i -= 5;
            }
            handler.headers(z, i2, (byte) -1, readHeaderBlock(lengthWithoutPadding(i, b, s), s, b, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    private List<Header> readHeaderBlock(int i, short s, byte b, int i2) {
        ContinuationSource continuationSource = this.continuation;
        this.continuation.left = i;
        continuationSource.length = i;
        this.continuation.padding = s;
        this.continuation.flags = b;
        this.continuation.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readData(Handler handler, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 != 0) {
            Object obj = 1;
            boolean z = (b & 1) != 0;
            if ((b & 32) == 0) {
                obj = null;
            }
            if (obj == null) {
                if ((b & 8) != 0) {
                    s = (short) (this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE);
                }
                handler.data(z, i2, this.source, lengthWithoutPadding(i, b, s));
                this.source.mo6309i((long) s);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void readPriority(Handler handler, int i, byte b, int i2) {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[]{Integer.valueOf(i)});
        } else if (i2 != 0) {
            readPriority(handler, i2);
        } else {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void readPriority(Handler handler, int i) {
        int j = this.source.mo6310j();
        handler.priority(i, j & Integer.MAX_VALUE, (this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE) + 1, (LinearLayoutManager.INVALID_OFFSET & j) != 0);
    }

    private void readRstStream(Handler handler, int i, byte b, int i2) {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[]{Integer.valueOf(i)});
        } else if (i2 != 0) {
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(this.source.mo6310j());
            if (fromHttp2 != null) {
                handler.rstStream(i2, fromHttp2);
            } else {
                throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[]{Integer.valueOf(i)});
            }
        } else {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void readSettings(Handler handler, int i, byte b, int i2) {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & (byte) 1) != (byte) 0) {
            if (i == 0) {
                handler.ackSettings();
            } else {
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
        } else if (i % 6 == (byte) 0) {
            b = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                int i4 = this.source.mo6308i() & MinElf.PN_XNUM;
                int j = this.source.mo6310j();
                switch (i4) {
                    case 1:
                    case 6:
                        break;
                    case 2:
                        if (j == 0) {
                            continue;
                        } else if (j == 1) {
                            break;
                        } else {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        i4 = 4;
                        break;
                    case 4:
                        i4 = 7;
                        if (j >= 0) {
                            break;
                        }
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    case 5:
                        if (j >= 16384 && j <= 16777215) {
                            break;
                        }
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[]{Integer.valueOf(j)});
                        break;
                    default:
                        break;
                }
                b.set(i4, j);
            }
            handler.settings(false, b);
        } else {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[]{Integer.valueOf(i)});
        }
    }

    private void readPushPromise(Handler handler, int i, byte b, int i2) {
        short s = (short) 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.source.mo6304h() & JfifUtil.MARKER_FIRST_BYTE);
            }
            handler.pushPromise(i2, this.source.mo6310j() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i - 4, b, s), s, b, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void readPing(Handler handler, int i, byte b, int i2) {
        boolean z = false;
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", new Object[]{Integer.valueOf(i)});
        } else if (i2 == 0) {
            i = this.source.mo6310j();
            i2 = this.source.mo6310j();
            if ((b & (byte) 1) != (byte) 0) {
                z = true;
            }
            handler.ping(z, i, i2);
        } else {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void readGoAway(Handler handler, int i, byte b, int i2) {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[]{Integer.valueOf(i)});
        } else if (i2 == 0) {
            i2 = this.source.mo6310j();
            i -= 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(this.source.mo6310j());
            if (fromHttp2 != null) {
                b = C5869f.f19527b;
                if (i > 0) {
                    b = this.source.mo6299d((long) i);
                }
                handler.goAway(i2, fromHttp2, b);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[]{Integer.valueOf(r2)});
        } else {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private void readWindowUpdate(Handler handler, int i, byte b, int i2) {
        if (i == 4) {
            long j = ((long) this.source.mo6310j()) & 2147483647L;
            if (j != 0) {
                handler.windowUpdate(i2, j);
                return;
            } else {
                throw Http2.ioException("windowSizeIncrement was 0", new Object[]{Long.valueOf(j)});
            }
        }
        throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[]{Integer.valueOf(i)});
    }

    public void close() {
        this.source.close();
    }

    static int readMedium(C7204e c7204e) {
        return (c7204e.mo6304h() & JfifUtil.MARKER_FIRST_BYTE) | (((c7204e.mo6304h() & JfifUtil.MARKER_FIRST_BYTE) << 16) | ((c7204e.mo6304h() & JfifUtil.MARKER_FIRST_BYTE) << 8));
    }

    static int lengthWithoutPadding(int i, byte b, short s) {
        if ((b & 8) != (byte) 0) {
            short s2 = i - 1;
        }
        if (s <= s2) {
            return (short) (s2 - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[]{Short.valueOf(s), Integer.valueOf(s2)});
    }
}
