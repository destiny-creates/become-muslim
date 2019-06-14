package host.exp.exponent.gcm;

import com.google.android.gms.iid.C3060a;
import host.exp.exponent.notifications.C6397d;
import host.exp.p333a.C6271b;

public class GcmRegistrationIntentService extends C6397d {
    /* renamed from: a */
    private static final String f26234a = "GcmRegistrationIntentService";

    /* renamed from: b */
    public String mo5414b() {
        return "gcm_token";
    }

    /* renamed from: c */
    public String mo5415c() {
        return "gcm";
    }

    public GcmRegistrationIntentService() {
        super(f26234a);
    }

    /* renamed from: a */
    public String mo5413a() {
        return C3060a.c(this).a(C6271b.m25897a().m25922c(), "GCM", null);
    }
}
