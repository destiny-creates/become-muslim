package host.exp.exponent.oauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.C4908c;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.infer.annotation.Assertions;
import host.exp.p333a.C6279c.C6274c;
import host.exp.p333a.C6279c.C6275d;

public class OAuthWebViewActivity extends C4908c {

    /* renamed from: host.exp.exponent.oauth.OAuthWebViewActivity$1 */
    class C64101 extends WebViewClient {
        /* renamed from: a */
        final /* synthetic */ OAuthWebViewActivity f20736a;

        C64101(OAuthWebViewActivity oAuthWebViewActivity) {
            this.f20736a = oAuthWebViewActivity;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith("https://oauth.host.exp.com")) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            this.f20736a.m44518a(str);
            return true;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C6275d.oauth_webview_activity);
        a((Toolbar) Assertions.assertNotNull((Toolbar) findViewById(C6274c.toolbar)));
        bundle = b();
        if (bundle != null) {
            bundle.a("");
            bundle.b(true);
            bundle.a(true);
        }
        WebView webView = (WebView) Assertions.assertNotNull((WebView) findViewById(C6274c.webview));
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new C64101(this));
        webView.loadUrl(getIntent().getStringExtra("url"));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            setResult(0);
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* renamed from: a */
    private void m44518a(String str) {
        Intent intent = new Intent();
        intent.putExtra("result_url", str);
        setResult(-1, intent);
        finish();
    }
}
