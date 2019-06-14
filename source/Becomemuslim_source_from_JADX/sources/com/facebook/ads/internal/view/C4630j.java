package com.facebook.ads.internal.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.adapters.ae;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.settings.C1550a.C1549a;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.C4584b;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import java.util.UUID;

/* renamed from: com.facebook.ads.internal.view.j */
public class C4630j extends C3640a {
    /* renamed from: b */
    private final String f12614b = UUID.randomUUID().toString();
    /* renamed from: c */
    private final C3657k f12615c = new C46271(this);
    /* renamed from: d */
    private final C3655i f12616d = new C46282(this);
    /* renamed from: e */
    private final C3649c f12617e = new C46293(this);
    /* renamed from: f */
    private final ae f12618f;
    /* renamed from: g */
    private C1412c f12619g;
    /* renamed from: h */
    private C4584b f12620h;
    /* renamed from: i */
    private String f12621i;
    /* renamed from: j */
    private Uri f12622j;
    /* renamed from: k */
    private String f12623k;
    /* renamed from: l */
    private String f12624l;
    /* renamed from: m */
    private String f12625m;
    /* renamed from: n */
    private C1667k f12626n;
    /* renamed from: o */
    private NativeAd f12627o;

    /* renamed from: com.facebook.ads.internal.view.j$1 */
    class C46271 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ C4630j f12611a;

        C46271(C4630j c4630j) {
            this.f12611a = c4630j;
        }

        /* renamed from: a */
        public void m15960a(C3656j c3656j) {
            if (this.f12611a.f12626n != null) {
                this.f12611a.f12626n.mo872c();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.j$2 */
    class C46282 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ C4630j f12612a;

        C46282(C4630j c4630j) {
            this.f12612a = c4630j;
        }

        /* renamed from: a */
        public void m15962a(C3654h c3654h) {
            if (this.f12612a.f12626n != null) {
                this.f12612a.f12626n.mo871b();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.view.j$3 */
    class C46293 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ C4630j f12613a;

        C46293(C4630j c4630j) {
            this.f12613a = c4630j;
        }

        /* renamed from: a */
        public void m15964a(C3648b c3648b) {
            if (this.f12613a.f12626n != null) {
                this.f12613a.f12626n.mo877h();
            }
        }
    }

    public C4630j(Context context) {
        super(context);
        this.f12618f = new ae(this, context);
        m15967t();
    }

    public C4630j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12618f = new ae(this, context);
        m15967t();
    }

    public C4630j(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12618f = new ae(this, context);
        m15967t();
    }

    @TargetApi(21)
    public C4630j(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f12618f = new ae(this, context);
        m15967t();
    }

    /* renamed from: a */
    private void m15966a(Intent intent) {
        if (this.f12621i == null || this.f12620h == null) {
            throw new IllegalStateException("Must setVideoReportUri first.");
        }
        if (this.f12622j == null) {
            if (this.f12624l == null) {
                throw new IllegalStateException("Must setVideoURI or setVideoMPD first.");
            }
        }
        intent.putExtra("useNativeCtaButton", this.f12625m);
        intent.putExtra(AudienceNetworkActivity.VIEW_TYPE, C1549a.FULL_SCREEN_VIDEO);
        intent.putExtra(AudienceNetworkActivity.VIDEO_URL, this.f12622j.toString());
        intent.putExtra(AudienceNetworkActivity.CLIENT_TOKEN, this.f12623k == null ? "" : this.f12623k);
        intent.putExtra(AudienceNetworkActivity.VIDEO_MPD, this.f12624l);
        intent.putExtra(AudienceNetworkActivity.PREDEFINED_ORIENTATION_KEY, 13);
        intent.putExtra(AudienceNetworkActivity.VIDEO_SEEK_TIME, getCurrentPositionInMillis());
        intent.putExtra(AudienceNetworkActivity.AUDIENCE_NETWORK_UNIQUE_ID_EXTRA, this.f12614b);
        intent.putExtra(AudienceNetworkActivity.VIDEO_LOGGER, this.f12620h.mo937g());
        intent.putExtra("video_time_polling_interval", getVideoProgressReportIntervalMs());
        intent.addFlags(268435456);
    }

    /* renamed from: t */
    private void m15967t() {
        getEventBus().m4804a(this.f12615c, this.f12616d, this.f12617e);
    }

    /* renamed from: a */
    public void mo2891a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r3 = this;
        r0 = r3.getContext();
        r1 = new android.content.Intent;
        r2 = com.facebook.ads.AudienceNetworkActivity.class;
        r1.<init>(r0, r2);
        r3.m15966a(r1);
        r2 = 0;
        r3.m11917a(r2);	 Catch:{ ActivityNotFoundException -> 0x0026 }
        r2 = 8;	 Catch:{ ActivityNotFoundException -> 0x0026 }
        r3.setVisibility(r2);	 Catch:{ ActivityNotFoundException -> 0x0026 }
        r0.startActivity(r1);	 Catch:{ ActivityNotFoundException -> 0x0026 }
        goto L_0x002e;
    L_0x001b:
        r0 = move-exception;
        r1 = "Error occurred while loading fullscreen video activity.";
        r0 = com.facebook.ads.internal.p095j.C1397a.m4794a(r0, r1);
        com.facebook.ads.internal.p095j.C1398b.m4797a(r0);
        goto L_0x002e;
    L_0x0026:
        r2 = com.facebook.ads.InterstitialAdActivity.class;	 Catch:{ Exception -> 0x001b }
        r1.setClass(r0, r2);	 Catch:{ Exception -> 0x001b }
        r0.startActivity(r1);	 Catch:{ Exception -> 0x001b }
    L_0x002e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.j.a():void");
    }

    /* renamed from: a */
    public void m15969a(String str, String str2) {
        if (this.f12620h != null) {
            this.f12620h.mo2876a();
        }
        this.f12623k = str2;
        this.f12621i = str;
        C4584b c4584b = (str == null || str2 == null) ? null : new C4584b(getContext(), this.f12619g, this, str2);
        this.f12620h = c4584b;
    }

    /* renamed from: b */
    public void mo2892b() {
        if (this.f12627o != null) {
            this.f12627o.onCtaBroadcast();
        }
    }

    public C1667k getListener() {
        return this.f12626n;
    }

    public String getUniqueId() {
        return this.f12614b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12618f.m4589a();
    }

    protected void onDetachedFromWindow() {
        this.f12618f.m4590b();
        super.onDetachedFromWindow();
    }

    public void setAdEventManager(C1412c c1412c) {
        this.f12619g = c1412c;
    }

    public void setEnableBackgroundVideo(boolean z) {
        this.a.setBackgroundPlaybackEnabled(z);
    }

    public void setListener(C1667k c1667k) {
        this.f12626n = c1667k;
    }

    public void setNativeAd(NativeAd nativeAd) {
        this.f12627o = nativeAd;
    }

    public void setVideoCTA(String str) {
        this.f12625m = str;
    }

    public void setVideoMPD(String str) {
        if (str != null) {
            if (this.f12620h == null) {
                throw new IllegalStateException("Must setVideoReportUri first.");
            }
        }
        this.f12624l = str;
        super.setVideoMPD(str);
    }

    public void setVideoURI(Uri uri) {
        if (uri != null) {
            if (this.f12620h == null) {
                throw new IllegalStateException("Must setVideoReportUri first.");
            }
        }
        this.f12622j = uri;
        super.setVideoURI(uri);
    }
}
