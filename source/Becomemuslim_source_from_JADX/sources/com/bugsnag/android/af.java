package com.bugsnag.android;

import com.bugsnag.android.NativeInterface.C1068a;
import com.bugsnag.android.NativeInterface.C1069b;
import com.bugsnag.android.ab.C1071a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MetaData */
public class af extends Observable implements C1071a {
    /* renamed from: a */
    final Map<String, Object> f9164a;
    /* renamed from: b */
    final ah f9165b;

    public af() {
        this(new ConcurrentHashMap());
    }

    public af(Map<String, Object> map) {
        this.f9164a = new ConcurrentHashMap(map);
        this.f9165b = new ah();
    }

    public void toStream(ab abVar) {
        this.f9165b.m3739a(this.f9164a, abVar);
    }

    /* renamed from: a */
    public void m11033a(String str, String str2, Object obj) {
        Map a = m11032a(str);
        setChanged();
        if (obj != null) {
            a.put(str2, obj);
            notifyObservers(new C1068a(C1069b.ADD_METADATA, Arrays.asList(new Object[]{str, str2, obj})));
            return;
        }
        a.remove(str2);
        notifyObservers(new C1068a(C1069b.REMOVE_METADATA, Arrays.asList(new String[]{str, str2})));
    }

    /* renamed from: a */
    Map<String, Object> m11032a(String str) {
        Map<String, Object> map = (Map) this.f9164a.get(str);
        if (map != null) {
            return map;
        }
        Map concurrentHashMap = new ConcurrentHashMap();
        this.f9164a.put(str, concurrentHashMap);
        return concurrentHashMap;
    }

    /* renamed from: a */
    void m11034a(String... strArr) {
        this.f9165b.f3014a = strArr;
    }

    /* renamed from: a */
    static af m11030a(af... afVarArr) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (af afVar : afVarArr) {
            if (afVar != null) {
                arrayList.add(afVar.f9164a);
                if (afVar.f9165b.f3014a != null) {
                    arrayList2.addAll(Arrays.asList(afVar.f9165b.f3014a));
                }
            }
        }
        afVarArr = new af(m11031a((Map[]) arrayList.toArray(new Map[0])));
        afVarArr.m11034a((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        return afVarArr;
    }

    @SafeVarargs
    /* renamed from: a */
    private static Map<String, Object> m11031a(Map<String, Object>... mapArr) {
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap();
        for (Map map : mapArr) {
            if (map != null) {
                Set<String> hashSet = new HashSet(concurrentHashMap.keySet());
                hashSet.addAll(map.keySet());
                for (String str : hashSet) {
                    Object obj = concurrentHashMap.get(str);
                    Object obj2 = map.get(str);
                    if (obj2 != null) {
                        if ((obj instanceof Map) && (obj2 instanceof Map)) {
                            Map map2 = (Map) obj2;
                            concurrentHashMap.put(str, m11031a((Map) obj, map2));
                        } else {
                            concurrentHashMap.put(str, obj2);
                        }
                    } else if (obj != null) {
                        concurrentHashMap.put(str, obj);
                    }
                }
            }
        }
        return concurrentHashMap;
    }
}
