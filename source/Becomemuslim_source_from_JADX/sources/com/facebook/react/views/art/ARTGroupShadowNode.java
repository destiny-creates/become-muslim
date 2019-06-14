package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTGroupShadowNode extends ARTVirtualNode {
    protected RectF mClipping;

    public boolean isVirtual() {
        return true;
    }

    public ARTGroupShadowNode(ARTGroupShadowNode aRTGroupShadowNode) {
        super(aRTGroupShadowNode);
        this.mClipping = new RectF(aRTGroupShadowNode.mClipping);
    }

    @ReactProp(name = "clipping")
    public void setClipping(ReadableArray readableArray) {
        readableArray = PropHelper.toFloatArray(readableArray);
        if (readableArray != null) {
            this.mClipping = createClipping(readableArray);
            markUpdated();
        }
    }

    protected ReactShadowNodeImpl copy() {
        return new ARTGroupShadowNode(this);
    }

    public void draw(Canvas canvas, Paint paint, float f) {
        f *= this.mOpacity;
        if (f > 0.01f) {
            saveAndSetupCanvas(canvas);
            if (this.mClipping != null) {
                canvas.clipRect(this.mClipping.left * this.mScale, this.mClipping.top * this.mScale, this.mClipping.right * this.mScale, this.mClipping.bottom * this.mScale, Op.REPLACE);
            }
            for (int i = 0; i < getChildCount(); i++) {
                ARTVirtualNode aRTVirtualNode = (ARTVirtualNode) getChildAt(i);
                aRTVirtualNode.draw(canvas, paint, f);
                aRTVirtualNode.markUpdateSeen();
            }
            restoreCanvas(canvas);
        }
    }

    private static RectF createClipping(float[] fArr) {
        if (fArr.length == 4) {
            return new RectF(fArr[0], fArr[1], fArr[0] + fArr[2], fArr[1] + fArr[3]);
        }
        throw new JSApplicationIllegalArgumentException("Clipping should be array of length 4 (e.g. [x, y, width, height])");
    }
}
