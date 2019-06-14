package versioned.host.exp.exponent.modules.api;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import host.exp.exponent.p346j.C6393j;

public class ImageManipulatorModule extends ReactContextBaseJavaModule {
    private static final String ARGS_ERROR_TAG = "E_ARGS_ERR";
    private static final String DECODE_ERROR_TAG = "E_DECODE_ERR";
    private static final String TAG = "ExpoImageManipulator";
    private C6393j mScopedContext;

    public String getName() {
        return "ExponentImageManipulator";
    }

    public ImageManipulatorModule(ReactApplicationContext reactApplicationContext, C6393j c6393j) {
        super(reactApplicationContext);
        this.mScopedContext = c6393j;
    }

    @ReactMethod
    public void manipulate(String str, ReadableArray readableArray, ReadableMap readableMap, Promise promise) {
        if (str != null) {
            if (str.length() != 0) {
                DataSource fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setRotationOptions(RotationOptions.autoRotate()).build(), getReactApplicationContext());
                final ReadableArray readableArray2 = readableArray;
                final ReadableMap readableMap2 = readableMap;
                final Promise promise2 = promise;
                final DataSource dataSource = fetchDecodedImage;
                final String str2 = str;
                fetchDecodedImage.subscribe(new BaseBitmapDataSubscriber() {
                    public void onNewResultImpl(Bitmap bitmap) {
                        if (bitmap != null) {
                            ImageManipulatorModule.this.processBitmapWithActions(bitmap, readableArray2, readableMap2, promise2);
                        } else {
                            onFailureImpl(dataSource);
                        }
                    }

                    public void onFailureImpl(DataSource dataSource) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Could not get decoded bitmap of ");
                        stringBuilder.append(str2);
                        String stringBuilder2 = stringBuilder.toString();
                        if (dataSource.getFailureCause() != null) {
                            Promise promise = promise2;
                            String str = ImageManipulatorModule.DECODE_ERROR_TAG;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(stringBuilder2);
                            stringBuilder3.append(": ");
                            stringBuilder3.append(dataSource.getFailureCause().toString());
                            promise.reject(str, stringBuilder3.toString(), dataSource.getFailureCause());
                            return;
                        }
                        dataSource = promise2;
                        String str2 = ImageManipulatorModule.DECODE_ERROR_TAG;
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(stringBuilder2);
                        stringBuilder4.append(".");
                        dataSource.reject(str2, stringBuilder4.toString());
                    }
                }, CallerThreadExecutor.getInstance());
                return;
            }
        }
        promise.reject(ARGS_ERROR_TAG, "Uri passed to ImageManipulator cannot be empty!");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processBitmapWithActions(android.graphics.Bitmap r11, com.facebook.react.bridge.ReadableArray r12, com.facebook.react.bridge.ReadableMap r13, com.facebook.react.bridge.Promise r14) {
        /*
        r10 = this;
        r0 = 0;
        r1 = r11;
        r11 = 0;
    L_0x0003:
        r2 = r12.size();
        r3 = 1;
        if (r11 >= r2) goto L_0x0144;
    L_0x000a:
        r2 = r12.getMap(r11);
        r4 = r1.getWidth();
        r5 = r1.getHeight();
        r6 = "resize";
        r6 = r2.hasKey(r6);
        r7 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        if (r6 == 0) goto L_0x005b;
    L_0x0020:
        r6 = "resize";
        r2 = r2.getMap(r6);
        r4 = (float) r4;
        r4 = r4 * r7;
        r5 = (float) r5;
        r4 = r4 / r5;
        r5 = "width";
        r5 = r2.hasKey(r5);
        if (r5 == 0) goto L_0x003e;
    L_0x0033:
        r5 = "width";
        r5 = r2.getDouble(r5);
        r5 = (int) r5;
        r6 = (float) r5;
        r6 = r6 / r4;
        r6 = (int) r6;
        goto L_0x0040;
    L_0x003e:
        r5 = 0;
        r6 = 0;
    L_0x0040:
        r7 = "height";
        r7 = r2.hasKey(r7);
        if (r7 == 0) goto L_0x0055;
    L_0x0048:
        r6 = "height";
        r6 = r2.getDouble(r6);
        r6 = (int) r6;
        if (r5 != 0) goto L_0x0055;
    L_0x0051:
        r2 = (float) r6;
        r4 = r4 * r2;
        r5 = (int) r4;
    L_0x0055:
        r1 = android.graphics.Bitmap.createScaledBitmap(r1, r5, r6, r3);
        goto L_0x0140;
    L_0x005b:
        r3 = "rotate";
        r3 = r2.hasKey(r3);
        if (r3 == 0) goto L_0x0083;
    L_0x0063:
        r3 = "rotate";
        r2 = r2.getInt(r3);
        r6 = new android.graphics.Matrix;
        r6.<init>();
        r2 = (float) r2;
        r6.postRotate(r2);
        r2 = 0;
        r3 = 0;
        r4 = r1.getWidth();
        r5 = r1.getHeight();
        r7 = 1;
        r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0140;
    L_0x0083:
        r3 = "flip";
        r3 = r2.hasKey(r3);
        if (r3 == 0) goto L_0x00cf;
    L_0x008b:
        r6 = new android.graphics.Matrix;
        r6.<init>();
        r3 = "flip";
        r2 = r2.getMap(r3);
        r3 = "horizontal";
        r3 = r2.hasKey(r3);
        r4 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        if (r3 == 0) goto L_0x00ab;
    L_0x00a0:
        r3 = "horizontal";
        r3 = r2.getBoolean(r3);
        if (r3 == 0) goto L_0x00ab;
    L_0x00a8:
        r6.postScale(r4, r7);
    L_0x00ab:
        r3 = "vertical";
        r3 = r2.hasKey(r3);
        if (r3 == 0) goto L_0x00be;
    L_0x00b3:
        r3 = "vertical";
        r2 = r2.getBoolean(r3);
        if (r2 == 0) goto L_0x00be;
    L_0x00bb:
        r6.postScale(r7, r4);
    L_0x00be:
        r2 = 0;
        r3 = 0;
        r4 = r1.getWidth();
        r5 = r1.getHeight();
        r7 = 1;
        r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x0140;
    L_0x00cf:
        r3 = "crop";
        r3 = r2.hasKey(r3);
        if (r3 == 0) goto L_0x0140;
    L_0x00d7:
        r3 = "crop";
        r2 = r2.getMap(r3);
        r3 = "originX";
        r3 = r2.hasKey(r3);
        if (r3 == 0) goto L_0x0138;
    L_0x00e5:
        r3 = "originY";
        r3 = r2.hasKey(r3);
        if (r3 == 0) goto L_0x0138;
    L_0x00ed:
        r3 = "width";
        r3 = r2.hasKey(r3);
        if (r3 == 0) goto L_0x0138;
    L_0x00f5:
        r3 = "height";
        r3 = r2.hasKey(r3);
        if (r3 != 0) goto L_0x00fe;
    L_0x00fd:
        goto L_0x0138;
    L_0x00fe:
        r3 = "originX";
        r6 = r2.getDouble(r3);
        r3 = (int) r6;
        r6 = "originY";
        r6 = r2.getDouble(r6);
        r6 = (int) r6;
        r7 = "width";
        r7 = r2.getDouble(r7);
        r7 = (int) r7;
        r8 = "height";
        r8 = r2.getDouble(r8);
        r2 = (int) r8;
        if (r3 > r4) goto L_0x0130;
    L_0x011c:
        if (r6 > r5) goto L_0x0130;
    L_0x011e:
        r4 = r1.getWidth();
        if (r7 > r4) goto L_0x0130;
    L_0x0124:
        r4 = r1.getHeight();
        if (r2 <= r4) goto L_0x012b;
    L_0x012a:
        goto L_0x0130;
    L_0x012b:
        r1 = android.graphics.Bitmap.createBitmap(r1, r3, r6, r7, r2);
        goto L_0x0140;
    L_0x0130:
        r11 = "E_INVALID_CROP_DATA";
        r12 = "Invalid crop options has been passed. Please make sure the requested crop rectangle is inside source image.";
        r14.reject(r11, r12);
        return;
    L_0x0138:
        r11 = "E_INVALID_CROP_DATA";
        r12 = "Invalid crop options has been passed. Please make sure the object contains originX, originY, width and height.";
        r14.reject(r11, r12);
        return;
    L_0x0140:
        r11 = r11 + 1;
        goto L_0x0003;
    L_0x0144:
        r11 = 100;
        r12 = "compress";
        r12 = r13.hasKey(r12);
        if (r12 == 0) goto L_0x0159;
    L_0x014e:
        r11 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = "compress";
        r4 = r13.getDouble(r2);
        r4 = r4 * r11;
        r11 = (int) r4;
    L_0x0159:
        r12 = "format";
        r12 = r13.hasKey(r12);
        if (r12 == 0) goto L_0x0168;
    L_0x0161:
        r12 = "format";
        r12 = r13.getString(r12);
        goto L_0x016a;
    L_0x0168:
        r12 = "jpeg";
    L_0x016a:
        r2 = "png";
        r2 = r12.equals(r2);
        if (r2 == 0) goto L_0x0177;
    L_0x0172:
        r12 = android.graphics.Bitmap.CompressFormat.PNG;
        r2 = ".png";
        goto L_0x01a3;
    L_0x0177:
        r2 = "jpeg";
        r2 = r12.equals(r2);
        if (r2 == 0) goto L_0x0184;
    L_0x017f:
        r12 = android.graphics.Bitmap.CompressFormat.JPEG;
        r2 = ".jpg";
        goto L_0x01a3;
    L_0x0184:
        r2 = "ExpoImageManipulator";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Unsupported format: ";
        r4.append(r5);
        r4.append(r12);
        r12 = ", using JPEG instead";
        r4.append(r12);
        r12 = r4.toString();
        host.exp.exponent.p334a.C6289b.m25952b(r2, r12);
        r12 = android.graphics.Bitmap.CompressFormat.JPEG;
        r2 = ".jpg";
    L_0x01a3:
        r4 = "base64";
        r4 = r13.hasKey(r4);
        if (r4 == 0) goto L_0x01b4;
    L_0x01ab:
        r4 = "base64";
        r13 = r13.getBoolean(r4);
        if (r13 == 0) goto L_0x01b4;
    L_0x01b3:
        goto L_0x01b5;
    L_0x01b4:
        r3 = 0;
    L_0x01b5:
        r13 = 0;
        r4 = r10.mScopedContext;	 Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        r4 = r4.getCacheDir();	 Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        r5 = "ImageManipulator";
        r2 = host.exp.exponent.p346j.C6385c.m26194a(r4, r5, r2);	 Catch:{ Exception -> 0x01fa, all -> 0x01f7 }
        r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x01f4, all -> 0x01f7 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x01f4, all -> 0x01f7 }
        r1.compress(r12, r11, r4);	 Catch:{ Exception -> 0x01f1, all -> 0x01ef }
        if (r3 == 0) goto L_0x01e0;
    L_0x01cc:
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x01f1, all -> 0x01ef }
        r5.<init>();	 Catch:{ Exception -> 0x01f1, all -> 0x01ef }
        r1.compress(r12, r11, r5);	 Catch:{ Exception -> 0x01de }
        r11 = r5.toByteArray();	 Catch:{ Exception -> 0x01de }
        r11 = android.util.Base64.encodeToString(r11, r0);	 Catch:{ Exception -> 0x01de }
        r13 = r5;
        goto L_0x01e1;
    L_0x01de:
        r11 = move-exception;
        goto L_0x01fe;
    L_0x01e0:
        r11 = r13;
    L_0x01e1:
        r4.close();	 Catch:{ IOException -> 0x01ea }
        if (r13 == 0) goto L_0x0213;
    L_0x01e6:
        r13.close();	 Catch:{ IOException -> 0x01ea }
        goto L_0x0213;
    L_0x01ea:
        r12 = move-exception;
        r12.printStackTrace();
        goto L_0x0213;
    L_0x01ef:
        r11 = move-exception;
        goto L_0x0248;
    L_0x01f1:
        r11 = move-exception;
        r5 = r13;
        goto L_0x01fe;
    L_0x01f4:
        r11 = move-exception;
        r4 = r13;
        goto L_0x01fd;
    L_0x01f7:
        r11 = move-exception;
        r4 = r13;
        goto L_0x0248;
    L_0x01fa:
        r11 = move-exception;
        r2 = r13;
        r4 = r2;
    L_0x01fd:
        r5 = r4;
    L_0x01fe:
        r11.printStackTrace();	 Catch:{ all -> 0x0246 }
        if (r4 == 0) goto L_0x0209;
    L_0x0203:
        r4.close();	 Catch:{ IOException -> 0x0207 }
        goto L_0x0209;
    L_0x0207:
        r11 = move-exception;
        goto L_0x020f;
    L_0x0209:
        if (r5 == 0) goto L_0x0212;
    L_0x020b:
        r5.close();	 Catch:{ IOException -> 0x0207 }
        goto L_0x0212;
    L_0x020f:
        r11.printStackTrace();
    L_0x0212:
        r11 = r13;
    L_0x0213:
        r12 = com.facebook.react.bridge.Arguments.createMap();
        r13 = "uri";
        r0 = new java.io.File;
        r0.<init>(r2);
        r0 = android.net.Uri.fromFile(r0);
        r0 = r0.toString();
        r12.putString(r13, r0);
        r13 = "width";
        r0 = r1.getWidth();
        r12.putInt(r13, r0);
        r13 = "height";
        r0 = r1.getHeight();
        r12.putInt(r13, r0);
        if (r3 == 0) goto L_0x0242;
    L_0x023d:
        r13 = "base64";
        r12.putString(r13, r11);
    L_0x0242:
        r14.resolve(r12);
        return;
    L_0x0246:
        r11 = move-exception;
        r13 = r5;
    L_0x0248:
        if (r4 == 0) goto L_0x0250;
    L_0x024a:
        r4.close();	 Catch:{ IOException -> 0x024e }
        goto L_0x0250;
    L_0x024e:
        r12 = move-exception;
        goto L_0x0256;
    L_0x0250:
        if (r13 == 0) goto L_0x0259;
    L_0x0252:
        r13.close();	 Catch:{ IOException -> 0x024e }
        goto L_0x0259;
    L_0x0256:
        r12.printStackTrace();
    L_0x0259:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.ImageManipulatorModule.processBitmapWithActions(android.graphics.Bitmap, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }
}
