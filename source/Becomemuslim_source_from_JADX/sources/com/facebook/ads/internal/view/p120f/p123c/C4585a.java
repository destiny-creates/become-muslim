package com.facebook.ads.internal.view.p120f.p123c;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.facebook.ads.internal.p105q.p106a.C1523w;
import com.facebook.ads.internal.p105q.p107b.C1527b;
import com.facebook.ads.internal.p105q.p107b.C1528c;
import com.facebook.ads.internal.p105q.p108c.C1539g;
import com.facebook.ads.internal.view.p120f.p121a.C3639c;

/* renamed from: com.facebook.ads.internal.view.f.c.a */
public class C4585a extends C3639c {
    /* renamed from: a */
    private final C1635a f12487a;

    /* renamed from: com.facebook.ads.internal.view.f.c.a$a */
    public static class C1635a extends RelativeLayout {
        /* renamed from: a */
        private final String f4909a;
        /* renamed from: b */
        private final String f4910b;
        /* renamed from: c */
        private final String f4911c;
        /* renamed from: d */
        private final DisplayMetrics f4912d;
        /* renamed from: e */
        private ImageView f4913e;
        /* renamed from: f */
        private TextView f4914f;
        /* renamed from: g */
        private boolean f4915g = false;

        /* renamed from: com.facebook.ads.internal.view.f.c.a$a$1 */
        class C16301 implements OnTouchListener {
            /* renamed from: a */
            final /* synthetic */ C1635a f4900a;

            C16301(C1635a c1635a) {
                this.f4900a = c1635a;
            }

            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                if (!this.f4900a.f4915g) {
                    this.f4900a.m5621d();
                } else if (!TextUtils.isEmpty(this.f4900a.f4910b)) {
                    C1539g.m5388a(new C1539g(), this.f4900a.getContext(), Uri.parse(this.f4900a.f4910b), this.f4900a.f4911c);
                }
                return true;
            }
        }

        public C1635a(Context context, String str, String str2, float[] fArr, String str3) {
            super(context);
            this.f4909a = str;
            this.f4910b = str2;
            this.f4911c = str3;
            this.f4912d = context.getResources().getDisplayMetrics();
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-16777216);
            gradientDrawable.setAlpha(178);
            gradientDrawable.setCornerRadii(new float[]{fArr[0] * this.f4912d.density, fArr[0] * this.f4912d.density, fArr[1] * this.f4912d.density, fArr[1] * this.f4912d.density, fArr[2] * this.f4912d.density, fArr[2] * this.f4912d.density, fArr[3] * this.f4912d.density, fArr[3] * this.f4912d.density});
            C1523w.m5343a((View) this, gradientDrawable);
            m5614a();
            m5618b();
            m5620c();
            setMinimumWidth(Math.round(this.f4912d.density * 20.0f));
            setMinimumHeight(Math.round(this.f4912d.density * 18.0f));
        }

        /* renamed from: a */
        private void m5614a() {
            setOnTouchListener(new C16301(this));
        }

        /* renamed from: b */
        private void m5618b() {
            this.f4913e = new ImageView(getContext());
            this.f4913e.setImageBitmap(C1528c.m5354a(C1527b.IC_AD_CHOICES));
            addView(this.f4913e);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(Math.round(this.f4912d.density * 16.0f), Math.round(this.f4912d.density * 16.0f));
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            layoutParams.setMargins(Math.round(this.f4912d.density * 4.0f), Math.round(this.f4912d.density * 2.0f), Math.round(this.f4912d.density * 2.0f), Math.round(this.f4912d.density * 2.0f));
            this.f4913e.setLayoutParams(layoutParams);
        }

        /* renamed from: c */
        private void m5620c() {
            this.f4914f = new TextView(getContext());
            addView(this.f4914f);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.width = 0;
            layoutParams.leftMargin = (int) (this.f4912d.density * 20.0f);
            layoutParams.addRule(9);
            layoutParams.addRule(15, -1);
            this.f4914f.setLayoutParams(layoutParams);
            this.f4914f.setSingleLine();
            this.f4914f.setText(this.f4909a);
            this.f4914f.setTextSize(10.0f);
            this.f4914f.setTextColor(-4341303);
        }

        /* renamed from: d */
        private void m5621d() {
            Paint paint = new Paint();
            paint.setTextSize(this.f4914f.getTextSize());
            int round = Math.round(paint.measureText(this.f4909a) + (this.f4912d.density * 4.0f));
            final int width = getWidth();
            round += width;
            this.f4915g = true;
            Animation c16312 = new Animation(this) {
                /* renamed from: c */
                final /* synthetic */ C1635a f4903c;

                protected void applyTransformation(float f, Transformation transformation) {
                    int i = (int) (((float) width) + (((float) (round - width)) * f));
                    this.f4903c.getLayoutParams().width = i;
                    this.f4903c.requestLayout();
                    this.f4903c.f4914f.getLayoutParams().width = i - width;
                    this.f4903c.f4914f.requestLayout();
                }

                public boolean willChangeBounds() {
                    return true;
                }
            };
            c16312.setAnimationListener(new AnimationListener(this) {
                /* renamed from: c */
                final /* synthetic */ C1635a f4908c;

                /* renamed from: com.facebook.ads.internal.view.f.c.a$a$3$1 */
                class C16331 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C16343 f4905a;

                    /* renamed from: com.facebook.ads.internal.view.f.c.a$a$3$1$1 */
                    class C16321 extends Animation {
                        /* renamed from: a */
                        final /* synthetic */ C16331 f4904a;

                        C16321(C16331 c16331) {
                            this.f4904a = c16331;
                        }

                        protected void applyTransformation(float f, Transformation transformation) {
                            int i = (int) (((float) round) + (((float) (width - round)) * f));
                            this.f4904a.f4905a.f4908c.getLayoutParams().width = i;
                            this.f4904a.f4905a.f4908c.requestLayout();
                            this.f4904a.f4905a.f4908c.f4914f.getLayoutParams().width = i - width;
                            this.f4904a.f4905a.f4908c.f4914f.requestLayout();
                        }

                        public boolean willChangeBounds() {
                            return true;
                        }
                    }

                    C16331(C16343 c16343) {
                        this.f4905a = c16343;
                    }

                    public void run() {
                        if (this.f4905a.f4908c.f4915g) {
                            this.f4905a.f4908c.f4915g = false;
                            Animation c16321 = new C16321(this);
                            c16321.setDuration(300);
                            c16321.setFillAfter(true);
                            this.f4905a.f4908c.startAnimation(c16321);
                        }
                    }
                }

                public void onAnimationEnd(Animation animation) {
                    new Handler().postDelayed(new C16331(this), 3000);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            c16312.setDuration(300);
            c16312.setFillAfter(true);
            startAnimation(c16312);
        }
    }

    public C4585a(Context context, String str, String str2, float[] fArr) {
        super(context);
        this.f12487a = new C1635a(context, "AdChoices", str, fArr, str2);
        addView(this.f12487a);
    }
}
