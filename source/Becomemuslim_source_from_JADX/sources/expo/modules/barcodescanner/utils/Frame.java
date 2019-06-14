package expo.modules.barcodescanner.utils;

import com.google.android.gms.p190g.C3052b;

public class Frame {
    private ImageDimensions mDimensions;
    private C3052b mFrame;

    public Frame(C3052b c3052b, ImageDimensions imageDimensions) {
        this.mFrame = c3052b;
        this.mDimensions = imageDimensions;
    }

    public C3052b getFrame() {
        return this.mFrame;
    }

    public ImageDimensions getDimensions() {
        return this.mDimensions;
    }
}
