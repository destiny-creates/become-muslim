package android.support.p016d.p017a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.support.v4.content.p027b.C0365c;
import android.support.v4.p020a.C0267b;
import android.support.v4.p020a.C0267b.C0266b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimatorInflaterCompat */
/* renamed from: android.support.d.a.e */
public class C0122e {

    /* compiled from: AnimatorInflaterCompat */
    /* renamed from: android.support.d.a.e$a */
    private static class C0121a implements TypeEvaluator<C0266b[]> {
        /* renamed from: a */
        private C0266b[] f265a;

        public /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            return m239a(f, (C0266b[]) obj, (C0266b[]) obj2);
        }

        private C0121a() {
        }

        /* renamed from: a */
        public C0266b[] m239a(float f, C0266b[] c0266bArr, C0266b[] c0266bArr2) {
            if (C0267b.m728a(c0266bArr, c0266bArr2)) {
                if (this.f265a == null || !C0267b.m728a(this.f265a, c0266bArr)) {
                    this.f265a = C0267b.m730a(c0266bArr);
                }
                for (int i = 0; i < c0266bArr.length; i++) {
                    this.f265a[i].m723a(c0266bArr[i], c0266bArr2[i], f);
                }
                return this.f265a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* renamed from: a */
    private static boolean m257a(int i) {
        return i >= 28 && i <= 31;
    }

    /* renamed from: a */
    public static Animator m242a(Context context, int i) {
        if (VERSION.SDK_INT >= 24) {
            return AnimatorInflater.loadAnimator(context, i);
        }
        return C0122e.m243a(context, context.getResources(), context.getTheme(), i);
    }

    /* renamed from: a */
    public static Animator m243a(Context context, Resources resources, Theme theme, int i) {
        return C0122e.m244a(context, resources, theme, i, 1.0f);
    }

    /* renamed from: a */
    public static Animator m244a(Context context, Resources resources, Theme theme, int i, float f) {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlPullParser animation = resources.getAnimation(i);
            try {
                context = C0122e.m245a(context, resources, theme, animation, f);
                if (animation != null) {
                    animation.close();
                }
                return context;
            } catch (XmlPullParserException e) {
                context = e;
                XmlPullParser xmlPullParser = animation;
                theme = new StringBuilder();
                theme.append("Can't load animation resource ID #0x");
                theme.append(Integer.toHexString(i));
                resources = new NotFoundException(theme.toString());
                resources.initCause(context);
                throw resources;
            } catch (IOException e2) {
                context = e2;
                xmlResourceParser = animation;
                theme = new StringBuilder();
                theme.append("Can't load animation resource ID #0x");
                theme.append(Integer.toHexString(i));
                resources = new NotFoundException(theme.toString());
                resources.initCause(context);
                throw resources;
            } catch (Throwable th) {
                context = th;
                xmlResourceParser = animation;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw context;
            }
        } catch (XmlPullParserException e3) {
            context = e3;
            theme = new StringBuilder();
            theme.append("Can't load animation resource ID #0x");
            theme.append(Integer.toHexString(i));
            resources = new NotFoundException(theme.toString());
            resources.initCause(context);
            throw resources;
        } catch (IOException e4) {
            context = e4;
            theme = new StringBuilder();
            theme.append("Can't load animation resource ID #0x");
            theme.append(Integer.toHexString(i));
            resources = new NotFoundException(theme.toString());
            resources.initCause(context);
            throw resources;
        } catch (Throwable th2) {
            context = th2;
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw context;
        }
    }

    /* renamed from: a */
    private static PropertyValuesHolder m251a(TypedArray typedArray, int i, int i2, int i3, String str) {
        TypedValue peekValue = typedArray.peekValue(i2);
        Object obj = peekValue != null ? 1 : null;
        int i4 = obj != null ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        Object obj2 = peekValue2 != null ? 1 : null;
        int i5 = obj2 != null ? peekValue2.type : 0;
        if (i == 4) {
            i = ((obj == null || C0122e.m257a(i4) == 0) && (obj2 == null || C0122e.m257a(i5) == 0)) ? 0 : 3;
        }
        Object obj3 = i == 0 ? 1 : null;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i == 2) {
            i = typedArray.getString(i2);
            typedArray = typedArray.getString(i3);
            C0266b[] b = C0267b.m732b(i);
            C0266b[] b2 = C0267b.m732b(typedArray);
            if (b == 0 && b2 == 0) {
                return null;
            }
            if (b != 0) {
                TypeEvaluator c0121a = new C0121a();
                if (b2 == 0) {
                    typedArray = PropertyValuesHolder.ofObject(str, c0121a, new Object[]{b});
                } else if (C0267b.m728a(b, b2)) {
                    typedArray = PropertyValuesHolder.ofObject(str, c0121a, new Object[]{b, b2});
                } else {
                    i3 = new StringBuilder();
                    i3.append(" Can't morph from ");
                    i3.append(i);
                    i3.append(" to ");
                    i3.append(typedArray);
                    throw new InflateException(i3.toString());
                }
                return typedArray;
            } else if (b2 == null) {
                return null;
            } else {
                return PropertyValuesHolder.ofObject(str, new C0121a(), new Object[]{b2});
            }
        }
        i = i == 3 ? C0123f.m259a() : 0;
        if (obj3 != null) {
            if (obj != null) {
                if (i4 == 5) {
                    i2 = typedArray.getDimension(i2, 0.0f);
                } else {
                    i2 = typedArray.getFloat(i2, 0.0f);
                }
                if (obj2 != null) {
                    if (i5 == 5) {
                        typedArray = typedArray.getDimension(i3, 0.0f);
                    } else {
                        typedArray = typedArray.getFloat(i3, 0.0f);
                    }
                    typedArray = PropertyValuesHolder.ofFloat(str, new float[]{i2, typedArray});
                } else {
                    typedArray = PropertyValuesHolder.ofFloat(str, new float[]{i2});
                }
            } else {
                if (i5 == 5) {
                    typedArray = typedArray.getDimension(i3, 0.0f);
                } else {
                    typedArray = typedArray.getFloat(i3, 0.0f);
                }
                typedArray = PropertyValuesHolder.ofFloat(str, new float[]{typedArray});
            }
            propertyValuesHolder = typedArray;
        } else if (obj != null) {
            if (i4 == 5) {
                i2 = (int) typedArray.getDimension(i2, 0.0f);
            } else if (C0122e.m257a(i4)) {
                i2 = typedArray.getColor(i2, 0);
            } else {
                i2 = typedArray.getInt(i2, 0);
            }
            if (obj2 != null) {
                if (i5 == 5) {
                    typedArray = (int) typedArray.getDimension(i3, 0.0f);
                } else if (C0122e.m257a(i5)) {
                    typedArray = typedArray.getColor(i3, 0);
                } else {
                    typedArray = typedArray.getInt(i3, 0);
                }
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2, typedArray});
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{i2});
            }
        } else if (obj2 != null) {
            if (i5 == 5) {
                typedArray = (int) typedArray.getDimension(i3, 0.0f);
            } else if (C0122e.m257a(i5) != 0) {
                typedArray = typedArray.getColor(i3, 0);
            } else {
                typedArray = typedArray.getInt(i3, 0);
            }
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, new int[]{typedArray});
        }
        if (propertyValuesHolder == null || i == 0) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(i);
        return propertyValuesHolder;
    }

    /* renamed from: a */
    private static void m254a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long a = (long) C0365c.m1095a(typedArray, xmlPullParser, "duration", 1, 300);
        long a2 = (long) C0365c.m1095a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int a3 = C0365c.m1095a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (C0365c.m1099a(xmlPullParser, "valueFrom") && C0365c.m1099a(xmlPullParser, "valueTo")) {
            if (a3 == 4) {
                a3 = C0122e.m241a(typedArray, 5, 6);
            }
            if (C0122e.m251a(typedArray, a3, 5, 6, "") != null) {
                valueAnimator.setValues(new PropertyValuesHolder[]{C0122e.m251a(typedArray, a3, 5, 6, "")});
            }
        }
        valueAnimator.setDuration(a);
        valueAnimator.setStartDelay(a2);
        valueAnimator.setRepeatCount(C0365c.m1095a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(C0365c.m1095a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            C0122e.m253a(valueAnimator, typedArray2, a3, f, xmlPullParser);
        }
    }

    /* renamed from: a */
    private static void m253a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String a = C0365c.m1097a(typedArray, xmlPullParser, "pathData", 1);
        if (a != null) {
            String a2 = C0365c.m1097a(typedArray, xmlPullParser, "propertyXName", 2);
            String a3 = C0365c.m1097a(typedArray, xmlPullParser, "propertyYName", 3);
            if (i != 2) {
            }
            if (a2 == null) {
                if (a3 == null) {
                    i = new StringBuilder();
                    i.append(typedArray.getPositionDescription());
                    i.append(" propertyXName or propertyYName is needed for PathData");
                    throw new InflateException(i.toString());
                }
            }
            C0122e.m255a(C0267b.m725a(a), objectAnimator, f * 1056964608, a2, a3);
            return;
        }
        objectAnimator.setPropertyName(C0365c.m1097a(typedArray, xmlPullParser, "propertyName", (int) 0.0f));
    }

    /* renamed from: a */
    private static void m255a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        Path path2 = path;
        ObjectAnimator objectAnimator2 = objectAnimator;
        String str3 = str;
        String str4 = str2;
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float f2 = 0.0f;
        do {
            f2 += pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
        } while (pathMeasure.nextContour());
        pathMeasure = new PathMeasure(path2, false);
        int min = Math.min(100, ((int) (f2 / f)) + 1);
        float[] fArr = new float[min];
        float[] fArr2 = new float[min];
        float[] fArr3 = new float[2];
        f2 /= (float) (min - 1);
        int i2 = 0;
        float f3 = 0.0f;
        int i3 = 0;
        while (true) {
            float[] fArr4 = null;
            if (i2 >= min) {
                break;
            }
            pathMeasure.getPosTan(f3, fArr3, null);
            fArr[i2] = fArr3[i];
            fArr2[i2] = fArr3[1];
            f3 += f2;
            int i4 = i3 + 1;
            if (i4 < arrayList.size() && f3 > ((Float) arrayList.get(i4)).floatValue()) {
                f3 -= ((Float) arrayList.get(i4)).floatValue();
                pathMeasure.nextContour();
                i3 = i4;
            }
            i2++;
            i = 0;
        }
        PropertyValuesHolder ofFloat = str3 != null ? PropertyValuesHolder.ofFloat(str3, fArr) : null;
        if (str4 != null) {
            fArr4 = PropertyValuesHolder.ofFloat(str4, fArr2);
        }
        if (ofFloat == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{fArr4});
        } else if (fArr4 == null) {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat});
        } else {
            objectAnimator2.setValues(new PropertyValuesHolder[]{ofFloat, fArr4});
        }
    }

    /* renamed from: a */
    private static Animator m245a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, float f) {
        return C0122e.m246a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* renamed from: a */
    private static Animator m246a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) {
        Resources resources2 = resources;
        Theme theme2 = theme;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AnimatorSet animatorSet2 = animatorSet;
        int depth = xmlPullParser.getDepth();
        Animator animator = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i2 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    Context context2;
                    String name = xmlPullParser.getName();
                    if (name.equals("objectAnimator")) {
                        animator = C0122e.m249a(context, resources, theme, attributeSet, f, xmlPullParser);
                    } else if (name.equals("animator")) {
                        animator = C0122e.m252a(context, resources, theme, attributeSet, null, f, xmlPullParser);
                    } else {
                        if (name.equals("set")) {
                            Animator animatorSet3 = new AnimatorSet();
                            TypedArray a = C0365c.m1096a(resources2, theme2, attributeSet, C0114a.f253h);
                            Context context3 = context;
                            Resources resources3 = resources;
                            Theme theme3 = theme;
                            XmlPullParser xmlPullParser3 = xmlPullParser;
                            AttributeSet attributeSet2 = attributeSet;
                            TypedArray typedArray = a;
                            C0122e.m246a(context3, resources3, theme3, xmlPullParser3, attributeSet2, (AnimatorSet) animatorSet3, C0365c.m1095a(a, xmlPullParser2, "ordering", 0, 0), f);
                            typedArray.recycle();
                            context2 = context;
                            animator = animatorSet3;
                        } else if (name.equals("propertyValuesHolder")) {
                            PropertyValuesHolder[] a2 = C0122e.m258a(context, resources2, theme2, xmlPullParser2, Xml.asAttributeSet(xmlPullParser));
                            if (!(a2 == null || animator == null || !(animator instanceof ValueAnimator))) {
                                ((ValueAnimator) animator).setValues(a2);
                            }
                            i2 = 1;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown animator name: ");
                            stringBuilder.append(xmlPullParser.getName());
                            throw new RuntimeException(stringBuilder.toString());
                        }
                        if (animatorSet2 != null && r14 == 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(animator);
                        }
                    }
                    context2 = context;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(animator);
                }
            }
        }
        if (!(animatorSet2 == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int i3 = i2 + 1;
                animatorArr[i2] = (Animator) it.next();
                i2 = i3;
            }
            if (i == 0) {
                animatorSet2.playTogether(animatorArr);
            } else {
                animatorSet2.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    /* renamed from: a */
    private static PropertyValuesHolder[] m258a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            int i = 0;
            if (eventType == 3 || eventType == 1) {
                if (arrayList != null) {
                    eventType = arrayList.size();
                    propertyValuesHolderArr = new PropertyValuesHolder[eventType];
                    while (i < eventType) {
                        propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
                        i++;
                    }
                }
            } else if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray a = C0365c.m1096a(resources, theme, attributeSet, C0114a.f254i);
                    String a2 = C0365c.m1097a(a, xmlPullParser2, "propertyName", 3);
                    int a3 = C0365c.m1095a(a, xmlPullParser2, "valueType", 2, 4);
                    int i2 = a3;
                    Object a4 = C0122e.m250a(context, resources, theme, xmlPullParser, a2, a3);
                    if (a4 == null) {
                        a4 = C0122e.m251a(a, i2, 0, 1, a2);
                    }
                    if (a4 != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(a4);
                    }
                    a.recycle();
                } else {
                    Resources resources2 = resources;
                    Theme theme2 = theme;
                    AttributeSet attributeSet2 = attributeSet;
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            eventType = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[eventType];
            while (i < eventType) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
                i++;
            }
        }
        return propertyValuesHolderArr;
    }

    /* renamed from: a */
    private static int m240a(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        resources = C0365c.m1096a(resources, theme, attributeSet, C0114a.f255j);
        attributeSet = null;
        theme = C0365c.m1101b(resources, xmlPullParser, "value", 0);
        if (!((theme != null ? true : null) == null || C0122e.m257a(theme.type) == null)) {
            attributeSet = 3;
        }
        resources.recycle();
        return attributeSet;
    }

    /* renamed from: a */
    private static int m241a(TypedArray typedArray, int i, int i2) {
        i = typedArray.peekValue(i);
        Object obj = 1;
        Object obj2 = i != 0 ? 1 : null;
        i = obj2 != null ? i.type : 0;
        typedArray = typedArray.peekValue(i2);
        if (typedArray == null) {
            obj = null;
        }
        typedArray = obj != null ? typedArray.type : null;
        if ((obj2 == null || C0122e.m257a(i) == 0) && (obj == null || C0122e.m257a(typedArray) == null)) {
            return 0;
        }
        return 3;
    }

    /* renamed from: a */
    private static PropertyValuesHolder m250a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser, String str, int i) {
        int i2;
        float fraction;
        Keyframe[] keyframeArr;
        PropertyValuesHolder propertyValuesHolder = null;
        int i3 = i;
        i = 0;
        while (true) {
            Object size;
            Keyframe keyframe;
            Keyframe keyframe2;
            int i4;
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                if (i != 0) {
                    size = i.size();
                    if (size > null) {
                        i2 = null;
                        keyframe = (Keyframe) i.get(0);
                        keyframe2 = (Keyframe) i.get(size - 1);
                        fraction = keyframe2.getFraction();
                        if (fraction < 1.0f) {
                            if (fraction >= 0.0f) {
                                keyframe2.setFraction(1.0f);
                            } else {
                                i.add(i.size(), C0122e.m247a(keyframe2, 1.0f));
                                size++;
                            }
                        }
                        xmlPullParser = keyframe.getFraction();
                        if (xmlPullParser != null) {
                            if (xmlPullParser >= null) {
                                keyframe.setFraction(0.0f);
                            } else {
                                i.add(0, C0122e.m247a(keyframe, 0.0f));
                                size++;
                            }
                        }
                        keyframeArr = new Keyframe[size];
                        i.toArray(keyframeArr);
                        while (i2 < size) {
                            xmlPullParser = keyframeArr[i2];
                            if (xmlPullParser.getFraction() >= 0) {
                                if (i2 != null) {
                                    xmlPullParser.setFraction(0.0f);
                                } else {
                                    i = size - 1;
                                    if (i2 != i) {
                                        xmlPullParser.setFraction(1.0f);
                                    } else {
                                        i4 = i2;
                                        for (xmlPullParser = i2 + 1; xmlPullParser < i; xmlPullParser++) {
                                            if (keyframeArr[xmlPullParser].getFraction() >= 0.0f) {
                                                break;
                                            }
                                            i4 = xmlPullParser;
                                        }
                                        C0122e.m256a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                                    }
                                }
                            }
                            i2++;
                        }
                        propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                        if (i3 == 3) {
                            propertyValuesHolder.setEvaluator(C0123f.m259a());
                        }
                    }
                }
            } else if (xmlPullParser.getName().equals("keyframe")) {
                if (i3 == 4) {
                    i3 = C0122e.m240a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe a = C0122e.m248a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i3, xmlPullParser);
                if (a != null) {
                    if (i == 0) {
                        i = new ArrayList();
                    }
                    i.add(a);
                }
                xmlPullParser.next();
            }
        }
        if (i != 0) {
            size = i.size();
            if (size > null) {
                i2 = null;
                keyframe = (Keyframe) i.get(0);
                keyframe2 = (Keyframe) i.get(size - 1);
                fraction = keyframe2.getFraction();
                if (fraction < 1.0f) {
                    if (fraction >= 0.0f) {
                        i.add(i.size(), C0122e.m247a(keyframe2, 1.0f));
                        size++;
                    } else {
                        keyframe2.setFraction(1.0f);
                    }
                }
                xmlPullParser = keyframe.getFraction();
                if (xmlPullParser != null) {
                    if (xmlPullParser >= null) {
                        i.add(0, C0122e.m247a(keyframe, 0.0f));
                        size++;
                    } else {
                        keyframe.setFraction(0.0f);
                    }
                }
                keyframeArr = new Keyframe[size];
                i.toArray(keyframeArr);
                while (i2 < size) {
                    xmlPullParser = keyframeArr[i2];
                    if (xmlPullParser.getFraction() >= 0) {
                        if (i2 != null) {
                            i = size - 1;
                            if (i2 != i) {
                                i4 = i2;
                                for (xmlPullParser = i2 + 1; xmlPullParser < i; xmlPullParser++) {
                                    if (keyframeArr[xmlPullParser].getFraction() >= 0.0f) {
                                        break;
                                    }
                                    i4 = xmlPullParser;
                                }
                                C0122e.m256a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                            } else {
                                xmlPullParser.setFraction(1.0f);
                            }
                        } else {
                            xmlPullParser.setFraction(0.0f);
                        }
                    }
                    i2++;
                }
                propertyValuesHolder = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
                if (i3 == 3) {
                    propertyValuesHolder.setEvaluator(C0123f.m259a());
                }
            }
        }
        return propertyValuesHolder;
    }

    /* renamed from: a */
    private static Keyframe m247a(Keyframe keyframe, float f) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f);
        }
        if (keyframe.getType() == Integer.TYPE) {
            return Keyframe.ofInt(f);
        }
        return Keyframe.ofObject(f);
    }

    /* renamed from: a */
    private static void m256a(Keyframe[] keyframeArr, float f, int i, int i2) {
        f /= (float) ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f);
            i++;
        }
    }

    /* renamed from: a */
    private static Keyframe m248a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        TypedArray a = C0365c.m1096a(resources, theme, attributeSet, C0114a.f255j);
        theme = C0365c.m1094a(a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue b = C0365c.m1101b(a, xmlPullParser, "value", 0);
        Object obj = b != null ? 1 : null;
        if (i == 4) {
            i = (obj == null || C0122e.m257a(b.type) == 0) ? 0 : 3;
        }
        if (obj != null) {
            if (i != 3) {
                switch (i) {
                    case 0:
                        theme = Keyframe.ofFloat(theme, C0365c.m1094a(a, xmlPullParser, "value", 0, 0.0f));
                        break;
                    case 1:
                        break;
                    default:
                        theme = null;
                        break;
                }
            }
            theme = Keyframe.ofInt(theme, C0365c.m1095a(a, xmlPullParser, "value", 0, 0));
        } else if (i == 0) {
            theme = Keyframe.ofFloat(theme);
        } else {
            theme = Keyframe.ofInt(theme);
        }
        attributeSet = C0365c.m1102c(a, xmlPullParser, "interpolator", 1, 0);
        if (attributeSet > null) {
            theme.setInterpolator(C0119d.m237a(context, attributeSet));
        }
        a.recycle();
        return theme;
    }

    /* renamed from: a */
    private static ObjectAnimator m249a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ValueAnimator objectAnimator = new ObjectAnimator();
        C0122e.m252a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* renamed from: a */
    private static ValueAnimator m252a(Context context, Resources resources, Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray a = C0365c.m1096a(resources, theme, attributeSet, C0114a.f252g);
        TypedArray a2 = C0365c.m1096a(resources, theme, attributeSet, C0114a.f256k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        C0122e.m254a(valueAnimator, a, a2, f, xmlPullParser);
        theme = C0365c.m1102c(a, xmlPullParser, "interpolator", 0, 0);
        if (theme > null) {
            valueAnimator.setInterpolator(C0119d.m237a(context, theme));
        }
        a.recycle();
        if (a2 != null) {
            a2.recycle();
        }
        return valueAnimator;
    }
}
