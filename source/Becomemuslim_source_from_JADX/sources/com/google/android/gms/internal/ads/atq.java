package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@cm
public final class atq implements OnClickListener {
    /* renamed from: a */
    String f14992a;
    /* renamed from: b */
    Long f14993b;
    /* renamed from: c */
    WeakReference<View> f14994c;
    /* renamed from: d */
    private final bq f14995d;
    /* renamed from: e */
    private awx f14996e;
    /* renamed from: f */
    private ae f14997f;

    public atq(bq bqVar) {
        this.f14995d = bqVar;
    }

    /* renamed from: c */
    private final void m18935c() {
        this.f14992a = null;
        this.f14993b = null;
        if (this.f14994c != null) {
            View view = (View) this.f14994c.get();
            this.f14994c = null;
            if (view != null) {
                view.setClickable(false);
                view.setOnClickListener(null);
            }
        }
    }

    /* renamed from: a */
    public final awx m18936a() {
        return this.f14996e;
    }

    /* renamed from: a */
    public final void m18937a(awx awx) {
        this.f14996e = awx;
        if (this.f14997f != null) {
            this.f14995d.mo4225b("/unconfirmedClick", this.f14997f);
        }
        this.f14997f = new atr(this);
        this.f14995d.mo4222a("/unconfirmedClick", this.f14997f);
    }

    /* renamed from: b */
    public final void m18938b() {
        if (this.f14996e != null && this.f14993b != null) {
            m18935c();
            try {
                this.f14996e.mo4060a();
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }

    public final void onClick(View view) {
        if (this.f14994c == null) {
            return;
        }
        if (this.f14994c.get() == view) {
            if (this.f14992a != null) {
                if (this.f14993b != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f14992a);
                        jSONObject.put("time_interval", ax.l().a() - this.f14993b.longValue());
                        jSONObject.put("messageType", "onePointFiveClick");
                        this.f14995d.mo4223a("sendMessageToNativeJs", jSONObject);
                    } catch (Throwable e) {
                        mt.m19919b("Unable to dispatch sendMessageToNativeJs event", e);
                    }
                }
            }
            m18935c();
        }
    }
}
