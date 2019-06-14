package com.p064b.p065a.p068c;

import io.p347a.p348a.p349a.C6514c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SessionReport */
/* renamed from: com.b.a.c.ac */
class ac implements C1067z {
    /* renamed from: a */
    private final File f9099a;
    /* renamed from: b */
    private final Map<String, String> f9100b;

    public ac(File file) {
        this(file, Collections.emptyMap());
    }

    public ac(File file, Map<String, String> map) {
        this.f9099a = file;
        this.f9100b = new HashMap(map);
        if (this.f9099a.length() == 0) {
            this.f9100b.putAll(aa.f2850a);
        }
    }

    /* renamed from: d */
    public File mo750d() {
        return this.f9099a;
    }

    /* renamed from: b */
    public String mo748b() {
        return mo750d().getName();
    }

    /* renamed from: c */
    public String mo749c() {
        String b = mo748b();
        return b.substring(0, b.lastIndexOf(46));
    }

    /* renamed from: e */
    public Map<String, String> mo751e() {
        return Collections.unmodifiableMap(this.f9100b);
    }

    /* renamed from: a */
    public boolean mo747a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Removing report at ");
        stringBuilder.append(this.f9099a.getPath());
        C6514c.h().a("CrashlyticsCore", stringBuilder.toString());
        return this.f9099a.delete();
    }
}
