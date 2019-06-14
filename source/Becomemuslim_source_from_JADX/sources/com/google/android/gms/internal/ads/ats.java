package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p174b.C4757d;
import java.util.List;

@cm
public final class ats extends RelativeLayout {
    /* renamed from: a */
    private static final float[] f14998a = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    /* renamed from: b */
    private AnimationDrawable f14999b;

    public ats(Context context, atp atp, LayoutParams layoutParams) {
        View textView;
        super(context);
        C2872v.a(atp);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(f14998a, null, null));
        shapeDrawable.getPaint().setColor(atp.m37021d());
        setLayoutParams(layoutParams);
        ax.g().mo6843a((View) this, shapeDrawable);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(atp.mo3994a())) {
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-2, -2);
            textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(atp.mo3994a());
            textView.setTextColor(atp.m37022e());
            textView.setTextSize((float) atp.m37023f());
            aph.m18683a();
            int a = mi.m19864a(context, 4);
            aph.m18683a();
            textView.setPadding(a, 0, mi.m19864a(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        textView = new ImageView(context);
        textView.setLayoutParams(layoutParams2);
        textView.setId(1195835394);
        List<att> c = atp.m37020c();
        if (c != null && c.size() > 1) {
            this.f14999b = new AnimationDrawable();
            for (att a2 : c) {
                try {
                    this.f14999b.addFrame((Drawable) C4757d.a(a2.mo3996a()), atp.m37024g());
                } catch (Throwable e) {
                    mt.m19919b("Error while getting drawable.", e);
                }
            }
            ax.g().mo6843a(textView, this.f14999b);
        } else if (c.size() == 1) {
            try {
                textView.setImageDrawable((Drawable) C4757d.a(((att) c.get(0)).mo3996a()));
            } catch (Throwable e2) {
                mt.m19919b("Error while getting drawable.", e2);
            }
        }
        addView(textView);
    }

    public final void onAttachedToWindow() {
        if (this.f14999b != null) {
            this.f14999b.start();
        }
        super.onAttachedToWindow();
    }
}
