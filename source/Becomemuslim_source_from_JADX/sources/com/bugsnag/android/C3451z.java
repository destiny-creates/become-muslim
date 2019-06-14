package com.bugsnag.android;

import android.text.TextUtils;
import com.bugsnag.android.ab.C1071a;

/* compiled from: HandledState */
/* renamed from: com.bugsnag.android.z */
final class C3451z implements C1071a {
    /* renamed from: a */
    private final String f9222a;
    /* renamed from: b */
    private final String f9223b;
    /* renamed from: c */
    private final Severity f9224c;
    /* renamed from: d */
    private Severity f9225d;
    /* renamed from: e */
    private final boolean f9226e;

    /* renamed from: a */
    static C3451z m11092a(String str, Severity severity, String str2) {
        if (str.equals("strictMode")) {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("No reason supplied for strictmode");
            }
        }
        if (!(str.equals("strictMode") || str.equals("log"))) {
            if (!TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("attributeValue should not be supplied");
            }
        }
        Object obj = -1;
        switch (str.hashCode()) {
            case -1876197364:
                if (str.equals("strictMode")) {
                    obj = 1;
                    break;
                }
                break;
            case -1773746641:
                if (str.equals("userCallbackSetSeverity")) {
                    obj = 4;
                    break;
                }
                break;
            case -1591166708:
                if (str.equals("unhandledException")) {
                    obj = null;
                    break;
                }
                break;
            case -1107031998:
                if (str.equals("userSpecifiedSeverity")) {
                    obj = 3;
                    break;
                }
                break;
            case 107332:
                if (str.equals("log")) {
                    obj = 6;
                    break;
                }
                break;
            case 87505361:
                if (str.equals("unhandledPromiseRejection")) {
                    obj = 5;
                    break;
                }
                break;
            case 561970291:
                if (str.equals("handledException")) {
                    obj = 2;
                    break;
                }
                break;
            default:
                break;
        }
        switch (obj) {
            case null:
                return new C3451z(str, Severity.ERROR, true, null);
            case 1:
                return new C3451z(str, Severity.WARNING, true, str2);
            case 2:
                return new C3451z(str, Severity.WARNING, false, null);
            case 3:
                return new C3451z(str, severity, false, null);
            case 4:
                return new C3451z(str, severity, false, null);
            case 5:
                return new C3451z(str, Severity.ERROR, true, null);
            case 6:
                return new C3451z(str, severity, false, str2);
            default:
                throw new IllegalArgumentException(String.format("Invalid argument '%s' for severityReason", new Object[]{str}));
        }
    }

    C3451z(String str, Severity severity, boolean z, String str2) {
        this.f9222a = str;
        this.f9224c = severity;
        this.f9226e = z;
        this.f9223b = str2;
        this.f9225d = severity;
    }

    /* renamed from: a */
    String m11093a() {
        return this.f9224c == this.f9225d ? this.f9222a : "userCallbackSetSeverity";
    }

    /* renamed from: b */
    boolean m11095b() {
        return this.f9226e;
    }

    /* renamed from: a */
    void m11094a(Severity severity) {
        this.f9225d = severity;
    }

    public void toStream(ab abVar) {
        abVar.mo772c().mo773c("type").mo771b(m11093a());
        if (this.f9223b != null) {
            String str = null;
            String str2 = this.f9222a;
            Object obj = -1;
            int hashCode = str2.hashCode();
            if (hashCode != -1876197364) {
                if (hashCode == 107332) {
                    if (str2.equals("log")) {
                        obj = null;
                    }
                }
            } else if (str2.equals("strictMode")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = "level";
                    break;
                case 1:
                    str = "violationType";
                    break;
                default:
                    break;
            }
            if (str != null) {
                abVar.mo764a("attributes").mo772c().mo773c(str).mo771b(this.f9223b).mo770b();
            }
        }
        abVar.mo770b();
    }
}
