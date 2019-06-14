package com.facebook.ads.internal.view.component;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.support.v4.p020a.C0264a;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.ads.internal.adapters.p086a.C1312d;
import com.facebook.ads.internal.adapters.p086a.C1313e;
import com.facebook.ads.internal.p085a.C1297b;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1520t;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p111r.C1545a;
import com.facebook.ads.internal.view.C1566a.C1551a;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.view.component.a */
public class C1599a extends Button {
    /* renamed from: a */
    public static final int f4786a = ((int) (C1523w.f4503b * 16.0f));
    /* renamed from: b */
    private static final int f4787b = ((int) (C1523w.f4503b * 4.0f));
    /* renamed from: c */
    private final Paint f4788c = new Paint();
    /* renamed from: d */
    private final RectF f4789d;
    /* renamed from: e */
    private final boolean f4790e;
    /* renamed from: f */
    private final String f4791f;
    /* renamed from: g */
    private final C1545a f4792g;
    /* renamed from: h */
    private final C1520t f4793h;
    /* renamed from: i */
    private final C1412c f4794i;
    /* renamed from: j */
    private final C1551a f4795j;

    public C1599a(Context context, boolean z, boolean z2, String str, C1312d c1312d, C1412c c1412c, C1551a c1551a, C1545a c1545a, C1520t c1520t) {
        super(context);
        this.f4794i = c1412c;
        this.f4795j = c1551a;
        this.f4790e = z;
        this.f4791f = str;
        this.f4792g = c1545a;
        this.f4793h = c1520t;
        C1523w.m5344a(this, false, 16);
        setGravity(17);
        setPadding(f4786a, f4786a, f4786a, f4786a);
        setTextColor(c1312d.m4511f(z2));
        int e = c1312d.m4510e(z2);
        int a = C0264a.m715a(e, -16777216, 0.1f);
        this.f4788c.setStyle(Style.FILL);
        this.f4788c.setColor(e);
        this.f4789d = new RectF();
        if (!z) {
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(a));
            stateListDrawable.addState(new int[0], new ColorDrawable(e));
            C1523w.m5343a((View) this, stateListDrawable);
        }
    }

    /* renamed from: a */
    public void m5582a(C1313e c1313e, String str, Map<String, String> map) {
        m5583a(c1313e.m4515b(), c1313e.m4514a(), str, map);
    }

    /* renamed from: a */
    public void m5583a(String str, final String str2, final String str3, final Map<String, String> map) {
        if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
            if (this.f4794i != null) {
                setText(str.toUpperCase(Locale.US));
                setOnClickListener(new OnClickListener(this) {
                    /* renamed from: d */
                    final /* synthetic */ C1599a f4754d;

                    public void onClick(View view) {
                        Throwable e;
                        String valueOf;
                        String stringBuilder;
                        try {
                            Uri parse = Uri.parse(str2);
                            this.f4754d.f4792g.m5433a(map);
                            map.put("touch", C1508k.m5306a(this.f4754d.f4793h.m5335e()));
                            C1297b a = C1298c.m4444a(this.f4754d.getContext(), this.f4754d.f4794i, str3, parse, map);
                            if (a != null) {
                                a.mo917b();
                            }
                            if (this.f4754d.f4795j != null) {
                                this.f4754d.f4795j.mo854a(this.f4754d.f4791f);
                            }
                        } catch (ActivityNotFoundException e2) {
                            e = e2;
                            valueOf = String.valueOf(C1599a.class);
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Error while opening ");
                            stringBuilder2.append(str2);
                            stringBuilder = stringBuilder2.toString();
                            Log.e(valueOf, stringBuilder, e);
                        } catch (Exception e3) {
                            e = e3;
                            valueOf = String.valueOf(C1599a.class);
                            stringBuilder = "Error executing action";
                            Log.e(valueOf, stringBuilder, e);
                        }
                    }
                });
                return;
            }
        }
        setVisibility(8);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f4790e) {
            this.f4789d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            canvas.drawRoundRect(this.f4789d, (float) f4787b, (float) f4787b, this.f4788c);
        }
        super.onDraw(canvas);
    }
}
