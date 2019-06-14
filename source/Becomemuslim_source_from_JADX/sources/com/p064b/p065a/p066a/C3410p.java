package com.p064b.p065a.p066a;

import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6417a;
import io.p347a.p348a.p349a.p350a.p352b.C6442r;
import io.p347a.p348a.p349a.p350a.p355d.C6474f;
import io.p347a.p348a.p349a.p350a.p356e.C6478c;
import io.p347a.p348a.p349a.p350a.p356e.C6483d;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import java.io.File;
import java.util.List;

/* compiled from: SessionAnalyticsFilesSender */
/* renamed from: com.b.a.a.p */
class C3410p extends C6417a implements C6474f {
    /* renamed from: b */
    private final String f9071b;

    public C3410p(C6520i c6520i, String str, String str2, C6484e c6484e, String str3) {
        super(c6520i, str, str2, c6484e, C6478c.f20880b);
        this.f9071b = str3;
    }

    /* renamed from: a */
    public boolean m10863a(List<File> list) {
        C6483d a = b().a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", this.f9071b);
        int i = 0;
        for (File file : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("session_analytics_file_");
            stringBuilder.append(i);
            a.a(stringBuilder.toString(), file.getName(), "application/vnd.crashlytics.android.events", file);
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Sending ");
        stringBuilder2.append(list.size());
        stringBuilder2.append(" analytics files to ");
        stringBuilder2.append(a());
        C6514c.h().a("Answers", stringBuilder2.toString());
        list = a.b();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Response code for analytics file send is ");
        stringBuilder3.append(list);
        C6514c.h().a("Answers", stringBuilder3.toString());
        if (C6442r.a(list) == null) {
            return true;
        }
        return false;
    }
}
