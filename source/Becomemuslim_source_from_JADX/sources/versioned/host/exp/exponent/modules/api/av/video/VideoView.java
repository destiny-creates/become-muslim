package versioned.host.exp.exponent.modules.api.av.video;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.FrameLayout;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.p082f.p083a.C1252b;
import versioned.host.exp.exponent.modules.api.av.AVModule;
import versioned.host.exp.exponent.modules.api.av.AudioEventHandler;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.ErrorListener;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.FullscreenPresenter;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.LoadCompletionListener;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.StatusUpdateListener;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData.VideoSizeUpdateListener;
import versioned.host.exp.exponent.modules.api.av.player.PlayerDataControl;

@SuppressLint({"ViewConstructor"})
public class VideoView extends FrameLayout implements AudioEventHandler, FullscreenPresenter, FullscreenVideoPlayerPresentationChangeListener {
    private final AVModule mAVModule;
    private RCTEventEmitter mEventEmitter;
    private FullscreenVideoPlayer mFullscreenPlayer = null;
    private FullscreenVideoPlayerPresentationChangeProgressListener mFullscreenPlayerPresentationChangeProgressListener = null;
    private FullscreenVideoPlayerPresentationChangeProgressListener mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
    private boolean mIsLoaded = false;
    private MediaController mMediaController = null;
    private final Runnable mMediaControllerUpdater = new C67291();
    private Boolean mOverridingUseNativeControls = null;
    private PlayerData mPlayerData = null;
    private C1252b mResizeMode = C1252b.LEFT_TOP;
    private boolean mShouldShowFullscreenPlayerOnLoad = false;
    private WritableMap mStatusToSet = Arguments.createMap();
    private final StatusUpdateListener mStatusUpdateListener = new C77652();
    private boolean mUseNativeControls = false;
    private VideoTextureView mVideoTextureView = null;
    private VideoViewWrapper mVideoViewWrapper;
    private Pair<Integer, Integer> mVideoWidthHeight = null;

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.VideoView$1 */
    class C67291 implements Runnable {
        C67291() {
        }

        public void run() {
            if (VideoView.this.mMediaController != null) {
                VideoView.this.mMediaController.updateControls();
            }
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.VideoView$2 */
    class C77652 implements StatusUpdateListener {
        C77652() {
        }

        public void onStatusUpdate(WritableMap writableMap) {
            VideoView.this.post(VideoView.this.mMediaControllerUpdater);
            VideoView.this.mEventEmitter.receiveEvent(VideoView.this.getReactId(), Events.EVENT_STATUS_UPDATE.toString(), writableMap);
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.VideoView$3 */
    class C77663 implements ErrorListener {
        C77663() {
        }

        public void onError(String str) {
            VideoView.this.unloadPlayerAndMediaController();
            VideoView.this.callOnError(str);
        }
    }

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.VideoView$4 */
    class C77674 implements VideoSizeUpdateListener {
        C77674() {
        }

        public void onVideoSizeUpdate(Pair<Integer, Integer> pair) {
            VideoView.this.mVideoTextureView.scaleVideoSize(pair, VideoView.this.mResizeMode);
            VideoView.this.mVideoWidthHeight = pair;
            VideoView.this.callOnReadyForDisplay(pair);
        }
    }

    public VideoView(ThemedReactContext themedReactContext, VideoViewWrapper videoViewWrapper) {
        super(themedReactContext);
        this.mVideoViewWrapper = videoViewWrapper;
        this.mEventEmitter = (RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class);
        this.mAVModule = (AVModule) themedReactContext.getNativeModule(AVModule.class);
        this.mAVModule.registerVideoViewForAudioLifecycle(this);
        this.mVideoTextureView = new VideoTextureView(themedReactContext, this);
        addView(this.mVideoTextureView, generateDefaultLayoutParams());
        this.mFullscreenPlayer = new FullscreenVideoPlayer(themedReactContext, this);
        this.mFullscreenPlayer.setUpdateListener(this);
        this.mMediaController = new MediaController(getContext());
        this.mMediaController.setAnchorView(this);
        maybeUpdateMediaControllerForUseNativeControls();
    }

    public void unloadPlayerAndMediaController() {
        ensureFullscreenPlayerIsDismissed();
        if (this.mMediaController != null) {
            this.mMediaController.hide();
            this.mMediaController.setEnabled(false);
            this.mMediaController.setAnchorView(null);
            this.mMediaController = null;
        }
        if (this.mPlayerData != null) {
            this.mPlayerData.release();
            this.mPlayerData = null;
        }
        this.mIsLoaded = false;
    }

    void onDropViewInstance() {
        this.mAVModule.unregisterVideoViewForAudioLifecycle(this);
        unloadPlayerAndMediaController();
    }

    private void callOnError(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("error", str);
        this.mEventEmitter.receiveEvent(getReactId(), Events.EVENT_ERROR.toString(), createMap);
    }

    private void callOnReadyForDisplay(Pair<Integer, Integer> pair) {
        if (pair != null && this.mIsLoaded) {
            int intValue = ((Integer) pair.first).intValue();
            pair = ((Integer) pair.second).intValue();
            if (intValue != 0) {
                if (pair != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("width", intValue);
                    createMap.putInt("height", pair);
                    createMap.putString("orientation", intValue > pair ? "landscape" : "portrait");
                    pair = Arguments.createMap();
                    pair.putMap("naturalSize", createMap);
                    pair.putMap(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, this.mPlayerData.getStatus());
                    this.mEventEmitter.receiveEvent(getReactId(), Events.EVENT_READY_FOR_DISPLAY.toString(), pair);
                }
            }
        }
    }

    public void maybeUpdateMediaControllerForUseNativeControls() {
        maybeUpdateMediaControllerForUseNativeControls(true);
    }

    public void maybeUpdateMediaControllerForUseNativeControls(boolean z) {
        if (this.mPlayerData != null && this.mMediaController != null) {
            this.mMediaController.updateControls();
            this.mMediaController.setEnabled(shouldUseNativeControls());
            if (shouldUseNativeControls() && z) {
                this.mMediaController.show();
            } else {
                this.mMediaController.hide();
            }
        }
    }

    public void ensureFullscreenPlayerIsPresented() {
        ensureFullscreenPlayerIsPresented(null);
    }

    public void ensureFullscreenPlayerIsPresented(FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        if (!this.mIsLoaded) {
            saveFullscreenPlayerStateForOnLoad(true, fullscreenVideoPlayerPresentationChangeProgressListener);
        } else if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerPresentationTriedToInterrupt();
            }
        } else {
            if (!isBeingPresentedFullscreen()) {
                if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                    this.mFullscreenPlayerPresentationChangeProgressListener = fullscreenVideoPlayerPresentationChangeProgressListener;
                }
                this.mFullscreenPlayer.show();
            } else if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidPresent();
            }
        }
    }

    public void ensureFullscreenPlayerIsDismissed() {
        ensureFullscreenPlayerIsDismissed(null);
    }

    public void ensureFullscreenPlayerIsDismissed(FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        if (!this.mIsLoaded) {
            saveFullscreenPlayerStateForOnLoad(false, fullscreenVideoPlayerPresentationChangeProgressListener);
        } else if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerPresentationTriedToInterrupt();
            }
        } else {
            if (isBeingPresentedFullscreen()) {
                if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                    this.mFullscreenPlayerPresentationChangeProgressListener = fullscreenVideoPlayerPresentationChangeProgressListener;
                }
                this.mFullscreenPlayer.dismiss();
            } else if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidDismiss();
            }
        }
    }

    private void saveFullscreenPlayerStateForOnLoad(boolean z, FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        this.mShouldShowFullscreenPlayerOnLoad = z;
        if (this.mFullscreenVideoPlayerPresentationOnLoadChangeListener) {
            this.mFullscreenVideoPlayerPresentationOnLoadChangeListener.onFullscreenPlayerPresentationInterrupted();
        }
        this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = fullscreenVideoPlayerPresentationChangeProgressListener;
    }

    public void onFullscreenPlayerWillPresent() {
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_WILL_PRESENT);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerWillPresent();
        }
    }

    public void onFullscreenPlayerDidPresent() {
        this.mMediaController.updateControls();
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_DID_PRESENT);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerDidPresent();
            this.mFullscreenPlayerPresentationChangeProgressListener = null;
        }
    }

    public void onFullscreenPlayerWillDismiss() {
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_WILL_DISMISS);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerWillDismiss();
        }
    }

    public void onFullscreenPlayerDidDismiss() {
        this.mMediaController.updateControls();
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_DID_DISMISS);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerDidDismiss();
            this.mFullscreenPlayerPresentationChangeProgressListener = null;
        }
    }

    private void callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate fullscreenPlayerUpdate) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("fullscreenUpdate", fullscreenPlayerUpdate.getValue());
        createMap.putMap(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, getStatus());
        this.mEventEmitter.receiveEvent(getReactId(), Events.EVENT_FULLSCREEN_PLAYER_UPDATE.toString(), createMap);
    }

    public void setStatus(ReadableMap readableMap, Promise promise) {
        this.mStatusToSet.merge(readableMap);
        if (this.mPlayerData != null) {
            Arguments.createMap().merge(this.mStatusToSet);
            this.mStatusToSet = Arguments.createMap();
            this.mPlayerData.setStatus(readableMap, promise);
        } else if (promise != null) {
            promise.resolve(PlayerData.getUnloadedStatus());
        }
    }

    public WritableMap getStatus() {
        return this.mPlayerData == null ? PlayerData.getUnloadedStatus() : this.mPlayerData.getStatus();
    }

    private boolean shouldUseNativeControls() {
        if (this.mOverridingUseNativeControls != null) {
            return this.mOverridingUseNativeControls.booleanValue();
        }
        return this.mUseNativeControls;
    }

    void setOverridingUseNativeControls(Boolean bool) {
        this.mOverridingUseNativeControls = bool;
        maybeUpdateMediaControllerForUseNativeControls();
    }

    void setUseNativeControls(boolean z) {
        this.mUseNativeControls = z;
        maybeUpdateMediaControllerForUseNativeControls();
    }

    public void setSource(ReadableMap readableMap, ReadableMap readableMap2, final Promise promise) {
        PlayerData playerData = null;
        if (this.mPlayerData != null) {
            this.mStatusToSet.merge(this.mPlayerData.getStatus());
            this.mPlayerData.release();
            this.mPlayerData = null;
            this.mIsLoaded = false;
        }
        if (readableMap2 != null) {
            this.mStatusToSet.merge(readableMap2);
        }
        if (readableMap != null) {
            playerData = readableMap.getString("uri");
        }
        if (playerData == null) {
            if (promise != null) {
                promise.resolve(PlayerData.getUnloadedStatus());
            }
            return;
        }
        this.mEventEmitter.receiveEvent(getReactId(), Events.EVENT_LOAD_START.toString(), Arguments.createMap());
        readableMap2 = Arguments.createMap();
        readableMap2.merge(this.mStatusToSet);
        this.mStatusToSet = Arguments.createMap();
        this.mPlayerData = PlayerData.createUnloadedPlayerData(this.mAVModule, (ThemedReactContext) getContext(), readableMap, readableMap2);
        this.mPlayerData.setErrorListener(new C77663());
        this.mPlayerData.setVideoSizeUpdateListener(new C77674());
        this.mPlayerData.setFullscreenPresenter(this);
        this.mPlayerData.load(readableMap2, new LoadCompletionListener() {
            public void onLoadSuccess(WritableMap writableMap) {
                VideoView.this.mIsLoaded = true;
                VideoView.this.mVideoTextureView.scaleVideoSize(VideoView.this.mPlayerData.getVideoWidthHeight(), VideoView.this.mResizeMode);
                if (VideoView.this.mVideoTextureView.isAttachedToWindow()) {
                    VideoView.this.mPlayerData.tryUpdateVideoSurface(VideoView.this.mVideoTextureView.getSurface());
                }
                if (promise != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.merge(writableMap);
                    promise.resolve(createMap);
                }
                VideoView.this.mPlayerData.setStatusUpdateListener(VideoView.this.mStatusUpdateListener);
                VideoView.this.mMediaController.setMediaPlayer(new PlayerDataControl(VideoView.this.mPlayerData));
                VideoView.this.mMediaController.setAnchorView(VideoView.this);
                VideoView.this.maybeUpdateMediaControllerForUseNativeControls(false);
                VideoView.this.mEventEmitter.receiveEvent(VideoView.this.getReactId(), Events.EVENT_LOAD.toString(), writableMap);
                if (VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener != null) {
                    writableMap = VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener;
                    VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
                    if (VideoView.this.mShouldShowFullscreenPlayerOnLoad) {
                        VideoView.this.ensureFullscreenPlayerIsPresented(writableMap);
                    } else {
                        VideoView.this.ensureFullscreenPlayerIsDismissed(writableMap);
                    }
                }
                VideoView.this.callOnReadyForDisplay(VideoView.this.mVideoWidthHeight);
            }

            public void onLoadError(String str) {
                if (VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener != null) {
                    VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener.onFullscreenPlayerPresentationError(str);
                    VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
                }
                VideoView.this.mShouldShowFullscreenPlayerOnLoad = false;
                VideoView.this.unloadPlayerAndMediaController();
                if (promise != null) {
                    promise.reject("E_VIDEO_NOTCREATED", str);
                }
                VideoView.this.callOnError(str);
            }
        });
    }

    void setResizeMode(C1252b c1252b) {
        this.mResizeMode = c1252b;
        if (this.mPlayerData != null) {
            this.mVideoTextureView.scaleVideoSize(this.mPlayerData.getVideoWidthHeight(), this.mResizeMode);
        }
    }

    private int getReactId() {
        return this.mVideoViewWrapper.getId();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (shouldUseNativeControls() && this.mMediaController != null) {
            this.mMediaController.show();
        }
        return super.onTouchEvent(motionEvent);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.mPlayerData) {
            this.mVideoTextureView.scaleVideoSize(this.mPlayerData.getVideoWidthHeight(), this.mResizeMode);
        }
    }

    public void tryUpdateVideoSurface(Surface surface) {
        if (this.mPlayerData != null) {
            this.mPlayerData.tryUpdateVideoSurface(surface);
        }
    }

    public void pauseImmediately() {
        if (this.mPlayerData != null) {
            this.mPlayerData.pauseImmediately();
        }
    }

    public boolean requiresAudioFocus() {
        return this.mPlayerData != null && this.mPlayerData.requiresAudioFocus();
    }

    public void updateVolumeMuteAndDuck() {
        if (this.mPlayerData != null) {
            this.mPlayerData.updateVolumeMuteAndDuck();
        }
    }

    public void handleAudioFocusInterruptionBegan() {
        if (this.mPlayerData != null) {
            this.mPlayerData.handleAudioFocusInterruptionBegan();
        }
    }

    public void handleAudioFocusGained() {
        if (this.mPlayerData != null) {
            this.mPlayerData.handleAudioFocusGained();
        }
    }

    public void onPause() {
        if (this.mPlayerData != null) {
            ensureFullscreenPlayerIsDismissed();
            this.mPlayerData.onPause();
        }
    }

    public void onResume() {
        if (this.mPlayerData != null) {
            this.mPlayerData.onResume();
        }
    }

    public boolean isBeingPresentedFullscreen() {
        return this.mFullscreenPlayer.isShowing();
    }

    public void setFullscreenMode(boolean z) {
        if (z) {
            ensureFullscreenPlayerIsPresented();
        } else {
            ensureFullscreenPlayerIsDismissed();
        }
    }
}
