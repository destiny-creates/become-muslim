package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.util.C2904o;
import java.io.InputStream;

final class bf implements lm<att> {
    /* renamed from: a */
    private final /* synthetic */ boolean f23975a;
    /* renamed from: b */
    private final /* synthetic */ double f23976b;
    /* renamed from: c */
    private final /* synthetic */ boolean f23977c;
    /* renamed from: d */
    private final /* synthetic */ String f23978d;
    /* renamed from: e */
    private final /* synthetic */ ay f23979e;

    bf(ay ayVar, boolean z, double d, boolean z2, String str) {
        this.f23979e = ayVar;
        this.f23975a = z;
        this.f23976b = d;
        this.f23977c = z2;
        this.f23978d = str;
    }

    @TargetApi(19)
    /* renamed from: b */
    private final att m30632b(InputStream inputStream) {
        Bitmap decodeStream;
        Options options = new Options();
        options.inDensity = (int) (this.f23976b * 160.0d);
        if (!this.f23977c) {
            options.inPreferredConfig = Config.RGB_565;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        } catch (Throwable e) {
            mt.m19919b("Error grabbing image.", e);
            decodeStream = null;
        }
        if (decodeStream == null) {
            this.f23979e.m19126a(2, this.f23975a);
            return null;
        }
        long uptimeMillis2 = SystemClock.uptimeMillis();
        if (C2904o.g() && jn.m30865a()) {
            int width = decodeStream.getWidth();
            int height = decodeStream.getHeight();
            int allocationByteCount = decodeStream.getAllocationByteCount();
            uptimeMillis2 -= uptimeMillis;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder stringBuilder = new StringBuilder(108);
            stringBuilder.append("Decoded image w: ");
            stringBuilder.append(width);
            stringBuilder.append(" h:");
            stringBuilder.append(height);
            stringBuilder.append(" bytes: ");
            stringBuilder.append(allocationByteCount);
            stringBuilder.append(" time: ");
            stringBuilder.append(uptimeMillis2);
            stringBuilder.append(" on ui thread: ");
            stringBuilder.append(z);
            jn.m30864a(stringBuilder.toString());
        }
        return new att(new BitmapDrawable(Resources.getSystem(), decodeStream), Uri.parse(this.f23978d), this.f23976b);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo4217a() {
        this.f23979e.m19126a(2, this.f23975a);
        return null;
    }

    @TargetApi(19)
    /* renamed from: a */
    public final /* synthetic */ Object mo4218a(InputStream inputStream) {
        return m30632b(inputStream);
    }
}
