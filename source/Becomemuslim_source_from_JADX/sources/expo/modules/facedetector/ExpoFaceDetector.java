package expo.modules.facedetector;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.p190g.p192b.C3048a;
import com.google.android.gms.p190g.p192b.C4425b;
import com.google.android.gms.p190g.p192b.C4425b.C3049a;
import expo.p307b.p311d.C6024a;
import java.util.Map;

public class ExpoFaceDetector implements C6024a {
    public static int ACCURATE_MODE = 1;
    public static int ALL_CLASSIFICATIONS = 1;
    public static int ALL_LANDMARKS = 1;
    private static final String DETECT_LANDMARKS_KEY = "detectLandmarks";
    public static int FAST_MODE = 0;
    private static final String MODE_KEY = "mode";
    public static int NO_CLASSIFICATIONS = 0;
    public static int NO_LANDMARKS = 0;
    private static final String RUN_CLASSIFICATIONS_KEY = "runClassifications";
    private static final String TRACKING_KEY = "tracking";
    private C3049a mBuilder;
    private int mClassificationType = NO_CLASSIFICATIONS;
    private C4425b mFaceDetector = null;
    private int mLandmarkType = NO_LANDMARKS;
    private float mMinFaceSize = 0.15f;
    private int mMode = FAST_MODE;
    private ImageDimensions mPreviousDimensions;

    public ExpoFaceDetector(Context context) {
        this.mBuilder = new C3049a(context);
        this.mBuilder.a(this.mMinFaceSize);
        this.mBuilder.c(this.mMode);
        this.mBuilder.a(this.mLandmarkType);
        this.mBuilder.b(this.mClassificationType);
    }

    public boolean isOperational() {
        if (this.mFaceDetector == null) {
            createFaceDetector();
        }
        return this.mFaceDetector.b();
    }

    public SparseArray<C3048a> detect(ExpoFrame expoFrame) {
        if (!expoFrame.getDimensions().equals(this.mPreviousDimensions)) {
            releaseFaceDetector();
        }
        if (this.mFaceDetector == null) {
            createFaceDetector();
            this.mPreviousDimensions = expoFrame.getDimensions();
        }
        return this.mFaceDetector.a(expoFrame.getFrame());
    }

    public java.util.List<android.os.Bundle> detectFaces(byte[] r3, int r4, int r5, int r6, int r7, double r8, double r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r3 = expo.modules.facedetector.ExpoFrameFactory.buildFrame(r3, r4, r5, r6);	 Catch:{ Exception -> 0x0039 }
        r4 = r2.detect(r3);	 Catch:{ Exception -> 0x0039 }
        r5 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0039 }
        r5.<init>();	 Catch:{ Exception -> 0x0039 }
        r6 = 0;	 Catch:{ Exception -> 0x0039 }
    L_0x000e:
        r0 = r4.size();	 Catch:{ Exception -> 0x0039 }
        if (r6 >= r0) goto L_0x0038;	 Catch:{ Exception -> 0x0039 }
    L_0x0014:
        r0 = r4.valueAt(r6);	 Catch:{ Exception -> 0x0039 }
        r0 = (com.google.android.gms.p190g.p192b.C3048a) r0;	 Catch:{ Exception -> 0x0039 }
        r0 = expo.modules.facedetector.FaceDetectorUtils.serializeFace(r0, r8, r10);	 Catch:{ Exception -> 0x0039 }
        r1 = 1;	 Catch:{ Exception -> 0x0039 }
        if (r7 != r1) goto L_0x002e;	 Catch:{ Exception -> 0x0039 }
    L_0x0021:
        r1 = r3.getDimensions();	 Catch:{ Exception -> 0x0039 }
        r1 = r1.getWidth();	 Catch:{ Exception -> 0x0039 }
        r0 = expo.modules.facedetector.FaceDetectorUtils.rotateFaceX(r0, r1, r8);	 Catch:{ Exception -> 0x0039 }
        goto L_0x0032;	 Catch:{ Exception -> 0x0039 }
    L_0x002e:
        r0 = expo.modules.facedetector.FaceDetectorUtils.changeAnglesDirection(r0);	 Catch:{ Exception -> 0x0039 }
    L_0x0032:
        r5.add(r0);	 Catch:{ Exception -> 0x0039 }
        r6 = r6 + 1;
        goto L_0x000e;
    L_0x0038:
        return r5;
    L_0x0039:
        r3 = new java.util.ArrayList;
        r3.<init>();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.facedetector.ExpoFaceDetector.detectFaces(byte[], int, int, int, int, double, double):java.util.List<android.os.Bundle>");
    }

    public void setSettings(Map<String, Object> map) {
        if (map.get(MODE_KEY) instanceof Number) {
            setMode(((Number) map.get(MODE_KEY)).intValue());
        }
        if (map.get(DETECT_LANDMARKS_KEY) instanceof Number) {
            setLandmarkType(((Number) map.get(DETECT_LANDMARKS_KEY)).intValue());
        }
        if (map.get(TRACKING_KEY) instanceof Boolean) {
            setTrackingEnabled(((Boolean) map.get(TRACKING_KEY)).booleanValue());
        }
        if (map.get(RUN_CLASSIFICATIONS_KEY) instanceof Number) {
            setClassificationType(((Number) map.get(RUN_CLASSIFICATIONS_KEY)).intValue());
        }
    }

    public void setClassificationType(int i) {
        if (i != this.mClassificationType) {
            release();
            this.mBuilder.b(i);
            this.mClassificationType = i;
        }
    }

    public void setLandmarkType(int i) {
        if (i != this.mLandmarkType) {
            release();
            this.mBuilder.a(i);
            this.mLandmarkType = i;
        }
    }

    public void setMode(int i) {
        if (i != this.mMode) {
            release();
            this.mBuilder.c(i);
            this.mMode = i;
        }
    }

    public void setTrackingEnabled(boolean z) {
        release();
        this.mBuilder.a(z);
    }

    public void release() {
        releaseFaceDetector();
        this.mPreviousDimensions = null;
    }

    private void releaseFaceDetector() {
        if (this.mFaceDetector != null) {
            this.mFaceDetector.a();
            this.mFaceDetector = null;
        }
    }

    private void createFaceDetector() {
        this.mFaceDetector = this.mBuilder.a();
    }
}
