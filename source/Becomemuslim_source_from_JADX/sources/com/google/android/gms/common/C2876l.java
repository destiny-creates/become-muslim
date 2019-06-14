package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.p166a.C2594a.C2593d;

/* renamed from: com.google.android.gms.common.l */
public final class C2876l extends FrameLayout implements OnClickListener {
    /* renamed from: a */
    private int f7338a;
    /* renamed from: b */
    private int f7339b;
    /* renamed from: c */
    private View f7340c;
    /* renamed from: d */
    private OnClickListener f7341d;

    public C2876l(Context context) {
        this(context, null);
    }

    public C2876l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C2876l(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7341d = 0;
        context = context.getTheme().obtainStyledAttributes(attributeSet, C2593d.SignInButton, 0, 0);
        try {
            this.f7338a = context.getInt(C2593d.SignInButton_buttonSize, 0);
            this.f7339b = context.getInt(C2593d.SignInButton_colorScheme, 2);
            m8401a(this.f7338a, this.f7339b);
        } finally {
            context.recycle();
        }
    }

    public final void setSize(int i) {
        m8401a(i, this.f7339b);
    }

    public final void setColorScheme(int i) {
        m8401a(this.f7338a, i);
    }

    @Deprecated
    public final void setScopes(Scope[] scopeArr) {
        m8401a(this.f7338a, this.f7339b);
    }

    /* renamed from: a */
    public final void m8401a(int r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        r2.f7338a = r3;
        r2.f7339b = r4;
        r3 = r2.getContext();
        r4 = r2.f7340c;
        if (r4 == 0) goto L_0x0011;
    L_0x000c:
        r4 = r2.f7340c;
        r2.removeView(r4);
    L_0x0011:
        r4 = r2.f7338a;	 Catch:{ a -> 0x001c }
        r0 = r2.f7339b;	 Catch:{ a -> 0x001c }
        r4 = com.google.android.gms.common.internal.C4375z.m14393a(r3, r4, r0);	 Catch:{ a -> 0x001c }
        r2.f7340c = r4;	 Catch:{ a -> 0x001c }
        goto L_0x0035;
    L_0x001c:
        r4 = "SignInButton";
        r0 = "Sign in button not found, using placeholder instead";
        android.util.Log.w(r4, r0);
        r4 = r2.f7338a;
        r0 = r2.f7339b;
        r1 = new com.google.android.gms.common.internal.aa;
        r1.<init>(r3);
        r3 = r3.getResources();
        r1.m8215a(r3, r4, r0);
        r2.f7340c = r1;
    L_0x0035:
        r3 = r2.f7340c;
        r2.addView(r3);
        r3 = r2.f7340c;
        r4 = r2.isEnabled();
        r3.setEnabled(r4);
        r3 = r2.f7340c;
        r3.setOnClickListener(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.l.a(int, int):void");
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f7341d = onClickListener;
        if (this.f7340c != null) {
            this.f7340c.setOnClickListener(this);
        }
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f7340c.setEnabled(z);
    }

    public final void onClick(View view) {
        if (this.f7341d != null && view == this.f7340c) {
            this.f7341d.onClick(this);
        }
    }
}
