package host.exp.exponent.gcm;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.gcm.C4426a;
import host.exp.exponent.C6301d;
import host.exp.exponent.notifications.C6408j;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;

public class ExponentGcmListenerService extends C4426a {
    /* renamed from: b */
    private static final String f30368b = "ExponentGcmListenerService";
    /* renamed from: c */
    private static ExponentGcmListenerService f30369c;

    public void onCreate() {
        super.onCreate();
        C6294a.m25957a().m25961b(ExponentGcmListenerService.class, this);
        f30369c = this;
    }

    /* renamed from: a */
    public void m39718a(String str, Bundle bundle) {
        if (C6301d.f20507m == null) {
            String string = bundle.getString("body");
            String string2 = bundle.getString("experienceId");
            if (string2 == null) {
                C6289b.m25953c(f30368b, "No experienceId in push payload.");
                return;
            }
            String string3 = bundle.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            if (string3 == null) {
                C6289b.m25953c(f30368b, "No message in push payload.");
                return;
            }
            String string4 = bundle.getString("title");
            C6408j.m26297a().m26305a(this, string2, bundle.getString("channelId"), string3, string, string4, bundle.getString("categoryId"));
        }
    }
}
