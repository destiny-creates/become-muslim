package versioned.host.exp.exponent.modules.api.components.svg;

import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;

class GlyphContext {
    private double mDX;
    private int mDXIndex = -1;
    private final ArrayList<Integer> mDXIndices = new ArrayList();
    private SVGLength[] mDXs = new SVGLength[0];
    private final ArrayList<SVGLength[]> mDXsContext = new ArrayList();
    private int mDXsIndex;
    private final ArrayList<Integer> mDXsIndices = new ArrayList();
    private double mDY;
    private int mDYIndex = -1;
    private final ArrayList<Integer> mDYIndices = new ArrayList();
    private SVGLength[] mDYs = new SVGLength[0];
    private final ArrayList<SVGLength[]> mDYsContext = new ArrayList();
    private int mDYsIndex;
    private final ArrayList<Integer> mDYsIndices = new ArrayList();
    private final ArrayList<FontData> mFontContext = new ArrayList();
    private double mFontSize = 12.0d;
    private final float mHeight;
    private int mRIndex = -1;
    private final ArrayList<Integer> mRIndices = new ArrayList();
    private double[] mRs = new double[]{0.0d};
    private final ArrayList<double[]> mRsContext = new ArrayList();
    private int mRsIndex;
    private final ArrayList<Integer> mRsIndices = new ArrayList();
    private final float mScale;
    private int mTop;
    private final float mWidth;
    private double mX;
    private int mXIndex = -1;
    private final ArrayList<Integer> mXIndices = new ArrayList();
    private SVGLength[] mXs = new SVGLength[0];
    private final ArrayList<SVGLength[]> mXsContext = new ArrayList();
    private int mXsIndex;
    private final ArrayList<Integer> mXsIndices = new ArrayList();
    private double mY;
    private int mYIndex = -1;
    private final ArrayList<Integer> mYIndices = new ArrayList();
    private SVGLength[] mYs = new SVGLength[0];
    private final ArrayList<SVGLength[]> mYsContext = new ArrayList();
    private int mYsIndex;
    private final ArrayList<Integer> mYsIndices = new ArrayList();
    private FontData topFont = FontData.Defaults;

    private void pushIndices() {
        this.mXsIndices.add(Integer.valueOf(this.mXsIndex));
        this.mYsIndices.add(Integer.valueOf(this.mYsIndex));
        this.mDXsIndices.add(Integer.valueOf(this.mDXsIndex));
        this.mDYsIndices.add(Integer.valueOf(this.mDYsIndex));
        this.mRsIndices.add(Integer.valueOf(this.mRsIndex));
    }

    GlyphContext(float f, float f2, float f3) {
        this.mScale = f;
        this.mWidth = f2;
        this.mHeight = f3;
        this.mXsContext.add(this.mXs);
        this.mYsContext.add(this.mYs);
        this.mDXsContext.add(this.mDXs);
        this.mDYsContext.add(this.mDYs);
        this.mRsContext.add(this.mRs);
        this.mXIndices.add(Integer.valueOf(this.mXIndex));
        this.mYIndices.add(Integer.valueOf(this.mYIndex));
        this.mDXIndices.add(Integer.valueOf(this.mDXIndex));
        this.mDYIndices.add(Integer.valueOf(this.mDYIndex));
        this.mRIndices.add(Integer.valueOf(this.mRIndex));
        this.mFontContext.add(this.topFont);
        pushIndices();
    }

    private void reset() {
        this.mRsIndex = 0;
        this.mDYsIndex = 0;
        this.mDXsIndex = 0;
        this.mYsIndex = 0;
        this.mXsIndex = 0;
        this.mRIndex = -1;
        this.mDYIndex = -1;
        this.mDXIndex = -1;
        this.mYIndex = -1;
        this.mXIndex = -1;
        this.mDY = 0.0d;
        this.mDX = 0.0d;
        this.mY = 0.0d;
        this.mX = 0.0d;
    }

    FontData getFont() {
        return this.topFont;
    }

    private FontData getTopOrParentFont(GroupView groupView) {
        if (this.mTop > 0) {
            return this.topFont;
        }
        for (groupView = groupView.getParentTextRoot(); groupView != null; groupView = groupView.getParentTextRoot()) {
            FontData font = groupView.getGlyphContext().getFont();
            if (font != FontData.Defaults) {
                return font;
            }
        }
        return FontData.Defaults;
    }

    private void pushNodeAndFont(GroupView groupView, ReadableMap readableMap) {
        groupView = getTopOrParentFont(groupView);
        this.mTop++;
        if (readableMap == null) {
            this.mFontContext.add(groupView);
            return;
        }
        FontData fontData = new FontData(readableMap, groupView, (double) this.mScale);
        this.mFontSize = fontData.fontSize;
        this.mFontContext.add(fontData);
        this.topFont = fontData;
    }

    void pushContext(GroupView groupView, ReadableMap readableMap) {
        pushNodeAndFont(groupView, readableMap);
        pushIndices();
    }

    private SVGLength[] getStringArrayFromReadableArray(ArrayList<SVGLength> arrayList) {
        int size = arrayList.size();
        SVGLength[] sVGLengthArr = new SVGLength[size];
        for (int i = 0; i < size; i++) {
            sVGLengthArr[i] = (SVGLength) arrayList.get(i);
        }
        return sVGLengthArr;
    }

    private double[] getDoubleArrayFromReadableArray(ArrayList<SVGLength> arrayList) {
        int size = arrayList.size();
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = ((SVGLength) arrayList.get(i)).value;
        }
        return dArr;
    }

    void pushContext(boolean z, TextView textView, ReadableMap readableMap, ArrayList<SVGLength> arrayList, ArrayList<SVGLength> arrayList2, ArrayList<SVGLength> arrayList3, ArrayList<SVGLength> arrayList4, ArrayList<SVGLength> arrayList5) {
        if (z) {
            reset();
        }
        pushNodeAndFont(textView, readableMap);
        if (!(arrayList == null || arrayList.size() == null)) {
            this.mXsIndex++;
            this.mXIndex = -1;
            this.mXIndices.add(Integer.valueOf(this.mXIndex));
            this.mXs = getStringArrayFromReadableArray(arrayList);
            this.mXsContext.add(this.mXs);
        }
        if (!(arrayList2 == null || arrayList2.size() == null)) {
            this.mYsIndex++;
            this.mYIndex = -1;
            this.mYIndices.add(Integer.valueOf(this.mYIndex));
            this.mYs = getStringArrayFromReadableArray(arrayList2);
            this.mYsContext.add(this.mYs);
        }
        if (!(arrayList3 == null || arrayList3.size() == null)) {
            this.mDXsIndex++;
            this.mDXIndex = -1;
            this.mDXIndices.add(Integer.valueOf(this.mDXIndex));
            this.mDXs = getStringArrayFromReadableArray(arrayList3);
            this.mDXsContext.add(this.mDXs);
        }
        if (!(arrayList4 == null || arrayList4.size() == null)) {
            this.mDYsIndex++;
            this.mDYIndex = -1;
            this.mDYIndices.add(Integer.valueOf(this.mDYIndex));
            this.mDYs = getStringArrayFromReadableArray(arrayList4);
            this.mDYsContext.add(this.mDYs);
        }
        if (!(arrayList5 == null || arrayList5.size() == null)) {
            this.mRsIndex++;
            this.mRIndex = -1;
            this.mRIndices.add(Integer.valueOf(this.mRIndex));
            this.mRs = getDoubleArrayFromReadableArray(arrayList5);
            this.mRsContext.add(this.mRs);
        }
        pushIndices();
    }

    void popContext() {
        this.mFontContext.remove(this.mTop);
        this.mXsIndices.remove(this.mTop);
        this.mYsIndices.remove(this.mTop);
        this.mDXsIndices.remove(this.mTop);
        this.mDYsIndices.remove(this.mTop);
        this.mRsIndices.remove(this.mTop);
        this.mTop--;
        int i = this.mXsIndex;
        int i2 = this.mYsIndex;
        int i3 = this.mDXsIndex;
        int i4 = this.mDYsIndex;
        int i5 = this.mRsIndex;
        this.topFont = (FontData) this.mFontContext.get(this.mTop);
        this.mXsIndex = ((Integer) this.mXsIndices.get(this.mTop)).intValue();
        this.mYsIndex = ((Integer) this.mYsIndices.get(this.mTop)).intValue();
        this.mDXsIndex = ((Integer) this.mDXsIndices.get(this.mTop)).intValue();
        this.mDYsIndex = ((Integer) this.mDYsIndices.get(this.mTop)).intValue();
        this.mRsIndex = ((Integer) this.mRsIndices.get(this.mTop)).intValue();
        if (i != this.mXsIndex) {
            this.mXsContext.remove(i);
            this.mXs = (SVGLength[]) this.mXsContext.get(this.mXsIndex);
            this.mXIndex = ((Integer) this.mXIndices.get(this.mXsIndex)).intValue();
        }
        if (i2 != this.mYsIndex) {
            this.mYsContext.remove(i2);
            this.mYs = (SVGLength[]) this.mYsContext.get(this.mYsIndex);
            this.mYIndex = ((Integer) this.mYIndices.get(this.mYsIndex)).intValue();
        }
        if (i3 != this.mDXsIndex) {
            this.mDXsContext.remove(i3);
            this.mDXs = (SVGLength[]) this.mDXsContext.get(this.mDXsIndex);
            this.mDXIndex = ((Integer) this.mDXIndices.get(this.mDXsIndex)).intValue();
        }
        if (i4 != this.mDYsIndex) {
            this.mDYsContext.remove(i4);
            this.mDYs = (SVGLength[]) this.mDYsContext.get(this.mDYsIndex);
            this.mDYIndex = ((Integer) this.mDYIndices.get(this.mDYsIndex)).intValue();
        }
        if (i5 != this.mRsIndex) {
            this.mRsContext.remove(i5);
            this.mRs = (double[]) this.mRsContext.get(this.mRsIndex);
            this.mRIndex = ((Integer) this.mRIndices.get(this.mRsIndex)).intValue();
        }
    }

    private static void incrementIndices(ArrayList<Integer> arrayList, int i) {
        while (i >= 0) {
            arrayList.set(i, Integer.valueOf(((Integer) arrayList.get(i)).intValue() + 1));
            i--;
        }
    }

    double getFontSize() {
        return this.mFontSize;
    }

    double nextX(double d) {
        incrementIndices(this.mXIndices, this.mXsIndex);
        int i = this.mXIndex + 1;
        if (i < this.mXs.length) {
            this.mDX = 0.0d;
            this.mXIndex = i;
            this.mX = PropHelper.fromRelative(this.mXs[i], (double) this.mWidth, 0.0d, (double) this.mScale, this.mFontSize);
        }
        this.mX += d;
        return this.mX;
    }

    double nextY() {
        incrementIndices(this.mYIndices, this.mYsIndex);
        int i = this.mYIndex + 1;
        if (i < this.mYs.length) {
            this.mDY = 0.0d;
            this.mYIndex = i;
            this.mY = PropHelper.fromRelative(this.mYs[i], (double) this.mHeight, 0.0d, (double) this.mScale, this.mFontSize);
        }
        return this.mY;
    }

    double nextDeltaX() {
        incrementIndices(this.mDXIndices, this.mDXsIndex);
        int i = this.mDXIndex + 1;
        if (i < this.mDXs.length) {
            this.mDXIndex = i;
            this.mDX += PropHelper.fromRelative(this.mDXs[i], (double) this.mWidth, 0.0d, (double) this.mScale, this.mFontSize);
        }
        return this.mDX;
    }

    double nextDeltaY() {
        incrementIndices(this.mDYIndices, this.mDYsIndex);
        int i = this.mDYIndex + 1;
        if (i < this.mDYs.length) {
            this.mDYIndex = i;
            this.mDY += PropHelper.fromRelative(this.mDYs[i], (double) this.mHeight, 0.0d, (double) this.mScale, this.mFontSize);
        }
        return this.mDY;
    }

    double nextRotation() {
        incrementIndices(this.mRIndices, this.mRsIndex);
        this.mRIndex = Math.min(this.mRIndex + 1, this.mRs.length - 1);
        return this.mRs[this.mRIndex];
    }

    float getWidth() {
        return this.mWidth;
    }

    float getHeight() {
        return this.mHeight;
    }
}
