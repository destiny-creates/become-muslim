package com.facebook.react.packagerconnection;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.af;
import expolib_v1.p321a.ag;
import expolib_v1.p332b.C6251f;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.TimeUnit;

public final class ReconnectingWebSocket extends ag {
    private static final int RECONNECT_DELAY_MS = 2000;
    private static final String TAG = "ReconnectingWebSocket";
    private boolean mClosed = false;
    private ConnectionCallback mConnectionCallback;
    private final Handler mHandler;
    private MessageCallback mMessageCallback;
    private boolean mSuppressConnectionErrors;
    private final String mUrl;
    private af mWebSocket;

    /* renamed from: com.facebook.react.packagerconnection.ReconnectingWebSocket$1 */
    class C19601 implements Runnable {
        C19601() {
        }

        public void run() {
            ReconnectingWebSocket.this.delayedReconnect();
        }
    }

    public interface ConnectionCallback {
        void onConnected();

        void onDisconnected();
    }

    public interface MessageCallback {
        void onMessage(C6251f c6251f);

        void onMessage(String str);
    }

    public ReconnectingWebSocket(String str, MessageCallback messageCallback, ConnectionCallback connectionCallback) {
        this.mUrl = str;
        this.mMessageCallback = messageCallback;
        this.mConnectionCallback = connectionCallback;
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void connect() {
        if (this.mClosed) {
            throw new IllegalStateException("Can't connect closed client");
        }
        new C6243a().a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(0, TimeUnit.MINUTES).a().a(new C6245a().a(this.mUrl).b(), this);
    }

    private synchronized void delayedReconnect() {
        if (!this.mClosed) {
            connect();
        }
    }

    private void reconnect() {
        if (this.mClosed) {
            throw new IllegalStateException("Can't reconnect closed client");
        }
        if (!this.mSuppressConnectionErrors) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't connect to \"");
            stringBuilder.append(this.mUrl);
            stringBuilder.append("\", will silently retry");
            FLog.m5714w(str, stringBuilder.toString());
            this.mSuppressConnectionErrors = true;
        }
        this.mHandler.postDelayed(new C19601(), 2000);
    }

    public void closeQuietly() {
        this.mClosed = true;
        closeWebSocketQuietly();
        this.mMessageCallback = null;
        if (this.mConnectionCallback != null) {
            this.mConnectionCallback.onDisconnected();
        }
    }

    private void closeWebSocketQuietly() {
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
        r0 = r3.mWebSocket;
        if (r0 == 0) goto L_0x0010;
    L_0x0004:
        r0 = r3.mWebSocket;	 Catch:{ Exception -> 0x000d }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x000d }
        r2 = "End of session";	 Catch:{ Exception -> 0x000d }
        r0.a(r1, r2);	 Catch:{ Exception -> 0x000d }
    L_0x000d:
        r0 = 0;
        r3.mWebSocket = r0;
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.packagerconnection.ReconnectingWebSocket.closeWebSocketQuietly():void");
    }

    private void abort(String str, Throwable th) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Error occurred, shutting down websocket connection: ");
        stringBuilder.append(str);
        FLog.m5675e(str2, stringBuilder.toString(), th);
        closeWebSocketQuietly();
    }

    public synchronized void onOpen(af afVar, ab abVar) {
        this.mWebSocket = afVar;
        this.mSuppressConnectionErrors = null;
        if (this.mConnectionCallback != null) {
            this.mConnectionCallback.onConnected();
        }
    }

    public synchronized void onFailure(af afVar, Throwable th, ab abVar) {
        if (this.mWebSocket != null) {
            abort("Websocket exception", th);
        }
        if (this.mClosed == null) {
            if (this.mConnectionCallback != null) {
                this.mConnectionCallback.onDisconnected();
            }
            reconnect();
        }
    }

    public synchronized void onMessage(af afVar, String str) {
        if (this.mMessageCallback != null) {
            this.mMessageCallback.onMessage(str);
        }
    }

    public synchronized void onMessage(af afVar, C6251f c6251f) {
        if (this.mMessageCallback != null) {
            this.mMessageCallback.onMessage(c6251f);
        }
    }

    public synchronized void onClosed(af afVar, int i, String str) {
        this.mWebSocket = null;
        if (this.mClosed == null) {
            if (this.mConnectionCallback != null) {
                this.mConnectionCallback.onDisconnected();
            }
            reconnect();
        }
    }

    public synchronized void sendMessage(String str) {
        if (this.mWebSocket != null) {
            this.mWebSocket.a(str);
        } else {
            throw new ClosedChannelException();
        }
    }

    public synchronized void sendMessage(C6251f c6251f) {
        if (this.mWebSocket != null) {
            this.mWebSocket.a(c6251f);
        } else {
            throw new ClosedChannelException();
        }
    }
}
