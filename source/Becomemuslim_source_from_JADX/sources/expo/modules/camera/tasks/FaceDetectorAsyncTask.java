package expo.modules.camera.tasks;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import expo.p307b.p311d.C6024a;
import java.util.List;

public class FaceDetectorAsyncTask extends AsyncTask<Void, Void, List<Bundle>> {
    private static final String TAG = "FaceDetectorAsyncTask";
    private FaceDetectorAsyncTaskDelegate mDelegate;
    private C6024a mFaceDetector;
    private int mFacing;
    private int mHeight;
    private byte[] mImageData;
    private int mRotation;
    private double mScaleX;
    private double mScaleY;
    private int mWidth;

    public FaceDetectorAsyncTask(FaceDetectorAsyncTaskDelegate faceDetectorAsyncTaskDelegate, C6024a c6024a, byte[] bArr, int i, int i2, int i3, int i4, double d, double d2) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mFacing = i4;
        this.mScaleX = d;
        this.mScaleY = d2;
        this.mRotation = i3;
        this.mDelegate = faceDetectorAsyncTaskDelegate;
        this.mFaceDetector = c6024a;
    }

    protected List<Bundle> doInBackground(Void... voidArr) {
        if (isCancelled() == null && this.mDelegate != null) {
            if (this.mFaceDetector != null) {
                if (this.mFaceDetector.isOperational() != null) {
                    try {
                        return this.mFaceDetector.detectFaces(this.mImageData, this.mWidth, this.mHeight, this.mRotation, this.mFacing, this.mScaleX, this.mScaleY);
                    } catch (Void[] voidArr2) {
                        String str = TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to detect face: ");
                        stringBuilder.append(voidArr2.getMessage());
                        Log.e(str, stringBuilder.toString());
                    }
                }
                return null;
            }
        }
        return null;
    }

    protected void onPostExecute(List<Bundle> list) {
        super.onPostExecute(list);
        if (list == null) {
            this.mDelegate.onFaceDetectionError(this.mFaceDetector);
        } else {
            this.mDelegate.onFacesDetected(list);
        }
        this.mDelegate.onFaceDetectingTaskCompleted();
    }
}
