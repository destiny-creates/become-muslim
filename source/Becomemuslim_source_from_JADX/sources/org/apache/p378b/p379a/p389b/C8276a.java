package org.apache.p378b.p379a.p389b;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.util.Date;
import org.apache.p378b.p379a.C6649a;
import org.apache.p378b.p379a.C6661d;
import org.apache.p378b.p379a.C6674f;
import org.apache.p378b.p379a.p380a.C6647b;
import org.apache.p378b.p379a.p381c.C8192a;

/* compiled from: SimpleLogger */
/* renamed from: org.apache.b.a.b.a */
public class C8276a extends C8192a {
    private static final long serialVersionUID = 1;
    /* renamed from: h */
    private DateFormat f32456h;
    /* renamed from: i */
    private C6649a f32457i;
    /* renamed from: j */
    private final boolean f32458j;
    /* renamed from: k */
    private final boolean f32459k;
    /* renamed from: l */
    private PrintStream f32460l;
    /* renamed from: m */
    private final String f32461m;

    public C8276a(java.lang.String r2, org.apache.p378b.p379a.C6649a r3, boolean r4, boolean r5, boolean r6, boolean r7, java.lang.String r8, org.apache.p378b.p379a.p380a.C6648c r9, org.apache.p378b.p379a.p383e.C6666b r10, java.io.PrintStream r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.<init>(r2, r9);
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r0 = "org.apache.logging.log4j.simplelog.";
        r9.append(r0);
        r9.append(r2);
        r0 = ".level";
        r9.append(r0);
        r9 = r9.toString();
        r9 = r10.m27120a(r9);
        r3 = org.apache.p378b.p379a.C6649a.m27070a(r9, r3);
        r1.f32457i = r3;
        if (r5 == 0) goto L_0x003f;
    L_0x0025:
        r3 = ".";
        r3 = r2.lastIndexOf(r3);
        if (r3 <= 0) goto L_0x003c;
    L_0x002d:
        r4 = r2.length();
        if (r3 >= r4) goto L_0x003c;
    L_0x0033:
        r3 = r3 + 1;
        r2 = r2.substring(r3);
        r1.f32461m = r2;
        goto L_0x0047;
    L_0x003c:
        r1.f32461m = r2;
        goto L_0x0047;
    L_0x003f:
        if (r4 == 0) goto L_0x0044;
    L_0x0041:
        r1.f32461m = r2;
        goto L_0x0047;
    L_0x0044:
        r2 = 0;
        r1.f32461m = r2;
    L_0x0047:
        r1.f32458j = r6;
        r1.f32459k = r7;
        r1.f32460l = r11;
        if (r6 == 0) goto L_0x0060;
    L_0x004f:
        r2 = new java.text.SimpleDateFormat;	 Catch:{ IllegalArgumentException -> 0x0057 }
        r2.<init>(r8);	 Catch:{ IllegalArgumentException -> 0x0057 }
        r1.f32456h = r2;	 Catch:{ IllegalArgumentException -> 0x0057 }
        goto L_0x0060;
    L_0x0057:
        r2 = new java.text.SimpleDateFormat;
        r3 = "yyyy/MM/dd HH:mm:ss:SSS zzz";
        r2.<init>(r3);
        r1.f32456h = r2;
    L_0x0060:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.b.a.<init>(java.lang.String, org.apache.b.a.a, boolean, boolean, boolean, boolean, java.lang.String, org.apache.b.a.a.c, org.apache.b.a.e.b, java.io.PrintStream):void");
    }

    /* renamed from: a */
    public boolean mo6783a(C6649a c6649a, C6661d c6661d, Object obj, Throwable th) {
        return this.f32457i.m27071a() >= c6649a.m27071a() ? true : null;
    }

    /* renamed from: a */
    public boolean mo6785a(C6649a c6649a, C6661d c6661d, String str, Object... objArr) {
        return this.f32457i.m27071a() >= c6649a.m27071a() ? true : null;
    }

    /* renamed from: a */
    public boolean mo6784a(C6649a c6649a, C6661d c6661d, String str, Throwable th) {
        return this.f32457i.m27071a() >= c6649a.m27071a() ? true : null;
    }

    /* renamed from: a */
    public void mo6782a(String str, C6649a c6649a, C6661d c6661d, C6647b c6647b, Throwable th) {
        str = new StringBuilder();
        if (this.f32458j != null) {
            c6661d = new Date();
            synchronized (this.f32456h) {
                c6661d = this.f32456h.format(c6661d);
            }
            str.append(c6661d);
            str.append(' ');
        }
        str.append(c6649a.toString());
        str.append(' ');
        if (this.f32461m != null && this.f32461m.length() > null) {
            str.append(this.f32461m);
            str.append(' ');
        }
        str.append(c6647b.mo5699a());
        if (this.f32459k != null) {
            c6649a = C6674f.m27137b();
            if (c6649a.size() > null) {
                str.append(' ');
                str.append(c6649a.toString());
                str.append(' ');
            }
        }
        c6649a = c6647b.mo5700b();
        if (th == null && c6649a != null && c6649a.length > null && (c6649a[c6649a.length - 1] instanceof Throwable) != null) {
            th = (Throwable) c6649a[c6649a.length - 1];
        }
        if (th != null) {
            str.append(' ');
            c6649a = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(c6649a));
            str.append(c6649a.toString());
        }
        this.f32460l.println(str.toString());
    }
}
