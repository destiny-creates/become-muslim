package com.facebook.react.fabric;

import com.facebook.react.bridge.ReactContext;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private static final String TAG = "Scheduler";
    private final ExecutorService mExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
    private final ReactContext mReactContext;

    public void flushSerial(Work work) {
    }

    public void flushSync(Work work) {
    }

    public void scheduleSerial(Work work) {
    }

    public Scheduler(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    public void scheduleWork(final com.facebook.react.fabric.Work r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r0 = r2.mExecutor;	 Catch:{ RejectedExecutionException -> 0x000b }
        r1 = new com.facebook.react.fabric.Scheduler$1;	 Catch:{ RejectedExecutionException -> 0x000b }
        r1.<init>(r3);	 Catch:{ RejectedExecutionException -> 0x000b }
        r0.execute(r1);	 Catch:{ RejectedExecutionException -> 0x000b }
        goto L_0x0012;
    L_0x000b:
        r3 = TAG;
        r0 = "Unable to schedule task.";
        com.facebook.common.logging.FLog.m5686i(r3, r0);
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.Scheduler.scheduleWork(com.facebook.react.fabric.Work):void");
    }

    public void shutdown() {
        this.mExecutor.shutdownNow();
    }
}
