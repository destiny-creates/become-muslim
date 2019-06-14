package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@cm
public final class kq {
    /* renamed from: a */
    private final Context f15706a;
    /* renamed from: b */
    private String f15707b;
    /* renamed from: c */
    private String f15708c;
    /* renamed from: d */
    private String f15709d;
    /* renamed from: e */
    private String f15710e;
    /* renamed from: f */
    private final float f15711f;
    /* renamed from: g */
    private float f15712g;
    /* renamed from: h */
    private float f15713h;
    /* renamed from: i */
    private float f15714i;
    /* renamed from: j */
    private int f15715j;
    /* renamed from: k */
    private int f15716k;
    /* renamed from: l */
    private float f15717l;
    /* renamed from: m */
    private float f15718m;
    /* renamed from: n */
    private float f15719n;
    /* renamed from: o */
    private float f15720o;
    /* renamed from: p */
    private Handler f15721p;
    /* renamed from: q */
    private Runnable f15722q;

    public kq(Context context) {
        this.f15715j = 0;
        this.f15722q = new kr(this);
        this.f15706a = context;
        this.f15711f = context.getResources().getDisplayMetrics().density;
        this.f15716k = ViewConfiguration.get(this.f15706a).getScaledTouchSlop();
        ax.t().m19837a();
        this.f15721p = ax.t().m19838b();
    }

    public kq(Context context, String str) {
        this(context);
        this.f15707b = str;
    }

    /* renamed from: a */
    private static int m19784a(List<String> list, String str, boolean z) {
        if (!z) {
            return -1;
        }
        list.add(str);
        return list.size() - 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private final void m19785a(int r5, float r6, float r7) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000c;
    L_0x0002:
        r5 = 0;
        r4.f15715j = r5;
        r4.f15712g = r6;
        r4.f15713h = r7;
        r4.f15714i = r7;
        return;
    L_0x000c:
        r0 = r4.f15715j;
        r1 = -1;
        if (r0 != r1) goto L_0x0012;
    L_0x0011:
        return;
    L_0x0012:
        r0 = 2;
        r2 = 1;
        if (r5 != r0) goto L_0x008e;
    L_0x0016:
        r5 = r4.f15713h;
        r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x001f;
    L_0x001c:
        r4.f15713h = r7;
        goto L_0x0027;
    L_0x001f:
        r5 = r4.f15714i;
        r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0027;
    L_0x0025:
        r4.f15714i = r7;
    L_0x0027:
        r5 = r4.f15713h;
        r7 = r4.f15714i;
        r5 = r5 - r7;
        r7 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r3 = r4.f15711f;
        r3 = r3 * r7;
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0039;
    L_0x0036:
        r4.f15715j = r1;
        return;
    L_0x0039:
        r5 = r4.f15715j;
        r7 = 3;
        if (r5 == 0) goto L_0x005a;
    L_0x003e:
        r5 = r4.f15715j;
        if (r5 != r0) goto L_0x0043;
    L_0x0042:
        goto L_0x005a;
    L_0x0043:
        r5 = r4.f15715j;
        if (r5 == r2) goto L_0x004b;
    L_0x0047:
        r5 = r4.f15715j;
        if (r5 != r7) goto L_0x006f;
    L_0x004b:
        r5 = r4.f15712g;
        r5 = r6 - r5;
        r1 = -1035468800; // 0xffffffffc2480000 float:-50.0 double:NaN;
        r3 = r4.f15711f;
        r3 = r3 * r1;
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 > 0) goto L_0x006f;
    L_0x0059:
        goto L_0x0068;
    L_0x005a:
        r5 = r4.f15712g;
        r5 = r6 - r5;
        r1 = 1112014848; // 0x42480000 float:50.0 double:5.49408334E-315;
        r3 = r4.f15711f;
        r3 = r3 * r1;
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 < 0) goto L_0x006f;
    L_0x0068:
        r4.f15712g = r6;
        r5 = r4.f15715j;
        r5 = r5 + r2;
        r4.f15715j = r5;
    L_0x006f:
        r5 = r4.f15715j;
        if (r5 == r2) goto L_0x0085;
    L_0x0073:
        r5 = r4.f15715j;
        if (r5 != r7) goto L_0x0078;
    L_0x0077:
        goto L_0x0085;
    L_0x0078:
        r5 = r4.f15715j;
        if (r5 != r0) goto L_0x0098;
    L_0x007c:
        r5 = r4.f15712g;
        r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0098;
    L_0x0082:
        r4.f15712g = r6;
        return;
    L_0x0085:
        r5 = r4.f15712g;
        r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r5 <= 0) goto L_0x0098;
    L_0x008b:
        r4.f15712g = r6;
        return;
    L_0x008e:
        if (r5 != r2) goto L_0x0098;
    L_0x0090:
        r5 = r4.f15715j;
        r6 = 4;
        if (r5 != r6) goto L_0x0098;
    L_0x0095:
        r4.m19788a();
    L_0x0098:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.kq.a(int, float, float):void");
    }

    /* renamed from: a */
    private final boolean m19786a(float f, float f2, float f3, float f4) {
        return Math.abs(this.f15717l - f) < ((float) this.f15716k) && Math.abs(this.f15718m - f2) < ((float) this.f15716k) && Math.abs(this.f15719n - f3) < ((float) this.f15716k) && Math.abs(this.f15720o - f4) < ((float) this.f15716k);
    }

    /* renamed from: e */
    private final void m19787e() {
        if (this.f15706a instanceof Activity) {
            Builder builder;
            Object obj = this.f15707b;
            if (!TextUtils.isEmpty(obj)) {
                Uri build = new Uri.Builder().encodedQuery(obj.replaceAll("\\+", "%20")).build();
                StringBuilder stringBuilder = new StringBuilder();
                ax.e();
                Map a = jw.m19693a(build);
                for (String str : a.keySet()) {
                    stringBuilder.append(str);
                    stringBuilder.append(" = ");
                    stringBuilder.append((String) a.get(str));
                    stringBuilder.append("\n\n");
                }
                obj = stringBuilder.toString().trim();
                if (!TextUtils.isEmpty(obj)) {
                    builder = new Builder(this.f15706a);
                    builder.setMessage(obj);
                    builder.setTitle("Ad Information");
                    builder.setPositiveButton("Share", new kt(this, obj));
                    builder.setNegativeButton("Close", ku.f15730a);
                    builder.create().show();
                    return;
                }
            }
            obj = "No debug information";
            builder = new Builder(this.f15706a);
            builder.setMessage(obj);
            builder.setTitle("Ad Information");
            builder.setPositiveButton("Share", new kt(this, obj));
            builder.setNegativeButton("Close", ku.f15730a);
            builder.create().show();
            return;
        }
        mt.m19922d("Can not create dialog without Activity Context");
    }

    /* renamed from: a */
    public final void m19788a() {
        String str;
        try {
            if (!((Boolean) aph.m18688f().m18889a(asp.cP)).booleanValue()) {
                if (!((Boolean) aph.m18688f().m18889a(asp.cO)).booleanValue()) {
                    m19787e();
                    return;
                }
            }
            if (this.f15706a instanceof Activity) {
                String str2 = !TextUtils.isEmpty(ax.o().m19806a()) ? "Creative Preview (Enabled)" : "Creative Preview";
                str = ax.o().m19810b() ? "Troubleshooting (Enabled)" : "Troubleshooting";
                List arrayList = new ArrayList();
                int a = m19784a(arrayList, "Ad Information", true);
                int a2 = m19784a(arrayList, str2, ((Boolean) aph.m18688f().m18889a(asp.cO)).booleanValue());
                int a3 = m19784a(arrayList, str, ((Boolean) aph.m18688f().m18889a(asp.cP)).booleanValue());
                Builder builder = new Builder(this.f15706a, ax.g().mo6659f());
                builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new ks(this, a, a2, a3));
                builder.create().show();
                return;
            }
            mt.m19922d("Can not create dialog without Activity Context");
        } catch (Throwable e) {
            str = "";
            if (jn.m30865a()) {
                Log.v("Ads", str, e);
            }
        }
    }

    /* renamed from: a */
    final /* synthetic */ void m19789a(int i, int i2, int i3, DialogInterface dialogInterface, int i4) {
        if (i4 == i) {
            m19787e();
            return;
        }
        if (i4 == i2) {
            if (((Boolean) aph.m18688f().m18889a(asp.cO)).booleanValue()) {
                mt.m19918b("Debug mode [Creative Preview] selected.");
                ju.m19678a(new kv(this));
                return;
            }
        }
        if (i4 == i3) {
            if (((Boolean) aph.m18688f().m18889a(asp.cP)).booleanValue()) {
                mt.m19918b("Debug mode [Troubleshooting] selected.");
                ju.m19678a(new kw(this));
            }
        }
    }

    /* renamed from: a */
    public final void m19790a(MotionEvent motionEvent) {
        int actionMasked;
        int historySize;
        if (((Boolean) aph.m18688f().m18889a(asp.cQ)).booleanValue()) {
            actionMasked = motionEvent.getActionMasked();
            historySize = motionEvent.getHistorySize();
            int pointerCount = motionEvent.getPointerCount();
            if (actionMasked == 0) {
                this.f15715j = 0;
                this.f15717l = motionEvent.getX();
                this.f15718m = motionEvent.getY();
                return;
            }
            if (this.f15715j != -1) {
                int i = 1;
                if (this.f15715j == 0 && actionMasked == 5) {
                    this.f15715j = 5;
                    this.f15719n = motionEvent.getX(1);
                    this.f15720o = motionEvent.getY(1);
                    this.f15721p.postDelayed(this.f15722q, ((Long) aph.m18688f().m18889a(asp.cR)).longValue());
                    return;
                } else if (this.f15715j == 5) {
                    if (pointerCount == 2) {
                        if (actionMasked == 2) {
                            pointerCount = 0;
                            for (actionMasked = 0; actionMasked < historySize; actionMasked++) {
                                if (!m19786a(motionEvent.getHistoricalX(0, actionMasked), motionEvent.getHistoricalY(0, actionMasked), motionEvent.getHistoricalX(1, actionMasked), motionEvent.getHistoricalY(1, actionMasked))) {
                                    pointerCount = 1;
                                }
                            }
                            if (m19786a(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                                i = pointerCount;
                            }
                        } else {
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        this.f15715j = -1;
                        this.f15721p.removeCallbacks(this.f15722q);
                    }
                }
            }
            return;
        }
        actionMasked = motionEvent.getHistorySize();
        for (historySize = 0; historySize < actionMasked; historySize++) {
            m19785a(motionEvent.getActionMasked(), motionEvent.getHistoricalX(0, historySize), motionEvent.getHistoricalY(0, historySize));
        }
        m19785a(motionEvent.getActionMasked(), motionEvent.getX(), motionEvent.getY());
    }

    /* renamed from: a */
    public final void m19791a(String str) {
        this.f15708c = str;
    }

    /* renamed from: a */
    final /* synthetic */ void m19792a(String str, DialogInterface dialogInterface, int i) {
        ax.e();
        jw.m19696a(this.f15706a, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* renamed from: b */
    final /* synthetic */ void m19793b() {
        ax.o().m19808a(this.f15706a, this.f15708c, this.f15709d, this.f15710e);
    }

    /* renamed from: b */
    public final void m19794b(String str) {
        this.f15709d = str;
    }

    /* renamed from: c */
    final /* synthetic */ void m19795c() {
        ax.o().m19807a(this.f15706a, this.f15708c, this.f15709d);
    }

    /* renamed from: c */
    public final void m19796c(String str) {
        this.f15707b = str;
    }

    /* renamed from: d */
    final /* synthetic */ void m19797d() {
        this.f15715j = 4;
        m19788a();
    }

    /* renamed from: d */
    public final void m19798d(String str) {
        this.f15710e = str;
    }
}
