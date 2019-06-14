package com.google.android.p133a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p030f.C0392e;
import android.support.v4.p030f.C0393f;
import android.support.v4.view.C0517s;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.p133a.C2200f.C2199a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: CameraView */
/* renamed from: com.google.android.a.e */
public class C2198e extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int FACING_BACK = 0;
    public static final int FACING_FRONT = 1;
    public static final int FLASH_AUTO = 3;
    public static final int FLASH_OFF = 0;
    public static final int FLASH_ON = 1;
    public static final int FLASH_RED_EYE = 4;
    public static final int FLASH_TORCH = 2;
    private boolean mAdjustViewBounds;
    private final C4074b mCallbacks;
    private Context mContext;
    private final C2203h mDisplayOrientationDetector;
    C2200f mImpl;

    /* compiled from: CameraView */
    /* renamed from: com.google.android.a.e$a */
    public static abstract class C2196a {
        public void onCameraClosed(C2198e c2198e) {
        }

        public void onCameraOpened(C2198e c2198e) {
        }

        public void onFramePreview(C2198e c2198e, byte[] bArr, int i, int i2, int i3) {
        }

        public void onMountError(C2198e c2198e) {
        }

        public void onPictureTaken(C2198e c2198e, byte[] bArr) {
        }

        public void onVideoRecorded(C2198e c2198e, String str) {
        }
    }

    /* compiled from: CameraView */
    /* renamed from: com.google.android.a.e$c */
    protected static class C2197c extends BaseSavedState {
        public static final Creator<C2197c> CREATOR = C0392e.m1170a(new C40751());
        /* renamed from: a */
        int f5237a;
        /* renamed from: b */
        C2186a f5238b;
        /* renamed from: c */
        boolean f5239c;
        /* renamed from: d */
        int f5240d;
        /* renamed from: e */
        float f5241e;
        /* renamed from: f */
        float f5242f;
        /* renamed from: g */
        int f5243g;
        /* renamed from: h */
        boolean f5244h;
        /* renamed from: i */
        C2210k f5245i;

        /* compiled from: CameraView */
        /* renamed from: com.google.android.a.e$c$1 */
        static class C40751 implements C0393f<C2197c> {
            C40751() {
            }

            /* renamed from: a */
            public /* synthetic */ Object mo817a(Parcel parcel, ClassLoader classLoader) {
                return m12629b(parcel, classLoader);
            }

            /* renamed from: a */
            public /* synthetic */ Object[] mo818a(int i) {
                return m12630b(i);
            }

            /* renamed from: b */
            public C2197c m12629b(Parcel parcel, ClassLoader classLoader) {
                return new C2197c(parcel, classLoader);
            }

            /* renamed from: b */
            public C2197c[] m12630b(int i) {
                return new C2197c[i];
            }
        }

        public C2197c(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f5237a = parcel.readInt();
            this.f5238b = (C2186a) parcel.readParcelable(classLoader);
            boolean z = false;
            this.f5239c = parcel.readByte() != (byte) 0;
            this.f5240d = parcel.readInt();
            this.f5241e = parcel.readFloat();
            this.f5242f = parcel.readFloat();
            this.f5243g = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            }
            this.f5244h = z;
            this.f5245i = (C2210k) parcel.readParcelable(classLoader);
        }

        public C2197c(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f5237a);
            parcel.writeParcelable(this.f5238b, 0);
            parcel.writeByte((byte) this.f5239c);
            parcel.writeInt(this.f5240d);
            parcel.writeFloat(this.f5241e);
            parcel.writeFloat(this.f5242f);
            parcel.writeInt(this.f5243g);
            parcel.writeByte((byte) this.f5244h);
            parcel.writeParcelable(this.f5245i, i);
        }
    }

    /* compiled from: CameraView */
    /* renamed from: com.google.android.a.e$b */
    private class C4074b implements C2199a {
        /* renamed from: a */
        final /* synthetic */ C2198e f10216a;
        /* renamed from: b */
        private final ArrayList<C2196a> f10217b = new ArrayList();
        /* renamed from: c */
        private boolean f10218c;

        C4074b(C2198e c2198e) {
            this.f10216a = c2198e;
        }

        /* renamed from: a */
        public void m12619a(C2196a c2196a) {
            this.f10217b.add(c2196a);
        }

        /* renamed from: b */
        public void m12624b(C2196a c2196a) {
            this.f10217b.remove(c2196a);
        }

        /* renamed from: a */
        public void mo2094a() {
            if (this.f10218c) {
                this.f10218c = false;
                this.f10216a.requestLayout();
            }
            Iterator it = this.f10217b.iterator();
            while (it.hasNext()) {
                ((C2196a) it.next()).onCameraOpened(this.f10216a);
            }
        }

        /* renamed from: b */
        public void mo2098b() {
            Iterator it = this.f10217b.iterator();
            while (it.hasNext()) {
                ((C2196a) it.next()).onCameraClosed(this.f10216a);
            }
        }

        /* renamed from: a */
        public void mo2096a(byte[] bArr) {
            Iterator it = this.f10217b.iterator();
            while (it.hasNext()) {
                ((C2196a) it.next()).onPictureTaken(this.f10216a, bArr);
            }
        }

        /* renamed from: a */
        public void mo2095a(String str) {
            Iterator it = this.f10217b.iterator();
            while (it.hasNext()) {
                ((C2196a) it.next()).onVideoRecorded(this.f10216a, str);
            }
        }

        /* renamed from: a */
        public void mo2097a(byte[] bArr, int i, int i2, int i3) {
            Iterator it = this.f10217b.iterator();
            while (it.hasNext()) {
                ((C2196a) it.next()).onFramePreview(this.f10216a, bArr, i, i2, i3);
            }
        }

        /* renamed from: c */
        public void mo2099c() {
            Iterator it = this.f10217b.iterator();
            while (it.hasNext()) {
                ((C2196a) it.next()).onMountError(this.f10216a);
            }
        }

        /* renamed from: d */
        public void m12626d() {
            this.f10218c = true;
        }
    }

    public C2198e(Context context, boolean z) {
        this(context, null, z);
    }

    public C2198e(Context context, AttributeSet attributeSet, boolean z) {
        this(context, attributeSet, 0, z);
    }

    public C2198e(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        if (isInEditMode() != null) {
            this.mCallbacks = null;
            this.mDisplayOrientationDetector = null;
            return;
        }
        this.mAdjustViewBounds = true;
        this.mContext = context;
        attributeSet = createPreviewImpl(context);
        this.mCallbacks = new C4074b(this);
        if (!z) {
            if (VERSION.SDK_INT >= true) {
                if (VERSION.SDK_INT < true) {
                    this.mImpl = new C4072c(this.mCallbacks, attributeSet, context);
                } else {
                    this.mImpl = new C4689d(this.mCallbacks, attributeSet, context);
                }
                this.mDisplayOrientationDetector = new C2203h(this, context) {
                    /* renamed from: a */
                    final /* synthetic */ C2198e f10215a;

                    /* renamed from: a */
                    public void mo2093a(int i) {
                        this.f10215a.mImpl.mo2074d(i);
                    }
                };
            }
        }
        this.mImpl = new C4069b(this.mCallbacks, attributeSet);
        this.mDisplayOrientationDetector = /* anonymous class already generated */;
    }

    private C2205i createPreviewImpl(Context context) {
        if (VERSION.SDK_INT < 14) {
            return new C4076m(context, this);
        }
        return new C4077n(context, this);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.mDisplayOrientationDetector.m6076a(C0517s.m1685C(this));
        }
    }

    protected void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.mDisplayOrientationDetector.m6074a();
        }
        super.onDetachedFromWindow();
    }

    protected void onMeasure(int i, int i2) {
        if (isInEditMode()) {
            super.onMeasure(i, i2);
            return;
        }
        if (!this.mAdjustViewBounds) {
            super.onMeasure(i, i2);
        } else if (isCameraOpened()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 != 1073741824) {
                mode = (int) (((float) MeasureSpec.getSize(i)) * getAspectRatio().m6029c());
                if (mode2 == LinearLayoutManager.INVALID_OFFSET) {
                    mode = Math.min(mode, MeasureSpec.getSize(i2));
                }
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(mode, 1073741824));
            } else if (mode == 1073741824 || mode2 != 1073741824) {
                super.onMeasure(i, i2);
            } else {
                mode2 = (int) (((float) MeasureSpec.getSize(i2)) * getAspectRatio().m6029c());
                if (mode == LinearLayoutManager.INVALID_OFFSET) {
                    mode2 = Math.min(mode2, MeasureSpec.getSize(i));
                }
                super.onMeasure(MeasureSpec.makeMeasureSpec(mode2, 1073741824), i2);
            }
        } else {
            this.mCallbacks.m12626d();
            super.onMeasure(i, i2);
            return;
        }
        i = getMeasuredWidth();
        i2 = getMeasuredHeight();
        C2186a aspectRatio = getAspectRatio();
        if (this.mDisplayOrientationDetector.m6077b() % RotationOptions.ROTATE_180 == 0) {
            aspectRatio = aspectRatio.m6030d();
        }
        if (i2 < (aspectRatio.m6028b() * i) / aspectRatio.m6025a()) {
            this.mImpl.m6041C().measure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec((i * aspectRatio.m6028b()) / aspectRatio.m6025a(), 1073741824));
        } else {
            this.mImpl.m6041C().measure(MeasureSpec.makeMeasureSpec((aspectRatio.m6025a() * i2) / aspectRatio.m6028b(), 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
        }
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c2197c = new C2197c(super.onSaveInstanceState());
        c2197c.f5237a = getFacing();
        c2197c.f5238b = getAspectRatio();
        c2197c.f5239c = getAutoFocus();
        c2197c.f5240d = getFlash();
        c2197c.f5241e = getFocusDepth();
        c2197c.f5242f = getZoom();
        c2197c.f5243g = getWhiteBalance();
        c2197c.f5244h = getScanning();
        c2197c.f5245i = getPictureSize();
        return c2197c;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C2197c) {
            C2197c c2197c = (C2197c) parcelable;
            super.onRestoreInstanceState(c2197c.getSuperState());
            setFacing(c2197c.f5237a);
            setAspectRatio(c2197c.f5238b);
            setAutoFocus(c2197c.f5239c);
            setFlash(c2197c.f5240d);
            setFocusDepth(c2197c.f5241e);
            setZoom(c2197c.f5242f);
            setWhiteBalance(c2197c.f5243g);
            setScanning(c2197c.f5244h);
            setPictureSize(c2197c.f5245i);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setUsingCamera2Api(boolean z) {
        if (VERSION.SDK_INT >= 21) {
            boolean isCameraOpened = isCameraOpened();
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (z) {
                if (isCameraOpened) {
                    stop();
                }
                if (VERSION.SDK_INT < true) {
                    this.mImpl = new C4072c(this.mCallbacks, this.mImpl.f5247g, this.mContext);
                } else {
                    this.mImpl = new C4689d(this.mCallbacks, this.mImpl.f5247g, this.mContext);
                }
            } else if (!(this.mImpl instanceof C4069b)) {
                if (isCameraOpened) {
                    stop();
                }
                this.mImpl = new C4069b(this.mCallbacks, this.mImpl.f5247g);
            } else {
                return;
            }
            onRestoreInstanceState(onSaveInstanceState);
            if (isCameraOpened) {
                start();
            }
        }
    }

    public void start() {
        if (!this.mImpl.mo2065a()) {
            if (this.mImpl.m6041C() != null) {
                removeView(this.mImpl.m6041C());
            }
            Parcelable onSaveInstanceState = onSaveInstanceState();
            this.mImpl = new C4069b(this.mCallbacks, createPreviewImpl(getContext()));
            onRestoreInstanceState(onSaveInstanceState);
            this.mImpl.mo2065a();
        }
    }

    public void stop() {
        this.mImpl.mo2067b();
    }

    public boolean isCameraOpened() {
        return this.mImpl.mo2076f();
    }

    public void addCallback(C2196a c2196a) {
        this.mCallbacks.m12619a(c2196a);
    }

    public void removeCallback(C2196a c2196a) {
        this.mCallbacks.m12624b(c2196a);
    }

    public void setAdjustViewBounds(boolean z) {
        if (this.mAdjustViewBounds != z) {
            this.mAdjustViewBounds = z;
            requestLayout();
        }
    }

    public boolean getAdjustViewBounds() {
        return this.mAdjustViewBounds;
    }

    public View getView() {
        return this.mImpl != null ? this.mImpl.m6041C() : null;
    }

    public void setFacing(int i) {
        this.mImpl.mo2061a(i);
    }

    public int getFacing() {
        return this.mImpl.mo2077g();
    }

    public int getCameraId() {
        return this.mImpl.mo2078h();
    }

    public Set<C2186a> getSupportedAspectRatios() {
        return this.mImpl.mo2079i();
    }

    public void setAspectRatio(C2186a c2186a) {
        if (this.mImpl.mo2071b(c2186a) != null) {
            requestLayout();
        }
    }

    public C2186a getAspectRatio() {
        return this.mImpl.mo2081k();
    }

    public SortedSet<C2210k> getAvailablePictureSizes(C2186a c2186a) {
        return this.mImpl.mo2059a(c2186a);
    }

    public void setPictureSize(C2210k c2210k) {
        this.mImpl.mo2063a(c2210k);
    }

    public C2210k getPictureSize() {
        return this.mImpl.mo2080j();
    }

    public void setAutoFocus(boolean z) {
        this.mImpl.mo2064a(z);
    }

    public boolean getAutoFocus() {
        return this.mImpl.mo2082l();
    }

    public void setFlash(int i) {
        this.mImpl.mo2069b(i);
    }

    public int getFlash() {
        return this.mImpl.mo2083m();
    }

    public void setFocusDepth(float f) {
        this.mImpl.mo2060a(f);
    }

    public float getFocusDepth() {
        return this.mImpl.mo2084n();
    }

    public void setZoom(float f) {
        this.mImpl.mo2068b(f);
    }

    public float getZoom() {
        return this.mImpl.mo2085o();
    }

    public void setWhiteBalance(int i) {
        this.mImpl.mo2072c(i);
    }

    public int getWhiteBalance() {
        return this.mImpl.mo2086p();
    }

    public void setScanning(boolean z) {
        this.mImpl.mo2070b(z);
    }

    public boolean getScanning() {
        return this.mImpl.mo2087q();
    }

    public void takePicture() {
        this.mImpl.mo2088r();
    }

    public boolean record(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        return this.mImpl.mo2066a(str, i, i2, z, camcorderProfile);
    }

    public void stopRecording() {
        this.mImpl.mo2089t();
    }

    public void resumePreview() {
        this.mImpl.mo2073d();
    }

    public void pausePreview() {
        this.mImpl.mo2075e();
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.mImpl.mo2062a(surfaceTexture);
    }

    public C2210k getPreviewSize() {
        return this.mImpl.mo2090u();
    }
}
