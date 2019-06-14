package expo.modules.barcodescanner;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import expo.p304a.C6007d;
import expo.p304a.p305a.p306a.C5991a;
import expo.p307b.p308a.C6019c;
import expo.p307b.p308a.C6020d;

public class BarCodeScannerView extends ViewGroup {
    private int mActualDeviceOrientation = -1;
    private final Context mContext;
    private final C6007d mModuleRegistry;
    private final OrientationEventListener mOrientationListener;
    private BarCodeScannerViewFinder mViewFinder = null;

    public BarCodeScannerView(final Context context, C6007d c6007d) {
        super(context);
        this.mContext = context;
        this.mModuleRegistry = c6007d;
        ExpoBarCodeScanner.createInstance(getDeviceOrientation(context));
        this.mOrientationListener = new OrientationEventListener(3, context) {
            public void onOrientationChanged(int i) {
                if (BarCodeScannerView.this.setActualDeviceOrientation(context) != 0) {
                    BarCodeScannerView.this.layoutViewFinder();
                }
            }
        };
        if (this.mOrientationListener.canDetectOrientation() != null) {
            this.mOrientationListener.enable();
        } else {
            this.mOrientationListener.disable();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutViewFinder(i, i2, i3, i4);
    }

    public void onViewAdded(View view) {
        if (this.mViewFinder != view) {
            removeView(this.mViewFinder);
            addView(this.mViewFinder, 0);
        }
    }

    public void onBarCodeScanned(C6019c c6019c) {
        ((C5991a) this.mModuleRegistry.m25133a(C5991a.class)).mo5141a(getId(), BarCodeScannedEvent.obtain(getId(), c6019c));
    }

    public void setCameraType(int i) {
        if (this.mViewFinder != null) {
            this.mViewFinder.setCameraType(i);
            ExpoBarCodeScanner.getInstance().adjustPreviewLayout(i);
            return;
        }
        this.mViewFinder = new BarCodeScannerViewFinder(this.mContext, i, this, this.mModuleRegistry);
        addView(this.mViewFinder);
    }

    public void setBarCodeScannerSettings(C6020d c6020d) {
        this.mViewFinder.setBarCodeScannerSettings(c6020d);
    }

    private boolean setActualDeviceOrientation(Context context) {
        context = getDeviceOrientation(context);
        if (this.mActualDeviceOrientation == context) {
            return null;
        }
        this.mActualDeviceOrientation = context;
        ExpoBarCodeScanner.getInstance().setActualDeviceOrientation(this.mActualDeviceOrientation);
        return true;
    }

    private int getDeviceOrientation(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    private void layoutViewFinder() {
        layoutViewFinder(getLeft(), getTop(), getRight(), getBottom());
    }

    private void layoutViewFinder(int i, int i2, int i3, int i4) {
        if (this.mViewFinder != null) {
            i = (float) (i3 - i);
            i2 = (float) (i4 - i2);
            i3 = this.mViewFinder.getRatio();
            double d = ((double) i2) * i3;
            double d2 = (double) i;
            if (d < d2) {
                i3 = (int) (d2 / i3);
                i4 = (int) i;
            } else {
                i4 = (int) d;
                i3 = (int) i2;
            }
            i = (int) ((i - ((float) i4)) / 1073741824);
            i2 = (int) ((i2 - ((float) i3)) / 1073741824);
            this.mViewFinder.layout(i, i2, i4 + i, i3 + i2);
            postInvalidate(getLeft(), getTop(), getRight(), getBottom());
        }
    }
}
