package expo.modules.camera.tasks;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p018e.C0207a;
import android.util.Base64;
import com.facebook.imagepipeline.common.RotationOptions;
import expo.modules.camera.CameraViewHelper;
import expo.p304a.C6009f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class ResolveTakenPictureAsyncTask extends AsyncTask<Void, Void, Bundle> {
    private static final String BASE64_KEY = "base64";
    private static final String DATA_KEY = "data";
    private static final int DEFAULT_QUALITY = 1;
    private static final String DIRECTORY_NAME = "Camera";
    private static final String DIRECTORY_NOT_FOUND_MSG = "Documents directory of the app could not be found.";
    private static final String ERROR_TAG = "E_TAKING_PICTURE_FAILED";
    private static final String EXIF_KEY = "exif";
    private static final String EXTENSION = ".jpg";
    private static final String FAST_MODE_KEY = "fastMode";
    private static final String HEIGHT_KEY = "height";
    private static final String ID_KEY = "id";
    private static final String QUALITY_KEY = "quality";
    private static final String SKIP_PROCESSING_KEY = "skipProcessing";
    private static final String UNKNOWN_EXCEPTION_MSG = "An unknown exception has occurred.";
    private static final String UNKNOWN_IO_EXCEPTION_MSG = "An unknown I/O exception has occurred.";
    private static final String URI_KEY = "uri";
    private static final String WIDTH_KEY = "width";
    private Bitmap mBitmap;
    private File mDirectory;
    private byte[] mImageData;
    private Map<String, Object> mOptions;
    private PictureSavedDelegate mPictureSavedDelegate;
    private C6009f mPromise;

    private int getImageRotation(int i) {
        return i != 3 ? i != 6 ? i != 8 ? 0 : RotationOptions.ROTATE_270 : 90 : RotationOptions.ROTATE_180;
    }

    public ResolveTakenPictureAsyncTask(byte[] bArr, C6009f c6009f, Map<String, Object> map, File file, PictureSavedDelegate pictureSavedDelegate) {
        this.mPromise = c6009f;
        this.mOptions = map;
        this.mImageData = bArr;
        this.mDirectory = file;
        this.mPictureSavedDelegate = pictureSavedDelegate;
    }

    public ResolveTakenPictureAsyncTask(Bitmap bitmap, C6009f c6009f, Map<String, Object> map, File file, PictureSavedDelegate pictureSavedDelegate) {
        this.mPromise = c6009f;
        this.mBitmap = bitmap;
        this.mOptions = map;
        this.mDirectory = file;
        this.mPictureSavedDelegate = pictureSavedDelegate;
    }

    private int getQuality() {
        return this.mOptions.get(QUALITY_KEY) instanceof Number ? (int) (((Number) this.mOptions.get(QUALITY_KEY)).doubleValue() * 100.0d) : 100;
    }

    protected Bundle doInBackground(Void... voidArr) {
        ByteArrayInputStream byteArrayInputStream;
        if (this.mImageData != null && isOptionEnabled(SKIP_PROCESSING_KEY) != null) {
            return handleSkipProcessing();
        }
        voidArr = new Bundle();
        if (this.mBitmap == null) {
            this.mBitmap = BitmapFactory.decodeByteArray(this.mImageData, 0, this.mImageData.length);
            byteArrayInputStream = new ByteArrayInputStream(this.mImageData);
        } else {
            byteArrayInputStream = null;
        }
        if (byteArrayInputStream != null) {
            try {
                C0207a c0207a = new C0207a(byteArrayInputStream);
                int a = c0207a.a("Orientation", 0);
                if (a != 0) {
                    this.mBitmap = rotateBitmap(this.mBitmap, getImageRotation(a));
                }
                if (isOptionEnabled(EXIF_KEY)) {
                    voidArr.putBundle(EXIF_KEY, CameraViewHelper.getExifData(c0207a));
                }
            } catch (Void[] voidArr2) {
                this.mPromise.mo5138a(ERROR_TAG, DIRECTORY_NOT_FOUND_MSG, voidArr2);
                voidArr2.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            } catch (Void[] voidArr22) {
                this.mPromise.mo5138a(ERROR_TAG, UNKNOWN_IO_EXCEPTION_MSG, voidArr22);
                voidArr22.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return null;
            } catch (Void[] voidArr222) {
                this.mPromise.mo5138a(ERROR_TAG, UNKNOWN_EXCEPTION_MSG, voidArr222);
                voidArr222.printStackTrace();
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Void[] voidArr2222) {
                        voidArr2222.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        voidArr2222.putInt("width", this.mBitmap.getWidth());
        voidArr2222.putInt("height", this.mBitmap.getHeight());
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.mBitmap.compress(CompressFormat.JPEG, getQuality(), byteArrayOutputStream);
        voidArr2222.putString("uri", Uri.fromFile(new File(writeStreamToFile(byteArrayOutputStream))).toString());
        if (isOptionEnabled("base64")) {
            voidArr2222.putString("base64", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
        }
        byteArrayOutputStream.close();
        if (byteArrayInputStream != null) {
            byteArrayInputStream.close();
            byteArrayInputStream = null;
        }
        if (byteArrayInputStream != null) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return voidArr2222;
    }

    private Bundle handleSkipProcessing() {
        Bundle bundle = new Bundle();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(this.mImageData);
            String writeStreamToFile = writeStreamToFile(byteArrayOutputStream);
            bundle.putString("uri", Uri.fromFile(new File(writeStreamToFile)).toString());
            C0207a c0207a = new C0207a(writeStreamToFile);
            bundle.putInt("width", c0207a.a("ImageWidth", -1));
            bundle.putInt("height", c0207a.a("ImageLength", -1));
            if (isOptionEnabled(EXIF_KEY)) {
                bundle.putBundle(EXIF_KEY, CameraViewHelper.getExifData(c0207a));
            }
            if (isOptionEnabled("base64")) {
                bundle.putString("base64", Base64.encodeToString(this.mImageData, 0));
            }
            return bundle;
        } catch (Throwable e) {
            this.mPromise.mo5138a(ERROR_TAG, UNKNOWN_IO_EXCEPTION_MSG, e);
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            this.mPromise.mo5138a(ERROR_TAG, UNKNOWN_EXCEPTION_MSG, e2);
            e2.printStackTrace();
            return null;
        }
    }

    protected void onPostExecute(Bundle bundle) {
        super.onPostExecute(bundle);
        if (bundle == null) {
            return;
        }
        if (isOptionEnabled(FAST_MODE_KEY)) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("id", ((Double) this.mOptions.get("id")).intValue());
            bundle2.putBundle("data", bundle);
            this.mPictureSavedDelegate.onPictureSaved(bundle2);
            return;
        }
        this.mPromise.mo5137a((Object) bundle);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String writeStreamToFile(java.io.ByteArrayOutputStream r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.mDirectory;	 Catch:{ IOException -> 0x0023, all -> 0x0021 }
        r2 = "Camera";
        r3 = ".jpg";
        r1 = expo.modules.camera.utils.FileSystemUtils.generateOutputPath(r1, r2, r3);	 Catch:{ IOException -> 0x0023, all -> 0x0021 }
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x001e, all -> 0x0021 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x001e, all -> 0x0021 }
        r5.writeTo(r2);	 Catch:{ IOException -> 0x001c }
        r2.close();	 Catch:{ IOException -> 0x0017 }
        goto L_0x002f;
    L_0x0017:
        r5 = move-exception;
        r5.printStackTrace();
        goto L_0x002f;
    L_0x001c:
        r5 = move-exception;
        goto L_0x0026;
    L_0x001e:
        r5 = move-exception;
        r2 = r0;
        goto L_0x0026;
    L_0x0021:
        r5 = move-exception;
        goto L_0x0035;
    L_0x0023:
        r5 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0026:
        r0 = r5;
        r0.printStackTrace();	 Catch:{ all -> 0x0033 }
        if (r2 == 0) goto L_0x002f;
    L_0x002c:
        r2.close();	 Catch:{ IOException -> 0x0017 }
    L_0x002f:
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return r1;
    L_0x0032:
        throw r0;
    L_0x0033:
        r5 = move-exception;
        r0 = r2;
    L_0x0035:
        if (r0 == 0) goto L_0x003f;
    L_0x0037:
        r0.close();	 Catch:{ IOException -> 0x003b }
        goto L_0x003f;
    L_0x003b:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x003f:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.tasks.ResolveTakenPictureAsyncTask.writeStreamToFile(java.io.ByteArrayOutputStream):java.lang.String");
    }

    private Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private boolean isOptionEnabled(String str) {
        return (this.mOptions.get(str) == null || ((Boolean) this.mOptions.get(str)).booleanValue() == null) ? null : true;
    }
}
