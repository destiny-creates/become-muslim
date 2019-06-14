package com.facebook.ads;

import android.content.Context;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p105q.p106a.C1507j;
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p108c.C1539g;

public class AdChoicesView extends RelativeLayout {
    /* renamed from: a */
    private final NativeAdBase f3640a;
    /* renamed from: b */
    private final float f3641b;
    /* renamed from: c */
    private boolean f3642c;
    /* renamed from: d */
    private TextView f3643d;
    /* renamed from: e */
    private String f3644e;

    public AdChoicesView(Context context, NativeAdBase nativeAdBase) {
        this(context, nativeAdBase, false);
    }

    public AdChoicesView(Context context, final NativeAdBase nativeAdBase, boolean z) {
        super(context);
        boolean z2 = false;
        this.f3642c = false;
        this.f3640a = nativeAdBase;
        this.f3641b = C1523w.f4503b;
        if (!this.f3640a.isAdLoaded() || this.f3640a.m11396h().mo2838g()) {
            this.f3644e = this.f3640a.getAdChoicesText();
            if (TextUtils.isEmpty(this.f3644e)) {
                this.f3644e = "AdChoices";
            }
            C1427h y = this.f3640a.m11395g().m5019y();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            setOnTouchListener(new OnTouchListener(this) {
                /* renamed from: b */
                final /* synthetic */ AdChoicesView f3631b;

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 0) {
                        return false;
                    }
                    if (!this.f3631b.f3642c) {
                        this.f3631b.m4379a();
                    } else if (!TextUtils.isEmpty(this.f3631b.f3640a.getAdChoicesLinkUrl())) {
                        C1539g.m5388a(new C1539g(), this.f3631b.getContext(), Uri.parse(this.f3631b.f3640a.getAdChoicesLinkUrl()), nativeAdBase.m11397i());
                    }
                    return true;
                }
            });
            this.f3643d = new TextView(getContext());
            addView(this.f3643d);
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (!z || y == null) {
                z2 = true;
            } else {
                layoutParams2.addRule(11, m4378a(y).getId());
                layoutParams2.width = 0;
                layoutParams.width = Math.round(((float) (y.m5023b() + 4)) * this.f3641b);
                layoutParams.height = Math.round(((float) (y.m5024c() + 2)) * this.f3641b);
            }
            this.f3642c = z2;
            setLayoutParams(layoutParams);
            layoutParams2.addRule(15, -1);
            this.f3643d.setLayoutParams(layoutParams2);
            this.f3643d.setSingleLine();
            this.f3643d.setText(this.f3644e);
            this.f3643d.setTextSize(10.0f);
            this.f3643d.setTextColor(-4341303);
            C1507j.m5304a(this, C1507j.INTERNAL_AD_CHOICES_ICON);
            C1507j.m5304a(this.f3643d, C1507j.INTERNAL_AD_CHOICES_ICON);
            return;
        }
        setVisibility(8);
    }

    /* renamed from: a */
    private ImageView m4378a(C1427h c1427h) {
        ImageView imageView = new ImageView(getContext());
        addView(imageView);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(((float) c1427h.m5023b()) * this.f3641b), Math.round(((float) c1427h.m5024c()) * this.f3641b));
        layoutParams.addRule(9);
        layoutParams.addRule(15, -1);
        layoutParams.setMargins(Math.round(this.f3641b * 4.0f), Math.round(this.f3641b * 2.0f), Math.round(this.f3641b * 2.0f), Math.round(this.f3641b * 2.0f));
        imageView.setLayoutParams(layoutParams);
        C1425f.m4949a(c1427h, imageView);
        return imageView;
    }

    /* renamed from: a */
    private void m4379a() {
        Paint paint = new Paint();
        paint.setTextSize(this.f3643d.getTextSize());
        int round = Math.round(paint.measureText(this.f3644e) + (this.f3641b * 4.0f));
        final int width = getWidth();
        round += width;
        this.f3642c = true;
        Animation c12752 = new Animation(this) {
            /* renamed from: c */
            final /* synthetic */ AdChoicesView f3634c;

            protected void applyTransformation(float f, Transformation transformation) {
                int i = (int) (((float) width) + (((float) (round - width)) * f));
                this.f3634c.getLayoutParams().width = i;
                this.f3634c.requestLayout();
                this.f3634c.f3643d.getLayoutParams().width = i - width;
                this.f3634c.f3643d.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        c12752.setAnimationListener(new AnimationListener(this) {
            /* renamed from: c */
            final /* synthetic */ AdChoicesView f3639c;

            /* renamed from: com.facebook.ads.AdChoicesView$3$1 */
            class C12771 implements Runnable {
                /* renamed from: a */
                final /* synthetic */ C12783 f3636a;

                /* renamed from: com.facebook.ads.AdChoicesView$3$1$1 */
                class C12761 extends Animation {
                    /* renamed from: a */
                    final /* synthetic */ C12771 f3635a;

                    C12761(C12771 c12771) {
                        this.f3635a = c12771;
                    }

                    protected void applyTransformation(float f, Transformation transformation) {
                        int i = (int) (((float) round) + (((float) (width - round)) * f));
                        this.f3635a.f3636a.f3639c.getLayoutParams().width = i;
                        this.f3635a.f3636a.f3639c.requestLayout();
                        this.f3635a.f3636a.f3639c.f3643d.getLayoutParams().width = i - width;
                        this.f3635a.f3636a.f3639c.f3643d.requestLayout();
                    }

                    public boolean willChangeBounds() {
                        return true;
                    }
                }

                C12771(C12783 c12783) {
                    this.f3636a = c12783;
                }

                public void run() {
                    if (this.f3636a.f3639c.f3642c) {
                        this.f3636a.f3639c.f3642c = false;
                        Animation c12761 = new C12761(this);
                        c12761.setDuration(300);
                        c12761.setFillAfter(true);
                        this.f3636a.f3639c.startAnimation(c12761);
                    }
                }
            }

            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new C12771(this), 3000);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        c12752.setDuration(300);
        c12752.setFillAfter(true);
        startAnimation(c12752);
    }
}
