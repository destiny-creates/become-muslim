package com.facebook.ads.internal.view.p120f.p124d;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.google.android.exoplayer2.C2330e;
import com.google.android.exoplayer2.C2368g;
import com.google.android.exoplayer2.C2573r;
import com.google.android.exoplayer2.C2589y;
import com.google.android.exoplayer2.C4089c;
import com.google.android.exoplayer2.C4159f.C4155a;
import com.google.android.exoplayer2.C4734x;
import com.google.android.exoplayer2.C4734x.C2586b;
import com.google.android.exoplayer2.p137e.C4106c;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p149h.C4217g;
import com.google.android.exoplayer2.p162j.C2485g;
import com.google.android.exoplayer2.p162j.C4729a.C4235a;
import com.google.android.exoplayer2.p162j.C4730c;
import com.google.android.exoplayer2.p163k.C2514v;
import com.google.android.exoplayer2.p163k.C4242l;
import com.google.android.exoplayer2.p163k.C4244n;
import com.google.android.exoplayer2.p164l.C2541v;

@TargetApi(14)
/* renamed from: com.facebook.ads.internal.view.f.d.a */
public class C4618a extends TextureView implements SurfaceTextureListener, C1657c, C4155a, C2586b {
    /* renamed from: a */
    private static final String f12545a = "a";
    /* renamed from: b */
    private Uri f12546b;
    /* renamed from: c */
    private String f12547c;
    /* renamed from: d */
    private C1659e f12548d;
    /* renamed from: e */
    private Surface f12549e;
    /* renamed from: f */
    private C4734x f12550f;
    /* renamed from: g */
    private MediaController f12551g;
    /* renamed from: h */
    private C1658d f12552h = C1658d.IDLE;
    /* renamed from: i */
    private C1658d f12553i = C1658d.IDLE;
    /* renamed from: j */
    private C1658d f12554j = C1658d.IDLE;
    /* renamed from: k */
    private boolean f12555k = false;
    /* renamed from: l */
    private View f12556l;
    /* renamed from: m */
    private boolean f12557m = false;
    /* renamed from: n */
    private boolean f12558n = false;
    /* renamed from: o */
    private long f12559o;
    /* renamed from: p */
    private long f12560p;
    /* renamed from: q */
    private long f12561q;
    /* renamed from: r */
    private int f12562r;
    /* renamed from: s */
    private int f12563s;
    /* renamed from: t */
    private float f12564t = 1.0f;
    /* renamed from: u */
    private int f12565u = -1;
    /* renamed from: v */
    private boolean f12566v = false;
    /* renamed from: w */
    private boolean f12567w = false;
    /* renamed from: x */
    private C1624a f12568x = C1624a.NOT_STARTED;
    /* renamed from: y */
    private boolean f12569y = false;

    /* renamed from: com.facebook.ads.internal.view.f.d.a$1 */
    class C16511 implements MediaPlayerControl {
        /* renamed from: a */
        final /* synthetic */ C4618a f4942a;

        C16511(C4618a c4618a) {
            this.f4942a = c4618a;
        }

        public boolean canPause() {
            return true;
        }

        public boolean canSeekBackward() {
            return true;
        }

        public boolean canSeekForward() {
            return true;
        }

        public int getAudioSessionId() {
            return this.f4942a.f12550f != null ? this.f4942a.f12550f.m16409g() : 0;
        }

        public int getBufferPercentage() {
            return this.f4942a.f12550f != null ? this.f4942a.f12550f.mo3241k() : 0;
        }

        public int getCurrentPosition() {
            return this.f4942a.getCurrentPosition();
        }

        public int getDuration() {
            return this.f4942a.getDuration();
        }

        public boolean isPlaying() {
            return this.f4942a.f12550f != null && this.f4942a.f12550f.mo3234b();
        }

        public void pause() {
            this.f4942a.mo1041a(true);
        }

        public void seekTo(int i) {
            this.f4942a.mo1039a(i);
        }

        public void start() {
            this.f4942a.mo1040a(C1624a.USER_STARTED);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.d.a$2 */
    class C16522 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C4618a f4943a;

        C16522(C4618a c4618a) {
            this.f4943a = c4618a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4943a.f12551g != null && motionEvent.getAction() == 1) {
                if (this.f4943a.f12551g.isShowing()) {
                    this.f4943a.f12551g.hide();
                } else {
                    this.f4943a.f12551g.show();
                }
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.d.a$3 */
    class C16533 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C4618a f4944a;

        C16533(C4618a c4618a) {
            this.f4944a = c4618a;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f4944a.f12551g != null && motionEvent.getAction() == 1) {
                if (this.f4944a.f12551g.isShowing()) {
                    this.f4944a.f12551g.hide();
                } else {
                    this.f4944a.f12551g.show();
                }
            }
            return true;
        }
    }

    public C4618a(Context context) {
        super(context);
    }

    public C4618a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C4618a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public C4618a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: f */
    private void m15911f() {
        C2514v c4242l = new C4242l();
        this.f12550f = C2368g.m6555a(getContext(), new C4730c(new C4235a(c4242l)), new C4089c());
        this.f12550f.m16402b((C2586b) this);
        this.f12550f.addListener(this);
        this.f12550f.mo3231a(false);
        if (this.f12558n && !this.f12566v) {
            this.f12551g = new MediaController(getContext());
            this.f12551g.setAnchorView(this.f12556l == null ? this : this.f12556l);
            this.f12551g.setMediaPlayer(new C16511(this));
            this.f12551g.setEnabled(true);
        }
        if (this.f12547c == null || this.f12547c.length() == 0 || this.f12569y) {
            this.f12550f.mo3228a(new C4217g(this.f12546b, new C4244n(getContext(), C2541v.m7170a(getContext(), "ads"), c4242l), new C4106c(), null, null));
        }
        setVideoState(C1658d.PREPARING);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    /* renamed from: g */
    private void m15912g() {
        if (this.f12549e != null) {
            this.f12549e.release();
            this.f12549e = null;
        }
        if (this.f12550f != null) {
            this.f12550f.mo3237e();
            this.f12550f = null;
        }
        this.f12551g = null;
        this.f12557m = false;
        setVideoState(C1658d.IDLE);
    }

    private void setVideoState(C1658d c1658d) {
        if (c1658d != this.f12552h) {
            this.f12552h = c1658d;
            if (this.f12552h == C1658d.STARTED) {
                this.f12557m = true;
            }
            if (this.f12548d != null) {
                this.f12548d.mo1032a(c1658d);
            }
        }
    }

    /* renamed from: a */
    public void m15913a() {
        if (!this.f12567w) {
            mo1041a(false);
        }
    }

    /* renamed from: a */
    public void mo1039a(int i) {
        if (this.f12550f != null) {
            this.f12565u = getCurrentPosition();
            this.f12550f.mo3227a((long) i);
            return;
        }
        this.f12561q = (long) i;
    }

    /* renamed from: a */
    public void mo1040a(C1624a c1624a) {
        this.f12553i = C1658d.STARTED;
        this.f12568x = c1624a;
        if (this.f12550f == null) {
            setup(this.f12546b);
        } else if (this.f12552h == C1658d.PREPARED || this.f12552h == C1658d.PAUSED || this.f12552h == C1658d.PLAYBACK_COMPLETED) {
            this.f12550f.mo3231a(true);
            setVideoState(C1658d.STARTED);
        }
    }

    /* renamed from: a */
    public void mo1041a(boolean z) {
        if (this.f12550f != null) {
            this.f12550f.mo3231a(false);
        } else {
            setVideoState(C1658d.IDLE);
        }
    }

    /* renamed from: b */
    public void mo1042b() {
        setVideoState(C1658d.PLAYBACK_COMPLETED);
        mo1043c();
        this.f12561q = 0;
    }

    /* renamed from: c */
    public void mo1043c() {
        this.f12553i = C1658d.IDLE;
        if (this.f12550f != null) {
            this.f12550f.mo3236d();
            this.f12550f.mo3237e();
            this.f12550f = null;
        }
        setVideoState(C1658d.IDLE);
    }

    /* renamed from: d */
    public boolean mo1044d() {
        return (this.f12550f == null || this.f12550f.m16408f() == null) ? false : true;
    }

    /* renamed from: e */
    public void mo1045e() {
        m15912g();
    }

    public int getCurrentPosition() {
        return this.f12550f != null ? (int) this.f12550f.mo3239i() : 0;
    }

    public int getDuration() {
        return this.f12550f == null ? 0 : (int) this.f12550f.mo3238h();
    }

    public long getInitialBufferTime() {
        return this.f12560p;
    }

    public C1624a getStartReason() {
        return this.f12568x;
    }

    public C1658d getState() {
        return this.f12552h;
    }

    public C1658d getTargetState() {
        return this.f12553i;
    }

    public int getVideoHeight() {
        return this.f12563s;
    }

    public int getVideoWidth() {
        return this.f12562r;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f12564t;
    }

    public void onLoadingChanged(boolean z) {
    }

    public void onPlaybackParametersChanged(C2573r c2573r) {
    }

    public void onPlayerError(C2330e c2330e) {
        setVideoState(C1658d.ERROR);
        c2330e.printStackTrace();
        C1398b.m4797a(C1397a.m4794a(c2330e, "[ExoPlayer] Error during playback of ExoPlayer"));
    }

    public void onPlayerStateChanged(boolean z, int i) {
        C1658d c1658d;
        switch (i) {
            case 1:
                c1658d = C1658d.IDLE;
                break;
            case 2:
                if (this.f12565u >= 0) {
                    int i2 = this.f12565u;
                    this.f12565u = -1;
                    this.f12548d.mo1031a(i2, getCurrentPosition());
                    return;
                }
                return;
            case 3:
                if (this.f12559o != 0) {
                    this.f12560p = System.currentTimeMillis() - this.f12559o;
                }
                setRequestedVolume(this.f12564t);
                if (this.f12561q > 0 && this.f12561q < this.f12550f.mo3238h()) {
                    this.f12550f.mo3227a(this.f12561q);
                    this.f12561q = 0;
                }
                if (this.f12550f.mo3239i() != 0 && !z && this.f12557m) {
                    c1658d = C1658d.PAUSED;
                    break;
                } else if (!z && this.f12552h != C1658d.PLAYBACK_COMPLETED) {
                    setVideoState(C1658d.PREPARED);
                    if (this.f12553i == C1658d.STARTED) {
                        mo1040a(this.f12568x);
                        this.f12553i = C1658d.IDLE;
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 4:
                if (z) {
                    setVideoState(C1658d.PLAYBACK_COMPLETED);
                }
                if (this.f12550f != null) {
                    this.f12550f.mo3231a(false);
                    if (!z) {
                        this.f12550f.mo3235c();
                    }
                }
                this.f12557m = false;
                return;
            default:
                return;
        }
        setVideoState(c1658d);
    }

    public void onPositionDiscontinuity() {
    }

    public void onRenderedFirstFrame() {
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f12549e != null) {
            this.f12549e.release();
        }
        this.f12549e = new Surface(surfaceTexture);
        if (this.f12550f != null) {
            this.f12550f.m16395a(this.f12549e);
            this.f12555k = false;
            if (this.f12552h == C1658d.PAUSED && this.f12554j != C1658d.PAUSED) {
                mo1040a(this.f12568x);
            }
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        if (this.f12549e != null) {
            this.f12549e.release();
            this.f12549e = null;
            if (this.f12550f != null) {
                this.f12550f.m16395a(null);
            }
        }
        if (!this.f12555k) {
            this.f12554j = this.f12558n ? C1658d.STARTED : this.f12552h;
            this.f12555k = true;
        }
        if (this.f12552h != C1658d.PAUSED) {
            mo1041a(false);
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onTimelineChanged(C2589y c2589y, Object obj) {
    }

    public void onTracksChanged(C2439q c2439q, C2485g c2485g) {
    }

    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        this.f12562r = i;
        this.f12563s = i2;
        if (this.f12562r != 0 && this.f12563s != 0) {
            requestLayout();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f12550f != null) {
            if (this.f12551g == null || !this.f12551g.isShowing()) {
                if (z) {
                    this.f12555k = false;
                    if (this.f12552h == C1658d.PAUSED && this.f12554j != C1658d.PAUSED) {
                        mo1040a(this.f12568x);
                    }
                } else {
                    if (!this.f12555k) {
                        this.f12554j = this.f12558n ? C1658d.STARTED : this.f12552h;
                        this.f12555k = true;
                    }
                    if (this.f12552h != C1658d.PAUSED) {
                        m15913a();
                    }
                }
            }
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.w(f12545a, "Google always throw an exception with setBackgroundDrawable on Nougat above. so we silently ignore it.");
        }
    }

    public void setBackgroundPlaybackEnabled(boolean z) {
        this.f12567w = z;
    }

    public void setControlsAnchorView(View view) {
        this.f12556l = view;
        view.setOnTouchListener(new C16533(this));
    }

    public void setForeground(Drawable drawable) {
        if (VERSION.SDK_INT < 24) {
            super.setForeground(drawable);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.w(f12545a, "Google always throw an exception with setForeground on Nougat above. so we silently ignore it.");
        }
    }

    public void setFullScreen(boolean z) {
        this.f12558n = z;
        if (z && !this.f12566v) {
            setOnTouchListener(new C16522(this));
        }
    }

    public void setRequestedVolume(float f) {
        this.f12564t = f;
        if (this.f12550f != null && this.f12552h != C1658d.PREPARING && this.f12552h != C1658d.IDLE) {
            this.f12550f.m16392a(f);
        }
    }

    public void setTestMode(boolean z) {
        this.f12569y = z;
    }

    public void setVideoMPD(String str) {
        this.f12547c = str;
    }

    public void setVideoStateChangeListener(C1659e c1659e) {
        this.f12548d = c1659e;
    }

    public void setup(Uri uri) {
        if (this.f12550f != null) {
            m15912g();
        }
        this.f12546b = uri;
        setSurfaceTextureListener(this);
        m15911f();
    }
}
