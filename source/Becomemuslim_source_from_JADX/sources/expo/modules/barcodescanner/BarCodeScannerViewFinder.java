package expo.modules.barcodescanner;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import expo.p304a.C6007d;
import expo.p307b.p308a.C6017a;
import expo.p307b.p308a.C6018b;
import expo.p307b.p308a.C6020d;

class BarCodeScannerViewFinder extends TextureView implements PreviewCallback, SurfaceTextureListener {
    public static volatile boolean barCodeScannerTaskLock = false;
    private C6017a mBarCodeScanner;
    private BarCodeScannerView mBarCodeScannerView;
    private Camera mCamera;
    private int mCameraType;
    private boolean mIsChanging;
    private boolean mIsStarting;
    private boolean mIsStopping;
    private final C6007d mModuleRegistry;
    private SurfaceTexture mSurfaceTexture;

    private class BarCodeScannerAsyncTask extends AsyncTask<Void, Void, Void> {
        private final Camera mCamera;
        private byte[] mImageData;

        BarCodeScannerAsyncTask(Camera camera, byte[] bArr, BarCodeScannerView barCodeScannerView) {
            this.mCamera = camera;
            this.mImageData = bArr;
            BarCodeScannerViewFinder.this.mBarCodeScannerView = barCodeScannerView;
        }

        protected Void doInBackground(Void... voidArr) {
            if (isCancelled() != null) {
                return null;
            }
            if (BarCodeScannerViewFinder.this.mIsChanging == null && this.mCamera != null) {
                voidArr = this.mCamera.getParameters().getPreviewSize();
                voidArr = BarCodeScannerViewFinder.this.mBarCodeScanner.scan(this.mImageData, voidArr.width, voidArr.height, ExpoBarCodeScanner.getInstance().getActualDeviceOrientation());
                if (voidArr != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            BarCodeScannerViewFinder.this.mBarCodeScannerView.onBarCodeScanned(voidArr);
                        }
                    });
                }
            }
            BarCodeScannerViewFinder.barCodeScannerTaskLock = null;
            return null;
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public BarCodeScannerViewFinder(Context context, int i, BarCodeScannerView barCodeScannerView, C6007d c6007d) {
        super(context);
        this.mModuleRegistry = c6007d;
        this.mCameraType = i;
        this.mBarCodeScannerView = barCodeScannerView;
        setSurfaceTextureListener(this);
        initBarCodeScanner();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.mSurfaceTexture = surfaceTexture;
        startCamera();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = null;
        stopCamera();
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.mSurfaceTexture = surfaceTexture;
    }

    public double getRatio() {
        return (double) (((float) ExpoBarCodeScanner.getInstance().getPreviewWidth(this.mCameraType)) / ((float) ExpoBarCodeScanner.getInstance().getPreviewHeight(this.mCameraType)));
    }

    public void setCameraType(final int i) {
        if (this.mCameraType != i) {
            new Thread(new Runnable() {
                public void run() {
                    BarCodeScannerViewFinder.this.mIsChanging = true;
                    BarCodeScannerViewFinder.this.stopPreview();
                    BarCodeScannerViewFinder.this.mCameraType = i;
                    BarCodeScannerViewFinder.this.startPreview();
                    BarCodeScannerViewFinder.this.mIsChanging = false;
                }
            }).start();
        }
    }

    private void startPreview() {
        if (this.mSurfaceTexture != null) {
            startCamera();
        }
    }

    private void stopPreview() {
        if (this.mCamera != null) {
            stopCamera();
        }
    }

    private synchronized void startCamera() {
        if (!this.mIsStarting) {
            this.mIsStarting = true;
            try {
                this.mCamera = ExpoBarCodeScanner.getInstance().acquireCameraInstance(this.mCameraType);
                Parameters parameters = this.mCamera.getParameters();
                if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                    parameters.setFocusMode("continuous-picture");
                }
                Size bestSize = ExpoBarCodeScanner.getInstance().getBestSize(parameters.getSupportedPictureSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
                parameters.setPictureSize(bestSize.width, bestSize.height);
                this.mCamera.setParameters(parameters);
                this.mCamera.setPreviewTexture(this.mSurfaceTexture);
                this.mCamera.startPreview();
                this.mCamera.setPreviewCallback(this);
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                    stopCamera();
                } catch (Throwable th) {
                    this.mIsStarting = false;
                }
            }
            this.mIsStarting = false;
        }
    }

    private synchronized void stopCamera() {
        if (!this.mIsStopping) {
            this.mIsStopping = true;
            try {
                if (this.mCamera != null) {
                    this.mCamera.stopPreview();
                    this.mCamera.setPreviewCallback(null);
                    ExpoBarCodeScanner.getInstance().releaseCameraInstance();
                    this.mCamera = null;
                }
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                } catch (Throwable th) {
                    this.mIsStopping = false;
                }
            }
            this.mIsStopping = false;
        }
    }

    private void initBarCodeScanner() {
        C6018b c6018b = (C6018b) this.mModuleRegistry.m25133a(C6018b.class);
        if (c6018b != null) {
            this.mBarCodeScanner = c6018b.createBarCodeDetectorWithContext(getContext());
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (!barCodeScannerTaskLock) {
            barCodeScannerTaskLock = true;
            new BarCodeScannerAsyncTask(camera, bArr, this.mBarCodeScannerView).execute(new Void[null]);
        }
    }

    public void setBarCodeScannerSettings(C6020d c6020d) {
        this.mBarCodeScanner.setSettings(c6020d);
    }
}
