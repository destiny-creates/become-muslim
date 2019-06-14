package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.ax;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@cm
public final class kx {
    /* renamed from: a */
    private final Object f15733a = new Object();
    /* renamed from: b */
    private String f15734b = "";
    /* renamed from: c */
    private String f15735c = "";
    /* renamed from: d */
    private boolean f15736d = false;
    /* renamed from: e */
    private String f15737e = "";

    /* renamed from: a */
    private final String m19799a(Context context) {
        String str;
        synchronized (this.f15733a) {
            if (TextUtils.isEmpty(this.f15734b)) {
                ax.e();
                this.f15734b = jw.m19718c(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.f15734b)) {
                    ax.e();
                    this.f15734b = jw.m19688a();
                    ax.e();
                    jw.m19715b(context, "debug_signals_id.txt", this.f15734b);
                }
            }
            str = this.f15734b;
        }
        return str;
    }

    /* renamed from: a */
    private final void m19800a(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            jw.f15691a.post(new ky(this, context, str, z, z2));
        } else {
            mt.m19922d("Can not create dialog without Activity Context");
        }
    }

    /* renamed from: b */
    private final boolean m19801b(Context context, String str, String str2) {
        Object d = m19804d(context, m19802c(context, (String) aph.m18688f().m18889a(asp.cT), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            mt.m19918b("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(d.trim());
            String optString = jSONObject.optString("gct");
            this.f15737e = jSONObject.optString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            synchronized (this.f15733a) {
                this.f15735c = optString;
            }
            return true;
        } catch (Throwable e) {
            mt.m19921c("Fail to get in app preview response json.", e);
            return false;
        }
    }

    /* renamed from: c */
    private final Uri m19802c(Context context, String str, String str2, String str3) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", m19799a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    /* renamed from: c */
    private final boolean m19803c(Context context, String str, String str2) {
        Object d = m19804d(context, m19802c(context, (String) aph.m18688f().m18889a(asp.cU), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            mt.m19918b("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(new JSONObject(d.trim()).optString("debug_mode"));
            synchronized (this.f15733a) {
                this.f15736d = equals;
            }
            return equals;
        } catch (Throwable e) {
            mt.m19921c("Fail to get debug mode response json.", e);
            return false;
        }
    }

    /* renamed from: d */
    private static String m19804d(Context context, String str, String str2) {
        Throwable e;
        String str3;
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", ax.e().m19744b(context, str2));
        no a = new lg(context).m19833a(str, hashMap);
        try {
            return (String) a.get((long) ((Integer) aph.m18688f().m18889a(asp.cW)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
            str3 = "Timeout while retriving a response from: ";
            str = String.valueOf(str);
            if (str.length() == 0) {
                str = new String(str3);
                mt.m19919b(str, e);
                a.cancel(true);
                return null;
            }
            str = str3.concat(str);
            mt.m19919b(str, e);
            a.cancel(true);
            return null;
        } catch (InterruptedException e3) {
            e = e3;
            str3 = "Interrupted while retriving a response from: ";
            str = String.valueOf(str);
            if (str.length() != 0) {
                str = str3.concat(str);
                mt.m19919b(str, e);
                a.cancel(true);
                return null;
            }
            str = new String(str3);
            mt.m19919b(str, e);
            a.cancel(true);
            return null;
        } catch (Throwable e4) {
            str2 = "Error retriving a response from: ";
            str = String.valueOf(str);
            mt.m19919b(str.length() != 0 ? str2.concat(str) : new String(str2), e4);
            return null;
        }
    }

    /* renamed from: e */
    private final void m19805e(Context context, String str, String str2) {
        ax.e();
        jw.m19697a(context, m19802c(context, (String) aph.m18688f().m18889a(asp.cS), str, str2));
    }

    /* renamed from: a */
    public final String m19806a() {
        String str;
        synchronized (this.f15733a) {
            str = this.f15735c;
        }
        return str;
    }

    /* renamed from: a */
    public final void m19807a(Context context, String str, String str2) {
        if (!m19801b(context, str, str2)) {
            m19800a(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(this.f15737e)) {
            mt.m19918b("Creative is not pushed for this device.");
            m19800a(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f15737e)) {
            mt.m19918b("The app is not linked for creative preview.");
            m19805e(context, str, str2);
        } else {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.f15737e)) {
                mt.m19918b("Device is linked for in app preview.");
                m19800a(context, "The device is successfully linked for creative preview.", false, true);
            }
        }
    }

    /* renamed from: a */
    public final void m19808a(Context context, String str, String str2, String str3) {
        boolean b = m19810b();
        if (m19803c(context, str, str2)) {
            if (!(b || TextUtils.isEmpty(str3))) {
                m19809b(context, str2, str3, str);
            }
            mt.m19918b("Device is linked for debug signals.");
            m19800a(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        m19805e(context, str, str2);
    }

    /* renamed from: b */
    public final void m19809b(Context context, String str, String str2, String str3) {
        Builder buildUpon = m19802c(context, (String) aph.m18688f().m18889a(asp.cV), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        ax.e();
        jw.m19698a(context, str, buildUpon.build().toString());
    }

    /* renamed from: b */
    public final boolean m19810b() {
        boolean z;
        synchronized (this.f15733a) {
            z = this.f15736d;
        }
        return z;
    }
}
