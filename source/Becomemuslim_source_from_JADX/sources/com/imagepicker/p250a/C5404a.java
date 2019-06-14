package com.imagepicker.p250a;

import android.webkit.MimeTypeMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import java.io.File;

/* compiled from: ImageConfig */
/* renamed from: com.imagepicker.a.a */
public class C5404a {
    /* renamed from: a */
    public final File f18194a;
    /* renamed from: b */
    public final File f18195b;
    /* renamed from: c */
    public final int f18196c;
    /* renamed from: d */
    public final int f18197d;
    /* renamed from: e */
    public final int f18198e;
    /* renamed from: f */
    public final int f18199f;
    /* renamed from: g */
    public final boolean f18200g;

    public C5404a(File file, File file2, int i, int i2, int i3, int i4, boolean z) {
        this.f18194a = file;
        this.f18195b = file2;
        this.f18196c = i;
        this.f18197d = i2;
        this.f18198e = i3;
        this.f18199f = i4;
        this.f18200g = z;
    }

    /* renamed from: a */
    public C5404a m22973a(int i) {
        return new C5404a(this.f18194a, this.f18195b, i, this.f18197d, this.f18198e, this.f18199f, this.f18200g);
    }

    /* renamed from: b */
    public C5404a m22978b(int i) {
        return new C5404a(this.f18194a, this.f18195b, this.f18196c, i, this.f18198e, this.f18199f, this.f18200g);
    }

    /* renamed from: a */
    public C5404a m22975a(File file) {
        if (file != null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath());
            int i = this.f18198e;
            boolean contains = fileExtensionFromUrl.contains("gif");
        }
        return new C5404a(file, this.f18195b, this.f18196c, this.f18197d, this.f18198e, this.f18199f, this.f18200g);
    }

    /* renamed from: b */
    public C5404a m22979b(File file) {
        return new C5404a(this.f18194a, file, this.f18196c, this.f18197d, this.f18198e, this.f18199f, this.f18200g);
    }

    /* renamed from: a */
    public C5404a m22974a(ReadableMap readableMap) {
        boolean z;
        int i = readableMap.hasKey(ViewProps.MAX_WIDTH) ? (int) readableMap.getDouble(ViewProps.MAX_WIDTH) : 0;
        int i2 = readableMap.hasKey(ViewProps.MAX_HEIGHT) ? (int) readableMap.getDouble(ViewProps.MAX_HEIGHT) : 0;
        int i3 = readableMap.hasKey("quality") ? (int) (readableMap.getDouble("quality") * 100.0d) : 100;
        int i4 = readableMap.hasKey("rotation") ? (int) readableMap.getDouble("rotation") : 0;
        if (readableMap.hasKey("storageOptions")) {
            readableMap = readableMap.getMap("storageOptions");
            if (readableMap.hasKey("cameraRoll")) {
                z = readableMap.getBoolean("cameraRoll");
                return new C5404a(this.f18194a, this.f18195b, i, i2, i3, i4, z);
            }
        }
        z = false;
        return new C5404a(this.f18194a, this.f18195b, i, i2, i3, i4, z);
    }

    /* renamed from: a */
    public boolean m22977a(int i, int i2, int i3) {
        return ((i < this.f18196c && this.f18196c > 0) || this.f18196c == 0) && (((i2 < this.f18197d && this.f18197d > 0) || this.f18197d == 0) && this.f18198e == 100 && (this.f18199f == 0 || i3 == this.f18199f));
    }

    /* renamed from: a */
    public File m22976a() {
        return this.f18195b != null ? this.f18195b : this.f18194a;
    }
}
