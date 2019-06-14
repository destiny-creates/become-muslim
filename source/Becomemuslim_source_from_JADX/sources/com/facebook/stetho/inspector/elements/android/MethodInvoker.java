package com.facebook.stetho.inspector.elements.android;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.util.Arrays;
import java.util.List;

public class MethodInvoker {
    private static final List<TypedMethodInvoker<?>> invokers = Arrays.asList(new TypedMethodInvoker[]{new StringMethodInvoker(), new CharSequenceMethodInvoker(), new IntegerMethodInvoker(), new FloatMethodInvoker(), new BooleanMethodInvoker()});

    private static abstract class TypedMethodInvoker<T> {
        private final Class<T> mArgType;

        abstract T convertArgument(String str);

        TypedMethodInvoker(Class<T> cls) {
            this.mArgType = cls;
        }

        boolean invoke(java.lang.Object r6, java.lang.String r7, java.lang.String r8) {
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
            r5 = this;
            r0 = 0;
            r1 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r2 = 1;	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r3 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r4 = r5.mArgType;	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r3[r0] = r4;	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r7 = r1.getMethod(r7, r3);	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r1 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r8 = r5.convertArgument(r8);	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r1[r0] = r8;	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            r7.invoke(r6, r1);	 Catch:{ NoSuchMethodException -> 0x0069, InvocationTargetException -> 0x0050, IllegalAccessException -> 0x0036, IllegalArgumentException -> 0x001c }
            return r2;
        L_0x001c:
            r6 = move-exception;
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "IllegalArgumentException: ";
            r7.append(r8);
            r6 = r6.getMessage();
            r7.append(r6);
            r6 = r7.toString();
            com.facebook.stetho.common.LogUtil.m5754w(r6);
            goto L_0x0069;
        L_0x0036:
            r6 = move-exception;
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "IllegalAccessException: ";
            r7.append(r8);
            r6 = r6.getMessage();
            r7.append(r6);
            r6 = r7.toString();
            com.facebook.stetho.common.LogUtil.m5754w(r6);
            goto L_0x0069;
        L_0x0050:
            r6 = move-exception;
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r8 = "InvocationTargetException: ";
            r7.append(r8);
            r6 = r6.getMessage();
            r7.append(r6);
            r6 = r7.toString();
            com.facebook.stetho.common.LogUtil.m5754w(r6);
        L_0x0069:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.elements.android.MethodInvoker.TypedMethodInvoker.invoke(java.lang.Object, java.lang.String, java.lang.String):boolean");
        }
    }

    private static class BooleanMethodInvoker extends TypedMethodInvoker<Boolean> {
        BooleanMethodInvoker() {
            super(Boolean.TYPE);
        }

        Boolean convertArgument(String str) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
    }

    private static class CharSequenceMethodInvoker extends TypedMethodInvoker<CharSequence> {
        CharSequence convertArgument(String str) {
            return str;
        }

        CharSequenceMethodInvoker() {
            super(CharSequence.class);
        }
    }

    private static class FloatMethodInvoker extends TypedMethodInvoker<Float> {
        FloatMethodInvoker() {
            super(Float.TYPE);
        }

        Float convertArgument(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }
    }

    private static class IntegerMethodInvoker extends TypedMethodInvoker<Integer> {
        IntegerMethodInvoker() {
            super(Integer.TYPE);
        }

        Integer convertArgument(String str) {
            return Integer.valueOf(Integer.parseInt(str));
        }
    }

    private static class StringMethodInvoker extends TypedMethodInvoker<String> {
        String convertArgument(String str) {
            return str;
        }

        StringMethodInvoker() {
            super(String.class);
        }
    }

    public void invoke(Object obj, String str, String str2) {
        Util.throwIfNull(obj, str, str2);
        int size = invokers.size();
        int i = 0;
        while (i < size) {
            if (!((TypedMethodInvoker) invokers.get(i)).invoke(obj, str, str2)) {
                i++;
            } else {
                return;
            }
        }
        obj = new StringBuilder();
        obj.append("Method with name ");
        obj.append(str);
        obj.append(" not found for any of the MethodInvoker supported argument types.");
        LogUtil.m5754w(obj.toString());
    }
}
