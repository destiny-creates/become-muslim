package com.google.android.gms.ads.p168b;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.mt;

/* renamed from: com.google.android.gms.ads.b.j */
public final class C4262j extends C2612e {
    public C4262j(Context context) {
        super(context);
    }

    public final View getAdvertiserView() {
        return super.m7373a("1004");
    }

    public final View getBodyView() {
        return super.m7373a("1002");
    }

    public final View getCallToActionView() {
        return super.m7373a("1003");
    }

    public final View getHeadlineView() {
        return super.m7373a("1001");
    }

    public final View getImageView() {
        return super.m7373a("1005");
    }

    public final View getLogoView() {
        return super.m7373a("1006");
    }

    public final C2606b getMediaView() {
        View a = super.m7373a("1009");
        if (a instanceof C2606b) {
            return (C2606b) a;
        }
        if (a != null) {
            mt.b("View is not an instance of MediaView");
        }
        return null;
    }

    public final void setAdvertiserView(View view) {
        super.m7374a("1004", view);
    }

    public final void setBodyView(View view) {
        super.m7374a("1002", view);
    }

    public final void setCallToActionView(View view) {
        super.m7374a("1003", view);
    }

    public final void setHeadlineView(View view) {
        super.m7374a("1001", view);
    }

    public final void setImageView(View view) {
        super.m7374a("1005", view);
    }

    public final void setLogoView(View view) {
        super.m7374a("1006", view);
    }

    public final void setMediaView(C2606b c2606b) {
        super.m7374a("1009", c2606b);
    }
}
