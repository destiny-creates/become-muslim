package com.p064b.p065a.p068c;

import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p357f.C6489a;
import java.io.File;

/* compiled from: CrashlyticsFileMarker */
/* renamed from: com.b.a.c.h */
class C1036h {
    /* renamed from: a */
    private final String f2903a;
    /* renamed from: b */
    private final C6489a f2904b;

    public C1036h(String str, C6489a c6489a) {
        this.f2903a = str;
        this.f2904b = c6489a;
    }

    /* renamed from: a */
    public boolean m3565a() {
        try {
            return m3564d().createNewFile();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error creating marker: ");
            stringBuilder.append(this.f2903a);
            C6514c.h().e("CrashlyticsCore", stringBuilder.toString(), e);
            return false;
        }
    }

    /* renamed from: b */
    public boolean m3566b() {
        return m3564d().exists();
    }

    /* renamed from: c */
    public boolean m3567c() {
        return m3564d().delete();
    }

    /* renamed from: d */
    private File m3564d() {
        return new File(this.f2904b.a(), this.f2903a);
    }
}
