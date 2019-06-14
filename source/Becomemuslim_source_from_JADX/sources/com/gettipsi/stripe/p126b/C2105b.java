package com.gettipsi.stripe.p126b;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.widget.ImageView;
import com.gettipsi.stripe.C2116d.C2110a;

/* compiled from: CardFlipAnimator */
/* renamed from: com.gettipsi.stripe.b.b */
public class C2105b {
    /* renamed from: a */
    private final Context f5034a;
    /* renamed from: b */
    private final ImageView f5035b;
    /* renamed from: c */
    private final ImageView f5036c;
    /* renamed from: d */
    private Animator f5037d;
    /* renamed from: e */
    private Animator f5038e;
    /* renamed from: f */
    private Animator f5039f;
    /* renamed from: g */
    private Animator f5040g;

    public C2105b(Context context, ImageView imageView, ImageView imageView2) {
        this.f5034a = context;
        this.f5035b = imageView;
        this.f5036c = imageView2;
        m5780c();
    }

    /* renamed from: c */
    private void m5780c() {
        this.f5037d = AnimatorInflater.loadAnimator(this.f5034a, C2110a.card_flip_right_in);
        this.f5038e = AnimatorInflater.loadAnimator(this.f5034a, C2110a.card_flip_right_out);
        this.f5039f = AnimatorInflater.loadAnimator(this.f5034a, C2110a.card_flip_left_in);
        this.f5040g = AnimatorInflater.loadAnimator(this.f5034a, C2110a.card_flip_left_out);
        this.f5037d.setTarget(this.f5036c);
        this.f5038e.setTarget(this.f5035b);
        this.f5039f.setTarget(this.f5035b);
        this.f5040g.setTarget(this.f5036c);
    }

    /* renamed from: a */
    public void m5781a() {
        this.f5037d.start();
        this.f5038e.start();
    }

    /* renamed from: b */
    public void m5782b() {
        this.f5039f.start();
        this.f5040g.start();
    }
}
