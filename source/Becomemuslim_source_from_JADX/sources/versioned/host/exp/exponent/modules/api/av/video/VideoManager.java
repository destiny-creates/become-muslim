package versioned.host.exp.exponent.modules.api.av.video;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;

public class VideoManager extends ReactContextBaseJavaModule {
    private static final String NAME = "ExponentVideoManager";
    private final ReactApplicationContext mReactApplicationContext;

    private interface VideoViewCallback {
        void runWithVideoView(VideoView videoView);
    }

    public String getName() {
        return NAME;
    }

    public VideoManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
    }

    @ReactMethod
    public void setFullscreen(Integer num, final Boolean bool, final Promise promise) {
        tryRunWithVideoView(num, new VideoViewCallback() {
            public void runWithVideoView(final VideoView videoView) {
                FullscreenVideoPlayerPresentationChangeProgressListener c81981 = new FullscreenVideoPlayerPresentationChangeProgressListener() {
                    public void onFullscreenPlayerDidDismiss() {
                        promise.resolve(videoView.getStatus());
                    }

                    public void onFullscreenPlayerDidPresent() {
                        promise.resolve(videoView.getStatus());
                    }

                    public void onFullscreenPlayerPresentationTriedToInterrupt() {
                        promise.reject("E_FULLSCREEN_VIDEO_PLAYER", "This presentation change tries to interrupt an older request. Await the old request and then try again.");
                    }

                    public void onFullscreenPlayerPresentationInterrupted() {
                        promise.reject("E_FULLSCREEN_VIDEO_PLAYER", "This presentation change has been interrupted by a newer change request.");
                    }

                    void onFullscreenPlayerPresentationError(String str) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("This presentation change has been interrupted by an error.");
                        if (str != null) {
                            stringBuilder.append(" ");
                            stringBuilder.append(str);
                        }
                        promise.reject("E_FULLSCREEN_VIDEO_PLAYER", stringBuilder.toString());
                    }
                };
                if (bool.booleanValue()) {
                    videoView.ensureFullscreenPlayerIsPresented(c81981);
                } else {
                    videoView.ensureFullscreenPlayerIsDismissed(c81981);
                }
            }
        }, promise);
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
                throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.av.video.VideoManager.2.execute(com.facebook.react.uimanager.NativeViewHierarchyManager):void");
            }
        });
    }
}
