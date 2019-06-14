package com.google.android.gms.internal.p209h;

import java.io.PrintStream;

/* renamed from: com.google.android.gms.internal.h.m */
public final class C4987m {
    /* renamed from: a */
    private static final C4988n f16227a;
    /* renamed from: b */
    private static final int f16228b;

    /* renamed from: com.google.android.gms.internal.h.m$a */
    static final class C6785a extends C4988n {
        C6785a() {
        }

        /* renamed from: a */
        public final void mo4411a(Throwable th, Throwable th2) {
        }
    }

    /* renamed from: a */
    public static void m20273a(Throwable th, Throwable th2) {
        f16227a.mo4411a(th, th2);
    }

    /* renamed from: a */
    private static Integer m20272a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    static {
        Integer a;
        C4988n c6787r;
        Throwable th;
        PrintStream printStream;
        String name;
        StringBuilder stringBuilder;
        int i = 1;
        try {
            a = C4987m.m20272a();
            if (a != null) {
                try {
                    if (a.intValue() >= 19) {
                        c6787r = new C6787r();
                        f16227a = c6787r;
                        if (a != null) {
                            i = a.intValue();
                        }
                        f16228b = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = System.err;
                    name = C6785a.class.getName();
                    stringBuilder = new StringBuilder(String.valueOf(name).length() + 133);
                    stringBuilder.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    stringBuilder.append(name);
                    stringBuilder.append("will be used. The error is: ");
                    printStream.println(stringBuilder.toString());
                    th.printStackTrace(System.err);
                    c6787r = new C6785a();
                    f16227a = c6787r;
                    if (a != null) {
                        i = a.intValue();
                    }
                    f16228b = i;
                }
            }
            if ((Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) != 0) {
                c6787r = new C6786q();
            } else {
                c6787r = new C6785a();
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            printStream = System.err;
            name = C6785a.class.getName();
            stringBuilder = new StringBuilder(String.valueOf(name).length() + 133);
            stringBuilder.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            stringBuilder.append(name);
            stringBuilder.append("will be used. The error is: ");
            printStream.println(stringBuilder.toString());
            th.printStackTrace(System.err);
            c6787r = new C6785a();
            f16227a = c6787r;
            if (a != null) {
                i = a.intValue();
            }
            f16228b = i;
        }
        f16227a = c6787r;
        if (a != null) {
            i = a.intValue();
        }
        f16228b = i;
    }
}
