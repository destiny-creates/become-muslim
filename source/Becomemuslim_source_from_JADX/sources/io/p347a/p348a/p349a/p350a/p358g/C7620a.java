package io.p347a.p348a.p349a.p350a.p358g;

import android.content.res.Resources.NotFoundException;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.C6522k;
import io.p347a.p348a.p349a.p350a.p352b.C6417a;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p352b.C6442r;
import io.p347a.p348a.p349a.p350a.p356e.C6478c;
import io.p347a.p348a.p349a.p350a.p356e.C6483d;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Locale;

/* compiled from: AbstractAppSpiCall */
/* renamed from: io.a.a.a.a.g.a */
abstract class C7620a extends C6417a {
    public C7620a(C6520i c6520i, String str, String str2, C6484e c6484e, C6478c c6478c) {
        super(c6520i, str, str2, c6484e, c6478c);
    }

    /* renamed from: a */
    public boolean mo6416a(C6493d c6493d) {
        C6483d b = m34402b(m34401a(m26325b(), c6493d), c6493d);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Sending app info to ");
        stringBuilder.append(m26324a());
        C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
        if (c6493d.f20926j != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("App icon hash is ");
            stringBuilder.append(c6493d.f20926j.f20940a);
            C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append("App icon size is ");
            stringBuilder.append(c6493d.f20926j.f20942c);
            stringBuilder.append("x");
            stringBuilder.append(c6493d.f20926j.f20943d);
            C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
        }
        c6493d = b.m26558b();
        String str = "POST".equals(b.m26582p()) ? "Create" : "Update";
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(" app request ID: ");
        stringBuilder2.append(b.m26560b("X-REQUEST-ID"));
        C6514c.m26634h().mo5472a("Fabric", stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Result was ");
        stringBuilder3.append(c6493d);
        C6514c.m26634h().mo5472a("Fabric", stringBuilder3.toString());
        return C6442r.m26446a(c6493d) == null ? true : null;
    }

    /* renamed from: a */
    private C6483d m34401a(C6483d c6483d, C6493d c6493d) {
        return c6483d.m26548a("X-CRASHLYTICS-API-KEY", c6493d.f20917a).m26548a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").m26548a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo5486a());
    }

    /* renamed from: b */
    private C6483d m34402b(C6483d c6483d, C6493d c6493d) {
        Closeable openRawResource;
        Throwable e;
        StringBuilder stringBuilder;
        c6483d = c6483d.m26568e("app[identifier]", c6493d.f20918b).m26568e("app[name]", c6493d.f20922f).m26568e("app[display_version]", c6493d.f20919c).m26568e("app[build_version]", c6493d.f20920d).m26547a("app[source]", Integer.valueOf(c6493d.f20923g)).m26568e("app[minimum_sdk_version]", c6493d.f20924h).m26568e("app[built_sdk_version]", c6493d.f20925i);
        if (!C6428i.m26379c(c6493d.f20921e)) {
            c6483d.m26568e("app[instance_identifier]", c6493d.f20921e);
        }
        if (c6493d.f20926j != null) {
            try {
                openRawResource = this.a.m26655E().getResources().openRawResource(c6493d.f20926j.f20941b);
                try {
                    c6483d.m26568e("app[icon][hash]", c6493d.f20926j.f20940a).m26552a("app[icon][data]", "icon.png", "application/octet-stream", (InputStream) openRawResource).m26547a("app[icon][width]", Integer.valueOf(c6493d.f20926j.f20942c)).m26547a("app[icon][height]", Integer.valueOf(c6493d.f20926j.f20943d));
                } catch (NotFoundException e2) {
                    e = e2;
                    try {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to find app icon with resource ID: ");
                        stringBuilder.append(c6493d.f20926j.f20941b);
                        C6514c.m26634h().mo5480e("Fabric", stringBuilder.toString(), e);
                        C6428i.m26367a(openRawResource, "Failed to close app icon InputStream.");
                        if (c6493d.f20927k != null) {
                            for (C6522k c6522k : c6493d.f20927k) {
                                c6483d.m26568e(m34403a(c6522k), c6522k.m26670b());
                                c6483d.m26568e(m34405b(c6522k), c6522k.m26671c());
                            }
                        }
                        return c6483d;
                    } catch (Throwable th) {
                        c6483d = th;
                        C6428i.m26367a(openRawResource, "Failed to close app icon InputStream.");
                        throw c6483d;
                    }
                }
            } catch (Throwable e3) {
                Throwable th2 = e3;
                openRawResource = null;
                e = th2;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to find app icon with resource ID: ");
                stringBuilder.append(c6493d.f20926j.f20941b);
                C6514c.m26634h().mo5480e("Fabric", stringBuilder.toString(), e);
                C6428i.m26367a(openRawResource, "Failed to close app icon InputStream.");
                if (c6493d.f20927k != null) {
                    for (C6522k c6522k2 : c6493d.f20927k) {
                        c6483d.m26568e(m34403a(c6522k2), c6522k2.m26670b());
                        c6483d.m26568e(m34405b(c6522k2), c6522k2.m26671c());
                    }
                }
                return c6483d;
            } catch (Throwable th3) {
                c6483d = th3;
                openRawResource = null;
                C6428i.m26367a(openRawResource, "Failed to close app icon InputStream.");
                throw c6483d;
            }
            C6428i.m26367a(openRawResource, "Failed to close app icon InputStream.");
        }
        if (c6493d.f20927k != null) {
            for (C6522k c6522k22 : c6493d.f20927k) {
                c6483d.m26568e(m34403a(c6522k22), c6522k22.m26670b());
                c6483d.m26568e(m34405b(c6522k22), c6522k22.m26671c());
            }
        }
        return c6483d;
    }

    /* renamed from: a */
    String m34403a(C6522k c6522k) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{c6522k.m26669a()});
    }

    /* renamed from: b */
    String m34405b(C6522k c6522k) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{c6522k.m26669a()});
    }
}
