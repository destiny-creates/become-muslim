package com.google.android.gms.internal.p207f;

import java.io.PrintStream;

/* renamed from: com.google.android.gms.internal.f.c */
public final class C4966c {
    /* renamed from: a */
    private static final C4967d f16207a;
    /* renamed from: b */
    private static final int f16208b;

    /* renamed from: com.google.android.gms.internal.f.c$a */
    static final class C6780a extends C4967d {
        C6780a() {
        }

        /* renamed from: a */
        public final void mo4397a(Throwable th, Throwable th2) {
        }
    }

    /* renamed from: a */
    public static void m20245a(Throwable th, Throwable th2) {
        f16207a.mo4397a(th, th2);
    }

    /* renamed from: a */
    private static Integer m20244a() {
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
        C4967d c6782h;
        Throwable th;
        PrintStream printStream;
        String name;
        StringBuilder stringBuilder;
        int i = 1;
        try {
            a = C4966c.m20244a();
            if (a != null) {
                try {
                    if (a.intValue() >= 19) {
                        c6782h = new C6782h();
                        f16207a = c6782h;
                        if (a != null) {
                            i = a.intValue();
                        }
                        f16208b = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = System.err;
                    name = C6780a.class.getName();
                    stringBuilder = new StringBuilder(String.valueOf(name).length() + 132);
                    stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                    stringBuilder.append(name);
                    stringBuilder.append("will be used. The error is: ");
                    printStream.println(stringBuilder.toString());
                    th.printStackTrace(System.err);
                    c6782h = new C6780a();
                    f16207a = c6782h;
                    if (a != null) {
                        i = a.intValue();
                    }
                    f16208b = i;
                }
            }
            if ((Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) != 0) {
                c6782h = new C6781g();
            } else {
                c6782h = new C6780a();
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            printStream = System.err;
            name = C6780a.class.getName();
            stringBuilder = new StringBuilder(String.valueOf(name).length() + 132);
            stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
            stringBuilder.append(name);
            stringBuilder.append("will be used. The error is: ");
            printStream.println(stringBuilder.toString());
            th.printStackTrace(System.err);
            c6782h = new C6780a();
            f16207a = c6782h;
            if (a != null) {
                i = a.intValue();
            }
            f16208b = i;
        }
        f16207a = c6782h;
        if (a != null) {
            i = a.intValue();
        }
        f16208b = i;
    }
}
