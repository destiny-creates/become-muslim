package com.facebook.ads.internal.view.p113b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.p089d.C1365c;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p107b.C1530e;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.view.b.d */
public class C1577d extends AsyncTask<String, Void, Bitmap[]> {
    /* renamed from: b */
    private static final String f4713b = "d";
    /* renamed from: a */
    public boolean f4714a = false;
    /* renamed from: c */
    private final WeakReference<Context> f4715c;
    /* renamed from: d */
    private final int f4716d;
    /* renamed from: e */
    private final WeakReference<ImageView> f4717e;
    /* renamed from: f */
    private final WeakReference<C1574b> f4718f;
    /* renamed from: g */
    private final WeakReference<ViewGroup> f4719g;
    /* renamed from: h */
    private C1578e f4720h;
    /* renamed from: i */
    private int f4721i = -1;
    /* renamed from: j */
    private int f4722j = -1;

    public C1577d(ViewGroup viewGroup, int i) {
        this.f4715c = new WeakReference(viewGroup.getContext());
        this.f4718f = null;
        this.f4717e = null;
        this.f4719g = new WeakReference(viewGroup);
        this.f4716d = i;
    }

    public C1577d(ImageView imageView) {
        this.f4715c = new WeakReference(imageView.getContext());
        this.f4718f = null;
        this.f4717e = new WeakReference(imageView);
        this.f4719g = null;
        this.f4716d = 0;
    }

    public C1577d(C1574b c1574b) {
        this.f4715c = new WeakReference(c1574b.getContext());
        this.f4718f = new WeakReference(c1574b);
        this.f4717e = null;
        this.f4719g = null;
        this.f4716d = 0;
    }

    /* renamed from: a */
    public C1577d m5504a() {
        this.f4721i = -1;
        this.f4722j = -1;
        return this;
    }

    /* renamed from: a */
    public C1577d m5505a(int i, int i2) {
        this.f4721i = i;
        this.f4722j = i2;
        return this;
    }

    /* renamed from: a */
    public C1577d m5506a(C1578e c1578e) {
        this.f4720h = c1578e;
        return this;
    }

    /* renamed from: a */
    public C1577d m5507a(boolean z) {
        this.f4714a = z;
        return this;
    }

    /* renamed from: a */
    public void m5508a(String str) {
        if (TextUtils.isEmpty(str)) {
            if (this.f4720h != null) {
                this.f4720h.mo841a(false);
            }
            return;
        }
        executeOnExecutor(THREAD_POOL_EXECUTOR, new String[]{str});
    }

    /* renamed from: a */
    protected void m5509a(Bitmap[] bitmapArr) {
        boolean z = false;
        if (this.f4717e != null) {
            ImageView imageView = (ImageView) this.f4717e.get();
            if (imageView != null) {
                imageView.setImageBitmap(bitmapArr[0]);
            }
        }
        if (this.f4718f != null) {
            C1574b c1574b = (C1574b) this.f4718f.get();
            if (c1574b != null) {
                c1574b.m5490a(bitmapArr[0], bitmapArr[1]);
            }
        }
        if (!(this.f4719g == null || this.f4719g.get() == null || bitmapArr[1] == null)) {
            C1523w.m5343a((View) this.f4719g.get(), new BitmapDrawable(((Context) this.f4715c.get()).getResources(), bitmapArr[1]));
        }
        if (this.f4720h != null) {
            C1578e c1578e = this.f4720h;
            if (bitmapArr[0] != null) {
                z = true;
            }
            c1578e.mo841a(z);
        }
    }

    /* renamed from: a */
    protected Bitmap[] m5510a(String... strArr) {
        Throwable th;
        String str;
        StringBuilder stringBuilder;
        String str2 = strArr[0];
        Context context = (Context) this.f4715c.get();
        String str3 = null;
        if (context == null) {
            return new Bitmap[]{null, null};
        }
        Bitmap a;
        try {
            a = C1365c.m4662a(context).m4669a(str2, this.f4721i, this.f4722j);
            try {
                Object obj = (this.f4718f == null || this.f4718f.get() == null) ? null : 1;
                Object obj2 = (this.f4719g == null || this.f4719g.get() == null) ? null : 1;
                if (!((obj == null && obj2 == null) || a == null || this.f4714a)) {
                    C1530e c1530e = new C1530e(a);
                    c1530e.m5360a(this.f4716d != 0 ? this.f4716d : Math.round(((float) a.getWidth()) / 40.0f));
                    str3 = c1530e.m5359a();
                }
            } catch (Throwable th2) {
                th = th2;
                str = f4713b;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error downloading image: ");
                stringBuilder.append(str2);
                Log.e(str, stringBuilder.toString(), th);
                C1398b.m4797a(C1397a.m4794a(th, null));
                return new Bitmap[]{a, str3};
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            str = f4713b;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error downloading image: ");
            stringBuilder.append(str2);
            Log.e(str, stringBuilder.toString(), th);
            C1398b.m4797a(C1397a.m4794a(th, null));
            return new Bitmap[]{a, str3};
        }
        return new Bitmap[]{a, str3};
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m5510a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m5509a((Bitmap[]) obj);
    }
}
