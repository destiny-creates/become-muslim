package com.p064b.p065a.p067b;

import com.facebook.share.internal.ShareConstants;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.p350a.p352b.C6417a;
import io.p347a.p348a.p349a.p350a.p356e.C6478c;
import io.p347a.p348a.p349a.p350a.p356e.C6483d;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CheckForUpdatesRequest */
/* renamed from: com.b.a.b.e */
class C3418e extends C6417a {
    /* renamed from: b */
    private final C1005g f9096b;

    /* renamed from: a */
    static String m10912a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("3:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public C3418e(C6520i c6520i, String str, String str2, C6484e c6484e, C1005g c1005g) {
        super(c6520i, str, str2, c6484e, C6478c.f20879a);
        this.f9096b = c1005g;
    }

    /* renamed from: a */
    public C1004f m10914a(String str, String str2, C1003d c1003d) {
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        StringBuilder stringBuilder3;
        try {
            c1003d = m10913a(c1003d);
            C6483d a = a(c1003d);
            try {
                str = m10911a(a, str, str2);
                try {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Checking for updates from ");
                    stringBuilder2.append(a());
                    C6514c.h().a("Beta", stringBuilder2.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Checking for updates query params are: ");
                    stringBuilder2.append(c1003d);
                    C6514c.h().a("Beta", stringBuilder2.toString());
                    if (str.c() != null) {
                        C6514c.h().a("Beta", "Checking for updates was successful");
                        str2 = this.f9096b.m3449a(new JSONObject(str.e()));
                        if (str != null) {
                            str = str.b("X-REQUEST-ID");
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Checking for updates request ID: ");
                            stringBuilder3.append(str);
                            C6514c.h().a("Fabric", stringBuilder3.toString());
                        }
                        return str2;
                    }
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Checking for updates failed. Response code: ");
                    stringBuilder3.append(str.b());
                    C6514c.h().e("Beta", stringBuilder3.toString());
                    if (str != null) {
                        str = str.b("X-REQUEST-ID");
                        str2 = C6514c.h();
                        c1003d = "Fabric";
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Checking for updates request ID: ");
                        stringBuilder3.append(str);
                        str2.a(c1003d, stringBuilder3.toString());
                    }
                    return null;
                } catch (Exception e) {
                    str2 = e;
                    try {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Error while checking for updates from ");
                        stringBuilder2.append(a());
                        C6514c.h().e("Beta", stringBuilder2.toString(), str2);
                        if (str != null) {
                            str = str.b("X-REQUEST-ID");
                            str2 = C6514c.h();
                            c1003d = "Fabric";
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Checking for updates request ID: ");
                            stringBuilder3.append(str);
                            str2.a(c1003d, stringBuilder3.toString());
                        }
                        return null;
                    } catch (Throwable th) {
                        str2 = th;
                        if (str != null) {
                            str = str.b("X-REQUEST-ID");
                            c1003d = C6514c.h();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Checking for updates request ID: ");
                            stringBuilder.append(str);
                            c1003d.a("Fabric", stringBuilder.toString());
                        }
                        throw str2;
                    }
                }
            } catch (Exception e2) {
                str2 = e2;
                str = a;
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Error while checking for updates from ");
                stringBuilder2.append(a());
                C6514c.h().e("Beta", stringBuilder2.toString(), str2);
                if (str != null) {
                    str = str.b("X-REQUEST-ID");
                    str2 = C6514c.h();
                    c1003d = "Fabric";
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Checking for updates request ID: ");
                    stringBuilder3.append(str);
                    str2.a(c1003d, stringBuilder3.toString());
                }
                return null;
            } catch (Throwable th2) {
                str2 = th2;
                str = a;
                if (str != null) {
                    str = str.b("X-REQUEST-ID");
                    c1003d = C6514c.h();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Checking for updates request ID: ");
                    stringBuilder.append(str);
                    c1003d.a("Fabric", stringBuilder.toString());
                }
                throw str2;
            }
        } catch (Exception e3) {
            str2 = e3;
            str = null;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Error while checking for updates from ");
            stringBuilder2.append(a());
            C6514c.h().e("Beta", stringBuilder2.toString(), str2);
            if (str != null) {
                str = str.b("X-REQUEST-ID");
                str2 = C6514c.h();
                c1003d = "Fabric";
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Checking for updates request ID: ");
                stringBuilder3.append(str);
                str2.a(c1003d, stringBuilder3.toString());
            }
            return null;
        } catch (Throwable th3) {
            str2 = th3;
            str = null;
            if (str != null) {
                str = str.b("X-REQUEST-ID");
                c1003d = C6514c.h();
                stringBuilder = new StringBuilder();
                stringBuilder.append("Checking for updates request ID: ");
                stringBuilder.append(str);
                c1003d.a("Fabric", stringBuilder.toString());
            }
            throw str2;
        }
    }

    /* renamed from: a */
    private C6483d m10911a(C6483d c6483d, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Crashlytics Android SDK/");
        stringBuilder.append(this.a.a());
        return c6483d.a("Accept", "application/json").a("User-Agent", stringBuilder.toString()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa").a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a()).a("X-CRASHLYTICS-API-KEY", str).a("X-CRASHLYTICS-BETA-TOKEN", C3418e.m10912a(str2));
    }

    /* renamed from: a */
    private Map<String, String> m10913a(C1003d c1003d) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c1003d.f2807a);
        hashMap.put("display_version", c1003d.f2808b);
        hashMap.put("instance", c1003d.f2809c);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, "3");
        return hashMap;
    }
}
