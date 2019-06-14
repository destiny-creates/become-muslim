package com.google.android.gms.ads.p168b;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.mt;

/* renamed from: com.google.android.gms.ads.b.h */
public final class C4260h extends C2612e {
    public C4260h(Context context) {
        super(context);
    }

    public final View getBodyView() {
        return super.m7373a("2004");
    }

    public final View getCallToActionView() {
        return super.m7373a("2002");
    }

    public final View getHeadlineView() {
        return super.m7373a("2001");
    }

    public final View getIconView() {
        return super.m7373a("2003");
    }

    public final View getImageView() {
        return super.m7373a("2007");
    }

    public final C2606b getMediaView() {
        View a = super.m7373a("2011");
        if (a instanceof C2606b) {
            return (C2606b) a;
        }
        if (a != null) {
            mt.b("View is not an instance of MediaView");
        }
        return null;
    }

    public final View getPriceView() {
        return super.m7373a("2006");
    }

    public final View getStarRatingView() {
        return super.m7373a("2008");
    }

    public final View getStoreView() {
        return super.m7373a("2005");
    }

    public final void setBodyView(View view) {
        super.m7374a("2004", view);
    }

    public final void setCallToActionView(View view) {
        super.m7374a("2002", view);
    }

    public final void setHeadlineView(View view) {
        super.m7374a("2001", view);
    }

    public final void setIconView(View view) {
        super.m7374a("2003", view);
    }

    public final void setImageView(View view) {
        super.m7374a("2007", view);
    }

    public final void setMediaView(C2606b c2606b) {
        super.m7374a("2011", c2606b);
    }

    public final void setPriceView(View view) {
        super.m7374a("2006", view);
    }

    public final void setStarRatingView(View view) {
        super.m7374a("2008", view);
    }

    public final void setStoreView(View view) {
        super.m7374a("2005", view);
    }
}
