package host.exp.exponent.oauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import de.p287a.p288a.C5884c;
import expo.modules.appauth.AppAuthBrowserActivity;
import net.openid.appauth.C6584d;
import net.openid.appauth.C6590f;
import net.openid.appauth.C6593g;
import net.openid.appauth.C6593g.C6592b;
import net.openid.appauth.C6610s;

public class OAuthResultActivity extends Activity {

    /* renamed from: host.exp.exponent.oauth.OAuthResultActivity$a */
    public static class C6409a {
        /* renamed from: a */
        public C6590f f20733a;
        /* renamed from: b */
        public C6610s f20734b;
        /* renamed from: c */
        public C6584d f20735c;

        public C6409a(C6590f c6590f, C6610s c6610s, C6584d c6584d) {
            this.f20733a = c6590f;
            this.f20734b = c6610s;
            this.f20735c = c6584d;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m26307a(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m26307a(intent);
    }

    /* renamed from: a */
    private void m26307a(Intent intent) {
        C6593g c6593g = new C6593g(this);
        final C6590f a = C6590f.m26875a(intent);
        C6584d a2 = C6584d.m26822a(intent);
        if (a != null) {
            c6593g.m26892a(a.m26879a(), new C6592b(this) {
                /* renamed from: b */
                final /* synthetic */ OAuthResultActivity f26290b;

                public void onTokenRequestCompleted(C6610s c6610s, C6584d c6584d) {
                    if (c6610s != null) {
                        C5884c.m24753a().m24769d(new C6409a(a, c6610s, null));
                    } else {
                        C5884c.m24753a().m24769d(new C6409a(null, null, c6584d));
                    }
                }
            });
        } else {
            C5884c.m24753a().m24769d(new C6409a(null, null, a2));
        }
        if (intent.hasExtra(AppAuthBrowserActivity.EXTRA_REDIRECT_EXPERIENCE_URL)) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(intent.getStringExtra(AppAuthBrowserActivity.EXTRA_REDIRECT_EXPERIENCE_URL)));
            intent2.addFlags(268435456);
            startActivity(intent2);
        }
        finish();
    }
}
