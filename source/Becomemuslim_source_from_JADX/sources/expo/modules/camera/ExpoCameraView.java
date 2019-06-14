package expo.modules.camera;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.p133a.C2198e;
import com.google.android.p133a.C2198e.C2196a;
import com.google.android.p133a.C2210k;
import expo.modules.camera.tasks.BarCodeScannerAsyncTask;
import expo.modules.camera.tasks.BarCodeScannerAsyncTaskDelegate;
import expo.modules.camera.tasks.FaceDetectorAsyncTask;
import expo.modules.camera.tasks.FaceDetectorAsyncTaskDelegate;
import expo.modules.camera.tasks.PictureSavedDelegate;
import expo.modules.camera.tasks.ResolveTakenPictureAsyncTask;
import expo.modules.camera.utils.ImageDimensions;
import expo.p304a.C6007d;
import expo.p304a.C6009f;
import expo.p304a.p305a.C6000g;
import expo.p304a.p305a.p306a.C5991a;
import expo.p304a.p305a.p306a.C5993b;
import expo.p307b.p308a.C6017a;
import expo.p307b.p308a.C6018b;
import expo.p307b.p308a.C6019c;
import expo.p307b.p308a.C6020d;
import expo.p307b.p309b.C6022a;
import expo.p307b.p311d.C6024a;
import expo.p307b.p311d.C6025b;
import expo.p307b.p315h.C6033a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ExpoCameraView extends C2198e implements C6000g, C6022a, BarCodeScannerAsyncTaskDelegate, FaceDetectorAsyncTaskDelegate, PictureSavedDelegate {
    private static final String FAST_MODE_KEY = "fastMode";
    private static final String MAX_DURATION_KEY = "maxDuration";
    private static final String MAX_FILE_SIZE_KEY = "maxFileSize";
    private static final String MUTE_KEY = "mute";
    private static final String QUALITY_KEY = "quality";
    public volatile boolean barCodeScannerTaskLock = false;
    public volatile boolean faceDetectorTaskLock = false;
    private C6017a mBarCodeScanner;
    private C6024a mFaceDetector;
    private boolean mIsNew = true;
    private boolean mIsPaused = false;
    private C6007d mModuleRegistry;
    private Map<String, Object> mPendingFaceDetectorSettings;
    private Map<C6009f, File> mPictureTakenDirectories = new ConcurrentHashMap();
    private Map<C6009f, Map<String, Object>> mPictureTakenOptions = new ConcurrentHashMap();
    private Queue<C6009f> mPictureTakenPromises = new ConcurrentLinkedQueue();
    private boolean mShouldDetectFaces = false;
    private boolean mShouldScanBarCodes = false;
    private C6009f mVideoRecordedPromise;

    /* renamed from: expo.modules.camera.ExpoCameraView$1 */
    class C74071 extends C2196a {
        C74071() {
        }

        public void onCameraOpened(C2198e c2198e) {
            CameraViewHelper.emitCameraReadyEvent((C5991a) ExpoCameraView.this.mModuleRegistry.m25133a(C5991a.class), c2198e);
        }

        public void onMountError(C2198e c2198e) {
            CameraViewHelper.emitMountErrorEvent((C5991a) ExpoCameraView.this.mModuleRegistry.m25133a(C5991a.class), c2198e, "Camera component could not be rendered - is there any other instance running?");
        }

        public void onPictureTaken(C2198e c2198e, byte[] bArr) {
            C6009f c6009f = (C6009f) ExpoCameraView.this.mPictureTakenPromises.poll();
            File file = (File) ExpoCameraView.this.mPictureTakenDirectories.remove(c6009f);
            Map map = (Map) ExpoCameraView.this.mPictureTakenOptions.remove(c6009f);
            if (!(map.containsKey(ExpoCameraView.FAST_MODE_KEY) == null || ((Boolean) map.get(ExpoCameraView.FAST_MODE_KEY)).booleanValue() == null)) {
                c6009f.mo5137a((Object) null);
            }
            new ResolveTakenPictureAsyncTask(bArr, c6009f, map, file, ExpoCameraView.this).execute(new Void[null]);
        }

        public void onVideoRecorded(C2198e c2198e, String str) {
            if (ExpoCameraView.this.mVideoRecordedPromise != null) {
                if (str != null) {
                    Object bundle = new Bundle();
                    bundle.putString("uri", Uri.fromFile(new File(str)).toString());
                    ExpoCameraView.this.mVideoRecordedPromise.mo5137a(bundle);
                } else {
                    ExpoCameraView.this.mVideoRecordedPromise.m25152a("E_RECORDING", "Couldn't stop recording - there is none in progress");
                }
                ExpoCameraView.this.mVideoRecordedPromise = null;
            }
        }

        public void onFramePreview(C2198e c2198e, byte[] bArr, int i, int i2, int i3) {
            C2198e c2198e2 = c2198e;
            int correctCameraRotation = CameraViewHelper.getCorrectCameraRotation(i3, ExpoCameraView.this.getFacing());
            if (ExpoCameraView.this.mShouldScanBarCodes && !ExpoCameraView.this.barCodeScannerTaskLock && (c2198e2 instanceof BarCodeScannerAsyncTaskDelegate)) {
                ExpoCameraView.this.barCodeScannerTaskLock = true;
                new BarCodeScannerAsyncTask((BarCodeScannerAsyncTaskDelegate) c2198e2, ExpoCameraView.this.mBarCodeScanner, bArr, i, i2, i3).execute(new Void[0]);
            }
            if (ExpoCameraView.this.mShouldDetectFaces && !ExpoCameraView.this.faceDetectorTaskLock && (c2198e2 instanceof FaceDetectorAsyncTaskDelegate)) {
                ExpoCameraView.this.faceDetectorTaskLock = true;
                float f = c2198e.getResources().getDisplayMetrics().density;
                int i4 = i;
                int i5 = i2;
                ImageDimensions imageDimensions = new ImageDimensions(i4, i5, correctCameraRotation, ExpoCameraView.this.getFacing());
                byte[] bArr2 = bArr;
                int i6 = correctCameraRotation;
                new FaceDetectorAsyncTask((FaceDetectorAsyncTaskDelegate) c2198e2, ExpoCameraView.this.mFaceDetector, bArr2, i4, i5, i6, ExpoCameraView.this.getFacing(), ((double) c2198e.getWidth()) / ((double) (((float) imageDimensions.getWidth()) * f)), ((double) c2198e.getHeight()) / ((double) (((float) imageDimensions.getHeight()) * f))).execute(new Void[0]);
            }
        }
    }

    public void requestLayout() {
    }

    public ExpoCameraView(Context context, C6007d c6007d) {
        super(context, true);
        this.mModuleRegistry = c6007d;
        initBarCodeScanner();
        ((C5993b) this.mModuleRegistry.m25133a(C5993b.class)).registerLifecycleEventListener(this);
        addCallback(new C74071());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getView();
        if (z) {
            setBackgroundColor(-16777216);
            z.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    public void onViewAdded(View view) {
        if (getView() != view) {
            if (getView() != null) {
                removeView(getView());
                addView(getView(), 0);
            }
        }
    }

    public void takePicture(Map<String, Object> map, C6009f c6009f, File file) {
        this.mPictureTakenPromises.add(c6009f);
        this.mPictureTakenOptions.put(c6009f, map);
        this.mPictureTakenDirectories.put(c6009f, file);
        try {
            super.takePicture();
        } catch (Map<String, Object> map2) {
            this.mPictureTakenPromises.remove(c6009f);
            this.mPictureTakenOptions.remove(c6009f);
            this.mPictureTakenDirectories.remove(c6009f);
            throw map2;
        }
    }

    public void onPictureSaved(Bundle bundle) {
        CameraViewHelper.emitPictureSavedEvent((C5991a) this.mModuleRegistry.m25133a(C5991a.class), this, bundle);
    }

    public void record(java.util.Map<java.lang.String, java.lang.Object> r9, expo.p304a.C6009f r10, java.io.File r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = "Camera";	 Catch:{ IOException -> 0x0085 }
        r1 = ".mp4";	 Catch:{ IOException -> 0x0085 }
        r3 = expo.modules.camera.utils.FileSystemUtils.generateOutputPath(r11, r0, r1);	 Catch:{ IOException -> 0x0085 }
        r11 = "maxDuration";	 Catch:{ IOException -> 0x0085 }
        r11 = r9.get(r11);	 Catch:{ IOException -> 0x0085 }
        r0 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;	 Catch:{ IOException -> 0x0085 }
        if (r11 == 0) goto L_0x001f;	 Catch:{ IOException -> 0x0085 }
    L_0x0012:
        r11 = "maxDuration";	 Catch:{ IOException -> 0x0085 }
        r11 = r9.get(r11);	 Catch:{ IOException -> 0x0085 }
        r11 = (java.lang.Double) r11;	 Catch:{ IOException -> 0x0085 }
        r4 = r11.doubleValue();	 Catch:{ IOException -> 0x0085 }
        goto L_0x0020;	 Catch:{ IOException -> 0x0085 }
    L_0x001f:
        r4 = r0;	 Catch:{ IOException -> 0x0085 }
    L_0x0020:
        r11 = "maxFileSize";	 Catch:{ IOException -> 0x0085 }
        r11 = r9.get(r11);	 Catch:{ IOException -> 0x0085 }
        if (r11 == 0) goto L_0x0034;	 Catch:{ IOException -> 0x0085 }
    L_0x0028:
        r11 = "maxFileSize";	 Catch:{ IOException -> 0x0085 }
        r11 = r9.get(r11);	 Catch:{ IOException -> 0x0085 }
        r11 = (java.lang.Double) r11;	 Catch:{ IOException -> 0x0085 }
        r0 = r11.doubleValue();	 Catch:{ IOException -> 0x0085 }
    L_0x0034:
        r11 = r8.getCameraId();	 Catch:{ IOException -> 0x0085 }
        r2 = 1;	 Catch:{ IOException -> 0x0085 }
        r11 = android.media.CamcorderProfile.get(r11, r2);	 Catch:{ IOException -> 0x0085 }
        r6 = "quality";	 Catch:{ IOException -> 0x0085 }
        r6 = r9.get(r6);	 Catch:{ IOException -> 0x0085 }
        if (r6 == 0) goto L_0x0059;	 Catch:{ IOException -> 0x0085 }
    L_0x0045:
        r11 = r8.getCameraId();	 Catch:{ IOException -> 0x0085 }
        r6 = "quality";	 Catch:{ IOException -> 0x0085 }
        r6 = r9.get(r6);	 Catch:{ IOException -> 0x0085 }
        r6 = (java.lang.Double) r6;	 Catch:{ IOException -> 0x0085 }
        r6 = r6.intValue();	 Catch:{ IOException -> 0x0085 }
        r11 = expo.modules.camera.CameraViewHelper.getCamcorderProfile(r11, r6);	 Catch:{ IOException -> 0x0085 }
    L_0x0059:
        r7 = r11;	 Catch:{ IOException -> 0x0085 }
        r11 = "mute";	 Catch:{ IOException -> 0x0085 }
        r9 = r9.get(r11);	 Catch:{ IOException -> 0x0085 }
        r9 = (java.lang.Boolean) r9;	 Catch:{ IOException -> 0x0085 }
        if (r9 == 0) goto L_0x006e;	 Catch:{ IOException -> 0x0085 }
    L_0x0064:
        r9 = r9.booleanValue();	 Catch:{ IOException -> 0x0085 }
        if (r9 != 0) goto L_0x006b;	 Catch:{ IOException -> 0x0085 }
    L_0x006a:
        goto L_0x006e;	 Catch:{ IOException -> 0x0085 }
    L_0x006b:
        r9 = 0;	 Catch:{ IOException -> 0x0085 }
        r6 = 0;	 Catch:{ IOException -> 0x0085 }
        goto L_0x006f;	 Catch:{ IOException -> 0x0085 }
    L_0x006e:
        r6 = 1;	 Catch:{ IOException -> 0x0085 }
    L_0x006f:
        r9 = (int) r4;	 Catch:{ IOException -> 0x0085 }
        r4 = r9 * 1000;	 Catch:{ IOException -> 0x0085 }
        r5 = (int) r0;	 Catch:{ IOException -> 0x0085 }
        r2 = r8;	 Catch:{ IOException -> 0x0085 }
        r9 = super.record(r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x0085 }
        if (r9 == 0) goto L_0x007d;	 Catch:{ IOException -> 0x0085 }
    L_0x007a:
        r8.mVideoRecordedPromise = r10;	 Catch:{ IOException -> 0x0085 }
        goto L_0x008c;	 Catch:{ IOException -> 0x0085 }
    L_0x007d:
        r9 = "E_RECORDING_FAILED";	 Catch:{ IOException -> 0x0085 }
        r11 = "Starting video recording failed. Another recording might be in progress.";	 Catch:{ IOException -> 0x0085 }
        r10.m25152a(r9, r11);	 Catch:{ IOException -> 0x0085 }
        goto L_0x008c;
    L_0x0085:
        r9 = "E_RECORDING_FAILED";
        r11 = "Starting video recording failed - could not create video file.";
        r10.m25152a(r9, r11);
    L_0x008c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.ExpoCameraView.record(java.util.Map, expo.a.f, java.io.File):void");
    }

    private void initBarCodeScanner() {
        C6018b c6018b = (C6018b) this.mModuleRegistry.m25133a(C6018b.class);
        if (c6018b != null) {
            this.mBarCodeScanner = c6018b.createBarCodeDetectorWithContext(getContext());
        }
    }

    public void setShouldScanBarCodes(boolean z) {
        this.mShouldScanBarCodes = z;
        if (!this.mShouldScanBarCodes) {
            if (!this.mShouldDetectFaces) {
                z = false;
                setScanning(z);
            }
        }
        z = true;
        setScanning(z);
    }

    public void setBarCodeScannerSettings(C6020d c6020d) {
        if (this.mBarCodeScanner != null) {
            this.mBarCodeScanner.setSettings(c6020d);
        }
    }

    public void onBarCodeScanned(C6019c c6019c) {
        if (this.mShouldScanBarCodes) {
            CameraViewHelper.emitBarCodeReadEvent((C5991a) this.mModuleRegistry.m25133a(C5991a.class), this, c6019c);
        }
    }

    public void onBarCodeScanningTaskCompleted() {
        this.barCodeScannerTaskLock = false;
    }

    public int[] getPreviewSizeAsArray() {
        C2210k previewSize = getPreviewSize();
        return new int[]{previewSize.a(), previewSize.b()};
    }

    public void onHostResume() {
        if (!hasCameraPermissions()) {
            CameraViewHelper.emitMountErrorEvent((C5991a) this.mModuleRegistry.m25133a(C5991a.class), this, "Camera permissions not granted - component could not be rendered.");
        } else if ((this.mIsPaused && !isCameraOpened()) || this.mIsNew) {
            this.mIsPaused = false;
            this.mIsNew = false;
            if (!Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) {
                start();
                C6025b c6025b = (C6025b) this.mModuleRegistry.m25133a(C6025b.class);
                if (c6025b != null) {
                    this.mFaceDetector = c6025b.createFaceDetectorWithContext(getContext());
                    if (this.mPendingFaceDetectorSettings != null) {
                        this.mFaceDetector.setSettings(this.mPendingFaceDetectorSettings);
                        this.mPendingFaceDetectorSettings = null;
                    }
                }
            }
        }
    }

    public void onHostPause() {
        if (!this.mIsPaused && isCameraOpened()) {
            if (this.mFaceDetector != null) {
                this.mFaceDetector.release();
            }
            this.mIsPaused = true;
            stop();
        }
    }

    public void onHostDestroy() {
        if (this.mFaceDetector != null) {
            this.mFaceDetector.release();
        }
        stop();
    }

    private boolean hasCameraPermissions() {
        int[] permissions = ((C6033a) this.mModuleRegistry.m25133a(C6033a.class)).getPermissions(new String[]{"android.permission.CAMERA"});
        return permissions.length == 1 && permissions[0] == 0;
    }

    public void setShouldDetectFaces(boolean z) {
        this.mShouldDetectFaces = z;
        if (!this.mShouldScanBarCodes) {
            if (!this.mShouldDetectFaces) {
                z = false;
                setScanning(z);
            }
        }
        z = true;
        setScanning(z);
    }

    public void setFaceDetectorSettings(Map<String, Object> map) {
        if (this.mFaceDetector == null) {
            this.mPendingFaceDetectorSettings = map;
        } else {
            this.mFaceDetector.setSettings(map);
        }
    }

    public void onFacesDetected(List<Bundle> list) {
        if (this.mShouldDetectFaces) {
            if (list == null) {
                list = new ArrayList();
            }
            CameraViewHelper.emitFacesDetectedEvent((C5991a) this.mModuleRegistry.m25133a(C5991a.class), this, list);
        }
    }

    public void onFaceDetectionError(C6024a c6024a) {
        if (this.mShouldDetectFaces) {
            CameraViewHelper.emitFaceDetectionErrorEvent((C5991a) this.mModuleRegistry.m25133a(C5991a.class), this, c6024a);
        }
    }

    public void onFaceDetectingTaskCompleted() {
        this.faceDetectorTaskLock = false;
    }
}
