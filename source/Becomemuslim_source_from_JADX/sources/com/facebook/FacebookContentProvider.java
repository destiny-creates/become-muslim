package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.facebook.internal.NativeAppCallAttachmentStore;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider extends ContentProvider {
    private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
    private static final String INVALID_FILE_NAME = "..";
    private static final String TAG = "com.facebook.FacebookContentProvider";

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

    public static String getAttachmentUrl(String str, UUID uuid, String str2) {
        return String.format("%s%s/%s/%s", new Object[]{ATTACHMENT_URL_BASE, str, uuid.toString(), str2});
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        uri = parseCallIdAndAttachmentName(uri);
        if (uri != null) {
            try {
                uri = NativeAppCallAttachmentStore.openAttachment((UUID) uri.first, (String) uri.second);
                if (uri != null) {
                    return ParcelFileDescriptor.open(uri, 268435456);
                }
                throw new FileNotFoundException();
            } catch (Uri uri2) {
                str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Got unexpected exception:");
                stringBuilder.append(uri2);
                Log.e(str, stringBuilder.toString());
                throw uri2;
            }
        }
        throw new FileNotFoundException();
    }

    android.util.Pair<java.util.UUID, java.lang.String> parseCallIdAndAttachmentName(android.net.Uri r3) {
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
        r3 = r3.getPath();	 Catch:{ Exception -> 0x0034 }
        r0 = 1;	 Catch:{ Exception -> 0x0034 }
        r3 = r3.substring(r0);	 Catch:{ Exception -> 0x0034 }
        r1 = "/";	 Catch:{ Exception -> 0x0034 }
        r3 = r3.split(r1);	 Catch:{ Exception -> 0x0034 }
        r1 = 0;	 Catch:{ Exception -> 0x0034 }
        r1 = r3[r1];	 Catch:{ Exception -> 0x0034 }
        r3 = r3[r0];	 Catch:{ Exception -> 0x0034 }
        r0 = "..";	 Catch:{ Exception -> 0x0034 }
        r0 = r0.contentEquals(r1);	 Catch:{ Exception -> 0x0034 }
        if (r0 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x0034 }
    L_0x001c:
        r0 = "..";	 Catch:{ Exception -> 0x0034 }
        r0 = r0.contentEquals(r3);	 Catch:{ Exception -> 0x0034 }
        if (r0 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x0034 }
    L_0x0024:
        r0 = java.util.UUID.fromString(r1);	 Catch:{ Exception -> 0x0034 }
        r1 = new android.util.Pair;	 Catch:{ Exception -> 0x0034 }
        r1.<init>(r0, r3);	 Catch:{ Exception -> 0x0034 }
        return r1;	 Catch:{ Exception -> 0x0034 }
    L_0x002e:
        r3 = new java.lang.Exception;	 Catch:{ Exception -> 0x0034 }
        r3.<init>();	 Catch:{ Exception -> 0x0034 }
        throw r3;	 Catch:{ Exception -> 0x0034 }
    L_0x0034:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookContentProvider.parseCallIdAndAttachmentName(android.net.Uri):android.util.Pair<java.util.UUID, java.lang.String>");
    }
}
