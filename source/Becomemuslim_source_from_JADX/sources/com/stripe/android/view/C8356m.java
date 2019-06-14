package com.stripe.android.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0373d;
import android.support.v7.app.C4473b.C0609a;
import android.support.v7.app.C4908c;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.stripe.android.C5756m.C5746a;
import com.stripe.android.C5756m.C5749d;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5753h;
import com.stripe.android.p284a.C5711h;

/* compiled from: StripeActivity */
/* renamed from: com.stripe.android.view.m */
abstract class C8356m extends C4908c {
    /* renamed from: e */
    BroadcastReceiver f32932e;
    /* renamed from: f */
    C5815a f32933f;
    /* renamed from: g */
    boolean f32934g;
    /* renamed from: h */
    Toolbar f32935h;
    /* renamed from: i */
    ProgressBar f32936i;
    /* renamed from: j */
    ViewStub f32937j;

    /* compiled from: StripeActivity */
    /* renamed from: com.stripe.android.view.m$1 */
    class C58131 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ C8356m f19255a;

        C58131(C8356m c8356m) {
            this.f19255a = c8356m;
        }

        public void onReceive(Context context, Intent intent) {
            this.f19255a.m44502a(((C5711h) intent.getSerializableExtra("exception")).getLocalizedMessage());
        }
    }

    /* compiled from: StripeActivity */
    /* renamed from: com.stripe.android.view.m$2 */
    class C58142 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C8356m f19256a;

        C58142(C8356m c8356m) {
            this.f19256a = c8356m;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: StripeActivity */
    /* renamed from: com.stripe.android.view.m$a */
    interface C5815a {
        /* renamed from: a */
        void m24520a(String str);
    }

    /* renamed from: g */
    protected abstract void mo6893g();

    C8356m() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5752g.activity_stripe);
        this.f32936i = (ProgressBar) findViewById(C5750e.progress_bar_as);
        this.f32935h = (Toolbar) findViewById(C5750e.toolbar_as);
        this.f32937j = (ViewStub) findViewById(C5750e.widget_viewstub_as);
        if (b() != null) {
            b().b(true);
        }
        a(this.f32935h);
        if (b() != null) {
            b().b(true);
        }
        mo6892a((boolean) null);
        this.f32932e = new C58131(this);
    }

    protected void onPause() {
        super.onPause();
        C0373d.a(this).a(this.f32932e);
    }

    protected void onResume() {
        super.onResume();
        C0373d.a(this).a(this.f32932e, new IntentFilter("action_api_exception"));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C5753h.add_source_menu, menu);
        menu.findItem(C5750e.action_save).setEnabled(this.f32934g ^ true);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C5750e.action_save) {
            mo6893g();
            return true;
        }
        menuItem = super.onOptionsItemSelected(menuItem);
        if (menuItem == null) {
            onBackPressed();
        }
        return menuItem;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(C5750e.action_save).setIcon(C5816n.m24522a(this, getTheme(), C5746a.titleTextColor, C5749d.ic_checkmark));
        return super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: a */
    protected void mo6892a(boolean z) {
        this.f32934g = z;
        if (z) {
            this.f32936i.setVisibility(0);
        } else {
            this.f32936i.setVisibility(8);
        }
        supportInvalidateOptionsMenu();
    }

    /* renamed from: a */
    void m44502a(String str) {
        if (this.f32933f != null) {
            this.f32933f.m24520a(str);
        }
        new C0609a(this).b(str).a(true).a(17039370, new C58142(this)).b().show();
    }
}
