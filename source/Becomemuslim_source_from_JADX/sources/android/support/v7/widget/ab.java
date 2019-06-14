package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.p035a.C0591a.C0590j;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.facebook.common.util.ByteConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper */
class ab {
    /* renamed from: a */
    private static final RectF f1919a = new RectF();
    /* renamed from: b */
    private static ConcurrentHashMap<String, Method> f1920b = new ConcurrentHashMap();
    /* renamed from: c */
    private int f1921c = 0;
    /* renamed from: d */
    private boolean f1922d = false;
    /* renamed from: e */
    private float f1923e = -1.0f;
    /* renamed from: f */
    private float f1924f = -1.0f;
    /* renamed from: g */
    private float f1925g = -1.0f;
    /* renamed from: h */
    private int[] f1926h = new int[0];
    /* renamed from: i */
    private boolean f1927i = false;
    /* renamed from: j */
    private TextPaint f1928j;
    /* renamed from: k */
    private final TextView f1929k;
    /* renamed from: l */
    private final Context f1930l;

    ab(TextView textView) {
        this.f1929k = textView;
        this.f1930l = this.f1929k.getContext();
    }

    /* renamed from: a */
    void m2504a(AttributeSet attributeSet, int i) {
        attributeSet = this.f1930l.obtainStyledAttributes(attributeSet, C0590j.AppCompatTextView, i, 0);
        if (attributeSet.hasValue(C0590j.AppCompatTextView_autoSizeTextType) != 0) {
            this.f1921c = attributeSet.getInt(C0590j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = attributeSet.hasValue(C0590j.AppCompatTextView_autoSizeStepGranularity) != 0 ? attributeSet.getDimension(C0590j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1082130432;
        float dimension2 = attributeSet.hasValue(C0590j.AppCompatTextView_autoSizeMinTextSize) ? attributeSet.getDimension(C0590j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = attributeSet.hasValue(C0590j.AppCompatTextView_autoSizeMaxTextSize) ? attributeSet.getDimension(C0590j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (attributeSet.hasValue(C0590j.AppCompatTextView_autoSizePresetSizes)) {
            int resourceId = attributeSet.getResourceId(C0590j.AppCompatTextView_autoSizePresetSizes, 0);
            if (resourceId > 0) {
                TypedArray obtainTypedArray = attributeSet.getResources().obtainTypedArray(resourceId);
                m2493a(obtainTypedArray);
                obtainTypedArray.recycle();
            }
        }
        attributeSet.recycle();
        if (m2499k() == null) {
            this.f1921c = 0;
        } else if (this.f1921c == 1) {
            if (this.f1927i == null) {
                attributeSet = this.f1930l.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, attributeSet);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, attributeSet);
                }
                if (dimension == -1082130432) {
                    dimension = 1065353216;
                }
                m2492a(dimension2, dimension3, dimension);
            }
            m2497i();
        }
    }

    /* renamed from: a */
    void m2501a(int i) {
        if (m2499k()) {
            switch (i) {
                case 0:
                    m2498j();
                    return;
                case 1:
                    i = this.f1930l.getResources().getDisplayMetrics();
                    m2492a(TypedValue.applyDimension(2, 12.0f, i), TypedValue.applyDimension(2, 112.0f, i), 1.0f);
                    if (m2497i() != 0) {
                        m2510f();
                        return;
                    }
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown auto-size text type: ");
                    stringBuilder.append(i);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    void m2503a(int i, int i2, int i3, int i4) {
        if (m2499k()) {
            DisplayMetrics displayMetrics = this.f1930l.getResources().getDisplayMetrics();
            m2492a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (m2497i() != 0) {
                m2510f();
            }
        }
    }

    /* renamed from: a */
    void m2505a(int[] iArr, int i) {
        if (m2499k()) {
            int length = iArr.length;
            int i2 = 0;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1930l.getResources().getDisplayMetrics();
                    while (i2 < length) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                        i2++;
                    }
                }
                this.f1926h = m2495a(iArr2);
                if (m2496h() == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("None of the preset sizes is valid: ");
                    stringBuilder.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            } else {
                this.f1927i = false;
            }
            if (m2497i() != null) {
                m2510f();
            }
        }
    }

    /* renamed from: a */
    int m2500a() {
        return this.f1921c;
    }

    /* renamed from: b */
    int m2506b() {
        return Math.round(this.f1923e);
    }

    /* renamed from: c */
    int m2507c() {
        return Math.round(this.f1924f);
    }

    /* renamed from: d */
    int m2508d() {
        return Math.round(this.f1925g);
    }

    /* renamed from: e */
    int[] m2509e() {
        return this.f1926h;
    }

    /* renamed from: a */
    private void m2493a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f1926h = m2495a(iArr);
            m2496h();
        }
    }

    /* renamed from: h */
    private boolean m2496h() {
        int length = this.f1926h.length;
        this.f1927i = length > 0;
        if (this.f1927i) {
            this.f1921c = 1;
            this.f1924f = (float) this.f1926h[0];
            this.f1925g = (float) this.f1926h[length - 1];
            this.f1923e = -1.0f;
        }
        return this.f1927i;
    }

    /* renamed from: a */
    private int[] m2495a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        List arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        iArr = arrayList.size();
        int[] iArr2 = new int[iArr];
        for (int i2 = 0; i2 < iArr; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: a */
    private void m2492a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            f3 = new StringBuilder();
            f3.append("Minimum auto-size text size (");
            f3.append(f);
            f3.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(f3.toString());
        } else if (f2 <= f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Maximum auto-size text size (");
            stringBuilder.append(f2);
            stringBuilder.append("px) is less or equal to minimum auto-size ");
            stringBuilder.append("text size (");
            stringBuilder.append(f);
            stringBuilder.append("px)");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (f3 > 0.0f) {
            this.f1921c = 1;
            this.f1924f = f;
            this.f1925g = f2;
            this.f1923e = f3;
            this.f1927i = false;
        } else {
            f2 = new StringBuilder();
            f2.append("The auto-size step granularity (");
            f2.append(f3);
            f2.append("px) is less or equal to (0px)");
            throw new IllegalArgumentException(f2.toString());
        }
    }

    /* renamed from: i */
    private boolean m2497i() {
        int i = 0;
        if (m2499k() && this.f1921c == 1) {
            if (!this.f1927i || this.f1926h.length == 0) {
                float round = (float) Math.round(this.f1924f);
                int i2 = 1;
                while (Math.round(this.f1923e + round) <= Math.round(this.f1925g)) {
                    i2++;
                    round += this.f1923e;
                }
                int[] iArr = new int[i2];
                float f = this.f1924f;
                while (i < i2) {
                    iArr[i] = Math.round(f);
                    f += this.f1923e;
                    i++;
                }
                this.f1926h = m2495a(iArr);
            }
            this.f1922d = true;
        } else {
            this.f1922d = false;
        }
        return this.f1922d;
    }

    /* renamed from: f */
    void m2510f() {
        if (m2511g()) {
            if (this.f1922d) {
                if (this.f1929k.getMeasuredHeight() > 0) {
                    if (this.f1929k.getMeasuredWidth() > 0) {
                        int i;
                        if (((Boolean) m2489a(this.f1929k, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
                            i = ByteConstants.MB;
                        } else {
                            i = (this.f1929k.getMeasuredWidth() - this.f1929k.getTotalPaddingLeft()) - this.f1929k.getTotalPaddingRight();
                        }
                        int height = (this.f1929k.getHeight() - this.f1929k.getCompoundPaddingBottom()) - this.f1929k.getCompoundPaddingTop();
                        if (i > 0) {
                            if (height > 0) {
                                synchronized (f1919a) {
                                    f1919a.setEmpty();
                                    f1919a.right = (float) i;
                                    f1919a.bottom = (float) height;
                                    float a = (float) m2486a(f1919a);
                                    if (a != this.f1929k.getTextSize()) {
                                        m2502a(0, a);
                                    }
                                }
                            }
                        }
                        return;
                    }
                }
                return;
            }
            this.f1922d = true;
        }
    }

    /* renamed from: j */
    private void m2498j() {
        this.f1921c = 0;
        this.f1924f = -1.0f;
        this.f1925g = -1.0f;
        this.f1923e = -1.0f;
        this.f1926h = new int[0];
        this.f1922d = false;
    }

    /* renamed from: a */
    void m2502a(int i, float f) {
        Resources system;
        if (this.f1930l == null) {
            system = Resources.getSystem();
        } else {
            system = this.f1930l.getResources();
        }
        m2491a(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    /* renamed from: a */
    private void m2491a(float f) {
        if (f != this.f1929k.getPaint().getTextSize()) {
            this.f1929k.getPaint().setTextSize(f);
            f = VERSION.SDK_INT >= 18 ? this.f1929k.isInLayout() : 0.0f;
            if (this.f1929k.getLayout() != null) {
                this.f1922d = false;
                try {
                    Method a = m2490a("nullLayouts");
                    if (a != null) {
                        a.invoke(this.f1929k, new Object[0]);
                    }
                } catch (Throwable e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (f == null) {
                    this.f1929k.requestLayout();
                } else {
                    this.f1929k.forceLayout();
                }
                this.f1929k.invalidate();
            }
        }
    }

    /* renamed from: a */
    private int m2486a(RectF rectF) {
        int length = this.f1926h.length;
        if (length != 0) {
            length--;
            int i = 1;
            int i2 = 0;
            while (i <= length) {
                i2 = (i + length) / 2;
                if (m2494a(this.f1926h[i2], rectF)) {
                    int i3 = i2 + 1;
                    i2 = i;
                    i = i3;
                } else {
                    i2--;
                    length = i2;
                }
            }
            return this.f1926h[i2];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m2494a(int r6, android.graphics.RectF r7) {
        /*
        r5 = this;
        r0 = r5.f1929k;
        r0 = r0.getText();
        r1 = r5.f1929k;
        r1 = r1.getTransformationMethod();
        if (r1 == 0) goto L_0x0017;
    L_0x000e:
        r2 = r5.f1929k;
        r1 = r1.getTransformation(r0, r2);
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        r0 = r1;
    L_0x0017:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 16;
        r3 = -1;
        if (r1 < r2) goto L_0x0025;
    L_0x001e:
        r1 = r5.f1929k;
        r1 = r1.getMaxLines();
        goto L_0x0026;
    L_0x0025:
        r1 = -1;
    L_0x0026:
        r2 = r5.f1928j;
        if (r2 != 0) goto L_0x0032;
    L_0x002a:
        r2 = new android.text.TextPaint;
        r2.<init>();
        r5.f1928j = r2;
        goto L_0x0037;
    L_0x0032:
        r2 = r5.f1928j;
        r2.reset();
    L_0x0037:
        r2 = r5.f1928j;
        r4 = r5.f1929k;
        r4 = r4.getPaint();
        r2.set(r4);
        r2 = r5.f1928j;
        r6 = (float) r6;
        r2.setTextSize(r6);
        r6 = r5.f1929k;
        r2 = "getLayoutAlignment";
        r4 = android.text.Layout.Alignment.ALIGN_NORMAL;
        r6 = r5.m2489a(r6, r2, r4);
        r6 = (android.text.Layout.Alignment) r6;
        r2 = android.os.Build.VERSION.SDK_INT;
        r4 = 23;
        if (r2 < r4) goto L_0x0065;
    L_0x005a:
        r2 = r7.right;
        r2 = java.lang.Math.round(r2);
        r6 = r5.m2488a(r0, r6, r2, r1);
        goto L_0x006f;
    L_0x0065:
        r2 = r7.right;
        r2 = java.lang.Math.round(r2);
        r6 = r5.m2487a(r0, r6, r2);
    L_0x006f:
        r2 = 0;
        r4 = 1;
        if (r1 == r3) goto L_0x0089;
    L_0x0073:
        r3 = r6.getLineCount();
        if (r3 > r1) goto L_0x0088;
    L_0x0079:
        r1 = r6.getLineCount();
        r1 = r1 - r4;
        r1 = r6.getLineEnd(r1);
        r0 = r0.length();
        if (r1 == r0) goto L_0x0089;
    L_0x0088:
        return r2;
    L_0x0089:
        r6 = r6.getHeight();
        r6 = (float) r6;
        r7 = r7.bottom;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 <= 0) goto L_0x0095;
    L_0x0094:
        return r2;
    L_0x0095:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ab.a(int, android.graphics.RectF):boolean");
    }

    /* renamed from: a */
    private StaticLayout m2488a(CharSequence charSequence, Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) m2489a(this.f1929k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        charSequence = Builder.obtain(charSequence, 0, charSequence.length(), this.f1928j, i).setAlignment(alignment).setLineSpacing(this.f1929k.getLineSpacingExtra(), this.f1929k.getLineSpacingMultiplier()).setIncludePad(this.f1929k.getIncludeFontPadding()).setBreakStrategy(this.f1929k.getBreakStrategy()).setHyphenationFrequency(this.f1929k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return charSequence.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    /* renamed from: a */
    private StaticLayout m2487a(CharSequence charSequence, Alignment alignment, int i) {
        float lineSpacingMultiplier;
        float lineSpacingExtra;
        boolean includeFontPadding;
        if (VERSION.SDK_INT >= 16) {
            lineSpacingMultiplier = this.f1929k.getLineSpacingMultiplier();
            lineSpacingExtra = this.f1929k.getLineSpacingExtra();
            includeFontPadding = this.f1929k.getIncludeFontPadding();
        } else {
            lineSpacingMultiplier = ((Float) m2489a(this.f1929k, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            lineSpacingExtra = ((Float) m2489a(this.f1929k, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            includeFontPadding = ((Boolean) m2489a(this.f1929k, "getIncludeFontPadding", Boolean.valueOf(true))).booleanValue();
        }
        return new StaticLayout(charSequence, this.f1928j, i, alignment, lineSpacingMultiplier, lineSpacingExtra, includeFontPadding);
    }

    /* renamed from: a */
    private <T> T m2489a(Object obj, String str, T t) {
        try {
            return m2490a(str).invoke(obj, new Object[0]);
        } catch (Object obj2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to invoke TextView#");
            stringBuilder.append(str);
            stringBuilder.append("() method");
            Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), obj2);
            return t;
        }
    }

    /* renamed from: a */
    private Method m2490a(String str) {
        try {
            Method method = (Method) f1920b.get(str);
            if (method == null) {
                method = TextView.class.getDeclaredMethod(str, new Class[0]);
                if (method != null) {
                    method.setAccessible(true);
                    f1920b.put(str, method);
                }
            }
            return method;
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to retrieve TextView#");
            stringBuilder.append(str);
            stringBuilder.append("() method");
            Log.w("ACTVAutoSizeHelper", stringBuilder.toString(), e);
            return null;
        }
    }

    /* renamed from: g */
    boolean m2511g() {
        return m2499k() && this.f1921c != 0;
    }

    /* renamed from: k */
    private boolean m2499k() {
        return !(this.f1929k instanceof C3326n);
    }
}
