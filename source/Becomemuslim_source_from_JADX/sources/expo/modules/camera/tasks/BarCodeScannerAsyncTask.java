package expo.modules.camera.tasks;

import android.os.AsyncTask;
import expo.p307b.p308a.C6017a;
import expo.p307b.p308a.C6019c;

public class BarCodeScannerAsyncTask extends AsyncTask<Void, Void, C6019c> {
    private final C6017a mBarCodeScanner;
    private BarCodeScannerAsyncTaskDelegate mDelegate;
    private int mHeight;
    private byte[] mImageData;
    private int mRotation;
    private int mWidth;

    public BarCodeScannerAsyncTask(BarCodeScannerAsyncTaskDelegate barCodeScannerAsyncTaskDelegate, C6017a c6017a, byte[] bArr, int i, int i2, int i3) {
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mDelegate = barCodeScannerAsyncTaskDelegate;
        this.mBarCodeScanner = c6017a;
        this.mRotation = i3;
    }

    protected C6019c doInBackground(Void... voidArr) {
        if (isCancelled() == null) {
            if (this.mDelegate != null) {
                return this.mBarCodeScanner.scan(this.mImageData, this.mWidth, this.mHeight, this.mRotation);
            }
        }
        return null;
    }

    protected void onPostExecute(C6019c c6019c) {
        super.onPostExecute(c6019c);
        if (c6019c != null) {
            this.mDelegate.onBarCodeScanned(c6019c);
        }
        this.mDelegate.onBarCodeScanningTaskCompleted();
    }
}
