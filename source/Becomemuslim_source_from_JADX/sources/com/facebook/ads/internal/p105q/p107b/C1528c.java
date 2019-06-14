package com.facebook.ads.internal.p105q.p107b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.facebook.ads.internal.q.b.c */
public class C1528c {
    /* renamed from: a */
    private static int m5353a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i3 /= 2;
            i4 /= 2;
            while (i3 / i5 >= i2 && i4 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* renamed from: a */
    public static Bitmap m5354a(C1527b c1527b) {
        byte[] decode = Base64.decode(c1527b.m5352a(C1523w.f4503b), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    /* renamed from: a */
    public static Bitmap m5355a(InputStream inputStream, int i, int i2) {
        InputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bufferedInputStream, null, options);
        try {
            bufferedInputStream.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
        options.inSampleSize = C1528c.m5353a(options, i2, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(bufferedInputStream, null, options);
    }

    /* renamed from: a */
    public static Bitmap m5356a(String str, int i, int i2) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = C1528c.m5353a(options, i2, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    /* renamed from: a */
    public static Drawable m5357a(Context context, C1527b c1527b) {
        return new BitmapDrawable(context.getResources(), C1528c.m5354a(c1527b));
    }
}
