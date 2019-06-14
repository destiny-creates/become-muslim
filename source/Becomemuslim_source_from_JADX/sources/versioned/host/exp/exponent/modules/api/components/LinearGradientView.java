package versioned.host.exp.exponent.modules.api.components;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;

public class LinearGradientView extends View {
    private float[] mBorderRadii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
    private int[] mColors;
    private float[] mEndPos = new float[]{0.0f, 1.0f};
    private float[] mLocations;
    private final Paint mPaint = new Paint(1);
    private Path mPathForBorderRadius;
    private LinearGradient mShader;
    private int[] mSize = new int[]{0, 0};
    private float[] mStartPos = new float[]{0.0f, 0.0f};
    private RectF mTempRectForBorderRadius;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LinearGradientView(android.content.Context r2) {
        /*
        r1 = this;
        r1.<init>(r2);
        r2 = new android.graphics.Paint;
        r0 = 1;
        r2.<init>(r0);
        r1.mPaint = r2;
        r2 = 2;
        r0 = new float[r2];
        r0 = {0, 0};
        r1.mStartPos = r0;
        r0 = new float[r2];
        r0 = {0, 1065353216};
        r1.mEndPos = r0;
        r2 = new int[r2];
        r2 = {0, 0};
        r1.mSize = r2;
        r2 = 8;
        r2 = new float[r2];
        r2 = {0, 0, 0, 0, 0, 0, 0, 0};
        r1.mBorderRadii = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.LinearGradientView.<init>(android.content.Context):void");
    }

    public void setStartPosition(ReadableArray readableArray) {
        this.mStartPos = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setEndPosition(ReadableArray readableArray) {
        this.mEndPos = new float[]{(float) readableArray.getDouble(0), (float) readableArray.getDouble(1)};
        drawGradient();
    }

    public void setColors(ReadableArray readableArray) {
        int[] iArr = new int[readableArray.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = readableArray.getInt(i);
        }
        this.mColors = iArr;
        drawGradient();
    }

    public void setLocations(ReadableArray readableArray) {
        float[] fArr = new float[readableArray.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = (float) readableArray.getDouble(i);
        }
        this.mLocations = fArr;
        drawGradient();
    }

    public void setBorderRadii(ReadableArray readableArray) {
        float[] fArr = new float[readableArray.size()];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = PixelUtil.toPixelFromDIP((float) readableArray.getDouble(i));
        }
        this.mBorderRadii = fArr;
        updatePath();
        drawGradient();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mSize = new int[]{i, i2};
        updatePath();
        drawGradient();
    }

    private void drawGradient() {
        if (this.mColors != null) {
            if (this.mLocations == null || this.mColors.length == this.mLocations.length) {
                this.mShader = new LinearGradient(((float) this.mSize[0]) * this.mStartPos[0], this.mStartPos[1] * ((float) this.mSize[1]), this.mEndPos[0] * ((float) this.mSize[0]), this.mEndPos[1] * ((float) this.mSize[1]), this.mColors, this.mLocations, TileMode.CLAMP);
                this.mPaint.setShader(this.mShader);
                invalidate();
            }
        }
    }

    private void updatePath() {
        if (this.mPathForBorderRadius == null) {
            this.mPathForBorderRadius = new Path();
            this.mTempRectForBorderRadius = new RectF();
        }
        this.mPathForBorderRadius.reset();
        this.mTempRectForBorderRadius.set(0.0f, 0.0f, (float) this.mSize[0], (float) this.mSize[1]);
        this.mPathForBorderRadius.addRoundRect(this.mTempRectForBorderRadius, this.mBorderRadii, Direction.CW);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPathForBorderRadius == null) {
            canvas.drawPaint(this.mPaint);
        } else {
            canvas.drawPath(this.mPathForBorderRadius, this.mPaint);
        }
    }
}
