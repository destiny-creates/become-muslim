package com.imagepicker.p252c;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.ReadableMap;
import java.util.LinkedList;
import java.util.List;

/* compiled from: ButtonsHelper */
/* renamed from: com.imagepicker.c.a */
public class C5414a {
    /* renamed from: a */
    public final C5413a f18207a;
    /* renamed from: b */
    public final C5413a f18208b;
    /* renamed from: c */
    public final C5413a f18209c;
    /* renamed from: d */
    public final List<C5413a> f18210d;

    /* compiled from: ButtonsHelper */
    /* renamed from: com.imagepicker.c.a$a */
    public static class C5413a {
        /* renamed from: a */
        public final String f18205a;
        /* renamed from: b */
        public final String f18206b;

        public C5413a(String str, String str2) {
            this.f18205a = str;
            this.f18206b = str2;
        }
    }

    public C5414a(C5413a c5413a, C5413a c5413a2, C5413a c5413a3, LinkedList<C5413a> linkedList) {
        this.f18207a = c5413a;
        this.f18208b = c5413a2;
        this.f18209c = c5413a3;
        this.f18210d = linkedList;
    }

    /* renamed from: a */
    public List<String> m22987a() {
        List<String> linkedList = new LinkedList();
        if (this.f18207a != null) {
            linkedList.add(this.f18207a.f18205a);
        }
        if (this.f18208b != null) {
            linkedList.add(this.f18208b.f18205a);
        }
        for (int i = 0; i < this.f18210d.size(); i++) {
            linkedList.add(((C5413a) this.f18210d.get(i)).f18205a);
        }
        return linkedList;
    }

    /* renamed from: b */
    public List<String> m22988b() {
        List<String> linkedList = new LinkedList();
        if (this.f18207a != null) {
            linkedList.add(this.f18207a.f18206b);
        }
        if (this.f18208b != null) {
            linkedList.add(this.f18208b.f18206b);
        }
        for (int i = 0; i < this.f18210d.size(); i++) {
            linkedList.add(((C5413a) this.f18210d.get(i)).f18206b);
        }
        return linkedList;
    }

    /* renamed from: a */
    public static C5414a m22985a(ReadableMap readableMap) {
        return new C5414a(C5414a.m22984a(readableMap, "takePhotoButtonTitle", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO), C5414a.m22984a(readableMap, "chooseFromLibraryButtonTitle", "library"), C5414a.m22984a(readableMap, "cancelButtonTitle", "cancel"), C5414a.m22986b(readableMap));
    }

    /* renamed from: a */
    private static C5413a m22984a(ReadableMap readableMap, String str, String str2) {
        if (C5419c.m22998b(readableMap, str)) {
            return new C5413a(readableMap.getString(str), str2);
        }
        return null;
    }

    /* renamed from: b */
    private static LinkedList<C5413a> m22986b(ReadableMap readableMap) {
        LinkedList<C5413a> linkedList = new LinkedList();
        if (!readableMap.hasKey("customButtons")) {
            return linkedList;
        }
        readableMap = readableMap.getArray("customButtons");
        for (int i = 0; i < readableMap.size(); i++) {
            ReadableMap map = readableMap.getMap(i);
            linkedList.add(new C5413a(map.getString("title"), map.getString("name")));
        }
        return linkedList;
    }
}
