package versioned.host.exp.exponent.modules.api.av.player;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.exoplayer2.C2330e;
import com.google.android.exoplayer2.C2368g;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2573r;
import com.google.android.exoplayer2.C2575s.C2574a;
import com.google.android.exoplayer2.C2589y;
import com.google.android.exoplayer2.C4734x;
import com.google.android.exoplayer2.C4734x.C2586b;
import com.google.android.exoplayer2.p137e.C4106c;
import com.google.android.exoplayer2.p149h.C2423i;
import com.google.android.exoplayer2.p149h.C2439q;
import com.google.android.exoplayer2.p149h.C4173a;
import com.google.android.exoplayer2.p149h.C4217g;
import com.google.android.exoplayer2.p149h.C4217g.C2420a;
import com.google.android.exoplayer2.p149h.p151b.C4186c;
import com.google.android.exoplayer2.p149h.p151b.C4716f.C4188a;
import com.google.android.exoplayer2.p149h.p153c.C4198j;
import com.google.android.exoplayer2.p149h.p155d.C4211d;
import com.google.android.exoplayer2.p149h.p155d.C4720a.C4203a;
import com.google.android.exoplayer2.p162j.C2485g;
import com.google.android.exoplayer2.p162j.C4729a.C4235a;
import com.google.android.exoplayer2.p162j.C4730c;
import com.google.android.exoplayer2.p163k.C2498g.C2497a;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p163k.C4242l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.util.Map;
import versioned.host.exp.exponent.modules.api.av.AVModule;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.ErrorListener;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.LoadCompletionListener;

class SimpleExoPlayerData extends PlayerData implements C4173a, C2420a, C2574a, C2586b {
    private static final String IMPLEMENTATION_NAME = "SimpleExoPlayer";
    private boolean mFirstFrameRendered = false;
    private boolean mIsLoading = true;
    private boolean mIsLooping = false;
    private Integer mLastPlaybackState = null;
    private LoadCompletionListener mLoadCompletionListener = null;
    private String mOverridingExtension;
    private ReactContext mReactContext;
    private C4734x mSimpleExoPlayer = null;
    private Pair<Integer, Integer> mVideoWidthHeight = null;

    String getImplementationName() {
        return IMPLEMENTATION_NAME;
    }

    public void onDownstreamFormatChanged(int i, C2515k c2515k, int i2, Object obj, long j) {
    }

    public void onLoadCanceled(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
    }

    public void onLoadCompleted(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
    }

    public void onLoadStarted(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3) {
    }

    public void onPlaybackParametersChanged(C2573r c2573r) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onSeekProcessed() {
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    public void onTimelineChanged(C2589y c2589y, Object obj) {
    }

    public void onTracksChanged(C2439q c2439q, C2485g c2485g) {
    }

    public void onUpstreamDiscarded(int i, long j, long j2) {
    }

    SimpleExoPlayerData(AVModule aVModule, ReactContext reactContext, Uri uri, String str, Map<String, Object> map) {
        super(aVModule, uri, map);
        this.mReactContext = reactContext;
        this.mOverridingExtension = str;
    }

    public void load(ReadableMap readableMap, LoadCompletionListener loadCompletionListener) {
        this.mLoadCompletionListener = loadCompletionListener;
        loadCompletionListener = new Handler();
        this.mSimpleExoPlayer = C2368g.a(this.mAVModule.mScopedContext, new C4730c(new C4235a(new C4242l())));
        this.mSimpleExoPlayer.a(this);
        this.mSimpleExoPlayer.a(this);
        try {
            this.mSimpleExoPlayer.a(buildMediaSource(this.mUri, this.mOverridingExtension, loadCompletionListener, new SharedCookiesDataSourceFactory(this.mUri, this.mReactContext, C2541v.a(this.mAVModule.mScopedContext, "yourApplicationName"), this.mRequestHeaders)));
            setStatus(readableMap, null);
        } catch (ReadableMap readableMap2) {
            onFatalError(readableMap2);
        }
    }

    public synchronized void release() {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.e();
            this.mSimpleExoPlayer = null;
        }
    }

    boolean shouldContinueUpdatingProgress() {
        return this.mSimpleExoPlayer != null && this.mSimpleExoPlayer.b();
    }

    void playPlayerWithRateAndMuteIfNecessary() {
        if (this.mSimpleExoPlayer != null) {
            if (shouldPlayerPlay()) {
                if (!this.mIsMuted) {
                    this.mAVModule.acquireAudioFocus();
                }
                updateVolumeMuteAndDuck();
                this.mSimpleExoPlayer.a(new C2573r(this.mRate, this.mShouldCorrectPitch ? 1.0f : this.mRate));
                this.mSimpleExoPlayer.a(this.mShouldPlay);
                beginUpdatingProgressIfNecessary();
            }
        }
    }

    void applyNewStatus(Integer num, Boolean bool) {
        if (this.mSimpleExoPlayer != null) {
            if (bool != null) {
                this.mIsLooping = bool.booleanValue();
                if (this.mIsLooping != null) {
                    this.mSimpleExoPlayer.a(2);
                } else {
                    this.mSimpleExoPlayer.a(0);
                }
            }
            if (shouldPlayerPlay() == null) {
                this.mSimpleExoPlayer.a(false);
                stopUpdatingProgressIfNecessary();
            }
            updateVolumeMuteAndDuck();
            if (num != null) {
                this.mSimpleExoPlayer.a((long) num.intValue());
            }
            playPlayerWithRateAndMuteIfNecessary();
            return;
        }
        throw new IllegalStateException("mSimpleExoPlayer is null!");
    }

    boolean isLoaded() {
        return this.mSimpleExoPlayer != null;
    }

    void getExtraStatusFields(WritableMap writableMap) {
        int h = (int) this.mSimpleExoPlayer.h();
        writableMap.putInt("durationMillis", h);
        writableMap.putInt("positionMillis", getClippedIntegerForValue(Integer.valueOf((int) this.mSimpleExoPlayer.i()), Integer.valueOf(0), Integer.valueOf(h)));
        writableMap.putInt("playableDurationMillis", getClippedIntegerForValue(Integer.valueOf((int) this.mSimpleExoPlayer.j()), Integer.valueOf(0), Integer.valueOf(h)));
        String str = PlayerData.STATUS_IS_PLAYING_KEY_PATH;
        boolean z = true;
        boolean z2 = this.mSimpleExoPlayer.b() && this.mSimpleExoPlayer.a() == 3;
        writableMap.putBoolean(str, z2);
        str = "isBuffering";
        if (!this.mIsLoading) {
            if (this.mSimpleExoPlayer.a() != 2) {
                z = false;
            }
        }
        writableMap.putBoolean(str, z);
        writableMap.putBoolean("isLooping", this.mIsLooping);
    }

    public Pair<Integer, Integer> getVideoWidthHeight() {
        return this.mVideoWidthHeight != null ? this.mVideoWidthHeight : new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }

    public void tryUpdateVideoSurface(Surface surface) {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.a(surface);
        }
    }

    public int getAudioSessionId() {
        return this.mSimpleExoPlayer != null ? this.mSimpleExoPlayer.g() : 0;
    }

    public void pauseImmediately() {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.a(false);
        }
        stopUpdatingProgressIfNecessary();
    }

    public boolean requiresAudioFocus() {
        return this.mSimpleExoPlayer != null && ((this.mSimpleExoPlayer.b() || shouldPlayerPlay()) && !this.mIsMuted);
    }

    public void updateVolumeMuteAndDuck() {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.a(this.mAVModule.getVolumeForDuckAndFocus(this.mIsMuted, this.mVolume));
        }
    }

    public void onLoadingChanged(boolean z) {
        this.mIsLoading = z;
        callStatusUpdateListener();
    }

    public void onPlayerStateChanged(boolean z, int i) {
        if (i == true && this.mLoadCompletionListener) {
            z = this.mLoadCompletionListener;
            this.mLoadCompletionListener = null;
            z.onLoadSuccess(getStatus());
        }
        if (this.mLastPlaybackState && i != this.mLastPlaybackState.intValue() && i == true) {
            callStatusUpdateListenerWithDidJustFinish();
        } else {
            callStatusUpdateListener();
        }
        this.mLastPlaybackState = Integer.valueOf(i);
    }

    public void onPlayerError(C2330e c2330e) {
        onFatalError(c2330e.getCause());
    }

    public void onPositionDiscontinuity(int i) {
        if (i == 0) {
            callStatusUpdateListenerWithDidJustFinish();
        }
    }

    public void onLoadError(IOException iOException) {
        onFatalError(iOException);
    }

    private void onFatalError(Throwable th) {
        if (this.mLoadCompletionListener != null) {
            LoadCompletionListener loadCompletionListener = this.mLoadCompletionListener;
            this.mLoadCompletionListener = null;
            loadCompletionListener.onLoadError(th.toString());
        } else {
            ErrorListener errorListener = this.mErrorListener;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Player error: ");
            stringBuilder.append(th.getMessage());
            errorListener.onError(stringBuilder.toString());
        }
        release();
    }

    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        this.mVideoWidthHeight = new Pair(Integer.valueOf(i), Integer.valueOf(i2));
        if (this.mFirstFrameRendered != 0 && this.mVideoSizeUpdateListener != 0) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(this.mVideoWidthHeight);
        }
    }

    public void onRenderedFirstFrame() {
        if (!(this.mFirstFrameRendered || this.mVideoWidthHeight == null || this.mVideoSizeUpdateListener == null)) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(this.mVideoWidthHeight);
        }
        this.mFirstFrameRendered = true;
    }

    private C2423i buildMediaSource(Uri uri, String str, Handler handler, C2497a c2497a) {
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(uri);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        str = C2541v.i(str);
        switch (str) {
            case null:
                return new C4186c(uri, c2497a, new C4188a(c2497a), handler, this);
            case 1:
                return new C4211d(uri, c2497a, new C4203a(c2497a), handler, this);
            case 2:
                return new C4198j(uri, c2497a, handler, this);
            case 3:
                return new C4217g(uri, c2497a, new C4106c(), handler, this);
            default:
                handler = new StringBuilder();
                handler.append("Content of this type is unsupported at the moment. Unsupported type: ");
                handler.append(str);
                throw new IllegalStateException(handler.toString());
        }
    }

    public void onLoadError(C2501j c2501j, int i, int i2, C2515k c2515k, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        SimpleExoPlayerData simpleExoPlayerData = this;
        onLoadError(iOException);
    }
}
