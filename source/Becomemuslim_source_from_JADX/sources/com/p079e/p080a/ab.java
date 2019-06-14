package com.p079e.p080a;

import java.io.PrintWriter;

/* compiled from: StatsSnapshot */
/* renamed from: com.e.a.ab */
public class ab {
    /* renamed from: a */
    public final int f3377a;
    /* renamed from: b */
    public final int f3378b;
    /* renamed from: c */
    public final long f3379c;
    /* renamed from: d */
    public final long f3380d;
    /* renamed from: e */
    public final long f3381e;
    /* renamed from: f */
    public final long f3382f;
    /* renamed from: g */
    public final long f3383g;
    /* renamed from: h */
    public final long f3384h;
    /* renamed from: i */
    public final long f3385i;
    /* renamed from: j */
    public final long f3386j;
    /* renamed from: k */
    public final int f3387k;
    /* renamed from: l */
    public final int f3388l;
    /* renamed from: m */
    public final int f3389m;
    /* renamed from: n */
    public final long f3390n;

    public ab(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.f3377a = i;
        this.f3378b = i2;
        this.f3379c = j;
        this.f3380d = j2;
        this.f3381e = j3;
        this.f3382f = j4;
        this.f3383g = j5;
        this.f3384h = j6;
        this.f3385i = j7;
        this.f3386j = j8;
        this.f3387k = i3;
        this.f3388l = i4;
        this.f3389m = i5;
        this.f3390n = j9;
    }

    /* renamed from: a */
    public void m4198a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f3377a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f3378b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f3378b) / ((float) this.f3377a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f3379c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f3380d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f3387k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f3381e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f3384h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f3388l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f3382f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f3389m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f3383g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f3385i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f3386j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StatsSnapshot{maxSize=");
        stringBuilder.append(this.f3377a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.f3378b);
        stringBuilder.append(", cacheHits=");
        stringBuilder.append(this.f3379c);
        stringBuilder.append(", cacheMisses=");
        stringBuilder.append(this.f3380d);
        stringBuilder.append(", downloadCount=");
        stringBuilder.append(this.f3387k);
        stringBuilder.append(", totalDownloadSize=");
        stringBuilder.append(this.f3381e);
        stringBuilder.append(", averageDownloadSize=");
        stringBuilder.append(this.f3384h);
        stringBuilder.append(", totalOriginalBitmapSize=");
        stringBuilder.append(this.f3382f);
        stringBuilder.append(", totalTransformedBitmapSize=");
        stringBuilder.append(this.f3383g);
        stringBuilder.append(", averageOriginalBitmapSize=");
        stringBuilder.append(this.f3385i);
        stringBuilder.append(", averageTransformedBitmapSize=");
        stringBuilder.append(this.f3386j);
        stringBuilder.append(", originalBitmapCount=");
        stringBuilder.append(this.f3388l);
        stringBuilder.append(", transformedBitmapCount=");
        stringBuilder.append(this.f3389m);
        stringBuilder.append(", timeStamp=");
        stringBuilder.append(this.f3390n);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
