package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.net.Uri;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import expo.modules.contacts.EXColumns;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.Executor;

public class LocalContentUriFetchProducer extends LocalFetchProducer {
    public static final String PRODUCER_NAME = "LocalContentUriFetchProducer";
    private static final String[] PROJECTION = new String[]{EXColumns.ID, "_data"};
    private final ContentResolver mContentResolver;

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public LocalContentUriFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    protected com.facebook.imagepipeline.image.EncodedImage getEncodedImage(com.facebook.imagepipeline.request.ImageRequest r4) {
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
        r4 = r4.getSourceUri();
        r0 = com.facebook.common.util.UriUtil.isLocalContactUri(r4);
        r1 = -1;
        if (r0 == 0) goto L_0x0073;
    L_0x000b:
        r0 = r4.toString();
        r2 = "/photo";
        r0 = r0.endsWith(r2);
        if (r0 == 0) goto L_0x001f;
    L_0x0017:
        r0 = r3.mContentResolver;
        r4 = r0.openInputStream(r4);
        r0 = r4;
        goto L_0x0057;
    L_0x001f:
        r0 = r4.toString();
        r2 = "/display_photo";
        r0 = r0.endsWith(r2);
        if (r0 == 0) goto L_0x004f;
    L_0x002b:
        r0 = r3.mContentResolver;	 Catch:{ IOException -> 0x0038 }
        r2 = "r";	 Catch:{ IOException -> 0x0038 }
        r0 = r0.openAssetFileDescriptor(r4, r2);	 Catch:{ IOException -> 0x0038 }
        r0 = r0.createInputStream();	 Catch:{ IOException -> 0x0038 }
        goto L_0x0057;
    L_0x0038:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Contact photo does not exist: ";
        r1.append(r2);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
    L_0x004f:
        r0 = r3.mContentResolver;
        r0 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r0, r4);
        if (r0 == 0) goto L_0x005c;
    L_0x0057:
        r4 = r3.getEncodedImage(r0, r1);
        return r4;
    L_0x005c:
        r0 = new java.io.IOException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Contact photo does not exist: ";
        r1.append(r2);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
    L_0x0073:
        r0 = com.facebook.common.util.UriUtil.isLocalCameraUri(r4);
        if (r0 == 0) goto L_0x0080;
    L_0x0079:
        r0 = r3.getCameraImage(r4);
        if (r0 == 0) goto L_0x0080;
    L_0x007f:
        return r0;
    L_0x0080:
        r0 = r3.mContentResolver;
        r4 = r0.openInputStream(r4);
        r4 = r3.getEncodedImage(r4, r1);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.LocalContentUriFetchProducer.getEncodedImage(com.facebook.imagepipeline.request.ImageRequest):com.facebook.imagepipeline.image.EncodedImage");
    }

    private EncodedImage getCameraImage(Uri uri) {
        uri = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (uri == null) {
            return null;
        }
        try {
            if (uri.getCount() == 0) {
                return null;
            }
            uri.moveToFirst();
            String string = uri.getString(uri.getColumnIndex("_data"));
            if (string != null) {
                EncodedImage encodedImage = getEncodedImage(new FileInputStream(string), getLength(string));
                uri.close();
                return encodedImage;
            }
            uri.close();
            return null;
        } finally {
            uri.close();
        }
    }

    private static int getLength(String str) {
        return str == null ? -1 : (int) new File(str).length();
    }
}
