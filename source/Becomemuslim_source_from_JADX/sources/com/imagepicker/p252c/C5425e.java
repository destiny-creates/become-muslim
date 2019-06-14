package com.imagepicker.p252c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.C4473b;
import android.support.v7.app.C4473b.C0609a;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ReadableMap;
import com.imagepicker.C5412b.C5405a;
import com.imagepicker.ImagePickerModule;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: UI */
/* renamed from: com.imagepicker.c.e */
public class C5425e {

    /* compiled from: UI */
    /* renamed from: com.imagepicker.c.e$a */
    public interface C5424a {
        /* renamed from: a */
        void mo4912a(ImagePickerModule imagePickerModule);

        /* renamed from: a */
        void mo4913a(ImagePickerModule imagePickerModule, String str);

        /* renamed from: b */
        void mo4914b(ImagePickerModule imagePickerModule);

        /* renamed from: c */
        void mo4915c(ImagePickerModule imagePickerModule);
    }

    /* renamed from: a */
    public static C4473b m23012a(ImagePickerModule imagePickerModule, ReadableMap readableMap, final C5424a c5424a) {
        Context activity = imagePickerModule.getActivity();
        if (activity == null) {
            return null;
        }
        final WeakReference weakReference = new WeakReference(imagePickerModule);
        C5414a a = C5414a.m22985a(readableMap);
        List a2 = a.m22987a();
        final List b = a.m22988b();
        ListAdapter arrayAdapter = new ArrayAdapter(activity, C5405a.list_item, a2);
        C0609a c0609a = new C0609a(activity, imagePickerModule.getDialogThemeId());
        if (C5419c.m22998b(readableMap, "title") != null) {
            c0609a.a(readableMap.getString("title"));
        }
        c0609a.a(arrayAdapter, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String str = (String) b.get(i);
                i = str.hashCode();
                if (i != -1367724422) {
                    if (i != 106642994) {
                        if (i == 166208699) {
                            if (str.equals("library") != 0) {
                                i = 1;
                                switch (i) {
                                    case 0:
                                        c5424a.mo4912a((ImagePickerModule) weakReference.get());
                                        return;
                                    case 1:
                                        c5424a.mo4914b((ImagePickerModule) weakReference.get());
                                        return;
                                    case 2:
                                        c5424a.mo4915c((ImagePickerModule) weakReference.get());
                                        return;
                                    default:
                                        c5424a.mo4913a((ImagePickerModule) weakReference.get(), str);
                                        return;
                                }
                            }
                        }
                    } else if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO) != 0) {
                        i = 0;
                        switch (i) {
                            case 0:
                                c5424a.mo4912a((ImagePickerModule) weakReference.get());
                                return;
                            case 1:
                                c5424a.mo4914b((ImagePickerModule) weakReference.get());
                                return;
                            case 2:
                                c5424a.mo4915c((ImagePickerModule) weakReference.get());
                                return;
                            default:
                                c5424a.mo4913a((ImagePickerModule) weakReference.get(), str);
                                return;
                        }
                    }
                } else if (str.equals("cancel") != 0) {
                    i = 2;
                    switch (i) {
                        case 0:
                            c5424a.mo4912a((ImagePickerModule) weakReference.get());
                            return;
                        case 1:
                            c5424a.mo4914b((ImagePickerModule) weakReference.get());
                            return;
                        case 2:
                            c5424a.mo4915c((ImagePickerModule) weakReference.get());
                            return;
                        default:
                            c5424a.mo4913a((ImagePickerModule) weakReference.get(), str);
                            return;
                    }
                }
                i = -1;
                switch (i) {
                    case 0:
                        c5424a.mo4912a((ImagePickerModule) weakReference.get());
                        return;
                    case 1:
                        c5424a.mo4914b((ImagePickerModule) weakReference.get());
                        return;
                    case 2:
                        c5424a.mo4915c((ImagePickerModule) weakReference.get());
                        return;
                    default:
                        c5424a.mo4913a((ImagePickerModule) weakReference.get(), str);
                        return;
                }
            }
        });
        c0609a.b(a.f18209c.f18205a, new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                c5424a.mo4915c((ImagePickerModule) weakReference.get());
                dialogInterface.dismiss();
            }
        });
        imagePickerModule = c0609a.b();
        imagePickerModule.setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                c5424a.mo4915c((ImagePickerModule) weakReference.get());
                dialogInterface.dismiss();
            }
        });
        return imagePickerModule;
    }
}
