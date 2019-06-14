package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class amg implements Comparator<alt> {
    public amg(amf amf) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        alt alt = (alt) obj;
        alt alt2 = (alt) obj2;
        if (alt.m18609b() < alt2.m18609b()) {
            return -1;
        }
        if (alt.m18609b() > alt2.m18609b()) {
            return 1;
        }
        if (alt.m18608a() < alt2.m18608a()) {
            return -1;
        }
        if (alt.m18608a() > alt2.m18608a()) {
            return 1;
        }
        float d = (alt.m18611d() - alt.m18609b()) * (alt.m18610c() - alt.m18608a());
        float d2 = (alt2.m18611d() - alt2.m18609b()) * (alt2.m18610c() - alt2.m18608a());
        return d > d2 ? -1 : d < d2 ? 1 : 0;
    }
}
