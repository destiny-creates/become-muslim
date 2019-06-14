package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1507j;
import com.facebook.ads.internal.view.C1667k;
import com.facebook.ads.internal.view.C4630j;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3649c;
import com.facebook.ads.internal.view.p120f.p122b.C3650d;
import com.facebook.ads.internal.view.p120f.p122b.C3651e;
import com.facebook.ads.internal.view.p120f.p122b.C3654h;
import com.facebook.ads.internal.view.p120f.p122b.C3655i;
import com.facebook.ads.internal.view.p120f.p122b.C3656j;
import com.facebook.ads.internal.view.p120f.p122b.C3657k;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p122b.C3659m;
import com.facebook.ads.internal.view.p120f.p122b.C3662p;
import com.facebook.ads.internal.view.p120f.p122b.C3663q;
import com.facebook.ads.internal.view.p120f.p122b.C3668v;
import com.facebook.ads.internal.view.p120f.p122b.C3669w;
import com.facebook.ads.internal.view.p120f.p124d.C1658d;

public abstract class MediaViewVideoRenderer extends FrameLayout {
    /* renamed from: d */
    private static final String f3678d = "MediaViewVideoRenderer";
    /* renamed from: a */
    protected NativeAd f3679a;
    /* renamed from: b */
    protected VideoAutoplayBehavior f3680b;
    /* renamed from: c */
    final C4630j f3681c;
    /* renamed from: e */
    private final C3659m f3682e = new C45481(this);
    /* renamed from: f */
    private final C3657k f3683f = new C45492(this);
    /* renamed from: g */
    private final C3655i f3684g = new C45503(this);
    /* renamed from: h */
    private final C3663q f3685h = new C45514(this);
    /* renamed from: i */
    private final C3649c f3686i = new C45525(this);
    /* renamed from: j */
    private final C3669w f3687j = new C45536(this);
    /* renamed from: k */
    private final C3651e f3688k = new C45547(this);
    /* renamed from: l */
    private boolean f3689l;
    /* renamed from: m */
    private boolean f3690m;

    /* renamed from: com.facebook.ads.MediaViewVideoRenderer$1 */
    class C45481 extends C3659m {
        /* renamed from: a */
        final /* synthetic */ MediaViewVideoRenderer f12276a;

        C45481(MediaViewVideoRenderer mediaViewVideoRenderer) {
            this.f12276a = mediaViewVideoRenderer;
        }

        /* renamed from: a */
        public void m15461a(C3658l c3658l) {
            this.f12276a.onPrepared();
        }
    }

    /* renamed from: com.facebook.ads.MediaViewVideoRenderer$2 */
    class C45492 extends C3657k {
        /* renamed from: a */
        final /* synthetic */ MediaViewVideoRenderer f12277a;

        C45492(MediaViewVideoRenderer mediaViewVideoRenderer) {
            this.f12277a = mediaViewVideoRenderer;
        }

        /* renamed from: a */
        public void m15463a(C3656j c3656j) {
            if (this.f12277a.f3679a != null) {
                this.f12277a.f3679a.m11395g().m4992a(true, true);
            }
            this.f12277a.onPlayed();
        }
    }

    /* renamed from: com.facebook.ads.MediaViewVideoRenderer$3 */
    class C45503 extends C3655i {
        /* renamed from: a */
        final /* synthetic */ MediaViewVideoRenderer f12278a;

        C45503(MediaViewVideoRenderer mediaViewVideoRenderer) {
            this.f12278a = mediaViewVideoRenderer;
        }

        /* renamed from: a */
        public void m15465a(C3654h c3654h) {
            this.f12278a.onPaused();
        }
    }

    /* renamed from: com.facebook.ads.MediaViewVideoRenderer$4 */
    class C45514 extends C3663q {
        /* renamed from: a */
        final /* synthetic */ MediaViewVideoRenderer f12279a;

        C45514(MediaViewVideoRenderer mediaViewVideoRenderer) {
            this.f12279a = mediaViewVideoRenderer;
        }

        /* renamed from: a */
        public void m15467a(C3662p c3662p) {
            this.f12279a.onSeek();
        }
    }

    /* renamed from: com.facebook.ads.MediaViewVideoRenderer$5 */
    class C45525 extends C3649c {
        /* renamed from: a */
        final /* synthetic */ MediaViewVideoRenderer f12280a;

        C45525(MediaViewVideoRenderer mediaViewVideoRenderer) {
            this.f12280a = mediaViewVideoRenderer;
        }

        /* renamed from: a */
        public void m15469a(C3648b c3648b) {
            this.f12280a.onCompleted();
        }
    }

    /* renamed from: com.facebook.ads.MediaViewVideoRenderer$6 */
    class C45536 extends C3669w {
        /* renamed from: a */
        final /* synthetic */ MediaViewVideoRenderer f12281a;

        C45536(MediaViewVideoRenderer mediaViewVideoRenderer) {
            this.f12281a = mediaViewVideoRenderer;
        }

        /* renamed from: a */
        public void m15471a(C3668v c3668v) {
            this.f12281a.onVolumeChanged();
        }
    }

    /* renamed from: com.facebook.ads.MediaViewVideoRenderer$7 */
    class C45547 extends C3651e {
        /* renamed from: a */
        final /* synthetic */ MediaViewVideoRenderer f12282a;

        C45547(MediaViewVideoRenderer mediaViewVideoRenderer) {
            this.f12282a = mediaViewVideoRenderer;
        }

        /* renamed from: a */
        public void m15473a(C3650d c3650d) {
            if (this.f12282a.f3679a != null) {
                this.f12282a.f3679a.m11395g().m4992a(false, true);
            }
            this.f12282a.onError();
        }
    }

    public MediaViewVideoRenderer(Context context) {
        super(context);
        this.f3681c = new C4630j(context);
        m4413b();
    }

    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3681c = new C4630j(context, attributeSet);
        m4413b();
    }

    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3681c = new C4630j(context, attributeSet, i);
        m4413b();
    }

    @TargetApi(21)
    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3681c = new C4630j(context, attributeSet, i, i2);
        m4413b();
    }

    /* renamed from: b */
    private void m4413b() {
        this.f3681c.setEnableBackgroundVideo(shouldAllowBackgroundPlayback());
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.f3681c.setLayoutParams(layoutParams);
        super.addView(this.f3681c, -1, layoutParams);
        C1507j.m5304a(this.f3681c, C1507j.INTERNAL_AD_MEDIA);
        this.f3681c.getEventBus().m4804a(this.f3682e, this.f3683f, this.f3684g, this.f3685h, this.f3686i, this.f3687j, this.f3688k);
    }

    /* renamed from: a */
    protected void mo857a() {
        pause(false);
        this.f3681c.m15969a(null, null);
        this.f3681c.setVideoMPD(null);
        this.f3681c.setVideoURI((Uri) null);
        this.f3681c.setVideoCTA(null);
        this.f3681c.setNativeAd(null);
        this.f3680b = VideoAutoplayBehavior.DEFAULT;
        if (this.f3679a != null) {
            this.f3679a.m11395g().m4992a(false, false);
        }
        this.f3679a = null;
    }

    public void addView(View view) {
    }

    public void addView(View view, int i) {
    }

    public void addView(View view, int i, int i2) {
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
    }

    public void addView(View view, LayoutParams layoutParams) {
    }

    public void destroy() {
        this.f3681c.m11926k();
    }

    public final void disengageSeek(VideoStartReason videoStartReason) {
        if (this.f3689l) {
            this.f3689l = false;
            if (this.f3690m) {
                this.f3681c.m11914a(videoStartReason.m4432a());
            }
            onSeekDisengaged();
            return;
        }
        Log.w(f3678d, "disengageSeek called without engageSeek.");
    }

    public final void engageSeek() {
        if (this.f3689l) {
            Log.w(f3678d, "engageSeek called without disengageSeek.");
            return;
        }
        this.f3689l = true;
        this.f3690m = C1658d.STARTED.equals(this.f3681c.getState());
        this.f3681c.m11917a(false);
        onSeekEngaged();
    }

    public final int getCurrentTimeMs() {
        return this.f3681c.getCurrentPositionInMillis();
    }

    public final int getDuration() {
        return this.f3681c.getDuration();
    }

    final View getVideoView() {
        return this.f3681c.getVideoView();
    }

    public final float getVolume() {
        return this.f3681c.getVolume();
    }

    public void onCompleted() {
    }

    public void onError() {
    }

    public void onPaused() {
    }

    public void onPlayed() {
    }

    public void onPrepared() {
    }

    public void onSeek() {
    }

    public void onSeekDisengaged() {
    }

    public void onSeekEngaged() {
    }

    public void onVolumeChanged() {
    }

    public final void pause(boolean z) {
        this.f3681c.m11917a(z);
    }

    public final void play(VideoStartReason videoStartReason) {
        this.f3681c.m11914a(videoStartReason.m4432a());
    }

    public final void seekTo(int i) {
        if (this.f3689l) {
            this.f3681c.m11912a(i);
        } else {
            Log.w(f3678d, "Seeking must be preceded by a call to engageSeek, and followed by a call to disengageSeek.");
        }
    }

    final void setAdEventManager(C1412c c1412c) {
        this.f3681c.setAdEventManager(c1412c);
    }

    final void setListener(C1667k c1667k) {
        this.f3681c.setListener(c1667k);
    }

    protected void setNativeAd(NativeAd nativeAd) {
        this.f3679a = nativeAd;
        this.f3681c.m15969a(nativeAd.m15477c(), nativeAd.m11397i());
        this.f3681c.setVideoMPD(nativeAd.m15476b());
        this.f3681c.setVideoURI(nativeAd.m15474a());
        this.f3681c.setVideoProgressReportIntervalMs(nativeAd.m11396h().mo2819D());
        this.f3681c.setVideoCTA(nativeAd.getAdCallToAction());
        this.f3681c.setNativeAd(nativeAd);
        this.f3680b = nativeAd.m15478d();
    }

    public final void setVolume(float f) {
        this.f3681c.setVolume(f);
    }

    public boolean shouldAllowBackgroundPlayback() {
        return false;
    }

    public final boolean shouldAutoplay() {
        return this.f3681c != null ? this.f3681c.getState() == C1658d.PLAYBACK_COMPLETED ? false : this.f3680b == VideoAutoplayBehavior.ON : false;
    }
}
