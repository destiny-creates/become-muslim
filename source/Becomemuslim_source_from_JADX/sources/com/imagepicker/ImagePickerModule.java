package com.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.C3169a;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.imagepicker.p250a.C5404a;
import com.imagepicker.p251b.C5407a;
import com.imagepicker.p251b.C5411b;
import com.imagepicker.p251b.C5411b.C5410a;
import com.imagepicker.p252c.C5418b;
import com.imagepicker.p252c.C5420d;
import com.imagepicker.p252c.C5425e;
import com.imagepicker.p252c.C5425e.C5424a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class ImagePickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int REQUEST_LAUNCH_IMAGE_CAPTURE = 13001;
    public static final int REQUEST_LAUNCH_IMAGE_LIBRARY = 13002;
    public static final int REQUEST_LAUNCH_VIDEO_CAPTURE = 13004;
    public static final int REQUEST_LAUNCH_VIDEO_LIBRARY = 13003;
    public static final int REQUEST_PERMISSIONS_FOR_CAMERA = 14001;
    public static final int REQUEST_PERMISSIONS_FOR_LIBRARY = 14002;
    protected Callback callback;
    protected Uri cameraCaptureURI;
    private final int dialogThemeId;
    private C5404a imageConfig = new C5404a(null, null, 0, 0, 100, 0, false);
    private PermissionListener listener = new C69381(this);
    private Boolean noData = Boolean.valueOf(false);
    private ReadableMap options;
    private Boolean pickVideo = Boolean.valueOf(false);
    private final ReactApplicationContext reactContext;
    private C5426c responseHelper = new C5426c();
    @Deprecated
    private int videoDurationLimit = 0;
    @Deprecated
    private int videoQuality = 1;

    /* renamed from: com.imagepicker.ImagePickerModule$1 */
    class C69381 implements PermissionListener {
        /* renamed from: a */
        final /* synthetic */ ImagePickerModule f24802a;

        C69381(ImagePickerModule imagePickerModule) {
            this.f24802a = imagePickerModule;
        }

        public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Object obj = 1;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                obj = (obj == null || (iArr[i2] == 0 ? 1 : null) == null) ? null : 1;
            }
            if (this.f24802a.callback != null) {
                if (this.f24802a.options != null) {
                    if (obj == null) {
                        this.f24802a.responseHelper.m23021b(this.f24802a.callback, "Permissions weren't granted");
                        return false;
                    }
                    switch (i) {
                        case ImagePickerModule.REQUEST_PERMISSIONS_FOR_CAMERA /*14001*/:
                            this.f24802a.launchCamera(this.f24802a.options, this.f24802a.callback);
                            break;
                        case ImagePickerModule.REQUEST_PERMISSIONS_FOR_LIBRARY /*14002*/:
                            this.f24802a.launchImageLibrary(this.f24802a.options, this.f24802a.callback);
                            break;
                        default:
                            break;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.imagepicker.ImagePickerModule$2 */
    class C69392 implements C5424a {
        /* renamed from: a */
        final /* synthetic */ ImagePickerModule f24803a;

        C69392(ImagePickerModule imagePickerModule) {
            this.f24803a = imagePickerModule;
        }

        /* renamed from: a */
        public void mo4912a(ImagePickerModule imagePickerModule) {
            if (imagePickerModule != null) {
                imagePickerModule.launchCamera();
            }
        }

        /* renamed from: b */
        public void mo4914b(ImagePickerModule imagePickerModule) {
            if (imagePickerModule != null) {
                imagePickerModule.launchImageLibrary();
            }
        }

        /* renamed from: c */
        public void mo4915c(ImagePickerModule imagePickerModule) {
            if (imagePickerModule != null) {
                imagePickerModule.doOnCancel();
            }
        }

        /* renamed from: a */
        public void mo4913a(ImagePickerModule imagePickerModule, String str) {
            if (imagePickerModule != null) {
                imagePickerModule.invokeCustomButton(str);
            }
        }
    }

    /* renamed from: com.imagepicker.ImagePickerModule$3 */
    class C69403 implements C5410a {
        /* renamed from: a */
        final /* synthetic */ ImagePickerModule f24804a;

        C69403(ImagePickerModule imagePickerModule) {
            this.f24804a = imagePickerModule;
        }

        /* renamed from: a */
        public void mo4916a(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface) {
            ImagePickerModule imagePickerModule = (ImagePickerModule) weakReference.get();
            if (imagePickerModule != null) {
                imagePickerModule.doOnCancel();
            }
        }

        /* renamed from: b */
        public void mo4917b(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface) {
            ImagePickerModule imagePickerModule = (ImagePickerModule) weakReference.get();
            if (imagePickerModule != null) {
                dialogInterface = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                dialogInterface.setData(Uri.fromParts("package", imagePickerModule.getContext().getPackageName(), null));
                weakReference = imagePickerModule.getActivity();
                if (weakReference != null) {
                    weakReference.startActivityForResult(dialogInterface, 1);
                }
            }
        }
    }

    public String getName() {
        return "ImagePickerManager";
    }

    public void onNewIntent(Intent intent) {
    }

    public ImagePickerModule(ReactApplicationContext reactApplicationContext, int i) {
        super(reactApplicationContext);
        this.dialogThemeId = i;
        this.reactContext = reactApplicationContext;
        this.reactContext.addActivityEventListener(this);
    }

    @ReactMethod
    public void showImagePicker(ReadableMap readableMap, Callback callback) {
        if (getCurrentActivity() == null) {
            this.responseHelper.m23021b(callback, "can't find current Activity");
            return;
        }
        this.callback = callback;
        this.options = readableMap;
        this.imageConfig = new C5404a(null, null, 0, 0, 100, 0, false);
        C5425e.m23012a(this, readableMap, new C69392(this)).show();
    }

    public void doOnCancel() {
        if (this.callback != null) {
            this.responseHelper.m23014a(this.callback);
            this.callback = null;
        }
    }

    public void launchCamera() {
        launchCamera(this.options, this.callback);
    }

    @ReactMethod
    public void launchCamera(ReadableMap readableMap, Callback callback) {
        if (isCameraAvailable()) {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                this.responseHelper.m23021b(callback, "can't find current Activity");
                return;
            }
            this.callback = callback;
            this.options = readableMap;
            if (permissionsCheck(currentActivity, callback, REQUEST_PERMISSIONS_FOR_CAMERA) != null) {
                Intent intent;
                parseOptions(this.options);
                if (this.pickVideo.booleanValue() != null) {
                    readableMap = REQUEST_LAUNCH_VIDEO_CAPTURE;
                    intent = new Intent("android.media.action.VIDEO_CAPTURE");
                    intent.putExtra("android.intent.extra.videoQuality", this.videoQuality);
                    if (this.videoDurationLimit > 0) {
                        intent.putExtra("android.intent.extra.durationLimit", this.videoDurationLimit);
                    }
                } else {
                    readableMap = REQUEST_LAUNCH_IMAGE_CAPTURE;
                    intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    this.imageConfig = this.imageConfig.m22975a(C5418b.m22992a(this.reactContext, this.options, false));
                    if (this.imageConfig.f18194a != null) {
                        this.cameraCaptureURI = C5420d.m22999a(this.reactContext, this.imageConfig.f18194a);
                        if (this.cameraCaptureURI == null) {
                            this.responseHelper.m23021b(callback, "Couldn't get file path for photo");
                            return;
                        }
                        intent.putExtra("output", this.cameraCaptureURI);
                    } else {
                        this.responseHelper.m23021b(callback, "Couldn't get file path for photo");
                        return;
                    }
                }
                if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                    this.responseHelper.m23021b(callback, "Cannot launch camera");
                    return;
                }
                if (VERSION.SDK_INT <= 19) {
                    for (ResolveInfo resolveInfo : this.reactContext.getPackageManager().queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)) {
                        this.reactContext.grantUriPermission(resolveInfo.activityInfo.packageName, this.cameraCaptureURI, 3);
                    }
                }
                try {
                    currentActivity.startActivityForResult(intent, readableMap);
                } catch (ReadableMap readableMap2) {
                    readableMap2.printStackTrace();
                    this.responseHelper.m23021b(callback, "Cannot launch camera");
                }
                return;
            }
            return;
        }
        this.responseHelper.m23021b(callback, "Camera not available");
    }

    public void launchImageLibrary() {
        launchImageLibrary(this.options, this.callback);
    }

    @ReactMethod
    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            this.responseHelper.m23021b(callback, "can't find current Activity");
            return;
        }
        this.callback = callback;
        this.options = readableMap;
        if (permissionsCheck(currentActivity, callback, REQUEST_PERMISSIONS_FOR_LIBRARY) != null) {
            Intent intent;
            parseOptions(this.options);
            if (this.pickVideo.booleanValue() != null) {
                readableMap = REQUEST_LAUNCH_VIDEO_LIBRARY;
                intent = new Intent("android.intent.action.PICK");
                intent.setType("video/*");
            } else {
                readableMap = REQUEST_LAUNCH_IMAGE_LIBRARY;
                intent = new Intent("android.intent.action.PICK", Media.EXTERNAL_CONTENT_URI);
            }
            if (intent.resolveActivity(this.reactContext.getPackageManager()) == null) {
                this.responseHelper.m23021b(callback, "Cannot launch photo library");
                return;
            }
            try {
                currentActivity.startActivityForResult(intent, readableMap);
            } catch (ReadableMap readableMap2) {
                readableMap2.printStackTrace();
                this.responseHelper.m23021b(callback, "Cannot launch photo library");
            }
        }
    }

    public void onActivityResult(android.app.Activity r9, int r10, int r11, android.content.Intent r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r9 = r8.passResult(r10);
        if (r9 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r9 = r8.responseHelper;
        r9.m23013a();
        r9 = -1;
        r0 = 0;
        if (r11 == r9) goto L_0x001f;
    L_0x0010:
        r9 = r8.imageConfig;
        com.imagepicker.p252c.C5418b.m22993a(r10, r9);
        r9 = r8.responseHelper;
        r10 = r8.callback;
        r9.m23014a(r10);
        r8.callback = r0;
        return;
    L_0x001f:
        r9 = 1;
        switch(r10) {
            case 13001: goto L_0x00d6;
            case 13002: goto L_0x007b;
            case 13003: goto L_0x0053;
            case 13004: goto L_0x0026;
            default: goto L_0x0023;
        };
    L_0x0023:
        r11 = r0;
        goto L_0x00d8;
    L_0x0026:
        r9 = r12.getData();
        r9 = r8.getRealPathFromURI(r9);
        r10 = r8.responseHelper;
        r11 = "uri";
        r12 = r12.getData();
        r12 = r12.toString();
        r10.m23018a(r11, r12);
        r10 = r8.responseHelper;
        r11 = "path";
        r10.m23018a(r11, r9);
        r10 = r8.reactContext;
        com.imagepicker.p252c.C5418b.m22994a(r10, r9);
        r9 = r8.responseHelper;
        r10 = r8.callback;
        r9.m23020b(r10);
        r8.callback = r0;
        return;
    L_0x0053:
        r9 = r8.responseHelper;
        r10 = "uri";
        r11 = r12.getData();
        r11 = r11.toString();
        r9.m23018a(r10, r11);
        r9 = r8.responseHelper;
        r10 = "path";
        r11 = r12.getData();
        r11 = r8.getRealPathFromURI(r11);
        r9.m23018a(r10, r11);
        r9 = r8.responseHelper;
        r10 = r8.callback;
        r9.m23020b(r10);
        r8.callback = r0;
        return;
    L_0x007b:
        r11 = r12.getData();
        r12 = r8.getRealPathFromURI(r11);
        r1 = android.text.TextUtils.isEmpty(r12);
        if (r1 != 0) goto L_0x0097;
    L_0x0089:
        r1 = android.util.Patterns.WEB_URL;
        r1 = r1.matcher(r12);
        r1 = r1.matches();
        if (r1 == 0) goto L_0x0097;
    L_0x0095:
        r1 = 1;
        goto L_0x0098;
    L_0x0097:
        r1 = 0;
    L_0x0098:
        if (r12 == 0) goto L_0x009c;
    L_0x009a:
        if (r1 == 0) goto L_0x00aa;
    L_0x009c:
        r12 = r8.createFileFromURI(r11);	 Catch:{ Exception -> 0x00b8 }
        r1 = r12.getAbsolutePath();	 Catch:{ Exception -> 0x00b8 }
        r12 = android.net.Uri.fromFile(r12);	 Catch:{ Exception -> 0x00b8 }
        r11 = r12;
        r12 = r1;
    L_0x00aa:
        r1 = r8.imageConfig;
        r2 = new java.io.File;
        r2.<init>(r12);
        r12 = r1.m22975a(r2);
        r8.imageConfig = r12;
        goto L_0x00d8;
    L_0x00b8:
        r9 = r8.responseHelper;
        r10 = "error";
        r12 = "Could not read photo";
        r9.m23018a(r10, r12);
        r9 = r8.responseHelper;
        r10 = "uri";
        r11 = r11.toString();
        r9.m23018a(r10, r11);
        r9 = r8.responseHelper;
        r10 = r8.callback;
        r9.m23020b(r10);
        r8.callback = r0;
        return;
    L_0x00d6:
        r11 = r8.cameraCaptureURI;
    L_0x00d8:
        r12 = r8.responseHelper;
        r1 = r8.imageConfig;
        r12 = com.imagepicker.p252c.C5418b.m22990a(r12, r1);
        r1 = r12.f18212b;
        if (r1 == 0) goto L_0x00f9;
    L_0x00e4:
        r9 = r8.imageConfig;
        com.imagepicker.p252c.C5418b.m22993a(r10, r9);
        r9 = r8.responseHelper;
        r10 = r8.callback;
        r11 = r12.f18212b;
        r11 = r11.getMessage();
        r9.m23021b(r10, r11);
        r8.callback = r0;
        return;
    L_0x00f9:
        r1 = new android.graphics.BitmapFactory$Options;
        r1.<init>();
        r1.inJustDecodeBounds = r9;
        r9 = r8.imageConfig;
        r9 = r9.f18194a;
        r9 = r9.getAbsolutePath();
        android.graphics.BitmapFactory.decodeFile(r9, r1);
        r5 = r1.outWidth;
        r6 = r1.outHeight;
        r9 = r8.imageConfig;
        r9 = r9.f18194a;
        r9 = r9.getAbsolutePath();
        r8.updatedResultResponse(r11, r9);
        r9 = r8.imageConfig;
        r11 = r12.f18211a;
        r9 = r9.m22977a(r5, r6, r11);
        if (r9 == 0) goto L_0x0140;
    L_0x0124:
        r9 = r8.responseHelper;
        r11 = "width";
        r9.m23017a(r11, r5);
        r9 = r8.responseHelper;
        r11 = "height";
        r9.m23017a(r11, r6);
        r9 = r8.reactContext;
        r11 = r8.imageConfig;
        r11 = r11.f18194a;
        r11 = r11.getAbsolutePath();
        com.imagepicker.p252c.C5418b.m22994a(r9, r11);
        goto L_0x019f;
    L_0x0140:
        r2 = r8.reactContext;
        r3 = r8.options;
        r4 = r8.imageConfig;
        r7 = r10;
        r9 = com.imagepicker.p252c.C5418b.m22989a(r2, r3, r4, r5, r6, r7);
        r8.imageConfig = r9;
        r9 = r8.imageConfig;
        r9 = r9.f18195b;
        if (r9 != 0) goto L_0x0162;
    L_0x0153:
        r9 = r8.imageConfig;
        com.imagepicker.p252c.C5418b.m22993a(r10, r9);
        r9 = r8.responseHelper;
        r11 = "error";
        r12 = "Can't resize the image";
        r9.m23018a(r11, r12);
        goto L_0x019f;
    L_0x0162:
        r9 = r8.imageConfig;
        r9 = r9.f18195b;
        r9 = android.net.Uri.fromFile(r9);
        r11 = r8.imageConfig;
        r11 = r11.f18195b;
        r11 = r11.getAbsolutePath();
        android.graphics.BitmapFactory.decodeFile(r11, r1);
        r11 = r8.responseHelper;
        r12 = "width";
        r2 = r1.outWidth;
        r11.m23017a(r12, r2);
        r11 = r8.responseHelper;
        r12 = "height";
        r1 = r1.outHeight;
        r11.m23017a(r12, r1);
        r11 = r8.imageConfig;
        r11 = r11.f18195b;
        r11 = r11.getAbsolutePath();
        r8.updatedResultResponse(r9, r11);
        r9 = r8.reactContext;
        r11 = r8.imageConfig;
        r11 = r11.f18195b;
        r11 = r11.getAbsolutePath();
        com.imagepicker.p252c.C5418b.m22994a(r9, r11);
    L_0x019f:
        r9 = r8.imageConfig;
        r9 = r9.f18200g;
        if (r9 == 0) goto L_0x01f0;
    L_0x01a5:
        r9 = 13001; // 0x32c9 float:1.8218E-41 double:6.4233E-320;
        if (r10 != r9) goto L_0x01f0;
    L_0x01a9:
        r9 = r8.imageConfig;
        r9 = com.imagepicker.p252c.C5418b.m22991a(r9);
        r11 = r9.f18214b;
        if (r11 != 0) goto L_0x01cf;
    L_0x01b3:
        r9 = r9.f18213a;
        r8.imageConfig = r9;
        r9 = r8.imageConfig;
        r9 = r9.m22976a();
        r9 = android.net.Uri.fromFile(r9);
        r10 = r8.imageConfig;
        r10 = r10.m22976a();
        r10 = r10.getAbsolutePath();
        r8.updatedResultResponse(r9, r10);
        goto L_0x01f0;
    L_0x01cf:
        r11 = r8.imageConfig;
        com.imagepicker.p252c.C5418b.m22993a(r10, r11);
        r10 = new java.lang.StringBuilder;
        r11 = "Error moving image to camera roll: ";
        r10.<init>(r11);
        r9 = r9.f18214b;
        r9 = r9.getMessage();
        r10.append(r9);
        r9 = r10.toString();
        r10 = r8.responseHelper;
        r11 = "error";
        r10.m23018a(r11, r9);
        return;
    L_0x01f0:
        r9 = r8.responseHelper;
        r10 = r8.callback;
        r9.m23020b(r10);
        r8.callback = r0;
        r8.options = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.ImagePickerModule.onActivityResult(android.app.Activity, int, int, android.content.Intent):void");
    }

    public void invokeCustomButton(String str) {
        this.responseHelper.m23015a(this.callback, str);
    }

    public Context getContext() {
        return getReactApplicationContext();
    }

    public int getDialogThemeId() {
        return this.dialogThemeId;
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    private boolean passResult(int i) {
        if (!(this.callback == null || (this.cameraCaptureURI == null && i == REQUEST_LAUNCH_IMAGE_CAPTURE))) {
            if (i == REQUEST_LAUNCH_IMAGE_CAPTURE || i == REQUEST_LAUNCH_IMAGE_LIBRARY || i == REQUEST_LAUNCH_VIDEO_LIBRARY || i == REQUEST_LAUNCH_VIDEO_CAPTURE) {
                return false;
            }
        }
        return true;
    }

    private void updatedResultResponse(Uri uri, String str) {
        this.responseHelper.m23018a("uri", uri.toString());
        this.responseHelper.m23018a("path", str);
        if (this.noData.booleanValue() == null) {
            this.responseHelper.m23018a("data", getBase64StringFromFile(str));
        }
        putExtraFileInfo(str, this.responseHelper);
    }

    private boolean permissionsCheck(Activity activity, Callback callback, int i) {
        boolean z = true;
        callback = (C3169a.b(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == null && C3169a.b(activity, "android.permission.CAMERA") == 0) ? true : null;
        if (callback != null) {
            return true;
        }
        if (C3169a.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == null || C3169a.a(activity, "android.permission.CAMERA") == null) {
            z = false;
        }
        if (Boolean.valueOf(z).booleanValue() != null) {
            activity = C5411b.m22983a(this, this.options, new C69403(this));
            if (activity != null) {
                activity.show();
            }
            return false;
        }
        callback = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"};
        if (activity instanceof ReactActivity) {
            ((ReactActivity) activity).requestPermissions(callback, i, this.listener);
        } else if (activity instanceof PermissionAwareActivity) {
            ((PermissionAwareActivity) activity).requestPermissions(callback, i, this.listener);
        } else if (activity instanceof C5407a) {
            ((C5407a) activity).m22980a(this.listener);
            C3169a.a(activity, callback, i);
        } else {
            callback = new StringBuilder(activity.getClass().getSimpleName());
            callback.append(" must implement ");
            callback.append(C5407a.class.getSimpleName());
            callback.append(" or ");
            callback.append(PermissionAwareActivity.class.getSimpleName());
            throw new UnsupportedOperationException(callback.toString());
        }
        return false;
    }

    private boolean isCameraAvailable() {
        if (!this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera")) {
            if (!this.reactContext.getPackageManager().hasSystemFeature("android.hardware.camera.any")) {
                return false;
            }
        }
        return true;
    }

    private String getRealPathFromURI(Uri uri) {
        return C5420d.m23000a(this.reactContext, uri);
    }

    private File createFileFromURI(Uri uri) {
        File externalCacheDir = this.reactContext.getExternalCacheDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("photo-");
        stringBuilder.append(uri.getLastPathSegment());
        File file = new File(externalCacheDir, stringBuilder.toString());
        uri = this.reactContext.getContentResolver().openInputStream(uri);
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = uri.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            return file;
        } finally {
            fileOutputStream.close();
            uri.close();
        }
    }

    private String getBase64StringFromFile(String str) {
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
        } catch (String str2) {
            str2.printStackTrace();
            fileInputStream = null;
        }
        str2 = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = fileInputStream.read(str2);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(str2, 0, read);
            } catch (String str22) {
                str22.printStackTrace();
            }
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    private void putExtraFileInfo(String str, C5426c c5426c) {
        try {
            File file = new File(str);
            c5426c.m23016a("fileSize", (double) file.length());
            c5426c.m23018a("fileName", file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        str = MimeTypeMap.getFileExtensionFromUrl(str);
        if (str != null) {
            c5426c.m23018a("type", MimeTypeMap.getSingleton().getMimeTypeFromExtension(str));
        }
    }

    private void parseOptions(ReadableMap readableMap) {
        this.noData = Boolean.valueOf(false);
        if (readableMap.hasKey("noData")) {
            this.noData = Boolean.valueOf(readableMap.getBoolean("noData"));
        }
        this.imageConfig = this.imageConfig.m22974a(readableMap);
        this.pickVideo = Boolean.valueOf(false);
        if (readableMap.hasKey("mediaType") && readableMap.getString("mediaType").equals("video")) {
            this.pickVideo = Boolean.valueOf(true);
        }
        this.videoQuality = 1;
        if (readableMap.hasKey("videoQuality") && readableMap.getString("videoQuality").equals("low")) {
            this.videoQuality = 0;
        }
        this.videoDurationLimit = 0;
        if (readableMap.hasKey("durationLimit")) {
            this.videoDurationLimit = readableMap.getInt("durationLimit");
        }
    }
}
