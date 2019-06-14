package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.net.Uri;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class ImageSource {
    private boolean isResource;
    private double mSize;
    private String mSource;
    private Uri mUri;

    public ImageSource(Context context, String str, double d, double d2) {
        this.mSource = str;
        this.mSize = d * d2;
        this.mUri = computeUri(context);
    }

    public ImageSource(Context context, String str) {
        this(context, str, 0.0d, 0.0d);
    }

    public String getSource() {
        return this.mSource;
    }

    public Uri getUri() {
        return (Uri) Assertions.assertNotNull(this.mUri);
    }

    public double getSize() {
        return this.mSize;
    }

    public boolean isResource() {
        return this.isResource;
    }

    private android.net.Uri computeUri(android.content.Context r3) {
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
        r0 = r2.mSource;	 Catch:{ Exception -> 0x0011 }
        r0 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x0011 }
        r1 = r0.getScheme();	 Catch:{ Exception -> 0x0011 }
        if (r1 != 0) goto L_0x0010;	 Catch:{ Exception -> 0x0011 }
    L_0x000c:
        r0 = r2.computeLocalUri(r3);	 Catch:{ Exception -> 0x0011 }
    L_0x0010:
        return r0;
    L_0x0011:
        r3 = r2.computeLocalUri(r3);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.imagehelper.ImageSource.computeUri(android.content.Context):android.net.Uri");
    }

    private Uri computeLocalUri(Context context) {
        this.isResource = true;
        return ResourceDrawableIdHelper.getInstance().getResourceDrawableUri(context, this.mSource);
    }
}
