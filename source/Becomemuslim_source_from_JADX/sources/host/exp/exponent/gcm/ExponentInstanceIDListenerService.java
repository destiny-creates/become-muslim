package host.exp.exponent.gcm;

import android.content.Intent;
import com.google.android.gms.iid.C4428b;
import host.exp.exponent.C6301d;

public class ExponentInstanceIDListenerService extends C4428b {
    /* renamed from: a */
    public void m39719a() {
        if (!C6301d.f20507m) {
            startService(new Intent(this, GcmRegistrationIntentService.class));
        }
    }
}
