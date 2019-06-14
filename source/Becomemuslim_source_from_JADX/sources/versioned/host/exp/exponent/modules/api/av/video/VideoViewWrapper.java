package versioned.host.exp.exponent.modules.api.av.video;

import android.annotation.SuppressLint;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.facebook.react.uimanager.ThemedReactContext;

@SuppressLint({"ViewConstructor"})
public class VideoViewWrapper extends FrameLayout {
    private final Runnable mLayoutRunnable = new C67301();
    private VideoView mVideoView = null;

    /* renamed from: versioned.host.exp.exponent.modules.api.av.video.VideoViewWrapper$1 */
    class C67301 implements Runnable {
        C67301() {
        }

        public void run() {
            VideoViewWrapper.this.measure(MeasureSpec.makeMeasureSpec(VideoViewWrapper.this.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(VideoViewWrapper.this.getHeight(), 1073741824));
            VideoViewWrapper.this.layout(VideoViewWrapper.this.getLeft(), VideoViewWrapper.this.getTop(), VideoViewWrapper.this.getRight(), VideoViewWrapper.this.getBottom());
        }
    }

    public VideoViewWrapper(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.mVideoView = new VideoView(themedReactContext, this);
        addView(this.mVideoView, generateDefaultLayoutParams());
    }

    public VideoView getVideoViewInstance() {
        return this.mVideoView;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.mLayoutRunnable);
    }
}
