package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.facebook.imageutils.JfifUtil;
import com.theartofdev.edmodo.cropper.C5833a.C5832a;
import com.theartofdev.edmodo.cropper.C5835b.C5834a;
import com.theartofdev.edmodo.cropper.C5855i.C5850a;
import com.theartofdev.edmodo.cropper.C5855i.C5851b;
import com.theartofdev.edmodo.cropper.C5855i.C5854e;
import com.theartofdev.edmodo.cropper.CropOverlayView.C5830a;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class CropImageView extends FrameLayout {
    /* renamed from: A */
    private C5822d f19286A;
    /* renamed from: B */
    private Uri f19287B;
    /* renamed from: C */
    private int f19288C;
    /* renamed from: D */
    private float f19289D;
    /* renamed from: E */
    private float f19290E;
    /* renamed from: F */
    private float f19291F;
    /* renamed from: G */
    private RectF f19292G;
    /* renamed from: H */
    private int f19293H;
    /* renamed from: I */
    private boolean f19294I;
    /* renamed from: J */
    private Uri f19295J;
    /* renamed from: K */
    private WeakReference<C5835b> f19296K;
    /* renamed from: L */
    private WeakReference<C5833a> f19297L;
    /* renamed from: a */
    private final ImageView f19298a;
    /* renamed from: b */
    private final CropOverlayView f19299b;
    /* renamed from: c */
    private final Matrix f19300c;
    /* renamed from: d */
    private final Matrix f19301d;
    /* renamed from: e */
    private final ProgressBar f19302e;
    /* renamed from: f */
    private final float[] f19303f;
    /* renamed from: g */
    private final float[] f19304g;
    /* renamed from: h */
    private C5843e f19305h;
    /* renamed from: i */
    private Bitmap f19306i;
    /* renamed from: j */
    private int f19307j;
    /* renamed from: k */
    private int f19308k;
    /* renamed from: l */
    private boolean f19309l;
    /* renamed from: m */
    private boolean f19310m;
    /* renamed from: n */
    private int f19311n;
    /* renamed from: o */
    private int f19312o;
    /* renamed from: p */
    private int f19313p;
    /* renamed from: q */
    private C5828j f19314q;
    /* renamed from: r */
    private boolean f19315r;
    /* renamed from: s */
    private boolean f19316s;
    /* renamed from: t */
    private boolean f19317t;
    /* renamed from: u */
    private boolean f19318u;
    /* renamed from: v */
    private int f19319v;
    /* renamed from: w */
    private C5824f f19320w;
    /* renamed from: x */
    private C5823e f19321x;
    /* renamed from: y */
    private C5825g f19322y;
    /* renamed from: z */
    private C5826h f19323z;

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$a */
    public static class C5819a {
        /* renamed from: a */
        private final Bitmap f19258a;
        /* renamed from: b */
        private final Uri f19259b;
        /* renamed from: c */
        private final Bitmap f19260c;
        /* renamed from: d */
        private final Uri f19261d;
        /* renamed from: e */
        private final Exception f19262e;
        /* renamed from: f */
        private final float[] f19263f;
        /* renamed from: g */
        private final Rect f19264g;
        /* renamed from: h */
        private final Rect f19265h;
        /* renamed from: i */
        private final int f19266i;
        /* renamed from: j */
        private final int f19267j;

        C5819a(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exception, float[] fArr, Rect rect, Rect rect2, int i, int i2) {
            this.f19258a = bitmap;
            this.f19259b = uri;
            this.f19260c = bitmap2;
            this.f19261d = uri2;
            this.f19262e = exception;
            this.f19263f = fArr;
            this.f19264g = rect;
            this.f19265h = rect2;
            this.f19266i = i;
            this.f19267j = i2;
        }

        /* renamed from: a */
        public Uri m24533a() {
            return this.f19259b;
        }

        /* renamed from: b */
        public Uri m24534b() {
            return this.f19261d;
        }

        /* renamed from: c */
        public Exception m24535c() {
            return this.f19262e;
        }

        /* renamed from: d */
        public float[] m24536d() {
            return this.f19263f;
        }

        /* renamed from: e */
        public Rect m24537e() {
            return this.f19264g;
        }

        /* renamed from: f */
        public Rect m24538f() {
            return this.f19265h;
        }

        /* renamed from: g */
        public int m24539g() {
            return this.f19266i;
        }

        /* renamed from: h */
        public int m24540h() {
            return this.f19267j;
        }
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$b */
    public enum C5820b {
        RECTANGLE,
        OVAL
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$c */
    public enum C5821c {
        OFF,
        ON_TOUCH,
        ON
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$d */
    public interface C5822d {
        /* renamed from: a */
        void mo6880a(CropImageView cropImageView, C5819a c5819a);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$e */
    public interface C5823e {
        /* renamed from: a */
        void m24542a(Rect rect);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$f */
    public interface C5824f {
        /* renamed from: a */
        void m24543a(Rect rect);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$g */
    public interface C5825g {
        /* renamed from: a */
        void m24544a();
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$h */
    public interface C5826h {
        /* renamed from: a */
        void mo6879a(CropImageView cropImageView, Uri uri, Exception exception);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$i */
    public enum C5827i {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$j */
    public enum C5828j {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView$1 */
    class C71951 implements C5830a {
        /* renamed from: a */
        final /* synthetic */ CropImageView f25468a;

        C71951(CropImageView cropImageView) {
            this.f25468a = cropImageView;
        }

        /* renamed from: a */
        public void mo5081a(boolean z) {
            this.f25468a.m24552a(z, true);
            C5824f a = this.f25468a.f19320w;
            if (!(a == null || z)) {
                a.m24543a(this.f25468a.getCropRect());
            }
            C5823e b = this.f25468a.f19321x;
            if (b != null && z) {
                b.m24542a(this.f25468a.getCropRect());
            }
        }
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19300c = new Matrix();
        this.f19301d = new Matrix();
        this.f19303f = new float[8];
        this.f19304g = new float[8];
        this.f19315r = false;
        this.f19316s = true;
        this.f19317t = true;
        this.f19318u = true;
        this.f19288C = 1;
        this.f19289D = 1.0f;
        C5845f c5845f = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (intent != null) {
            Bundle bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
            if (bundleExtra != null) {
                c5845f = (C5845f) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
            }
        }
        if (c5845f == null) {
            c5845f = new C5845f();
            if (attributeSet != null) {
                attributeSet = context.obtainStyledAttributes(attributeSet, C5854e.CropImageView, 0, 0);
                try {
                    c5845f.f19445l = attributeSet.getBoolean(C5854e.CropImageView_cropFixAspectRatio, c5845f.f19445l);
                    c5845f.f19446m = attributeSet.getInteger(C5854e.CropImageView_cropAspectRatioX, c5845f.f19446m);
                    c5845f.f19447n = attributeSet.getInteger(C5854e.CropImageView_cropAspectRatioY, c5845f.f19447n);
                    c5845f.f19438e = C5828j.values()[attributeSet.getInt(C5854e.CropImageView_cropScaleType, c5845f.f19438e.ordinal())];
                    c5845f.f19441h = attributeSet.getBoolean(C5854e.CropImageView_cropAutoZoomEnabled, c5845f.f19441h);
                    c5845f.f19442i = attributeSet.getBoolean(C5854e.CropImageView_cropMultiTouchEnabled, c5845f.f19442i);
                    c5845f.f19443j = attributeSet.getInteger(C5854e.CropImageView_cropMaxZoom, c5845f.f19443j);
                    c5845f.f19434a = C5820b.values()[attributeSet.getInt(C5854e.CropImageView_cropShape, c5845f.f19434a.ordinal())];
                    c5845f.f19437d = C5821c.values()[attributeSet.getInt(C5854e.CropImageView_cropGuidelines, c5845f.f19437d.ordinal())];
                    c5845f.f19435b = attributeSet.getDimension(C5854e.CropImageView_cropSnapRadius, c5845f.f19435b);
                    c5845f.f19436c = attributeSet.getDimension(C5854e.CropImageView_cropTouchRadius, c5845f.f19436c);
                    c5845f.f19444k = attributeSet.getFloat(C5854e.CropImageView_cropInitialCropWindowPaddingRatio, c5845f.f19444k);
                    c5845f.f19448o = attributeSet.getDimension(C5854e.CropImageView_cropBorderLineThickness, c5845f.f19448o);
                    c5845f.f19449p = attributeSet.getInteger(C5854e.CropImageView_cropBorderLineColor, c5845f.f19449p);
                    c5845f.f19450q = attributeSet.getDimension(C5854e.CropImageView_cropBorderCornerThickness, c5845f.f19450q);
                    c5845f.f19451r = attributeSet.getDimension(C5854e.CropImageView_cropBorderCornerOffset, c5845f.f19451r);
                    c5845f.f19452s = attributeSet.getDimension(C5854e.CropImageView_cropBorderCornerLength, c5845f.f19452s);
                    c5845f.f19453t = attributeSet.getInteger(C5854e.CropImageView_cropBorderCornerColor, c5845f.f19453t);
                    c5845f.f19454u = attributeSet.getDimension(C5854e.CropImageView_cropGuidelinesThickness, c5845f.f19454u);
                    c5845f.f19455v = attributeSet.getInteger(C5854e.CropImageView_cropGuidelinesColor, c5845f.f19455v);
                    c5845f.f19456w = attributeSet.getInteger(C5854e.CropImageView_cropBackgroundColor, c5845f.f19456w);
                    c5845f.f19439f = attributeSet.getBoolean(C5854e.CropImageView_cropShowCropOverlay, this.f19316s);
                    c5845f.f19440g = attributeSet.getBoolean(C5854e.CropImageView_cropShowProgressBar, this.f19317t);
                    c5845f.f19450q = attributeSet.getDimension(C5854e.CropImageView_cropBorderCornerThickness, c5845f.f19450q);
                    c5845f.f19457x = (int) attributeSet.getDimension(C5854e.CropImageView_cropMinCropWindowWidth, (float) c5845f.f19457x);
                    c5845f.f19458y = (int) attributeSet.getDimension(C5854e.CropImageView_cropMinCropWindowHeight, (float) c5845f.f19458y);
                    c5845f.f19459z = (int) attributeSet.getFloat(C5854e.CropImageView_cropMinCropResultWidthPX, (float) c5845f.f19459z);
                    c5845f.f19412A = (int) attributeSet.getFloat(C5854e.CropImageView_cropMinCropResultHeightPX, (float) c5845f.f19412A);
                    c5845f.f19413B = (int) attributeSet.getFloat(C5854e.CropImageView_cropMaxCropResultWidthPX, (float) c5845f.f19413B);
                    c5845f.f19414C = (int) attributeSet.getFloat(C5854e.CropImageView_cropMaxCropResultHeightPX, (float) c5845f.f19414C);
                    c5845f.f19430S = attributeSet.getBoolean(C5854e.CropImageView_cropFlipHorizontally, c5845f.f19430S);
                    c5845f.f19431T = attributeSet.getBoolean(C5854e.CropImageView_cropFlipHorizontally, c5845f.f19431T);
                    this.f19315r = attributeSet.getBoolean(C5854e.CropImageView_cropSaveBitmapToInstanceState, this.f19315r);
                    if (attributeSet.hasValue(C5854e.CropImageView_cropAspectRatioX) && attributeSet.hasValue(C5854e.CropImageView_cropAspectRatioX) && !attributeSet.hasValue(C5854e.CropImageView_cropFixAspectRatio)) {
                        c5845f.f19445l = true;
                    }
                    attributeSet.recycle();
                } catch (Throwable th) {
                    attributeSet.recycle();
                }
            }
        }
        c5845f.m24652a();
        this.f19314q = c5845f.f19438e;
        this.f19318u = c5845f.f19441h;
        this.f19319v = c5845f.f19443j;
        this.f19316s = c5845f.f19439f;
        this.f19317t = c5845f.f19440g;
        this.f19309l = c5845f.f19430S;
        this.f19310m = c5845f.f19431T;
        context = LayoutInflater.from(context).inflate(C5851b.crop_image_view, this, true);
        this.f19298a = (ImageView) context.findViewById(C5850a.ImageView_image);
        this.f19298a.setScaleType(ScaleType.MATRIX);
        this.f19299b = (CropOverlayView) context.findViewById(C5850a.CropOverlayView);
        this.f19299b.setCropWindowChangeListener(new C71951(this));
        this.f19299b.setInitialAttributeValues(c5845f);
        this.f19302e = (ProgressBar) context.findViewById(C5850a.CropProgressBar);
        m24557f();
    }

    public C5828j getScaleType() {
        return this.f19314q;
    }

    public void setScaleType(C5828j c5828j) {
        if (c5828j != this.f19314q) {
            this.f19314q = c5828j;
            this.f19289D = 1.0f;
            this.f19291F = 0.0f;
            this.f19290E = 0.0f;
            this.f19299b.m24587b();
            requestLayout();
        }
    }

    public C5820b getCropShape() {
        return this.f19299b.getCropShape();
    }

    public void setCropShape(C5820b c5820b) {
        this.f19299b.setCropShape(c5820b);
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.f19318u != z) {
            this.f19318u = z;
            m24552a(false, false);
            this.f19299b.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z) {
        if (this.f19299b.m24586a(z)) {
            m24552a(false, false);
            this.f19299b.invalidate();
        }
    }

    public int getMaxZoom() {
        return this.f19319v;
    }

    public void setMaxZoom(int i) {
        if (this.f19319v != i && i > 0) {
            this.f19319v = i;
            m24552a(false, false);
            this.f19299b.invalidate();
        }
    }

    public int getRotatedDegrees() {
        return this.f19308k;
    }

    public void setRotatedDegrees(int i) {
        if (this.f19308k != i) {
            m24560a(i - this.f19308k);
        }
    }

    public void setFixedAspectRatio(boolean z) {
        this.f19299b.setFixedAspectRatio(z);
    }

    public void setFlippedHorizontally(boolean z) {
        if (this.f19309l != z) {
            this.f19309l = z;
            m24548a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z) {
        if (this.f19310m != z) {
            this.f19310m = z;
            m24548a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public C5821c getGuidelines() {
        return this.f19299b.getGuidelines();
    }

    public void setGuidelines(C5821c c5821c) {
        this.f19299b.setGuidelines(c5821c);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair(Integer.valueOf(this.f19299b.getAspectRatioX()), Integer.valueOf(this.f19299b.getAspectRatioY()));
    }

    public void setSnapRadius(float f) {
        if (f >= 0.0f) {
            this.f19299b.setSnapRadius(f);
        }
    }

    public void setShowProgressBar(boolean z) {
        if (this.f19317t != z) {
            this.f19317t = z;
            m24557f();
        }
    }

    public void setShowCropOverlay(boolean z) {
        if (this.f19316s != z) {
            this.f19316s = z;
            m24556e();
        }
    }

    public void setSaveBitmapToInstanceState(boolean z) {
        this.f19315r = z;
    }

    public int getImageResource() {
        return this.f19313p;
    }

    public Uri getImageUri() {
        return this.f19287B;
    }

    public Rect getWholeImageRect() {
        int i = this.f19288C;
        Bitmap bitmap = this.f19306i;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public Rect getCropRect() {
        int i = this.f19288C;
        Bitmap bitmap = this.f19306i;
        if (bitmap == null) {
            return null;
        }
        return C5838c.m24604a(getCropPoints(), bitmap.getWidth() * i, i * bitmap.getHeight(), this.f19299b.m24588c(), this.f19299b.getAspectRatioX(), this.f19299b.getAspectRatioY());
    }

    public RectF getCropWindowRect() {
        if (this.f19299b == null) {
            return null;
        }
        return this.f19299b.getCropWindowRect();
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.f19299b.getCropWindowRect();
        r1 = new float[8];
        int i = 0;
        r1[0] = cropWindowRect.left;
        r1[1] = cropWindowRect.top;
        r1[2] = cropWindowRect.right;
        r1[3] = cropWindowRect.top;
        r1[4] = cropWindowRect.right;
        r1[5] = cropWindowRect.bottom;
        r1[6] = cropWindowRect.left;
        r1[7] = cropWindowRect.bottom;
        this.f19300c.invert(this.f19301d);
        this.f19301d.mapPoints(r1);
        while (i < r1.length) {
            r1[i] = r1[i] * ((float) this.f19288C);
            i++;
        }
        return r1;
    }

    public void setCropRect(Rect rect) {
        this.f19299b.setInitialCropWindowRect(rect);
    }

    public Bitmap getCroppedImage() {
        return m24558a(0, 0, C5827i.NONE);
    }

    /* renamed from: a */
    public Bitmap m24558a(int i, int i2, C5827i c5827i) {
        C5827i c5827i2 = c5827i;
        if (this.f19306i == null) {
            return null;
        }
        Bitmap bitmap;
        r0.f19298a.clearAnimation();
        int i3 = 0;
        int i4 = c5827i2 != C5827i.NONE ? i : 0;
        if (c5827i2 != C5827i.NONE) {
            i3 = i2;
        }
        if (r0.f19287B == null || (r0.f19288C <= 1 && c5827i2 != C5827i.SAMPLING)) {
            bitmap = C5838c.m24611a(r0.f19306i, getCropPoints(), r0.f19308k, r0.f19299b.m24588c(), r0.f19299b.getAspectRatioX(), r0.f19299b.getAspectRatioY(), r0.f19309l, r0.f19310m).f19388a;
        } else {
            bitmap = C5838c.m24608a(getContext(), r0.f19287B, getCropPoints(), r0.f19308k, r0.f19306i.getWidth() * r0.f19288C, r0.f19306i.getHeight() * r0.f19288C, r0.f19299b.m24588c(), r0.f19299b.getAspectRatioX(), r0.f19299b.getAspectRatioY(), i4, i3, r0.f19309l, r0.f19310m).f19388a;
        }
        return C5838c.m24599a(bitmap, i4, i3, c5827i2);
    }

    public void getCroppedImageAsync() {
        m24566b(0, 0, C5827i.NONE);
    }

    /* renamed from: b */
    public void m24566b(int i, int i2, C5827i c5827i) {
        if (this.f19286A != null) {
            m24561a(i, i2, c5827i, null, null, 0);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    /* renamed from: a */
    public void m24562a(Uri uri, CompressFormat compressFormat, int i, int i2, int i3, C5827i c5827i) {
        if (this.f19286A != null) {
            m24561a(i2, i3, c5827i, uri, compressFormat, i);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public void setOnSetCropOverlayReleasedListener(C5824f c5824f) {
        this.f19320w = c5824f;
    }

    public void setOnSetCropOverlayMovedListener(C5823e c5823e) {
        this.f19321x = c5823e;
    }

    public void setOnCropWindowChangedListener(C5825g c5825g) {
        this.f19322y = c5825g;
    }

    public void setOnSetImageUriCompleteListener(C5826h c5826h) {
        this.f19323z = c5826h;
    }

    public void setOnCropImageCompleteListener(C5822d c5822d) {
        this.f19286A = c5822d;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f19299b.setInitialCropWindowRect(null);
        m24549a(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.f19299b.setInitialCropWindowRect(null);
            m24549a(BitmapFactory.decodeResource(getResources(), i), i, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            C5835b c5835b = this.f19296K != null ? (C5835b) this.f19296K.get() : null;
            if (c5835b != null) {
                c5835b.cancel(true);
            }
            m24554c();
            this.f19292G = null;
            this.f19293H = 0;
            this.f19299b.setInitialCropWindowRect(null);
            this.f19296K = new WeakReference(new C5835b(this, uri));
            ((C5835b) this.f19296K.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            m24557f();
        }
    }

    /* renamed from: a */
    public void m24560a(int i) {
        int i2 = i;
        if (this.f19306i != null) {
            if (i2 < 0) {
                i2 = (i2 % 360) + 360;
            } else {
                i2 %= 360;
            }
            Object obj = (r0.f19299b.m24588c() || ((i2 <= 45 || i2 >= 135) && (i2 <= JfifUtil.MARKER_RST7 || i2 >= 305))) ? null : 1;
            C5838c.f19394c.set(r0.f19299b.getCropWindowRect());
            float height = (obj != null ? C5838c.f19394c.height() : C5838c.f19394c.width()) / 2.0f;
            float width = (obj != null ? C5838c.f19394c.width() : C5838c.f19394c.height()) / 2.0f;
            if (obj != null) {
                boolean z = r0.f19309l;
                r0.f19309l = r0.f19310m;
                r0.f19310m = z;
            }
            r0.f19300c.invert(r0.f19301d);
            C5838c.f19395d[0] = C5838c.f19394c.centerX();
            C5838c.f19395d[1] = C5838c.f19394c.centerY();
            C5838c.f19395d[2] = 0.0f;
            C5838c.f19395d[3] = 0.0f;
            C5838c.f19395d[4] = 1.0f;
            C5838c.f19395d[5] = 0.0f;
            r0.f19301d.mapPoints(C5838c.f19395d);
            r0.f19308k = (r0.f19308k + i2) % 360;
            m24548a((float) getWidth(), (float) getHeight(), true, false);
            r0.f19300c.mapPoints(C5838c.f19396e, C5838c.f19395d);
            r0.f19289D = (float) (((double) r0.f19289D) / Math.sqrt(Math.pow((double) (C5838c.f19396e[4] - C5838c.f19396e[2]), 2.0d) + Math.pow((double) (C5838c.f19396e[5] - C5838c.f19396e[3]), 2.0d)));
            r0.f19289D = Math.max(r0.f19289D, 1.0f);
            m24548a((float) getWidth(), (float) getHeight(), true, false);
            r0.f19300c.mapPoints(C5838c.f19396e, C5838c.f19395d);
            double sqrt = Math.sqrt(Math.pow((double) (C5838c.f19396e[4] - C5838c.f19396e[2]), 2.0d) + Math.pow((double) (C5838c.f19396e[5] - C5838c.f19396e[3]), 2.0d));
            float f = (float) (((double) height) * sqrt);
            float f2 = (float) (((double) width) * sqrt);
            C5838c.f19394c.set(C5838c.f19396e[0] - f, C5838c.f19396e[1] - f2, C5838c.f19396e[0] + f, C5838c.f19396e[1] + f2);
            r0.f19299b.m24587b();
            r0.f19299b.setCropWindowRect(C5838c.f19394c);
            m24548a((float) getWidth(), (float) getHeight(), true, false);
            m24552a(false, false);
            r0.f19299b.m24583a();
        }
    }

    /* renamed from: a */
    public void m24559a() {
        this.f19309l ^= true;
        m24548a((float) getWidth(), (float) getHeight(), true, false);
    }

    /* renamed from: b */
    public void m24565b() {
        this.f19310m ^= true;
        m24548a((float) getWidth(), (float) getHeight(), true, false);
    }

    /* renamed from: a */
    void m24564a(C5834a c5834a) {
        this.f19296K = null;
        m24557f();
        if (c5834a.f19382e == null) {
            this.f19307j = c5834a.f19381d;
            m24549a(c5834a.f19379b, 0, c5834a.f19378a, c5834a.f19380c, c5834a.f19381d);
        }
        C5826h c5826h = this.f19323z;
        if (c5826h != null) {
            c5826h.mo6879a(this, c5834a.f19378a, c5834a.f19382e);
        }
    }

    /* renamed from: a */
    void m24563a(C5832a c5832a) {
        this.f19297L = null;
        m24557f();
        C5822d c5822d = this.f19286A;
        if (c5822d != null) {
            c5822d.mo6880a(this, new C5819a(this.f19306i, this.f19287B, c5832a.f19354a, c5832a.f19355b, c5832a.f19356c, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), c5832a.f19358e));
        }
    }

    /* renamed from: a */
    private void m24549a(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        if (this.f19306i == null || !this.f19306i.equals(bitmap)) {
            this.f19298a.clearAnimation();
            m24554c();
            this.f19306i = bitmap;
            this.f19298a.setImageBitmap(this.f19306i);
            this.f19287B = uri;
            this.f19313p = i;
            this.f19288C = i2;
            this.f19308k = i3;
            m24548a((float) getWidth(), (float) getHeight(), true, 0);
            if (this.f19299b != null) {
                this.f19299b.m24587b();
                m24556e();
            }
        }
    }

    /* renamed from: c */
    private void m24554c() {
        if (this.f19306i != null && (this.f19313p > 0 || this.f19287B != null)) {
            this.f19306i.recycle();
        }
        this.f19306i = null;
        this.f19313p = 0;
        this.f19287B = null;
        this.f19288C = 1;
        this.f19308k = 0;
        this.f19289D = 1.0f;
        this.f19290E = 0.0f;
        this.f19291F = 0.0f;
        this.f19300c.reset();
        this.f19295J = null;
        this.f19298a.setImageBitmap(null);
        m24556e();
    }

    /* renamed from: a */
    public void m24561a(int i, int i2, C5827i c5827i, Uri uri, CompressFormat compressFormat, int i3) {
        C5827i c5827i2 = c5827i;
        Bitmap bitmap = this.f19306i;
        CropImageView cropImageView;
        if (bitmap != null) {
            r15.f19298a.clearAnimation();
            C5833a c5833a = r15.f19297L != null ? (C5833a) r15.f19297L.get() : null;
            if (c5833a != null) {
                c5833a.cancel(true);
            }
            int i4 = c5827i2 != C5827i.NONE ? i : 0;
            int i5 = c5827i2 != C5827i.NONE ? i2 : 0;
            int width = bitmap.getWidth() * r15.f19288C;
            int height = bitmap.getHeight() * r15.f19288C;
            if (r15.f19287B == null || (r15.f19288C <= 1 && c5827i2 != C5827i.SAMPLING)) {
                C5833a c5833a2 = c5833a;
                c5833a = new C5833a(this, bitmap, getCropPoints(), r15.f19308k, r15.f19299b.m24588c(), r15.f19299b.getAspectRatioX(), r15.f19299b.getAspectRatioY(), i4, i5, r15.f19309l, r15.f19310m, c5827i, uri, compressFormat, i3);
                this.f19297L = new WeakReference(c5833a2);
            } else {
                C5833a c5833a3 = c5833a;
                c5833a = new C5833a(this, r15.f19287B, getCropPoints(), r15.f19308k, width, height, r15.f19299b.m24588c(), r15.f19299b.getAspectRatioX(), r15.f19299b.getAspectRatioY(), i4, i5, r15.f19309l, r15.f19310m, c5827i, uri, compressFormat, i3);
                this.f19297L = new WeakReference(c5833a3);
                cropImageView = this;
            }
            ((C5833a) cropImageView.f19297L.get()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            m24557f();
            return;
        }
        cropImageView = r15;
    }

    public Parcelable onSaveInstanceState() {
        if (this.f19287B == null && this.f19306i == null && this.f19313p < 1) {
            return super.onSaveInstanceState();
        }
        Parcelable bundle = new Bundle();
        Parcelable parcelable = this.f19287B;
        if (this.f19315r && parcelable == null && this.f19313p < 1) {
            parcelable = C5838c.m24605a(getContext(), this.f19306i, this.f19295J);
            this.f19295J = parcelable;
        }
        if (!(parcelable == null || this.f19306i == null)) {
            String uuid = UUID.randomUUID().toString();
            C5838c.f19397f = new Pair(uuid, new WeakReference(this.f19306i));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        if (this.f19296K != null) {
            C5835b c5835b = (C5835b) this.f19296K.get();
            if (c5835b != null) {
                bundle.putParcelable("LOADING_IMAGE_URI", c5835b.m24591a());
            }
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", parcelable);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.f19313p);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.f19288C);
        bundle.putInt("DEGREES_ROTATED", this.f19308k);
        bundle.putParcelable("INITIAL_CROP_RECT", this.f19299b.getInitialCropWindowRect());
        C5838c.f19394c.set(this.f19299b.getCropWindowRect());
        this.f19300c.invert(this.f19301d);
        this.f19301d.mapRect(C5838c.f19394c);
        bundle.putParcelable("CROP_WINDOW_RECT", C5838c.f19394c);
        bundle.putString("CROP_SHAPE", this.f19299b.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.f19318u);
        bundle.putInt("CROP_MAX_ZOOM", this.f19319v);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f19309l);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.f19310m);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.f19296K == null && this.f19287B == null && this.f19306i == null && this.f19313p == 0) {
                int i;
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Bitmap bitmap = (C5838c.f19397f == null || !((String) C5838c.f19397f.first).equals(string)) ? null : (Bitmap) ((WeakReference) C5838c.f19397f.second).get();
                        C5838c.f19397f = null;
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            m24549a(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.f19287B == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    i = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i > 0) {
                        setImageResource(i);
                    } else {
                        uri = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri != null) {
                            setImageUriAsync(uri);
                        }
                    }
                }
                i = bundle.getInt("DEGREES_ROTATED");
                this.f19293H = i;
                this.f19308k = i;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.f19299b.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.f19292G = rectF;
                }
                this.f19299b.setCropShape(C5820b.valueOf(bundle.getString("CROP_SHAPE")));
                this.f19318u = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.f19319v = bundle.getInt("CROP_MAX_ZOOM");
                this.f19309l = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.f19310m = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (this.f19306i != null) {
            int width;
            int height;
            if (i2 == 0) {
                i2 = this.f19306i.getHeight();
            }
            double width2 = i < this.f19306i.getWidth() ? ((double) i) / ((double) this.f19306i.getWidth()) : Double.POSITIVE_INFINITY;
            double height2 = i2 < this.f19306i.getHeight() ? ((double) i2) / ((double) this.f19306i.getHeight()) : Double.POSITIVE_INFINITY;
            if (width2 == Double.POSITIVE_INFINITY) {
                if (height2 == Double.POSITIVE_INFINITY) {
                    width = this.f19306i.getWidth();
                    height = this.f19306i.getHeight();
                    i = m24546a(mode, i, width);
                    i2 = m24546a(mode2, i2, height);
                    this.f19311n = i;
                    this.f19312o = i2;
                    setMeasuredDimension(this.f19311n, this.f19312o);
                    return;
                }
            }
            if (width2 <= height2) {
                height = (int) (((double) this.f19306i.getHeight()) * width2);
                width = i;
            } else {
                width = (int) (((double) this.f19306i.getWidth()) * height2);
                height = i2;
            }
            i = m24546a(mode, i, width);
            i2 = m24546a(mode2, i2, height);
            this.f19311n = i;
            this.f19312o = i2;
            setMeasuredDimension(this.f19311n, this.f19312o);
            return;
        }
        setMeasuredDimension(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f19311n > false || this.f19312o > false) {
            m24551a(true);
            return;
        }
        z = getLayoutParams();
        z.width = this.f19311n;
        z.height = this.f19312o;
        setLayoutParams(z);
        if (this.f19306i) {
            z = (float) (i3 - i);
            i = (float) (i4 - i2);
            m24548a(z, i, true, false);
            if (this.f19292G != 0) {
                if (this.f19293H != this.f19307j) {
                    this.f19308k = this.f19293H;
                    m24548a(z, i, true, false);
                }
                this.f19300c.mapRect(this.f19292G);
                this.f19299b.setCropWindowRect(this.f19292G);
                m24552a(false, false);
                this.f19299b.m24583a();
                this.f19292G = false;
                return;
            } else if (this.f19294I) {
                this.f19294I = false;
                m24552a(false, false);
                return;
            } else {
                return;
            }
        }
        m24551a(true);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        i = (i3 <= 0 || i4 <= 0) ? 0 : 1;
        this.f19294I = i;
    }

    /* renamed from: a */
    private void m24552a(boolean z, boolean z2) {
        int width = getWidth();
        int height = getHeight();
        if (this.f19306i != null && width > 0 && height > 0) {
            RectF cropWindowRect = this.f19299b.getCropWindowRect();
            if (z) {
                if (cropWindowRect.left >= false || cropWindowRect.top >= false || cropWindowRect.right > ((float) width) || cropWindowRect.bottom > ((float) height)) {
                    m24548a((float) width, (float) height, false, false);
                }
            } else if (this.f19318u || this.f19289D > 1.0f) {
                float min;
                float f;
                float max;
                if (this.f19289D < ((float) this.f19319v)) {
                    float f2 = (float) width;
                    if (cropWindowRect.width() < f2 * 0.5f) {
                        float f3 = (float) height;
                        if (cropWindowRect.height() < 0.5f * f3) {
                            min = Math.min((float) this.f19319v, Math.min(f2 / ((cropWindowRect.width() / this.f19289D) / 0.64f), f3 / ((cropWindowRect.height() / this.f19289D) / 0.64f)));
                            if (this.f19289D > 1.0f) {
                                f = (float) width;
                                if (cropWindowRect.width() > f * 0.65f || cropWindowRect.height() > ((float) height) * 0.65f) {
                                    max = Math.max(1.0f, Math.min(f / ((cropWindowRect.width() / this.f19289D) / 0.51f), ((float) height) / ((cropWindowRect.height() / this.f19289D) / 0.51f)));
                                    if (!this.f19318u) {
                                        max = 1.0f;
                                    }
                                    if (max > 0.0f && max != this.f19289D) {
                                        if (z2) {
                                            if (this.f19305h == null) {
                                                this.f19305h = new C5843e(this.f19298a, this.f19299b);
                                            }
                                            this.f19305h.m24648a(this.f19303f, this.f19300c);
                                        }
                                        this.f19289D = max;
                                        m24548a((float) width, (float) height, true, z2);
                                    }
                                }
                            }
                            max = min;
                            if (this.f19318u) {
                                max = 1.0f;
                            }
                            if (z2) {
                                if (this.f19305h == null) {
                                    this.f19305h = new C5843e(this.f19298a, this.f19299b);
                                }
                                this.f19305h.m24648a(this.f19303f, this.f19300c);
                            }
                            this.f19289D = max;
                            m24548a((float) width, (float) height, true, z2);
                        }
                    }
                }
                min = 0.0f;
                if (this.f19289D > 1.0f) {
                    f = (float) width;
                    max = Math.max(1.0f, Math.min(f / ((cropWindowRect.width() / this.f19289D) / 0.51f), ((float) height) / ((cropWindowRect.height() / this.f19289D) / 0.51f)));
                    if (this.f19318u) {
                        max = 1.0f;
                    }
                    if (z2) {
                        if (this.f19305h == null) {
                            this.f19305h = new C5843e(this.f19298a, this.f19299b);
                        }
                        this.f19305h.m24648a(this.f19303f, this.f19300c);
                    }
                    this.f19289D = max;
                    m24548a((float) width, (float) height, true, z2);
                }
                max = min;
                if (this.f19318u) {
                    max = 1.0f;
                }
                if (z2) {
                    if (this.f19305h == null) {
                        this.f19305h = new C5843e(this.f19298a, this.f19299b);
                    }
                    this.f19305h.m24648a(this.f19303f, this.f19300c);
                }
                this.f19289D = max;
                m24548a((float) width, (float) height, true, z2);
            }
            if (this.f19322y && !z) {
                this.f19322y.m24544a();
            }
        }
    }

    /* renamed from: a */
    private void m24548a(float f, float f2, boolean z, boolean z2) {
        if (this.f19306i != null) {
            float f3 = 0.0f;
            if (f > 0.0f && f2 > 0.0f) {
                this.f19300c.invert(this.f19301d);
                RectF cropWindowRect = this.f19299b.getCropWindowRect();
                this.f19301d.mapRect(cropWindowRect);
                this.f19300c.reset();
                this.f19300c.postTranslate((f - ((float) this.f19306i.getWidth())) / 2.0f, (f2 - ((float) this.f19306i.getHeight())) / 2.0f);
                m24555d();
                if (this.f19308k > 0) {
                    this.f19300c.postRotate((float) this.f19308k, C5838c.m24622g(this.f19303f), C5838c.m24623h(this.f19303f));
                    m24555d();
                }
                float min = Math.min(f / C5838c.m24620e(this.f19303f), f2 / C5838c.m24621f(this.f19303f));
                if (this.f19314q == C5828j.FIT_CENTER || ((this.f19314q == C5828j.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.f19318u))) {
                    this.f19300c.postScale(min, min, C5838c.m24622g(this.f19303f), C5838c.m24623h(this.f19303f));
                    m24555d();
                }
                min = this.f19309l ? -this.f19289D : this.f19289D;
                float f4 = this.f19310m ? -this.f19289D : this.f19289D;
                this.f19300c.postScale(min, f4, C5838c.m24622g(this.f19303f), C5838c.m24623h(this.f19303f));
                m24555d();
                this.f19300c.mapRect(cropWindowRect);
                if (z) {
                    if (f > C5838c.m24620e(this.f19303f)) {
                        f = 0.0f;
                    } else {
                        f = Math.max(Math.min((f / 2.0f) - cropWindowRect.centerX(), -C5838c.m24594a(this.f19303f)), ((float) getWidth()) - C5838c.m24618c(this.f19303f)) / min;
                    }
                    this.f19290E = f;
                    if (f2 <= C5838c.m24621f(this.f19303f)) {
                        f3 = Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerY(), -C5838c.m24617b(this.f19303f)), ((float) getHeight()) - C5838c.m24619d(this.f19303f)) / f4;
                    }
                    this.f19291F = f3;
                } else {
                    this.f19290E = Math.min(Math.max(this.f19290E * min, -cropWindowRect.left), (-cropWindowRect.right) + f) / min;
                    this.f19291F = Math.min(Math.max(this.f19291F * f4, -cropWindowRect.top), (-cropWindowRect.bottom) + f2) / f4;
                }
                this.f19300c.postTranslate(this.f19290E * min, this.f19291F * f4);
                cropWindowRect.offset(this.f19290E * min, this.f19291F * f4);
                this.f19299b.setCropWindowRect(cropWindowRect);
                m24555d();
                this.f19299b.invalidate();
                if (z2) {
                    this.f19305h.m24649b(this.f19303f, this.f19300c);
                    this.f19298a.startAnimation(this.f19305h);
                } else {
                    this.f19298a.setImageMatrix(this.f19300c);
                }
                m24551a((boolean) 0.0f);
            }
        }
    }

    /* renamed from: d */
    private void m24555d() {
        this.f19303f[0] = 0.0f;
        this.f19303f[1] = 0.0f;
        this.f19303f[2] = (float) this.f19306i.getWidth();
        this.f19303f[3] = 0.0f;
        this.f19303f[4] = (float) this.f19306i.getWidth();
        this.f19303f[5] = (float) this.f19306i.getHeight();
        this.f19303f[6] = 0.0f;
        this.f19303f[7] = (float) this.f19306i.getHeight();
        this.f19300c.mapPoints(this.f19303f);
        this.f19304g[0] = 0.0f;
        this.f19304g[1] = 0.0f;
        this.f19304g[2] = 100.0f;
        this.f19304g[3] = 0.0f;
        this.f19304g[4] = 100.0f;
        this.f19304g[5] = 100.0f;
        this.f19304g[6] = 0.0f;
        this.f19304g[7] = 100.0f;
        this.f19300c.mapPoints(this.f19304g);
    }

    /* renamed from: a */
    private static int m24546a(int i, int i2, int i3) {
        if (i == 1073741824) {
            return i2;
        }
        return i == LinearLayoutManager.INVALID_OFFSET ? Math.min(i3, i2) : i3;
    }

    /* renamed from: e */
    private void m24556e() {
        if (this.f19299b != null) {
            CropOverlayView cropOverlayView = this.f19299b;
            int i = (!this.f19316s || this.f19306i == null) ? 4 : 0;
            cropOverlayView.setVisibility(i);
        }
    }

    /* renamed from: f */
    private void m24557f() {
        int i = 0;
        Object obj = (!this.f19317t || ((this.f19306i != null || this.f19296K == null) && this.f19297L == null)) ? null : 1;
        ProgressBar progressBar = this.f19302e;
        if (obj == null) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }

    /* renamed from: a */
    private void m24551a(boolean z) {
        if (!(this.f19306i == null || z)) {
            this.f19299b.m24584a((float) getWidth(), (float) getHeight(), (((float) this.f19288C) * 100.0f) / C5838c.m24620e(this.f19304g), (((float) this.f19288C) * 100.0f) / C5838c.m24621f(this.f19304g));
        }
        this.f19299b.m24585a(z ? false : this.f19303f, getWidth(), getHeight());
    }
}
