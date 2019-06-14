package com.facebook.imagepipeline.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityThreadFactory implements ThreadFactory {
    private final boolean mAddThreadNumber;
    private final String mPrefix;
    private final AtomicInteger mThreadNumber;
    private final int mThreadPriority;

    public PriorityThreadFactory(int i) {
        this(i, "PriorityThreadFactory", true);
    }

    public PriorityThreadFactory(int i, String str, boolean z) {
        this.mThreadNumber = new AtomicInteger(1);
        this.mThreadPriority = i;
        this.mPrefix = str;
        this.mAddThreadNumber = z;
    }

    public Thread newThread(final Runnable runnable) {
        Runnable c17701 = new Runnable() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                /*
                r1 = this;
                r0 = com.facebook.imagepipeline.core.PriorityThreadFactory.this;	 Catch:{ Throwable -> 0x0009 }
                r0 = r0.mThreadPriority;	 Catch:{ Throwable -> 0x0009 }
                android.os.Process.setThreadPriority(r0);	 Catch:{ Throwable -> 0x0009 }
            L_0x0009:
                r0 = r3;
                r0.run();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.core.PriorityThreadFactory.1.run():void");
            }
        };
        if (this.mAddThreadNumber != null) {
            runnable = new StringBuilder();
            runnable.append(this.mPrefix);
            runnable.append("-");
            runnable.append(this.mThreadNumber.getAndIncrement());
            runnable = runnable.toString();
        } else {
            runnable = this.mPrefix;
        }
        return new Thread(c17701, runnable);
    }
}
