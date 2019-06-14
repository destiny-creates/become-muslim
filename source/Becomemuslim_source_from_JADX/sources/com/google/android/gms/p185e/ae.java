package com.google.android.gms.p185e;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

/* renamed from: com.google.android.gms.e.ae */
final class ae implements bj {
    /* renamed from: a */
    private final /* synthetic */ C2938e f11602a;

    ae(C2938e c2938e) {
        this.f11602a = c2938e;
    }

    /* renamed from: a */
    public final Info mo2496a() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.f11602a.f7556g);
        } catch (Throwable e) {
            bs.m8585b("IllegalStateException getting Advertising Id Info", e);
            return null;
        } catch (Throwable e2) {
            bs.m8585b("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            return null;
        } catch (Throwable e22) {
            bs.m8585b("IOException getting Ad Id Info", e22);
            return null;
        } catch (Throwable e222) {
            this.f11602a.m8699c();
            bs.m8585b("GooglePlayServicesNotAvailableException getting Advertising Id Info", e222);
            return null;
        } catch (Throwable e2222) {
            bs.m8585b("Unknown exception. Could not get the Advertising Id Info.", e2222);
            return null;
        }
    }
}
