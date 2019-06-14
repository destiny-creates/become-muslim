package expo.modules.facedetector.tasks;

import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p018e.C0207a;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.p190g.p192b.C3048a;
import expo.modules.facedetector.ExpoFaceDetector;
import expo.modules.facedetector.ExpoFrameFactory;
import expo.modules.facedetector.FaceDetectorUtils;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class FileFaceDetectionAsyncTask extends AsyncTask<Void, Void, SparseArray<C3048a>> {
    private static final String ERROR_TAG = "E_FACE_DETECTION_FAILED";
    private ExpoFaceDetector mExpoFaceDetector;
    private FileInputStream mFileInputStream;
    private int mHeight = 0;
    private FileFaceDetectionCompletionListener mListener;
    private int mOrientation = 0;
    private String mPath;
    private String mUri;
    private int mWidth = 0;

    public FileFaceDetectionAsyncTask(ExpoFaceDetector expoFaceDetector, HashMap<String, Object> hashMap, FileFaceDetectionCompletionListener fileFaceDetectionCompletionListener) {
        this.mUri = (String) hashMap.get("uri");
        this.mListener = fileFaceDetectionCompletionListener;
        this.mExpoFaceDetector = expoFaceDetector;
    }

    protected void onPreExecute() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.mUri;
        r1 = 1;
        if (r0 != 0) goto L_0x0012;
    L_0x0005:
        r0 = r5.mListener;
        r2 = "E_FACE_DETECTION_FAILED";
        r3 = "You have to provide an URI of an image.";
        r0.reject(r2, r3);
        r5.cancel(r1);
        return;
    L_0x0012:
        r0 = r5.mUri;
        r0 = android.net.Uri.parse(r0);
        r2 = r0.getPath();
        r5.mPath = r2;
        r2 = r5.mPath;
        if (r2 != 0) goto L_0x0045;
    L_0x0022:
        r0 = r5.mListener;
        r2 = "E_FACE_DETECTION_FAILED";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Invalid URI provided: `";
        r3.append(r4);
        r4 = r5.mUri;
        r3.append(r4);
        r4 = "`.";
        r3.append(r4);
        r3 = r3.toString();
        r0.reject(r2, r3);
        r5.cancel(r1);
        return;
    L_0x0045:
        r2 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0051 }
        r0 = r0.getPath();	 Catch:{ FileNotFoundException -> 0x0051 }
        r2.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0051 }
        r5.mFileInputStream = r2;	 Catch:{ FileNotFoundException -> 0x0051 }
        goto L_0x0073;
    L_0x0051:
        r0 = r5.mListener;
        r2 = "E_FACE_DETECTION_FAILED";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "The file does not exist. Given path: `";
        r3.append(r4);
        r4 = r5.mPath;
        r3.append(r4);
        r4 = "`.";
        r3.append(r4);
        r3 = r3.toString();
        r0.reject(r2, r3);
        r5.cancel(r1);
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.facedetector.tasks.FileFaceDetectionAsyncTask.onPreExecute():void");
    }

    protected SparseArray<C3048a> doInBackground(Void... voidArr) {
        if (isCancelled() != null) {
            return null;
        }
        voidArr = BitmapFactory.decodeStream(this.mFileInputStream);
        this.mWidth = voidArr.getWidth();
        this.mHeight = voidArr.getHeight();
        try {
            this.mOrientation = new C0207a(this.mPath).a("Orientation", 0);
        } catch (Throwable e) {
            String str = ERROR_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Reading orientation from file `");
            stringBuilder.append(this.mPath);
            stringBuilder.append("` failed.");
            Log.e(str, stringBuilder.toString(), e);
        }
        return this.mExpoFaceDetector.detect(ExpoFrameFactory.buildFrame(voidArr));
    }

    protected void onPostExecute(SparseArray<C3048a> sparseArray) {
        super.onPostExecute(sparseArray);
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < sparseArray.size(); i++) {
            Bundle serializeFace = FaceDetectorUtils.serializeFace((C3048a) sparseArray.valueAt(i));
            serializeFace.putDouble("yawAngle", ((-serializeFace.getDouble("yawAngle")) + 360.0d) % 360.0d);
            serializeFace.putDouble("rollAngle", ((-serializeFace.getDouble("rollAngle")) + 360.0d) % 360.0d);
            arrayList.add(serializeFace);
        }
        bundle.putParcelableArrayList("faces", arrayList);
        sparseArray = new Bundle();
        sparseArray.putInt("width", this.mWidth);
        sparseArray.putInt("height", this.mHeight);
        sparseArray.putInt("orientation", this.mOrientation);
        sparseArray.putString("uri", this.mUri);
        bundle.putBundle(MessengerShareContentUtility.MEDIA_IMAGE, sparseArray);
        this.mExpoFaceDetector.release();
        this.mListener.resolve(bundle);
    }
}
