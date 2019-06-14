package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.ads.internal.overlay.C4739c;
import com.google.android.gms.ads.internal.overlay.C4740d;
import com.google.android.gms.ads.p169c.C2627a.C2626a;
import com.google.android.gms.common.util.C2905p;
import java.util.Map;
import org.json.JSONObject;

@cm
public final class ra extends FrameLayout implements qo {
    /* renamed from: a */
    private final qo f32215a;
    /* renamed from: b */
    private final pe f32216b;

    public ra(qo qoVar) {
        super(qoVar.getContext());
        this.f32215a = qoVar;
        this.f32216b = new pe(qoVar.mo6708q(), this, this);
        addView(this.f32215a.getView());
    }

    /* renamed from: A */
    public final boolean mo6660A() {
        return this.f32215a.mo6660A();
    }

    /* renamed from: B */
    public final void mo6661B() {
        this.f32216b.m19997c();
        this.f32215a.mo6661B();
    }

    /* renamed from: C */
    public final boolean mo6662C() {
        return this.f32215a.mo6662C();
    }

    /* renamed from: D */
    public final boolean mo6663D() {
        return this.f32215a.mo6663D();
    }

    /* renamed from: E */
    public final boolean mo6664E() {
        return this.f32215a.mo6664E();
    }

    /* renamed from: F */
    public final void mo6665F() {
        this.f32215a.mo6665F();
    }

    /* renamed from: G */
    public final void mo6666G() {
        this.f32215a.mo6666G();
    }

    /* renamed from: H */
    public final aud mo6667H() {
        return this.f32215a.mo6667H();
    }

    /* renamed from: I */
    public final void mo6668I() {
        setBackgroundColor(0);
        this.f32215a.setBackgroundColor(0);
    }

    /* renamed from: J */
    public final void mo6669J() {
        View textView = new TextView(getContext());
        Resources h = ax.i().m30843h();
        textView.setText(h != null ? h.getString(C2626a.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    /* renamed from: a */
    public final pe mo6670a() {
        return this.f32216b;
    }

    /* renamed from: a */
    public final void mo6671a(int i) {
        this.f32215a.mo6671a(i);
    }

    /* renamed from: a */
    public final void mo6672a(Context context) {
        this.f32215a.mo6672a(context);
    }

    /* renamed from: a */
    public final void mo6673a(C4739c c4739c) {
        this.f32215a.mo6673a(c4739c);
    }

    /* renamed from: a */
    public final void mo6674a(C4740d c4740d) {
        this.f32215a.mo6674a(c4740d);
    }

    /* renamed from: a */
    public final void mo4298a(akv akv) {
        this.f32215a.mo4298a(akv);
    }

    /* renamed from: a */
    public final void mo6675a(aud aud) {
        this.f32215a.mo6675a(aud);
    }

    /* renamed from: a */
    public final void mo6126a(re reVar) {
        this.f32215a.mo6126a(reVar);
    }

    /* renamed from: a */
    public final void mo6676a(sc scVar) {
        this.f32215a.mo6676a(scVar);
    }

    /* renamed from: a */
    public final void mo6677a(String str) {
        this.f32215a.mo6677a(str);
    }

    /* renamed from: a */
    public final void mo6678a(String str, ae<? super qo> aeVar) {
        this.f32215a.mo6678a(str, (ae) aeVar);
    }

    /* renamed from: a */
    public final void mo6679a(String str, C2905p<ae<? super qo>> c2905p) {
        this.f32215a.mo6679a(str, (C2905p) c2905p);
    }

    /* renamed from: a */
    public final void mo6680a(String str, String str2, String str3) {
        this.f32215a.mo6680a(str, str2, str3);
    }

    /* renamed from: a */
    public final void mo6650a(String str, Map<String, ?> map) {
        this.f32215a.mo6650a(str, (Map) map);
    }

    /* renamed from: a */
    public final void mo4089a(String str, JSONObject jSONObject) {
        this.f32215a.mo4089a(str, jSONObject);
    }

    /* renamed from: a */
    public final void mo6681a(boolean z) {
        this.f32215a.mo6681a(z);
    }

    /* renamed from: a */
    public final void mo6682a(boolean z, int i) {
        this.f32215a.mo6682a(z, i);
    }

    /* renamed from: a */
    public final void mo6683a(boolean z, int i, String str) {
        this.f32215a.mo6683a(z, i, str);
    }

    /* renamed from: a */
    public final void mo6684a(boolean z, int i, String str, String str2) {
        this.f32215a.mo6684a(z, i, str, str2);
    }

    /* renamed from: b */
    public final re mo6127b() {
        return this.f32215a.mo6127b();
    }

    /* renamed from: b */
    public final void mo6685b(C4740d c4740d) {
        this.f32215a.mo6685b(c4740d);
    }

    /* renamed from: b */
    public final void mo4090b(String str) {
        this.f32215a.mo4090b(str);
    }

    /* renamed from: b */
    public final void mo6686b(String str, ae<? super qo> aeVar) {
        this.f32215a.mo6686b(str, aeVar);
    }

    /* renamed from: b */
    public final void mo6652b(String str, JSONObject jSONObject) {
        this.f32215a.mo6652b(str, jSONObject);
    }

    /* renamed from: b */
    public final void mo6687b(boolean z) {
        this.f32215a.mo6687b(z);
    }

    /* renamed from: c */
    public final ata mo6688c() {
        return this.f32215a.mo6688c();
    }

    /* renamed from: c */
    public final void mo6689c(boolean z) {
        this.f32215a.mo6689c(z);
    }

    /* renamed from: d */
    public final Activity mo6128d() {
        return this.f32215a.mo6128d();
    }

    /* renamed from: d */
    public final void mo6690d(boolean z) {
        this.f32215a.mo6690d(z);
    }

    public final void destroy() {
        this.f32215a.destroy();
    }

    /* renamed from: e */
    public final bu mo6129e() {
        return this.f32215a.mo6129e();
    }

    /* renamed from: e */
    public final void mo6692e(boolean z) {
        this.f32215a.mo6692e(z);
    }

    /* renamed from: f */
    public final void mo6693f() {
        this.f32215a.mo6693f();
    }

    public final OnClickListener getOnClickListener() {
        return this.f32215a.getOnClickListener();
    }

    public final int getRequestedOrientation() {
        return this.f32215a.getRequestedOrientation();
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this.f32215a.getWebView();
    }

    /* renamed from: i */
    public final String mo6697i() {
        return this.f32215a.mo6697i();
    }

    /* renamed from: j */
    public final atb mo6132j() {
        return this.f32215a.mo6132j();
    }

    /* renamed from: k */
    public final mv mo6133k() {
        return this.f32215a.mo6133k();
    }

    /* renamed from: l */
    public final int mo6698l() {
        return getMeasuredHeight();
    }

    public final void loadData(String str, String str2, String str3) {
        this.f32215a.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f32215a.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.f32215a.loadUrl(str);
    }

    /* renamed from: m */
    public final int mo6702m() {
        return getMeasuredWidth();
    }

    public final void m_() {
        this.f32215a.m_();
    }

    /* renamed from: n */
    public final void mo6703n() {
        this.f32215a.mo6703n();
    }

    public final void n_() {
        this.f32215a.n_();
    }

    /* renamed from: o */
    public final void mo6704o() {
        this.f32215a.mo6704o();
    }

    public final void onPause() {
        this.f32216b.m19996b();
        this.f32215a.onPause();
    }

    public final void onResume() {
        this.f32215a.onResume();
    }

    /* renamed from: p */
    public final void mo6707p() {
        this.f32215a.mo6707p();
    }

    /* renamed from: q */
    public final Context mo6708q() {
        return this.f32215a.mo6708q();
    }

    /* renamed from: r */
    public final C4740d mo6709r() {
        return this.f32215a.mo6709r();
    }

    /* renamed from: s */
    public final C4740d mo6710s() {
        return this.f32215a.mo6710s();
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f32215a.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f32215a.setOnTouchListener(onTouchListener);
    }

    public final void setRequestedOrientation(int i) {
        this.f32215a.setRequestedOrientation(i);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f32215a.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f32215a.setWebViewClient(webViewClient);
    }

    public final void stopLoading() {
        this.f32215a.stopLoading();
    }

    /* renamed from: t */
    public final sc mo6135t() {
        return this.f32215a.mo6135t();
    }

    /* renamed from: u */
    public final String mo6717u() {
        return this.f32215a.mo6717u();
    }

    /* renamed from: v */
    public final rw mo6718v() {
        return this.f32215a.mo6718v();
    }

    /* renamed from: w */
    public final WebViewClient mo6719w() {
        return this.f32215a.mo6719w();
    }

    /* renamed from: x */
    public final boolean mo6720x() {
        return this.f32215a.mo6720x();
    }

    /* renamed from: y */
    public final ahi mo6136y() {
        return this.f32215a.mo6136y();
    }

    /* renamed from: z */
    public final boolean mo6137z() {
        return this.f32215a.mo6137z();
    }
}
