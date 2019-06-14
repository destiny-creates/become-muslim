package com.google.p127a.p129b;

import com.google.p127a.C2162l;
import com.google.p127a.p129b.p130a.C2127m;
import com.google.p127a.p132d.C2154c;
import java.io.Writer;

/* compiled from: Streams */
/* renamed from: com.google.a.b.j */
public final class C2147j {

    /* compiled from: Streams */
    /* renamed from: com.google.a.b.j$a */
    private static final class C2146a extends Writer {
        /* renamed from: a */
        private final Appendable f5131a;
        /* renamed from: b */
        private final C2145a f5132b;

        /* compiled from: Streams */
        /* renamed from: com.google.a.b.j$a$a */
        static class C2145a implements CharSequence {
            /* renamed from: a */
            char[] f5130a;

            C2145a() {
            }

            public int length() {
                return this.f5130a.length;
            }

            public char charAt(int i) {
                return this.f5130a[i];
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.f5130a, i, i2 - i);
            }
        }

        public void close() {
        }

        public void flush() {
        }

        private C2146a(Appendable appendable) {
            this.f5132b = new C2145a();
            this.f5131a = appendable;
        }

        public void write(char[] cArr, int i, int i2) {
            this.f5132b.f5130a = cArr;
            this.f5131a.append(this.f5132b, i, i2 + i);
        }

        public void write(int i) {
            this.f5131a.append((char) i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static com.google.p127a.C2162l m5881a(com.google.p127a.p132d.C2152a r2) {
        /*
        r2.mo1999f();	 Catch:{ EOFException -> 0x0024, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r0 = 0;
        r1 = com.google.p127a.p129b.p130a.C2127m.f5066P;	 Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r2 = r1.mo1992b(r2);	 Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        r2 = (com.google.p127a.C2162l) r2;	 Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
        return r2;
    L_0x000d:
        r2 = move-exception;
        goto L_0x0026;
    L_0x000f:
        r2 = move-exception;
        r0 = new com.google.a.t;
        r0.<init>(r2);
        throw r0;
    L_0x0016:
        r2 = move-exception;
        r0 = new com.google.a.m;
        r0.<init>(r2);
        throw r0;
    L_0x001d:
        r2 = move-exception;
        r0 = new com.google.a.t;
        r0.<init>(r2);
        throw r0;
    L_0x0024:
        r2 = move-exception;
        r0 = 1;
    L_0x0026:
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r2 = com.google.p127a.C4051n.f10123a;
        return r2;
    L_0x002b:
        r0 = new com.google.a.t;
        r0.<init>(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.j.a(com.google.a.d.a):com.google.a.l");
    }

    /* renamed from: a */
    public static void m5883a(C2162l c2162l, C2154c c2154c) {
        C2127m.f5066P.mo1991a(c2154c, c2162l);
    }

    /* renamed from: a */
    public static Writer m5882a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new C2146a(appendable);
    }
}
