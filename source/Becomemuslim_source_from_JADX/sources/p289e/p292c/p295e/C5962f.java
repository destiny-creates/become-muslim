package p289e.p292c.p295e;

import java.util.ArrayList;
import java.util.List;

/* compiled from: LinkedArrayList */
/* renamed from: e.c.e.f */
public class C5962f {
    /* renamed from: g */
    final int f19720g;
    /* renamed from: h */
    Object[] f19721h;
    /* renamed from: i */
    Object[] f19722i;
    /* renamed from: j */
    volatile int f19723j;
    /* renamed from: k */
    int f19724k;

    public C5962f(int i) {
        this.f19720g = i;
    }

    /* renamed from: b */
    public void m24931b(Object obj) {
        if (this.f19723j == 0) {
            this.f19721h = new Object[(this.f19720g + 1)];
            this.f19722i = this.f19721h;
            this.f19721h[0] = obj;
            this.f19724k = 1;
            this.f19723j = 1;
        } else if (this.f19724k == this.f19720g) {
            Object[] objArr = new Object[(this.f19720g + 1)];
            objArr[0] = obj;
            this.f19722i[this.f19720g] = objArr;
            this.f19722i = objArr;
            this.f19724k = 1;
            this.f19723j += 1;
        } else {
            this.f19722i[this.f19724k] = obj;
            this.f19724k += 1;
            this.f19723j += 1;
        }
    }

    /* renamed from: d */
    public Object[] m24932d() {
        return this.f19721h;
    }

    /* renamed from: e */
    public int m24933e() {
        return this.f19723j;
    }

    /* renamed from: f */
    List<Object> m24934f() {
        int i = this.f19720g;
        int i2 = this.f19723j;
        List<Object> arrayList = new ArrayList(i2 + 1);
        Object[] d = m24932d();
        int i3 = 0;
        while (true) {
            int i4 = 0;
            while (i3 < i2) {
                arrayList.add(d[i4]);
                i3++;
                i4++;
                if (i4 == i) {
                    d = (Object[]) d[i];
                }
            }
            return arrayList;
        }
    }

    public String toString() {
        return m24934f().toString();
    }
}
