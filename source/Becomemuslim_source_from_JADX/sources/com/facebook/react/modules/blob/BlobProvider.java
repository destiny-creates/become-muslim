package com.facebook.react.modules.blob;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public final class BlobProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public android.os.ParcelFileDescriptor openFile(android.net.Uri r4, java.lang.String r5) {
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
        r3 = this;
        r0 = "r";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0075;
    L_0x0008:
        r5 = r3.getContext();
        r5 = r5.getApplicationContext();
        r0 = r5 instanceof com.facebook.react.ReactApplication;
        r1 = 0;
        if (r0 == 0) goto L_0x002c;
    L_0x0015:
        r5 = (com.facebook.react.ReactApplication) r5;
        r5 = r5.getReactNativeHost();
        r5 = r5.getReactInstanceManager();
        r5 = r5.getCurrentReactContext();
        r0 = com.facebook.react.modules.blob.BlobModule.class;
        r5 = r5.getNativeModule(r0);
        r5 = (com.facebook.react.modules.blob.BlobModule) r5;
        goto L_0x002d;
    L_0x002c:
        r5 = r1;
    L_0x002d:
        if (r5 == 0) goto L_0x006d;
    L_0x002f:
        r5 = r5.resolve(r4);
        if (r5 == 0) goto L_0x004d;
    L_0x0035:
        r4 = android.os.ParcelFileDescriptor.createPipe();	 Catch:{ IOException -> 0x004c }
        r0 = 0;
        r0 = r4[r0];
        r2 = 1;
        r4 = r4[r2];
        r2 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
        r2.<init>(r4);
        r2.write(r5);	 Catch:{ IOException -> 0x004b }
        r2.close();	 Catch:{ IOException -> 0x004b }
        return r0;
    L_0x004b:
        return r1;
    L_0x004c:
        return r1;
    L_0x004d:
        r5 = new java.io.FileNotFoundException;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Cannot open ";
        r0.append(r1);
        r4 = r4.toString();
        r0.append(r4);
        r4 = ", blob not found.";
        r0.append(r4);
        r4 = r0.toString();
        r5.<init>(r4);
        throw r5;
    L_0x006d:
        r4 = new java.lang.RuntimeException;
        r5 = "No blob module associated with BlobProvider";
        r4.<init>(r5);
        throw r4;
    L_0x0075:
        r0 = new java.io.FileNotFoundException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot open ";
        r1.append(r2);
        r4 = r4.toString();
        r1.append(r4);
        r4 = " in mode '";
        r1.append(r4);
        r1.append(r5);
        r4 = "'";
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.blob.BlobProvider.openFile(android.net.Uri, java.lang.String):android.os.ParcelFileDescriptor");
    }
}
