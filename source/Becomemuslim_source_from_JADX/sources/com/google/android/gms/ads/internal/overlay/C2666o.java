package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.mi;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.o */
public final class C2666o extends FrameLayout implements OnClickListener {
    /* renamed from: a */
    private final ImageButton f6910a;
    /* renamed from: b */
    private final C2671w f6911b;

    public C2666o(Context context, C2667p c2667p, C2671w c2671w) {
        super(context);
        this.f6911b = c2671w;
        setOnClickListener(this);
        this.f6910a = new ImageButton(context);
        this.f6910a.setImageResource(17301527);
        this.f6910a.setBackgroundColor(0);
        this.f6910a.setOnClickListener(this);
        ImageButton imageButton = this.f6910a;
        aph.a();
        int a = mi.a(context, c2667p.f6912a);
        aph.a();
        int a2 = mi.a(context, 0);
        aph.a();
        int a3 = mi.a(context, c2667p.f6913b);
        aph.a();
        imageButton.setPadding(a, a2, a3, mi.a(context, c2667p.f6915d));
        this.f6910a.setContentDescription("Interstitial close button");
        aph.a();
        mi.a(context, c2667p.f6916e);
        View view = this.f6910a;
        aph.a();
        a = mi.a(context, (c2667p.f6916e + c2667p.f6912a) + c2667p.f6913b);
        aph.a();
        addView(view, new LayoutParams(a, mi.a(context, c2667p.f6916e + c2667p.f6915d), 17));
    }

    /* renamed from: a */
    public final void m7546a(boolean z) {
        ImageButton imageButton;
        int i;
        if (z) {
            imageButton = this.f6910a;
            i = 8;
        } else {
            imageButton = this.f6910a;
            i = 0;
        }
        imageButton.setVisibility(i);
    }

    public final void onClick(View view) {
        if (this.f6911b != null) {
            this.f6911b.mo3254c();
        }
    }
}
