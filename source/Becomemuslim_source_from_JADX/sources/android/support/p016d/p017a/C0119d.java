package android.support.p016d.p017a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.support.v4.view.p034b.C3219a;
import android.support.v4.view.p034b.C3220b;
import android.support.v4.view.p034b.C3221c;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: AnimationUtilsCompat */
/* renamed from: android.support.d.a.d */
public class C0119d {
    /* renamed from: a */
    public static Interpolator m237a(Context context, int i) {
        StringBuilder stringBuilder;
        NotFoundException notFoundException;
        if (VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        XmlResourceParser xmlResourceParser = null;
        if (i == 17563663) {
            try {
                return new C3219a();
            } catch (XmlPullParserException e) {
                context = e;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString(i));
                notFoundException = new NotFoundException(stringBuilder.toString());
                notFoundException.initCause(context);
                throw notFoundException;
            } catch (IOException e2) {
                context = e2;
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Can't load animation resource ID #0x");
                    stringBuilder.append(Integer.toHexString(i));
                    notFoundException = new NotFoundException(stringBuilder.toString());
                    notFoundException.initCause(context);
                    throw notFoundException;
                } catch (Throwable th) {
                    context = th;
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw context;
                }
            }
        } else if (i == 17563661) {
            return new C3220b();
        } else {
            if (i == 17563662) {
                return new C3221c();
            }
            XmlResourceParser animation = context.getResources().getAnimation(i);
            try {
                context = C0119d.m238a(context, context.getResources(), context.getTheme(), animation);
                if (animation != null) {
                    animation.close();
                }
                return context;
            } catch (XmlPullParserException e3) {
                context = e3;
                xmlResourceParser = animation;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString(i));
                notFoundException = new NotFoundException(stringBuilder.toString());
                notFoundException.initCause(context);
                throw notFoundException;
            } catch (IOException e4) {
                context = e4;
                xmlResourceParser = animation;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Can't load animation resource ID #0x");
                stringBuilder.append(Integer.toHexString(i));
                notFoundException = new NotFoundException(stringBuilder.toString());
                notFoundException.initCause(context);
                throw notFoundException;
            } catch (Throwable th2) {
                context = th2;
                xmlResourceParser = animation;
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
                throw context;
            }
        }
    }

    /* renamed from: a */
    private static Interpolator m238a(Context context, Resources resources, Theme theme, XmlPullParser xmlPullParser) {
        resources = xmlPullParser.getDepth();
        theme = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > resources) && next != 1) {
                if (next == 2) {
                    theme = Xml.asAttributeSet(xmlPullParser);
                    String name = xmlPullParser.getName();
                    if (name.equals("linearInterpolator")) {
                        theme = new LinearInterpolator();
                    } else {
                        AccelerateInterpolator accelerateInterpolator;
                        if (name.equals("accelerateInterpolator")) {
                            accelerateInterpolator = new AccelerateInterpolator(context, theme);
                        } else if (name.equals("decelerateInterpolator")) {
                            accelerateInterpolator = new DecelerateInterpolator(context, theme);
                        } else if (name.equals("accelerateDecelerateInterpolator")) {
                            theme = new AccelerateDecelerateInterpolator();
                        } else if (name.equals("cycleInterpolator")) {
                            accelerateInterpolator = new CycleInterpolator(context, theme);
                        } else if (name.equals("anticipateInterpolator")) {
                            accelerateInterpolator = new AnticipateInterpolator(context, theme);
                        } else if (name.equals("overshootInterpolator")) {
                            accelerateInterpolator = new OvershootInterpolator(context, theme);
                        } else if (name.equals("anticipateOvershootInterpolator")) {
                            accelerateInterpolator = new AnticipateOvershootInterpolator(context, theme);
                        } else if (name.equals("bounceInterpolator")) {
                            theme = new BounceInterpolator();
                        } else if (name.equals("pathInterpolator")) {
                            accelerateInterpolator = new C0124g(context, theme, xmlPullParser);
                        } else {
                            resources = new StringBuilder();
                            resources.append("Unknown interpolator name: ");
                            resources.append(xmlPullParser.getName());
                            throw new RuntimeException(resources.toString());
                        }
                        theme = accelerateInterpolator;
                    }
                }
            }
        }
        return theme;
    }
}
