package host.exp.exponent.referrer;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C2705a;
import host.exp.exponent.C6301d;
import host.exp.exponent.C7528e;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6271b;
import javax.inject.C6562a;
import org.json.JSONObject;

public class InstallReferrerReceiver extends C2705a {
    /* renamed from: b */
    private static final String f26291b = "InstallReferrerReceiver";
    @C6562a
    /* renamed from: a */
    C6373d f26292a;

    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if ((context.getApplicationContext() instanceof C7528e) == null) {
            C6289b.m25953c(f26291b, "InstallReferrerReceiver.context.getApplicationContext() not an instance of ExpoApplication");
            return;
        }
        C6294a.m25957a().m25961b(InstallReferrerReceiver.class, this);
        context = intent.getStringExtra("referrer");
        String str = f26291b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Referrer: ");
        stringBuilder.append(context);
        C6289b.m25949a(str, stringBuilder.toString());
        if (context != null) {
            this.f26292a.m26157b("referrer", (String) context);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = "REFERRER";
            if (context == null) {
                context = "";
            }
            jSONObject.put(str2, context);
        } catch (Context context2) {
            C6289b.m25953c(f26291b, context2.getMessage());
        }
        C6288a.m25945a("INSTALL_REFERRER_RECEIVED", jSONObject);
        try {
            m34327a();
        } catch (Context context22) {
            intent = f26291b;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't preload: ");
            stringBuilder.append(context22.toString());
            C6289b.m25953c(intent, stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private void m34327a() {
        if (C6301d.f20496b != null) {
            C6271b.m25897a().m25925f(C6301d.f20496b);
        }
    }
}
