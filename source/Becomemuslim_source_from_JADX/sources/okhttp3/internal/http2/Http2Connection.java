package okhttp3.internal.http2;

import com.facebook.soloader.MinElf;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import p286d.C5869f;
import p286d.C5870l;
import p286d.C7203d;
import p286d.C7204e;
import p286d.C8037c;

public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    private boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests = new LinkedHashSet();
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings = new Settings();
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    boolean receivedInitialPeerSettings = false;
    boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final Http2Writer writer;
    private final ScheduledExecutorService writerExecutor;

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        C7203d sink;
        Socket socket;
        C7204e source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Builder socket(Socket socket) {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), C5870l.m24720a(C5870l.m24730b(socket)), C5870l.m24719a(C5870l.m24724a(socket)));
        }

        public Builder socket(Socket socket, String str, C7204e c7204e, C7203d c7203d) {
            this.socket = socket;
            this.hostname = str;
            this.source = c7204e;
            this.sink = c7203d;
            return this;
        }

        public Builder listener(Listener listener) {
            this.listener = listener;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new C76671();

        /* renamed from: okhttp3.internal.http2.Http2Connection$Listener$1 */
        class C76671 extends Listener {
            C76671() {
            }

            public void onStream(Http2Stream http2Stream) {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        }

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", r4.hostname, Integer.valueOf(i), Integer.valueOf(i2));
            this.reply = z;
            this.payload1 = i;
            this.payload2 = i2;
        }

        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Handler {
        final Http2Reader reader;

        public void ackSettings() {
        }

        public void alternateService(int i, String str, C5869f c5869f, String str2, int i2, long j) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", r4.hostname);
            this.reader = http2Reader;
        }

        protected void execute() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            r1 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            r2 = r5.reader;	 Catch:{ IOException -> 0x001e }
            r2.readConnectionPreface(r5);	 Catch:{ IOException -> 0x001e }
        L_0x0009:
            r2 = r5.reader;	 Catch:{ IOException -> 0x001e }
            r3 = 0;	 Catch:{ IOException -> 0x001e }
            r2 = r2.nextFrame(r3, r5);	 Catch:{ IOException -> 0x001e }
            if (r2 == 0) goto L_0x0013;	 Catch:{ IOException -> 0x001e }
        L_0x0012:
            goto L_0x0009;	 Catch:{ IOException -> 0x001e }
        L_0x0013:
            r2 = okhttp3.internal.http2.ErrorCode.NO_ERROR;	 Catch:{ IOException -> 0x001e }
            r0 = okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x001a }
            r1 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ IOException -> 0x0027 }
            goto L_0x0024;
        L_0x001a:
            r0 = r2;
            goto L_0x001e;
        L_0x001c:
            r2 = move-exception;
            goto L_0x0031;
        L_0x001e:
            r2 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x001c }
            r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x002d }
            r1 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ IOException -> 0x0027 }
        L_0x0024:
            r1.close(r2, r0);	 Catch:{ IOException -> 0x0027 }
        L_0x0027:
            r0 = r5.reader;
            okhttp3.internal.Util.closeQuietly(r0);
            return;
        L_0x002d:
            r0 = move-exception;
            r4 = r2;
            r2 = r0;
            r0 = r4;
        L_0x0031:
            r3 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ IOException -> 0x0036 }
            r3.close(r0, r1);	 Catch:{ IOException -> 0x0036 }
        L_0x0036:
            r0 = r5.reader;
            okhttp3.internal.Util.closeQuietly(r0);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.execute():void");
        }

        public void data(boolean z, int i, C7204e c7204e, int i2) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushDataLater(i, c7204e, i2, z);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                c7204e.mo6309i((long) i2);
                return;
            }
            stream.receiveData(c7204e, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r10, int r11, int r12, java.util.List<okhttp3.internal.http2.Header> r13) {
            /*
            r9 = this;
            r12 = okhttp3.internal.http2.Http2Connection.this;
            r12 = r12.pushedStream(r11);
            if (r12 == 0) goto L_0x000e;
        L_0x0008:
            r12 = okhttp3.internal.http2.Http2Connection.this;
            r12.pushHeadersLater(r11, r13, r10);
            return;
        L_0x000e:
            r12 = okhttp3.internal.http2.Http2Connection.this;
            monitor-enter(r12);
            r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r0 = r0.getStream(r11);	 Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0070;
        L_0x0019:
            r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r0 = r0.shutdown;	 Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0021;
        L_0x001f:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0021:
            r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r0 = r0.lastGoodStreamId;	 Catch:{ all -> 0x007a }
            if (r11 > r0) goto L_0x0029;
        L_0x0027:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0029:
            r0 = r11 % 2;
            r1 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r1 = r1.nextStreamId;	 Catch:{ all -> 0x007a }
            r2 = 2;
            r1 = r1 % r2;
            if (r0 != r1) goto L_0x0035;
        L_0x0033:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0035:
            r0 = new okhttp3.internal.http2.Http2Stream;	 Catch:{ all -> 0x007a }
            r5 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r6 = 0;
            r3 = r0;
            r4 = r11;
            r7 = r10;
            r8 = r13;
            r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ all -> 0x007a }
            r10 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r10.lastGoodStreamId = r11;	 Catch:{ all -> 0x007a }
            r10 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r10 = r10.streams;	 Catch:{ all -> 0x007a }
            r13 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x007a }
            r10.put(r13, r0);	 Catch:{ all -> 0x007a }
            r10 = okhttp3.internal.http2.Http2Connection.listenerExecutor;	 Catch:{ all -> 0x007a }
            r13 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$1;	 Catch:{ all -> 0x007a }
            r1 = "OkHttp %s stream %d";
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x007a }
            r3 = 0;
            r4 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x007a }
            r4 = r4.hostname;	 Catch:{ all -> 0x007a }
            r2[r3] = r4;	 Catch:{ all -> 0x007a }
            r3 = 1;
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x007a }
            r2[r3] = r11;	 Catch:{ all -> 0x007a }
            r13.<init>(r1, r2, r0);	 Catch:{ all -> 0x007a }
            r10.execute(r13);	 Catch:{ all -> 0x007a }
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            return;
        L_0x0070:
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            r0.receiveHeaders(r13);
            if (r10 == 0) goto L_0x0079;
        L_0x0076:
            r0.receiveFin();
        L_0x0079:
            return;
        L_0x007a:
            r10 = move-exception;
            monitor-exit(r12);	 Catch:{ all -> 0x007a }
            throw r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.headers(boolean, int, int, java.util.List):void");
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i)) {
                Http2Connection.this.pushResetLater(i, errorCode);
                return;
            }
            i = Http2Connection.this.removeStream(i);
            if (i != 0) {
                i.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z, Settings settings) {
            synchronized (Http2Connection.this) {
                boolean initialWindowSize = Http2Connection.this.peerSettings.getInitialWindowSize();
                if (z) {
                    Http2Connection.this.peerSettings.clear();
                }
                Http2Connection.this.peerSettings.merge(settings);
                applyAndAckSettings(settings);
                z = Http2Connection.this.peerSettings.getInitialWindowSize();
                Http2Stream[] http2StreamArr = null;
                if (z || z == initialWindowSize) {
                    z = false;
                } else {
                    z = (long) (z - initialWindowSize);
                    if (!Http2Connection.this.receivedInitialPeerSettings) {
                        Http2Connection.this.addBytesToWriteWindow(z);
                        Http2Connection.this.receivedInitialPeerSettings = true;
                    }
                    if (!Http2Connection.this.streams.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                    }
                }
                ExecutorService access$100 = Http2Connection.listenerExecutor;
                Object[] objArr = new Object[1];
                int i = 0;
                objArr[0] = Http2Connection.this.hostname;
                access$100.execute(new NamedRunnable("OkHttp %s settings", objArr) {
                    public void execute() {
                        Http2Connection.this.listener.onSettings(Http2Connection.this);
                    }
                });
            }
            if (http2StreamArr != null && z) {
                int length = http2StreamArr.length;
                while (i < length) {
                    Http2Stream http2Stream = http2StreamArr[i];
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(z);
                    }
                    i++;
                }
            }
        }

        private void applyAndAckSettings(final okhttp3.internal.http2.Settings r7) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ RejectedExecutionException -> 0x001a }
            r0 = r0.writerExecutor;	 Catch:{ RejectedExecutionException -> 0x001a }
            r1 = new okhttp3.internal.http2.Http2Connection$ReaderRunnable$3;	 Catch:{ RejectedExecutionException -> 0x001a }
            r2 = "OkHttp %s ACK Settings";	 Catch:{ RejectedExecutionException -> 0x001a }
            r3 = 1;	 Catch:{ RejectedExecutionException -> 0x001a }
            r3 = new java.lang.Object[r3];	 Catch:{ RejectedExecutionException -> 0x001a }
            r4 = 0;	 Catch:{ RejectedExecutionException -> 0x001a }
            r5 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ RejectedExecutionException -> 0x001a }
            r5 = r5.hostname;	 Catch:{ RejectedExecutionException -> 0x001a }
            r3[r4] = r5;	 Catch:{ RejectedExecutionException -> 0x001a }
            r1.<init>(r2, r3, r7);	 Catch:{ RejectedExecutionException -> 0x001a }
            r0.execute(r1);	 Catch:{ RejectedExecutionException -> 0x001a }
        L_0x001a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.applyAndAckSettings(okhttp3.internal.http2.Settings):void");
        }

        public void ping(boolean r4, int r5, int r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            if (r4 == 0) goto L_0x0015;
        L_0x0002:
            r4 = okhttp3.internal.http2.Http2Connection.this;
            monitor-enter(r4);
            r5 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x0012 }
            r6 = 0;	 Catch:{ all -> 0x0012 }
            r5.awaitingPong = r6;	 Catch:{ all -> 0x0012 }
            r5 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x0012 }
            r5.notifyAll();	 Catch:{ all -> 0x0012 }
            monitor-exit(r4);	 Catch:{ all -> 0x0012 }
            goto L_0x0026;	 Catch:{ all -> 0x0012 }
        L_0x0012:
            r5 = move-exception;	 Catch:{ all -> 0x0012 }
            monitor-exit(r4);	 Catch:{ all -> 0x0012 }
            throw r5;
        L_0x0015:
            r4 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ RejectedExecutionException -> 0x0026 }
            r4 = r4.writerExecutor;	 Catch:{ RejectedExecutionException -> 0x0026 }
            r0 = new okhttp3.internal.http2.Http2Connection$PingRunnable;	 Catch:{ RejectedExecutionException -> 0x0026 }
            r1 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ RejectedExecutionException -> 0x0026 }
            r2 = 1;	 Catch:{ RejectedExecutionException -> 0x0026 }
            r0.<init>(r2, r5, r6);	 Catch:{ RejectedExecutionException -> 0x0026 }
            r4.execute(r0);	 Catch:{ RejectedExecutionException -> 0x0026 }
        L_0x0026:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.ReaderRunnable.ping(boolean, int, int):void");
        }

        public void goAway(int i, ErrorCode errorCode, C5869f c5869f) {
            c5869f.mo5110h();
            synchronized (Http2Connection.this) {
                Http2Stream[] http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    i = Http2Connection.this;
                    i.bytesLeftInWriteWindow += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            i = Http2Connection.this.getStream(i);
            if (i != 0) {
                synchronized (i) {
                    i.addBytesToWriteWindow(j);
                }
            }
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.pushRequestLater(i2, list);
        }
    }

    boolean pushedStream(int i) {
        return i != 0 && (i & 1) == 0;
    }

    Http2Connection(Builder builder) {
        Builder builder2 = builder;
        this.pushObserver = builder2.pushObserver;
        this.client = builder2.client;
        this.listener = builder2.listener;
        r0.nextStreamId = builder2.client ? 1 : 2;
        if (builder2.client) {
            r0.nextStreamId += 2;
        }
        if (builder2.client) {
            r0.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
        }
        r0.hostname = builder2.hostname;
        r0.writerExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", r0.hostname), false));
        if (builder2.pingIntervalMillis != 0) {
            r0.writerExecutor.scheduleAtFixedRate(new PingRunnable(false, 0, 0), (long) builder2.pingIntervalMillis, (long) builder2.pingIntervalMillis, TimeUnit.MILLISECONDS);
        }
        r0.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", r0.hostname), true));
        r0.peerSettings.set(7, MinElf.PN_XNUM);
        r0.peerSettings.set(5, 16384);
        r0.bytesLeftInWriteWindow = (long) r0.peerSettings.getInitialWindowSize();
        r0.socket = builder2.socket;
        r0.writer = new Http2Writer(builder2.sink, r0.client);
        r0.readerRunnable = new ReaderRunnable(new Http2Reader(builder2.source, r0.client));
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    synchronized Http2Stream getStream(int i) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i));
    }

    synchronized Http2Stream removeStream(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) {
        if (!this.client) {
            return newStream(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public Http2Stream newStream(List<Header> list, boolean z) {
        return newStream(0, list, z);
    }

    private Http2Stream newStream(int i, List<Header> list, boolean z) {
        Http2Stream http2Stream;
        boolean z2 = z ^ 1;
        synchronized (this.writer) {
            synchronized (this) {
                if (this.nextStreamId > 1073741823) {
                    shutdown(ErrorCode.REFUSED_STREAM);
                }
                if (this.shutdown) {
                    throw new ConnectionShutdownException();
                }
                int i2 = this.nextStreamId;
                this.nextStreamId += 2;
                http2Stream = new Http2Stream(i2, this, z2, false, list);
                if (z && this.bytesLeftInWriteWindow != 0) {
                    if (http2Stream.bytesLeftInWriteWindow != 0) {
                        z = false;
                        if (http2Stream.isOpen()) {
                            this.streams.put(Integer.valueOf(i2), http2Stream);
                        }
                    }
                }
                z = true;
                if (http2Stream.isOpen()) {
                    this.streams.put(Integer.valueOf(i2), http2Stream);
                }
            }
            if (i == 0) {
                this.writer.synStream(z2, i2, i, list);
            } else if (this.client) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.writer.pushPromise(i, i2, list);
            }
        }
        if (z) {
            this.writer.flush();
        }
        return http2Stream;
    }

    void writeSynReply(int i, boolean z, List<Header> list) {
        this.writer.synReply(z, i, list);
    }

    public void writeData(int r9, boolean r10, p286d.C8037c r11, long r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = 0;
        r1 = 0;
        r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r3 != 0) goto L_0x000d;
    L_0x0007:
        r12 = r8.writer;
        r12.data(r10, r9, r11, r0);
        return;
    L_0x000d:
        r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x0063;
    L_0x0011:
        monitor-enter(r8);
    L_0x0012:
        r3 = r8.bytesLeftInWriteWindow;	 Catch:{ InterruptedException -> 0x005b }
        r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));	 Catch:{ InterruptedException -> 0x005b }
        if (r3 > 0) goto L_0x0030;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0018:
        r3 = r8.streams;	 Catch:{ InterruptedException -> 0x005b }
        r4 = java.lang.Integer.valueOf(r9);	 Catch:{ InterruptedException -> 0x005b }
        r3 = r3.containsKey(r4);	 Catch:{ InterruptedException -> 0x005b }
        if (r3 == 0) goto L_0x0028;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0024:
        r8.wait();	 Catch:{ InterruptedException -> 0x005b }
        goto L_0x0012;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0028:
        r9 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x005b }
        r10 = "stream closed";	 Catch:{ InterruptedException -> 0x005b }
        r9.<init>(r10);	 Catch:{ InterruptedException -> 0x005b }
        throw r9;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0030:
        r3 = r8.bytesLeftInWriteWindow;	 Catch:{ all -> 0x0059 }
        r3 = java.lang.Math.min(r12, r3);	 Catch:{ all -> 0x0059 }
        r3 = (int) r3;	 Catch:{ all -> 0x0059 }
        r4 = r8.writer;	 Catch:{ all -> 0x0059 }
        r4 = r4.maxDataLength();	 Catch:{ all -> 0x0059 }
        r3 = java.lang.Math.min(r3, r4);	 Catch:{ all -> 0x0059 }
        r4 = r8.bytesLeftInWriteWindow;	 Catch:{ all -> 0x0059 }
        r6 = (long) r3;	 Catch:{ all -> 0x0059 }
        r4 = r4 - r6;	 Catch:{ all -> 0x0059 }
        r8.bytesLeftInWriteWindow = r4;	 Catch:{ all -> 0x0059 }
        monitor-exit(r8);	 Catch:{ all -> 0x0059 }
        r4 = 0;
        r12 = r12 - r6;
        r4 = r8.writer;
        if (r10 == 0) goto L_0x0054;
    L_0x004e:
        r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1));
        if (r5 != 0) goto L_0x0054;
    L_0x0052:
        r5 = 1;
        goto L_0x0055;
    L_0x0054:
        r5 = 0;
    L_0x0055:
        r4.data(r5, r9, r11, r3);
        goto L_0x000d;
    L_0x0059:
        r9 = move-exception;
        goto L_0x0061;
    L_0x005b:
        r9 = new java.io.InterruptedIOException;	 Catch:{ all -> 0x0059 }
        r9.<init>();	 Catch:{ all -> 0x0059 }
        throw r9;	 Catch:{ all -> 0x0059 }
    L_0x0061:
        monitor-exit(r8);	 Catch:{ all -> 0x0059 }
        throw r9;
    L_0x0063:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, d.c, long):void");
    }

    void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void writeSynResetLater(int r9, okhttp3.internal.http2.ErrorCode r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.writerExecutor;	 Catch:{ RejectedExecutionException -> 0x001f }
        r7 = new okhttp3.internal.http2.Http2Connection$1;	 Catch:{ RejectedExecutionException -> 0x001f }
        r3 = "OkHttp %s stream %d";	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = 2;	 Catch:{ RejectedExecutionException -> 0x001f }
        r4 = new java.lang.Object[r1];	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = 0;	 Catch:{ RejectedExecutionException -> 0x001f }
        r2 = r8.hostname;	 Catch:{ RejectedExecutionException -> 0x001f }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = 1;	 Catch:{ RejectedExecutionException -> 0x001f }
        r2 = java.lang.Integer.valueOf(r9);	 Catch:{ RejectedExecutionException -> 0x001f }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = r7;	 Catch:{ RejectedExecutionException -> 0x001f }
        r2 = r8;	 Catch:{ RejectedExecutionException -> 0x001f }
        r5 = r9;	 Catch:{ RejectedExecutionException -> 0x001f }
        r6 = r10;	 Catch:{ RejectedExecutionException -> 0x001f }
        r1.<init>(r3, r4, r5, r6);	 Catch:{ RejectedExecutionException -> 0x001f }
        r0.execute(r7);	 Catch:{ RejectedExecutionException -> 0x001f }
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeSynResetLater(int, okhttp3.internal.http2.ErrorCode):void");
    }

    void writeSynReset(int i, ErrorCode errorCode) {
        this.writer.rstStream(i, errorCode);
    }

    void writeWindowUpdateLater(int r10, long r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.writerExecutor;	 Catch:{ RejectedExecutionException -> 0x001f }
        r8 = new okhttp3.internal.http2.Http2Connection$2;	 Catch:{ RejectedExecutionException -> 0x001f }
        r3 = "OkHttp Window Update %s stream %d";	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = 2;	 Catch:{ RejectedExecutionException -> 0x001f }
        r4 = new java.lang.Object[r1];	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = 0;	 Catch:{ RejectedExecutionException -> 0x001f }
        r2 = r9.hostname;	 Catch:{ RejectedExecutionException -> 0x001f }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = 1;	 Catch:{ RejectedExecutionException -> 0x001f }
        r2 = java.lang.Integer.valueOf(r10);	 Catch:{ RejectedExecutionException -> 0x001f }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x001f }
        r1 = r8;	 Catch:{ RejectedExecutionException -> 0x001f }
        r2 = r9;	 Catch:{ RejectedExecutionException -> 0x001f }
        r5 = r10;	 Catch:{ RejectedExecutionException -> 0x001f }
        r6 = r11;	 Catch:{ RejectedExecutionException -> 0x001f }
        r1.<init>(r3, r4, r5, r6);	 Catch:{ RejectedExecutionException -> 0x001f }
        r0.execute(r8);	 Catch:{ RejectedExecutionException -> 0x001f }
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeWindowUpdateLater(int, long):void");
    }

    void writePing(boolean r3, int r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        if (r3 != 0) goto L_0x0012;
    L_0x0002:
        monitor-enter(r2);
        r0 = r2.awaitingPong;	 Catch:{ all -> 0x000f }
        r1 = 1;	 Catch:{ all -> 0x000f }
        r2.awaitingPong = r1;	 Catch:{ all -> 0x000f }
        monitor-exit(r2);	 Catch:{ all -> 0x000f }
        if (r0 == 0) goto L_0x0012;
    L_0x000b:
        r2.failConnection();
        return;
    L_0x000f:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x000f }
        throw r3;
    L_0x0012:
        r0 = r2.writer;	 Catch:{ IOException -> 0x0018 }
        r0.ping(r3, r4, r5);	 Catch:{ IOException -> 0x0018 }
        goto L_0x001b;
    L_0x0018:
        r2.failConnection();
    L_0x001b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writePing(boolean, int, int):void");
    }

    void writePingAndAwaitPong() {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    synchronized void awaitPong() {
        while (this.awaitingPong) {
            wait();
        }
    }

    public void flush() {
        this.writer.flush();
    }

    public void shutdown(ErrorCode errorCode) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                int i = this.lastGoodStreamId;
                this.writer.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void close() {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    void close(ErrorCode errorCode, ErrorCode errorCode2) {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            errorCode = null;
        } catch (IOException e) {
            errorCode = e;
        }
        synchronized (this) {
            if (!this.streams.isEmpty()) {
                http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                this.streams.clear();
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e2) {
                    if (errorCode != null) {
                        errorCode = e2;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (ErrorCode errorCode22) {
            if (errorCode == null) {
                errorCode = errorCode22;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e3) {
            errorCode = e3;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (errorCode != null) {
            throw errorCode;
        }
    }

    private void failConnection() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ IOException -> 0x0007 }
        r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ IOException -> 0x0007 }
        r2.close(r0, r1);	 Catch:{ IOException -> 0x0007 }
    L_0x0007:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.failConnection():void");
    }

    public void start() {
        start(true);
    }

    void start(boolean z) {
        if (z) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            z = this.okHttpSettings.getInitialWindowSize();
            if (!z) {
                this.writer.windowUpdate(0, (long) (z - true));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public void setSettings(Settings settings) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new ConnectionShutdownException();
                }
                this.okHttpSettings.merge(settings);
            }
            this.writer.settings(settings);
        }
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    void pushRequestLater(int r9, java.util.List<okhttp3.internal.http2.Header> r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.currentPushRequests;	 Catch:{ all -> 0x003e }
        r1 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x003e }
        r0 = r0.contains(r1);	 Catch:{ all -> 0x003e }
        if (r0 == 0) goto L_0x0014;	 Catch:{ all -> 0x003e }
    L_0x000d:
        r10 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x003e }
        r8.writeSynResetLater(r9, r10);	 Catch:{ all -> 0x003e }
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        return;	 Catch:{ all -> 0x003e }
    L_0x0014:
        r0 = r8.currentPushRequests;	 Catch:{ all -> 0x003e }
        r1 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x003e }
        r0.add(r1);	 Catch:{ all -> 0x003e }
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        r0 = r8.pushExecutor;	 Catch:{ RejectedExecutionException -> 0x003d }
        r7 = new okhttp3.internal.http2.Http2Connection$3;	 Catch:{ RejectedExecutionException -> 0x003d }
        r3 = "OkHttp %s Push Request[%s]";	 Catch:{ RejectedExecutionException -> 0x003d }
        r1 = 2;	 Catch:{ RejectedExecutionException -> 0x003d }
        r4 = new java.lang.Object[r1];	 Catch:{ RejectedExecutionException -> 0x003d }
        r1 = 0;	 Catch:{ RejectedExecutionException -> 0x003d }
        r2 = r8.hostname;	 Catch:{ RejectedExecutionException -> 0x003d }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x003d }
        r1 = 1;	 Catch:{ RejectedExecutionException -> 0x003d }
        r2 = java.lang.Integer.valueOf(r9);	 Catch:{ RejectedExecutionException -> 0x003d }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x003d }
        r1 = r7;	 Catch:{ RejectedExecutionException -> 0x003d }
        r2 = r8;	 Catch:{ RejectedExecutionException -> 0x003d }
        r5 = r9;	 Catch:{ RejectedExecutionException -> 0x003d }
        r6 = r10;	 Catch:{ RejectedExecutionException -> 0x003d }
        r1.<init>(r3, r4, r5, r6);	 Catch:{ RejectedExecutionException -> 0x003d }
        r0.execute(r7);	 Catch:{ RejectedExecutionException -> 0x003d }
    L_0x003d:
        return;
    L_0x003e:
        r9 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x003e }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.pushRequestLater(int, java.util.List):void");
    }

    void pushHeadersLater(int r10, java.util.List<okhttp3.internal.http2.Header> r11, boolean r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.pushExecutor;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r8 = new okhttp3.internal.http2.Http2Connection$4;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r3 = "OkHttp %s Push Headers[%s]";	 Catch:{ RejectedExecutionException -> 0x0020 }
        r1 = 2;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r4 = new java.lang.Object[r1];	 Catch:{ RejectedExecutionException -> 0x0020 }
        r1 = 0;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r2 = r9.hostname;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r1 = 1;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r2 = java.lang.Integer.valueOf(r10);	 Catch:{ RejectedExecutionException -> 0x0020 }
        r4[r1] = r2;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r1 = r8;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r2 = r9;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r5 = r10;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r6 = r11;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r7 = r12;	 Catch:{ RejectedExecutionException -> 0x0020 }
        r1.<init>(r3, r4, r5, r6, r7);	 Catch:{ RejectedExecutionException -> 0x0020 }
        r0.execute(r8);	 Catch:{ RejectedExecutionException -> 0x0020 }
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.pushHeadersLater(int, java.util.List, boolean):void");
    }

    void pushDataLater(int i, C7204e c7204e, int i2, boolean z) {
        final C8037c c8037c = new C8037c();
        long j = (long) i2;
        c7204e.mo6288a(j);
        c7204e.read(c8037c, j);
        if (c8037c.m38961a() == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
                public void execute() {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r5 = this;
                    r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ IOException -> 0x0038 }
                    r0 = r0.pushObserver;	 Catch:{ IOException -> 0x0038 }
                    r1 = r4;	 Catch:{ IOException -> 0x0038 }
                    r2 = r5;	 Catch:{ IOException -> 0x0038 }
                    r3 = r6;	 Catch:{ IOException -> 0x0038 }
                    r4 = r7;	 Catch:{ IOException -> 0x0038 }
                    r0 = r0.onData(r1, r2, r3, r4);	 Catch:{ IOException -> 0x0038 }
                    if (r0 == 0) goto L_0x001d;	 Catch:{ IOException -> 0x0038 }
                L_0x0012:
                    r1 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ IOException -> 0x0038 }
                    r1 = r1.writer;	 Catch:{ IOException -> 0x0038 }
                    r2 = r4;	 Catch:{ IOException -> 0x0038 }
                    r3 = okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x0038 }
                    r1.rstStream(r2, r3);	 Catch:{ IOException -> 0x0038 }
                L_0x001d:
                    if (r0 != 0) goto L_0x0023;	 Catch:{ IOException -> 0x0038 }
                L_0x001f:
                    r0 = r7;	 Catch:{ IOException -> 0x0038 }
                    if (r0 == 0) goto L_0x0038;	 Catch:{ IOException -> 0x0038 }
                L_0x0023:
                    r0 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ IOException -> 0x0038 }
                    monitor-enter(r0);	 Catch:{ IOException -> 0x0038 }
                    r1 = okhttp3.internal.http2.Http2Connection.this;	 Catch:{ all -> 0x0035 }
                    r1 = r1.currentPushRequests;	 Catch:{ all -> 0x0035 }
                    r2 = r4;	 Catch:{ all -> 0x0035 }
                    r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0035 }
                    r1.remove(r2);	 Catch:{ all -> 0x0035 }
                    monitor-exit(r0);	 Catch:{ all -> 0x0035 }
                    goto L_0x0038;	 Catch:{ all -> 0x0035 }
                L_0x0035:
                    r1 = move-exception;	 Catch:{ all -> 0x0035 }
                    monitor-exit(r0);	 Catch:{ all -> 0x0035 }
                    throw r1;	 Catch:{ IOException -> 0x0038 }
                L_0x0038:
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.5.execute():void");
                }
            });
            return;
        }
        c7204e = new StringBuilder();
        c7204e.append(c8037c.m38961a());
        c7204e.append(" != ");
        c7204e.append(i2);
        throw new IOException(c7204e.toString());
    }

    void pushResetLater(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.pushExecutor.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i)}) {
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i2, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
