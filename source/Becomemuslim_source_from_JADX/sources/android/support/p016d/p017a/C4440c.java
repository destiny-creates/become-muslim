package android.support.p016d.p017a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.content.p027b.C0365c;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.util.C3211a;
import android.util.AttributeSet;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AnimatedVectorDrawableCompat */
/* renamed from: android.support.d.a.c */
public class C4440c extends C3115h implements C0115b {
    /* renamed from: a */
    final Callback f11821a;
    /* renamed from: c */
    private C0117a f11822c;
    /* renamed from: d */
    private Context f11823d;
    /* renamed from: e */
    private ArgbEvaluator f11824e;
    /* renamed from: f */
    private AnimatorListener f11825f;
    /* renamed from: g */
    private ArrayList<Object> f11826g;

    /* compiled from: AnimatedVectorDrawableCompat */
    /* renamed from: android.support.d.a.c$1 */
    class C01161 implements Callback {
        /* renamed from: a */
        final /* synthetic */ C4440c f258a;

        C01161(C4440c c4440c) {
            this.f258a = c4440c;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f258a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f258a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f258a.unscheduleSelf(runnable);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat */
    /* renamed from: android.support.d.a.c$a */
    private static class C0117a extends ConstantState {
        /* renamed from: a */
        int f259a;
        /* renamed from: b */
        C4441i f260b;
        /* renamed from: c */
        AnimatorSet f261c;
        /* renamed from: d */
        C3211a<Animator, String> f262d;
        /* renamed from: e */
        private ArrayList<Animator> f263e;

        public C0117a(Context context, C0117a c0117a, Callback callback, Resources resources) {
            if (c0117a != null) {
                this.f259a = c0117a.f259a;
                int i = 0;
                if (c0117a.f260b != null) {
                    context = c0117a.f260b.getConstantState();
                    if (resources != null) {
                        this.f260b = (C4441i) context.newDrawable(resources);
                    } else {
                        this.f260b = (C4441i) context.newDrawable();
                    }
                    this.f260b = (C4441i) this.f260b.mutate();
                    this.f260b.setCallback(callback);
                    this.f260b.setBounds(c0117a.f260b.getBounds());
                    this.f260b.m14762a(false);
                }
                if (c0117a.f263e != null) {
                    int size = c0117a.f263e.size();
                    this.f263e = new ArrayList(size);
                    this.f262d = new C3211a(size);
                    while (i < size) {
                        Animator animator = (Animator) c0117a.f263e.get(i);
                        resources = animator.clone();
                        String str = (String) c0117a.f262d.get(animator);
                        resources.setTarget(this.f260b.m14761a(str));
                        this.f263e.add(resources);
                        this.f262d.put(resources, str);
                        i++;
                    }
                    m236a();
                }
            }
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public int getChangingConfigurations() {
            return this.f259a;
        }

        /* renamed from: a */
        public void m236a() {
            if (this.f261c == null) {
                this.f261c = new AnimatorSet();
            }
            this.f261c.playTogether(this.f263e);
        }
    }

    /* compiled from: AnimatedVectorDrawableCompat */
    /* renamed from: android.support.d.a.c$b */
    private static class C0118b extends ConstantState {
        /* renamed from: a */
        private final ConstantState f264a;

        public C0118b(ConstantState constantState) {
            this.f264a = constantState;
        }

        public Drawable newDrawable() {
            Drawable c4440c = new C4440c();
            c4440c.b = this.f264a.newDrawable();
            c4440c.b.setCallback(c4440c.f11821a);
            return c4440c;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c4440c = new C4440c();
            c4440c.b = this.f264a.newDrawable(resources);
            c4440c.b.setCallback(c4440c.f11821a);
            return c4440c;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c4440c = new C4440c();
            c4440c.b = this.f264a.newDrawable(resources, theme);
            c4440c.b.setCallback(c4440c.f11821a);
            return c4440c;
        }

        public boolean canApplyTheme() {
            return this.f264a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f264a.getChangingConfigurations();
        }
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C4440c() {
        this(null, null, null);
    }

    private C4440c(Context context) {
        this(context, null, null);
    }

    private C4440c(Context context, C0117a c0117a, Resources resources) {
        this.f11824e = null;
        this.f11825f = null;
        this.f11826g = null;
        this.f11821a = new C01161(this);
        this.f11823d = context;
        if (c0117a != null) {
            this.f11822c = c0117a;
        } else {
            this.f11822c = new C0117a(context, c0117a, this.f11821a, resources);
        }
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
        }
        return this;
    }

    /* renamed from: a */
    public static C4440c m14750a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C4440c c4440c = new C4440c(context);
        c4440c.inflate(resources, xmlPullParser, attributeSet, theme);
        return c4440c;
    }

    public ConstantState getConstantState() {
        return (this.b == null || VERSION.SDK_INT < 24) ? null : new C0118b(this.b.getConstantState());
    }

    public int getChangingConfigurations() {
        if (this.b != null) {
            return this.b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f11822c.f259a;
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        this.f11822c.f260b.draw(canvas);
        if (this.f11822c.f261c.isStarted() != null) {
            invalidateSelf();
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        } else {
            this.f11822c.f260b.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        return this.f11822c.f260b.setState(iArr);
    }

    protected boolean onLevelChange(int i) {
        if (this.b != null) {
            return this.b.setLevel(i);
        }
        return this.f11822c.f260b.setLevel(i);
    }

    public int getAlpha() {
        if (this.b != null) {
            return C0259a.m699c(this.b);
        }
        return this.f11822c.f260b.getAlpha();
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
        } else {
            this.f11822c.f260b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
        } else {
            this.f11822c.f260b.setColorFilter(colorFilter);
        }
    }

    public void setTint(int i) {
        if (this.b != null) {
            C0259a.m690a(this.b, i);
        } else {
            this.f11822c.f260b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            C0259a.m692a(this.b, colorStateList);
        } else {
            this.f11822c.f260b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            C0259a.m695a(this.b, mode);
        } else {
            this.f11822c.f260b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        this.f11822c.f260b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public boolean isStateful() {
        if (this.b != null) {
            return this.b.isStateful();
        }
        return this.f11822c.f260b.isStateful();
    }

    public int getOpacity() {
        if (this.b != null) {
            return this.b.getOpacity();
        }
        return this.f11822c.f260b.getOpacity();
    }

    public int getIntrinsicWidth() {
        if (this.b != null) {
            return this.b.getIntrinsicWidth();
        }
        return this.f11822c.f260b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        if (this.b != null) {
            return this.b.getIntrinsicHeight();
        }
        return this.f11822c.f260b.getIntrinsicHeight();
    }

    public boolean isAutoMirrored() {
        if (this.b != null) {
            return C0259a.m697b(this.b);
        }
        return this.f11822c.f260b.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            C0259a.m696a(this.b, z);
        } else {
            this.f11822c.f260b.setAutoMirrored(z);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            C0259a.m694a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = C0365c.m1096a(resources, theme, attributeSet, C0114a.f250e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C4441i a2 = C4441i.m14755a(resources, resourceId, theme);
                        a2.m14762a(false);
                        a2.setCallback(this.f11821a);
                        if (this.f11822c.f260b != null) {
                            this.f11822c.f260b.setCallback(null);
                        }
                        this.f11822c.f260b = a2;
                    }
                    a.recycle();
                } else if (TouchesHelper.TARGET_KEY.equals(name)) {
                    a = resources.obtainAttributes(attributeSet, C0114a.f251f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f11823d != null) {
                            m14752a(string, C0122e.m242a(this.f11823d, resourceId2));
                        } else {
                            a.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f11822c.m236a();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void applyTheme(Theme theme) {
        if (this.b != null) {
            C0259a.m693a(this.b, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.b != null ? C0259a.m700d(this.b) : false;
    }

    /* renamed from: a */
    private void m14751a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m14751a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f11824e == null) {
                    this.f11824e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f11824e);
            }
        }
    }

    /* renamed from: a */
    private void m14752a(String str, Animator animator) {
        animator.setTarget(this.f11822c.f260b.m14761a(str));
        if (VERSION.SDK_INT < 21) {
            m14751a(animator);
        }
        if (this.f11822c.f263e == null) {
            this.f11822c.f263e = new ArrayList();
            this.f11822c.f262d = new C3211a();
        }
        this.f11822c.f263e.add(animator);
        this.f11822c.f262d.put(animator, str);
    }

    public boolean isRunning() {
        if (this.b != null) {
            return ((AnimatedVectorDrawable) this.b).isRunning();
        }
        return this.f11822c.f261c.isRunning();
    }

    public void start() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).start();
        } else if (!this.f11822c.f261c.isStarted()) {
            this.f11822c.f261c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.b != null) {
            ((AnimatedVectorDrawable) this.b).stop();
        } else {
            this.f11822c.f261c.end();
        }
    }
}
