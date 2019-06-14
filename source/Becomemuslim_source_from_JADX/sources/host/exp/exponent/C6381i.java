package host.exp.exponent;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.imageutils.JfifUtil;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.uimanager.ViewProps;
import com.p079e.p080a.C1212e;
import com.p079e.p080a.C1236t;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p346j.C6383a;
import host.exp.exponent.p346j.C6383a.C6382a;
import host.exp.exponent.p346j.C6384b;
import host.exp.p333a.C6279c.C6273b;
import host.exp.p333a.C6279c.C6274c;
import host.exp.p333a.C6279c.C6275d;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: LoadingView */
/* renamed from: host.exp.exponent.i */
public class C6381i extends RelativeLayout {
    /* renamed from: g */
    private static final String f20661g = "i";
    /* renamed from: a */
    ProgressBar f20662a;
    /* renamed from: b */
    ImageView f20663b;
    /* renamed from: c */
    ImageView f20664c;
    /* renamed from: d */
    View f20665d;
    /* renamed from: e */
    TextView f20666e;
    /* renamed from: f */
    TextView f20667f;
    /* renamed from: h */
    private Handler f20668h = new Handler();
    /* renamed from: i */
    private boolean f20669i = false;
    /* renamed from: j */
    private boolean f20670j = false;
    /* renamed from: k */
    private boolean f20671k = false;

    /* compiled from: LoadingView */
    /* renamed from: host.exp.exponent.i$1 */
    class C63751 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C6381i f20648a;

        C63751(C6381i c6381i) {
            this.f20648a = c6381i;
        }

        public void run() {
            this.f20648a.f20662a.setVisibility(0);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(250);
            alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            alphaAnimation.setFillAfter(true);
            this.f20648a.f20662a.startAnimation(alphaAnimation);
        }
    }

    /* compiled from: LoadingView */
    /* renamed from: host.exp.exponent.i$2 */
    class C63762 implements AnimationListener {
        /* renamed from: a */
        final /* synthetic */ C6381i f20649a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C63762(C6381i c6381i) {
            this.f20649a = c6381i;
        }

        public void onAnimationEnd(Animation animation) {
            this.f20649a.f20662a.setVisibility(8);
        }
    }

    /* compiled from: LoadingView */
    /* renamed from: host.exp.exponent.i$6 */
    class C63776 implements AnimationListener {
        /* renamed from: a */
        final /* synthetic */ C6381i f20650a;

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }

        C63776(C6381i c6381i) {
            this.f20650a = c6381i;
        }

        public void onAnimationEnd(Animation animation) {
            this.f20650a.f20663b.setVisibility(8);
        }
    }

    public C6381i(Context context) {
        super(context);
        m26178c();
    }

    /* renamed from: c */
    private void m26178c() {
        C6381i.inflate(getContext(), C6275d.loading_view, this);
        this.f20662a = (ProgressBar) findViewById(C6274c.progress_bar);
        this.f20663b = (ImageView) findViewById(C6274c.image_view);
        this.f20664c = (ImageView) findViewById(C6274c.background_image_view);
        this.f20665d = findViewById(C6274c.status_bar);
        this.f20666e = (TextView) findViewById(C6274c.status_text_view);
        this.f20667f = (TextView) findViewById(C6274c.percentage_text_view);
        setBackgroundColor(-1);
        m26180d();
    }

    /* renamed from: d */
    private void m26180d() {
        this.f20668h.postDelayed(new C63751(this), 2500);
    }

    /* renamed from: e */
    private void m26182e() {
        this.f20668h.removeCallbacksAndMessages(null);
        this.f20662a.clearAnimation();
        if (this.f20662a.getVisibility() == 0) {
            Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(250);
            alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new C63762(this));
            this.f20662a.startAnimation(alphaAnimation);
        }
    }

    public void setManifest(JSONObject jSONObject) {
        m26182e();
        if (!this.f20670j) {
            this.f20670j = true;
            this.f20671k = false;
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("loading");
                if (m26177c(jSONObject).booleanValue()) {
                    this.f20663b.setAlpha(0.0f);
                } else if (optJSONObject != null && optJSONObject.has("iconUrl")) {
                    this.f20663b.setVisibility(8);
                    final String optString = optJSONObject.optString("iconUrl");
                    this.f20671k = true;
                    C1236t.a(getContext()).a(optString).a(this.f20663b, new C1212e(this) {
                        /* renamed from: b */
                        final /* synthetic */ C6381i f26237b;

                        /* renamed from: a */
                        public void m34306a() {
                            this.f26237b.m26169a(this.f26237b.f20663b);
                            this.f26237b.f20671k = false;
                            C6383a.m26189a("loadingViewImage");
                        }

                        /* renamed from: b */
                        public void m34307b() {
                            String b = C6381i.f20661g;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Couldn't load image at url ");
                            stringBuilder.append(optString);
                            C6289b.m25953c(b, stringBuilder.toString());
                        }
                    });
                } else if (optJSONObject != null && optJSONObject.has("exponentIconGrayscale")) {
                    this.f20663b.setImageResource(C6273b.big_logo_dark);
                    int optDouble = (int) (optJSONObject.optDouble("exponentIconGrayscale", 1.0d) * 255.0d);
                    if (optDouble < 0) {
                        optDouble = 0;
                    } else if (optDouble > JfifUtil.MARKER_FIRST_BYTE) {
                        optDouble = JfifUtil.MARKER_FIRST_BYTE;
                    }
                    this.f20663b.setColorFilter(Color.argb(JfifUtil.MARKER_FIRST_BYTE, optDouble, optDouble, optDouble));
                } else if (optJSONObject != null) {
                    String optString2 = optJSONObject.optString("exponentIconColor", null);
                    if (optString2 != null) {
                        if (optString2.equals("white")) {
                            this.f20663b.setImageResource(C6273b.big_logo_new_filled);
                        } else if (optString2.equals("navy") || optString2.equals("blue")) {
                            this.f20663b.setImageResource(C6273b.big_logo_dark_filled);
                        }
                    }
                }
                setBackgroundImage(jSONObject);
                setBackgroundColor(jSONObject);
            }
        }
    }

    private void setBackgroundImage(JSONObject jSONObject) {
        if (m26177c(jSONObject).booleanValue()) {
            this.f20664c.setScaleType(m26168a(jSONObject));
        }
        if (C6301d.m26001a()) {
            m26169a(this.f20664c);
            return;
        }
        jSONObject = m26174b(jSONObject);
        if (jSONObject != null) {
            C1236t.a(getContext()).a(jSONObject).a(this.f20664c, new C1212e(this) {
                /* renamed from: b */
                final /* synthetic */ C6381i f26239b;

                /* renamed from: a */
                public void m34308a() {
                    this.f26239b.m26169a(this.f26239b.f20664c);
                }

                /* renamed from: b */
                public void m34309b() {
                    String b = C6381i.f20661g;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Couldn't load image at url ");
                    stringBuilder.append(jSONObject);
                    C6289b.m25953c(b, stringBuilder.toString());
                }
            });
        }
    }

    /* renamed from: a */
    private ScaleType m26168a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        String str = null;
        if (jSONObject.has("android")) {
            optJSONObject = jSONObject.optJSONObject("android");
            if (optJSONObject.has("splash")) {
                optJSONObject = optJSONObject.optJSONObject("splash");
                if (optJSONObject == null && jSONObject.has("splash")) {
                    optJSONObject = jSONObject.optJSONObject("splash");
                }
                if (!(optJSONObject == null || optJSONObject.has(ViewProps.RESIZE_MODE) == null)) {
                    str = optJSONObject.optString(ViewProps.RESIZE_MODE, "contain");
                }
                if (str == null) {
                    return ScaleType.FIT_CENTER;
                }
                if (str.equals(PlaceFields.COVER) == null) {
                    return ScaleType.CENTER_CROP;
                }
                return ScaleType.FIT_CENTER;
            }
        }
        optJSONObject = null;
        optJSONObject = jSONObject.optJSONObject("splash");
        str = optJSONObject.optString(ViewProps.RESIZE_MODE, "contain");
        if (str == null) {
            return ScaleType.FIT_CENTER;
        }
        if (str.equals(PlaceFields.COVER) == null) {
            return ScaleType.FIT_CENTER;
        }
        return ScaleType.CENTER_CROP;
    }

    private void setBackgroundColor(JSONObject jSONObject) {
        if (m26177c(jSONObject).booleanValue()) {
            JSONObject optJSONObject = jSONObject.has("android") ? jSONObject.optJSONObject("android").optJSONObject("splash") : null;
            if (optJSONObject == null && jSONObject.has("splash")) {
                optJSONObject = jSONObject.optJSONObject("splash");
            }
            if (optJSONObject != null) {
                jSONObject = optJSONObject.optString(ViewProps.BACKGROUND_COLOR);
                if (jSONObject == null || !C6384b.m26192a(jSONObject)) {
                    jSONObject = "#FFFFFF";
                }
                setBackgroundColor(Color.parseColor(jSONObject));
                this.f20663b.setLayerType(2, null);
            }
        } else if (jSONObject.has("loading")) {
            jSONObject = jSONObject.optJSONObject("loading");
            if (jSONObject != null) {
                jSONObject = jSONObject.optString(ViewProps.BACKGROUND_COLOR);
                jSONObject = "#FFFFFF";
                setBackgroundColor(Color.parseColor(jSONObject));
                this.f20663b.setLayerType(2, null);
            }
        }
        jSONObject = null;
        jSONObject = "#FFFFFF";
        setBackgroundColor(Color.parseColor(jSONObject));
        this.f20663b.setLayerType(2, null);
    }

    /* renamed from: b */
    private String m26174b(JSONObject jSONObject) {
        if (m26177c(jSONObject).booleanValue()) {
            if (jSONObject.has("android")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("android");
                if (optJSONObject.has("splash")) {
                    optJSONObject = optJSONObject.optJSONObject("splash");
                    for (String str : new String[]{"xxxhdpiUrl", "xxhdpiUrl", "xhdpiUrl", "hdpiUrl", "mdpiUrl", "ldpiUrl"}) {
                        if (optJSONObject.has(str) && optJSONObject.optString(str) != null) {
                            return optJSONObject.optString(str);
                        }
                    }
                }
            }
            if (jSONObject.has("splash")) {
                jSONObject = jSONObject.optJSONObject("splash");
                if (jSONObject.has("imageUrl")) {
                    return jSONObject.optString("imageUrl");
                }
            }
        } else if (jSONObject.has("loading")) {
            jSONObject = jSONObject.optJSONObject("loading");
            if (jSONObject != null) {
                return jSONObject.optString("backgroundImageUrl", null);
            }
        }
        return null;
    }

    /* renamed from: c */
    private Boolean m26177c(JSONObject jSONObject) {
        boolean z = true;
        if (jSONObject.has("splash") && jSONObject.optJSONObject("splash") != null) {
            return Boolean.valueOf(true);
        }
        if (!jSONObject.has("android")) {
            return Boolean.valueOf(false);
        }
        if (jSONObject.optJSONObject("android").optJSONObject("splash") == null) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public void setShowIcon(final boolean z) {
        C6383a.m26191b("loadingViewImage");
        C6383a.m26190a("loadingViewImage", new C6382a(this) {
            /* renamed from: b */
            final /* synthetic */ C6381i f26241b;

            /* renamed from: a */
            public boolean mo5390a() {
                return this.f26241b.f20671k ^ 1;
            }

            /* renamed from: b */
            public void mo5391b() {
                boolean b = this.f26241b.f20669i;
                this.f26241b.f20669i = z;
                if (!this.f26241b.f20669i) {
                    this.f26241b.m26184g();
                } else if (!b) {
                    this.f26241b.m26183f();
                }
            }
        });
    }

    /* renamed from: a */
    public void m26186a(String str, Integer num, Integer num2) {
        this.f20665d.setVisibility(0);
        TextView textView = this.f20666e;
        if (str == null) {
            str = "Building JavaScript bundle...";
        }
        textView.setText(str);
        if (num != null && num2 != null && num2.intValue() > null) {
            str = (((float) num.intValue()) / ((float) num2.intValue())) * 1120403456;
            this.f20667f.setText(String.format(Locale.getDefault(), "%.2f%%", new Object[]{Float.valueOf(str)}));
        }
    }

    /* renamed from: f */
    private void m26183f() {
        if (this.f20669i) {
            if (this.f20670j) {
                this.f20663b.clearAnimation();
                this.f20663b.setVisibility(0);
                Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300);
                alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                alphaAnimation.setFillAfter(true);
                this.f20663b.startAnimation(alphaAnimation);
            }
        }
    }

    /* renamed from: g */
    private void m26184g() {
        this.f20663b.clearAnimation();
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new C63776(this));
        this.f20663b.startAnimation(alphaAnimation);
    }

    /* renamed from: a */
    public void m26185a() {
        this.f20670j = false;
        C6383a.m26191b("loadingViewImage");
    }

    /* renamed from: a */
    private void m26169a(View view) {
        view.setVisibility(0);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setFillAfter(true);
        view.setAnimation(alphaAnimation);
    }
}
