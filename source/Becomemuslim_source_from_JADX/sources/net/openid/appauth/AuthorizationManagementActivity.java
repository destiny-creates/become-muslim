package net.openid.appauth;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import net.openid.appauth.C6584d.C6581a;
import net.openid.appauth.C6584d.C6582b;
import net.openid.appauth.C6590f.C6589a;
import net.openid.appauth.p370c.C6578a;

public class AuthorizationManagementActivity extends Activity {
    /* renamed from: a */
    private boolean f21098a = false;
    /* renamed from: b */
    private Intent f21099b;
    /* renamed from: c */
    private C6587e f21100c;
    /* renamed from: d */
    private PendingIntent f21101d;
    /* renamed from: e */
    private PendingIntent f21102e;

    /* renamed from: a */
    public static Intent m26773a(Context context, C6587e c6587e, Intent intent, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        context = m26771a(context);
        context.putExtra("authIntent", intent);
        context.putExtra("authRequest", c6587e.m26860c());
        context.putExtra("completeIntent", pendingIntent);
        context.putExtra("cancelIntent", pendingIntent2);
        return context;
    }

    /* renamed from: a */
    public static Intent m26772a(Context context, Uri uri) {
        context = m26771a(context);
        context.setData(uri);
        context.addFlags(603979776);
        return context;
    }

    /* renamed from: a */
    private static Intent m26771a(Context context) {
        return new Intent(context, AuthorizationManagementActivity.class);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            m26776a(getIntent().getExtras());
        } else {
            m26776a(bundle);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.f21098a) {
            if (getIntent().getData() != null) {
                m26775a();
            } else {
                m26777b();
            }
            finish();
            return;
        }
        startActivity(this.f21099b);
        this.f21098a = true;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("authStarted", this.f21098a);
        bundle.putParcelable("authIntent", this.f21099b);
        bundle.putString("authRequest", this.f21100c.m26860c());
        bundle.putParcelable("completeIntent", this.f21101d);
        bundle.putParcelable("cancelIntent", this.f21102e);
    }

    /* renamed from: a */
    private void m26775a() {
        Uri data = getIntent().getData();
        Intent a = m26774a(data);
        if (a == null) {
            C6578a.m26808d("Failed to extract OAuth2 response from redirect", new Object[0]);
            return;
        }
        a.setData(data);
        if (this.f21101d != null) {
            C6578a.m26803a("Authorization complete - invoking completion intent", new Object[0]);
            try {
                this.f21101d.send(this, 0, a);
            } catch (CanceledException e) {
                C6578a.m26808d("Failed to send completion intent", e);
            }
        } else {
            setResult(-1, a);
        }
    }

    /* renamed from: b */
    private void m26777b() {
        C6578a.m26803a("Authorization flow canceled by user", new Object[0]);
        Intent c = C6584d.m26826a(C6582b.f21132b, null).m26836c();
        if (this.f21102e != null) {
            try {
                this.f21102e.send(this, 0, c);
                return;
            } catch (CanceledException e) {
                C6578a.m26808d("Failed to send cancel intent", e);
                return;
            }
        }
        setResult(0, c);
        C6578a.m26803a("No cancel intent set - will return to previous activity", new Object[0]);
    }

    /* renamed from: a */
    private void m26776a(Bundle bundle) {
        if (bundle == null) {
            C6578a.m26807c("No stored state - unable to handle response", new Object[0]);
            finish();
            return;
        }
        this.f21099b = (Intent) bundle.getParcelable("authIntent");
        this.f21098a = bundle.getBoolean("authStarted", false);
        try {
            C6587e c6587e = null;
            String string = bundle.getString("authRequest", null);
            if (string != null) {
                c6587e = C6587e.m26853a(string);
            }
            this.f21100c = c6587e;
            this.f21101d = (PendingIntent) bundle.getParcelable("completeIntent");
            this.f21102e = (PendingIntent) bundle.getParcelable("cancelIntent");
        } catch (Bundle bundle2) {
            throw new IllegalStateException("Unable to deserialize authorization request", bundle2);
        }
    }

    /* renamed from: a */
    private Intent m26774a(Uri uri) {
        if (uri.getQueryParameterNames().contains("error")) {
            return C6584d.m26823a(uri).m26836c();
        }
        uri = new C6589a(this.f21100c).m26861a(uri).m26869a();
        if ((this.f21100c.f21176i != null || uri.f21193b == null) && (this.f21100c.f21176i == null || this.f21100c.f21176i.equals(uri.f21193b))) {
            return uri.m26883d();
        }
        C6578a.m26807c("State returned in authorization response (%s) does not match state from request (%s) - discarding response", uri.f21193b, this.f21100c.f21176i);
        return C6581a.f21129j.m26836c();
    }
}
