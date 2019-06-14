package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.internal.C2843c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@cm
public final class oz extends FrameLayout implements ow {
    /* renamed from: a */
    private final pn f24199a;
    /* renamed from: b */
    private final FrameLayout f24200b;
    /* renamed from: c */
    private final atc f24201c;
    /* renamed from: d */
    private final pp f24202d;
    /* renamed from: e */
    private final long f24203e;
    /* renamed from: f */
    private ox f24204f;
    /* renamed from: g */
    private boolean f24205g;
    /* renamed from: h */
    private boolean f24206h;
    /* renamed from: i */
    private boolean f24207i;
    /* renamed from: j */
    private boolean f24208j;
    /* renamed from: k */
    private long f24209k;
    /* renamed from: l */
    private long f24210l;
    /* renamed from: m */
    private String f24211m;
    /* renamed from: n */
    private Bitmap f24212n;
    /* renamed from: o */
    private ImageView f24213o;
    /* renamed from: p */
    private boolean f24214p;

    public oz(Context context, pn pnVar, int i, boolean z, atc atc, pm pmVar) {
        Context context2 = context;
        super(context);
        pn pnVar2 = pnVar;
        this.f24199a = pnVar2;
        atc atc2 = atc;
        this.f24201c = atc2;
        this.f24200b = new FrameLayout(context);
        addView(this.f24200b, new LayoutParams(-1, -1));
        C2843c.a(pnVar.mo6129e());
        this.f24204f = pnVar.mo6129e().f6844b.mo4335a(context, pnVar2, i, z, atc2, pmVar);
        if (this.f24204f != null) {
            r0.f24200b.addView(r0.f24204f, new LayoutParams(-1, -1, 17));
            if (((Boolean) aph.m18688f().m18889a(asp.f14959w)).booleanValue()) {
                m30959m();
            }
        }
        r0.f24213o = new ImageView(context);
        r0.f24203e = ((Long) aph.m18688f().m18889a(asp.f14910A)).longValue();
        r0.f24208j = ((Boolean) aph.m18688f().m18889a(asp.f14961y)).booleanValue();
        if (r0.f24201c != null) {
            r0.f24201c.m18920a("spinner_used", r0.f24208j ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        r0.f24202d = new pp(this);
        if (r0.f24204f != null) {
            r0.f24204f.mo6115a((ow) this);
        }
        if (r0.f24204f == null) {
            mo4327a("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    /* renamed from: a */
    public static void m30934a(pn pnVar) {
        Map hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        pnVar.mo6650a("onVideoEvent", hashMap);
    }

    /* renamed from: a */
    public static void m30935a(pn pnVar, String str) {
        Map hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("error", str);
        pnVar.mo6650a("onVideoEvent", hashMap);
    }

    /* renamed from: a */
    public static void m30936a(pn pnVar, Map<String, List<Map<String, Object>>> map) {
        Map hashMap = new HashMap();
        hashMap.put("event", "decoderProps");
        hashMap.put("mimeTypes", map);
        pnVar.mo6650a("onVideoEvent", hashMap);
    }

    /* renamed from: a */
    private final void m30937a(String str, String... strArr) {
        Map hashMap = new HashMap();
        hashMap.put("event", str);
        Object obj = null;
        for (Object obj2 : strArr) {
            if (obj == null) {
                obj = obj2;
            } else {
                hashMap.put(obj, obj2);
                obj = null;
            }
        }
        this.f24199a.mo6650a("onVideoEvent", hashMap);
    }

    /* renamed from: p */
    private final boolean m30938p() {
        return this.f24213o.getParent() != null;
    }

    /* renamed from: q */
    private final void m30939q() {
        if (!(this.f24199a.mo6128d() == null || !this.f24206h || this.f24207i)) {
            this.f24199a.mo6128d().getWindow().clearFlags(128);
            this.f24206h = false;
        }
    }

    /* renamed from: a */
    public final void mo4325a() {
        this.f24202d.m20017b();
        jw.f15691a.post(new pb(this));
    }

    /* renamed from: a */
    public final void m30941a(float f, float f2) {
        if (this.f24204f != null) {
            this.f24204f.mo6113a(f, f2);
        }
    }

    /* renamed from: a */
    public final void m30942a(int i) {
        if (this.f24204f != null) {
            this.f24204f.mo6114a(i);
        }
    }

    /* renamed from: a */
    public final void mo4326a(int i, int i2) {
        if (this.f24208j) {
            i = Math.max(i / ((Integer) aph.m18688f().m18889a(asp.f14962z)).intValue(), 1);
            i2 = Math.max(i2 / ((Integer) aph.m18688f().m18889a(asp.f14962z)).intValue(), 1);
            if (this.f24212n == null || this.f24212n.getWidth() != i || this.f24212n.getHeight() != i2) {
                this.f24212n = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f24214p = false;
            }
        }
    }

    /* renamed from: a */
    public final void m30944a(int i, int i2, int i3, int i4) {
        if (i3 == 0) {
            return;
        }
        if (i4 != 0) {
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.f24200b.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    @TargetApi(14)
    /* renamed from: a */
    public final void m30945a(MotionEvent motionEvent) {
        if (this.f24204f != null) {
            this.f24204f.dispatchTouchEvent(motionEvent);
        }
    }

    /* renamed from: a */
    public final void m30946a(String str) {
        this.f24211m = str;
    }

    /* renamed from: a */
    public final void mo4327a(String str, String str2) {
        m30937a("error", "what", str, "extra", str2);
    }

    /* renamed from: b */
    public final void mo4328b() {
        if (this.f24204f != null && this.f24210l == 0) {
            float duration = ((float) this.f24204f.getDuration()) / 1000.0f;
            int videoWidth = this.f24204f.getVideoWidth();
            int videoHeight = this.f24204f.getVideoHeight();
            m30937a("canplaythrough", "duration", String.valueOf(duration), "videoWidth", String.valueOf(videoWidth), "videoHeight", String.valueOf(videoHeight));
        }
    }

    /* renamed from: c */
    public final void mo4329c() {
        if (!(this.f24199a.mo6128d() == null || this.f24206h)) {
            this.f24207i = (this.f24199a.mo6128d().getWindow().getAttributes().flags & 128) != 0;
            if (!this.f24207i) {
                this.f24199a.mo6128d().getWindow().addFlags(128);
                this.f24206h = true;
            }
        }
        this.f24205g = true;
    }

    /* renamed from: d */
    public final void mo4330d() {
        m30937a("pause", new String[0]);
        m30939q();
        this.f24205g = false;
    }

    /* renamed from: e */
    public final void mo4331e() {
        m30937a("ended", new String[0]);
        m30939q();
    }

    /* renamed from: f */
    public final void mo4332f() {
        if (!(!this.f24214p || this.f24212n == null || m30938p())) {
            this.f24213o.setImageBitmap(this.f24212n);
            this.f24213o.invalidate();
            this.f24200b.addView(this.f24213o, new LayoutParams(-1, -1));
            this.f24200b.bringChildToFront(this.f24213o);
        }
        this.f24202d.m20016a();
        this.f24210l = this.f24209k;
        jw.f15691a.post(new pc(this));
    }

    public final void finalize() {
        try {
            this.f24202d.m20016a();
            if (this.f24204f != null) {
                ox oxVar = this.f24204f;
                Executor executor = nu.f15846a;
                oxVar.getClass();
                executor.execute(pa.m19992a(oxVar));
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    /* renamed from: g */
    public final void mo4333g() {
        if (this.f24205g && m30938p()) {
            this.f24200b.removeView(this.f24213o);
        }
        if (this.f24212n != null) {
            long b = ax.l().b();
            if (this.f24204f.getBitmap(this.f24212n) != null) {
                this.f24214p = true;
            }
            long b2 = ax.l().b() - b;
            if (jn.m30865a()) {
                StringBuilder stringBuilder = new StringBuilder(46);
                stringBuilder.append("Spinner frame grab took ");
                stringBuilder.append(b2);
                stringBuilder.append("ms");
                jn.m30864a(stringBuilder.toString());
            }
            if (b2 > this.f24203e) {
                mt.m19924e("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.f24208j = false;
                this.f24212n = null;
                if (this.f24201c != null) {
                    this.f24201c.m18920a("spinner_jank", Long.toString(b2));
                }
            }
        }
    }

    /* renamed from: h */
    public final void m30954h() {
        if (this.f24204f != null) {
            if (TextUtils.isEmpty(this.f24211m)) {
                m30937a("no_src", new String[0]);
            } else {
                this.f24204f.setVideoPath(this.f24211m);
            }
        }
    }

    /* renamed from: i */
    public final void m30955i() {
        if (this.f24204f != null) {
            this.f24204f.mo6118d();
        }
    }

    /* renamed from: j */
    public final void m30956j() {
        if (this.f24204f != null) {
            this.f24204f.mo6117c();
        }
    }

    /* renamed from: k */
    public final void m30957k() {
        if (this.f24204f != null) {
            ox oxVar = this.f24204f;
            oxVar.f24198b.m20021a(true);
            oxVar.mo4324e();
        }
    }

    /* renamed from: l */
    public final void m30958l() {
        if (this.f24204f != null) {
            ox oxVar = this.f24204f;
            oxVar.f24198b.m20021a(false);
            oxVar.mo4324e();
        }
    }

    @TargetApi(14)
    /* renamed from: m */
    public final void m30959m() {
        if (this.f24204f != null) {
            View textView = new TextView(this.f24204f.getContext());
            String str = "AdMob - ";
            String valueOf = String.valueOf(this.f24204f.mo6112a());
            textView.setText(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            textView.setTextColor(-65536);
            textView.setBackgroundColor(-256);
            this.f24200b.addView(textView, new LayoutParams(-2, -2, 17));
            this.f24200b.bringChildToFront(textView);
        }
    }

    /* renamed from: n */
    public final void m30960n() {
        this.f24202d.m20016a();
        if (this.f24204f != null) {
            this.f24204f.mo6116b();
        }
        m30939q();
    }

    /* renamed from: o */
    final void m30961o() {
        if (this.f24204f != null) {
            long currentPosition = (long) this.f24204f.getCurrentPosition();
            if (this.f24209k != currentPosition && currentPosition > 0) {
                float f = ((float) currentPosition) / 1000.0f;
                m30937a("timeupdate", "time", String.valueOf(f));
                this.f24209k = currentPosition;
            }
        }
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        if (i == 0) {
            this.f24202d.m20017b();
            z = true;
        } else {
            this.f24202d.m20016a();
            this.f24210l = this.f24209k;
            z = false;
        }
        jw.f15691a.post(new pd(this, z));
    }

    public final void setVolume(float f) {
        if (this.f24204f != null) {
            ox oxVar = this.f24204f;
            oxVar.f24198b.m20020a(f);
            oxVar.mo4324e();
        }
    }
}
