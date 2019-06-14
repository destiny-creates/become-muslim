package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.facebook.common.logging.FLog;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTSurfaceViewShadowNode extends LayoutShadowNode implements SurfaceTextureListener {
    private Integer mBackgroundColor;
    private Surface mSurface;

    public boolean isVirtual() {
        return false;
    }

    public boolean isVirtualAnchor() {
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        this.mBackgroundColor = num;
        markUpdated();
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        drawOutput();
        uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), this);
    }

    private void drawOutput() {
        if (this.mSurface != null) {
            if (this.mSurface.isValid()) {
                try {
                    Canvas lockCanvas = this.mSurface.lockCanvas(null);
                    int i = 0;
                    lockCanvas.drawColor(0, Mode.CLEAR);
                    if (this.mBackgroundColor != null) {
                        lockCanvas.drawColor(this.mBackgroundColor.intValue());
                    }
                    Paint paint = new Paint();
                    while (i < getChildCount()) {
                        ARTVirtualNode aRTVirtualNode = (ARTVirtualNode) getChildAt(i);
                        aRTVirtualNode.draw(lockCanvas, paint, 1.0f);
                        aRTVirtualNode.markUpdateSeen();
                        i++;
                    }
                    if (this.mSurface != null) {
                        this.mSurface.unlockCanvasAndPost(lockCanvas);
                        return;
                    }
                    return;
                } catch (IllegalArgumentException e) {
                    String str = ReactConstants.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(e.getClass().getSimpleName());
                    stringBuilder.append(" in Surface.unlockCanvasAndPost");
                    FLog.m5674e(str, stringBuilder.toString());
                }
            }
        }
        markChildrenUpdatesSeen(this);
    }

    private void markChildrenUpdatesSeen(ReactShadowNode reactShadowNode) {
        for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
            ReactShadowNode childAt = reactShadowNode.getChildAt(i);
            childAt.markUpdateSeen();
            markChildrenUpdatesSeen(childAt);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurface = new Surface(surfaceTexture);
        drawOutput();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        surfaceTexture.release();
        this.mSurface = null;
        return true;
    }
}
