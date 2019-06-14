package com.stripe.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.C4908c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0701i;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.stripe.android.C5756m.C5746a;
import com.stripe.android.C5756m.C5749d;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5753h;
import com.stripe.android.C7169b;
import com.stripe.android.C7169b.C5717a;
import com.stripe.android.p285b.C7158d;
import com.stripe.android.p285b.C7159e;
import java.util.List;

public class PaymentMethodsActivity extends C4908c {
    /* renamed from: a */
    private boolean f32924a;
    /* renamed from: b */
    private C7158d f32925b;
    /* renamed from: c */
    private C5794a f32926c;
    /* renamed from: d */
    private C7190g f32927d;
    /* renamed from: e */
    private ProgressBar f32928e;
    /* renamed from: f */
    private RecyclerView f32929f;
    /* renamed from: g */
    private boolean f32930g;
    /* renamed from: h */
    private boolean f32931h;

    /* renamed from: com.stripe.android.view.PaymentMethodsActivity$1 */
    class C57931 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ PaymentMethodsActivity f19205a;

        C57931(PaymentMethodsActivity paymentMethodsActivity) {
            this.f19205a = paymentMethodsActivity;
        }

        public void onClick(View view) {
            view = AddSourceActivity.m44521a(this.f19205a, false, true);
            if (this.f19205a.f32931h) {
                view.putExtra("payment_session_active", true);
            }
            this.f19205a.startActivityForResult(view, 700);
        }
    }

    /* renamed from: com.stripe.android.view.PaymentMethodsActivity$a */
    interface C5794a {
        /* renamed from: a */
        C7158d m24472a();

        /* renamed from: a */
        void m24473a(C5717a c5717a);

        /* renamed from: a */
        void m24474a(String str);

        /* renamed from: a */
        void m24475a(String str, String str2, C5717a c5717a);

        /* renamed from: b */
        void m24476b(C5717a c5717a);
    }

    /* renamed from: com.stripe.android.view.PaymentMethodsActivity$2 */
    class C71822 implements C5717a {
        /* renamed from: a */
        final /* synthetic */ PaymentMethodsActivity f25444a;

        C71822(PaymentMethodsActivity paymentMethodsActivity) {
            this.f25444a = paymentMethodsActivity;
        }

        /* renamed from: a */
        public void mo5077a(C7158d c7158d) {
            this.f25444a.m44485a(c7158d);
        }
    }

    /* renamed from: com.stripe.android.view.PaymentMethodsActivity$3 */
    class C71833 implements C5717a {
        /* renamed from: a */
        final /* synthetic */ PaymentMethodsActivity f25445a;

        C71833(PaymentMethodsActivity paymentMethodsActivity) {
            this.f25445a = paymentMethodsActivity;
        }

        /* renamed from: a */
        public void mo5077a(C7158d c7158d) {
            this.f25445a.m44492b(c7158d);
        }
    }

    /* renamed from: com.stripe.android.view.PaymentMethodsActivity$4 */
    class C71844 implements C5717a {
        /* renamed from: a */
        final /* synthetic */ PaymentMethodsActivity f25446a;

        C71844(PaymentMethodsActivity paymentMethodsActivity) {
            this.f25446a = paymentMethodsActivity;
        }

        /* renamed from: a */
        public void mo5077a(C7158d c7158d) {
            this.f25446a.f32925b = c7158d;
            this.f25446a.m44497h();
        }
    }

    /* renamed from: com.stripe.android.view.PaymentMethodsActivity$5 */
    class C71855 implements C5717a {
        /* renamed from: a */
        final /* synthetic */ PaymentMethodsActivity f25447a;

        C71855(PaymentMethodsActivity paymentMethodsActivity) {
            this.f25447a = paymentMethodsActivity;
        }

        /* renamed from: a */
        public void mo5077a(C7158d c7158d) {
            this.f25447a.f32925b = c7158d;
            this.f25447a.m44489a(c7158d.m33252c());
            this.f25447a.m44490a(false);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C5752g.activity_payment_methods);
        this.f32928e = (ProgressBar) findViewById(C5750e.payment_methods_progress_bar);
        this.f32929f = (RecyclerView) findViewById(C5750e.payment_methods_recycler);
        bundle = findViewById(C5750e.payment_methods_add_payment_container);
        bundle.setOnClickListener(new C57931(this));
        a((Toolbar) findViewById(C5750e.payment_methods_toolbar));
        if (b() != null) {
            b().b(true);
        }
        if (!getIntent().getBooleanExtra("proxy_delay", false)) {
            m44501f();
        }
        bundle.requestFocusFromTouch();
        this.f32931h = getIntent().hasExtra("payment_session_active");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 700 && i2 == -1) {
            m44490a((boolean) 1);
            m44496g();
            C5717a c71822 = new C71822(this);
            if (this.f32926c == 0) {
                C7169b.m33350a().m33369b(c71822);
            } else {
                this.f32926c.m24476b(c71822);
            }
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(C5750e.action_save).setIcon(C5816n.m24522a(this, getTheme(), C5746a.titleTextColor, C5749d.ic_checkmark));
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C5753h.add_source_menu, menu);
        menu.findItem(C5750e.action_save).setEnabled(this.f32924a ^ true);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == C5750e.action_save) {
            m44500k();
            return true;
        }
        menuItem = super.onOptionsItemSelected(menuItem);
        if (menuItem == null) {
            onBackPressed();
        }
        return menuItem;
    }

    /* renamed from: f */
    void m44501f() {
        C7158d b;
        if (this.f32926c == null) {
            b = C7169b.m33350a().m33368b();
        } else {
            b = this.f32926c.m24472a();
        }
        if (b != null) {
            this.f32925b = b;
            m44497h();
            return;
        }
        m44499j();
    }

    /* renamed from: g */
    private void m44496g() {
        if (this.f32926c == null) {
            if (this.f32931h) {
                C7169b.m33350a().m33367a("PaymentSession");
            }
            C7169b.m33350a().m33367a("PaymentMethodsActivity");
            return;
        }
        if (this.f32931h) {
            this.f32926c.m24474a("PaymentSession");
        }
        this.f32926c.m24474a("PaymentMethodsActivity");
    }

    /* renamed from: a */
    private void m44485a(C7158d c7158d) {
        if (TextUtils.isEmpty(c7158d.m33252c())) {
            if (c7158d.m33253d().size() == 1) {
                C5717a c71833 = new C71833(this);
                C7159e c7159e = (C7159e) c7158d.m33253d().get(0);
                if (c7159e != null) {
                    if (c7159e.mo5067y() != null) {
                        if (this.f32926c == null) {
                            C7169b.m33350a().m33363a((Context) this, c7159e.mo5067y(), c7159e.m33260f(), c71833);
                        } else {
                            this.f32926c.m24475a(c7159e.mo5067y(), c7159e.m33260f(), c71833);
                        }
                        return;
                    }
                }
                m44492b(c7158d);
                return;
            }
        }
        m44492b(c7158d);
    }

    /* renamed from: h */
    private void m44497h() {
        m44490a(false);
        if (this.f32925b != null) {
            List d = this.f32925b.m33253d();
            if (this.f32930g) {
                this.f32927d.m33400a(d);
            } else {
                this.f32927d = new C7190g(d);
                C0701i linearLayoutManager = new LinearLayoutManager(this);
                this.f32929f.setHasFixedSize(false);
                this.f32929f.setLayoutManager(linearLayoutManager);
                this.f32929f.setAdapter(this.f32927d);
                this.f32930g = true;
            }
            String c = this.f32925b.m33252c();
            if (!TextUtils.isEmpty(c)) {
                this.f32927d.m33403a(c);
            }
            this.f32927d.notifyDataSetChanged();
        }
    }

    /* renamed from: i */
    private void m44498i() {
        setResult(0);
        finish();
    }

    /* renamed from: a */
    private void m44489a(String str) {
        str = this.f32925b.m33249a(str);
        if (str != null) {
            Intent intent = new Intent();
            intent.putExtra("selected_payment", str.toString());
            setResult(-1, intent);
        } else {
            setResult(null);
        }
        finish();
    }

    /* renamed from: j */
    private void m44499j() {
        C5717a c71844 = new C71844(this);
        m44490a(true);
        if (this.f32926c == null) {
            C7169b.m33350a().m33365a(c71844);
        } else {
            this.f32926c.m24473a(c71844);
        }
    }

    /* renamed from: a */
    private void m44490a(boolean z) {
        this.f32924a = z;
        if (z) {
            this.f32928e.setVisibility(0);
        } else {
            this.f32928e.setVisibility(8);
        }
        supportInvalidateOptionsMenu();
    }

    /* renamed from: k */
    private void m44500k() {
        if (this.f32927d != null) {
            if (this.f32927d.m33395a() != null) {
                C7159e a = this.f32927d.m33395a();
                C5717a c71855 = new C71855(this);
                if (a != null) {
                    if (a.mo5067y() != null) {
                        if (this.f32926c == null) {
                            C7169b.m33350a().m33363a((Context) this, a.mo5067y(), a.m33260f(), c71855);
                        } else {
                            this.f32926c.m24475a(a.mo5067y(), a.m33260f(), c71855);
                        }
                        m44490a(true);
                        return;
                    }
                }
                return;
            }
        }
        m44498i();
    }

    /* renamed from: b */
    private void m44492b(C7158d c7158d) {
        if (this.f32927d == null) {
            m44497h();
            if (this.f32925b == null) {
                return;
            }
        }
        this.f32927d.m33398a(c7158d);
        m44490a((boolean) null);
    }
}
