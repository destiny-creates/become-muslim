package versioned.host.exp.exponent.modules.api.av;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Build.VERSION;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.SystemClock;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p346j.C6393j;
import host.exp.p333a.C6271b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import versioned.host.exp.exponent.modules.ExpoKernelServiceConsumerBaseModule;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.ErrorListener;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.LoadCompletionListener;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.StatusUpdateListener;
import versioned.host.exp.exponent.modules.api.av.video.VideoView;

public class AVModule extends ExpoKernelServiceConsumerBaseModule implements OnAudioFocusChangeListener, OnInfoListener, LifecycleEventListener {
    private static final String AUDIO_MODE_INTERRUPTION_MODE_KEY = "interruptionModeAndroid";
    private static final String AUDIO_MODE_PLAY_THROUGH_EARPIECE = "playThroughEarpieceAndroid";
    private static final String AUDIO_MODE_SHOULD_DUCK_KEY = "shouldDuckAndroid";
    private static final String RECORDING_OPTIONS_KEY = "android";
    private static final String RECORDING_OPTION_AUDIO_ENCODER_KEY = "audioEncoder";
    private static final String RECORDING_OPTION_BIT_RATE_KEY = "bitRate";
    private static final String RECORDING_OPTION_EXTENSION_KEY = "extension";
    private static final String RECORDING_OPTION_MAX_FILE_SIZE_KEY = "maxFileSize";
    private static final String RECORDING_OPTION_NUMBER_OF_CHANNELS_KEY = "numberOfChannels";
    private static final String RECORDING_OPTION_OUTPUT_FORMAT_KEY = "outputFormat";
    private static final String RECORDING_OPTION_SAMPLE_RATE_KEY = "sampleRate";
    private boolean mAcquiredAudioFocus = false;
    private boolean mAppIsPaused = false;
    private AudioInterruptionMode mAudioInterruptionMode = AudioInterruptionMode.DUCK_OTHERS;
    private final AudioManager mAudioManager;
    private MediaRecorder mAudioRecorder = null;
    private long mAudioRecorderDurationAlreadyRecorded = 0;
    private boolean mAudioRecorderIsPaused = false;
    private boolean mAudioRecorderIsRecording = false;
    private Callback mAudioRecorderUnloadedCallback = null;
    private long mAudioRecorderUptimeOfLastStartResume = 0;
    private String mAudioRecordingFilePath = null;
    private boolean mEnabled = true;
    private boolean mIsDuckingAudio = false;
    private final BroadcastReceiver mNoisyAudioStreamReceiver;
    private final ReactApplicationContext mReactApplicationContext;
    public final C6393j mScopedContext;
    private boolean mShouldDuckAudio = true;
    private boolean mShouldRouteThroughEarpiece = false;
    private final Map<Integer, PlayerData> mSoundMap = new HashMap();
    private int mSoundMapKeyCount = 0;
    private final Set<VideoView> mVideoViewSet = new HashSet();

    /* renamed from: versioned.host.exp.exponent.modules.api.av.AVModule$1 */
    class C67211 extends BroadcastReceiver {
        C67211() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction()) != null) {
                AVModule.this.abandonAudioFocus();
            }
        }
    }

    public class AudioFocusNotAcquiredException extends Exception {
        AudioFocusNotAcquiredException(String str) {
            super(str);
        }
    }

    private enum AudioInterruptionMode {
        DO_NOT_MIX,
        DUCK_OTHERS
    }

    private interface VideoViewCallback {
        void runWithVideoView(VideoView videoView);
    }

    public String getName() {
        return "ExponentAV";
    }

    public AVModule(ReactApplicationContext reactApplicationContext, C6393j c6393j, C6330b c6330b) {
        super(reactApplicationContext, c6330b);
        this.mScopedContext = c6393j;
        this.mReactApplicationContext = reactApplicationContext;
        this.mAudioManager = (AudioManager) this.mScopedContext.getSystemService("audio");
        this.mNoisyAudioStreamReceiver = new C67211();
        this.mReactApplicationContext.registerReceiver(this.mNoisyAudioStreamReceiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        this.mReactApplicationContext.addLifecycleEventListener(this);
    }

    private void sendEvent(String str, WritableMap writableMap) {
        ((RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public void onHostResume() {
        if (this.mAppIsPaused) {
            this.mAppIsPaused = false;
            for (AudioEventHandler onResume : getAllRegisteredAudioEventHandlers()) {
                onResume.onResume();
            }
            if (this.mShouldRouteThroughEarpiece) {
                updatePlaySoundThroughEarpiece(true);
            }
        }
    }

    public void onHostPause() {
        if (!this.mAppIsPaused) {
            this.mAppIsPaused = true;
            for (AudioEventHandler onPause : getAllRegisteredAudioEventHandlers()) {
                onPause.onPause();
            }
            abandonAudioFocus();
            if (this.mShouldRouteThroughEarpiece) {
                updatePlaySoundThroughEarpiece(false);
            }
        }
    }

    public void onHostDestroy() {
        this.mReactApplicationContext.unregisterReceiver(this.mNoisyAudioStreamReceiver);
        for (Integer removeSoundForKey : this.mSoundMap.keySet()) {
            removeSoundForKey(removeSoundForKey);
        }
        for (VideoView unloadPlayerAndMediaController : this.mVideoViewSet) {
            unloadPlayerAndMediaController.unloadPlayerAndMediaController();
        }
        removeAudioRecorder();
        abandonAudioFocus();
    }

    public void registerVideoViewForAudioLifecycle(VideoView videoView) {
        this.mVideoViewSet.add(videoView);
    }

    public void unregisterVideoViewForAudioLifecycle(VideoView videoView) {
        this.mVideoViewSet.remove(videoView);
    }

    private Set<AudioEventHandler> getAllRegisteredAudioEventHandlers() {
        Set<AudioEventHandler> hashSet = new HashSet();
        hashSet.addAll(this.mVideoViewSet);
        hashSet.addAll(this.mSoundMap.values());
        return hashSet;
    }

    public void onAudioFocusChange(int i) {
        if (i != 1) {
            switch (i) {
                case ProfilePictureView.NORMAL /*-3*/:
                    if (this.mShouldDuckAudio != 0) {
                        this.mIsDuckingAudio = true;
                        this.mAcquiredAudioFocus = true;
                        updateDuckStatusForAllPlayersPlaying();
                        return;
                    }
                    break;
                case -2:
                case -1:
                    break;
                default:
                    return;
            }
            this.mIsDuckingAudio = false;
            this.mAcquiredAudioFocus = false;
            for (AudioEventHandler handleAudioFocusInterruptionBegan : getAllRegisteredAudioEventHandlers()) {
                handleAudioFocusInterruptionBegan.handleAudioFocusInterruptionBegan();
            }
            return;
        }
        this.mIsDuckingAudio = false;
        this.mAcquiredAudioFocus = true;
        for (AudioEventHandler handleAudioFocusInterruptionBegan2 : getAllRegisteredAudioEventHandlers()) {
            handleAudioFocusInterruptionBegan2.handleAudioFocusGained();
        }
    }

    public void acquireAudioFocus() {
        if (!this.mEnabled) {
            throw new AudioFocusNotAcquiredException("Expo Audio is disabled, so audio focus could not be acquired.");
        } else if (this.mAppIsPaused) {
            throw new AudioFocusNotAcquiredException("This experience is currently in the background, so audio focus could not be acquired.");
        } else if (!this.mAcquiredAudioFocus) {
            boolean z = true;
            if (this.mAudioManager.requestAudioFocus(this, 3, this.mAudioInterruptionMode == AudioInterruptionMode.DO_NOT_MIX ? 1 : 3) != 1) {
                z = false;
            }
            this.mAcquiredAudioFocus = z;
            if (!this.mAcquiredAudioFocus) {
                throw new AudioFocusNotAcquiredException("Audio focus could not be acquired from the OS at this time.");
            }
        }
    }

    private void abandonAudioFocus() {
        for (AudioEventHandler audioEventHandler : getAllRegisteredAudioEventHandlers()) {
            if (audioEventHandler.requiresAudioFocus()) {
                audioEventHandler.pauseImmediately();
            }
        }
        this.mAcquiredAudioFocus = false;
        this.mAudioManager.abandonAudioFocus(this);
    }

    public void abandonAudioFocusIfUnused() {
        for (AudioEventHandler requiresAudioFocus : getAllRegisteredAudioEventHandlers()) {
            if (requiresAudioFocus.requiresAudioFocus()) {
                return;
            }
        }
        abandonAudioFocus();
    }

    public float getVolumeForDuckAndFocus(boolean z, float f) {
        if (this.mAcquiredAudioFocus) {
            if (!z) {
                return this.mIsDuckingAudio ? f / true : f;
            }
        }
        return 0.0f;
    }

    private void updateDuckStatusForAllPlayersPlaying() {
        for (AudioEventHandler updateVolumeMuteAndDuck : getAllRegisteredAudioEventHandlers()) {
            updateVolumeMuteAndDuck.updateVolumeMuteAndDuck();
        }
    }

    private void updatePlaySoundThroughEarpiece(boolean z) {
        this.mAudioManager.setMode(z ? 3 : 0);
        this.mAudioManager.setSpeakerphoneOn(z ^ 1);
    }

    @ReactMethod
    public void setAudioIsEnabled(Boolean bool, Promise promise) {
        this.mEnabled = bool.booleanValue();
        if (bool.booleanValue() == null) {
            abandonAudioFocus();
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void setAudioMode(ReadableMap readableMap, Promise promise) {
        this.mShouldDuckAudio = readableMap.getBoolean(AUDIO_MODE_SHOULD_DUCK_KEY);
        if (!this.mShouldDuckAudio) {
            this.mIsDuckingAudio = false;
            updateDuckStatusForAllPlayersPlaying();
        }
        if (readableMap.hasKey(AUDIO_MODE_PLAY_THROUGH_EARPIECE)) {
            this.mShouldRouteThroughEarpiece = readableMap.getBoolean(AUDIO_MODE_PLAY_THROUGH_EARPIECE);
            updatePlaySoundThroughEarpiece(this.mShouldRouteThroughEarpiece);
        }
        if (readableMap.getInt(AUDIO_MODE_INTERRUPTION_MODE_KEY) == 1) {
            this.mAudioInterruptionMode = AudioInterruptionMode.DO_NOT_MIX;
        }
        this.mAudioInterruptionMode = AudioInterruptionMode.DUCK_OTHERS;
        promise.resolve(null);
    }

    private PlayerData tryGetSoundForKey(Integer num, Promise promise) {
        PlayerData playerData = (PlayerData) this.mSoundMap.get(num);
        if (playerData == null && promise != null) {
            promise.reject("E_AUDIO_NOPLAYER", "Player does not exist.");
        }
        return playerData;
    }

    private void removeSoundForKey(Integer num) {
        PlayerData playerData = (PlayerData) this.mSoundMap.remove(num);
        if (playerData != null) {
            playerData.release();
            abandonAudioFocusIfUnused();
        }
    }

    @ReactMethod
    public void loadForSound(ReadableMap readableMap, ReadableMap readableMap2, final Callback callback, final Callback callback2) {
        final int i = this.mSoundMapKeyCount;
        this.mSoundMapKeyCount = i + 1;
        readableMap = PlayerData.createUnloadedPlayerData(this, this.mReactApplicationContext, readableMap, readableMap2);
        readableMap.setErrorListener(new ErrorListener() {
            public void onError(String str) {
                AVModule.this.removeSoundForKey(Integer.valueOf(i));
            }
        });
        this.mSoundMap.put(Integer.valueOf(i), readableMap);
        readableMap.load(readableMap2, new LoadCompletionListener() {
            public void onLoadSuccess(WritableMap writableMap) {
                callback.invoke(new Object[]{Integer.valueOf(i), writableMap});
            }

            public void onLoadError(String str) {
                AVModule.this.mSoundMap.remove(Integer.valueOf(i));
                callback2.invoke(new Object[]{str});
            }
        });
        readableMap.setStatusUpdateListener(new StatusUpdateListener() {
            public void onStatusUpdate(WritableMap writableMap) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("key", i);
                createMap.putMap(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, writableMap);
                AVModule.this.sendEvent("didUpdatePlaybackStatus", createMap);
            }
        });
    }

    @ReactMethod
    public void unloadForSound(Integer num, Promise promise) {
        if (tryGetSoundForKey(num, promise) != null) {
            removeSoundForKey(num);
            promise.resolve(PlayerData.getUnloadedStatus());
        }
    }

    @ReactMethod
    public void setStatusForSound(Integer num, ReadableMap readableMap, Promise promise) {
        num = tryGetSoundForKey(num, promise);
        if (num != null) {
            num.setStatus(readableMap, promise);
        }
    }

    @ReactMethod
    public void replaySound(Integer num, ReadableMap readableMap, Promise promise) {
        num = tryGetSoundForKey(num, promise);
        if (num != null) {
            num.setStatus(readableMap, promise);
        }
    }

    @ReactMethod
    public void getStatusForSound(Integer num, Promise promise) {
        num = tryGetSoundForKey(num, promise);
        if (num != null) {
            promise.resolve(num.getStatus());
        }
    }

    @ReactMethod
    public void setErrorCallbackForSound(final Integer num, final Callback callback) {
        final PlayerData tryGetSoundForKey = tryGetSoundForKey(num, null);
        if (tryGetSoundForKey != null) {
            tryGetSoundForKey.setErrorListener(new ErrorListener() {
                public void onError(String str) {
                    tryGetSoundForKey.setErrorListener(null);
                    AVModule.this.removeSoundForKey(num);
                    callback.invoke(new Object[]{str});
                }
            });
        }
    }

    private void tryRunWithVideoView(final Integer num, final VideoViewCallback videoViewCallback, final Promise promise) {
        ((UIManagerModule) this.mReactApplicationContext.getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(com.facebook.react.uimanager.NativeViewHierarchyManager r3) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r2 = this;
                r0 = r3;	 Catch:{ Throwable -> 0x0020 }
                r0 = r0.intValue();	 Catch:{ Throwable -> 0x0020 }
                r3 = r3.resolveView(r0);	 Catch:{ Throwable -> 0x0020 }
                r0 = r3 instanceof versioned.host.exp.exponent.modules.api.av.video.VideoViewWrapper;	 Catch:{ Throwable -> 0x0020 }
                if (r0 == 0) goto L_0x001a;	 Catch:{ Throwable -> 0x0020 }
            L_0x000e:
                r3 = (versioned.host.exp.exponent.modules.api.av.video.VideoViewWrapper) r3;	 Catch:{ Throwable -> 0x0020 }
                r0 = r4;
                r3 = r3.getVideoViewInstance();
                r0.runWithVideoView(r3);
                return;
            L_0x001a:
                r3 = new java.lang.Exception;	 Catch:{ Throwable -> 0x0020 }
                r3.<init>();	 Catch:{ Throwable -> 0x0020 }
                throw r3;	 Catch:{ Throwable -> 0x0020 }
            L_0x0020:
                r3 = r5;
                r0 = "E_VIDEO_TAGINCORRECT";
                r1 = "Invalid view returned from registry.";
                r3.reject(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.AVModule.6.execute(com.facebook.react.uimanager.NativeViewHierarchyManager):void");
            }
        });
    }

    @ReactMethod
    public void loadForVideo(Integer num, final ReadableMap readableMap, final ReadableMap readableMap2, final Promise promise) {
        tryRunWithVideoView(num, new VideoViewCallback() {
            public void runWithVideoView(VideoView videoView) {
                videoView.setSource(readableMap, readableMap2, promise);
            }
        }, promise);
    }

    @ReactMethod
    public void unloadForVideo(Integer num, final Promise promise) {
        tryRunWithVideoView(num, new VideoViewCallback() {
            public void runWithVideoView(VideoView videoView) {
                videoView.setSource(null, null, promise);
            }
        }, promise);
    }

    @ReactMethod
    public void setStatusForVideo(Integer num, final ReadableMap readableMap, final Promise promise) {
        tryRunWithVideoView(num, new VideoViewCallback() {
            public void runWithVideoView(VideoView videoView) {
                videoView.setStatus(readableMap, promise);
            }
        }, promise);
    }

    @ReactMethod
    public void replayVideo(Integer num, final ReadableMap readableMap, final Promise promise) {
        tryRunWithVideoView(num, new VideoViewCallback() {
            public void runWithVideoView(VideoView videoView) {
                videoView.setStatus(readableMap, promise);
            }
        }, promise);
    }

    @ReactMethod
    public void getStatusForVideo(Integer num, final Promise promise) {
        tryRunWithVideoView(num, new VideoViewCallback() {
            public void runWithVideoView(VideoView videoView) {
                promise.resolve(videoView.getStatus());
            }
        }, promise);
    }

    private boolean isMissingAudioRecordingPermissions() {
        return C6271b.m25897a().m25916a("android.permission.RECORD_AUDIO", this.experienceId) ^ 1;
    }

    private boolean checkAudioRecorderExistsOrReject(Promise promise) {
        if (this.mAudioRecorder == null && promise != null) {
            promise.reject("E_AUDIO_NORECORDER", "Recorder does not exist.");
        }
        return this.mAudioRecorder != null ? true : null;
    }

    private long getAudioRecorderDurationMillis() {
        if (this.mAudioRecorder == null) {
            return 0;
        }
        long j = this.mAudioRecorderDurationAlreadyRecorded;
        if (this.mAudioRecorderIsRecording && this.mAudioRecorderUptimeOfLastStartResume > 0) {
            j += SystemClock.uptimeMillis() - this.mAudioRecorderUptimeOfLastStartResume;
        }
        return j;
    }

    private WritableMap getAudioRecorderStatus() {
        WritableMap createMap = Arguments.createMap();
        if (this.mAudioRecorder != null) {
            createMap.putBoolean("canRecord", true);
            createMap.putBoolean("isRecording", this.mAudioRecorderIsRecording);
            createMap.putInt("durationMillis", (int) getAudioRecorderDurationMillis());
        }
        return createMap;
    }

    private void removeAudioRecorder() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mAudioRecorder;
        r1 = 0;
        if (r0 == 0) goto L_0x0011;
    L_0x0005:
        r0 = r2.mAudioRecorder;	 Catch:{ RuntimeException -> 0x000a }
        r0.stop();	 Catch:{ RuntimeException -> 0x000a }
    L_0x000a:
        r0 = r2.mAudioRecorder;
        r0.release();
        r2.mAudioRecorder = r1;
    L_0x0011:
        r2.mAudioRecordingFilePath = r1;
        r0 = 0;
        r2.mAudioRecorderIsRecording = r0;
        r2.mAudioRecorderIsPaused = r0;
        r0 = 0;
        r2.mAudioRecorderDurationAlreadyRecorded = r0;
        r2.mAudioRecorderUptimeOfLastStartResume = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.AVModule.removeAudioRecorder():void");
    }

    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 801) {
            mediaRecorder = getAudioRecorderStatus();
            removeAudioRecorder();
            if (this.mAudioRecorderUnloadedCallback != 0) {
                i = this.mAudioRecorderUnloadedCallback;
                this.mAudioRecorderUnloadedCallback = 0;
                i.invoke(new Object[]{mediaRecorder});
            }
        }
    }

    @ReactMethod
    public void setUnloadedCallbackForAndroidRecording(Callback callback) {
        this.mAudioRecorderUnloadedCallback = callback;
    }

    @com.facebook.react.bridge.ReactMethod
    public void prepareAudioRecorder(com.facebook.react.bridge.ReadableMap r5, com.facebook.react.bridge.Promise r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.isMissingAudioRecordingPermissions();
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r5 = "E_MISSING_PERMISSION";
        r0 = "Missing audio recording permissions.";
        r6.reject(r5, r0);
        return;
    L_0x000e:
        r4.removeAudioRecorder();
        r0 = "android";
        r5 = r5.getMap(r0);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "recording-";
        r0.append(r1);
        r1 = java.util.UUID.randomUUID();
        r1 = r1.toString();
        r0.append(r1);
        r1 = "extension";
        r1 = r5.getString(r1);
        r0.append(r1);
        r0 = r0.toString();
        r1 = new java.io.File;	 Catch:{ IOException -> 0x0073 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0073 }
        r2.<init>();	 Catch:{ IOException -> 0x0073 }
        r3 = r4.mScopedContext;	 Catch:{ IOException -> 0x0073 }
        r3 = r3.getCacheDir();	 Catch:{ IOException -> 0x0073 }
        r2.append(r3);	 Catch:{ IOException -> 0x0073 }
        r3 = java.io.File.separator;	 Catch:{ IOException -> 0x0073 }
        r2.append(r3);	 Catch:{ IOException -> 0x0073 }
        r3 = "Audio";	 Catch:{ IOException -> 0x0073 }
        r2.append(r3);	 Catch:{ IOException -> 0x0073 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0073 }
        r1.<init>(r2);	 Catch:{ IOException -> 0x0073 }
        host.exp.exponent.p346j.C6385c.m26196c(r1);	 Catch:{ IOException -> 0x0073 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0073 }
        r2.<init>();	 Catch:{ IOException -> 0x0073 }
        r2.append(r1);	 Catch:{ IOException -> 0x0073 }
        r1 = java.io.File.separator;	 Catch:{ IOException -> 0x0073 }
        r2.append(r1);	 Catch:{ IOException -> 0x0073 }
        r2.append(r0);	 Catch:{ IOException -> 0x0073 }
        r0 = r2.toString();	 Catch:{ IOException -> 0x0073 }
        r4.mAudioRecordingFilePath = r0;	 Catch:{ IOException -> 0x0073 }
    L_0x0073:
        r0 = new android.media.MediaRecorder;
        r0.<init>();
        r4.mAudioRecorder = r0;
        r0 = r4.mAudioRecorder;
        r1 = 0;
        r0.setAudioSource(r1);
        r0 = r4.mAudioRecorder;
        r1 = "outputFormat";
        r1 = r5.getInt(r1);
        r0.setOutputFormat(r1);
        r0 = r4.mAudioRecorder;
        r1 = "audioEncoder";
        r1 = r5.getInt(r1);
        r0.setAudioEncoder(r1);
        r0 = "sampleRate";
        r0 = r5.hasKey(r0);
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r0 = r4.mAudioRecorder;
        r1 = "sampleRate";
        r1 = r5.getInt(r1);
        r0.setAudioSamplingRate(r1);
    L_0x00a9:
        r0 = "numberOfChannels";
        r0 = r5.hasKey(r0);
        if (r0 == 0) goto L_0x00bc;
    L_0x00b1:
        r0 = r4.mAudioRecorder;
        r1 = "numberOfChannels";
        r1 = r5.getInt(r1);
        r0.setAudioChannels(r1);
    L_0x00bc:
        r0 = "bitRate";
        r0 = r5.hasKey(r0);
        if (r0 == 0) goto L_0x00cf;
    L_0x00c4:
        r0 = r4.mAudioRecorder;
        r1 = "bitRate";
        r1 = r5.getInt(r1);
        r0.setAudioEncodingBitRate(r1);
    L_0x00cf:
        r0 = r4.mAudioRecorder;
        r1 = r4.mAudioRecordingFilePath;
        r0.setOutputFile(r1);
        r0 = "maxFileSize";
        r0 = r5.hasKey(r0);
        if (r0 == 0) goto L_0x00ef;
    L_0x00de:
        r0 = r4.mAudioRecorder;
        r1 = "maxFileSize";
        r5 = r5.getInt(r1);
        r1 = (long) r5;
        r0.setMaxFileSize(r1);
        r5 = r4.mAudioRecorder;
        r5.setOnInfoListener(r4);
    L_0x00ef:
        r5 = r4.mAudioRecorder;	 Catch:{ Exception -> 0x0119 }
        r5.prepare();	 Catch:{ Exception -> 0x0119 }
        r5 = com.facebook.react.bridge.Arguments.createMap();
        r0 = "uri";
        r1 = new java.io.File;
        r2 = r4.mAudioRecordingFilePath;
        r1.<init>(r2);
        r1 = android.net.Uri.fromFile(r1);
        r1 = r1.toString();
        r5.putString(r0, r1);
        r0 = "status";
        r1 = r4.getAudioRecorderStatus();
        r5.putMap(r0, r1);
        r6.resolve(r5);
        return;
    L_0x0119:
        r5 = move-exception;
        r0 = "E_AUDIO_RECORDERNOTCREATED";
        r1 = "Prepare encountered an error: recorder not prepared";
        r6.reject(r0, r1, r5);
        r4.removeAudioRecorder();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.AVModule.prepareAudioRecorder(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void startAudioRecording(Promise promise) {
        if (isMissingAudioRecordingPermissions()) {
            promise.reject("E_MISSING_PERMISSION", "Missing audio recording permissions.");
            return;
        }
        if (checkAudioRecorderExistsOrReject(promise)) {
            try {
                if (!this.mAudioRecorderIsPaused || VERSION.SDK_INT < 24) {
                    this.mAudioRecorder.start();
                } else {
                    this.mAudioRecorder.resume();
                }
                this.mAudioRecorderUptimeOfLastStartResume = SystemClock.uptimeMillis();
                this.mAudioRecorderIsRecording = true;
                this.mAudioRecorderIsPaused = false;
                promise.resolve(getAudioRecorderStatus());
            } catch (Throwable e) {
                promise.reject("E_AUDIO_RECORDING", "Start encountered an error: recording not started", e);
            }
        }
    }

    @ReactMethod
    public void pauseAudioRecording(Promise promise) {
        if (checkAudioRecorderExistsOrReject(promise)) {
            if (VERSION.SDK_INT < 24) {
                promise.reject("E_AUDIO_VERSIONINCOMPATIBLE", "Pausing an audio recording is unsupported on Android devices running SDK < 24.");
            } else {
                try {
                    this.mAudioRecorder.pause();
                    this.mAudioRecorderDurationAlreadyRecorded = getAudioRecorderDurationMillis();
                    this.mAudioRecorderIsRecording = false;
                    this.mAudioRecorderIsPaused = true;
                    promise.resolve(getAudioRecorderStatus());
                } catch (Throwable e) {
                    promise.reject("E_AUDIO_RECORDINGPAUSE", "Pause encountered an error: recording not paused", e);
                }
            }
        }
    }

    @ReactMethod
    public void stopAudioRecording(Promise promise) {
        if (checkAudioRecorderExistsOrReject(promise)) {
            try {
                this.mAudioRecorder.stop();
                this.mAudioRecorderDurationAlreadyRecorded = getAudioRecorderDurationMillis();
                this.mAudioRecorderIsRecording = false;
                this.mAudioRecorderIsPaused = false;
                promise.resolve(getAudioRecorderStatus());
            } catch (Throwable e) {
                promise.reject("E_AUDIO_RECORDINGSTOP", "Stop encountered an error: recording not stopped", e);
            }
        }
    }

    @ReactMethod
    public void getAudioRecordingStatus(Promise promise) {
        if (checkAudioRecorderExistsOrReject(promise)) {
            promise.resolve(getAudioRecorderStatus());
        }
    }

    @ReactMethod
    public void unloadAudioRecorder(Promise promise) {
        if (checkAudioRecorderExistsOrReject(promise)) {
            removeAudioRecorder();
            promise.resolve(null);
        }
    }
}
