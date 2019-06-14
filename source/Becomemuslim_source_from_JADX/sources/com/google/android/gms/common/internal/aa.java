package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.p020a.p021a.C0259a;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.common.util.C2898i;
import com.google.android.gms.p166a.C2594a.C2590a;
import com.google.android.gms.p166a.C2594a.C2591b;
import com.google.android.gms.p166a.C2594a.C2592c;

public final class aa extends Button {
    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    /* renamed from: a */
    public final void m8215a(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        i3 = m8214a(i2, C2591b.common_google_signin_btn_icon_dark, C2591b.common_google_signin_btn_icon_light, C2591b.common_google_signin_btn_icon_light);
        int a = m8214a(i2, C2591b.common_google_signin_btn_text_dark, C2591b.common_google_signin_btn_text_light, C2591b.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                i3 = a;
                break;
            case 2:
                break;
            default:
                i2 = new StringBuilder(32);
                i2.append("Unknown button size: ");
                i2.append(i);
                throw new IllegalStateException(i2.toString());
        }
        Drawable g = C0259a.m703g(resources.getDrawable(i3));
        C0259a.m692a(g, resources.getColorStateList(C2590a.common_google_signin_btn_tint));
        C0259a.m695a(g, Mode.SRC_ATOP);
        setBackgroundDrawable(g);
        setTextColor((ColorStateList) C2872v.m8380a(resources.getColorStateList(m8214a(i2, C2590a.common_google_signin_btn_text_dark, C2590a.common_google_signin_btn_text_light, C2590a.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C2592c.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C2592c.common_signin_button_text_long));
                break;
            case 2:
                setText(null);
                break;
            default:
                i2 = new StringBuilder(32);
                i2.append("Unknown button size: ");
                i2.append(i);
                throw new IllegalStateException(i2.toString());
        }
        setTransformationMethod(null);
        if (C2898i.m8442a(getContext()) != null) {
            setGravity(19);
        }
    }

    /* renamed from: a */
    private static int m8214a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                i4 = new StringBuilder(33);
                i4.append("Unknown color scheme: ");
                i4.append(i);
                throw new IllegalStateException(i4.toString());
        }
    }
}
