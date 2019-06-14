package com.facebook.imagepipeline.producers;

import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.Executor;

public class LocalResourceFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalResourceFetchProducer";
    private final Resources mResources;

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public LocalResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Resources resources) {
        super(executor, pooledByteBufferFactory);
        this.mResources = resources;
    }

    protected EncodedImage getEncodedImage(ImageRequest imageRequest) {
        return getEncodedImage(this.mResources.openRawResource(getResourceId(imageRequest)), getLength(imageRequest));
    }

    private int getLength(com.facebook.imagepipeline.request.ImageRequest r4) {
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
        r0 = 0;
        r1 = r3.mResources;	 Catch:{ NotFoundException -> 0x0024, all -> 0x001d }
        r4 = getResourceId(r4);	 Catch:{ NotFoundException -> 0x0024, all -> 0x001d }
        r4 = r1.openRawResourceFd(r4);	 Catch:{ NotFoundException -> 0x0024, all -> 0x001d }
        r0 = r4.getLength();	 Catch:{ NotFoundException -> 0x001b, all -> 0x0016 }
        r0 = (int) r0;
        if (r4 == 0) goto L_0x0015;
    L_0x0012:
        r4.close();	 Catch:{ IOException -> 0x0015 }
    L_0x0015:
        return r0;
    L_0x0016:
        r0 = move-exception;
        r2 = r0;
        r0 = r4;
        r4 = r2;
        goto L_0x001e;
    L_0x001b:
        r0 = r4;
        goto L_0x0024;
    L_0x001d:
        r4 = move-exception;
    L_0x001e:
        if (r0 == 0) goto L_0x0023;
    L_0x0020:
        r0.close();	 Catch:{ IOException -> 0x0023 }
    L_0x0023:
        throw r4;
    L_0x0024:
        r4 = -1;
        if (r0 == 0) goto L_0x002a;
    L_0x0027:
        r0.close();	 Catch:{ IOException -> 0x002a }
    L_0x002a:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.LocalResourceFetchProducer.getLength(com.facebook.imagepipeline.request.ImageRequest):int");
    }

    private static int getResourceId(ImageRequest imageRequest) {
        return Integer.parseInt(imageRequest.getSourceUri().getPath().substring(1));
    }
}
