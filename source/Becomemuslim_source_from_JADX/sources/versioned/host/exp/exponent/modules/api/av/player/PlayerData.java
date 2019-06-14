package versioned.host.exp.exponent.modules.api.av.player;

import android.net.Uri;
import android.os.Handler;
import android.util.Pair;
import android.view.Surface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.stetho.server.http.HttpStatus;
import java.lang.ref.WeakReference;
import java.util.Map;
import versioned.host.exp.exponent.modules.api.av.AVModule;
import versioned.host.exp.exponent.modules.api.av.AudioEventHandler;

public abstract class PlayerData implements AudioEventHandler {
    static final String STATUS_ANDROID_IMPLEMENTATION_KEY_PATH = "androidImplementation";
    static final String STATUS_DID_JUST_FINISH_KEY_PATH = "didJustFinish";
    static final String STATUS_DURATION_MILLIS_KEY_PATH = "durationMillis";
    static final String STATUS_HEADERS_KEY_PATH = "headers";
    static final String STATUS_IS_BUFFERING_KEY_PATH = "isBuffering";
    static final String STATUS_IS_LOADED_KEY_PATH = "isLoaded";
    static final String STATUS_IS_LOOPING_KEY_PATH = "isLooping";
    static final String STATUS_IS_MUTED_KEY_PATH = "isMuted";
    public static final String STATUS_IS_PLAYING_KEY_PATH = "isPlaying";
    static final String STATUS_OVERRIDING_EXTENSION_KEY_PATH = "overridingExtension";
    static final String STATUS_PLAYABLE_DURATION_MILLIS_KEY_PATH = "playableDurationMillis";
    static final String STATUS_POSITION_MILLIS_KEY_PATH = "positionMillis";
    static final String STATUS_PROGRESS_UPDATE_INTERVAL_MILLIS_KEY_PATH = "progressUpdateIntervalMillis";
    static final String STATUS_RATE_KEY_PATH = "rate";
    static final String STATUS_SHOULD_CORRECT_PITCH_KEY_PATH = "shouldCorrectPitch";
    static final String STATUS_SHOULD_PLAY_KEY_PATH = "shouldPlay";
    public static final String STATUS_URI_KEY_PATH = "uri";
    static final String STATUS_VOLUME_KEY_PATH = "volume";
    final AVModule mAVModule;
    ErrorListener mErrorListener = null;
    private FullscreenPresenter mFullscreenPresenter = null;
    private Handler mHandler = new Handler();
    boolean mIsMuted = false;
    private int mProgressUpdateIntervalMillis = HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
    private Runnable mProgressUpdater = new ProgressUpdater(this);
    float mRate = 1.0f;
    final Map<String, Object> mRequestHeaders;
    boolean mShouldCorrectPitch = false;
    boolean mShouldPlay = false;
    private StatusUpdateListener mStatusUpdateListener = null;
    final Uri mUri;
    VideoSizeUpdateListener mVideoSizeUpdateListener = null;
    float mVolume = 1.0f;

    public interface ErrorListener {
        void onError(String str);
    }

    public interface FullscreenPresenter {
        boolean isBeingPresentedFullscreen();

        void setFullscreenMode(boolean z);
    }

    public interface LoadCompletionListener {
        void onLoadError(String str);

        void onLoadSuccess(WritableMap writableMap);
    }

    private class ProgressUpdater implements Runnable {
        private WeakReference<PlayerData> mPlayerDataWeakReference;

        private ProgressUpdater(PlayerData playerData) {
            this.mPlayerDataWeakReference = new WeakReference(playerData);
        }

        public void run() {
            PlayerData playerData = (PlayerData) this.mPlayerDataWeakReference.get();
            if (playerData != null) {
                playerData.callStatusUpdateListener();
                playerData.progressUpdateLoop();
            }
        }
    }

    interface SetStatusCompletionListener {
        void onSetStatusComplete();

        void onSetStatusError(String str);
    }

    public interface StatusUpdateListener {
        void onStatusUpdate(WritableMap writableMap);
    }

    public interface VideoSizeUpdateListener {
        void onVideoSizeUpdate(Pair<Integer, Integer> pair);
    }

    abstract void applyNewStatus(Integer num, Boolean bool);

    abstract int getAudioSessionId();

    abstract void getExtraStatusFields(WritableMap writableMap);

    abstract String getImplementationName();

    public abstract Pair<Integer, Integer> getVideoWidthHeight();

    abstract boolean isLoaded();

    public abstract void load(ReadableMap readableMap, LoadCompletionListener loadCompletionListener);

    abstract void playPlayerWithRateAndMuteIfNecessary();

    public abstract void release();

    abstract boolean shouldContinueUpdatingProgress();

    public abstract void tryUpdateVideoSurface(Surface surface);

    public static WritableMap getUnloadedStatus() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean(STATUS_IS_LOADED_KEY_PATH, false);
        return createMap;
    }

    PlayerData(AVModule aVModule, Uri uri, Map<String, Object> map) {
        this.mRequestHeaders = map;
        this.mAVModule = aVModule;
        this.mUri = uri;
    }

    public static PlayerData createUnloadedPlayerData(AVModule aVModule, ReactContext reactContext, ReadableMap readableMap, ReadableMap readableMap2) {
        String string = readableMap.getString("uri");
        String str = null;
        Map toHashMap = readableMap.hasKey(STATUS_HEADERS_KEY_PATH) ? readableMap.getMap(STATUS_HEADERS_KEY_PATH).toHashMap() : null;
        if (readableMap.hasKey(STATUS_OVERRIDING_EXTENSION_KEY_PATH)) {
            str = readableMap.getString(STATUS_OVERRIDING_EXTENSION_KEY_PATH);
        }
        String str2 = str;
        Uri parse = Uri.parse(string);
        if (readableMap2.hasKey(STATUS_ANDROID_IMPLEMENTATION_KEY_PATH) == null || readableMap2.getString(STATUS_ANDROID_IMPLEMENTATION_KEY_PATH).equals("MediaPlayer") == null) {
            return new SimpleExoPlayerData(aVModule, reactContext, parse, str2, toHashMap);
        }
        return new MediaPlayerData(aVModule, reactContext, parse, toHashMap);
    }

    private void callStatusUpdateListenerWithStatus(WritableMap writableMap) {
        if (this.mStatusUpdateListener != null) {
            this.mStatusUpdateListener.onStatusUpdate(writableMap);
        }
    }

    final void callStatusUpdateListenerWithDidJustFinish() {
        WritableMap status = getStatus();
        status.putBoolean(STATUS_DID_JUST_FINISH_KEY_PATH, true);
        callStatusUpdateListenerWithStatus(status);
    }

    final void callStatusUpdateListener() {
        callStatusUpdateListenerWithStatus(getStatus());
    }

    final void stopUpdatingProgressIfNecessary() {
        this.mHandler.removeCallbacks(this.mProgressUpdater);
    }

    private void progressUpdateLoop() {
        if (shouldContinueUpdatingProgress()) {
            this.mHandler.postDelayed(this.mProgressUpdater, (long) this.mProgressUpdateIntervalMillis);
        } else {
            stopUpdatingProgressIfNecessary();
        }
    }

    final void beginUpdatingProgressIfNecessary() {
        this.mHandler.post(this.mProgressUpdater);
    }

    public final void setStatusUpdateListener(StatusUpdateListener statusUpdateListener) {
        this.mStatusUpdateListener = statusUpdateListener;
        if (this.mStatusUpdateListener != null) {
            beginUpdatingProgressIfNecessary();
        }
    }

    public final void setErrorListener(ErrorListener errorListener) {
        this.mErrorListener = errorListener;
    }

    final boolean shouldPlayerPlay() {
        return this.mShouldPlay && ((double) this.mRate) > 0.0d;
    }

    final void setStatusWithListener(ReadableMap readableMap, SetStatusCompletionListener setStatusCompletionListener) {
        if (readableMap.hasKey(STATUS_PROGRESS_UPDATE_INTERVAL_MILLIS_KEY_PATH)) {
            this.mProgressUpdateIntervalMillis = (int) readableMap.getDouble(STATUS_PROGRESS_UPDATE_INTERVAL_MILLIS_KEY_PATH);
        }
        Boolean bool = null;
        Integer valueOf = readableMap.hasKey(STATUS_POSITION_MILLIS_KEY_PATH) ? Integer.valueOf((int) readableMap.getDouble(STATUS_POSITION_MILLIS_KEY_PATH)) : null;
        if (readableMap.hasKey(STATUS_SHOULD_PLAY_KEY_PATH)) {
            this.mShouldPlay = readableMap.getBoolean(STATUS_SHOULD_PLAY_KEY_PATH);
        }
        if (readableMap.hasKey(STATUS_RATE_KEY_PATH)) {
            this.mRate = (float) readableMap.getDouble(STATUS_RATE_KEY_PATH);
        }
        if (readableMap.hasKey(STATUS_SHOULD_CORRECT_PITCH_KEY_PATH)) {
            this.mShouldCorrectPitch = readableMap.getBoolean(STATUS_SHOULD_CORRECT_PITCH_KEY_PATH);
        }
        if (readableMap.hasKey(STATUS_VOLUME_KEY_PATH)) {
            this.mVolume = (float) readableMap.getDouble(STATUS_VOLUME_KEY_PATH);
        }
        if (readableMap.hasKey(STATUS_IS_MUTED_KEY_PATH)) {
            this.mIsMuted = readableMap.getBoolean(STATUS_IS_MUTED_KEY_PATH);
        }
        if (readableMap.hasKey(STATUS_IS_LOOPING_KEY_PATH)) {
            bool = Boolean.valueOf(readableMap.getBoolean(STATUS_IS_LOOPING_KEY_PATH));
        }
        try {
            applyNewStatus(valueOf, bool);
            this.mAVModule.abandonAudioFocusIfUnused();
            setStatusCompletionListener.onSetStatusComplete();
        } catch (ReadableMap readableMap2) {
            this.mAVModule.abandonAudioFocusIfUnused();
            setStatusCompletionListener.onSetStatusError(readableMap2.toString());
        }
    }

    public final void setStatus(ReadableMap readableMap, final Promise promise) {
        if (readableMap == null) {
            if (promise != null) {
                promise.reject("E_AV_SETSTATUS", "Cannot set null status.");
            }
            return;
        }
        try {
            setStatusWithListener(readableMap, new SetStatusCompletionListener() {
                public void onSetStatusComplete() {
                    if (promise == null) {
                        PlayerData.this.callStatusUpdateListener();
                    } else {
                        promise.resolve(PlayerData.this.getStatus());
                    }
                }

                public void onSetStatusError(String str) {
                    if (promise == null) {
                        PlayerData.this.callStatusUpdateListener();
                    } else {
                        promise.reject("E_AV_SETSTATUS", str);
                    }
                }
            });
        } catch (ReadableMap readableMap2) {
            if (promise != null) {
                promise.reject("E_AV_SETSTATUS", "Encountered an error while setting status!", readableMap2);
            }
        }
    }

    final int getClippedIntegerForValue(Integer num, Integer num2, Integer num3) {
        if (num2 != null && num.intValue() < num2.intValue()) {
            num = num2;
        } else if (num3 != null && num.intValue() > num3.intValue()) {
            num = num3;
        }
        return num.intValue();
    }

    public final synchronized WritableMap getStatus() {
        if (isLoaded()) {
            WritableMap createMap = Arguments.createMap();
            createMap.putBoolean(STATUS_IS_LOADED_KEY_PATH, true);
            createMap.putString(STATUS_ANDROID_IMPLEMENTATION_KEY_PATH, getImplementationName());
            createMap.putString("uri", this.mUri.getPath());
            createMap.putInt(STATUS_PROGRESS_UPDATE_INTERVAL_MILLIS_KEY_PATH, this.mProgressUpdateIntervalMillis);
            createMap.putBoolean(STATUS_SHOULD_PLAY_KEY_PATH, this.mShouldPlay);
            createMap.putDouble(STATUS_RATE_KEY_PATH, (double) this.mRate);
            createMap.putBoolean(STATUS_SHOULD_CORRECT_PITCH_KEY_PATH, this.mShouldCorrectPitch);
            createMap.putDouble(STATUS_VOLUME_KEY_PATH, (double) this.mVolume);
            createMap.putBoolean(STATUS_IS_MUTED_KEY_PATH, this.mIsMuted);
            createMap.putBoolean(STATUS_DID_JUST_FINISH_KEY_PATH, false);
            getExtraStatusFields(createMap);
            return createMap;
        }
        createMap = getUnloadedStatus();
        createMap.putString(STATUS_ANDROID_IMPLEMENTATION_KEY_PATH, getImplementationName());
        return createMap;
    }

    public final void setVideoSizeUpdateListener(VideoSizeUpdateListener videoSizeUpdateListener) {
        this.mVideoSizeUpdateListener = videoSizeUpdateListener;
    }

    public final void setFullscreenPresenter(FullscreenPresenter fullscreenPresenter) {
        this.mFullscreenPresenter = fullscreenPresenter;
    }

    public boolean isPresentedFullscreen() {
        return this.mFullscreenPresenter.isBeingPresentedFullscreen();
    }

    public void toggleFullscreen() {
        this.mFullscreenPresenter.setFullscreenMode(isPresentedFullscreen() ^ 1);
    }

    public final void handleAudioFocusInterruptionBegan() {
        if (!this.mIsMuted) {
            pauseImmediately();
        }
    }

    public final void handleAudioFocusGained() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r0.playPlayerWithRateAndMuteIfNecessary();	 Catch:{ AudioFocusNotAcquiredException -> 0x0003 }
    L_0x0003:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.player.PlayerData.handleAudioFocusGained():void");
    }

    public final void onPause() {
        pauseImmediately();
    }

    public final void onResume() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r0.playPlayerWithRateAndMuteIfNecessary();	 Catch:{ AudioFocusNotAcquiredException -> 0x0003 }
    L_0x0003:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.player.PlayerData.onResume():void");
    }
}
