package com.google.android.gms.internal.ads;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class zq {
    /* renamed from: a */
    private static final zr f16127a;
    /* renamed from: b */
    private static final int f16128b;

    /* renamed from: com.google.android.gms.internal.ads.zq$a */
    static final class C6773a extends zr {
        C6773a() {
        }

        /* renamed from: a */
        public final void mo4394a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }
    }

    static {
        Integer a;
        zr zvVar;
        Throwable th;
        PrintStream printStream;
        String name;
        StringBuilder stringBuilder;
        int i = 1;
        try {
            a = m20202a();
            if (a != null) {
                try {
                    if (a.intValue() >= 19) {
                        zvVar = new zv();
                        f16127a = zvVar;
                        if (a != null) {
                            i = a.intValue();
                        }
                        f16128b = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = System.err;
                    name = C6773a.class.getName();
                    stringBuilder = new StringBuilder(String.valueOf(name).length() + 132);
                    stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                    stringBuilder.append(name);
                    stringBuilder.append("will be used. The error is: ");
                    printStream.println(stringBuilder.toString());
                    th.printStackTrace(System.err);
                    zvVar = new C6773a();
                    f16127a = zvVar;
                    if (a != null) {
                        i = a.intValue();
                    }
                    f16128b = i;
                }
            }
            zvVar = (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) != 0 ? new zu() : new C6773a();
        } catch (Throwable th3) {
            th = th3;
            a = null;
            printStream = System.err;
            name = C6773a.class.getName();
            stringBuilder = new StringBuilder(String.valueOf(name).length() + 132);
            stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
            stringBuilder.append(name);
            stringBuilder.append("will be used. The error is: ");
            printStream.println(stringBuilder.toString());
            th.printStackTrace(System.err);
            zvVar = new C6773a();
            f16127a = zvVar;
            if (a != null) {
                i = a.intValue();
            }
            f16128b = i;
        }
        f16127a = zvVar;
        if (a != null) {
            i = a.intValue();
        }
        f16128b = i;
    }

    /* renamed from: a */
    private static Integer m20202a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    /* renamed from: a */
    public static void m20203a(Throwable th, PrintWriter printWriter) {
        f16127a.mo4394a(th, printWriter);
    }
}
