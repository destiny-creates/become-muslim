package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.ax;
import java.util.concurrent.TimeUnit;

@cm
public final class po {
    /* renamed from: a */
    private final Context f15902a;
    /* renamed from: b */
    private final String f15903b;
    /* renamed from: c */
    private final mv f15904c;
    /* renamed from: d */
    private final ata f15905d;
    /* renamed from: e */
    private final atc f15906e;
    /* renamed from: f */
    private final lc f15907f = new lf().m19829a("min_1", Double.MIN_VALUE, 1.0d).m19829a("1_5", 1.0d, 5.0d).m19829a("5_10", 5.0d, 10.0d).m19829a("10_20", 10.0d, 20.0d).m19829a("20_30", 20.0d, 30.0d).m19829a("30_max", 30.0d, Double.MAX_VALUE).m19828a();
    /* renamed from: g */
    private final long[] f15908g;
    /* renamed from: h */
    private final String[] f15909h;
    /* renamed from: i */
    private boolean f15910i = false;
    /* renamed from: j */
    private boolean f15911j = false;
    /* renamed from: k */
    private boolean f15912k = false;
    /* renamed from: l */
    private boolean f15913l = false;
    /* renamed from: m */
    private boolean f15914m;
    /* renamed from: n */
    private ox f15915n;
    /* renamed from: o */
    private boolean f15916o;
    /* renamed from: p */
    private boolean f15917p;
    /* renamed from: q */
    private long f15918q = -1;

    public po(Context context, mv mvVar, String str, atc atc, ata ata) {
        this.f15902a = context;
        this.f15904c = mvVar;
        this.f15903b = str;
        this.f15906e = atc;
        this.f15905d = ata;
        String str2 = (String) aph.m18688f().m18889a(asp.f14957u);
        if (str2 == null) {
            r1.f15909h = new String[0];
            r1.f15908g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        r1.f15909h = new String[split.length];
        r1.f15908g = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                r1.f15908g[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                mt.m19921c("Unable to parse frame hash target time number.", e);
                r1.f15908g[i] = -1;
            }
        }
    }

    /* renamed from: a */
    public final void m20009a() {
        if (!this.f15910i) {
            return;
        }
        if (!this.f15911j) {
            asv.m18908a(this.f15906e, this.f15905d, "vfr2");
            this.f15911j = true;
        }
    }

    /* renamed from: a */
    public final void m20010a(ox oxVar) {
        asv.m18908a(this.f15906e, this.f15905d, "vpc2");
        this.f15910i = true;
        if (this.f15906e != null) {
            this.f15906e.m18920a("vpn", oxVar.mo6112a());
        }
        this.f15915n = oxVar;
    }

    /* renamed from: b */
    public final void m20011b() {
        if (((Boolean) aph.m18688f().m18889a(asp.f14956t)).booleanValue() && !this.f15916o) {
            String valueOf;
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.f15903b);
            bundle.putString("player", this.f15915n.mo6112a());
            for (le leVar : this.f15907f.m19823a()) {
                valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(leVar.f15753a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(leVar.f15755c));
                valueOf = String.valueOf("fps_p_");
                valueOf2 = String.valueOf(leVar.f15753a);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Double.toString(leVar.f15754b));
            }
            for (int i = 0; i < this.f15908g.length; i++) {
                String str = this.f15909h[i];
                if (str != null) {
                    valueOf = String.valueOf(Long.valueOf(this.f15908g[i]));
                    StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 3);
                    stringBuilder.append("fh_");
                    stringBuilder.append(valueOf);
                    bundle.putString(stringBuilder.toString(), str);
                }
            }
            ax.e().m19739a(this.f15902a, this.f15904c.f28709a, "gmob-apps", bundle, true);
            this.f15916o = true;
        }
    }

    /* renamed from: b */
    public final void m20012b(ox oxVar) {
        if (this.f15912k && !r0.f15913l) {
            if (jn.m30865a() && !r0.f15913l) {
                jn.m30864a("VideoMetricsMixin first frame");
            }
            asv.m18908a(r0.f15906e, r0.f15905d, "vff2");
            r0.f15913l = true;
        }
        long c = ax.l().c();
        if (r0.f15914m && r0.f15917p && r0.f15918q != -1) {
            r0.f15907f.m19824a(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (c - r0.f15918q)));
        }
        r0.f15917p = r0.f15914m;
        r0.f15918q = c;
        c = ((Long) aph.m18688f().m18889a(asp.f14958v)).longValue();
        long currentPosition = (long) oxVar.getCurrentPosition();
        int i = 0;
        while (i < r0.f15909h.length) {
            if (r0.f15909h[i] != null || c <= Math.abs(currentPosition - r0.f15908g[i])) {
                ox oxVar2 = oxVar;
                i++;
            } else {
                String[] strArr = r0.f15909h;
                int i2 = 8;
                Bitmap bitmap = oxVar.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    j = j2;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j2 = j;
                    i2 = 8;
                    j = j3;
                }
                strArr[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    /* renamed from: c */
    public final void m20013c() {
        this.f15914m = true;
        if (this.f15911j && !this.f15912k) {
            asv.m18908a(this.f15906e, this.f15905d, "vfp2");
            this.f15912k = true;
        }
    }

    /* renamed from: d */
    public final void m20014d() {
        this.f15914m = false;
    }
}
