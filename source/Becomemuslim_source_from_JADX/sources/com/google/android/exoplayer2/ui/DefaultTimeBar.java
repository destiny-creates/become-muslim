package com.google.android.exoplayer2.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.facebook.internal.Utility;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import com.google.android.exoplayer2.ui.C2579a.C2578a;
import com.google.android.exoplayer2.ui.C2582c.C2581a;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar extends View implements C2582c {
    /* renamed from: A */
    private int[] f11229A;
    /* renamed from: B */
    private Point f11230B;
    /* renamed from: C */
    private boolean f11231C;
    /* renamed from: D */
    private long f11232D;
    /* renamed from: E */
    private long f11233E;
    /* renamed from: F */
    private long f11234F;
    /* renamed from: G */
    private long f11235G;
    /* renamed from: H */
    private int f11236H;
    /* renamed from: I */
    private long[] f11237I;
    /* renamed from: J */
    private boolean[] f11238J;
    /* renamed from: a */
    private final Rect f11239a = new Rect();
    /* renamed from: b */
    private final Rect f11240b = new Rect();
    /* renamed from: c */
    private final Rect f11241c = new Rect();
    /* renamed from: d */
    private final Rect f11242d = new Rect();
    /* renamed from: e */
    private final Paint f11243e = new Paint();
    /* renamed from: f */
    private final Paint f11244f = new Paint();
    /* renamed from: g */
    private final Paint f11245g = new Paint();
    /* renamed from: h */
    private final Paint f11246h = new Paint();
    /* renamed from: i */
    private final Paint f11247i = new Paint();
    /* renamed from: j */
    private final Paint f11248j = new Paint();
    /* renamed from: k */
    private final Drawable f11249k;
    /* renamed from: l */
    private final int f11250l;
    /* renamed from: m */
    private final int f11251m;
    /* renamed from: n */
    private final int f11252n;
    /* renamed from: o */
    private final int f11253o;
    /* renamed from: p */
    private final int f11254p;
    /* renamed from: q */
    private final int f11255q;
    /* renamed from: r */
    private final int f11256r;
    /* renamed from: s */
    private final int f11257s;
    /* renamed from: t */
    private final StringBuilder f11258t;
    /* renamed from: u */
    private final Formatter f11259u;
    /* renamed from: v */
    private final Runnable f11260v;
    /* renamed from: w */
    private final CopyOnWriteArraySet<C2581a> f11261w;
    /* renamed from: x */
    private int f11262x;
    /* renamed from: y */
    private long f11263y;
    /* renamed from: z */
    private int f11264z;

    /* renamed from: com.google.android.exoplayer2.ui.DefaultTimeBar$1 */
    class C25771 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ DefaultTimeBar f6577a;

        C25771(DefaultTimeBar defaultTimeBar) {
            this.f6577a = defaultTimeBar;
        }

        public void run() {
            this.f6577a.m13843a(false);
        }
    }

    /* renamed from: a */
    public static int m13836a(int i) {
        return i | -16777216;
    }

    /* renamed from: b */
    public static int m13847b(int i) {
        return (i & 16777215) | 855638016;
    }

    /* renamed from: c */
    public static int m13850c(int i) {
        return (i & 16777215) | -872415232;
    }

    /* renamed from: d */
    public static int m13852d(int i) {
        return (i & 16777215) | 855638016;
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11248j.setAntiAlias(true);
        this.f11261w = new CopyOnWriteArraySet();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f11257s = m13837a(displayMetrics, -50);
        int a = m13837a(displayMetrics, 4);
        int a2 = m13837a(displayMetrics, 26);
        int a3 = m13837a(displayMetrics, 4);
        int a4 = m13837a(displayMetrics, 12);
        int a5 = m13837a(displayMetrics, 0);
        int a6 = m13837a(displayMetrics, 16);
        if (attributeSet != null) {
            context = context.getTheme().obtainStyledAttributes(attributeSet, C2578a.DefaultTimeBar, 0, 0);
            try {
                this.f11249k = context.getDrawable(C2578a.DefaultTimeBar_scrubber_drawable);
                if (this.f11249k != null) {
                    m13846a(this.f11249k, getLayoutDirection());
                    a2 = Math.max(this.f11249k.getMinimumHeight(), a2);
                }
                this.f11250l = context.getDimensionPixelSize(C2578a.DefaultTimeBar_bar_height, a);
                this.f11251m = context.getDimensionPixelSize(C2578a.DefaultTimeBar_touch_target_height, a2);
                this.f11252n = context.getDimensionPixelSize(C2578a.DefaultTimeBar_ad_marker_width, a3);
                this.f11253o = context.getDimensionPixelSize(C2578a.DefaultTimeBar_scrubber_enabled_size, a4);
                this.f11254p = context.getDimensionPixelSize(C2578a.DefaultTimeBar_scrubber_disabled_size, a5);
                this.f11255q = context.getDimensionPixelSize(C2578a.DefaultTimeBar_scrubber_dragged_size, a6);
                int i = context.getInt(C2578a.DefaultTimeBar_played_color, -1);
                a6 = context.getInt(C2578a.DefaultTimeBar_scrubber_color, m13836a(i));
                a3 = context.getInt(C2578a.DefaultTimeBar_buffered_color, m13850c(i));
                a = context.getInt(C2578a.DefaultTimeBar_unplayed_color, m13847b(i));
                a2 = context.getInt(C2578a.DefaultTimeBar_ad_marker_color, -1291845888);
                a4 = context.getInt(C2578a.DefaultTimeBar_played_ad_marker_color, m13852d(a2));
                this.f11243e.setColor(i);
                this.f11248j.setColor(a6);
                this.f11244f.setColor(a3);
                this.f11245g.setColor(a);
                this.f11246h.setColor(a2);
                this.f11247i.setColor(a4);
            } finally {
                context.recycle();
            }
        } else {
            this.f11250l = a;
            this.f11251m = a2;
            this.f11252n = a3;
            this.f11253o = a4;
            this.f11254p = a5;
            this.f11255q = a6;
            this.f11243e.setColor(-1);
            this.f11248j.setColor(m13836a(-1));
            this.f11244f.setColor(m13850c(-1));
            this.f11245g.setColor(m13847b(-1));
            this.f11246h.setColor(-1291845888);
            this.f11249k = null;
        }
        this.f11258t = new StringBuilder();
        this.f11259u = new Formatter(this.f11258t, Locale.getDefault());
        this.f11260v = new C25771(this);
        if (this.f11249k != null) {
            this.f11256r = (this.f11249k.getMinimumWidth() + 1) / 2;
        } else {
            this.f11256r = (Math.max(this.f11254p, Math.max(this.f11253o, this.f11255q)) + 1) / 2;
        }
        this.f11233E = -9223372036854775807L;
        this.f11263y = -9223372036854775807L;
        this.f11262x = 20;
        setFocusable(true);
        if (C2541v.f6467a >= 16) {
            m13839a();
        }
    }

    public void setKeyTimeIncrement(long j) {
        C2516a.m7017a(j > 0);
        this.f11262x = -1;
        this.f11263y = j;
    }

    public void setKeyCountIncrement(int i) {
        C2516a.m7017a(i > 0);
        this.f11262x = i;
        this.f11263y = -9223372036854775807L;
    }

    public void setPosition(long j) {
        this.f11234F = j;
        setContentDescription(getProgressText());
        m13851c();
    }

    public void setBufferedPosition(long j) {
        this.f11235G = j;
        m13851c();
    }

    public void setDuration(long j) {
        this.f11233E = j;
        if (this.f11231C && j == -9223372036854775807L) {
            m13843a((boolean) 1);
        }
        m13851c();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f11231C && !z) {
            m13843a(true);
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        m13841a(canvas);
        m13849b(canvas);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (isEnabled()) {
            if (this.f11233E > 0) {
                Point a = m13838a(motionEvent);
                int i = a.x;
                int i2 = a.y;
                switch (motionEvent.getAction()) {
                    case 0:
                        float f = (float) i;
                        if (m13844a(f, (float) i2)) {
                            m13848b();
                            m13840a(f);
                            this.f11232D = getScrubberPosition();
                            m13851c();
                            invalidate();
                            return true;
                        }
                        break;
                    case 1:
                    case 3:
                        if (this.f11231C) {
                            if (motionEvent.getAction() == 3) {
                                z = true;
                            }
                            m13843a(z);
                            return true;
                        }
                        break;
                    case 2:
                        if (this.f11231C != null) {
                            if (i2 < this.f11257s) {
                                m13840a((float) (this.f11264z + ((i - this.f11264z) / 3)));
                            } else {
                                this.f11264z = i;
                                m13840a((float) i);
                            }
                            this.f11232D = getScrubberPosition();
                            motionEvent = this.f11261w.iterator();
                            while (motionEvent.hasNext()) {
                                ((C2581a) motionEvent.next()).m7300b(this, this.f11232D);
                            }
                            m13851c();
                            invalidate();
                            return true;
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
        r4 = this;
        r0 = r4.isEnabled();
        if (r0 == 0) goto L_0x0036;
    L_0x0006:
        r0 = r4.getPositionIncrement();
        r2 = 66;
        r3 = 1;
        if (r5 == r2) goto L_0x0027;
    L_0x000f:
        switch(r5) {
            case 21: goto L_0x0013;
            case 22: goto L_0x0014;
            case 23: goto L_0x0027;
            default: goto L_0x0012;
        };
    L_0x0012:
        goto L_0x0036;
    L_0x0013:
        r0 = -r0;
    L_0x0014:
        r0 = r4.m13845a(r0);
        if (r0 == 0) goto L_0x0036;
    L_0x001a:
        r5 = r4.f11260v;
        r4.removeCallbacks(r5);
        r5 = r4.f11260v;
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4.postDelayed(r5, r0);
        return r3;
    L_0x0027:
        r0 = r4.f11231C;
        if (r0 == 0) goto L_0x0036;
    L_0x002b:
        r5 = r4.f11260v;
        r4.removeCallbacks(r5);
        r5 = r4.f11260v;
        r5.run();
        return r3;
    L_0x0036:
        r5 = super.onKeyDown(r5, r6);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m13853d();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f11249k != null) {
            this.f11249k.jumpToCurrentState();
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (mode == 0) {
            i2 = this.f11251m;
        } else if (mode != 1073741824) {
            i2 = Math.min(this.f11251m, i2);
        }
        setMeasuredDimension(MeasureSpec.getSize(i), i2);
        m13853d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        i3 -= i;
        i4 = ((i4 - i2) - this.f11251m) / 2;
        i = ((this.f11251m - this.f11250l) / 2) + i4;
        this.f11239a.set(getPaddingLeft(), i4, i3 - getPaddingRight(), this.f11251m + i4);
        this.f11240b.set(this.f11239a.left + this.f11256r, i, this.f11239a.right - this.f11256r, this.f11250l + i);
        m13851c();
    }

    public void onRtlPropertiesChanged(int i) {
        if (this.f11249k != null && m13846a(this.f11249k, i) != 0) {
            invalidate();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(DefaultTimeBar.class.getName());
    }

    @TargetApi(21)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(DefaultTimeBar.class.getCanonicalName());
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.f11233E > 0) {
            if (C2541v.f6467a >= 21) {
                accessibilityNodeInfo.addAction(AccessibilityAction.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfo.addAction(AccessibilityAction.ACTION_SCROLL_BACKWARD);
            } else if (C2541v.f6467a >= 16) {
                accessibilityNodeInfo.addAction(4096);
                accessibilityNodeInfo.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
    }

    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle) != null) {
            return true;
        }
        if (this.f11233E <= 0) {
            return false;
        }
        if (i == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            if (m13845a(-getPositionIncrement()) != 0) {
                m13843a(false);
            }
        } else if (i != 4096) {
            return false;
        } else {
            if (m13845a(getPositionIncrement()) != 0) {
                m13843a(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    @TargetApi(16)
    /* renamed from: a */
    private void m13839a() {
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* renamed from: b */
    private void m13848b() {
        this.f11231C = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.f11261w.iterator();
        while (it.hasNext()) {
            ((C2581a) it.next()).m7298a(this, getScrubberPosition());
        }
    }

    /* renamed from: a */
    private void m13843a(boolean z) {
        this.f11231C = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.f11261w.iterator();
        while (it.hasNext()) {
            ((C2581a) it.next()).m7299a(this, getScrubberPosition(), z);
        }
    }

    /* renamed from: c */
    private void m13851c() {
        this.f11241c.set(this.f11240b);
        this.f11242d.set(this.f11240b);
        long j = this.f11231C ? this.f11232D : this.f11234F;
        if (this.f11233E > 0) {
            this.f11241c.right = Math.min(this.f11240b.left + ((int) ((((long) this.f11240b.width()) * this.f11235G) / this.f11233E)), this.f11240b.right);
            this.f11242d.right = Math.min(this.f11240b.left + ((int) ((((long) this.f11240b.width()) * j) / this.f11233E)), this.f11240b.right);
        } else {
            this.f11241c.right = this.f11240b.left;
            this.f11242d.right = this.f11240b.left;
        }
        invalidate(this.f11239a);
    }

    /* renamed from: a */
    private void m13840a(float f) {
        this.f11242d.right = C2541v.m7164a((int) f, this.f11240b.left, this.f11240b.right);
    }

    /* renamed from: a */
    private Point m13838a(MotionEvent motionEvent) {
        if (this.f11229A == null) {
            this.f11229A = new int[2];
            this.f11230B = new Point();
        }
        getLocationOnScreen(this.f11229A);
        this.f11230B.set(((int) motionEvent.getRawX()) - this.f11229A[0], ((int) motionEvent.getRawY()) - this.f11229A[1]);
        return this.f11230B;
    }

    private long getScrubberPosition() {
        if (this.f11240b.width() > 0) {
            if (this.f11233E != -9223372036854775807L) {
                return (((long) this.f11242d.width()) * this.f11233E) / ((long) this.f11240b.width());
            }
        }
        return 0;
    }

    /* renamed from: a */
    private boolean m13844a(float f, float f2) {
        return this.f11239a.contains((int) f, (int) f2);
    }

    /* renamed from: a */
    private void m13841a(Canvas canvas) {
        int height = this.f11240b.height();
        int centerY = this.f11240b.centerY() - (height / 2);
        height += centerY;
        if (this.f11233E <= 0) {
            canvas.drawRect((float) this.f11240b.left, (float) centerY, (float) this.f11240b.right, (float) height, this.f11245g);
            return;
        }
        int i = this.f11241c.left;
        int i2 = this.f11241c.right;
        int max = Math.max(Math.max(this.f11240b.left, i2), this.f11242d.right);
        if (max < this.f11240b.right) {
            canvas.drawRect((float) max, (float) centerY, (float) this.f11240b.right, (float) height, this.f11245g);
        }
        i = Math.max(i, this.f11242d.right);
        if (i2 > i) {
            canvas.drawRect((float) i, (float) centerY, (float) i2, (float) height, this.f11244f);
        }
        if (this.f11242d.width() > 0) {
            canvas.drawRect((float) this.f11242d.left, (float) centerY, (float) this.f11242d.right, (float) height, this.f11243e);
        }
        i = this.f11252n / 2;
        for (max = 0; max < this.f11236H; max++) {
            int min = this.f11240b.left + Math.min(this.f11240b.width() - this.f11252n, Math.max(0, ((int) ((((long) this.f11240b.width()) * C2541v.m7169a(this.f11237I[max], 0, this.f11233E)) / this.f11233E)) - i));
            canvas.drawRect((float) min, (float) centerY, (float) (min + this.f11252n), (float) height, this.f11238J[max] ? this.f11247i : this.f11246h);
        }
    }

    /* renamed from: b */
    private void m13849b(Canvas canvas) {
        if (this.f11233E > 0) {
            int a = C2541v.m7164a(this.f11242d.right, this.f11242d.left, this.f11240b.right);
            int centerY = this.f11242d.centerY();
            int i;
            if (this.f11249k == null) {
                if (!this.f11231C) {
                    if (!isFocused()) {
                        i = isEnabled() ? this.f11253o : this.f11254p;
                        canvas.drawCircle((float) a, (float) centerY, (float) (i / 2), this.f11248j);
                    }
                }
                i = this.f11255q;
                canvas.drawCircle((float) a, (float) centerY, (float) (i / 2), this.f11248j);
            } else {
                i = this.f11249k.getIntrinsicWidth() / 2;
                int intrinsicHeight = this.f11249k.getIntrinsicHeight() / 2;
                this.f11249k.setBounds(a - i, centerY - intrinsicHeight, a + i, centerY + intrinsicHeight);
                this.f11249k.draw(canvas);
            }
        }
    }

    /* renamed from: d */
    private void m13853d() {
        if (this.f11249k != null && this.f11249k.isStateful() && this.f11249k.setState(getDrawableState())) {
            invalidate();
        }
    }

    private String getProgressText() {
        return C2541v.m7171a(this.f11258t, this.f11259u, this.f11234F);
    }

    private long getPositionIncrement() {
        if (this.f11263y == -9223372036854775807L) {
            return this.f11233E == -9223372036854775807L ? 0 : this.f11233E / ((long) this.f11262x);
        } else {
            return this.f11263y;
        }
    }

    /* renamed from: a */
    private boolean m13845a(long j) {
        if (this.f11233E <= 0) {
            return false;
        }
        long scrubberPosition = getScrubberPosition();
        this.f11232D = C2541v.m7169a(scrubberPosition + j, 0, this.f11233E);
        if (this.f11232D == scrubberPosition) {
            return false;
        }
        if (this.f11231C == null) {
            m13848b();
        }
        j = this.f11261w.iterator();
        while (j.hasNext()) {
            ((C2581a) j.next()).m7300b(this, this.f11232D);
        }
        m13851c();
        return 1;
    }

    /* renamed from: a */
    private static int m13837a(DisplayMetrics displayMetrics, int i) {
        return (int) ((((float) i) * displayMetrics.density) + 1056964608);
    }

    /* renamed from: a */
    private static boolean m13846a(Drawable drawable, int i) {
        return (C2541v.f6467a < 23 || drawable.setLayoutDirection(i) == null) ? null : true;
    }
}
