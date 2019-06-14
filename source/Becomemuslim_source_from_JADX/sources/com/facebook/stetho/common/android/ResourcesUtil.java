package com.facebook.stetho.common.android;

import android.content.res.Resources;
import com.facebook.imageutils.JfifUtil;

public class ResourcesUtil {
    private static int getResourcePackageId(int i) {
        return (i >>> 24) & JfifUtil.MARKER_FIRST_BYTE;
    }

    private ResourcesUtil() {
    }

    public static java.lang.String getIdStringQuietly(java.lang.Object r1, android.content.res.Resources r2, int r3) {
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
        r2 = getIdString(r2, r3);	 Catch:{ NotFoundException -> 0x0005 }
        return r2;
    L_0x0005:
        r2 = getFallbackIdString(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r0 = "Unknown identifier encountered on ";
        r3.append(r0);
        r3.append(r1);
        r1 = ": ";
        r3.append(r1);
        r3.append(r2);
        r1 = r3.toString();
        com.facebook.stetho.common.LogUtil.m5754w(r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.android.ResourcesUtil.getIdStringQuietly(java.lang.Object, android.content.res.Resources, int):java.lang.String");
    }

    public static String getIdString(Resources resources, int i) {
        if (resources == null) {
            return getFallbackIdString(i);
        }
        String resourcePackageName;
        String str;
        if (getResourcePackageId(i) != 127) {
            resourcePackageName = resources.getResourcePackageName(i);
            str = ":";
        } else {
            resourcePackageName = "";
            str = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i);
        resources = resources.getResourceEntryName(i);
        i = new StringBuilder(((((resourcePackageName.length() + 1) + str.length()) + resourceTypeName.length()) + 1) + resources.length());
        i.append("@");
        i.append(resourcePackageName);
        i.append(str);
        i.append(resourceTypeName);
        i.append("/");
        i.append(resources);
        return i.toString();
    }

    private static String getFallbackIdString(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        stringBuilder.append(Integer.toHexString(i));
        return stringBuilder.toString();
    }
}
