package host.exp.exponent.fcm;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.p186f.C2951d;
import com.google.android.gms.p186f.C2952e;
import com.google.firebase.iid.C5351a;
import com.google.firebase.iid.FirebaseInstanceId;
import host.exp.exponent.notifications.C6397d;
import java.io.IOException;

public class FcmRegistrationIntentService extends C6397d {
    /* renamed from: d */
    private static final String f26192d = "FcmRegistrationIntentService";
    /* renamed from: a */
    String f26193a = null;

    /* renamed from: host.exp.exponent.fcm.FcmRegistrationIntentService$1 */
    static class C75621 implements C2951d {
        C75621() {
        }

        /* renamed from: a */
        public void m34266a(Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error calling getInstanceId ");
            stringBuilder.append(exception.getLocalizedMessage());
            Log.e("FCM Device Token", stringBuilder.toString());
        }
    }

    /* renamed from: b */
    public String mo5414b() {
        return "fcm_token";
    }

    /* renamed from: c */
    public String mo5415c() {
        return AppMeasurement.FCM_ORIGIN;
    }

    public FcmRegistrationIntentService() {
        super(f26192d);
    }

    /* renamed from: a */
    public String mo5413a() {
        if (this.f26193a != null) {
            Log.d("FCM Device Token", this.f26193a);
            return this.f26193a;
        }
        throw new IOException("No FCM token found");
    }

    /* renamed from: a */
    public static void m34269a(final Context context) {
        FirebaseInstanceId.m22665a().m22686d().a(new C2952e<C5351a>() {
            /* renamed from: a */
            public void m34267a(C5351a c5351a) {
                FcmRegistrationIntentService.m34270a(context, c5351a.mo4893a());
            }
        }).a(new C75621());
    }

    /* renamed from: a */
    public static void m34270a(Context context, String str) {
        FcmRegistrationIntentService fcmRegistrationIntentService = new FcmRegistrationIntentService();
        fcmRegistrationIntentService.attachBaseContext(context);
        fcmRegistrationIntentService.f26193a = str;
        fcmRegistrationIntentService.onHandleIntent(null);
    }
}
