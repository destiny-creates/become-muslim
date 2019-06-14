package expo.modules.camera;

import android.content.Context;
import android.os.Build;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.p133a.C2186a;
import com.google.android.p133a.C2210k;
import expo.modules.camera.tasks.PictureSavedDelegate;
import expo.modules.camera.tasks.ResolveTakenPictureAsyncTask;
import expo.p304a.C6006c;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C5996c;
import expo.p304a.p305a.C6001h;
import expo.p304a.p305a.p306a.C5993b;
import expo.p304a.p305a.p306a.C5993b.C5992a;
import expo.p307b.p315h.C6033a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CameraModule extends C6006c implements C6001h {
    private static final String ERROR_TAG = "E_CAMERA";
    private static final String TAG = "ExponentCameraModule";
    static final Map<String, Object> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new C60731());
    static final int VIDEO_1080P = 1;
    static final int VIDEO_2160P = 0;
    static final int VIDEO_480P = 3;
    static final int VIDEO_4x3 = 4;
    static final int VIDEO_720P = 2;
    private C6007d mModuleRegistry;

    /* renamed from: expo.modules.camera.CameraModule$1 */
    static class C60731 extends HashMap<String, Object> {
        C60731() {
            put("aztec", Integer.valueOf(4096));
            put("ean13", Integer.valueOf(32));
            put("ean8", Integer.valueOf(64));
            put("qr", Integer.valueOf(256));
            put("pdf417", Integer.valueOf(2048));
            put("upc_e", Integer.valueOf(1024));
            put("datamatrix", Integer.valueOf(16));
            put("code39", Integer.valueOf(2));
            put("code93", Integer.valueOf(4));
            put("itf14", Integer.valueOf(128));
            put("codabar", Integer.valueOf(8));
            put("code128", Integer.valueOf(1));
            put("upc_a", Integer.valueOf(512));
        }
    }

    /* renamed from: expo.modules.camera.CameraModule$2 */
    class C60792 extends HashMap<String, Object> {

        /* renamed from: expo.modules.camera.CameraModule$2$1 */
        class C60741 extends HashMap<String, Object> {
            C60741() {
                put("front", Integer.valueOf(1));
                put("back", Integer.valueOf(0));
            }
        }

        /* renamed from: expo.modules.camera.CameraModule$2$2 */
        class C60752 extends HashMap<String, Object> {
            C60752() {
                put("off", Integer.valueOf(0));
                put(ViewProps.ON, Integer.valueOf(1));
                put("auto", Integer.valueOf(3));
                put("torch", Integer.valueOf(2));
            }
        }

        /* renamed from: expo.modules.camera.CameraModule$2$3 */
        class C60763 extends HashMap<String, Object> {
            C60763() {
                put(ViewProps.ON, Boolean.valueOf(true));
                put("off", Boolean.valueOf(false));
            }
        }

        /* renamed from: expo.modules.camera.CameraModule$2$4 */
        class C60774 extends HashMap<String, Object> {
            C60774() {
                put("auto", Integer.valueOf(0));
                put("cloudy", Integer.valueOf(1));
                put("sunny", Integer.valueOf(2));
                put("shadow", Integer.valueOf(3));
                put("fluorescent", Integer.valueOf(4));
                put("incandescent", Integer.valueOf(5));
            }
        }

        /* renamed from: expo.modules.camera.CameraModule$2$5 */
        class C60785 extends HashMap<String, Object> {
            C60785() {
                put("2160p", Integer.valueOf(0));
                put("1080p", Integer.valueOf(1));
                put("720p", Integer.valueOf(2));
                put("480p", Integer.valueOf(3));
                put("4:3", Integer.valueOf(4));
            }
        }

        C60792() {
            put("Type", getTypeConstants());
            put("FlashMode", getFlashModeConstants());
            put("AutoFocus", getAutoFocusConstants());
            put("WhiteBalance", getWhiteBalanceConstants());
            put("VideoQuality", getVideoQualityConstants());
            put("BarCodeType", getBarCodeConstants());
            put("FaceDetection", Collections.unmodifiableMap(new HashMap()));
        }

        private Map<String, Object> getTypeConstants() {
            return Collections.unmodifiableMap(new C60741());
        }

        private Map<String, Object> getFlashModeConstants() {
            return Collections.unmodifiableMap(new C60752());
        }

        private Map<String, Object> getAutoFocusConstants() {
            return Collections.unmodifiableMap(new C60763());
        }

        private Map<String, Object> getWhiteBalanceConstants() {
            return Collections.unmodifiableMap(new C60774());
        }

        private Map<String, Object> getVideoQualityConstants() {
            return Collections.unmodifiableMap(new C60785());
        }

        private Map<String, Object> getBarCodeConstants() {
            return CameraModule.VALID_BARCODE_TYPES;
        }
    }

    public String getName() {
        return TAG;
    }

    public CameraModule(Context context) {
        super(context);
    }

    public void setModuleRegistry(C6007d c6007d) {
        this.mModuleRegistry = c6007d;
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new C60792());
    }

    @C5996c
    public void pausePreview(int i, final C6009f c6009f) {
        addUIBlock(i, new C5992a<ExpoCameraView>() {
            public void resolve(ExpoCameraView expoCameraView) {
                try {
                    if (expoCameraView.isCameraOpened()) {
                        expoCameraView.pausePreview();
                    }
                } catch (ExpoCameraView expoCameraView2) {
                    C6009f c6009f = c6009f;
                    String str = CameraModule.ERROR_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("pausePreview -- exception occurred -- ");
                    stringBuilder.append(expoCameraView2.getMessage());
                    c6009f.mo5138a(str, stringBuilder.toString(), expoCameraView2);
                }
            }

            public void reject(Throwable th) {
                c6009f.m25154a(CameraModule.ERROR_TAG, th);
            }
        });
    }

    @C5996c
    public void resumePreview(int i, final C6009f c6009f) {
        addUIBlock(i, new C5992a<ExpoCameraView>() {
            public void resolve(ExpoCameraView expoCameraView) {
                try {
                    if (expoCameraView.isCameraOpened()) {
                        expoCameraView.resumePreview();
                    }
                } catch (ExpoCameraView expoCameraView2) {
                    C6009f c6009f = c6009f;
                    String str = CameraModule.ERROR_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("resumePreview -- exception occurred -- ");
                    stringBuilder.append(expoCameraView2.getMessage());
                    c6009f.mo5138a(str, stringBuilder.toString(), expoCameraView2);
                }
            }

            public void reject(Throwable th) {
                c6009f.m25154a(CameraModule.ERROR_TAG, th);
            }
        });
    }

    @C5996c
    public void takePicture(final Map<String, Object> map, int i, final C6009f c6009f) {
        final File cacheDir = getContext().getCacheDir();
        addUIBlock(i, new C5992a<ExpoCameraView>() {
            public void resolve(ExpoCameraView expoCameraView) {
                if (Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                    new ResolveTakenPictureAsyncTask(CameraViewHelper.generateSimulatorPhoto(expoCameraView.getWidth(), expoCameraView.getHeight()), c6009f, map, cacheDir, (PictureSavedDelegate) expoCameraView).execute(new Void[null]);
                } else if (expoCameraView.isCameraOpened()) {
                    expoCameraView.takePicture(map, c6009f, cacheDir);
                } else {
                    c6009f.m25152a("E_CAMERA_UNAVAILABLE", "Camera is not running");
                }
            }

            public void reject(Throwable th) {
                c6009f.m25154a(CameraModule.ERROR_TAG, th);
            }
        });
    }

    @C5996c
    public void record(final Map<String, Object> map, int i, final C6009f c6009f) {
        C6033a c6033a = (C6033a) this.mModuleRegistry.m25133a(C6033a.class);
        if (c6033a == null) {
            c6009f.m25152a("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
            return;
        }
        int[] permissions = c6033a.getPermissions(new String[]{"android.permission.RECORD_AUDIO"});
        if (permissions.length == 1 && permissions[0] == 0) {
            final File cacheDir = getContext().getCacheDir();
            addUIBlock(i, new C5992a<ExpoCameraView>() {
                public void resolve(ExpoCameraView expoCameraView) {
                    if (expoCameraView.isCameraOpened()) {
                        expoCameraView.record(map, c6009f, cacheDir);
                    } else {
                        c6009f.m25152a("E_CAMERA_UNAVAILABLE", "Camera is not running");
                    }
                }

                public void reject(Throwable th) {
                    c6009f.m25154a(CameraModule.ERROR_TAG, th);
                }
            });
        } else {
            c6009f.m25155a(new SecurityException("User rejected audio permissions"));
        }
    }

    @C5996c
    public void stopRecording(int i, final C6009f c6009f) {
        addUIBlock(i, new C5992a<ExpoCameraView>() {
            public void resolve(ExpoCameraView expoCameraView) {
                if (expoCameraView.isCameraOpened()) {
                    expoCameraView.stopRecording();
                    c6009f.mo5137a(Boolean.valueOf(true));
                    return;
                }
                c6009f.m25152a(CameraModule.ERROR_TAG, "Camera is not open");
            }

            public void reject(Throwable th) {
                c6009f.m25154a(CameraModule.ERROR_TAG, th);
            }
        });
    }

    @C5996c
    public void getSupportedRatios(int i, final C6009f c6009f) {
        addUIBlock(i, new C5992a<ExpoCameraView>() {
            public void resolve(ExpoCameraView expoCameraView) {
                if (expoCameraView.isCameraOpened()) {
                    ExpoCameraView<C2186a> supportedAspectRatios = expoCameraView.getSupportedAspectRatios();
                    Object arrayList = new ArrayList(supportedAspectRatios.size());
                    for (C2186a c2186a : supportedAspectRatios) {
                        arrayList.add(c2186a.toString());
                    }
                    c6009f.mo5137a(arrayList);
                    return;
                }
                c6009f.m25152a(CameraModule.ERROR_TAG, "Camera is not running");
            }

            public void reject(Throwable th) {
                c6009f.m25154a(CameraModule.ERROR_TAG, th);
            }
        });
    }

    @C5996c
    public void getAvailablePictureSizes(final String str, int i, final C6009f c6009f) {
        addUIBlock(i, new C5992a<ExpoCameraView>() {
            public void resolve(ExpoCameraView expoCameraView) {
                if (expoCameraView.isCameraOpened()) {
                    try {
                        ExpoCameraView<C2210k> availablePictureSizes = expoCameraView.getAvailablePictureSizes(C2186a.a(str));
                        Object arrayList = new ArrayList(availablePictureSizes.size());
                        for (C2210k c2210k : availablePictureSizes) {
                            arrayList.add(c2210k.toString());
                        }
                        c6009f.mo5137a(arrayList);
                        return;
                    } catch (ExpoCameraView expoCameraView2) {
                        C6009f c6009f = c6009f;
                        String str = CameraModule.ERROR_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("getAvailablePictureSizes -- unexpected error -- ");
                        stringBuilder.append(expoCameraView2.getMessage());
                        c6009f.mo5138a(str, stringBuilder.toString(), expoCameraView2);
                        return;
                    }
                }
                c6009f.m25152a(CameraModule.ERROR_TAG, "Camera is not running");
            }

            public void reject(Throwable th) {
                c6009f.m25154a(CameraModule.ERROR_TAG, th);
            }
        });
    }

    private void addUIBlock(int i, C5992a<ExpoCameraView> c5992a) {
        C5993b c5993b = (C5993b) this.mModuleRegistry.m25133a(C5993b.class);
        if (c5993b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Implementation of ");
            stringBuilder.append(C5993b.class.getName());
            stringBuilder.append(" is null. Are you sure you've included a proper Expo adapter for your platform?");
            c5992a.reject(new IllegalStateException(stringBuilder.toString()));
            return;
        }
        c5993b.addUIBlock(i, c5992a, ExpoCameraView.class);
    }
}
