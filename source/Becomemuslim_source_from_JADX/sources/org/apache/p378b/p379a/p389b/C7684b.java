package org.apache.p378b.p379a.p389b;

import java.io.PrintStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.p378b.p379a.C6649a;
import org.apache.p378b.p379a.p380a.C6648c;
import org.apache.p378b.p379a.p381c.C6652e;
import org.apache.p378b.p379a.p381c.C7687d;
import org.apache.p378b.p379a.p381c.C8192a;
import org.apache.p378b.p379a.p383e.C6666b;

/* compiled from: SimpleLoggerContext */
/* renamed from: org.apache.b.a.b.b */
public class C7684b implements C6652e {
    /* renamed from: a */
    private final C6666b f26431a = new C6666b("log4j2.simplelog.properties");
    /* renamed from: b */
    private final boolean f26432b = this.f26431a.m27122a("org.apache.logging.log4j.simplelog.showlogname", false);
    /* renamed from: c */
    private final boolean f26433c = this.f26431a.m27122a("org.apache.logging.log4j.simplelog.showShortLogname", true);
    /* renamed from: d */
    private final boolean f26434d = this.f26431a.m27122a("org.apache.logging.log4j.simplelog.showdatetime", false);
    /* renamed from: e */
    private final boolean f26435e = this.f26431a.m27122a("org.apache.logging.log4j.simplelog.showContextMap", false);
    /* renamed from: f */
    private final String f26436f;
    /* renamed from: g */
    private final C6649a f26437g = C6649a.m27070a(this.f26431a.m27120a("org.apache.logging.log4j.simplelog.level"), C6649a.f21366c);
    /* renamed from: h */
    private final PrintStream f26438h;
    /* renamed from: i */
    private final ConcurrentMap<String, C7687d> f26439i = new ConcurrentHashMap();

    public C7684b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.<init>();
        r0 = new java.util.concurrent.ConcurrentHashMap;
        r0.<init>();
        r4.f26439i = r0;
        r0 = new org.apache.b.a.e.b;
        r1 = "log4j2.simplelog.properties";
        r0.<init>(r1);
        r4.f26431a = r0;
        r0 = r4.f26431a;
        r1 = "org.apache.logging.log4j.simplelog.showContextMap";
        r2 = 0;
        r0 = r0.m27122a(r1, r2);
        r4.f26435e = r0;
        r0 = r4.f26431a;
        r1 = "org.apache.logging.log4j.simplelog.showlogname";
        r0 = r0.m27122a(r1, r2);
        r4.f26432b = r0;
        r0 = r4.f26431a;
        r1 = "org.apache.logging.log4j.simplelog.showShortLogname";
        r3 = 1;
        r0 = r0.m27122a(r1, r3);
        r4.f26433c = r0;
        r0 = r4.f26431a;
        r1 = "org.apache.logging.log4j.simplelog.showdatetime";
        r0 = r0.m27122a(r1, r2);
        r4.f26434d = r0;
        r0 = r4.f26431a;
        r1 = "org.apache.logging.log4j.simplelog.level";
        r0 = r0.m27120a(r1);
        r1 = org.apache.p378b.p379a.C6649a.f21366c;
        r0 = org.apache.p378b.p379a.C6649a.m27070a(r0, r1);
        r4.f26437g = r0;
        r0 = r4.f26434d;
        if (r0 == 0) goto L_0x005c;
    L_0x0051:
        r0 = r4.f26431a;
        r1 = "org.apache.logging.log4j.simplelog.dateTimeFormat";
        r2 = "yyyy/MM/dd HH:mm:ss:SSS zzz";
        r0 = r0.m27121a(r1, r2);
        goto L_0x005d;
    L_0x005c:
        r0 = 0;
    L_0x005d:
        r4.f26436f = r0;
        r0 = r4.f26431a;
        r1 = "org.apache.logging.log4j.simplelog.logFile";
        r2 = "system.err";
        r0 = r0.m27121a(r1, r2);
        r1 = "system.err";
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 == 0) goto L_0x0074;
    L_0x0071:
        r0 = java.lang.System.err;
        goto L_0x008c;
    L_0x0074:
        r1 = "system.out";
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 == 0) goto L_0x007f;
    L_0x007c:
        r0 = java.lang.System.out;
        goto L_0x008c;
    L_0x007f:
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x008a }
        r1.<init>(r0);	 Catch:{ FileNotFoundException -> 0x008a }
        r0 = new java.io.PrintStream;	 Catch:{ FileNotFoundException -> 0x008a }
        r0.<init>(r1);	 Catch:{ FileNotFoundException -> 0x008a }
        goto L_0x008c;
    L_0x008a:
        r0 = java.lang.System.err;
    L_0x008c:
        r4.f26438h = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.b.a.b.b.<init>():void");
    }

    /* renamed from: a */
    public C7687d mo5702a(String str) {
        return m34572a(str, null);
    }

    /* renamed from: a */
    public C7687d m34572a(String str, C6648c c6648c) {
        if (this.f26439i.containsKey(str)) {
            C7687d c7687d = (C7687d) this.f26439i.get(str);
            C8192a.m39769a(c7687d, c6648c);
            return c7687d;
        }
        this.f26439i.putIfAbsent(str, new C8276a(str, this.f26437g, this.f26432b, this.f26433c, this.f26434d, this.f26435e, this.f26436f, c6648c, this.f26431a, this.f26438h));
        return (C7687d) this.f26439i.get(str);
    }
}
