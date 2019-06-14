package com.facebook.ads.internal.view.p120f.p124d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.MediaPlayer.TrackInfo;
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
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.common.util.UriUtil;
import java.io.IOException;

@TargetApi(14)
/* renamed from: com.facebook.ads.internal.view.f.d.b */
public class C3685b extends TextureView implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnPreparedListener, OnSeekCompleteListener, OnVideoSizeChangedListener, SurfaceTextureListener, C1657c {
    /* renamed from: t */
    private static final String f9848t = "b";
    /* renamed from: a */
    private Uri f9849a;
    /* renamed from: b */
    private C1659e f9850b;
    /* renamed from: c */
    private Surface f9851c;
    /* renamed from: d */
    private MediaPlayer f9852d;
    /* renamed from: e */
    private MediaController f9853e;
    /* renamed from: f */
    private C1658d f9854f = C1658d.IDLE;
    /* renamed from: g */
    private C1658d f9855g = C1658d.IDLE;
    /* renamed from: h */
    private C1658d f9856h = C1658d.IDLE;
    /* renamed from: i */
    private boolean f9857i = false;
    /* renamed from: j */
    private View f9858j;
    /* renamed from: k */
    private int f9859k = 0;
    /* renamed from: l */
    private long f9860l;
    /* renamed from: m */
    private int f9861m = 0;
    /* renamed from: n */
    private int f9862n = 0;
    /* renamed from: o */
    private float f9863o = 1.0f;
    /* renamed from: p */
    private boolean f9864p = false;
    /* renamed from: q */
    private int f9865q = 3;
    /* renamed from: r */
    private boolean f9866r = false;
    /* renamed from: s */
    private boolean f9867s = false;
    /* renamed from: u */
    private int f9868u = 0;
    /* renamed from: v */
    private boolean f9869v = false;
    /* renamed from: w */
    private C1624a f9870w = C1624a.NOT_STARTED;
    /* renamed from: x */
    private final MediaPlayerControl f9871x = new C16541(this);

    /* renamed from: com.facebook.ads.internal.view.f.d.b$1 */
    class C16541 implements MediaPlayerControl {
        /* renamed from: a */
        final /* synthetic */ C3685b f4945a;

        C16541(C3685b c3685b) {
            this.f4945a = c3685b;
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
            return this.f4945a.f9852d != null ? this.f4945a.f9852d.getAudioSessionId() : 0;
        }

        public int getBufferPercentage() {
            return 0;
        }

        public int getCurrentPosition() {
            return this.f4945a.getCurrentPosition();
        }

        public int getDuration() {
            return this.f4945a.getDuration();
        }

        public boolean isPlaying() {
            return this.f4945a.f9852d != null && this.f4945a.f9852d.isPlaying();
        }

        public void pause() {
            this.f4945a.mo1041a(true);
        }

        public void seekTo(int i) {
            this.f4945a.mo1039a(i);
        }

        public void start() {
            this.f4945a.mo1040a(C1624a.USER_STARTED);
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.d.b$2 */
    class C16552 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C3685b f4946a;

        C16552(C3685b c3685b) {
            this.f4946a = c3685b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(this.f4946a.f9869v || this.f4946a.f9853e == null || motionEvent.getAction() != 1)) {
                if (this.f4946a.f9853e.isShowing()) {
                    this.f4946a.f9853e.hide();
                } else {
                    this.f4946a.f9853e.show();
                }
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.f.d.b$3 */
    class C16563 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C3685b f4947a;

        C16563(C3685b c3685b) {
            this.f4947a = c3685b;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(this.f4947a.f9869v || this.f4947a.f9853e == null || motionEvent.getAction() != 1)) {
                if (this.f4947a.f9853e.isShowing()) {
                    this.f4947a.f9853e.hide();
                } else {
                    this.f4947a.f9853e.show();
                }
            }
            return true;
        }
    }

    public C3685b(Context context) {
        super(context);
    }

    public C3685b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C3685b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public C3685b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private boolean m12064a(Surface surface) {
        if (this.f9852d == null) {
            return false;
        }
        try {
            this.f9852d.setSurface(surface);
            return true;
        } catch (Exception e) {
            C1540a.m5396a(getContext(), "player", C1541b.f4574s, e);
            Log.d(f9848t, "The MediaPlayer failed", e);
            return false;
        }
    }

    /* renamed from: f */
    private boolean m12067f() {
        if (!(this.f9854f == C1658d.PREPARED || this.f9854f == C1658d.STARTED || this.f9854f == C1658d.PAUSED)) {
            if (this.f9854f != C1658d.PLAYBACK_COMPLETED) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    private boolean m12068g() {
        if (this.f9852d == null) {
            return false;
        }
        try {
            this.f9852d.reset();
            return true;
        } catch (Exception e) {
            C1540a.m5396a(getContext(), "player", C1541b.f4575t, e);
            Log.d(f9848t, "The MediaPlayer failed", e);
            return false;
        }
    }

    /* renamed from: h */
    private boolean m12069h() {
        return (this.f9854f == C1658d.PREPARING || this.f9854f == C1658d.PREPARED) ? false : true;
    }

    /* renamed from: i */
    private boolean m12070i() {
        return (this.f9854f == C1658d.PREPARING || this.f9854f == C1658d.PREPARED) ? false : true;
    }

    private void setVideoState(C1658d c1658d) {
        if (c1658d != this.f9854f) {
            this.f9854f = c1658d;
            if (this.f9850b != null) {
                this.f9850b.mo1032a(c1658d);
            }
        }
    }

    /* renamed from: a */
    public void m12071a() {
        if (!this.f9866r) {
            mo1041a(false);
        }
    }

    /* renamed from: a */
    public void mo1039a(int i) {
        if (this.f9852d == null || !m12067f()) {
            this.f9859k = i;
        } else if (i < getDuration() && i > 0) {
            this.f9868u = getCurrentPosition();
            this.f9859k = i;
            this.f9852d.seekTo(i);
        }
    }

    /* renamed from: a */
    public void mo1040a(C1624a c1624a) {
        this.f9855g = C1658d.STARTED;
        this.f9870w = c1624a;
        if (this.f9854f == C1658d.STARTED || this.f9854f == C1658d.PREPARED || this.f9854f == C1658d.IDLE || this.f9854f == C1658d.PAUSED || this.f9854f == C1658d.PLAYBACK_COMPLETED) {
            if (this.f9852d == null) {
                setup(this.f9849a);
            } else {
                if (this.f9859k > 0) {
                    this.f9852d.seekTo(this.f9859k);
                }
                this.f9852d.start();
                if (this.f9854f != C1658d.PREPARED || this.f9867s) {
                    setVideoState(C1658d.STARTED);
                }
            }
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

    /* renamed from: a */
    public void mo1041a(boolean z) {
        C1658d c1658d;
        this.f9855g = C1658d.PAUSED;
        if (this.f9852d == null) {
            c1658d = C1658d.IDLE;
        } else if (m12070i()) {
            if (z) {
                this.f9856h = C1658d.PAUSED;
                this.f9857i = true;
            }
            this.f9852d.pause();
            if (this.f9854f != C1658d.PLAYBACK_COMPLETED) {
                c1658d = C1658d.PAUSED;
            }
        } else {
            return;
        }
        setVideoState(c1658d);
    }

    /* renamed from: b */
    public void mo1042b() {
        setVideoState(C1658d.PLAYBACK_COMPLETED);
        mo1043c();
        this.f9859k = 0;
    }

    /* renamed from: c */
    public void mo1043c() {
        this.f9855g = C1658d.IDLE;
        if (this.f9852d != null) {
            int currentPosition = this.f9852d.getCurrentPosition();
            if (currentPosition > 0) {
                this.f9859k = currentPosition;
            }
            this.f9852d.stop();
            m12068g();
            this.f9852d.release();
            this.f9852d = null;
            if (this.f9853e != null) {
                this.f9853e.hide();
                this.f9853e.setEnabled(false);
            }
        }
        setVideoState(C1658d.IDLE);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public boolean mo1044d() {
        if (this.f9852d != null) {
            if (VERSION.SDK_INT >= 16) {
                try {
                    for (TrackInfo trackType : this.f9852d.getTrackInfo()) {
                        if (trackType.getTrackType() == 2) {
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable e) {
                    Log.e(f9848t, "Couldn't retrieve video information", e);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public void mo1045e() {
        if (this.f9852d != null) {
            m12064a(null);
            this.f9852d.setOnBufferingUpdateListener(null);
            this.f9852d.setOnCompletionListener(null);
            this.f9852d.setOnErrorListener(null);
            this.f9852d.setOnInfoListener(null);
            this.f9852d.setOnPreparedListener(null);
            this.f9852d.setOnVideoSizeChangedListener(null);
            this.f9852d.setOnSeekCompleteListener(null);
            m12068g();
            this.f9852d = null;
            setVideoState(C1658d.IDLE);
        }
    }

    public int getCurrentPosition() {
        return (this.f9852d == null || !m12067f()) ? 0 : this.f9852d.getCurrentPosition();
    }

    public int getDuration() {
        if (this.f9852d != null) {
            if (m12067f()) {
                return this.f9852d.getDuration();
            }
        }
        return 0;
    }

    public long getInitialBufferTime() {
        return this.f9860l;
    }

    public C1624a getStartReason() {
        return this.f9870w;
    }

    public C1658d getState() {
        return this.f9854f;
    }

    public C1658d getTargetState() {
        return this.f9855g;
    }

    public int getVideoHeight() {
        return this.f9862n;
    }

    public int getVideoWidth() {
        return this.f9861m;
    }

    public View getView() {
        return this;
    }

    public float getVolume() {
        return this.f9863o;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f9852d != null) {
            this.f9852d.pause();
        }
        setVideoState(C1658d.PLAYBACK_COMPLETED);
        mo1039a(0);
        this.f9859k = 0;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f9865q <= 0 || getState() != C1658d.STARTED) {
            setVideoState(C1658d.ERROR);
            mo1043c();
        } else {
            this.f9865q--;
            mo1043c();
            mo1040a(this.f9870w);
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInfo(android.media.MediaPlayer r1, int r2, int r3) {
        /*
        r0 = this;
        r1 = 3;
        if (r2 == r1) goto L_0x0017;
    L_0x0003:
        switch(r2) {
            case 701: goto L_0x0010;
            case 702: goto L_0x0007;
            default: goto L_0x0006;
        };
    L_0x0006:
        goto L_0x0015;
    L_0x0007:
        r1 = r0.m12069h();
        if (r1 == 0) goto L_0x0015;
    L_0x000d:
        r1 = com.facebook.ads.internal.view.p120f.p124d.C1658d.STARTED;
        goto L_0x0012;
    L_0x0010:
        r1 = com.facebook.ads.internal.view.p120f.p124d.C1658d.BUFFERING;
    L_0x0012:
        r0.setVideoState(r1);
    L_0x0015:
        r1 = 0;
        return r1;
    L_0x0017:
        r1 = 1;
        r0.f9867s = r1;
        r2 = r0.f9855g;
        r3 = com.facebook.ads.internal.view.p120f.p124d.C1658d.STARTED;
        if (r2 != r3) goto L_0x0025;
    L_0x0020:
        r2 = com.facebook.ads.internal.view.p120f.p124d.C1658d.STARTED;
        r0.setVideoState(r2);
    L_0x0025:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.f.d.b.onInfo(android.media.MediaPlayer, int, int):boolean");
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        setVideoState(C1658d.PREPARED);
        if (this.f9864p && !this.f9869v) {
            this.f9853e = new MediaController(getContext());
            this.f9853e.setAnchorView(this.f9858j == null ? this : this.f9858j);
            this.f9853e.setMediaPlayer(this.f9871x);
            this.f9853e.setEnabled(true);
        }
        setRequestedVolume(this.f9863o);
        this.f9861m = mediaPlayer.getVideoWidth();
        this.f9862n = mediaPlayer.getVideoHeight();
        if (this.f9859k > 0) {
            if (this.f9859k >= this.f9852d.getDuration()) {
                this.f9859k = 0;
            }
            this.f9852d.seekTo(this.f9859k);
            this.f9859k = 0;
        }
        if (this.f9855g == C1658d.STARTED) {
            mo1040a(this.f9870w);
        }
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        if (this.f9850b != null) {
            this.f9850b.mo1031a(this.f9868u, this.f9859k);
            this.f9859k = 0;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.f9851c == null) {
            this.f9851c = new Surface(surfaceTexture);
        }
        if (m12064a(this.f9851c)) {
            this.f9857i = false;
            if (this.f9854f == C1658d.PAUSED && this.f9856h != C1658d.PAUSED) {
                mo1040a(this.f9870w);
            }
            return;
        }
        setVideoState(C1658d.ERROR);
        mo1045e();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        m12064a(null);
        if (this.f9851c != null) {
            this.f9851c.release();
            this.f9851c = null;
        }
        if (!this.f9857i) {
            this.f9856h = this.f9864p ? C1658d.STARTED : this.f9854f;
            this.f9857i = true;
        }
        if (this.f9854f != C1658d.PAUSED) {
            mo1041a(false);
        }
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f9861m = mediaPlayer.getVideoWidth();
        this.f9862n = mediaPlayer.getVideoHeight();
        if (this.f9861m != 0 && this.f9862n != 0) {
            requestLayout();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.f9852d != null) {
            if (this.f9853e == null || !this.f9853e.isShowing()) {
                if (z) {
                    this.f9857i = false;
                    if (this.f9854f == C1658d.PAUSED && this.f9856h != C1658d.PAUSED) {
                        mo1040a(this.f9870w);
                    }
                } else {
                    if (!this.f9857i) {
                        this.f9856h = this.f9864p ? C1658d.STARTED : this.f9854f;
                        this.f9857i = true;
                    }
                    if (this.f9854f != C1658d.PAUSED) {
                        m12071a();
                    }
                }
            }
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.w(f9848t, "Google always throw an exception with setBackgroundDrawable on Nougat above. so we silently ignore it.");
        }
    }

    public void setBackgroundPlaybackEnabled(boolean z) {
        this.f9866r = z;
    }

    public void setControlsAnchorView(View view) {
        this.f9858j = view;
        view.setOnTouchListener(new C16563(this));
    }

    public void setForeground(Drawable drawable) {
        if (VERSION.SDK_INT < 24) {
            super.setForeground(drawable);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.w(f9848t, "Google always throw an exception with setForeground on Nougat above. so we silently ignore it.");
        }
    }

    public void setFullScreen(boolean z) {
        this.f9864p = z;
        if (this.f9864p && !this.f9869v) {
            setOnTouchListener(new C16552(this));
        }
    }

    public void setRequestedVolume(float f) {
        this.f9863o = f;
        if (this.f9852d != null && this.f9854f != C1658d.PREPARING && this.f9854f != C1658d.IDLE) {
            this.f9852d.setVolume(f, f);
        }
    }

    public void setVideoMPD(String str) {
    }

    public void setVideoStateChangeListener(C1659e c1659e) {
        this.f9850b = c1659e;
    }

    public void setup(Uri uri) {
        MediaPlayer mediaPlayer;
        String str;
        StringBuilder stringBuilder;
        String stringBuilder2;
        Object obj;
        String str2;
        StringBuilder stringBuilder3;
        Throwable th;
        this.f9867s = false;
        this.f9849a = uri;
        AssetFileDescriptor assetFileDescriptor = null;
        if (this.f9852d != null) {
            m12068g();
            m12064a(null);
            mediaPlayer = this.f9852d;
            setVideoState(C1658d.IDLE);
        } else {
            mediaPlayer = new MediaPlayer();
        }
        try {
            if (uri.getScheme().equals(UriUtil.LOCAL_ASSET_SCHEME)) {
                try {
                    AssetFileDescriptor openFd = getContext().getAssets().openFd(uri.getPath().substring(1));
                    try {
                        MediaPlayer mediaPlayer2 = mediaPlayer;
                        mediaPlayer2.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                        if (openFd != null) {
                            try {
                                openFd.close();
                            } catch (IOException e) {
                                str = f9848t;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Unable to close");
                                stringBuilder.append(e);
                                stringBuilder2 = stringBuilder.toString();
                                Log.w(str, stringBuilder2);
                                mediaPlayer.setLooping(false);
                                mediaPlayer.setOnBufferingUpdateListener(this);
                                mediaPlayer.setOnCompletionListener(this);
                                mediaPlayer.setOnErrorListener(this);
                                mediaPlayer.setOnInfoListener(this);
                                mediaPlayer.setOnPreparedListener(this);
                                mediaPlayer.setOnVideoSizeChangedListener(this);
                                mediaPlayer.setOnSeekCompleteListener(this);
                                mediaPlayer.prepareAsync();
                                this.f9852d = mediaPlayer;
                                setVideoState(C1658d.PREPARING);
                                setSurfaceTextureListener(this);
                                if (isAvailable()) {
                                    onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                                }
                            }
                        }
                    } catch (SecurityException e2) {
                        SecurityException securityException = e2;
                        assetFileDescriptor = openFd;
                        obj = securityException;
                        try {
                            str2 = f9848t;
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append("Failed to open assets ");
                            stringBuilder3.append(obj);
                            Log.w(str2, stringBuilder3.toString());
                            setVideoState(C1658d.ERROR);
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                } catch (IOException e3) {
                                    str = f9848t;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unable to close");
                                    stringBuilder.append(e3);
                                    stringBuilder2 = stringBuilder.toString();
                                    Log.w(str, stringBuilder2);
                                    mediaPlayer.setLooping(false);
                                    mediaPlayer.setOnBufferingUpdateListener(this);
                                    mediaPlayer.setOnCompletionListener(this);
                                    mediaPlayer.setOnErrorListener(this);
                                    mediaPlayer.setOnInfoListener(this);
                                    mediaPlayer.setOnPreparedListener(this);
                                    mediaPlayer.setOnVideoSizeChangedListener(this);
                                    mediaPlayer.setOnSeekCompleteListener(this);
                                    mediaPlayer.prepareAsync();
                                    this.f9852d = mediaPlayer;
                                    setVideoState(C1658d.PREPARING);
                                    setSurfaceTextureListener(this);
                                    if (isAvailable()) {
                                        onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                                    }
                                }
                            }
                            mediaPlayer.setLooping(false);
                            mediaPlayer.setOnBufferingUpdateListener(this);
                            mediaPlayer.setOnCompletionListener(this);
                            mediaPlayer.setOnErrorListener(this);
                            mediaPlayer.setOnInfoListener(this);
                            mediaPlayer.setOnPreparedListener(this);
                            mediaPlayer.setOnVideoSizeChangedListener(this);
                            mediaPlayer.setOnSeekCompleteListener(this);
                            mediaPlayer.prepareAsync();
                            this.f9852d = mediaPlayer;
                            setVideoState(C1658d.PREPARING);
                            setSurfaceTextureListener(this);
                            if (isAvailable()) {
                                onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (assetFileDescriptor != null) {
                                try {
                                    assetFileDescriptor.close();
                                } catch (IOException e4) {
                                    str2 = f9848t;
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append("Unable to close");
                                    stringBuilder3.append(e4);
                                    Log.w(str2, stringBuilder3.toString());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        assetFileDescriptor = openFd;
                        th = th4;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        throw th;
                    }
                } catch (SecurityException e5) {
                    obj = e5;
                    str2 = f9848t;
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Failed to open assets ");
                    stringBuilder3.append(obj);
                    Log.w(str2, stringBuilder3.toString());
                    setVideoState(C1658d.ERROR);
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    mediaPlayer.setLooping(false);
                    mediaPlayer.setOnBufferingUpdateListener(this);
                    mediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.setOnErrorListener(this);
                    mediaPlayer.setOnInfoListener(this);
                    mediaPlayer.setOnPreparedListener(this);
                    mediaPlayer.setOnVideoSizeChangedListener(this);
                    mediaPlayer.setOnSeekCompleteListener(this);
                    mediaPlayer.prepareAsync();
                    this.f9852d = mediaPlayer;
                    setVideoState(C1658d.PREPARING);
                    setSurfaceTextureListener(this);
                    if (isAvailable()) {
                        onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
                    }
                }
            }
            mediaPlayer.setDataSource(uri.toString());
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setOnInfoListener(this);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnVideoSizeChangedListener(this);
            mediaPlayer.setOnSeekCompleteListener(this);
            mediaPlayer.prepareAsync();
            this.f9852d = mediaPlayer;
            setVideoState(C1658d.PREPARING);
        } catch (Exception e6) {
            setVideoState(C1658d.ERROR);
            mediaPlayer.release();
            String str3 = f9848t;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Cannot prepare media player with SurfaceTexture: ");
            stringBuilder4.append(e6);
            Log.e(str3, stringBuilder4.toString());
        }
        setSurfaceTextureListener(this);
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }
}
