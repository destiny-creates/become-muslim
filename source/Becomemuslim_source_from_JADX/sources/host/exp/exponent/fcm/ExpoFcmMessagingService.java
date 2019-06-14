package host.exp.exponent.fcm;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.messaging.C7917d;
import com.google.firebase.messaging.FirebaseMessagingService;
import host.exp.exponent.C6301d;
import host.exp.exponent.notifications.C6408j;

public class ExpoFcmMessagingService extends FirebaseMessagingService {
    /* renamed from: b */
    public void mo6410b(String str) {
        if (C6301d.f20507m) {
            FcmRegistrationIntentService.m34270a(getApplicationContext(), str);
        }
    }

    /* renamed from: a */
    public void mo6409a(C7917d c7917d) {
        if (C6301d.f20507m) {
            C6408j.m26297a().m26305a(this, (String) c7917d.m38517a().get("experienceId"), (String) c7917d.m38517a().get("channelId"), (String) c7917d.m38517a().get(ShareConstants.WEB_DIALOG_PARAM_MESSAGE), (String) c7917d.m38517a().get("body"), (String) c7917d.m38517a().get("title"), (String) c7917d.m38517a().get("categoryId"));
        }
    }
}
