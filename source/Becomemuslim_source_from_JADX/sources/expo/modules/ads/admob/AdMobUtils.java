package expo.modules.ads.admob;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.C2631d;

class AdMobUtils {
    static String errorStringForAdFailedCode(int i) {
        switch (i) {
            case 0:
                return "ERROR_CODE_INTERNAL_ERROR";
            case 1:
                return "ERROR_CODE_INVALID_REQUEST";
            case 2:
                return "ERROR_CODE_NETWORK_ERROR";
            case 3:
                return "ERROR_CODE_NO_FILL";
            default:
                return null;
        }
    }

    AdMobUtils() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.ads.C2631d getAdSizeFromString(java.lang.String r1) {
        /*
        r0 = r1.hashCode();
        switch(r0) {
            case -2023649721: goto L_0x004e;
            case -1735624867: goto L_0x0044;
            case -1396342996: goto L_0x003a;
            case -1294719333: goto L_0x0030;
            case -994916779: goto L_0x0026;
            case 438737894: goto L_0x001c;
            case 1251459344: goto L_0x0012;
            case 2081083770: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0058;
    L_0x0008:
        r0 = "mediumRectangle";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0010:
        r1 = 2;
        goto L_0x0059;
    L_0x0012:
        r0 = "smartBannerPortrait";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x001a:
        r1 = 5;
        goto L_0x0059;
    L_0x001c:
        r0 = "smartBannerLandscape";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0024:
        r1 = 6;
        goto L_0x0059;
    L_0x0026:
        r0 = "smartBanner";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x002e:
        r1 = 7;
        goto L_0x0059;
    L_0x0030:
        r0 = "fullBanner";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0038:
        r1 = 3;
        goto L_0x0059;
    L_0x003a:
        r0 = "banner";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0042:
        r1 = 0;
        goto L_0x0059;
    L_0x0044:
        r0 = "leaderBoard";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x004c:
        r1 = 4;
        goto L_0x0059;
    L_0x004e:
        r0 = "largeBanner";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0056:
        r1 = 1;
        goto L_0x0059;
    L_0x0058:
        r1 = -1;
    L_0x0059:
        switch(r1) {
            case 0: goto L_0x0074;
            case 1: goto L_0x0071;
            case 2: goto L_0x006e;
            case 3: goto L_0x006b;
            case 4: goto L_0x0068;
            case 5: goto L_0x0065;
            case 6: goto L_0x0062;
            case 7: goto L_0x005f;
            default: goto L_0x005c;
        };
    L_0x005c:
        r1 = com.google.android.gms.ads.C2631d.f6669a;
        return r1;
    L_0x005f:
        r1 = com.google.android.gms.ads.C2631d.f6675g;
        return r1;
    L_0x0062:
        r1 = com.google.android.gms.ads.C2631d.f6675g;
        return r1;
    L_0x0065:
        r1 = com.google.android.gms.ads.C2631d.f6675g;
        return r1;
    L_0x0068:
        r1 = com.google.android.gms.ads.C2631d.f6672d;
        return r1;
    L_0x006b:
        r1 = com.google.android.gms.ads.C2631d.f6670b;
        return r1;
    L_0x006e:
        r1 = com.google.android.gms.ads.C2631d.f6673e;
        return r1;
    L_0x0071:
        r1 = com.google.android.gms.ads.C2631d.f6671c;
        return r1;
    L_0x0074:
        r1 = com.google.android.gms.ads.C2631d.f6669a;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.ads.admob.AdMobUtils.getAdSizeFromString(java.lang.String):com.google.android.gms.ads.d");
    }

    static Bundle createEventForAdFailedToLoad(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("error", errorStringForAdFailedCode(i));
        return bundle;
    }

    static Bundle createEventForSizeChange(Context context, C2631d c2631d) {
        int toDIPFromPixel;
        Bundle bundle = new Bundle();
        if (c2631d == C2631d.f6675g) {
            toDIPFromPixel = toDIPFromPixel(context, c2631d.b(context));
            context = toDIPFromPixel(context, c2631d.a(context));
        } else {
            toDIPFromPixel = c2631d.b();
            context = c2631d.a();
        }
        bundle.putDouble("width", (double) toDIPFromPixel);
        bundle.putDouble("height", (double) context);
        return bundle;
    }

    static int toDIPFromPixel(Context context, int i) {
        return (int) (((float) i) / context.getResources().getDisplayMetrics().density);
    }
}
