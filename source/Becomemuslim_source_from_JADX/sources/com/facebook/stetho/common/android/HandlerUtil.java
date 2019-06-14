package com.facebook.stetho.common.android;

import android.os.Handler;
import android.os.Looper;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;

public final class HandlerUtil {

    private static abstract class WaitableRunnable<V> implements Runnable {
        private Exception mException;
        private boolean mIsDone;
        private V mValue;

        protected abstract V onRun();

        protected WaitableRunnable() {
        }

        public final void run() {
            try {
                this.mValue = onRun();
                this.mException = null;
                synchronized (this) {
                    this.mIsDone = true;
                    notifyAll();
                }
            } catch (Exception e) {
                try {
                    this.mValue = null;
                    this.mException = e;
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        this.mIsDone = true;
                        notifyAll();
                    }
                }
            }
        }

        public V invoke(Handler handler) {
            if (handler.post(this) != null) {
                join();
                if (this.mException == null) {
                    return this.mValue;
                }
                throw new RuntimeException(this.mException);
            }
            throw new RuntimeException("Handler.post() returned false");
        }

        private void join() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
            /*
            r1 = this;
            monitor-enter(r1);
        L_0x0001:
            r0 = r1.mIsDone;	 Catch:{ all -> 0x000b }
            if (r0 != 0) goto L_0x0009;
        L_0x0005:
            r1.wait();	 Catch:{ InterruptedException -> 0x0001 }
            goto L_0x0001;
        L_0x0009:
            monitor-exit(r1);	 Catch:{ all -> 0x000b }
            return;	 Catch:{ all -> 0x000b }
        L_0x000b:
            r0 = move-exception;	 Catch:{ all -> 0x000b }
            monitor-exit(r1);	 Catch:{ all -> 0x000b }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.android.HandlerUtil.WaitableRunnable.join():void");
        }
    }

    private HandlerUtil() {
    }

    public static boolean checkThreadAccess(Handler handler) {
        return Looper.myLooper() == handler.getLooper() ? true : null;
    }

    public static void verifyThreadAccess(Handler handler) {
        Util.throwIfNot(checkThreadAccess(handler));
    }

    public static <V> V postAndWait(Handler handler, final UncheckedCallable<V> uncheckedCallable) {
        if (!checkThreadAccess(handler)) {
            return new WaitableRunnable<V>() {
                protected V onRun() {
                    return uncheckedCallable.call();
                }
            }.invoke(handler);
        }
        try {
            return uncheckedCallable.call();
        } catch (Handler handler2) {
            throw new RuntimeException(handler2);
        }
    }

    public static void postAndWait(Handler handler, final Runnable runnable) {
        if (checkThreadAccess(handler)) {
            try {
                runnable.run();
                return;
            } catch (Handler handler2) {
                throw new RuntimeException(handler2);
            }
        }
        new WaitableRunnable<Void>() {
            protected Void onRun() {
                runnable.run();
                return null;
            }
        }.invoke(handler2);
    }
}
