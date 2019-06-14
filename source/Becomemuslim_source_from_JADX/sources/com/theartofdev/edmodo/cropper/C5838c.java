package com.theartofdev.edmodo.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.support.p018e.C0207a;
import android.util.Log;
import android.util.Pair;
import com.facebook.imagepipeline.common.RotationOptions;
import com.theartofdev.edmodo.cropper.CropImageView.C5827i;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: BitmapUtils */
/* renamed from: com.theartofdev.edmodo.cropper.c */
final class C5838c {
    /* renamed from: a */
    static final Rect f19392a = new Rect();
    /* renamed from: b */
    static final RectF f19393b = new RectF();
    /* renamed from: c */
    static final RectF f19394c = new RectF();
    /* renamed from: d */
    static final float[] f19395d = new float[6];
    /* renamed from: e */
    static final float[] f19396e = new float[6];
    /* renamed from: f */
    static Pair<String, WeakReference<Bitmap>> f19397f;
    /* renamed from: g */
    private static int f19398g;

    /* compiled from: BitmapUtils */
    /* renamed from: com.theartofdev.edmodo.cropper.c$a */
    static final class C5836a {
        /* renamed from: a */
        public final Bitmap f19388a;
        /* renamed from: b */
        final int f19389b;

        C5836a(Bitmap bitmap, int i) {
            this.f19388a = bitmap;
            this.f19389b = i;
        }
    }

    /* compiled from: BitmapUtils */
    /* renamed from: com.theartofdev.edmodo.cropper.c$b */
    static final class C5837b {
        /* renamed from: a */
        public final Bitmap f19390a;
        /* renamed from: b */
        final int f19391b;

        C5837b(Bitmap bitmap, int i) {
            this.f19390a = bitmap;
            this.f19391b = i;
        }
    }

    /* renamed from: a */
    static com.theartofdev.edmodo.cropper.C5838c.C5837b m24612a(android.graphics.Bitmap r1, android.content.Context r2, android.net.Uri r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x0014 }
        r2 = r2.openInputStream(r3);	 Catch:{ Exception -> 0x0014 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ Exception -> 0x0014 }
    L_0x000b:
        r3 = new android.support.e.a;	 Catch:{ Exception -> 0x0014 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0014 }
        r2.close();	 Catch:{ Exception -> 0x0015 }
        goto L_0x0015;
    L_0x0014:
        r3 = r0;
    L_0x0015:
        if (r3 == 0) goto L_0x001c;
    L_0x0017:
        r1 = com.theartofdev.edmodo.cropper.C5838c.m24613a(r1, r3);
        goto L_0x0023;
    L_0x001c:
        r2 = new com.theartofdev.edmodo.cropper.c$b;
        r3 = 0;
        r2.<init>(r1, r3);
        r1 = r2;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(android.graphics.Bitmap, android.content.Context, android.net.Uri):com.theartofdev.edmodo.cropper.c$b");
    }

    /* renamed from: a */
    static C5837b m24613a(Bitmap bitmap, C0207a c0207a) {
        c0207a = c0207a.a("Orientation", 1);
        c0207a = c0207a != 3 ? c0207a != 6 ? c0207a != 8 ? null : RotationOptions.ROTATE_270 : 90 : RotationOptions.ROTATE_180;
        return new C5837b(bitmap, c0207a);
    }

    /* renamed from: a */
    static C5836a m24606a(Context context, Uri uri, int i, int i2) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Options a = C5838c.m24603a(contentResolver, uri);
            a.inSampleSize = Math.max(C5838c.m24597a(a.outWidth, a.outHeight, i, i2), C5838c.m24596a(a.outWidth, a.outHeight));
            return new C5836a(C5838c.m24598a(contentResolver, uri, a), a.inSampleSize);
        } catch (Context context2) {
            i2 = new StringBuilder();
            i2.append("Failed to load sampled bitmap: ");
            i2.append(uri);
            i2.append("\r\n");
            i2.append(context2.getMessage());
            throw new RuntimeException(i2.toString(), context2);
        }
    }

    /* renamed from: a */
    static C5836a m24611a(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        int i4 = 1;
        while (true) {
            try {
                break;
            } catch (OutOfMemoryError e) {
                i4 *= 2;
                if (i4 > 8) {
                    throw e;
                }
            }
        }
        return new C5836a(C5838c.m24601a(bitmap, fArr, i, z, i2, i3, 1.0f / ((float) i4), z2, z3), i4);
    }

    /* renamed from: a */
    private static Bitmap m24601a(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f, boolean z2, boolean z3) {
        Bitmap bitmap2 = bitmap;
        int i4 = i;
        float f2 = f;
        Rect a = C5838c.m24604a(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i4, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        float f3 = z2 ? -f2 : f2;
        if (z3) {
            f2 = -f2;
        }
        matrix.postScale(f3, f2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, a.left, a.top, a.width(), a.height(), matrix, true);
        if (createBitmap == bitmap2) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i4 % 90 != 0 ? C5838c.m24602a(createBitmap, fArr, a, i, z, i2, i3) : createBitmap;
    }

    /* renamed from: a */
    static C5836a m24608a(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        int i8 = 1;
        while (true) {
            try {
                break;
            } catch (Throwable e) {
                Throwable th = e;
                i8 *= 2;
                if (i8 > 16) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to handle OOM by sampling (");
                    stringBuilder.append(i8);
                    stringBuilder.append("): ");
                    stringBuilder.append(uri);
                    stringBuilder.append("\r\n");
                    stringBuilder.append(th.getMessage());
                    throw new RuntimeException(stringBuilder.toString(), th);
                }
            }
        }
        return C5838c.m24609a(context, uri, fArr, i, i2, i3, z, i4, i5, i6, i7, z2, z3, i8);
    }

    /* renamed from: a */
    static float m24594a(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    /* renamed from: b */
    static float m24617b(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    /* renamed from: c */
    static float m24618c(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    /* renamed from: d */
    static float m24619d(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    /* renamed from: e */
    static float m24620e(float[] fArr) {
        return C5838c.m24618c(fArr) - C5838c.m24594a(fArr);
    }

    /* renamed from: f */
    static float m24621f(float[] fArr) {
        return C5838c.m24619d(fArr) - C5838c.m24617b(fArr);
    }

    /* renamed from: g */
    static float m24622g(float[] fArr) {
        return (C5838c.m24618c(fArr) + C5838c.m24594a(fArr)) / 1073741824;
    }

    /* renamed from: h */
    static float m24623h(float[] fArr) {
        return (C5838c.m24619d(fArr) + C5838c.m24617b(fArr)) / 1073741824;
    }

    /* renamed from: a */
    static Rect m24604a(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, C5838c.m24594a(fArr))), Math.round(Math.max(0.0f, C5838c.m24617b(fArr))), Math.round(Math.min((float) i, C5838c.m24618c(fArr))), Math.round(Math.min((float) i2, C5838c.m24619d(fArr))));
        if (z) {
            C5838c.m24615a(rect, i3, i4);
        }
        return rect;
    }

    /* renamed from: a */
    private static void m24615a(Rect rect, int i, int i2) {
        if (i == i2 && rect.width() != rect.height()) {
            if (rect.height() > rect.width()) {
                rect.bottom -= rect.height() - rect.width();
            } else {
                rect.right -= rect.width() - rect.height();
            }
        }
    }

    /* renamed from: a */
    static Uri m24605a(Context context, Bitmap bitmap, Uri uri) {
        Object obj = 1;
        if (uri == null) {
            try {
                uri = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
            } catch (Context context2) {
                Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", context2);
                return null;
            }
        } else if (new File(uri.getPath()).exists()) {
            obj = null;
        }
        if (obj != null) {
            C5838c.m24614a(context2, bitmap, uri, CompressFormat.JPEG, 95);
        }
        return uri;
    }

    /* renamed from: a */
    static void m24614a(Context context, Bitmap bitmap, Uri uri, CompressFormat compressFormat, int i) {
        Closeable closeable = null;
        try {
            Closeable openOutputStream = context.getContentResolver().openOutputStream(uri);
            try {
                bitmap.compress(compressFormat, i, openOutputStream);
                C5838c.m24616a(openOutputStream);
            } catch (Throwable th) {
                bitmap = th;
                closeable = openOutputStream;
                C5838c.m24616a(closeable);
                throw bitmap;
            }
        } catch (Throwable th2) {
            bitmap = th2;
            C5838c.m24616a(closeable);
            throw bitmap;
        }
    }

    /* renamed from: a */
    static Bitmap m24599a(Bitmap bitmap, int i, int i2, C5827i c5827i) {
        if (i > 0 && i2 > 0) {
            try {
                if (c5827i == C5827i.RESIZE_FIT || c5827i == C5827i.RESIZE_INSIDE || c5827i == C5827i.RESIZE_EXACT) {
                    Bitmap bitmap2 = null;
                    if (c5827i == C5827i.RESIZE_EXACT) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                    } else {
                        float width = (float) bitmap.getWidth();
                        float height = (float) bitmap.getHeight();
                        i = Math.max(width / ((float) i), height / ((float) i2));
                        if (i > 1065353216 || c5827i == C5827i.RESIZE_FIT) {
                            bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (width / i), (int) (height / i), false);
                        }
                    }
                    if (bitmap2 != null) {
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmap2;
                    }
                }
            } catch (int i3) {
                Log.w("AIC", "Failed to resize cropped image, return bitmap before resize", i3);
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    private static com.theartofdev.edmodo.cropper.C5838c.C5836a m24609a(android.content.Context r14, android.net.Uri r15, float[] r16, int r17, int r18, int r19, boolean r20, int r21, int r22, int r23, int r24, boolean r25, boolean r26, int r27) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r17;
        r1 = r16;
        r2 = r18;
        r3 = r19;
        r4 = r20;
        r5 = r21;
        r6 = r22;
        r9 = com.theartofdev.edmodo.cropper.C5838c.m24604a(r1, r2, r3, r4, r5, r6);
        if (r23 <= 0) goto L_0x0017;
    L_0x0014:
        r10 = r23;
        goto L_0x001c;
    L_0x0017:
        r1 = r9.width();
        r10 = r1;
    L_0x001c:
        if (r24 <= 0) goto L_0x0021;
    L_0x001e:
        r11 = r24;
        goto L_0x0026;
    L_0x0021:
        r1 = r9.height();
        r11 = r1;
    L_0x0026:
        r1 = 0;
        r8 = 1;
        r2 = r14;
        r3 = r15;
        r4 = r9;
        r5 = r10;
        r6 = r11;
        r7 = r27;
        r2 = com.theartofdev.edmodo.cropper.C5838c.m24607a(r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0039 }
        r3 = r2.f19388a;	 Catch:{ Exception -> 0x0039 }
        r1 = r2.f19389b;	 Catch:{ Exception -> 0x003a }
        r8 = r1;
        goto L_0x003a;
    L_0x0039:
        r3 = r1;
    L_0x003a:
        if (r3 == 0) goto L_0x0069;
    L_0x003c:
        r12 = r25;
        r13 = r26;
        r10 = com.theartofdev.edmodo.cropper.C5838c.m24600a(r3, r0, r12, r13);	 Catch:{ OutOfMemoryError -> 0x0061 }
        r1 = r0 % 90;	 Catch:{ OutOfMemoryError -> 0x005f }
        if (r1 == 0) goto L_0x0059;	 Catch:{ OutOfMemoryError -> 0x005f }
    L_0x0048:
        r1 = r10;	 Catch:{ OutOfMemoryError -> 0x005f }
        r2 = r16;	 Catch:{ OutOfMemoryError -> 0x005f }
        r3 = r9;	 Catch:{ OutOfMemoryError -> 0x005f }
        r4 = r17;	 Catch:{ OutOfMemoryError -> 0x005f }
        r5 = r20;	 Catch:{ OutOfMemoryError -> 0x005f }
        r6 = r21;	 Catch:{ OutOfMemoryError -> 0x005f }
        r7 = r22;	 Catch:{ OutOfMemoryError -> 0x005f }
        r0 = com.theartofdev.edmodo.cropper.C5838c.m24602a(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ OutOfMemoryError -> 0x005f }
        r10 = r0;
    L_0x0059:
        r0 = new com.theartofdev.edmodo.cropper.c$a;
        r0.<init>(r10, r8);
        return r0;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0063;
    L_0x0061:
        r0 = move-exception;
        r10 = r3;
    L_0x0063:
        if (r10 == 0) goto L_0x0068;
    L_0x0065:
        r10.recycle();
    L_0x0068:
        throw r0;
    L_0x0069:
        r12 = r25;
        r13 = r26;
        r1 = r14;
        r2 = r15;
        r3 = r16;
        r4 = r17;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        r8 = r27;
        r0 = com.theartofdev.edmodo.cropper.C5838c.m24610a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(android.content.Context, android.net.Uri, float[], int, int, int, boolean, int, int, int, int, boolean, boolean, int):com.theartofdev.edmodo.cropper.c$a");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static com.theartofdev.edmodo.cropper.C5838c.C5836a m24610a(android.content.Context r15, android.net.Uri r16, float[] r17, int r18, boolean r19, int r20, int r21, int r22, android.graphics.Rect r23, int r24, int r25, boolean r26, boolean r27) {
        /*
        r1 = r16;
        r0 = r17;
        r2 = 0;
        r3 = new android.graphics.BitmapFactory$Options;	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        r3.<init>();	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        r4 = r23.width();	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        r5 = r23.height();	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        r6 = r24;
        r7 = r25;
        r4 = com.theartofdev.edmodo.cropper.C5838c.m24597a(r4, r5, r6, r7);	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        r4 = r4 * r22;
        r3.inSampleSize = r4;	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        r5 = r15.getContentResolver();	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        r5 = com.theartofdev.edmodo.cropper.C5838c.m24598a(r5, r1, r3);	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
        if (r5 == 0) goto L_0x0061;
    L_0x0028:
        r6 = r0.length;	 Catch:{ all -> 0x005a }
        r7 = new float[r6];	 Catch:{ all -> 0x005a }
        r6 = r0.length;	 Catch:{ all -> 0x005a }
        r8 = 0;
        java.lang.System.arraycopy(r0, r8, r7, r8, r6);	 Catch:{ all -> 0x005a }
    L_0x0030:
        r0 = r7.length;	 Catch:{ all -> 0x005a }
        if (r8 >= r0) goto L_0x003e;
    L_0x0033:
        r0 = r7[r8];	 Catch:{ all -> 0x005a }
        r6 = r3.inSampleSize;	 Catch:{ all -> 0x005a }
        r6 = (float) r6;	 Catch:{ all -> 0x005a }
        r0 = r0 / r6;
        r7[r8] = r0;	 Catch:{ all -> 0x005a }
        r8 = r8 + 1;
        goto L_0x0030;
    L_0x003e:
        r12 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r6 = r5;
        r8 = r18;
        r9 = r19;
        r10 = r20;
        r11 = r21;
        r13 = r26;
        r14 = r27;
        r3 = com.theartofdev.edmodo.cropper.C5838c.m24601a(r6, r7, r8, r9, r10, r11, r12, r13, r14);	 Catch:{ all -> 0x005a }
        if (r3 == r5) goto L_0x0062;
    L_0x0053:
        r5.recycle();	 Catch:{ OutOfMemoryError -> 0x0057, Exception -> 0x0068 }
        goto L_0x0062;
    L_0x0057:
        r0 = move-exception;
        r2 = r3;
        goto L_0x008d;
    L_0x005a:
        r0 = move-exception;
        if (r5 == 0) goto L_0x0060;
    L_0x005d:
        r5.recycle();	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
    L_0x0060:
        throw r0;	 Catch:{ OutOfMemoryError -> 0x008c, Exception -> 0x0068 }
    L_0x0061:
        r3 = r2;
    L_0x0062:
        r0 = new com.theartofdev.edmodo.cropper.c$a;
        r0.<init>(r3, r4);
        return r0;
    L_0x0068:
        r0 = move-exception;
        r2 = new java.lang.RuntimeException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Failed to load sampled bitmap: ";
        r3.append(r4);
        r3.append(r1);
        r1 = "\r\n";
        r3.append(r1);
        r1 = r0.getMessage();
        r3.append(r1);
        r1 = r3.toString();
        r2.<init>(r1, r0);
        throw r2;
    L_0x008c:
        r0 = move-exception;
    L_0x008d:
        if (r2 == 0) goto L_0x0092;
    L_0x008f:
        r2.recycle();
    L_0x0092:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(android.content.Context, android.net.Uri, float[], int, boolean, int, int, int, android.graphics.Rect, int, int, boolean, boolean):com.theartofdev.edmodo.cropper.c$a");
    }

    /* renamed from: a */
    private static Options m24603a(ContentResolver contentResolver, Uri uri) {
        Closeable openInputStream;
        try {
            openInputStream = contentResolver.openInputStream(uri);
            try {
                uri = new Options();
                uri.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(openInputStream, f19392a, uri);
                uri.inJustDecodeBounds = false;
                C5838c.m24616a(openInputStream);
                return uri;
            } catch (Throwable th) {
                uri = th;
                C5838c.m24616a(openInputStream);
                throw uri;
            }
        } catch (Throwable th2) {
            uri = th2;
            openInputStream = null;
            C5838c.m24616a(openInputStream);
            throw uri;
        }
    }

    /* renamed from: a */
    private static android.graphics.Bitmap m24598a(android.content.ContentResolver r2, android.net.Uri r3, android.graphics.BitmapFactory.Options r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
    L_0x0000:
        r0 = 0;
        r1 = r2.openInputStream(r3);	 Catch:{ OutOfMemoryError -> 0x0016 }
        r0 = f19392a;	 Catch:{ OutOfMemoryError -> 0x0012, all -> 0x000f }
        r0 = android.graphics.BitmapFactory.decodeStream(r1, r0, r4);	 Catch:{ OutOfMemoryError -> 0x0012, all -> 0x000f }
        com.theartofdev.edmodo.cropper.C5838c.m24616a(r1);
        return r0;
    L_0x000f:
        r2 = move-exception;
        r0 = r1;
        goto L_0x003d;
    L_0x0012:
        r0 = r1;
        goto L_0x0016;
    L_0x0014:
        r2 = move-exception;
        goto L_0x003d;
    L_0x0016:
        r1 = r4.inSampleSize;	 Catch:{ all -> 0x0014 }
        r1 = r1 * 2;	 Catch:{ all -> 0x0014 }
        r4.inSampleSize = r1;	 Catch:{ all -> 0x0014 }
        com.theartofdev.edmodo.cropper.C5838c.m24616a(r0);
        r0 = r4.inSampleSize;
        r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r0 > r1) goto L_0x0026;
    L_0x0025:
        goto L_0x0000;
    L_0x0026:
        r2 = new java.lang.RuntimeException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = "Failed to decode image: ";
        r4.append(r0);
        r4.append(r3);
        r3 = r4.toString();
        r2.<init>(r3);
        throw r2;
    L_0x003d:
        com.theartofdev.edmodo.cropper.C5838c.m24616a(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(android.content.ContentResolver, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static com.theartofdev.edmodo.cropper.C5838c.C5836a m24607a(android.content.Context r4, android.net.Uri r5, android.graphics.Rect r6, int r7, int r8, int r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new android.graphics.BitmapFactory$Options;	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r1.<init>();	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r2 = r6.width();	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r3 = r6.height();	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r7 = com.theartofdev.edmodo.cropper.C5838c.m24597a(r2, r3, r7, r8);	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r9 = r9 * r7;	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r1.inSampleSize = r9;	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r4 = r4.getContentResolver();	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r4 = r4.openInputStream(r5);	 Catch:{ Exception -> 0x0061, all -> 0x005e }
        r7 = 0;
        r7 = android.graphics.BitmapRegionDecoder.newInstance(r4, r7);	 Catch:{ Exception -> 0x005a, all -> 0x0056 }
    L_0x0023:
        r8 = new com.theartofdev.edmodo.cropper.c$a;	 Catch:{ OutOfMemoryError -> 0x003b }
        r9 = r7.decodeRegion(r6, r1);	 Catch:{ OutOfMemoryError -> 0x003b }
        r2 = r1.inSampleSize;	 Catch:{ OutOfMemoryError -> 0x003b }
        r8.<init>(r9, r2);	 Catch:{ OutOfMemoryError -> 0x003b }
        com.theartofdev.edmodo.cropper.C5838c.m24616a(r4);
        if (r7 == 0) goto L_0x0036;
    L_0x0033:
        r7.recycle();
    L_0x0036:
        return r8;
    L_0x0037:
        r5 = move-exception;
        goto L_0x0058;
    L_0x0039:
        r6 = move-exception;
        goto L_0x005c;
    L_0x003b:
        r8 = r1.inSampleSize;	 Catch:{ Exception -> 0x0039, all -> 0x0037 }
        r8 = r8 * 2;	 Catch:{ Exception -> 0x0039, all -> 0x0037 }
        r1.inSampleSize = r8;	 Catch:{ Exception -> 0x0039, all -> 0x0037 }
        r8 = r1.inSampleSize;	 Catch:{ Exception -> 0x0039, all -> 0x0037 }
        r9 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r8 <= r9) goto L_0x0023;
    L_0x0047:
        com.theartofdev.edmodo.cropper.C5838c.m24616a(r4);
        if (r7 == 0) goto L_0x004f;
    L_0x004c:
        r7.recycle();
    L_0x004f:
        r4 = new com.theartofdev.edmodo.cropper.c$a;
        r5 = 1;
        r4.<init>(r0, r5);
        return r4;
    L_0x0056:
        r5 = move-exception;
        r7 = r0;
    L_0x0058:
        r0 = r4;
        goto L_0x0087;
    L_0x005a:
        r6 = move-exception;
        r7 = r0;
    L_0x005c:
        r0 = r4;
        goto L_0x0063;
    L_0x005e:
        r5 = move-exception;
        r7 = r0;
        goto L_0x0087;
    L_0x0061:
        r6 = move-exception;
        r7 = r0;
    L_0x0063:
        r4 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0086 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0086 }
        r8.<init>();	 Catch:{ all -> 0x0086 }
        r9 = "Failed to load sampled bitmap: ";	 Catch:{ all -> 0x0086 }
        r8.append(r9);	 Catch:{ all -> 0x0086 }
        r8.append(r5);	 Catch:{ all -> 0x0086 }
        r5 = "\r\n";	 Catch:{ all -> 0x0086 }
        r8.append(r5);	 Catch:{ all -> 0x0086 }
        r5 = r6.getMessage();	 Catch:{ all -> 0x0086 }
        r8.append(r5);	 Catch:{ all -> 0x0086 }
        r5 = r8.toString();	 Catch:{ all -> 0x0086 }
        r4.<init>(r5, r6);	 Catch:{ all -> 0x0086 }
        throw r4;	 Catch:{ all -> 0x0086 }
    L_0x0086:
        r5 = move-exception;
    L_0x0087:
        com.theartofdev.edmodo.cropper.C5838c.m24616a(r0);
        if (r7 == 0) goto L_0x008f;
    L_0x008c:
        r7.recycle();
    L_0x008f:
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(android.content.Context, android.net.Uri, android.graphics.Rect, int, int, int):com.theartofdev.edmodo.cropper.c$a");
    }

    /* renamed from: a */
    private static Bitmap m24602a(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        if (i % 90 == 0) {
            return bitmap;
        }
        int i4;
        int i5;
        int abs;
        double toRadians = Math.toRadians((double) i);
        if (i >= 90) {
            if (i <= RotationOptions.ROTATE_180 || i >= RotationOptions.ROTATE_270) {
                i = rect.right;
                i4 = 0;
                i5 = 0;
                while (i5 < fArr.length) {
                    if (fArr[i5] < ((float) (i - 1)) && fArr[i5] <= ((float) (i + 1))) {
                        i5++;
                        i4 = (int) Math.abs(Math.sin(toRadians) * ((double) (((float) rect.bottom) - fArr[i5])));
                        i = (int) Math.abs(Math.cos(toRadians) * ((double) (fArr[i5] - ((float) rect.top))));
                        abs = (int) Math.abs(((double) (fArr[i5] - ((float) rect.top))) / Math.sin(toRadians));
                        fArr = (int) Math.abs(((double) (((float) rect.bottom) - fArr[i5])) / Math.cos(toRadians));
                        break;
                    }
                    i5 += 2;
                }
                fArr = null;
                i = 0;
                abs = 0;
                rect.set(i4, i, abs + i4, fArr + i);
                if (z) {
                    C5838c.m24615a(rect, i2, i3);
                }
                fArr = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
                if (bitmap != fArr) {
                    bitmap.recycle();
                }
                return fArr;
            }
        }
        i = rect.left;
        i4 = 0;
        i5 = 0;
        while (i5 < fArr.length) {
            if (fArr[i5] < ((float) (i - 1))) {
            }
            i5 += 2;
        }
        fArr = null;
        i = 0;
        abs = 0;
        rect.set(i4, i, abs + i4, fArr + i);
        if (z) {
            C5838c.m24615a(rect, i2, i3);
        }
        fArr = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != fArr) {
            bitmap.recycle();
        }
        return fArr;
    }

    /* renamed from: a */
    private static int m24597a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* renamed from: a */
    private static int m24596a(int i, int i2) {
        if (f19398g == 0) {
            f19398g = C5838c.m24595a();
        }
        int i3 = 1;
        if (f19398g > 0) {
            while (true) {
                if (i2 / i3 <= f19398g && i / i3 <= f19398g) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    /* renamed from: a */
    private static Bitmap m24600a(Bitmap bitmap, int i, boolean z, boolean z2) {
        if (i <= 0 && !z) {
            if (!z2) {
                return bitmap;
            }
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i);
        i = 1065353216;
        z = z ? true : true;
        if (z2) {
            i = -1082130432;
        }
        matrix.postScale(z, i);
        i = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (i != bitmap) {
            bitmap.recycle();
        }
        return i;
    }

    /* renamed from: a */
    private static int m24595a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r1 = javax.microedition.khronos.egl.EGLContext.getEGL();	 Catch:{ Exception -> 0x0045 }
        r1 = (javax.microedition.khronos.egl.EGL10) r1;	 Catch:{ Exception -> 0x0045 }
        r2 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY;	 Catch:{ Exception -> 0x0045 }
        r2 = r1.eglGetDisplay(r2);	 Catch:{ Exception -> 0x0045 }
        r3 = 2;	 Catch:{ Exception -> 0x0045 }
        r3 = new int[r3];	 Catch:{ Exception -> 0x0045 }
        r1.eglInitialize(r2, r3);	 Catch:{ Exception -> 0x0045 }
        r3 = 1;	 Catch:{ Exception -> 0x0045 }
        r4 = new int[r3];	 Catch:{ Exception -> 0x0045 }
        r5 = 0;	 Catch:{ Exception -> 0x0045 }
        r6 = 0;	 Catch:{ Exception -> 0x0045 }
        r1.eglGetConfigs(r2, r5, r6, r4);	 Catch:{ Exception -> 0x0045 }
        r5 = r4[r6];	 Catch:{ Exception -> 0x0045 }
        r5 = new javax.microedition.khronos.egl.EGLConfig[r5];	 Catch:{ Exception -> 0x0045 }
        r7 = r4[r6];	 Catch:{ Exception -> 0x0045 }
        r1.eglGetConfigs(r2, r5, r7, r4);	 Catch:{ Exception -> 0x0045 }
        r3 = new int[r3];	 Catch:{ Exception -> 0x0045 }
        r7 = 0;	 Catch:{ Exception -> 0x0045 }
        r8 = 0;	 Catch:{ Exception -> 0x0045 }
    L_0x0029:
        r9 = r4[r6];	 Catch:{ Exception -> 0x0045 }
        if (r7 >= r9) goto L_0x003d;	 Catch:{ Exception -> 0x0045 }
    L_0x002d:
        r9 = r5[r7];	 Catch:{ Exception -> 0x0045 }
        r10 = 12332; // 0x302c float:1.7281E-41 double:6.093E-320;	 Catch:{ Exception -> 0x0045 }
        r1.eglGetConfigAttrib(r2, r9, r10, r3);	 Catch:{ Exception -> 0x0045 }
        r9 = r3[r6];	 Catch:{ Exception -> 0x0045 }
        if (r8 >= r9) goto L_0x003a;	 Catch:{ Exception -> 0x0045 }
    L_0x0038:
        r8 = r3[r6];	 Catch:{ Exception -> 0x0045 }
    L_0x003a:
        r7 = r7 + 1;	 Catch:{ Exception -> 0x0045 }
        goto L_0x0029;	 Catch:{ Exception -> 0x0045 }
    L_0x003d:
        r1.eglTerminate(r2);	 Catch:{ Exception -> 0x0045 }
        r1 = java.lang.Math.max(r8, r0);	 Catch:{ Exception -> 0x0045 }
        return r1;
    L_0x0045:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a():int");
    }

    /* renamed from: a */
    private static void m24616a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0005;
    L_0x0002:
        r0.close();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(java.io.Closeable):void");
    }
}
