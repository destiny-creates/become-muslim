package com.imagepicker.p252c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import com.facebook.react.bridge.ReadableMap;
import com.imagepicker.ImagePickerModule;
import com.imagepicker.p250a.C5404a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.UUID;

/* compiled from: MediaUtils */
/* renamed from: com.imagepicker.c.b */
public class C5418b {

    /* compiled from: MediaUtils */
    /* renamed from: com.imagepicker.c.b$1 */
    static class C54151 implements OnScanCompletedListener {
        C54151() {
        }

        public void onScanCompleted(String str, Uri uri) {
            StringBuilder stringBuilder = new StringBuilder("Finished scanning ");
            stringBuilder.append(str);
            Log.i("TAG", stringBuilder.toString());
        }
    }

    /* compiled from: MediaUtils */
    /* renamed from: com.imagepicker.c.b$a */
    public static class C5416a {
        /* renamed from: a */
        public final int f18211a;
        /* renamed from: b */
        public final Throwable f18212b;

        public C5416a(int i, Throwable th) {
            this.f18211a = i;
            this.f18212b = th;
        }
    }

    /* compiled from: MediaUtils */
    /* renamed from: com.imagepicker.c.b$b */
    public static class C5417b {
        /* renamed from: a */
        public final C5404a f18213a;
        /* renamed from: b */
        public final Throwable f18214b;

        public C5417b(C5404a c5404a, Throwable th) {
            this.f18213a = c5404a;
            this.f18214b = th;
        }
    }

    /* renamed from: a */
    public static File m22992a(Context context, ReadableMap readableMap, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("image-");
        stringBuilder.append(UUID.randomUUID().toString());
        stringBuilder.append(".jpg");
        String stringBuilder2 = stringBuilder.toString();
        if (C5419c.m22996a(readableMap, "storageOptions") && C5419c.m22998b(readableMap.getMap("storageOptions"), "path")) {
            context = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), readableMap.getMap("storageOptions").getString("path"));
        } else if (z) {
            context = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        } else {
            context = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        }
        readableMap = new File(context, stringBuilder2);
        try {
            context.mkdirs();
            readableMap.createNewFile();
            return readableMap;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static C5404a m22989a(Context context, ReadableMap readableMap, C5404a c5404a, int i, int i2, int i3) {
        int i4;
        int i5;
        Bitmap decodeFile;
        C5404a c5404a2;
        C5404a c5404a3;
        double d;
        double d2;
        Matrix matrix;
        float f;
        int attributeInt;
        Bitmap createBitmap;
        OutputStream byteArrayOutputStream;
        File a;
        OutputStream fileOutputStream;
        C5404a c5404a4 = c5404a;
        Options options = new Options();
        int i6 = 0;
        options.inScaled = false;
        options.inSampleSize = 1;
        if (c5404a4.f18196c == 0) {
            if (c5404a4.f18197d == 0) {
                i4 = i;
                i5 = i2;
                decodeFile = BitmapFactory.decodeFile(c5404a4.f18194a.getAbsolutePath(), options);
                if (decodeFile == null) {
                    return null;
                }
                if (c5404a4.f18196c != 0) {
                    if (c5404a4.f18196c > i4) {
                        c5404a2 = c5404a4;
                        if (c5404a4.f18197d != 0) {
                            if (c5404a4.f18196c > i5) {
                            }
                            c5404a3 = c5404a2;
                            d = ((double) c5404a3.f18196c) / ((double) i4);
                            d2 = ((double) c5404a3.f18197d) / ((double) i5);
                            if (d < d2) {
                                d2 = d;
                            }
                            matrix = new Matrix();
                            matrix.postRotate((float) c5404a3.f18199f);
                            f = (float) d2;
                            matrix.postScale(f, f);
                            attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
                            if (attributeInt == 3) {
                                matrix.postRotate(180.0f);
                            } else if (attributeInt == 6) {
                                matrix.postRotate(90.0f);
                            } else if (attributeInt == 8) {
                                matrix.postRotate(270.0f);
                            }
                            createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                            byteArrayOutputStream = new ByteArrayOutputStream();
                            createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
                            if (i3 == 13001) {
                                i6 = 1;
                            }
                            a = C5418b.m22992a(context, readableMap, i6 ^ true);
                            if (a != null) {
                                if (decodeFile != null) {
                                    decodeFile.recycle();
                                }
                                if (createBitmap != null) {
                                    createBitmap.recycle();
                                }
                                return c5404a4;
                            }
                            c5404a4 = c5404a3.m22979b(a);
                            try {
                                fileOutputStream = new FileOutputStream(c5404a4.f18195b);
                                byteArrayOutputStream.writeTo(fileOutputStream);
                                fileOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Throwable th) {
                                r14.addSuppressed(th);
                            }
                            if (decodeFile != null) {
                                decodeFile.recycle();
                            }
                            if (createBitmap != null) {
                                createBitmap.recycle();
                            }
                            return c5404a4;
                        }
                        c5404a2 = c5404a2.m22978b(i5);
                        c5404a3 = c5404a2;
                        d = ((double) c5404a3.f18196c) / ((double) i4);
                        d2 = ((double) c5404a3.f18197d) / ((double) i5);
                        if (d < d2) {
                            d2 = d;
                        }
                        matrix = new Matrix();
                        matrix.postRotate((float) c5404a3.f18199f);
                        f = (float) d2;
                        matrix.postScale(f, f);
                        attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
                        if (attributeInt == 3) {
                            matrix.postRotate(180.0f);
                        } else if (attributeInt == 6) {
                            matrix.postRotate(90.0f);
                        } else if (attributeInt == 8) {
                            matrix.postRotate(270.0f);
                        }
                        createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
                        if (i3 == 13001) {
                            i6 = 1;
                        }
                        a = C5418b.m22992a(context, readableMap, i6 ^ true);
                        if (a != null) {
                            c5404a4 = c5404a3.m22979b(a);
                            fileOutputStream = new FileOutputStream(c5404a4.f18195b);
                            byteArrayOutputStream.writeTo(fileOutputStream);
                            fileOutputStream.close();
                            if (decodeFile != null) {
                                decodeFile.recycle();
                            }
                            if (createBitmap != null) {
                                createBitmap.recycle();
                            }
                            return c5404a4;
                        }
                        if (decodeFile != null) {
                            decodeFile.recycle();
                        }
                        if (createBitmap != null) {
                            createBitmap.recycle();
                        }
                        return c5404a4;
                    }
                }
                c5404a2 = c5404a4.m22973a(i4);
                if (c5404a4.f18197d != 0) {
                    if (c5404a4.f18196c > i5) {
                    }
                    c5404a3 = c5404a2;
                    d = ((double) c5404a3.f18196c) / ((double) i4);
                    d2 = ((double) c5404a3.f18197d) / ((double) i5);
                    if (d < d2) {
                        d2 = d;
                    }
                    matrix = new Matrix();
                    matrix.postRotate((float) c5404a3.f18199f);
                    f = (float) d2;
                    matrix.postScale(f, f);
                    attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
                    if (attributeInt == 3) {
                        matrix.postRotate(180.0f);
                    } else if (attributeInt == 6) {
                        matrix.postRotate(90.0f);
                    } else if (attributeInt == 8) {
                        matrix.postRotate(270.0f);
                    }
                    createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
                    if (i3 == 13001) {
                        i6 = 1;
                    }
                    a = C5418b.m22992a(context, readableMap, i6 ^ true);
                    if (a != null) {
                        if (decodeFile != null) {
                            decodeFile.recycle();
                        }
                        if (createBitmap != null) {
                            createBitmap.recycle();
                        }
                        return c5404a4;
                    }
                    c5404a4 = c5404a3.m22979b(a);
                    fileOutputStream = new FileOutputStream(c5404a4.f18195b);
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.close();
                    if (decodeFile != null) {
                        decodeFile.recycle();
                    }
                    if (createBitmap != null) {
                        createBitmap.recycle();
                    }
                    return c5404a4;
                }
                c5404a2 = c5404a2.m22978b(i5);
                c5404a3 = c5404a2;
                d = ((double) c5404a3.f18196c) / ((double) i4);
                d2 = ((double) c5404a3.f18197d) / ((double) i5);
                if (d < d2) {
                    d2 = d;
                }
                matrix = new Matrix();
                matrix.postRotate((float) c5404a3.f18199f);
                f = (float) d2;
                matrix.postScale(f, f);
                try {
                    attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
                    if (attributeInt == 3) {
                        matrix.postRotate(180.0f);
                    } else if (attributeInt == 6) {
                        matrix.postRotate(90.0f);
                    } else if (attributeInt == 8) {
                        matrix.postRotate(270.0f);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
                if (i3 == 13001) {
                    i6 = 1;
                }
                a = C5418b.m22992a(context, readableMap, i6 ^ true);
                if (a != null) {
                    c5404a4 = c5404a3.m22979b(a);
                    fileOutputStream = new FileOutputStream(c5404a4.f18195b);
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.close();
                    if (decodeFile != null) {
                        decodeFile.recycle();
                    }
                    if (createBitmap != null) {
                        createBitmap.recycle();
                    }
                    return c5404a4;
                }
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                if (createBitmap != null) {
                    createBitmap.recycle();
                }
                return c5404a4;
            }
        }
        i4 = i;
        i5 = i2;
        while (true) {
            if (c5404a4.f18196c != 0 && i4 <= c5404a4.f18196c * 2) {
                break;
            }
            if (c5404a4.f18197d != 0) {
                if (i5 <= c5404a4.f18197d * 2) {
                    break;
                }
            }
            Context context2 = context;
            ReadableMap readableMap2 = readableMap;
            int i7 = i3;
            options.inSampleSize *= 2;
            i5 /= 2;
            i4 /= 2;
        }
        decodeFile = BitmapFactory.decodeFile(c5404a4.f18194a.getAbsolutePath(), options);
        if (decodeFile == null) {
            return null;
        }
        if (c5404a4.f18196c != 0) {
            if (c5404a4.f18196c > i4) {
                c5404a2 = c5404a4;
                if (c5404a4.f18197d != 0) {
                    if (c5404a4.f18196c > i5) {
                    }
                    c5404a3 = c5404a2;
                    d = ((double) c5404a3.f18196c) / ((double) i4);
                    d2 = ((double) c5404a3.f18197d) / ((double) i5);
                    if (d < d2) {
                        d2 = d;
                    }
                    matrix = new Matrix();
                    matrix.postRotate((float) c5404a3.f18199f);
                    f = (float) d2;
                    matrix.postScale(f, f);
                    attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
                    if (attributeInt == 3) {
                        matrix.postRotate(180.0f);
                    } else if (attributeInt == 6) {
                        matrix.postRotate(90.0f);
                    } else if (attributeInt == 8) {
                        matrix.postRotate(270.0f);
                    }
                    createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
                    if (i3 == 13001) {
                        i6 = 1;
                    }
                    a = C5418b.m22992a(context, readableMap, i6 ^ true);
                    if (a != null) {
                        if (decodeFile != null) {
                            decodeFile.recycle();
                        }
                        if (createBitmap != null) {
                            createBitmap.recycle();
                        }
                        return c5404a4;
                    }
                    c5404a4 = c5404a3.m22979b(a);
                    fileOutputStream = new FileOutputStream(c5404a4.f18195b);
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.close();
                    if (decodeFile != null) {
                        decodeFile.recycle();
                    }
                    if (createBitmap != null) {
                        createBitmap.recycle();
                    }
                    return c5404a4;
                }
                c5404a2 = c5404a2.m22978b(i5);
                c5404a3 = c5404a2;
                d = ((double) c5404a3.f18196c) / ((double) i4);
                d2 = ((double) c5404a3.f18197d) / ((double) i5);
                if (d < d2) {
                    d2 = d;
                }
                matrix = new Matrix();
                matrix.postRotate((float) c5404a3.f18199f);
                f = (float) d2;
                matrix.postScale(f, f);
                attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
                if (attributeInt == 3) {
                    matrix.postRotate(180.0f);
                } else if (attributeInt == 6) {
                    matrix.postRotate(90.0f);
                } else if (attributeInt == 8) {
                    matrix.postRotate(270.0f);
                }
                createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
                if (i3 == 13001) {
                    i6 = 1;
                }
                a = C5418b.m22992a(context, readableMap, i6 ^ true);
                if (a != null) {
                    c5404a4 = c5404a3.m22979b(a);
                    fileOutputStream = new FileOutputStream(c5404a4.f18195b);
                    byteArrayOutputStream.writeTo(fileOutputStream);
                    fileOutputStream.close();
                    if (decodeFile != null) {
                        decodeFile.recycle();
                    }
                    if (createBitmap != null) {
                        createBitmap.recycle();
                    }
                    return c5404a4;
                }
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                if (createBitmap != null) {
                    createBitmap.recycle();
                }
                return c5404a4;
            }
        }
        c5404a2 = c5404a4.m22973a(i4);
        if (c5404a4.f18197d != 0) {
            if (c5404a4.f18196c > i5) {
            }
            c5404a3 = c5404a2;
            d = ((double) c5404a3.f18196c) / ((double) i4);
            d2 = ((double) c5404a3.f18197d) / ((double) i5);
            if (d < d2) {
                d2 = d;
            }
            matrix = new Matrix();
            matrix.postRotate((float) c5404a3.f18199f);
            f = (float) d2;
            matrix.postScale(f, f);
            attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
            if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else if (attributeInt == 8) {
                matrix.postRotate(270.0f);
            }
            createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
            byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
            if (i3 == 13001) {
                i6 = 1;
            }
            a = C5418b.m22992a(context, readableMap, i6 ^ true);
            if (a != null) {
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                if (createBitmap != null) {
                    createBitmap.recycle();
                }
                return c5404a4;
            }
            c5404a4 = c5404a3.m22979b(a);
            fileOutputStream = new FileOutputStream(c5404a4.f18195b);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.close();
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            if (createBitmap != null) {
                createBitmap.recycle();
            }
            return c5404a4;
        }
        c5404a2 = c5404a2.m22978b(i5);
        c5404a3 = c5404a2;
        d = ((double) c5404a3.f18196c) / ((double) i4);
        d2 = ((double) c5404a3.f18197d) / ((double) i5);
        if (d < d2) {
            d2 = d;
        }
        matrix = new Matrix();
        matrix.postRotate((float) c5404a3.f18199f);
        f = (float) d2;
        matrix.postScale(f, f);
        attributeInt = new ExifInterface(c5404a3.f18194a.getAbsolutePath()).getAttributeInt("Orientation", 0);
        if (attributeInt == 3) {
            matrix.postRotate(180.0f);
        } else if (attributeInt == 6) {
            matrix.postRotate(90.0f);
        } else if (attributeInt == 8) {
            matrix.postRotate(270.0f);
        }
        createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.JPEG, c5404a3.f18198e, byteArrayOutputStream);
        if (i3 == 13001) {
            i6 = 1;
        }
        a = C5418b.m22992a(context, readableMap, i6 ^ true);
        if (a != null) {
            c5404a4 = c5404a3.m22979b(a);
            fileOutputStream = new FileOutputStream(c5404a4.f18195b);
            byteArrayOutputStream.writeTo(fileOutputStream);
            fileOutputStream.close();
            if (decodeFile != null) {
                decodeFile.recycle();
            }
            if (createBitmap != null) {
                createBitmap.recycle();
            }
            return c5404a4;
        }
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        if (createBitmap != null) {
            createBitmap.recycle();
        }
        return c5404a4;
    }

    /* renamed from: a */
    public static void m22993a(int i, C5404a c5404a) {
        if (i == ImagePickerModule.REQUEST_LAUNCH_IMAGE_CAPTURE) {
            if (!(c5404a.f18194a == 0 || c5404a.f18194a.exists() == 0)) {
                c5404a.f18194a.delete();
            }
            if (!(c5404a.f18195b == 0 || c5404a.f18195b.exists() == 0)) {
                c5404a.f18195b.delete();
            }
        }
    }

    /* renamed from: a */
    public static void m22994a(Context context, String str) {
        if (context != null) {
            MediaScannerConnection.scanFile(context, new String[]{str}, null, new C54151());
        }
    }

    /* renamed from: a */
    public static com.imagepicker.p252c.C5418b.C5416a m22990a(com.imagepicker.C5426c r7, com.imagepicker.p250a.C5404a r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new android.media.ExifInterface;	 Catch:{ IOException -> 0x0093 }
        r8 = r8.f18194a;	 Catch:{ IOException -> 0x0093 }
        r8 = r8.getAbsolutePath();	 Catch:{ IOException -> 0x0093 }
        r1.<init>(r8);	 Catch:{ IOException -> 0x0093 }
        r8 = 2;	 Catch:{ IOException -> 0x0093 }
        r8 = new float[r8];	 Catch:{ IOException -> 0x0093 }
        r1.getLatLong(r8);	 Catch:{ IOException -> 0x0093 }
        r2 = r8[r0];	 Catch:{ IOException -> 0x0093 }
        r3 = 1;	 Catch:{ IOException -> 0x0093 }
        r8 = r8[r3];	 Catch:{ IOException -> 0x0093 }
        r4 = 0;	 Catch:{ IOException -> 0x0093 }
        r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ IOException -> 0x0093 }
        if (r5 != 0) goto L_0x0020;	 Catch:{ IOException -> 0x0093 }
    L_0x001c:
        r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));	 Catch:{ IOException -> 0x0093 }
        if (r4 == 0) goto L_0x002c;	 Catch:{ IOException -> 0x0093 }
    L_0x0020:
        r4 = "latitude";	 Catch:{ IOException -> 0x0093 }
        r5 = (double) r2;	 Catch:{ IOException -> 0x0093 }
        r7.m23016a(r4, r5);	 Catch:{ IOException -> 0x0093 }
        r2 = "longitude";	 Catch:{ IOException -> 0x0093 }
        r4 = (double) r8;	 Catch:{ IOException -> 0x0093 }
        r7.m23016a(r2, r4);	 Catch:{ IOException -> 0x0093 }
    L_0x002c:
        r8 = "DateTime";	 Catch:{ IOException -> 0x0093 }
        r8 = r1.getAttribute(r8);	 Catch:{ IOException -> 0x0093 }
        r2 = new java.text.SimpleDateFormat;	 Catch:{ IOException -> 0x0093 }
        r4 = "yyyy:MM:dd HH:mm:ss";	 Catch:{ IOException -> 0x0093 }
        r2.<init>(r4);	 Catch:{ IOException -> 0x0093 }
        r4 = new java.text.SimpleDateFormat;	 Catch:{ IOException -> 0x0093 }
        r5 = "yyyy-MM-dd'T'HH:mm:ss";	 Catch:{ IOException -> 0x0093 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x0093 }
        r5 = "UTC";	 Catch:{ IOException -> 0x0093 }
        r5 = java.util.TimeZone.getTimeZone(r5);	 Catch:{ IOException -> 0x0093 }
        r4.setTimeZone(r5);	 Catch:{ IOException -> 0x0093 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0064 }
        r8 = r2.parse(r8);	 Catch:{ Exception -> 0x0064 }
        r8 = r4.format(r8);	 Catch:{ Exception -> 0x0064 }
        r5.<init>(r8);	 Catch:{ Exception -> 0x0064 }
        r8 = "Z";	 Catch:{ Exception -> 0x0064 }
        r5.append(r8);	 Catch:{ Exception -> 0x0064 }
        r8 = r5.toString();	 Catch:{ Exception -> 0x0064 }
        r2 = "timestamp";	 Catch:{ Exception -> 0x0064 }
        r7.m23018a(r2, r8);	 Catch:{ Exception -> 0x0064 }
    L_0x0064:
        r8 = "Orientation";	 Catch:{ IOException -> 0x0093 }
        r8 = r1.getAttributeInt(r8, r3);	 Catch:{ IOException -> 0x0093 }
        r1 = 3;	 Catch:{ IOException -> 0x0093 }
        if (r8 == r1) goto L_0x0080;	 Catch:{ IOException -> 0x0093 }
    L_0x006d:
        r1 = 6;	 Catch:{ IOException -> 0x0093 }
        if (r8 == r1) goto L_0x007a;	 Catch:{ IOException -> 0x0093 }
    L_0x0070:
        r1 = 8;	 Catch:{ IOException -> 0x0093 }
        if (r8 == r1) goto L_0x0075;	 Catch:{ IOException -> 0x0093 }
    L_0x0074:
        goto L_0x0082;	 Catch:{ IOException -> 0x0093 }
    L_0x0075:
        r8 = 270; // 0x10e float:3.78E-43 double:1.334E-321;	 Catch:{ IOException -> 0x0093 }
        r0 = 270; // 0x10e float:3.78E-43 double:1.334E-321;	 Catch:{ IOException -> 0x0093 }
        goto L_0x007e;	 Catch:{ IOException -> 0x0093 }
    L_0x007a:
        r8 = 90;	 Catch:{ IOException -> 0x0093 }
        r0 = 90;	 Catch:{ IOException -> 0x0093 }
    L_0x007e:
        r3 = 0;	 Catch:{ IOException -> 0x0093 }
        goto L_0x0082;	 Catch:{ IOException -> 0x0093 }
    L_0x0080:
        r0 = 180; // 0xb4 float:2.52E-43 double:8.9E-322;	 Catch:{ IOException -> 0x0093 }
    L_0x0082:
        r8 = "originalRotation";	 Catch:{ IOException -> 0x0093 }
        r7.m23017a(r8, r0);	 Catch:{ IOException -> 0x0093 }
        r8 = "isVertical";	 Catch:{ IOException -> 0x0093 }
        r7.m23019a(r8, r3);	 Catch:{ IOException -> 0x0093 }
        r7 = new com.imagepicker.c.b$a;	 Catch:{ IOException -> 0x0093 }
        r8 = 0;	 Catch:{ IOException -> 0x0093 }
        r7.<init>(r0, r8);	 Catch:{ IOException -> 0x0093 }
        goto L_0x009d;
    L_0x0093:
        r7 = move-exception;
        r7.printStackTrace();
        r8 = new com.imagepicker.c.b$a;
        r8.<init>(r0, r7);
        r7 = r8;
    L_0x009d:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.c.b.a(com.imagepicker.c, com.imagepicker.a.a):com.imagepicker.c.b$a");
    }

    /* renamed from: a */
    public static C5417b m22991a(C5404a c5404a) {
        File file = c5404a.f18195b == null ? c5404a.f18194a : c5404a.f18195b;
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath(), file.getName());
        try {
            C5404a b;
            C5418b.m22995a(file, file2);
            if (c5404a.f18195b != null) {
                b = c5404a.m22979b(file2);
            } else {
                b = c5404a.m22975a(file2);
            }
            return new C5417b(b, null);
        } catch (Throwable e) {
            e.printStackTrace();
            return new C5417b(c5404a, e);
        }
    }

    /* renamed from: a */
    private static void m22995a(File file, File file2) {
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            channel = new FileInputStream(file).getChannel();
            try {
                file2 = new FileOutputStream(file2).getChannel();
                try {
                    channel.transferTo(0, channel.size(), file2);
                    file.delete();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (File file3) {
                            file3.printStackTrace();
                            return;
                        }
                    }
                    if (file2 != null) {
                        file2.close();
                    }
                } catch (Throwable th) {
                    file3 = th;
                    fileChannel = file2;
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (File file22) {
                            file22.printStackTrace();
                            throw file3;
                        }
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw file3;
                }
            } catch (Throwable th2) {
                file3 = th2;
                if (channel != null) {
                    channel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw file3;
            }
        } catch (Throwable th3) {
            file3 = th3;
            channel = null;
            if (channel != null) {
                channel.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            throw file3;
        }
    }
}
