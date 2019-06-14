package com.google.android.gms.internal.p210i;

import java.io.PrintStream;

/* renamed from: com.google.android.gms.internal.i.dl */
public final class dl {
    /* renamed from: a */
    private static final dm f16505a;
    /* renamed from: b */
    private static final int f16506b;

    /* renamed from: com.google.android.gms.internal.i.dl$a */
    static final class C6792a extends dm {
        C6792a() {
        }

        /* renamed from: a */
        public final void mo4428a(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }
    }

    /* renamed from: a */
    public static void m20443a(Throwable th, PrintStream printStream) {
        f16505a.mo4428a(th, printStream);
    }

    /* renamed from: a */
    private static Integer m20442a() {
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
        dm dqVar;
        Throwable th;
        PrintStream printStream;
        String name;
        StringBuilder stringBuilder;
        int i = 1;
        try {
            a = dl.m20442a();
            if (a != null) {
                try {
                    if (a.intValue() >= 19) {
                        dqVar = new dq();
                        f16505a = dqVar;
                        if (a != null) {
                            i = a.intValue();
                        }
                        f16506b = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = System.err;
                    name = C6792a.class.getName();
                    stringBuilder = new StringBuilder(String.valueOf(name).length() + 133);
                    stringBuilder.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                    stringBuilder.append(name);
                    stringBuilder.append("will be used. The error is: ");
                    printStream.println(stringBuilder.toString());
                    th.printStackTrace(System.err);
                    dqVar = new C6792a();
                    f16505a = dqVar;
                    if (a != null) {
                        i = a.intValue();
                    }
                    f16506b = i;
                }
            }
            if ((Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) != 0) {
                dqVar = new dp();
            } else {
                dqVar = new C6792a();
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            printStream = System.err;
            name = C6792a.class.getName();
            stringBuilder = new StringBuilder(String.valueOf(name).length() + 133);
            stringBuilder.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            stringBuilder.append(name);
            stringBuilder.append("will be used. The error is: ");
            printStream.println(stringBuilder.toString());
            th.printStackTrace(System.err);
            dqVar = new C6792a();
            f16505a = dqVar;
            if (a != null) {
                i = a.intValue();
            }
            f16506b = i;
        }
        f16505a = dqVar;
        if (a != null) {
            i = a.intValue();
        }
        f16506b = i;
    }
}
