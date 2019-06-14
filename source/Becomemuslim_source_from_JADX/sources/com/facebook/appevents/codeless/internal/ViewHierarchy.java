package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0508j;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewHierarchy {
    private static final int ADAPTER_VIEW_ITEM_BITMASK = 9;
    private static final int BUTTON_BITMASK = 2;
    private static final int CHECKBOX_BITMASK = 15;
    private static final String CHILDREN_VIEW_KEY = "childviews";
    private static final String CLASS_NAME_KEY = "classname";
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    private static final String CLASS_RCTTEXTVIEW = "com.facebook.react.views.view.ReactTextView";
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final String CLASS_TYPE_BITMASK_KEY = "classtypebitmask";
    private static final int CLICKABLE_VIEW_BITMASK = 5;
    private static final String DESC_KEY = "description";
    private static final String DIMENSION_HEIGHT_KEY = "height";
    private static final String DIMENSION_KEY = "dimension";
    private static final String DIMENSION_LEFT_KEY = "left";
    private static final String DIMENSION_SCROLL_X_KEY = "scrollx";
    private static final String DIMENSION_SCROLL_Y_KEY = "scrolly";
    private static final String DIMENSION_TOP_KEY = "top";
    private static final String DIMENSION_VISIBILITY_KEY = "visibility";
    private static final String DIMENSION_WIDTH_KEY = "width";
    private static final String GET_ACCESSIBILITY_METHOD = "getAccessibilityDelegate";
    private static final String HINT_KEY = "hint";
    private static final String ICON_BITMAP = "icon_image";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    private static final String ID_KEY = "id";
    private static final int IMAGEVIEW_BITMASK = 1;
    private static final int INPUT_BITMASK = 11;
    private static final int LABEL_BITMASK = 10;
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    private static final int PICKER_BITMASK = 12;
    private static final int RADIO_GROUP_BITMASK = 14;
    private static final int RATINGBAR_BITMASK = 16;
    private static WeakReference<View> RCTRootViewReference = new WeakReference(null);
    private static final int REACT_NATIVE_BUTTON_BITMASK = 6;
    private static final int SWITCH_BITMASK = 13;
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    private static final String TAG_KEY = "tag";
    private static final int TEXTVIEW_BITMASK = 0;
    private static final String TEXT_IS_BOLD = "is_bold";
    private static final String TEXT_IS_ITALIC = "is_italic";
    private static final String TEXT_KEY = "text";
    private static final String TEXT_SIZE = "font_size";
    private static final String TEXT_STYLE = "text_style";
    private static Method methodFindTouchTargetView = null;

    public static ViewGroup getParentOfView(View view) {
        if (view == null) {
            return null;
        }
        view = view.getParent();
        if (view == null || !(view instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) view;
    }

    public static List<View> getChildrenOfView(View view) {
        List arrayList = new ArrayList();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                arrayList.add(viewGroup.getChildAt(i));
            }
        }
        return arrayList;
    }

    public static JSONObject setBasicInfoOfView(View view, JSONObject jSONObject) {
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(CLASS_NAME_KEY, view.getClass().getCanonicalName());
            jSONObject.put(CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put("text", "");
            } else {
                jSONObject.put("text", textOfView);
            }
            jSONObject.put(HINT_KEY, hintOfView);
            if (tag != null) {
                jSONObject.put(TAG_KEY, tag.toString());
            }
            if (contentDescription != null) {
                jSONObject.put("description", contentDescription.toString());
            }
            jSONObject.put(DIMENSION_KEY, getDimensionOfView(view));
        } catch (Exception e) {
            Utility.logd(TAG, e);
        }
        return jSONObject;
    }

    public static JSONObject setAppearanceOfView(View view, JSONObject jSONObject, float f) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Typeface typeface = textView.getTypeface();
                if (typeface != null) {
                    jSONObject2.put(TEXT_SIZE, (double) textView.getTextSize());
                    jSONObject2.put(TEXT_IS_BOLD, typeface.isBold());
                    jSONObject2.put(TEXT_IS_ITALIC, typeface.isItalic());
                    jSONObject.put(TEXT_STYLE, jSONObject2);
                }
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if ((drawable instanceof BitmapDrawable) && ((float) view.getHeight()) / f <= 44.0f && ((float) view.getWidth()) / f <= 1110441984) {
                    view = ((BitmapDrawable) drawable).getBitmap();
                    f = new ByteArrayOutputStream();
                    view.compress(CompressFormat.PNG, 100, f);
                    jSONObject.put(ICON_BITMAP, Base64.encodeToString(f.toByteArray(), 0.0f));
                }
            }
        } catch (Exception e) {
            Utility.logd(TAG, e);
        }
        return jSONObject;
    }

    public static JSONObject getDictionaryOfView(View view) {
        JSONObject basicInfoOfView;
        if (view.getClass().getName().equals(CLASS_RCTROOTVIEW)) {
            RCTRootViewReference = new WeakReference(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            basicInfoOfView = setBasicInfoOfView(view, jSONObject);
            try {
                JSONArray jSONArray = new JSONArray();
                view = getChildrenOfView(view);
                for (int i = 0; i < view.size(); i++) {
                    jSONArray.put(getDictionaryOfView((View) view.get(i)));
                }
                basicInfoOfView.put(CHILDREN_VIEW_KEY, jSONArray);
            } catch (JSONException e) {
                view = e;
                Log.e(TAG, "Failed to create JSONObject for view.", view);
                return basicInfoOfView;
            }
        } catch (JSONException e2) {
            view = e2;
            basicInfoOfView = jSONObject;
            Log.e(TAG, "Failed to create JSONObject for view.", view);
            return basicInfoOfView;
        }
        return basicInfoOfView;
    }

    private static int getClassTypeBitmask(View view) {
        int i = view instanceof ImageView ? 2 : 0;
        if (isClickableView(view)) {
            i |= 32;
        }
        if (isAdapterViewItem(view)) {
            i |= 512;
        }
        if (view instanceof TextView) {
            i = (i | 1024) | 1;
            if (view instanceof Button) {
                i |= 4;
                if (view instanceof Switch) {
                    i |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
                } else if (view instanceof CheckBox) {
                    i |= 32768;
                }
            }
            if ((view instanceof EditText) != null) {
                return i | 2048;
            }
            return i;
        }
        if (!(view instanceof Spinner)) {
            if (!(view instanceof DatePicker)) {
                if (view instanceof RatingBar) {
                    return i | NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                }
                if (view instanceof RadioGroup) {
                    return i | 16384;
                }
                return (!(view instanceof ViewGroup) || isRCTButton(view, (View) RCTRootViewReference.get()) == null) ? i : i | 64;
            }
        }
        return i | 4096;
    }

    public static boolean isClickableView(View view) {
        boolean z = false;
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            view = declaredField.get(view);
            if (view == null) {
                return false;
            }
            OnClickListener onClickListener = null;
            Field declaredField2 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if (declaredField2 != null) {
                onClickListener = (OnClickListener) declaredField2.get(view);
            }
            if (onClickListener != null) {
                z = true;
            }
            return z;
        } catch (View view2) {
            Log.e(TAG, "Failed to check if the view is clickable.", view2);
            return false;
        }
    }

    private static boolean isAdapterViewItem(View view) {
        view = view.getParent();
        return (view == null || (!(view instanceof AdapterView) && (view instanceof C0508j) == null)) ? null : true;
    }

    public static String getTextOfView(View view) {
        Object obj = null;
        if (view instanceof TextView) {
            obj = ((TextView) view).getText();
            if (view instanceof Switch) {
                view = ((Switch) view).isChecked() != null ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            if (obj == null) {
                return "";
            }
            return obj.toString();
        }
        if (view instanceof Spinner) {
            view = ((Spinner) view).getSelectedItem();
            if (view != null) {
                obj = view.toString();
            }
        } else {
            int i = 0;
            int year;
            if (view instanceof DatePicker) {
                DatePicker datePicker = (DatePicker) view;
                year = datePicker.getYear();
                int month = datePicker.getMonth();
                view = datePicker.getDayOfMonth();
                obj = String.format("%04d-%02d-%02d", new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(view)});
            } else if (view instanceof TimePicker) {
                TimePicker timePicker = (TimePicker) view;
                year = timePicker.getCurrentHour().intValue();
                view = timePicker.getCurrentMinute().intValue();
                obj = String.format("%02d:%02d", new Object[]{Integer.valueOf(year), Integer.valueOf(view)});
            } else if (view instanceof RadioGroup) {
                RadioGroup radioGroup = (RadioGroup) view;
                year = radioGroup.getCheckedRadioButtonId();
                int childCount = radioGroup.getChildCount();
                while (i < childCount) {
                    View childAt = radioGroup.getChildAt(i);
                    if (childAt.getId() == year && (childAt instanceof RadioButton)) {
                        view = ((RadioButton) childAt).getText();
                    } else {
                        i++;
                    }
                }
            } else if (view instanceof RatingBar) {
                obj = String.valueOf(((RatingBar) view).getRating());
            }
        }
        if (obj == null) {
            return obj.toString();
        }
        return "";
        obj = view;
        if (obj == null) {
            return "";
        }
        return obj.toString();
    }

    public static String getHintOfView(View view) {
        view = view instanceof TextView ? ((TextView) view).getHint() : view instanceof EditText ? ((EditText) view).getHint() : null;
        if (view == null) {
            return "";
        }
        return view.toString();
    }

    private static JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("top", view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put(DIMENSION_VISIBILITY_KEY, view.getVisibility());
        } catch (View view2) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", view2);
        }
        return jSONObject;
    }

    public static android.view.View.AccessibilityDelegate getExistingDelegate(android.view.View r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        r1 = r5.getClass();	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        r2 = "getAccessibilityDelegate";	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        r3 = 0;	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        r4 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        r2 = new java.lang.Object[r3];	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        r5 = r1.invoke(r5, r2);	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        r5 = (android.view.View.AccessibilityDelegate) r5;	 Catch:{ NoSuchMethodException -> 0x001b, NullPointerException -> 0x001a, SecurityException -> 0x0019, IllegalAccessException -> 0x0018, InvocationTargetException -> 0x0017 }
        return r5;
    L_0x0017:
        return r0;
    L_0x0018:
        return r0;
    L_0x0019:
        return r0;
    L_0x001a:
        return r0;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getExistingDelegate(android.view.View):android.view.View$AccessibilityDelegate");
    }

    public static OnTouchListener getExistingOnTouchListener(View view) {
        try {
            Field declaredField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            view = declaredField.get(view);
            if (view == null) {
                return null;
            }
            declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                view = (OnTouchListener) declaredField.get(view);
            } else {
                view = null;
            }
            return view;
        } catch (Exception e) {
            Utility.logd(TAG, e);
            return null;
        } catch (Exception e2) {
            Utility.logd(TAG, e2);
            return null;
        } catch (Exception e22) {
            Utility.logd(TAG, e22);
            return null;
        }
    }

    public static View getTouchReactView(float[] fArr, View view) {
        initTouchTargetHelperMethods();
        if (methodFindTouchTargetView != null) {
            if (view != null) {
                try {
                    View view2 = (View) methodFindTouchTargetView.invoke(null, new Object[]{fArr, view});
                    if (view2 != null && view2.getId() > null) {
                        view2 = (View) view2.getParent();
                        if (view2 != null) {
                            return view2;
                        }
                    }
                } catch (Exception e) {
                    Utility.logd(TAG, e);
                } catch (Exception e2) {
                    Utility.logd(TAG, e2);
                }
                return null;
            }
        }
        return null;
    }

    public static boolean isRCTButton(View view, View view2) {
        boolean z = false;
        if (!view.getClass().getName().equals(CLASS_RCTVIEWGROUP)) {
            return false;
        }
        view2 = getTouchReactView(getViewLocationOnScreen(view), view2);
        if (view2 != null && view2.getId() == view.getId()) {
            z = true;
        }
        return z;
    }

    public static boolean isRCTRootView(View view) {
        return view.getClass().getName().equals(CLASS_RCTROOTVIEW);
    }

    public static boolean isRCTTextView(View view) {
        return view.getClass().getName().equals(CLASS_RCTTEXTVIEW);
    }

    public static boolean isRCTViewGroup(View view) {
        return view.getClass().getName().equals(CLASS_RCTVIEWGROUP);
    }

    public static View findRCTRootView(View view) {
        while (view != null) {
            if (!isRCTRootView(view)) {
                view = view.getParent();
                if (view == null || !(view instanceof View)) {
                    break;
                }
                view = view;
            } else {
                return view;
            }
        }
        return null;
    }

    private static float[] getViewLocationOnScreen(View view) {
        float[] fArr = new float[2];
        r0 = new int[2];
        view.getLocationOnScreen(r0);
        fArr[0] = (float) r0[0];
        fArr[1] = (float) r0[1];
        return fArr;
    }

    private static void initTouchTargetHelperMethods() {
        if (methodFindTouchTargetView == null) {
            try {
                methodFindTouchTargetView = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, new Class[]{float[].class, ViewGroup.class});
                methodFindTouchTargetView.setAccessible(true);
            } catch (Exception e) {
                Utility.logd(TAG, e);
            } catch (Exception e2) {
                Utility.logd(TAG, e2);
            }
        }
    }
}
