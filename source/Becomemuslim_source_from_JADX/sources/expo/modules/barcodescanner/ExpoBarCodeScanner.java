package expo.modules.barcodescanner;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Log;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpoBarCodeScanner {
    static final int CAMERA_TYPE_BACK = 2;
    static final int CAMERA_TYPE_FRONT = 1;
    private static ExpoBarCodeScanner ourInstance;
    private int mActualDeviceOrientation;
    private int mAdjustedDeviceOrientation;
    private Camera mCamera = null;
    private final HashMap<Integer, CameraInfoWrapper> mCameraInfos;
    private final HashMap<Integer, Integer> mCameraTypeToIndex;
    private final Set<Number> mCameras;

    private class CameraInfoWrapper {
        public final CameraInfo info;
        public int previewHeight = -1;
        public int previewWidth = -1;
        public int rotation = null;

        public CameraInfoWrapper(CameraInfo cameraInfo) {
            this.info = cameraInfo;
        }
    }

    public static ExpoBarCodeScanner getInstance() {
        return ourInstance;
    }

    public static void createInstance(int i) {
        ourInstance = new ExpoBarCodeScanner(i);
    }

    public Camera acquireCameraInstance(int i) {
        if (this.mCamera == null && this.mCameras.contains(Integer.valueOf(i)) && this.mCameraTypeToIndex.get(Integer.valueOf(i)) != null) {
            try {
                this.mCamera = Camera.open(((Integer) this.mCameraTypeToIndex.get(Integer.valueOf(i))).intValue());
                adjustPreviewLayout(i);
            } catch (int i2) {
                Log.e("ExpoBarCodeScanner", "acquireCameraInstance failed", i2);
            }
        }
        return this.mCamera;
    }

    public void releaseCameraInstance() {
        if (this.mCamera != null) {
            this.mCamera.release();
            this.mCamera = null;
        }
    }

    public int getPreviewWidth(int i) {
        CameraInfoWrapper cameraInfoWrapper = (CameraInfoWrapper) this.mCameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewWidth;
    }

    public int getPreviewHeight(int i) {
        CameraInfoWrapper cameraInfoWrapper = (CameraInfoWrapper) this.mCameraInfos.get(Integer.valueOf(i));
        if (cameraInfoWrapper == null) {
            return 0;
        }
        return cameraInfoWrapper.previewHeight;
    }

    public Size getBestSize(List<Size> list, int i, int i2) {
        Size size = null;
        for (Size size2 : list) {
            if (size2.width <= i) {
                if (size2.height <= i2) {
                    if (size != null) {
                        if (size2.width * size2.height > size.width * size.height) {
                        }
                    }
                    size = size2;
                }
            }
        }
        return size;
    }

    public int getActualDeviceOrientation() {
        return this.mActualDeviceOrientation;
    }

    public void setAdjustedDeviceOrientation(int i) {
        this.mAdjustedDeviceOrientation = i;
    }

    public void setActualDeviceOrientation(int i) {
        this.mActualDeviceOrientation = i;
        adjustPreviewLayout(1);
        adjustPreviewLayout(2);
    }

    public void adjustPreviewLayout(int i) {
        if (this.mCamera != null) {
            CameraInfoWrapper cameraInfoWrapper = (CameraInfoWrapper) this.mCameraInfos.get(Integer.valueOf(i));
            if (cameraInfoWrapper != null) {
                int i2;
                int i3 = cameraInfoWrapper.info.orientation;
                if (cameraInfoWrapper.info.facing == 1) {
                    i2 = ((this.mActualDeviceOrientation * 90) + i3) % 360;
                    i3 = ((720 - i3) - (this.mActualDeviceOrientation * 90)) % 360;
                } else {
                    i2 = ((i3 - (this.mActualDeviceOrientation * 90)) + 360) % 360;
                    i3 = i2;
                }
                cameraInfoWrapper.rotation = i2;
                setAdjustedDeviceOrientation(i2);
                this.mCamera.setDisplayOrientation(i3);
                Parameters parameters = this.mCamera.getParameters();
                parameters.setRotation(cameraInfoWrapper.rotation);
                Size bestSize = getBestSize(parameters.getSupportedPreviewSizes(), Integer.MAX_VALUE, Integer.MAX_VALUE);
                int i4 = bestSize.width;
                i2 = bestSize.height;
                parameters.setPreviewSize(i4, i2);
                try {
                    this.mCamera.setParameters(parameters);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (cameraInfoWrapper.rotation != 0) {
                    if (cameraInfoWrapper.rotation != RotationOptions.ROTATE_180) {
                        cameraInfoWrapper.previewWidth = i2;
                        cameraInfoWrapper.previewHeight = i4;
                    }
                }
                cameraInfoWrapper.previewWidth = i4;
                cameraInfoWrapper.previewHeight = i2;
            }
        }
    }

    private ExpoBarCodeScanner(int i) {
        int i2 = 0;
        this.mActualDeviceOrientation = 0;
        this.mAdjustedDeviceOrientation = 0;
        this.mCameras = new HashSet();
        this.mCameraInfos = new HashMap();
        this.mCameraTypeToIndex = new HashMap();
        this.mActualDeviceOrientation = i;
        while (i2 < Camera.getNumberOfCameras()) {
            i = new CameraInfo();
            Camera.getCameraInfo(i2, i);
            if (i.facing == 1 && this.mCameraInfos.get(Integer.valueOf(1)) == null) {
                this.mCameraInfos.put(Integer.valueOf(1), new CameraInfoWrapper(i));
                this.mCameraTypeToIndex.put(Integer.valueOf(1), Integer.valueOf(i2));
                this.mCameras.add(Integer.valueOf(1));
            } else if (i.facing == 0 && this.mCameraInfos.get(Integer.valueOf(2)) == null) {
                this.mCameraInfos.put(Integer.valueOf(2), new CameraInfoWrapper(i));
                this.mCameraTypeToIndex.put(Integer.valueOf(2), Integer.valueOf(i2));
                this.mCameras.add(Integer.valueOf(2));
            }
            i2++;
        }
    }
}
