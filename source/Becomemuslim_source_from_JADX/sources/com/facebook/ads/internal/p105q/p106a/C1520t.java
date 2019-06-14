package com.facebook.ads.internal.p105q.p106a;

import android.os.Build.VERSION;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.MotionEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.q.a.t */
public class C1520t {
    /* renamed from: a */
    private static final String f4483a = "t";
    /* renamed from: b */
    private boolean f4484b;
    /* renamed from: c */
    private int f4485c = -1;
    /* renamed from: d */
    private int f4486d = -1;
    /* renamed from: e */
    private int f4487e = -1;
    /* renamed from: f */
    private int f4488f = -1;
    /* renamed from: g */
    private long f4489g = -1;
    /* renamed from: h */
    private int f4490h = -1;
    /* renamed from: i */
    private long f4491i = -1;
    /* renamed from: j */
    private long f4492j = -1;
    /* renamed from: k */
    private int f4493k = -1;
    /* renamed from: l */
    private int f4494l = -1;
    /* renamed from: m */
    private int f4495m = -1;
    /* renamed from: n */
    private int f4496n = -1;
    /* renamed from: o */
    private float f4497o = -1.0f;
    /* renamed from: p */
    private float f4498p = -1.0f;
    /* renamed from: q */
    private float f4499q = -1.0f;
    /* renamed from: r */
    private View f4500r;
    /* renamed from: s */
    private View f4501s;

    /* renamed from: f */
    private C1507j m5329f() {
        if (this.f4500r != null) {
            if (this.f4501s != null) {
                if (this.f4500r != this.f4501s) {
                    return C1507j.INTERNAL_NO_CLICK;
                }
                if (VERSION.SDK_INT < 4) {
                    return C1507j.INTERNAL_API_TOO_LOW;
                }
                Object tag = this.f4500r.getTag(C1507j.f4462o);
                return tag == null ? C1507j.INTERNAL_NO_TAG : !(tag instanceof C1507j) ? C1507j.INTERNAL_WRONG_TAG_CLASS : (C1507j) tag;
            }
        }
        return C1507j.INTERNAL_NULL_VIEW;
    }

    /* renamed from: a */
    public void m5330a() {
        this.f4489g = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m5331a(MotionEvent motionEvent, View view, View view2) {
        if (!this.f4484b) {
            this.f4484b = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                MotionRange motionRange = device.getMotionRange(0);
                MotionRange motionRange2 = device.getMotionRange(1);
                if (!(motionRange == null || motionRange2 == null)) {
                    this.f4499q = Math.min(motionRange.getRange(), motionRange2.getRange());
                }
            }
            if (this.f4499q <= 0.0f) {
                this.f4499q = (float) Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        switch (motionEvent.getAction()) {
            case 0:
                this.f4485c = (int) (((float) iArr[0]) / C1523w.f4503b);
                this.f4486d = (int) (((float) iArr[1]) / C1523w.f4503b);
                this.f4487e = (int) (((float) view.getWidth()) / C1523w.f4503b);
                this.f4488f = (int) (((float) view.getHeight()) / C1523w.f4503b);
                this.f4490h = 1;
                this.f4491i = System.currentTimeMillis();
                this.f4493k = (int) (((float) ((((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0])) / C1523w.f4503b);
                this.f4494l = (int) (((float) ((((int) (motionEvent.getY() + 0.5f)) + iArr2[1]) - iArr[1])) / C1523w.f4503b);
                this.f4497o = motionEvent.getPressure();
                this.f4498p = motionEvent.getSize();
                this.f4500r = view2;
                return;
            case 1:
            case 3:
                this.f4492j = System.currentTimeMillis();
                this.f4495m = (int) (((float) ((((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0])) / C1523w.f4503b);
                this.f4496n = (int) (((float) ((((int) (motionEvent.getY() + 0.5f)) + iArr2[1]) - iArr[1])) / C1523w.f4503b);
                this.f4501s = view2;
                return;
            case 2:
                this.f4497o -= this.f4497o / ((float) this.f4490h);
                this.f4497o += motionEvent.getPressure() / ((float) this.f4490h);
                this.f4498p -= this.f4498p / ((float) this.f4490h);
                this.f4498p += motionEvent.getSize() / ((float) this.f4490h);
                this.f4490h++;
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public boolean m5332b() {
        return this.f4489g != -1;
    }

    /* renamed from: c */
    public long m5333c() {
        return m5332b() ? System.currentTimeMillis() - this.f4489g : -1;
    }

    /* renamed from: d */
    public boolean m5334d() {
        return this.f4484b;
    }

    /* renamed from: e */
    public Map<String, String> m5335e() {
        if (!this.f4484b) {
            return null;
        }
        String valueOf = String.valueOf((this.f4498p * this.f4499q) / 2.0f);
        long j = (this.f4489g <= 0 || this.f4492j <= this.f4489g) ? -1 : this.f4492j - this.f4489g;
        Map<String, String> hashMap = new HashMap();
        hashMap.put("adPositionX", String.valueOf(this.f4485c));
        hashMap.put("adPositionY", String.valueOf(this.f4486d));
        hashMap.put("width", String.valueOf(this.f4487e));
        hashMap.put("height", String.valueOf(this.f4488f));
        hashMap.put("clickDelayTime", String.valueOf(j));
        hashMap.put("startTime", String.valueOf(this.f4491i));
        hashMap.put("endTime", String.valueOf(this.f4492j));
        hashMap.put("startX", String.valueOf(this.f4493k));
        hashMap.put("startY", String.valueOf(this.f4494l));
        hashMap.put("clickX", String.valueOf(this.f4495m));
        hashMap.put("clickY", String.valueOf(this.f4496n));
        hashMap.put("endX", String.valueOf(this.f4495m));
        hashMap.put("endY", String.valueOf(this.f4496n));
        hashMap.put("force", String.valueOf(this.f4497o));
        hashMap.put("radiusX", valueOf);
        hashMap.put("radiusY", valueOf);
        hashMap.put("clickedViewTag", String.valueOf(m5329f().m5305a()));
        return hashMap;
    }
}
