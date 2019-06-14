package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.theartofdev.edmodo.cropper.C5838c.C5837b;
import java.lang.ref.WeakReference;

/* compiled from: BitmapLoadingWorkerTask */
/* renamed from: com.theartofdev.edmodo.cropper.b */
final class C5835b extends AsyncTask<Void, Void, C5834a> {
    /* renamed from: a */
    private final WeakReference<CropImageView> f19383a;
    /* renamed from: b */
    private final Uri f19384b;
    /* renamed from: c */
    private final Context f19385c;
    /* renamed from: d */
    private final int f19386d;
    /* renamed from: e */
    private final int f19387e;

    /* compiled from: BitmapLoadingWorkerTask */
    /* renamed from: com.theartofdev.edmodo.cropper.b$a */
    public static final class C5834a {
        /* renamed from: a */
        public final Uri f19378a;
        /* renamed from: b */
        public final Bitmap f19379b;
        /* renamed from: c */
        public final int f19380c;
        /* renamed from: d */
        public final int f19381d;
        /* renamed from: e */
        public final Exception f19382e;

        C5834a(Uri uri, Bitmap bitmap, int i, int i2) {
            this.f19378a = uri;
            this.f19379b = bitmap;
            this.f19380c = i;
            this.f19381d = i2;
            this.f19382e = null;
        }

        C5834a(Uri uri, Exception exception) {
            this.f19378a = uri;
            this.f19379b = null;
            this.f19380c = 0;
            this.f19381d = 0;
            this.f19382e = exception;
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m24592a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m24593a((C5834a) obj);
    }

    public C5835b(CropImageView cropImageView, Uri uri) {
        this.f19384b = uri;
        this.f19383a = new WeakReference(cropImageView);
        this.f19385c = cropImageView.getContext();
        cropImageView = cropImageView.getResources().getDisplayMetrics();
        double d = cropImageView.density > 1065353216 ? (double) (1.0f / cropImageView.density) : 1.0d;
        this.f19386d = (int) (((double) cropImageView.widthPixels) * d);
        this.f19387e = (int) (((double) cropImageView.heightPixels) * d);
    }

    /* renamed from: a */
    public Uri m24591a() {
        return this.f19384b;
    }

    /* renamed from: a */
    protected C5834a m24592a(Void... voidArr) {
        try {
            if (isCancelled() == null) {
                voidArr = C5838c.m24606a(this.f19385c, this.f19384b, this.f19386d, this.f19387e);
                if (!isCancelled()) {
                    C5837b a = C5838c.m24612a(voidArr.f19388a, this.f19385c, this.f19384b);
                    return new C5834a(this.f19384b, a.f19390a, voidArr.f19389b, a.f19391b);
                }
            }
            return null;
        } catch (Void[] voidArr2) {
            return new C5834a(this.f19384b, voidArr2);
        }
    }

    /* renamed from: a */
    protected void m24593a(C5834a c5834a) {
        if (c5834a != null) {
            Object obj = null;
            if (!isCancelled()) {
                CropImageView cropImageView = (CropImageView) this.f19383a.get();
                if (cropImageView != null) {
                    obj = 1;
                    cropImageView.m24564a(c5834a);
                }
            }
            if (obj == null && c5834a.f19379b != null) {
                c5834a.f19379b.recycle();
            }
        }
    }
}
