package com.facebook.ads.internal.p101p.p102a;

import com.facebook.stetho.common.Utf8Charset;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.p.a.p */
public class C1452p implements Map<String, String> {
    /* renamed from: a */
    private Map<String, String> f4310a = new HashMap();

    /* renamed from: a */
    public C1452p m5140a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    /* renamed from: a */
    public String m5141a() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.f4310a.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(str);
            String str2 = (String) this.f4310a.get(str2);
            if (str2 != null) {
                stringBuilder.append("=");
                try {
                    stringBuilder.append(URLEncoder.encode(str2, Utf8Charset.NAME));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public String m5142a(Object obj) {
        return (String) this.f4310a.get(obj);
    }

    /* renamed from: a */
    public String m5143a(String str, String str2) {
        return (String) this.f4310a.put(str, str2);
    }

    /* renamed from: b */
    public String m5144b(Object obj) {
        return (String) this.f4310a.remove(obj);
    }

    /* renamed from: b */
    public byte[] m5145b() {
        try {
            return m5141a().getBytes(Utf8Charset.NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f4310a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f4310a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f4310a.containsValue(obj);
    }

    public Set<Entry<String, String>> entrySet() {
        return this.f4310a.entrySet();
    }

    public /* synthetic */ Object get(Object obj) {
        return m5142a(obj);
    }

    public boolean isEmpty() {
        return this.f4310a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f4310a.keySet();
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m5143a((String) obj, (String) obj2);
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f4310a.putAll(map);
    }

    public /* synthetic */ Object remove(Object obj) {
        return m5144b(obj);
    }

    public int size() {
        return this.f4310a.size();
    }

    public Collection<String> values() {
        return this.f4310a.values();
    }
}
