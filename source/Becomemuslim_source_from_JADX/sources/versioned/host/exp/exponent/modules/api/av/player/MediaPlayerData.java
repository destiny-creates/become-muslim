package versioned.host.exp.exponent.modules.api.av.player;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.Surface;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.network.NetworkingModule;
import expolib_v1.p321a.C6228l;
import expolib_v1.p321a.C6237r;
import host.exp.exponent.p334a.C6289b;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import versioned.host.exp.exponent.modules.api.av.AVModule;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.LoadCompletionListener;

class MediaPlayerData extends PlayerData implements OnBufferingUpdateListener, OnCompletionListener, OnErrorListener, OnInfoListener, OnSeekCompleteListener, OnVideoSizeChangedListener {
    static final String IMPLEMENTATION_NAME = "MediaPlayer";
    private boolean mIsBuffering = false;
    private MediaPlayer mMediaPlayer = null;
    private boolean mMediaPlayerHasStartedEver = false;
    private Integer mPlayableDurationMillis = null;
    private ReactContext mReactContext = null;

    String getImplementationName() {
        return IMPLEMENTATION_NAME;
    }

    MediaPlayerData(AVModule aVModule, ReactContext reactContext, Uri uri, Map<String, Object> map) {
        super(aVModule, uri, map);
        this.mReactContext = reactContext;
    }

    public void load(final ReadableMap readableMap, final LoadCompletionListener loadCompletionListener) {
        StringBuilder stringBuilder;
        if (this.mMediaPlayer != null) {
            loadCompletionListener.onLoadError("Load encountered an error: MediaPlayerData cannot be loaded twice.");
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            if (VERSION.SDK_INT >= 26) {
                mediaPlayer.setDataSource(this.mAVModule.mScopedContext, this.mUri, null, getHttpCookiesList());
            } else {
                Map hashMap = new HashMap(1);
                StringBuilder stringBuilder2 = new StringBuilder();
                for (HttpCookie httpCookie : getHttpCookiesList()) {
                    stringBuilder2.append(httpCookie.getName());
                    stringBuilder2.append("=");
                    stringBuilder2.append(httpCookie.getValue());
                    stringBuilder2.append("; ");
                }
                stringBuilder2.append("\r\n");
                hashMap.put("Cookie", stringBuilder2.toString());
                if (this.mRequestHeaders != null) {
                    for (Entry entry : this.mRequestHeaders.entrySet()) {
                        if (entry.getValue() instanceof String) {
                            hashMap.put(entry.getKey(), (String) entry.getValue());
                        }
                    }
                }
                mediaPlayer.setDataSource(this.mAVModule.mScopedContext, this.mUri, hashMap);
            }
            mediaPlayer.setOnErrorListener(new OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    mediaPlayer = loadCompletionListener;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Load encountered an error: the OnErrorListener was called with 'what' code ");
                    stringBuilder.append(i);
                    stringBuilder.append(" and 'extra' code ");
                    stringBuilder.append(i2);
                    stringBuilder.append(".");
                    mediaPlayer.onLoadError(stringBuilder.toString());
                    return true;
                }
            });
            mediaPlayer.setOnPreparedListener(new OnPreparedListener() {

                /* renamed from: versioned.host.exp.exponent.modules.api.av.player.MediaPlayerData$2$1 */
                class C77611 implements SetStatusCompletionListener {
                    C77611() {
                    }

                    public void onSetStatusComplete() {
                        loadCompletionListener.onLoadSuccess(MediaPlayerData.this.getStatus());
                    }

                    public void onSetStatusError(String str) {
                        loadCompletionListener.onLoadSuccess(MediaPlayerData.this.getStatus());
                    }
                }

                public void onPrepared(MediaPlayer mediaPlayer) {
                    MediaPlayerData.this.mMediaPlayer = mediaPlayer;
                    MediaPlayerData.this.mMediaPlayer.setOnBufferingUpdateListener(MediaPlayerData.this);
                    MediaPlayerData.this.mMediaPlayer.setOnCompletionListener(MediaPlayerData.this);
                    MediaPlayerData.this.mMediaPlayer.setOnErrorListener(MediaPlayerData.this);
                    MediaPlayerData.this.mMediaPlayer.setOnInfoListener(MediaPlayerData.this);
                    MediaPlayerData.this.setStatusWithListener(readableMap, new C77611());
                }
            });
            try {
                mediaPlayer.prepareAsync();
            } catch (ReadableMap readableMap2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Load encountered an error: an exception was thrown from prepareAsync() with message: ");
                stringBuilder.append(readableMap2.toString());
                loadCompletionListener.onLoadError(stringBuilder.toString());
            }
        } catch (ReadableMap readableMap22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Load encountered an error: setDataSource() threw an exception was thrown with message: ");
            stringBuilder.append(readableMap22.toString());
            loadCompletionListener.onLoadError(stringBuilder.toString());
        }
    }

    public synchronized void release() {
        stopUpdatingProgressIfNecessary();
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnBufferingUpdateListener(null);
            this.mMediaPlayer.setOnCompletionListener(null);
            this.mMediaPlayer.setOnErrorListener(null);
            this.mMediaPlayer.setOnInfoListener(null);
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    boolean shouldContinueUpdatingProgress() {
        return (this.mMediaPlayer == null || this.mIsBuffering) ? false : true;
    }

    private void playMediaPlayerWithRateMAndHigher(float f) {
        PlaybackParams playbackParams = this.mMediaPlayer.getPlaybackParams();
        playbackParams.setPitch(this.mShouldCorrectPitch ? 1.0f : f);
        playbackParams.setSpeed(f);
        playbackParams.setAudioFallbackMode(0.0f);
        this.mMediaPlayer.setPlaybackParams(playbackParams);
        this.mMediaPlayer.start();
    }

    void playPlayerWithRateAndMuteIfNecessary() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.mMediaPlayer;
        if (r0 == 0) goto L_0x0088;
    L_0x0004:
        r0 = r6.shouldPlayerPlay();
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        goto L_0x0088;
    L_0x000c:
        r0 = r6.mIsMuted;
        if (r0 != 0) goto L_0x0015;
    L_0x0010:
        r0 = r6.mAVModule;
        r0.acquireAudioFocus();
    L_0x0015:
        r6.updateVolumeMuteAndDuck();
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 23;
        r2 = 1;
        if (r0 >= r1) goto L_0x002f;
    L_0x001f:
        r0 = r6.mMediaPlayer;
        r0 = r0.isPlaying();
        if (r0 != 0) goto L_0x0084;
    L_0x0027:
        r0 = r6.mMediaPlayer;
        r0.start();
        r6.mMediaPlayerHasStartedEver = r2;
        goto L_0x0084;
    L_0x002f:
        r0 = 0;
        r3 = r6.mMediaPlayer;	 Catch:{ Throwable -> 0x0052 }
        r3 = r3.getPlaybackParams();	 Catch:{ Throwable -> 0x0052 }
        r4 = r3.getSpeed();	 Catch:{ Throwable -> 0x0052 }
        r3 = r3.getPitch();	 Catch:{ Throwable -> 0x0052 }
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;	 Catch:{ Throwable -> 0x0052 }
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ Throwable -> 0x0052 }
        if (r3 != 0) goto L_0x0046;	 Catch:{ Throwable -> 0x0052 }
    L_0x0044:
        r3 = 1;	 Catch:{ Throwable -> 0x0052 }
        goto L_0x0047;	 Catch:{ Throwable -> 0x0052 }
    L_0x0046:
        r3 = 0;	 Catch:{ Throwable -> 0x0052 }
    L_0x0047:
        r5 = r6.mRate;	 Catch:{ Throwable -> 0x0052 }
        r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));	 Catch:{ Throwable -> 0x0052 }
        if (r4 != 0) goto L_0x0052;	 Catch:{ Throwable -> 0x0052 }
    L_0x004d:
        r4 = r6.mShouldCorrectPitch;	 Catch:{ Throwable -> 0x0052 }
        if (r3 != r4) goto L_0x0052;
    L_0x0051:
        r0 = 1;
    L_0x0052:
        r3 = r6.mRate;
        r4 = 0;
        r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1));
        if (r3 == 0) goto L_0x0084;
    L_0x0059:
        r3 = r6.mMediaPlayer;
        r3 = r3.isPlaying();
        if (r3 == 0) goto L_0x0063;
    L_0x0061:
        if (r0 != 0) goto L_0x0084;
    L_0x0063:
        r0 = android.os.Build.VERSION.SDK_INT;
        r3 = 24;
        if (r0 < r3) goto L_0x006f;
    L_0x0069:
        r0 = r6.mRate;
        r6.playMediaPlayerWithRateMAndHigher(r0);
        goto L_0x0082;
    L_0x006f:
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 < r1) goto L_0x0082;
    L_0x0073:
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6.playMediaPlayerWithRateMAndHigher(r0);
        r0 = r6.mMediaPlayer;
        r0.pause();
        r0 = r6.mRate;
        r6.playMediaPlayerWithRateMAndHigher(r0);
    L_0x0082:
        r6.mMediaPlayerHasStartedEver = r2;
    L_0x0084:
        r6.beginUpdatingProgressIfNecessary();
        return;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.player.MediaPlayerData.playPlayerWithRateAndMuteIfNecessary():void");
    }

    void applyNewStatus(Integer num, Boolean bool) {
        if (this.mMediaPlayer != null) {
            if (VERSION.SDK_INT < 23 && this.mRate != 1.0f) {
                C6289b.m25952b("Expo MediaPlayerData", "Cannot set audio/video playback rate for Android SDK < 23.");
                this.mRate = 1.0f;
            }
            if (bool != null) {
                this.mMediaPlayer.setLooping(bool.booleanValue());
            }
            if (shouldPlayerPlay() == null) {
                if (this.mMediaPlayerHasStartedEver != null) {
                    this.mMediaPlayer.pause();
                }
                stopUpdatingProgressIfNecessary();
            }
            updateVolumeMuteAndDuck();
            if (!(num == null || num.intValue() == this.mMediaPlayer.getCurrentPosition())) {
                this.mMediaPlayer.seekTo(num.intValue());
            }
            playPlayerWithRateAndMuteIfNecessary();
            return;
        }
        throw new IllegalStateException("mMediaPlayer is null!");
    }

    boolean isLoaded() {
        return this.mMediaPlayer != null;
    }

    void getExtraStatusFields(WritableMap writableMap) {
        Integer valueOf = Integer.valueOf(this.mMediaPlayer.getDuration());
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            writableMap.putInt("durationMillis", valueOf.intValue());
        }
        writableMap.putInt("positionMillis", getClippedIntegerForValue(Integer.valueOf(this.mMediaPlayer.getCurrentPosition()), Integer.valueOf(0), valueOf));
        if (this.mPlayableDurationMillis != null) {
            writableMap.putInt("playableDurationMillis", getClippedIntegerForValue(this.mPlayableDurationMillis, Integer.valueOf(0), valueOf));
        }
        writableMap.putBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH, this.mMediaPlayer.isPlaying());
        writableMap.putBoolean("isBuffering", this.mIsBuffering);
        writableMap.putBoolean("isLooping", this.mMediaPlayer.isLooping());
    }

    public Pair<Integer, Integer> getVideoWidthHeight() {
        return this.mMediaPlayer == null ? new Pair(Integer.valueOf(0), Integer.valueOf(0)) : new Pair(Integer.valueOf(this.mMediaPlayer.getVideoWidth()), Integer.valueOf(this.mMediaPlayer.getVideoHeight()));
    }

    public void tryUpdateVideoSurface(Surface surface) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setSurface(surface);
            if (this.mMediaPlayerHasStartedEver == null && this.mShouldPlay == null) {
                this.mMediaPlayer.start();
                this.mMediaPlayer.pause();
                this.mMediaPlayerHasStartedEver = true;
            }
        }
    }

    public int getAudioSessionId() {
        return this.mMediaPlayer != null ? this.mMediaPlayer.getAudioSessionId() : 0;
    }

    public void pauseImmediately() {
        if (this.mMediaPlayer != null && this.mMediaPlayerHasStartedEver) {
            this.mMediaPlayer.pause();
        }
        stopUpdatingProgressIfNecessary();
    }

    public boolean requiresAudioFocus() {
        return this.mMediaPlayer != null && ((this.mMediaPlayer.isPlaying() || shouldPlayerPlay()) && !this.mIsMuted);
    }

    public void updateVolumeMuteAndDuck() {
        if (this.mMediaPlayer != null) {
            float volumeForDuckAndFocus = this.mAVModule.getVolumeForDuckAndFocus(this.mIsMuted, this.mVolume);
            this.mMediaPlayer.setVolume(volumeForDuckAndFocus, volumeForDuckAndFocus);
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (mediaPlayer.getDuration() >= 0) {
            this.mPlayableDurationMillis = Integer.valueOf((int) (((double) mediaPlayer.getDuration()) * (((double) i) / 100.0d)));
        } else {
            this.mPlayableDurationMillis = null;
        }
        callStatusUpdateListener();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        callStatusUpdateListenerWithDidJustFinish();
        if (mediaPlayer.isLooping() == null) {
            this.mAVModule.abandonAudioFocusIfUnused();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        release();
        if (this.mErrorListener != null) {
            mediaPlayer = this.mErrorListener;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MediaPlayer failed with 'what' code ");
            stringBuilder.append(i);
            stringBuilder.append(" and 'extra' code ");
            stringBuilder.append(i2);
            stringBuilder.append(".");
            mediaPlayer.onError(stringBuilder.toString());
        }
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        switch (i) {
            case 1:
            case 800:
            case 801:
            case 802:
            case 901:
            case 902:
                break;
            case 3:
                if (this.mVideoSizeUpdateListener != 0) {
                    this.mVideoSizeUpdateListener.onVideoSizeUpdate(new Pair(Integer.valueOf(mediaPlayer.getVideoWidth()), Integer.valueOf(mediaPlayer.getVideoHeight())));
                    break;
                }
                break;
            case 701:
                this.mIsBuffering = true;
                break;
            case 702:
                this.mIsBuffering = null;
                beginUpdatingProgressIfNecessary();
                break;
            default:
                break;
        }
        callStatusUpdateListener();
        return true;
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        callStatusUpdateListener();
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.mVideoSizeUpdateListener != null) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    private List<HttpCookie> getHttpCookiesList() {
        C6237r a = C6237r.m25748a(URI.create(this.mUri.toString()));
        if (a == null) {
            return Collections.emptyList();
        }
        List<C6228l> loadForRequest = ((NetworkingModule) this.mReactContext.getNativeModule(NetworkingModule.class)).mCookieJarContainer.loadForRequest(a);
        List<HttpCookie> arrayList = new ArrayList(loadForRequest.size());
        for (C6228l c6228l : loadForRequest) {
            if (c6228l.m25686a(a)) {
                arrayList.add(new HttpCookie(c6228l.m25684a(), c6228l.m25687b()));
            }
        }
        return arrayList;
    }
}
