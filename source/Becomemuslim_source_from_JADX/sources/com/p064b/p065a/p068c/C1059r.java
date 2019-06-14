package com.p064b.p065a.p068c;

import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/* compiled from: ExceptionUtils */
/* renamed from: com.b.a.c.r */
final class C1059r {
    /* renamed from: a */
    public static void m3647a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            C1059r.m3649b(th, outputStream);
        }
    }

    /* renamed from: b */
    private static void m3649b(Throwable th, OutputStream outputStream) {
        Closeable closeable = null;
        try {
            Writer printWriter = new PrintWriter(outputStream);
            try {
                C1059r.m3648a(th, printWriter);
                C6428i.a(printWriter, "Failed to close stack trace writer.");
            } catch (Exception e) {
                th = e;
                closeable = printWriter;
                try {
                    C6514c.h().e("CrashlyticsCore", "Failed to create PrintWriter", th);
                    C6428i.a(closeable, "Failed to close stack trace writer.");
                } catch (Throwable th2) {
                    th = th2;
                    C6428i.a(closeable, "Failed to close stack trace writer.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = printWriter;
                C6428i.a(closeable, "Failed to close stack trace writer.");
                throw th;
            }
        } catch (Exception e2) {
            th = e2;
            C6514c.h().e("CrashlyticsCore", "Failed to create PrintWriter", th);
            C6428i.a(closeable, "Failed to close stack trace writer.");
        }
    }

    /* renamed from: a */
    private static void m3648a(Throwable th, Writer writer) {
        Object obj = 1;
        while (th != null) {
            try {
                String a = C1059r.m3646a(th);
                if (a == null) {
                    a = "";
                }
                String str = obj != null ? "" : "Caused by: ";
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(th.getClass().getName());
                stringBuilder.append(": ");
                stringBuilder.append(a);
                stringBuilder.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                writer.write(stringBuilder.toString());
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("\tat ");
                    stringBuilder2.append(stackTraceElement.toString());
                    stringBuilder2.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                    writer.write(stringBuilder2.toString());
                }
                th = th.getCause();
                obj = null;
            } catch (Throwable th2) {
                C6514c.h().e("CrashlyticsCore", "Could not write stack trace", th2);
                return;
            }
        }
    }

    /* renamed from: a */
    private static String m3646a(Throwable th) {
        th = th.getLocalizedMessage();
        if (th == null) {
            return null;
        }
        return th.replaceAll("(\r\n|\n|\f)", " ");
    }
}
