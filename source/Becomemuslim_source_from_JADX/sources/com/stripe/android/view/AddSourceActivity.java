package com.stripe.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.stripe.android.C5740i;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5754i;
import com.stripe.android.C5760o;
import com.stripe.android.C5766p;
import com.stripe.android.C7169b;
import com.stripe.android.C7169b.C5718b;
import com.stripe.android.p285b.C5728m;
import com.stripe.android.p285b.C5731s;
import com.stripe.android.p285b.C7157c;
import com.stripe.android.p285b.C7162i;

public class AddSourceActivity extends C8356m {
    /* renamed from: a */
    CardMultilineWidget f32954a;
    /* renamed from: b */
    C5777a f32955b;
    /* renamed from: c */
    FrameLayout f32956c;
    /* renamed from: d */
    C5778b f32957d;
    /* renamed from: k */
    private boolean f32958k;
    /* renamed from: l */
    private boolean f32959l;

    /* renamed from: com.stripe.android.view.AddSourceActivity$a */
    interface C5777a {
        /* renamed from: a */
        void m24430a(String str);

        /* renamed from: a */
        void m24431a(String str, C5718b c5718b);
    }

    /* renamed from: com.stripe.android.view.AddSourceActivity$b */
    interface C5778b {
        /* renamed from: a */
        C5766p m24432a(Context context);
    }

    /* renamed from: com.stripe.android.view.AddSourceActivity$1 */
    class C71741 implements C5760o {
        /* renamed from: a */
        final /* synthetic */ AddSourceActivity f25436a;

        C71741(AddSourceActivity addSourceActivity) {
            this.f25436a = addSourceActivity;
        }

        /* renamed from: a */
        public void mo5072a(Exception exception) {
            this.f25436a.mo6892a(false);
            this.f25436a.m44502a((String) exception.getLocalizedMessage());
        }

        /* renamed from: a */
        public void mo5071a(C7162i c7162i) {
            if (this.f25436a.f32959l) {
                this.f25436a.m44523a((C5731s) c7162i);
            } else {
                this.f25436a.m44522a(c7162i);
            }
        }
    }

    /* renamed from: com.stripe.android.view.AddSourceActivity$2 */
    class C71752 implements C5718b {
        /* renamed from: a */
        final /* synthetic */ AddSourceActivity f25437a;

        C71752(AddSourceActivity addSourceActivity) {
            this.f25437a = addSourceActivity;
        }
    }

    public /* bridge */ /* synthetic */ boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public /* bridge */ /* synthetic */ boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: a */
    public static Intent m44521a(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, AddSourceActivity.class);
        intent.putExtra("show_zip", z);
        intent.putExtra("update_customer", z2);
        return intent;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j.setLayoutResource(C5752g.activity_add_source);
        this.j.inflate();
        this.f32954a = (CardMultilineWidget) findViewById(C5750e.add_source_card_entry_widget);
        this.f32956c = (FrameLayout) findViewById(C5750e.add_source_error_container);
        bundle = getIntent().getBooleanExtra("show_zip", false);
        this.f32959l = getIntent().getBooleanExtra("update_customer", false);
        this.f32958k = getIntent().getBooleanExtra("payment_session_active", true);
        this.f32954a.setShouldShowPostalCode(bundle);
        if (this.f32959l != null && getIntent().getBooleanExtra("proxy_delay", false) == null) {
            m44531f();
        }
        setTitle(C5754i.title_add_a_card);
    }

    /* renamed from: f */
    void m44531f() {
        m44526a("AddSourceActivity", this.f32959l);
        m44526a("PaymentSession", this.f32958k);
    }

    /* renamed from: g */
    protected void mo6893g() {
        C7157c card = this.f32954a.getCard();
        if (card != null) {
            card.m33221c("AddSourceActivity");
            C5766p h = m44529h();
            h.m24357a(C5740i.m24307a().m24308b());
            C5728m a = C5728m.m24251a(card);
            mo6892a(true);
            h.m24355a(a, new C71741(this));
        }
    }

    /* renamed from: a */
    private void m44523a(C5731s c5731s) {
        C5718b c71752 = new C71752(this);
        if (this.f32955b == null) {
            String q = c5731s instanceof C7162i ? ((C7162i) c5731s).m33297q() : c5731s instanceof C7157c ? "card" : "unknown";
            C7169b.m33350a().m33364a((Context) this, c5731s.mo5067y(), q, c71752);
            return;
        }
        this.f32955b.m24431a(c5731s.mo5067y(), c71752);
    }

    /* renamed from: a */
    private void m44526a(String str, boolean z) {
        if (this.f32955b != null) {
            m44528b(str, z);
            return;
        }
        if (z) {
            C7169b.m33350a().m33367a(str);
        }
    }

    /* renamed from: b */
    private void m44528b(String str, boolean z) {
        if (this.f32955b != null && z) {
            this.f32955b.m24430a(str);
        }
    }

    /* renamed from: a */
    private void m44522a(C7162i c7162i) {
        mo6892a(false);
        Intent intent = new Intent();
        intent.putExtra("new_source", c7162i.toString());
        setResult(-1, intent);
        finish();
    }

    /* renamed from: h */
    private C5766p m44529h() {
        if (this.f32957d == null) {
            return new C5766p(this);
        }
        return this.f32957d.m24432a(this);
    }

    /* renamed from: a */
    protected void mo6892a(boolean z) {
        super.mo6892a(z);
        if (this.f32954a != null) {
            this.f32954a.setEnabled(z ^ 1);
        }
    }
}
