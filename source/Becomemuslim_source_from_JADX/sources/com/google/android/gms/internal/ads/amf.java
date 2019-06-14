package com.google.android.gms.internal.ads;

import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

@cm
public final class amf {
    /* renamed from: a */
    private final alu f14751a;
    /* renamed from: b */
    private final int f14752b;
    /* renamed from: c */
    private String f14753c;
    /* renamed from: d */
    private String f14754d;
    /* renamed from: e */
    private final boolean f14755e = false;
    /* renamed from: f */
    private final int f14756f;
    /* renamed from: g */
    private final int f14757g;

    public amf(int i, int i2, int i3) {
        this.f14752b = i;
        if (i2 <= 64) {
            if (i2 >= 0) {
                this.f14756f = i2;
                if (i3 > 0) {
                    this.f14757g = 1;
                } else {
                    this.f14757g = i3;
                }
                this.f14751a = new amd(this.f14756f);
            }
        }
        this.f14756f = 64;
        if (i3 > 0) {
            this.f14757g = i3;
        } else {
            this.f14757g = 1;
        }
        this.f14751a = new amd(this.f14756f);
    }

    /* renamed from: a */
    public final String m18628a(ArrayList<String> arrayList, ArrayList<alt> arrayList2) {
        ArrayList<alt> arrayList3 = arrayList2;
        Collections.sort(arrayList3, new amg(this));
        HashSet hashSet = new HashSet();
        for (int i = 0; i < arrayList2.size(); i++) {
            String[] split = Normalizer.normalize((CharSequence) arrayList.get(((alt) arrayList3.get(i)).m18612e()), Form.NFKC).toLowerCase(Locale.US).split(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
            boolean z = true;
            if (split.length != 0) {
                for (String str : split) {
                    int i2;
                    String stringBuilder;
                    String[] a;
                    int i3;
                    Object obj;
                    int i4;
                    Object obj2;
                    String valueOf;
                    String valueOf2;
                    if (str.indexOf("'") != -1) {
                        StringBuilder stringBuilder2 = new StringBuilder(str);
                        int i5 = 1;
                        Object obj3 = null;
                        while (true) {
                            int i6 = i5 + 2;
                            if (i6 > stringBuilder2.length()) {
                                break;
                            }
                            if (stringBuilder2.charAt(i5) == '\'') {
                                if (stringBuilder2.charAt(i5 - 1) != ' ') {
                                    i2 = i5 + 1;
                                    if ((stringBuilder2.charAt(i2) == 's' || stringBuilder2.charAt(i2) == 'S') && (i6 == stringBuilder2.length() || stringBuilder2.charAt(i6) == ' ')) {
                                        stringBuilder2.insert(i5, ' ');
                                        i5 = i6;
                                        obj3 = 1;
                                    }
                                }
                                stringBuilder2.setCharAt(i5, ' ');
                                obj3 = 1;
                            }
                            i5++;
                        }
                        stringBuilder = obj3 != null ? stringBuilder2.toString() : null;
                        if (stringBuilder != null) {
                            r1.f14754d = stringBuilder;
                            a = aly.m18619a(stringBuilder, true);
                            if (a.length >= r1.f14757g) {
                                for (i3 = 0; i3 < a.length; i3++) {
                                    obj = "";
                                    for (i4 = 0; i4 < r1.f14757g; i4++) {
                                        i2 = i3 + i4;
                                        if (i2 >= a.length) {
                                            obj2 = null;
                                            break;
                                        }
                                        if (i4 > 0) {
                                            obj = String.valueOf(obj).concat(" ");
                                        }
                                        valueOf = String.valueOf(obj);
                                        valueOf2 = String.valueOf(a[i2]);
                                        obj = valueOf2.length() == 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                    }
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        break;
                                    }
                                    hashSet.add(obj);
                                    if (hashSet.size() >= r1.f14752b) {
                                        break;
                                    }
                                }
                                if (hashSet.size() >= r1.f14752b) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                    }
                    stringBuilder = str;
                    a = aly.m18619a(stringBuilder, true);
                    if (a.length >= r1.f14757g) {
                        while (i3 < a.length) {
                            obj = "";
                            for (i4 = 0; i4 < r1.f14757g; i4++) {
                                i2 = i3 + i4;
                                if (i2 >= a.length) {
                                    obj2 = null;
                                    break;
                                }
                                if (i4 > 0) {
                                    obj = String.valueOf(obj).concat(" ");
                                }
                                valueOf = String.valueOf(obj);
                                valueOf2 = String.valueOf(a[i2]);
                                if (valueOf2.length() == 0) {
                                }
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                hashSet.add(obj);
                                if (hashSet.size() >= r1.f14752b) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (hashSet.size() >= r1.f14752b) {
                            z = false;
                            break;
                        }
                    }
                }
            }
            if (!z) {
                break;
            }
        }
        alx alx = new alx();
        r1.f14753c = "";
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                alx.m18617a(r1.f14751a.mo3842a((String) it.next()));
            } catch (Throwable e) {
                mt.m19919b("Error while writing hash to byteStream", e);
            }
        }
        return alx.toString();
    }
}
