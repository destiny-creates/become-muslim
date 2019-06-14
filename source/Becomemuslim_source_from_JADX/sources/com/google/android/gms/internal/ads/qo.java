package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.aq;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.ads.internal.gmsg.ae;
import com.google.android.gms.ads.internal.overlay.C4740d;
import com.google.android.gms.common.util.C2905p;

@cm
public interface qo extends aq, akw, azm, ban, pn, rk, rl, rp, rs, ru, rv {
    /* renamed from: A */
    boolean mo6660A();

    /* renamed from: B */
    void mo6661B();

    /* renamed from: C */
    boolean mo6662C();

    /* renamed from: D */
    boolean mo6663D();

    /* renamed from: E */
    boolean mo6664E();

    /* renamed from: F */
    void mo6665F();

    /* renamed from: G */
    void mo6666G();

    /* renamed from: H */
    aud mo6667H();

    /* renamed from: I */
    void mo6668I();

    /* renamed from: J */
    void mo6669J();

    /* renamed from: a */
    void mo6671a(int i);

    /* renamed from: a */
    void mo6672a(Context context);

    /* renamed from: a */
    void mo6674a(C4740d c4740d);

    /* renamed from: a */
    void mo6675a(aud aud);

    /* renamed from: a */
    void mo6126a(re reVar);

    /* renamed from: a */
    void mo6676a(sc scVar);

    /* renamed from: a */
    void mo6677a(String str);

    /* renamed from: a */
    void mo6678a(String str, ae<? super qo> aeVar);

    /* renamed from: a */
    void mo6679a(String str, C2905p<ae<? super qo>> c2905p);

    /* renamed from: a */
    void mo6680a(String str, String str2, String str3);

    /* renamed from: b */
    re mo6127b();

    /* renamed from: b */
    void mo6685b(C4740d c4740d);

    /* renamed from: b */
    void mo6686b(String str, ae<? super qo> aeVar);

    /* renamed from: b */
    void mo6687b(boolean z);

    /* renamed from: c */
    void mo6689c(boolean z);

    /* renamed from: d */
    Activity mo6128d();

    /* renamed from: d */
    void mo6690d(boolean z);

    void destroy();

    /* renamed from: e */
    bu mo6129e();

    /* renamed from: e */
    void mo6692e(boolean z);

    Context getContext();

    int getHeight();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    OnClickListener getOnClickListener();

    ViewParent getParent();

    int getRequestedOrientation();

    View getView();

    WebView getWebView();

    int getWidth();

    /* renamed from: j */
    atb mo6132j();

    /* renamed from: k */
    mv mo6133k();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    /* renamed from: n */
    void mo6703n();

    /* renamed from: o */
    void mo6704o();

    void onPause();

    void onResume();

    /* renamed from: p */
    void mo6707p();

    /* renamed from: q */
    Context mo6708q();

    /* renamed from: r */
    C4740d mo6709r();

    /* renamed from: s */
    C4740d mo6710s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    /* renamed from: t */
    sc mo6135t();

    /* renamed from: u */
    String mo6717u();

    /* renamed from: v */
    rw mo6718v();

    /* renamed from: w */
    WebViewClient mo6719w();

    /* renamed from: x */
    boolean mo6720x();

    /* renamed from: y */
    ahi mo6136y();

    /* renamed from: z */
    boolean mo6137z();
}
