package com.facebook.react.modules.camera;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ReactModule(name = "ImageEditingManager")
public class ImageEditingManager extends ReactContextBaseJavaModule {
    private static final int COMPRESS_QUALITY = 90;
    @SuppressLint({"InlinedApi"})
    private static final String[] EXIF_ATTRIBUTES = new String[]{"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ImageLength", "ImageWidth", "ISOSpeedRatings", "Make", "Model", "Orientation", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
    private static final List<String> LOCAL_URI_PREFIXES = Arrays.asList(new String[]{"file://", "content://"});
    protected static final String NAME = "ImageEditingManager";
    private static final String TEMP_FILE_PREFIX = "ReactNative_cropped_image_";

    private static class CleanTask extends GuardedAsyncTask<Void, Void> {
        private final Context mContext;

        /* renamed from: com.facebook.react.modules.camera.ImageEditingManager$CleanTask$1 */
        class C19341 implements FilenameFilter {
            C19341() {
            }

            public boolean accept(File file, String str) {
                return str.startsWith(ImageEditingManager.TEMP_FILE_PREFIX);
            }
        }

        private CleanTask(ReactContext reactContext) {
            super(reactContext);
            this.mContext = reactContext;
        }

        protected void doInBackgroundGuarded(Void... voidArr) {
            cleanDirectory(this.mContext.getCacheDir());
            voidArr = this.mContext.getExternalCacheDir();
            if (voidArr != null) {
                cleanDirectory(voidArr);
            }
        }

        private void cleanDirectory(File file) {
            file = file.listFiles(new C19341());
            if (file != null) {
                for (File delete : file) {
                    delete.delete();
                }
            }
        }
    }

    private static class CropTask extends GuardedAsyncTask<Void, Void> {
        final Context mContext;
        final Callback mError;
        final int mHeight;
        final Callback mSuccess;
        int mTargetHeight;
        int mTargetWidth;
        final String mUri;
        final int mWidth;
        final int mX;
        final int mY;

        private CropTask(ReactContext reactContext, String str, int i, int i2, int i3, int i4, Callback callback, Callback callback2) {
            super(reactContext);
            this.mTargetWidth = 0;
            this.mTargetHeight = 0;
            if (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid crop rectangle: [%d, %d, %d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
            }
            this.mContext = reactContext;
            this.mUri = str;
            this.mX = i;
            this.mY = i2;
            this.mWidth = i3;
            this.mHeight = i4;
            this.mSuccess = callback;
            this.mError = callback2;
        }

        public void setTargetSize(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                throw new JSApplicationIllegalArgumentException(String.format("Invalid target size: [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
            this.mTargetWidth = i;
            this.mTargetHeight = i2;
        }

        private InputStream openBitmapInputStream() {
            InputStream openInputStream;
            if (ImageEditingManager.isLocalUri(this.mUri)) {
                openInputStream = this.mContext.getContentResolver().openInputStream(Uri.parse(this.mUri));
            } else {
                openInputStream = new URL(this.mUri).openConnection().getInputStream();
            }
            if (openInputStream != null) {
                return openInputStream;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot open bitmap: ");
            stringBuilder.append(this.mUri);
            throw new IOException(stringBuilder.toString());
        }

        protected void doInBackgroundGuarded(Void... voidArr) {
            try {
                Bitmap cropAndResize;
                Options options = new Options();
                Object obj = (this.mTargetWidth <= 0 || this.mTargetHeight <= 0) ? null : 1;
                if (obj != null) {
                    cropAndResize = cropAndResize(this.mTargetWidth, this.mTargetHeight, options);
                } else {
                    cropAndResize = crop(options);
                }
                String str = options.outMimeType;
                if (str == null || str.isEmpty()) {
                    throw new IOException("Could not determine MIME type");
                }
                File access$300 = ImageEditingManager.createTempFile(this.mContext, str);
                ImageEditingManager.writeCompressedBitmapToFile(cropAndResize, str, access$300);
                if (str.equals("image/jpeg")) {
                    ImageEditingManager.copyExif(this.mContext, Uri.parse(this.mUri), access$300);
                }
                this.mSuccess.invoke(Uri.fromFile(access$300).toString());
            } catch (Exception e) {
                this.mError.invoke(e.getMessage());
            }
        }

        private Bitmap crop(Options options) {
            InputStream openBitmapInputStream = openBitmapInputStream();
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(openBitmapInputStream, false);
            try {
                options = newInstance.decodeRegion(new Rect(this.mX, this.mY, this.mX + this.mWidth, this.mY + this.mHeight), options);
                return options;
            } finally {
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
                newInstance.recycle();
            }
        }

        private Bitmap cropAndResize(int i, int i2, Options options) {
            CropTask cropTask = this;
            int i3 = i;
            int i4 = i2;
            Options options2 = options;
            Assertions.assertNotNull(options);
            Options options3 = new Options();
            options3.inJustDecodeBounds = true;
            InputStream openBitmapInputStream = openBitmapInputStream();
            try {
                float f;
                float f2;
                BitmapFactory.decodeStream(openBitmapInputStream, null, options3);
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
                float f3 = (float) i3;
                float f4 = (float) i4;
                float f5 = f3 / f4;
                if (((float) cropTask.mWidth) / ((float) cropTask.mHeight) > f5) {
                    f = ((float) cropTask.mHeight) * f5;
                    f3 = (float) cropTask.mHeight;
                    f5 = ((float) cropTask.mX) + ((((float) cropTask.mWidth) - f) / 2.0f);
                    f2 = (float) cropTask.mY;
                    f4 /= (float) cropTask.mHeight;
                } else {
                    f = (float) cropTask.mWidth;
                    f4 = ((float) cropTask.mWidth) / f5;
                    f5 = (float) cropTask.mX;
                    f2 = ((float) cropTask.mY) + ((((float) cropTask.mHeight) - f4) / 2.0f);
                    float f6 = f4;
                    f4 = f3 / ((float) cropTask.mWidth);
                    f3 = f6;
                }
                Bitmap bitmap = cropTask.mWidth;
                options2.inSampleSize = ImageEditingManager.getDecodeSampleSize(bitmap, cropTask.mHeight, i3, i4);
                options3.inJustDecodeBounds = false;
                InputStream openBitmapInputStream2 = openBitmapInputStream();
                try {
                    bitmap = BitmapFactory.decodeStream(openBitmapInputStream2, null, options2);
                    if (bitmap != null) {
                        int floor = (int) Math.floor((double) (f5 / ((float) options2.inSampleSize)));
                        int floor2 = (int) Math.floor((double) (f2 / ((float) options2.inSampleSize)));
                        int floor3 = (int) Math.floor((double) (f / ((float) options2.inSampleSize)));
                        int floor4 = (int) Math.floor((double) (f3 / ((float) options2.inSampleSize)));
                        f4 *= (float) options2.inSampleSize;
                        Matrix matrix = new Matrix();
                        matrix.setScale(f4, f4);
                        return Bitmap.createBitmap(bitmap, floor, floor2, floor3, floor4, matrix, true);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot decode bitmap: ");
                    stringBuilder.append(cropTask.mUri);
                    throw new IOException(stringBuilder.toString());
                } finally {
                    if (openBitmapInputStream2 != null) {
                        openBitmapInputStream2.close();
                    }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (openBitmapInputStream != null) {
                    openBitmapInputStream.close();
                }
            }
        }
    }

    public String getName() {
        return NAME;
    }

    public ImageEditingManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public Map<String, Object> getConstants() {
        return Collections.emptyMap();
    }

    public void onCatalystInstanceDestroy() {
        new CleanTask(getReactApplicationContext()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @ReactMethod
    public void cropImage(String str, ReadableMap readableMap, Callback callback, Callback callback2) {
        ReadableMap readableMap2 = readableMap;
        ReadableMap readableMap3 = null;
        ReadableMap map = readableMap2.hasKey("offset") ? readableMap2.getMap("offset") : null;
        if (readableMap2.hasKey("size")) {
            readableMap3 = readableMap2.getMap("size");
        }
        if (map == null || readableMap3 == null || !map.hasKey("x") || !map.hasKey("y") || !readableMap3.hasKey("width") || !readableMap3.hasKey("height")) {
            throw new JSApplicationIllegalArgumentException("Please specify offset and size");
        } else if (str == null || str.isEmpty()) {
            throw new JSApplicationIllegalArgumentException("Please specify a URI");
        } else {
            CropTask cropTask = new CropTask(getReactApplicationContext(), str, (int) map.getDouble("x"), (int) map.getDouble("y"), (int) readableMap3.getDouble("width"), (int) readableMap3.getDouble("height"), callback, callback2);
            if (readableMap2.hasKey("displaySize")) {
                readableMap2 = readableMap2.getMap("displaySize");
                cropTask.setTargetSize((int) readableMap2.getDouble("width"), (int) readableMap2.getDouble("height"));
            }
            cropTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    private static void copyExif(Context context, Uri uri, File file) {
        context = getFileFromUri(context, uri);
        if (context == null) {
            String str = ReactConstants.TAG;
            file = new StringBuilder();
            file.append("Couldn't get real path for uri: ");
            file.append(uri);
            FLog.m5714w(str, file.toString());
            return;
        }
        uri = new ExifInterface(context.getAbsolutePath());
        context = new ExifInterface(file.getAbsolutePath());
        for (String str2 : EXIF_ATTRIBUTES) {
            String attribute = uri.getAttribute(str2);
            if (attribute != null) {
                context.setAttribute(str2, attribute);
            }
        }
        context.saveAttributes();
    }

    private static File getFileFromUri(Context context, Uri uri) {
        if (uri.getScheme().equals(UriUtil.LOCAL_FILE_SCHEME)) {
            return new File(uri.getPath());
        }
        File equals = uri.getScheme().equals(UriUtil.LOCAL_CONTENT_SCHEME);
        if (equals != null) {
            context = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (context != null) {
                try {
                    if (context.moveToFirst() != null) {
                        uri = context.getString(null);
                        if (!TextUtils.isEmpty(uri)) {
                            equals = new File(uri);
                            return equals;
                        }
                    }
                    context.close();
                } finally {
                    context.close();
                }
            }
        }
        return null;
    }

    private static boolean isLocalUri(String str) {
        for (String startsWith : LOCAL_URI_PREFIXES) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return null;
    }

    private static String getFileExtensionForType(String str) {
        if ("image/png".equals(str)) {
            return ".png";
        }
        return "image/webp".equals(str) != null ? ".webp" : ".jpg";
    }

    private static CompressFormat getCompressFormatForType(String str) {
        if ("image/png".equals(str)) {
            return CompressFormat.PNG;
        }
        if ("image/webp".equals(str) != null) {
            return CompressFormat.WEBP;
        }
        return CompressFormat.JPEG;
    }

    private static void writeCompressedBitmapToFile(Bitmap bitmap, String str, File file) {
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(getCompressFormatForType(str), 90, fileOutputStream);
        } finally {
            fileOutputStream.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File createTempFile(android.content.Context r5, java.lang.String r6) {
        /*
        r0 = r5.getExternalCacheDir();
        r5 = r5.getCacheDir();
        if (r0 != 0) goto L_0x0015;
    L_0x000a:
        if (r5 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0015;
    L_0x000d:
        r5 = new java.io.IOException;
        r6 = "No cache directory available";
        r5.<init>(r6);
        throw r5;
    L_0x0015:
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        r0 = r5;
        goto L_0x0028;
    L_0x0019:
        if (r5 != 0) goto L_0x001c;
    L_0x001b:
        goto L_0x0028;
    L_0x001c:
        r1 = r0.getFreeSpace();
        r3 = r5.getFreeSpace();
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x0017;
    L_0x0028:
        r5 = "ReactNative_cropped_image_";
        r6 = getFileExtensionForType(r6);
        r5 = java.io.File.createTempFile(r5, r6, r0);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.camera.ImageEditingManager.createTempFile(android.content.Context, java.lang.String):java.io.File");
    }

    private static int getDecodeSampleSize(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i3 || i > i4) {
            i2 /= 2;
            i /= 2;
            while (i / i5 >= i3 && i2 / i5 >= i4) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
