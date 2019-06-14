package com.google.android.gms.internal.ads;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@cm
public final class alv {
    /* renamed from: a */
    private final int f14740a;
    /* renamed from: b */
    private final int f14741b;
    /* renamed from: c */
    private final int f14742c;
    /* renamed from: d */
    private final alu f14743d = new alz();

    public alv(int i) {
        this.f14741b = i;
        this.f14740a = 6;
        this.f14742c = 0;
    }

    /* renamed from: a */
    private final String m18615a(String str) {
        String[] split = str.split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        if (split.length == 0) {
            return "";
        }
        alx alx = new alx();
        PriorityQueue priorityQueue = new PriorityQueue(this.f14741b, new alw(this));
        for (String a : split) {
            String[] a2 = aly.m18619a(a, false);
            if (a2.length != 0) {
                amb.m18626a(a2, this.f14741b, this.f14740a, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                alx.m18617a(this.f14743d.mo3842a(((amc) it.next()).f14749b));
            } catch (Throwable e) {
                mt.m19919b("Error while writing hash to byteStream", e);
            }
        }
        return alx.toString();
    }

    /* renamed from: a */
    public final String m18616a(ArrayList<String> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            stringBuilder.append(((String) obj).toLowerCase(Locale.US));
            stringBuilder.append('\n');
        }
        return m18615a(stringBuilder.toString());
    }
}
