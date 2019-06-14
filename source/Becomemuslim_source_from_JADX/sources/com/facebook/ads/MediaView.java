package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.C0689a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.adapters.C3554h;
import com.facebook.ads.internal.adapters.C3554h.C1330a;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p098m.C3580d;
import com.facebook.ads.internal.p099n.C1426g;
import com.facebook.ads.internal.p105q.p106a.C1507j;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.view.C1667k;
import com.facebook.ads.internal.view.hscroll.C4895b;
import com.facebook.ads.internal.view.p113b.C1574b;
import com.facebook.ads.internal.view.p113b.C1577d;
import com.facebook.ads.internal.view.p113b.C1578e;

public class MediaView extends C1426g {
    /* renamed from: a */
    private static final String f9391a = "MediaView";
    /* renamed from: b */
    private static final int f9392b = Color.argb(51, 145, 150, 165);
    /* renamed from: c */
    private C1574b f9393c;
    /* renamed from: d */
    private C4895b f9394d;
    /* renamed from: e */
    private MediaViewVideoRenderer f9395e;
    /* renamed from: f */
    private View f9396f;
    /* renamed from: g */
    private MediaViewListener f9397g;
    /* renamed from: h */
    private boolean f9398h;
    /* renamed from: i */
    private boolean f9399i;
    /* renamed from: j */
    private boolean f9400j;

    public MediaView(Context context) {
        super(context);
        setImageRenderer(new C1574b(context));
        setCarouselRenderer(new C4895b(context));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context));
        m11386a();
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setImageRenderer(new C1574b(context, attributeSet));
        setCarouselRenderer(new C4895b(context, attributeSet));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context, attributeSet));
        m11386a();
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setImageRenderer(new C1574b(context, attributeSet, i));
        setCarouselRenderer(new C4895b(context, attributeSet, i));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context, attributeSet, i));
        m11386a();
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setImageRenderer(new C1574b(context, attributeSet, i, i2));
        setCarouselRenderer(new C4895b(context, attributeSet, i));
        setVideoRenderer(new DefaultMediaViewVideoRenderer(context, attributeSet, i, i2));
        m11386a();
    }

    /* renamed from: a */
    private void m11386a() {
        C1523w.m5342a((View) this, f9392b);
        C1507j.m5304a(this, C1507j.INTERNAL_AD_MEDIA);
        C1507j.m5304a(this.f9393c, C1507j.INTERNAL_AD_MEDIA);
        C1507j.m5304a(this.f9395e, C1507j.INTERNAL_AD_MEDIA);
        C1507j.m5304a(this.f9394d, C1507j.INTERNAL_AD_MEDIA);
        this.f9399i = true;
    }

    /* renamed from: a */
    private boolean m11387a(NativeAd nativeAd) {
        return VERSION.SDK_INT >= 14 && !TextUtils.isEmpty(nativeAd.m15474a());
    }

    /* renamed from: b */
    private boolean m11388b(NativeAd nativeAd) {
        if (nativeAd.m15479e() == null) {
            return false;
        }
        for (NativeAd adCoverImage : nativeAd.m15479e()) {
            if (adCoverImage.getAdCoverImage() == null) {
                return false;
            }
        }
        return true;
    }

    private void setCarouselRenderer(C4895b c4895b) {
        if (this.f9398h) {
            throw new IllegalStateException("Carousel renderer must be set before nativeAd.");
        }
        if (this.f9394d != null) {
            removeView(this.f9394d);
        }
        float f = C1523w.f4503b;
        int round = Math.round(4.0f * f);
        int round2 = Math.round(f * 12.0f);
        c4895b.setChildSpacing(round);
        c4895b.setPadding(0, round2, 0, round2);
        c4895b.setVisibility(8);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView((View) c4895b, layoutParams);
        this.f9394d = c4895b;
    }

    private void setImageRenderer(C1574b c1574b) {
        if (this.f9398h) {
            throw new IllegalStateException("Image renderer must be set before nativeAd.");
        }
        if (this.f9393c != null) {
            removeView(this.f9393c);
        }
        c1574b.setVisibility(8);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView((View) c1574b, layoutParams);
        this.f9393c = c1574b;
    }

    /* renamed from: a */
    void m11389a(View view, LayoutParams layoutParams) {
        this.f9399i = false;
        addView(view, layoutParams);
        this.f9399i = true;
    }

    public void addView(View view) {
        if (!this.f9399i) {
            super.addView(view);
        }
    }

    public void addView(View view, int i) {
        if (!this.f9399i) {
            super.addView(view, i);
        }
    }

    public void addView(View view, int i, int i2) {
        if (!this.f9399i) {
            super.addView(view, i, i2);
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (!this.f9399i) {
            super.addView(view, i, layoutParams);
        }
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (!this.f9399i) {
            super.addView(view, layoutParams);
        }
    }

    public void bringChildToFront(View view) {
        if (view == this.f9394d || view == this.f9395e || view == this.f9393c) {
            super.bringChildToFront(view);
        }
    }

    public void destroy() {
        this.f9395e.pause(false);
        this.f9395e.destroy();
    }

    protected View getAdContentsView() {
        return this.f9396f;
    }

    protected C1412c getAdEventManager() {
        return C3580d.m11662a(getContext());
    }

    public void setListener(final MediaViewListener mediaViewListener) {
        this.f9397g = mediaViewListener;
        if (mediaViewListener == null) {
            this.f9395e.setListener(null);
        } else {
            this.f9395e.setListener(new C1667k(this) {
                /* renamed from: b */
                final /* synthetic */ MediaView f9390b;

                /* renamed from: a */
                public void mo870a() {
                    mediaViewListener.onVolumeChange(this.f9390b, this.f9390b.f9395e.getVolume());
                }

                /* renamed from: b */
                public void mo871b() {
                    mediaViewListener.onPause(this.f9390b);
                }

                /* renamed from: c */
                public void mo872c() {
                    mediaViewListener.onPlay(this.f9390b);
                }

                /* renamed from: d */
                public void mo873d() {
                    mediaViewListener.onFullscreenBackground(this.f9390b);
                }

                /* renamed from: e */
                public void mo874e() {
                    mediaViewListener.onFullscreenForeground(this.f9390b);
                }

                /* renamed from: f */
                public void mo875f() {
                    mediaViewListener.onExitFullscreen(this.f9390b);
                }

                /* renamed from: g */
                public void mo876g() {
                    mediaViewListener.onEnterFullscreen(this.f9390b);
                }

                /* renamed from: h */
                public void mo877h() {
                    mediaViewListener.onComplete(this.f9390b);
                }
            });
        }
    }

    void setNativeAd(final NativeAd nativeAd) {
        this.f9398h = true;
        nativeAd.m11392a(this);
        if (m11388b(nativeAd)) {
            this.f9396f = this.f9394d;
            this.f9393c.setVisibility(8);
            this.f9393c.m5490a(null, null);
            this.f9395e.setVisibility(8);
            this.f9395e.mo857a();
            bringChildToFront(this.f9394d);
            this.f9394d.setCurrentPosition(0);
            C0689a c3554h = new C3554h(this.f9394d, nativeAd.m11395g().m4976F());
            c3554h.m11522a(new C1330a(this) {
                /* renamed from: b */
                final /* synthetic */ MediaView f9386b;

                /* renamed from: a */
                public void mo869a() {
                    nativeAd.m11395g().m4992a(true, true);
                }
            });
            this.f9394d.setAdapter(c3554h);
            this.f9394d.setVisibility(0);
        } else if (m11387a(nativeAd)) {
            nativeAd.m11395g().m4994b(this.f9400j);
            this.f9396f = this.f9395e.getVideoView();
            this.f9393c.setVisibility(8);
            this.f9393c.m5490a(null, null);
            this.f9394d.setVisibility(8);
            this.f9394d.setAdapter(null);
            bringChildToFront(this.f9395e);
            this.f9395e.setNativeAd(nativeAd);
            this.f9395e.setVisibility(0);
        } else if (nativeAd.getAdCoverImage() != null) {
            this.f9396f = this.f9393c.getBodyImageView();
            this.f9395e.setVisibility(8);
            this.f9395e.mo857a();
            this.f9394d.setVisibility(8);
            this.f9394d.setAdapter(null);
            bringChildToFront(this.f9393c);
            this.f9393c.setVisibility(0);
            new C1577d(this.f9393c).m5505a(getHeight(), getWidth()).m5507a(C1405a.m4824e(getContext())).m5506a(new C1578e(this) {
                /* renamed from: b */
                final /* synthetic */ MediaView f9388b;

                /* renamed from: a */
                public void mo841a(boolean z) {
                    nativeAd.m11395g().m4992a(z, true);
                }
            }).m5508a(nativeAd.m11395g().m5005k().m5022a());
        }
    }

    public void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        if (this.f9398h) {
            throw new IllegalStateException("Video renderer must be set before nativeAd.");
        }
        if (this.f9395e != null) {
            removeView(this.f9395e);
            this.f9395e.destroy();
        }
        mediaViewVideoRenderer.setAdEventManager(getAdEventManager());
        mediaViewVideoRenderer.setVisibility(8);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        m11389a(mediaViewVideoRenderer, layoutParams);
        this.f9395e = mediaViewVideoRenderer;
        this.f9400j = !(this.f9395e instanceof DefaultMediaViewVideoRenderer);
    }
}
