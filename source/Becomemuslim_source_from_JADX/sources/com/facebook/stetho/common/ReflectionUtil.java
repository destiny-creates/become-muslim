package com.facebook.stetho.common;

import java.lang.reflect.Field;

public final class ReflectionUtil {
    private ReflectionUtil() {
    }

    public static java.lang.Class<?> tryGetClassForName(java.lang.String r0) {
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
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.ReflectionUtil.tryGetClassForName(java.lang.String):java.lang.Class<?>");
    }

    public static Field tryGetDeclaredField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable e) {
            LogUtil.m5741d(e, "Could not retrieve %s field from %s", str, cls);
            return null;
        }
    }

    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (Field field2) {
            throw new RuntimeException(field2);
        }
    }
}
