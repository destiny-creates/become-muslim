package com.p064b.p065a.p068c;

import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6417a;
import io.p347a.p348a.p349a.p350a.p352b.C6442r;
import io.p347a.p348a.p349a.p350a.p356e.C6478c;
import io.p347a.p348a.p349a.p350a.p356e.C6483d;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import java.util.Map.Entry;

/* compiled from: DefaultCreateReportSpiCall */
/* renamed from: com.b.a.c.o */
class C3426o extends C6417a implements C1054n {
    public C3426o(C6520i c6520i, String str, String str2, C6484e c6484e) {
        super(c6520i, str, str2, c6484e, C6478c.f20880b);
    }

    /* renamed from: a */
    public boolean mo753a(C1053m c1053m) {
        c1053m = m10983b(m10982a(b(), c1053m), c1053m);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending report to: ");
        stringBuilder.append(a());
        C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
        int b = c1053m.b();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Create report request ID: ");
        stringBuilder2.append(c1053m.b("X-REQUEST-ID"));
        C6514c.h().a("CrashlyticsCore", stringBuilder2.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("Result was: ");
        stringBuilder.append(b);
        C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
        return C6442r.a(b) == null ? true : null;
    }

    /* renamed from: a */
    private C6483d m10982a(C6483d c6483d, C1053m c1053m) {
        c6483d = c6483d.a("X-CRASHLYTICS-API-KEY", c1053m.f2941a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", C3424f.m10946e().m10950a());
        for (Entry a : c1053m.f2942b.mo751e().entrySet()) {
            c6483d = c6483d.a(a);
        }
        return c6483d;
    }

    /* renamed from: b */
    private C6483d m10983b(C6483d c6483d, C1053m c1053m) {
        c1053m = c1053m.f2942b;
        return c6483d.a("report[file]", c1053m.mo748b(), "application/octet-stream", c1053m.mo750d()).e("report[identifier]", c1053m.mo749c());
    }
}
