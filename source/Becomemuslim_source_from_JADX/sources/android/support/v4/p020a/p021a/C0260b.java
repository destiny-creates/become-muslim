package android.support.v4.p020a.p021a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.C0366b;

/* compiled from: IconCompat */
/* renamed from: android.support.v4.a.a.b */
public class C0260b {
    /* renamed from: a */
    private final int f658a;
    /* renamed from: b */
    private Object f659b;
    /* renamed from: c */
    private int f660c;
    /* renamed from: d */
    private int f661d;

    /* renamed from: a */
    public static C0260b m707a(Context context, int i) {
        if (context != null) {
            C0260b c0260b = new C0260b(2);
            c0260b.f660c = i;
            c0260b.f659b = context;
            return c0260b;
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    /* renamed from: a */
    public static C0260b m708a(Bitmap bitmap) {
        if (bitmap != null) {
            C0260b c0260b = new C0260b(1);
            c0260b.f659b = bitmap;
            return c0260b;
        }
        throw new IllegalArgumentException("Bitmap must not be null.");
    }

    private C0260b(int i) {
        this.f658a = i;
    }

    /* renamed from: a */
    public Icon m709a() {
        switch (this.f658a) {
            case 1:
                return Icon.createWithBitmap((Bitmap) this.f659b);
            case 2:
                return Icon.createWithResource((Context) this.f659b, this.f660c);
            case 3:
                return Icon.createWithData((byte[]) this.f659b, this.f660c, this.f661d);
            case 4:
                return Icon.createWithContentUri((String) this.f659b);
            case 5:
                if (VERSION.SDK_INT >= 26) {
                    return Icon.createWithAdaptiveBitmap((Bitmap) this.f659b);
                }
                return Icon.createWithBitmap(C0260b.m706a((Bitmap) this.f659b, false));
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }

    /* renamed from: a */
    public void m710a(Intent intent, Drawable drawable) {
        Parcelable parcelable;
        int i = this.f658a;
        if (i != 5) {
            switch (i) {
                case 1:
                    parcelable = (Bitmap) this.f659b;
                    if (drawable != null) {
                        parcelable = parcelable.copy(parcelable.getConfig(), true);
                        break;
                    }
                    break;
                case 2:
                    if (drawable == null) {
                        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext((Context) this.f659b, this.f660c));
                        return;
                    }
                    Context context = (Context) this.f659b;
                    Drawable a = C0366b.m1103a(context, this.f660c);
                    if (a.getIntrinsicWidth() > 0) {
                        if (a.getIntrinsicHeight() > 0) {
                            parcelable = Bitmap.createBitmap(a.getIntrinsicWidth(), a.getIntrinsicHeight(), Config.ARGB_8888);
                            a.setBounds(0, 0, parcelable.getWidth(), parcelable.getHeight());
                            a.draw(new Canvas(parcelable));
                            break;
                        }
                    }
                    i = ((ActivityManager) context.getSystemService("activity")).getLauncherLargeIconSize();
                    parcelable = Bitmap.createBitmap(i, i, Config.ARGB_8888);
                    a.setBounds(0, 0, parcelable.getWidth(), parcelable.getHeight());
                    a.draw(new Canvas(parcelable));
                default:
                    throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
        }
        parcelable = C0260b.m706a((Bitmap) this.f659b, true);
        if (drawable != null) {
            int width = parcelable.getWidth();
            int height = parcelable.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(parcelable));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", parcelable);
    }

    /* renamed from: a */
    static Bitmap m706a(Bitmap bitmap, boolean z) {
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = (float) min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            z = true * f;
            paint.setColor(0);
            paint.setShadowLayer(z, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(z, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(true);
        z = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) ((-(bitmap.getWidth() - min)) / 2), (float) ((-(bitmap.getHeight() - min)) / 2));
        z.setLocalMatrix(matrix);
        paint.setShader(z);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }
}
