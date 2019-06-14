package versioned.host.exp.exponent.modules.api.av.video;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.util.Pair;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.react.uimanager.ThemedReactContext;
import com.p082f.p083a.C1252b;
import com.p082f.p083a.C1254c;
import com.p082f.p083a.C1255d;

@SuppressLint({"ViewConstructor"})
public class VideoTextureView extends TextureView implements SurfaceTextureListener {
    private boolean mIsAttachedToWindow = false;
    private Surface mSurface = null;
    private VideoView mVideoView = null;

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public VideoTextureView(ThemedReactContext themedReactContext, VideoView videoView) {
        super(themedReactContext, null, 0);
        this.mVideoView = videoView;
        setSurfaceTextureListener(this);
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttachedToWindow;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void scaleVideoSize(Pair<Integer, Integer> pair, C1252b c1252b) {
        int intValue = ((Integer) pair.first).intValue();
        pair = ((Integer) pair.second).intValue();
        if (intValue != 0) {
            if (pair != null) {
                pair = new C1254c(new C1255d(getWidth(), getHeight()), new C1255d(intValue, pair)).a(c1252b);
                if (pair != null) {
                    setTransform(pair);
                }
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurface = new Surface(surfaceTexture);
        this.mVideoView.tryUpdateVideoSurface(this.mSurface);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurface = null;
        this.mVideoView.tryUpdateVideoSurface(null);
        return true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        this.mVideoView.tryUpdateVideoSurface(this.mSurface);
    }
}
