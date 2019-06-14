package com.imagepicker.p251b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.C4473b;
import android.support.v7.app.C4473b.C0609a;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.imagepicker.ImagePickerModule;
import java.lang.ref.WeakReference;

/* compiled from: PermissionUtils */
/* renamed from: com.imagepicker.b.b */
public class C5411b {

    /* compiled from: PermissionUtils */
    /* renamed from: com.imagepicker.b.b$a */
    public interface C5410a {
        /* renamed from: a */
        void mo4916a(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface);

        /* renamed from: b */
        void mo4917b(WeakReference<ImagePickerModule> weakReference, DialogInterface dialogInterface);
    }

    /* renamed from: a */
    public static C4473b m22983a(ImagePickerModule imagePickerModule, ReadableMap readableMap, final C5410a c5410a) {
        if (imagePickerModule.getContext() == null || !readableMap.hasKey("permissionDenied")) {
            return null;
        }
        readableMap = readableMap.getMap("permissionDenied");
        if (((ReadableNativeMap) readableMap).toHashMap().size() == 0) {
            return null;
        }
        CharSequence string = readableMap.getString("title");
        CharSequence string2 = readableMap.getString("text");
        CharSequence string3 = readableMap.getString("reTryTitle");
        readableMap = readableMap.getString("okTitle");
        final WeakReference weakReference = new WeakReference(imagePickerModule);
        Context activity = imagePickerModule.getActivity();
        if (activity == null) {
            return null;
        }
        C0609a c0609a = new C0609a(activity, imagePickerModule.getDialogThemeId());
        c0609a.a(string).b(string2).a(false).b(readableMap, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                c5410a.mo4916a(weakReference, dialogInterface);
            }
        }).a(string3, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                c5410a.mo4917b(weakReference, dialogInterface);
            }
        });
        return c0609a.b();
    }
}
