package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import com.theartofdev.edmodo.cropper.C5838c.C5836a;
import com.theartofdev.edmodo.cropper.CropImageView.C5827i;
import java.lang.ref.WeakReference;

/* compiled from: BitmapCroppingWorkerTask */
/* renamed from: com.theartofdev.edmodo.cropper.a */
final class C5833a extends AsyncTask<Void, Void, C5832a> {
    /* renamed from: a */
    private final WeakReference<CropImageView> f19359a;
    /* renamed from: b */
    private final Bitmap f19360b;
    /* renamed from: c */
    private final Uri f19361c;
    /* renamed from: d */
    private final Context f19362d;
    /* renamed from: e */
    private final float[] f19363e;
    /* renamed from: f */
    private final int f19364f;
    /* renamed from: g */
    private final int f19365g;
    /* renamed from: h */
    private final int f19366h;
    /* renamed from: i */
    private final boolean f19367i;
    /* renamed from: j */
    private final int f19368j;
    /* renamed from: k */
    private final int f19369k;
    /* renamed from: l */
    private final int f19370l;
    /* renamed from: m */
    private final int f19371m;
    /* renamed from: n */
    private final boolean f19372n;
    /* renamed from: o */
    private final boolean f19373o;
    /* renamed from: p */
    private final C5827i f19374p;
    /* renamed from: q */
    private final Uri f19375q;
    /* renamed from: r */
    private final CompressFormat f19376r;
    /* renamed from: s */
    private final int f19377s;

    /* compiled from: BitmapCroppingWorkerTask */
    /* renamed from: com.theartofdev.edmodo.cropper.a$a */
    static final class C5832a {
        /* renamed from: a */
        public final Bitmap f19354a;
        /* renamed from: b */
        public final Uri f19355b;
        /* renamed from: c */
        final Exception f19356c;
        /* renamed from: d */
        final boolean f19357d;
        /* renamed from: e */
        final int f19358e;

        C5832a(Bitmap bitmap, int i) {
            this.f19354a = bitmap;
            this.f19355b = null;
            this.f19356c = null;
            this.f19357d = null;
            this.f19358e = i;
        }

        C5832a(Uri uri, int i) {
            this.f19354a = null;
            this.f19355b = uri;
            this.f19356c = null;
            this.f19357d = true;
            this.f19358e = i;
        }

        C5832a(Exception exception, boolean z) {
            this.f19354a = null;
            this.f19355b = null;
            this.f19356c = exception;
            this.f19357d = z;
            this.f19358e = 1;
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m24589a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m24590a((C5832a) obj);
    }

    C5833a(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, int i4, int i5, boolean z2, boolean z3, C5827i c5827i, Uri uri, CompressFormat compressFormat, int i6) {
        CropImageView cropImageView2 = cropImageView;
        this.f19359a = new WeakReference(cropImageView);
        this.f19362d = cropImageView.getContext();
        this.f19360b = bitmap;
        this.f19363e = fArr;
        this.f19361c = null;
        this.f19364f = i;
        this.f19367i = z;
        this.f19368j = i2;
        this.f19369k = i3;
        this.f19370l = i4;
        this.f19371m = i5;
        this.f19372n = z2;
        this.f19373o = z3;
        this.f19374p = c5827i;
        this.f19375q = uri;
        this.f19376r = compressFormat;
        this.f19377s = i6;
        this.f19365g = 0;
        this.f19366h = 0;
    }

    C5833a(CropImageView cropImageView, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, C5827i c5827i, Uri uri2, CompressFormat compressFormat, int i8) {
        CropImageView cropImageView2 = cropImageView;
        this.f19359a = new WeakReference(cropImageView);
        this.f19362d = cropImageView.getContext();
        this.f19361c = uri;
        this.f19363e = fArr;
        this.f19364f = i;
        this.f19367i = z;
        this.f19368j = i4;
        this.f19369k = i5;
        this.f19365g = i2;
        this.f19366h = i3;
        this.f19370l = i6;
        this.f19371m = i7;
        this.f19372n = z2;
        this.f19373o = z3;
        this.f19374p = c5827i;
        this.f19375q = uri2;
        this.f19376r = compressFormat;
        this.f19377s = i8;
        this.f19360b = null;
    }

    /* renamed from: a */
    protected C5832a m24589a(Void... voidArr) {
        C5833a c5833a = this;
        boolean z = true;
        try {
            if (isCancelled()) {
                return null;
            }
            C5836a a;
            if (c5833a.f19361c != null) {
                a = C5838c.m24608a(c5833a.f19362d, c5833a.f19361c, c5833a.f19363e, c5833a.f19364f, c5833a.f19365g, c5833a.f19366h, c5833a.f19367i, c5833a.f19368j, c5833a.f19369k, c5833a.f19370l, c5833a.f19371m, c5833a.f19372n, c5833a.f19373o);
            } else if (c5833a.f19360b == null) {
                return new C5832a((Bitmap) null, 1);
            } else {
                a = C5838c.m24611a(c5833a.f19360b, c5833a.f19363e, c5833a.f19364f, c5833a.f19367i, c5833a.f19368j, c5833a.f19369k, c5833a.f19372n, c5833a.f19373o);
            }
            Bitmap a2 = C5838c.m24599a(a.f19388a, c5833a.f19370l, c5833a.f19371m, c5833a.f19374p);
            if (c5833a.f19375q == null) {
                return new C5832a(a2, a.f19389b);
            }
            C5838c.m24614a(c5833a.f19362d, a2, c5833a.f19375q, c5833a.f19376r, c5833a.f19377s);
            if (a2 != null) {
                a2.recycle();
            }
            return new C5832a(c5833a.f19375q, a.f19389b);
        } catch (Exception e) {
            if (c5833a.f19375q == null) {
                z = false;
            }
            return new C5832a(e, z);
        }
    }

    /* renamed from: a */
    protected void m24590a(C5832a c5832a) {
        if (c5832a != null) {
            Object obj = null;
            if (!isCancelled()) {
                CropImageView cropImageView = (CropImageView) this.f19359a.get();
                if (cropImageView != null) {
                    obj = 1;
                    cropImageView.m24563a(c5832a);
                }
            }
            if (obj == null && c5832a.f19354a != null) {
                c5832a.f19354a.recycle();
            }
        }
    }
}
