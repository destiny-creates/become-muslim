package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.util.concurrent.atomic.AtomicInteger;

public class LocalSocketServer {
    private static final int MAX_BIND_RETRIES = 2;
    private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
    private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
    private final String mAddress;
    private final String mFriendlyName;
    private Thread mListenerThread;
    private LocalServerSocket mServerSocket;
    private final SocketHandler mSocketHandler;
    private boolean mStopped;
    private final AtomicInteger mThreadId = new AtomicInteger();

    private static class WorkerThread extends Thread {
        private final LocalSocket mSocket;
        private final SocketHandler mSocketHandler;

        public WorkerThread(LocalSocket localSocket, SocketHandler socketHandler) {
            this.mSocket = localSocket;
            this.mSocketHandler = socketHandler;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r4 = this;
            r0 = r4.mSocketHandler;	 Catch:{ IOException -> 0x000f }
            r1 = r4.mSocket;	 Catch:{ IOException -> 0x000f }
            r0.onAccepted(r1);	 Catch:{ IOException -> 0x000f }
        L_0x0007:
            r0 = r4.mSocket;	 Catch:{ IOException -> 0x001c }
            r0.close();	 Catch:{ IOException -> 0x001c }
            goto L_0x001c;
        L_0x000d:
            r0 = move-exception;
            goto L_0x001d;
        L_0x000f:
            r0 = move-exception;
            r1 = "I/O error: %s";	 Catch:{ all -> 0x000d }
            r2 = 1;	 Catch:{ all -> 0x000d }
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x000d }
            r3 = 0;	 Catch:{ all -> 0x000d }
            r2[r3] = r0;	 Catch:{ all -> 0x000d }
            com.facebook.stetho.common.LogUtil.m5755w(r1, r2);	 Catch:{ all -> 0x000d }
            goto L_0x0007;
        L_0x001c:
            return;
        L_0x001d:
            r1 = r4.mSocket;	 Catch:{ IOException -> 0x0022 }
            r1.close();	 Catch:{ IOException -> 0x0022 }
        L_0x0022:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketServer.WorkerThread.run():void");
        }
    }

    public LocalSocketServer(String str, String str2, SocketHandler socketHandler) {
        this.mFriendlyName = (String) Util.throwIfNull(str);
        this.mAddress = (String) Util.throwIfNull(str2);
        this.mSocketHandler = socketHandler;
    }

    public String getName() {
        return this.mFriendlyName;
    }

    public void run() {
        synchronized (this) {
            if (this.mStopped) {
                return;
            }
            this.mListenerThread = Thread.currentThread();
            listenOnAddress(this.mAddress);
        }
    }

    private void listenOnAddress(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = bindToSocket(r4);
        r3.mServerSocket = r0;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Listening on @";
        r0.append(r1);
        r0.append(r4);
        r0 = r0.toString();
        com.facebook.stetho.common.LogUtil.m5746i(r0);
    L_0x001a:
        r0 = java.lang.Thread.interrupted();
        if (r0 != 0) goto L_0x006e;
    L_0x0020:
        r0 = r3.mServerSocket;	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0 = r0.accept();	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r1 = new com.facebook.stetho.server.LocalSocketServer$WorkerThread;	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r2 = r3.mSocketHandler;	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r1.<init>(r0, r2);	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0 = new java.lang.StringBuilder;	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0.<init>();	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r2 = "StethoWorker-";	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0.append(r2);	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r2 = r3.mFriendlyName;	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0.append(r2);	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r2 = "-";	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0.append(r2);	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r2 = r3.mThreadId;	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r2 = r2.incrementAndGet();	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0.append(r2);	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0 = r0.toString();	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r1.setName(r0);	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r0 = 1;	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r1.setDaemon(r0);	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        r1.start();	 Catch:{ SocketException -> 0x0060, InterruptedIOException -> 0x006e, IOException -> 0x0059 }
        goto L_0x001a;
    L_0x0059:
        r0 = move-exception;
        r1 = "I/O error initialising connection thread";
        com.facebook.stetho.common.LogUtil.m5756w(r0, r1);
        goto L_0x006e;
    L_0x0060:
        r0 = move-exception;
        r1 = java.lang.Thread.interrupted();
        if (r1 == 0) goto L_0x0068;
    L_0x0067:
        goto L_0x006e;
    L_0x0068:
        r1 = "I/O error";
        com.facebook.stetho.common.LogUtil.m5756w(r0, r1);
        goto L_0x001a;
    L_0x006e:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Server shutdown on @";
        r0.append(r1);
        r0.append(r4);
        r4 = r0.toString();
        com.facebook.stetho.common.LogUtil.m5746i(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketServer.listenOnAddress(java.lang.String):void");
    }

    public void stop() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = 1;
        r1.mStopped = r0;	 Catch:{ all -> 0x001a }
        r0 = r1.mListenerThread;	 Catch:{ all -> 0x001a }
        if (r0 != 0) goto L_0x000a;	 Catch:{ all -> 0x001a }
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        return;	 Catch:{ all -> 0x001a }
    L_0x000a:
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        r0 = r1.mListenerThread;
        r0.interrupt();
        r0 = r1.mServerSocket;	 Catch:{ IOException -> 0x0019 }
        if (r0 == 0) goto L_0x0019;	 Catch:{ IOException -> 0x0019 }
    L_0x0014:
        r0 = r1.mServerSocket;	 Catch:{ IOException -> 0x0019 }
        r0.close();	 Catch:{ IOException -> 0x0019 }
    L_0x0019:
        return;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.server.LocalSocketServer.stop():void");
    }

    private static LocalServerSocket bindToSocket(String str) {
        int i = 2;
        Throwable th = null;
        while (true) {
            try {
                break;
            } catch (Throwable e) {
                LogUtil.m5756w(e, "Binding error, sleep 1000 ms...");
                if (th == null) {
                    th = e;
                }
                Util.sleepUninterruptibly(1000);
                r2 = i - 1;
                if (i > 0) {
                    int i2;
                    i = i2;
                } else {
                    throw th;
                }
            }
        }
        if (LogUtil.isLoggable(3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Trying to bind to @");
            stringBuilder.append(str);
            LogUtil.m5738d(stringBuilder.toString());
        }
        return new LocalServerSocket(str);
    }
}
