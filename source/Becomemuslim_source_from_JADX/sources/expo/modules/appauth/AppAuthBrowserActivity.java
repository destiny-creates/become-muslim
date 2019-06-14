package expo.modules.appauth;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import de.p287a.p288a.C5884c;
import net.openid.appauth.C6584d;
import net.openid.appauth.C6590f;

public class AppAuthBrowserActivity extends Activity {
    public static final String EXTRA_REDIRECT_EXPERIENCE_URL = "redirectExperienceUrl";

    public static class OAuthResultEvent {
        public C6584d exception;
        public C6590f response;

        public OAuthResultEvent(Intent intent) {
            this.response = C6590f.m26875a(intent);
            this.exception = C6584d.m26822a(intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        handleIntent(getIntent());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        C5884c.m24753a().m24769d(new OAuthResultEvent(intent));
        if (intent.hasExtra(EXTRA_REDIRECT_EXPERIENCE_URL)) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(intent.getStringExtra(EXTRA_REDIRECT_EXPERIENCE_URL))).addFlags(1946157056));
        }
        finish();
    }
}
