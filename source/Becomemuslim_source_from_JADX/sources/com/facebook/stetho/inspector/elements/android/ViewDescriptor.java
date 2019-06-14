package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.FlagToString;
import android.view.ViewDebug.IntToString;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.Descriptor;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.helper.IntegerFormatter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

final class ViewDescriptor extends AbstractChainedDescriptor<View> implements HighlightableDescriptor {
    private static final String ID_NAME = "id";
    private static final String NONE_MAPPING = "<no mapping>";
    private static final String NONE_VALUE = "(none)";
    private final MethodInvoker mMethodInvoker;
    private volatile List<ViewCSSProperty> mViewProperties;
    private Pattern mWordBoundaryPattern;

    /* renamed from: com.facebook.stetho.inspector.elements.android.ViewDescriptor$1 */
    class C20651 implements Comparator<ViewCSSProperty> {
        C20651() {
        }

        public int compare(ViewCSSProperty viewCSSProperty, ViewCSSProperty viewCSSProperty2) {
            return viewCSSProperty.getCSSName().compareTo(viewCSSProperty2.getCSSName());
        }
    }

    private abstract class ViewCSSProperty {
        private final ExportedProperty mAnnotation;
        private final String mCSSName;

        public abstract Object getValue(View view);

        public ViewCSSProperty(String str, ExportedProperty exportedProperty) {
            this.mCSSName = str;
            this.mAnnotation = exportedProperty;
        }

        public final String getCSSName() {
            return this.mCSSName;
        }

        public final ExportedProperty getAnnotation() {
            return this.mAnnotation;
        }
    }

    private final class FieldBackedCSSProperty extends ViewCSSProperty {
        private final Field mField;

        public FieldBackedCSSProperty(Field field, String str, ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mField = field;
            this.mField.setAccessible(true);
        }

        public Object getValue(View view) {
            return this.mField.get(view);
        }
    }

    private final class MethodBackedCSSProperty extends ViewCSSProperty {
        private final Method mMethod;

        public MethodBackedCSSProperty(Method method, String str, ExportedProperty exportedProperty) {
            super(str, exportedProperty);
            this.mMethod = method;
            this.mMethod.setAccessible(true);
        }

        public Object getValue(View view) {
            return this.mMethod.invoke(view, new Object[0]);
        }
    }

    private Pattern getWordBoundaryPattern() {
        if (this.mWordBoundaryPattern == null) {
            this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})");
        }
        return this.mWordBoundaryPattern;
    }

    private List<ViewCSSProperty> getViewProperties() {
        if (this.mViewProperties == null) {
            synchronized (this) {
                if (this.mViewProperties == null) {
                    List arrayList = new ArrayList();
                    for (Method method : View.class.getDeclaredMethods()) {
                        ExportedProperty exportedProperty = (ExportedProperty) method.getAnnotation(ExportedProperty.class);
                        if (exportedProperty != null) {
                            arrayList.add(new MethodBackedCSSProperty(method, convertViewPropertyNameToCSSName(method.getName()), exportedProperty));
                        }
                    }
                    for (Field field : View.class.getDeclaredFields()) {
                        ExportedProperty exportedProperty2 = (ExportedProperty) field.getAnnotation(ExportedProperty.class);
                        if (exportedProperty2 != null) {
                            arrayList.add(new FieldBackedCSSProperty(field, convertViewPropertyNameToCSSName(field.getName()), exportedProperty2));
                        }
                    }
                    Collections.sort(arrayList, new C20651());
                    this.mViewProperties = Collections.unmodifiableList(arrayList);
                }
            }
        }
        return this.mViewProperties;
    }

    public ViewDescriptor() {
        this(new MethodInvoker());
    }

    public ViewDescriptor(MethodInvoker methodInvoker) {
        this.mMethodInvoker = methodInvoker;
    }

    protected String onGetNodeName(View view) {
        view = view.getClass().getName();
        return StringUtil.removePrefix(view, "android.view.", StringUtil.removePrefix(view, "android.widget."));
    }

    protected void onGetAttributes(View view, AttributeAccumulator attributeAccumulator) {
        view = getIdAttribute(view);
        if (view != null) {
            attributeAccumulator.store("id", view);
        }
    }

    protected void onSetAttributesAsText(View view, String str) {
        for (Entry entry : Descriptor.parseSetAttributesAsTextArg(str).entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("set");
            stringBuilder.append(capitalize((String) entry.getKey()));
            this.mMethodInvoker.invoke(view, stringBuilder.toString(), (String) entry.getValue());
        }
    }

    private static String getIdAttribute(View view) {
        int id = view.getId();
        if (id == -1) {
            return null;
        }
        return ResourcesUtil.getIdStringQuietly(view, view.getResources(), id);
    }

    public View getViewForHighlighting(Object obj) {
        return (View) obj;
    }

    protected void onGetStyles(View view, StyleAccumulator styleAccumulator) {
        List viewProperties = getViewProperties();
        int size = viewProperties.size();
        for (int i = 0; i < size; i++) {
            ViewCSSProperty viewCSSProperty = (ViewCSSProperty) viewProperties.get(i);
            try {
                getStyleFromValue(view, viewCSSProperty.getCSSName(), viewCSSProperty.getValue(view), viewCSSProperty.getAnnotation(), styleAccumulator);
            } catch (Throwable e) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("failed to get style property ");
                stringBuilder.append(viewCSSProperty.getCSSName());
                stringBuilder.append(" of element= ");
                stringBuilder.append(view.toString());
                LogUtil.m5744e(e, stringBuilder.toString());
            }
        }
    }

    private static boolean canIntBeMappedToString(ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.mapping() == null || exportedProperty.mapping().length <= null) ? null : true;
    }

    private static String mapIntToStringUsingAnnotation(int i, ExportedProperty exportedProperty) {
        if (canIntBeMappedToString(exportedProperty)) {
            for (IntToString intToString : exportedProperty.mapping()) {
                if (intToString.from() == i) {
                    return intToString.to();
                }
            }
            return NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    private static boolean canFlagsBeMappedToString(ExportedProperty exportedProperty) {
        return (exportedProperty == null || exportedProperty.flagMapping() == null || exportedProperty.flagMapping().length <= null) ? null : true;
    }

    private static String mapFlagsToStringUsingAnnotation(int i, ExportedProperty exportedProperty) {
        if (canFlagsBeMappedToString(exportedProperty)) {
            StringBuilder stringBuilder = null;
            Object obj = null;
            for (FlagToString flagToString : exportedProperty.flagMapping()) {
                if (flagToString.outputIf() == ((flagToString.mask() & i) == flagToString.equals())) {
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    if (obj != null) {
                        stringBuilder.append(" | ");
                    }
                    stringBuilder.append(flagToString.name());
                    obj = 1;
                }
            }
            if (obj != null) {
                return stringBuilder.toString();
            }
            return NONE_MAPPING;
        }
        throw new IllegalStateException("Cannot map using this annotation");
    }

    private static boolean isDefaultValue(Float f) {
        return f.floatValue() == 0.0f ? true : null;
    }

    private static boolean isDefaultValue(Integer num, ExportedProperty exportedProperty) {
        boolean z = false;
        if (!canFlagsBeMappedToString(exportedProperty)) {
            if (canIntBeMappedToString(exportedProperty) == null) {
                if (num.intValue() == null) {
                    z = true;
                }
                return z;
            }
        }
        return false;
    }

    private String convertViewPropertyNameToCSSName(String str) {
        str = getWordBoundaryPattern().split(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("get")) {
                if (!str[i].equals("m")) {
                    stringBuilder.append(str[i].toLowerCase());
                    if (i < str.length - 1) {
                        stringBuilder.append('-');
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    private void getStyleFromValue(View view, String str, Object obj, ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        if (str.equals("id")) {
            getIdStyle(view, styleAccumulator);
        } else if (obj instanceof Integer) {
            getStyleFromInteger(str, (Integer) obj, exportedProperty, styleAccumulator);
        } else if (obj instanceof Float) {
            getStyleFromFloat(str, (Float) obj, exportedProperty, styleAccumulator);
        } else {
            getStylesFromObject(view, str, obj, exportedProperty, styleAccumulator);
        }
    }

    private void getIdStyle(View view, StyleAccumulator styleAccumulator) {
        view = getIdAttribute(view);
        if (view == null) {
            styleAccumulator.store("id", NONE_VALUE, false);
        } else {
            styleAccumulator.store("id", view, false);
        }
    }

    private void getStyleFromInteger(String str, Integer num, ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        String format = IntegerFormatter.getInstance().format(num, exportedProperty);
        StringBuilder stringBuilder;
        if (canIntBeMappedToString(exportedProperty)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(" (");
            stringBuilder.append(mapIntToStringUsingAnnotation(num.intValue(), exportedProperty));
            stringBuilder.append(")");
            styleAccumulator.store(str, stringBuilder.toString(), false);
        } else if (canFlagsBeMappedToString(exportedProperty)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(" (");
            stringBuilder.append(mapFlagsToStringUsingAnnotation(num.intValue(), exportedProperty));
            stringBuilder.append(")");
            styleAccumulator.store(str, stringBuilder.toString(), false);
        } else {
            styleAccumulator.store(str, format, isDefaultValue(num, exportedProperty));
        }
    }

    private void getStyleFromFloat(String str, Float f, ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        styleAccumulator.store(str, String.valueOf(f), isDefaultValue(f));
    }

    private void getStylesFromObject(View view, String str, Object obj, ExportedProperty exportedProperty, StyleAccumulator styleAccumulator) {
        ViewDescriptor viewDescriptor;
        Object obj2 = obj;
        if (exportedProperty != null && exportedProperty.deepExport()) {
            if (obj2 != null) {
                for (Field field : obj.getClass().getFields()) {
                    if (Modifier.isStatic(field.getModifiers())) {
                        viewDescriptor = this;
                    } else {
                        boolean z = true;
                        try {
                            String str2;
                            StringBuilder stringBuilder;
                            String convertViewPropertyNameToCSSName;
                            field.setAccessible(true);
                            Object obj3 = field.get(obj2);
                            String name = field.getName();
                            int hashCode = name.hashCode();
                            if (hashCode != -599904534) {
                                if (hashCode != -414179485) {
                                    if (hashCode != 1928835221) {
                                        if (hashCode == 2064613305) {
                                            if (name.equals("bottomMargin")) {
                                                z = false;
                                                switch (z) {
                                                    case false:
                                                        str2 = "margin-bottom";
                                                        break;
                                                    case true:
                                                        str2 = "margin-top";
                                                        break;
                                                    case true:
                                                        str2 = "margin-left";
                                                        break;
                                                    case true:
                                                        str2 = "margin-right";
                                                        break;
                                                    default:
                                                        str2 = exportedProperty.prefix();
                                                        if (str2 != null) {
                                                            stringBuilder = new StringBuilder();
                                                            stringBuilder.append(str2);
                                                            stringBuilder.append(name);
                                                            name = stringBuilder.toString();
                                                        }
                                                        viewDescriptor = this;
                                                        convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                                        break;
                                                }
                                                convertViewPropertyNameToCSSName = str2;
                                                viewDescriptor = this;
                                                getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                                            }
                                        }
                                    } else if (name.equals("leftMargin")) {
                                        z = true;
                                        switch (z) {
                                            case false:
                                                str2 = "margin-bottom";
                                                break;
                                            case true:
                                                str2 = "margin-top";
                                                break;
                                            case true:
                                                str2 = "margin-left";
                                                break;
                                            case true:
                                                str2 = "margin-right";
                                                break;
                                            default:
                                                str2 = exportedProperty.prefix();
                                                if (str2 != null) {
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append(str2);
                                                    stringBuilder.append(name);
                                                    name = stringBuilder.toString();
                                                }
                                                viewDescriptor = this;
                                                convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                                break;
                                        }
                                        convertViewPropertyNameToCSSName = str2;
                                        viewDescriptor = this;
                                        getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                                    }
                                } else if (name.equals("topMargin")) {
                                    switch (z) {
                                        case false:
                                            str2 = "margin-bottom";
                                            break;
                                        case true:
                                            str2 = "margin-top";
                                            break;
                                        case true:
                                            str2 = "margin-left";
                                            break;
                                        case true:
                                            str2 = "margin-right";
                                            break;
                                        default:
                                            str2 = exportedProperty.prefix();
                                            if (str2 != null) {
                                                stringBuilder = new StringBuilder();
                                                stringBuilder.append(str2);
                                                stringBuilder.append(name);
                                                name = stringBuilder.toString();
                                            }
                                            viewDescriptor = this;
                                            convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                            break;
                                    }
                                    convertViewPropertyNameToCSSName = str2;
                                    viewDescriptor = this;
                                    getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                                }
                            } else if (name.equals("rightMargin")) {
                                z = true;
                                switch (z) {
                                    case false:
                                        str2 = "margin-bottom";
                                        break;
                                    case true:
                                        str2 = "margin-top";
                                        break;
                                    case true:
                                        str2 = "margin-left";
                                        break;
                                    case true:
                                        str2 = "margin-right";
                                        break;
                                    default:
                                        str2 = exportedProperty.prefix();
                                        if (str2 != null) {
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append(str2);
                                            stringBuilder.append(name);
                                            name = stringBuilder.toString();
                                        }
                                        viewDescriptor = this;
                                        convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                        break;
                                }
                                convertViewPropertyNameToCSSName = str2;
                                viewDescriptor = this;
                                getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                            }
                            z = true;
                            switch (z) {
                                case false:
                                    str2 = "margin-bottom";
                                    break;
                                case true:
                                    str2 = "margin-top";
                                    break;
                                case true:
                                    str2 = "margin-left";
                                    break;
                                case true:
                                    str2 = "margin-right";
                                    break;
                                default:
                                    str2 = exportedProperty.prefix();
                                    if (str2 != null) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(str2);
                                        stringBuilder.append(name);
                                        name = stringBuilder.toString();
                                    }
                                    viewDescriptor = this;
                                    convertViewPropertyNameToCSSName = convertViewPropertyNameToCSSName(name);
                                    break;
                            }
                            convertViewPropertyNameToCSSName = str2;
                            viewDescriptor = this;
                            getStyleFromValue(view, convertViewPropertyNameToCSSName, obj3, (ExportedProperty) field.getAnnotation(ExportedProperty.class), styleAccumulator);
                        } catch (Throwable e) {
                            viewDescriptor = this;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("failed to get property of name: \"");
                            stringBuilder2.append(str);
                            stringBuilder2.append("\" of object: ");
                            stringBuilder2.append(String.valueOf(obj));
                            LogUtil.m5744e(e, stringBuilder2.toString());
                            return;
                        }
                    }
                }
                viewDescriptor = this;
                return;
            }
        }
        viewDescriptor = this;
    }

    private static String capitalize(String str) {
        if (!(str == null || str.length() == 0)) {
            if (!Character.isTitleCase(str.charAt(0))) {
                StringBuilder stringBuilder = new StringBuilder(str);
                stringBuilder.setCharAt(0, Character.toTitleCase(stringBuilder.charAt(0)));
                return stringBuilder.toString();
            }
        }
        return str;
    }
}
