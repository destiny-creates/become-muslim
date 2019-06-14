package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.Util;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

class GunzippingOutputStream extends FilterOutputStream {
    private static final ExecutorService sExecutor = Executors.newCachedThreadPool();
    private final Future<Void> mCopyFuture;

    private static class GunzippingCallable implements Callable<Void> {
        private final InputStream mIn;
        private final OutputStream mOut;

        public GunzippingCallable(InputStream inputStream, OutputStream outputStream) {
            this.mIn = inputStream;
            this.mOut = outputStream;
        }

        public Void call() {
            InputStream gZIPInputStream = new GZIPInputStream(this.mIn);
            try {
                Util.copy(gZIPInputStream, this.mOut, new byte[1024]);
                return null;
            } finally {
                gZIPInputStream.close();
                this.mOut.close();
            }
        }
    }

    public static GunzippingOutputStream create(OutputStream outputStream) {
        InputStream pipedInputStream = new PipedInputStream();
        return new GunzippingOutputStream(new PipedOutputStream(pipedInputStream), sExecutor.submit(new GunzippingCallable(pipedInputStream, outputStream)));
    }

    private GunzippingOutputStream(OutputStream outputStream, Future<Void> future) {
        super(outputStream);
        this.mCopyFuture = future;
    }

    public void close() {
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
        super.close();	 Catch:{ all -> 0x000b }
        r0 = r2.mCopyFuture;	 Catch:{ IOException -> 0x0009 }
        getAndRethrow(r0);	 Catch:{ IOException -> 0x0009 }
        return;
    L_0x0009:
        r0 = move-exception;
        throw r0;
    L_0x000b:
        r0 = move-exception;
        r1 = r2.mCopyFuture;	 Catch:{ IOException -> 0x0011 }
        getAndRethrow(r1);	 Catch:{ IOException -> 0x0011 }
    L_0x0011:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.network.GunzippingOutputStream.close():void");
    }

    private static <T> T getAndRethrow(java.util.concurrent.Future<T> r2) {
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
    L_0x0000:
        r0 = r2.get();	 Catch:{ InterruptedException -> 0x0000, ExecutionException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = move-exception;
        r0 = r0.getCause();
        r1 = java.io.IOException.class;
        com.facebook.stetho.common.ExceptionUtil.propagateIfInstanceOf(r0, r1);
        com.facebook.stetho.common.ExceptionUtil.propagate(r0);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.network.GunzippingOutputStream.getAndRethrow(java.util.concurrent.Future):T");
    }
}
