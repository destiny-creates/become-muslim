package com.facebook.react.views.imagehelper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import java.util.HashMap;
import java.util.Map;

public class ResourceDrawableIdHelper {
    private static final String LOCAL_RESOURCE_SCHEME = "res";
    private static volatile ResourceDrawableIdHelper sResourceDrawableIdHelper;
    private Map<String, Integer> mResourceDrawableIdMap = new HashMap();

    private ResourceDrawableIdHelper() {
    }

    public static ResourceDrawableIdHelper getInstance() {
        if (sResourceDrawableIdHelper == null) {
            synchronized (ResourceDrawableIdHelper.class) {
                if (sResourceDrawableIdHelper == null) {
                    sResourceDrawableIdHelper = new ResourceDrawableIdHelper();
                }
            }
        }
        return sResourceDrawableIdHelper;
    }

    public synchronized void clear() {
        this.mResourceDrawableIdMap.clear();
    }

    public int getResourceDrawableId(android.content.Context r3, java.lang.String r4) {
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
        r2 = this;
        if (r4 == 0) goto L_0x004d;
    L_0x0002:
        r0 = r4.isEmpty();
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        goto L_0x004d;
    L_0x0009:
        r4 = r4.toLowerCase();
        r0 = "-";
        r1 = "_";
        r4 = r4.replace(r0, r1);
        r0 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x001a }
        return r0;
    L_0x001a:
        monitor-enter(r2);
        r0 = r2.mResourceDrawableIdMap;	 Catch:{ all -> 0x004a }
        r0 = r0.containsKey(r4);	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0031;	 Catch:{ all -> 0x004a }
    L_0x0023:
        r3 = r2.mResourceDrawableIdMap;	 Catch:{ all -> 0x004a }
        r3 = r3.get(r4);	 Catch:{ all -> 0x004a }
        r3 = (java.lang.Integer) r3;	 Catch:{ all -> 0x004a }
        r3 = r3.intValue();	 Catch:{ all -> 0x004a }
        monitor-exit(r2);	 Catch:{ all -> 0x004a }
        return r3;	 Catch:{ all -> 0x004a }
    L_0x0031:
        r0 = r3.getResources();	 Catch:{ all -> 0x004a }
        r1 = "drawable";	 Catch:{ all -> 0x004a }
        r3 = r3.getPackageName();	 Catch:{ all -> 0x004a }
        r3 = r0.getIdentifier(r4, r1, r3);	 Catch:{ all -> 0x004a }
        r0 = r2.mResourceDrawableIdMap;	 Catch:{ all -> 0x004a }
        r1 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x004a }
        r0.put(r4, r1);	 Catch:{ all -> 0x004a }
        monitor-exit(r2);	 Catch:{ all -> 0x004a }
        return r3;	 Catch:{ all -> 0x004a }
    L_0x004a:
        r3 = move-exception;	 Catch:{ all -> 0x004a }
        monitor-exit(r2);	 Catch:{ all -> 0x004a }
        throw r3;
    L_0x004d:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.imagehelper.ResourceDrawableIdHelper.getResourceDrawableId(android.content.Context, java.lang.String):int");
    }

    public Drawable getResourceDrawable(Context context, String str) {
        str = getResourceDrawableId(context, str);
        return str > null ? context.getResources().getDrawable(str) : null;
    }

    public Uri getResourceDrawableUri(Context context, String str) {
        context = getResourceDrawableId(context, str);
        return context > null ? new Builder().scheme("res").path(String.valueOf(context)).build() : Uri.EMPTY;
    }
}
