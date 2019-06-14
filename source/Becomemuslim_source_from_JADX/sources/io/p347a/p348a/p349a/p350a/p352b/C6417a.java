package io.p347a.p348a.p349a.p350a.p352b;

import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p356e.C6478c;
import io.p347a.p348a.p349a.p350a.p356e.C6483d;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: AbstractSpiCall */
/* renamed from: io.a.a.a.a.b.a */
public abstract class C6417a {
    /* renamed from: b */
    private static final Pattern f20742b = Pattern.compile("http(s?)://[^\\/]+", 2);
    /* renamed from: a */
    protected final C6520i f20743a;
    /* renamed from: c */
    private final String f20744c;
    /* renamed from: d */
    private final C6484e f20745d;
    /* renamed from: e */
    private final C6478c f20746e;
    /* renamed from: f */
    private final String f20747f;

    public C6417a(C6520i c6520i, String str, String str2, C6484e c6484e, C6478c c6478c) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (c6484e != null) {
            this.f20743a = c6520i;
            this.f20747f = str;
            this.f20744c = m26322a(str2);
            this.f20745d = c6484e;
            this.f20746e = c6478c;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    /* renamed from: a */
    protected String m26324a() {
        return this.f20744c;
    }

    /* renamed from: b */
    protected C6483d m26325b() {
        return m26323a(Collections.emptyMap());
    }

    /* renamed from: a */
    protected C6483d m26323a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics Android SDK/");
        stringBuilder.append(this.f20743a.mo5486a());
        return this.f20745d.mo5456a(this.f20746e, m26324a(), map).m26555a(false).m26545a(10000).m26548a("User-Agent", stringBuilder.toString()).m26548a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    /* renamed from: a */
    private String m26322a(String str) {
        return !C6428i.m26379c(this.f20747f) ? f20742b.matcher(str).replaceFirst(this.f20747f) : str;
    }
}
