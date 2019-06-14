package versioned.host.exp.exponent.modules.api.av.video;

import android.app.Dialog;
import android.os.Handler;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import java.lang.ref.WeakReference;
import versioned.host.exp.exponent.modules.api.KeepAwakeModule;
import versioned.host.exp.exponent.modules.api.av.player.PlayerData;

public class FullscreenVideoPlayer extends Dialog {
    private final FrameLayout mContainerView;
    private Handler mKeepScreenOnHandler = new Handler();
    private Runnable mKeepScreenOnUpdater = new KeepScreenOnUpdater(this);
    private FrameLayout mParent;
    private ReactContext mReactContext;
    private WeakReference<FullscreenVideoPlayerPresentationChangeListener> mUpdateListener;
    private final VideoView mVideoView;

    private static class KeepScreenOnUpdater implements Runnable {
        private static final long UPDATE_KEEP_SCREEN_ON_FLAG_MS = 200;
        private final WeakReference<FullscreenVideoPlayer> mFullscreenPlayer;

        KeepScreenOnUpdater(FullscreenVideoPlayer fullscreenVideoPlayer) {
            this.mFullscreenPlayer = new WeakReference(fullscreenVideoPlayer);
        }

        public void run() {
            FullscreenVideoPlayer fullscreenVideoPlayer = (FullscreenVideoPlayer) this.mFullscreenPlayer.get();
            if (fullscreenVideoPlayer != null) {
                Window window = fullscreenVideoPlayer.getWindow();
                if (window != null) {
                    Object obj = (fullscreenVideoPlayer.mVideoView.getStatus().hasKey(PlayerData.STATUS_IS_PLAYING_KEY_PATH) && fullscreenVideoPlayer.mVideoView.getStatus().getBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH)) ? 1 : null;
                    KeepAwakeModule keepAwakeModule = (KeepAwakeModule) fullscreenVideoPlayer.mReactContext.getNativeModule(KeepAwakeModule.class);
                    if (obj == null) {
                        if (!keepAwakeModule.isActivated()) {
                            window.clearFlags(128);
                        }
                    }
                    window.addFlags(128);
                }
                fullscreenVideoPlayer.mKeepScreenOnHandler.postDelayed(this, UPDATE_KEEP_SCREEN_ON_FLAG_MS);
            }
        }
    }

    FullscreenVideoPlayer(ThemedReactContext themedReactContext, VideoView videoView) {
        super(themedReactContext, 16973834);
        this.mReactContext = themedReactContext;
        setCancelable(false);
        this.mVideoView = videoView;
        this.mContainerView = new FrameLayout(themedReactContext);
        setContentView(this.mContainerView, generateDefaultLayoutParams());
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (isShowing()) {
            dismiss();
        }
    }

    public void show() {
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerWillPresent();
        }
        super.show();
    }

    public void dismiss() {
        this.mVideoView.setOverridingUseNativeControls(null);
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerWillDismiss();
        }
        super.dismiss();
    }

    protected void onStart() {
        this.mParent = (FrameLayout) this.mVideoView.getParent();
        this.mParent.removeView(this.mVideoView);
        this.mContainerView.addView(this.mVideoView, generateDefaultLayoutParams());
        super.onStart();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerDidPresent();
        }
        this.mVideoView.setOverridingUseNativeControls(Boolean.valueOf(true));
        this.mKeepScreenOnHandler.post(this.mKeepScreenOnUpdater);
    }

    void setUpdateListener(FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener) {
        this.mUpdateListener = new WeakReference(fullscreenVideoPlayerPresentationChangeListener);
    }

    protected void onStop() {
        this.mKeepScreenOnHandler.removeCallbacks(this.mKeepScreenOnUpdater);
        this.mContainerView.removeView(this.mVideoView);
        this.mParent.addView(this.mVideoView, generateDefaultLayoutParams());
        this.mParent.requestLayout();
        this.mParent = null;
        super.onStop();
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerDidDismiss();
        }
    }

    private LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }
}
