package com.facebook.stetho.inspector.runtime;

import android.content.Context;
import com.facebook.stetho.inspector.console.RuntimeRepl;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;

public class RhinoDetectingRuntimeReplFactory implements RuntimeReplFactory {
    private final Context mContext;
    private RuntimeException mRhinoJsUnexpectedError;
    private RuntimeReplFactory mRhinoReplFactory;
    private boolean mSearchedForRhinoJs;

    /* renamed from: com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory$1 */
    class C39701 implements RuntimeRepl {
        C39701() {
        }

        public Object evaluate(String str) {
            if (RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError == null) {
                return "Not supported without stetho-js-rhino dependency";
            }
            str = new StringBuilder();
            str.append("stetho-js-rhino threw: ");
            str.append(RhinoDetectingRuntimeReplFactory.this.mRhinoJsUnexpectedError.toString());
            return str.toString();
        }
    }

    public RhinoDetectingRuntimeReplFactory(Context context) {
        this.mContext = context;
    }

    public RuntimeRepl newInstance() {
        if (!this.mSearchedForRhinoJs) {
            this.mSearchedForRhinoJs = true;
            try {
                this.mRhinoReplFactory = findRhinoReplFactory(this.mContext);
            } catch (RuntimeException e) {
                this.mRhinoJsUnexpectedError = e;
            }
        }
        if (this.mRhinoReplFactory != null) {
            return this.mRhinoReplFactory.newInstance();
        }
        return new C39701();
    }

    private static com.facebook.stetho.inspector.console.RuntimeReplFactory findRhinoReplFactory(android.content.Context r7) {
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
        r0 = 0;
        r1 = "com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder";	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r2 = "defaultFactory";	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r4 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r5 = android.content.Context.class;	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r6 = 0;	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r4[r6] = r5;	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r1 = r1.getDeclaredMethod(r2, r4);	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r2 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r2[r6] = r7;	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r7 = r1.invoke(r0, r2);	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        r7 = (com.facebook.stetho.inspector.console.RuntimeReplFactory) r7;	 Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, InvocationTargetException -> 0x0027, IllegalAccessException -> 0x0020 }
        return r7;
    L_0x0020:
        r7 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r7);
        throw r0;
    L_0x0027:
        r7 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r7);
        throw r0;
    L_0x002e:
        r7 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r7);
        throw r0;
    L_0x0035:
        r7 = "Error finding stetho-js-rhino, cannot enable console evaluation!";
        com.facebook.stetho.common.LogUtil.m5746i(r7);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory.findRhinoReplFactory(android.content.Context):com.facebook.stetho.inspector.console.RuntimeReplFactory");
    }
}
