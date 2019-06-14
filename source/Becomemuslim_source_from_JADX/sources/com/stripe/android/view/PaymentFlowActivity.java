package com.stripe.android.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.C0373d;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0473f;
import android.view.Menu;
import android.view.MenuItem;
import com.stripe.android.C5742j;
import com.stripe.android.C5744k;
import com.stripe.android.C5756m.C5750e;
import com.stripe.android.C5756m.C5752g;
import com.stripe.android.C5756m.C5754i;
import com.stripe.android.C7169b;
import com.stripe.android.p285b.C7160g;
import com.stripe.android.p285b.C7161h;
import java.util.List;

public class PaymentFlowActivity extends C8356m {
    /* renamed from: a */
    private BroadcastReceiver f32960a;
    /* renamed from: b */
    private BroadcastReceiver f32961b;
    /* renamed from: c */
    private C7191h f32962c;
    /* renamed from: d */
    private ViewPager f32963d;
    /* renamed from: k */
    private C5744k f32964k;
    /* renamed from: l */
    private C7160g f32965l;
    /* renamed from: m */
    private List<C7161h> f32966m;
    /* renamed from: n */
    private C7161h f32967n;

    /* renamed from: com.stripe.android.view.PaymentFlowActivity$2 */
    class C57912 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ PaymentFlowActivity f19203a;

        C57912(PaymentFlowActivity paymentFlowActivity) {
            this.f19203a = paymentFlowActivity;
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getBooleanExtra("shipping_is_shipping_info_valid", false) != null) {
                this.f19203a.m44545f();
                this.f19203a.f32966m = intent.getParcelableArrayListExtra("valid_shipping_methods");
                this.f19203a.f32967n = (C7161h) intent.getParcelableExtra("default_shipping_method");
                return;
            }
            this.f19203a.mo6892a(false);
            context = intent.getStringExtra("shipping_info_error");
            if (context == null || context.isEmpty() != null) {
                this.f19203a.m44502a((String) this.f19203a.getString(C5754i.invalid_shipping_information));
            } else {
                this.f19203a.m44502a((String) context);
            }
            this.f19203a.f32965l = null;
        }
    }

    /* renamed from: com.stripe.android.view.PaymentFlowActivity$3 */
    class C57923 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ PaymentFlowActivity f19204a;

        C57923(PaymentFlowActivity paymentFlowActivity) {
            this.f19204a = paymentFlowActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.f19204a.m44539a((List) this.f19204a.f32966m, this.f19204a.f32967n);
            this.f19204a.f32964k.m24318a(this.f19204a.f32965l);
        }
    }

    /* renamed from: com.stripe.android.view.PaymentFlowActivity$1 */
    class C71811 implements C0473f {
        /* renamed from: a */
        final /* synthetic */ PaymentFlowActivity f25443a;

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        C71811(PaymentFlowActivity paymentFlowActivity) {
            this.f25443a = paymentFlowActivity;
        }

        public void onPageSelected(int i) {
            this.f25443a.setTitle(this.f25443a.f32963d.getAdapter().getPageTitle(i));
            if (this.f25443a.f32962c.m33405a(i) == C5809i.SHIPPING_INFO) {
                this.f25443a.f32962c.m33406a();
            }
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

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C7169b.m33350a().m33367a("PaymentSession");
        C7169b.m33350a().m33367a("PaymentFlowActivity");
        this.j.setLayoutResource(C5752g.activity_shipping_flow);
        this.j.inflate();
        this.f32963d = (ViewPager) findViewById(C5750e.shipping_flow_viewpager);
        C5742j c5742j = (C5742j) getIntent().getParcelableExtra("payment_session_config");
        this.f32964k = (C5744k) getIntent().getParcelableExtra("payment_session_data");
        if (this.f32964k != null) {
            this.f32962c = new C7191h(this, c5742j);
            this.f32963d.setAdapter(this.f32962c);
            this.f32963d.addOnPageChangeListener(new C71811(this));
            this.f32961b = new C57912(this);
            this.f32960a = new C57923(this);
            setTitle(this.f32962c.getPageTitle(this.f32963d.getCurrentItem()));
            return;
        }
        throw new IllegalArgumentException("PaymentFlowActivity launched without PaymentSessionData");
    }

    /* renamed from: g */
    protected void mo6893g() {
        if (this.f32962c.m33405a(this.f32963d.getCurrentItem()).equals(C5809i.SHIPPING_INFO)) {
            m44547h();
        } else {
            m44550k();
        }
    }

    protected void onPause() {
        super.onPause();
        C0373d.a(this).a(this.f32961b);
        C0373d.a(this).a(this.f32960a);
    }

    protected void onResume() {
        super.onResume();
        C0373d.a(this).a(this.f32961b, new IntentFilter("shipping_info_processed"));
        C0373d.a(this).a(this.f32960a, new IntentFilter("shipping_info_saved"));
    }

    /* renamed from: f */
    private void m44545f() {
        C7169b.m33350a().m33362a((Context) this, this.f32965l);
    }

    /* renamed from: a */
    private void m44539a(List<C7161h> list, C7161h c7161h) {
        mo6892a(false);
        this.f32962c.m33407a(list, c7161h);
        this.f32962c.m33408a(true);
        if (m44548i() != null) {
            this.f32963d.setCurrentItem(this.f32963d.getCurrentItem() + 1);
            return;
        }
        this.f32964k.m24318a(this.f32965l);
        list = new Intent();
        list.putExtra("payment_session_data", this.f32964k);
        setResult(-1, list);
        finish();
    }

    /* renamed from: h */
    private void m44547h() {
        C7160g shippingInformation = ((ShippingInfoWidget) findViewById(C5750e.shipping_info_widget)).getShippingInformation();
        if (shippingInformation != null) {
            this.f32965l = shippingInformation;
            mo6892a(true);
            m44537a(shippingInformation);
        }
    }

    /* renamed from: a */
    private void m44537a(C7160g c7160g) {
        Intent intent = new Intent("shipping_info_submitted");
        intent.putExtra("shipping_info_data", c7160g);
        C0373d.a(this).a(intent);
    }

    /* renamed from: i */
    private boolean m44548i() {
        return this.f32963d.getCurrentItem() + 1 < this.f32962c.getCount();
    }

    /* renamed from: j */
    private boolean m44549j() {
        return this.f32963d.getCurrentItem() != 0;
    }

    /* renamed from: k */
    private void m44550k() {
        this.f32964k.m24319a(((SelectShippingMethodWidget) findViewById(C5750e.select_shipping_method_widget)).getSelectedShippingMethod());
        Intent intent = new Intent();
        intent.putExtra("payment_session_data", this.f32964k);
        setResult(-1, intent);
        finish();
    }

    public void onBackPressed() {
        if (m44549j()) {
            this.f32963d.setCurrentItem(this.f32963d.getCurrentItem() - 1);
        } else {
            super.onBackPressed();
        }
    }
}
