package com.google.maps.android.p247a.p249b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.C5125c;
import com.google.android.gms.maps.model.C5136a;
import com.google.android.gms.maps.model.C5137b;
import com.google.android.gms.maps.model.C5139g;
import com.google.android.gms.maps.model.C5143l;
import com.google.maps.android.p247a.C5392b;
import com.google.maps.android.p247a.C5393c;
import com.google.maps.android.p247a.C5395h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: KmlRenderer */
/* renamed from: com.google.maps.android.a.b.m */
public class C6924m extends C5395h {
    /* renamed from: a */
    private final ArrayList<String> f24770a = new ArrayList();
    /* renamed from: b */
    private boolean f24771b = false;
    /* renamed from: c */
    private boolean f24772c = false;
    /* renamed from: d */
    private HashMap<C5387e, C5139g> f24773d;
    /* renamed from: e */
    private ArrayList<C5384b> f24774e;

    /* compiled from: KmlRenderer */
    /* renamed from: com.google.maps.android.a.b.m$a */
    private class C5389a extends AsyncTask<String, Void, Bitmap> {
        /* renamed from: a */
        final /* synthetic */ C6924m f18164a;
        /* renamed from: b */
        private final String f18165b;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m22876a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m22877a((Bitmap) obj);
        }

        public C5389a(C6924m c6924m, String str) {
            this.f18164a = c6924m;
            this.f18165b = str;
        }

        /* renamed from: a */
        protected android.graphics.Bitmap m22876a(java.lang.String... r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r4 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0032, IOException -> 0x0012 }
            r0 = r3.f18165b;	 Catch:{ MalformedURLException -> 0x0032, IOException -> 0x0012 }
            r4.<init>(r0);	 Catch:{ MalformedURLException -> 0x0032, IOException -> 0x0012 }
            r4 = r4.getContent();	 Catch:{ MalformedURLException -> 0x0032, IOException -> 0x0012 }
            r4 = (java.io.InputStream) r4;	 Catch:{ MalformedURLException -> 0x0032, IOException -> 0x0012 }
            r4 = android.graphics.BitmapFactory.decodeStream(r4);	 Catch:{ MalformedURLException -> 0x0032, IOException -> 0x0012 }
            return r4;
        L_0x0012:
            r4 = move-exception;
            r0 = "KmlRenderer";
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r2 = "Image [";
            r1.append(r2);
            r2 = r3.f18165b;
            r1.append(r2);
            r2 = "] download issue";
            r1.append(r2);
            r1 = r1.toString();
            android.util.Log.e(r0, r1, r4);
            r4 = 0;
            return r4;
        L_0x0032:
            r4 = r3.f18165b;
            r4 = android.graphics.BitmapFactory.decodeFile(r4);
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.a.b.m.a.a(java.lang.String[]):android.graphics.Bitmap");
        }

        /* renamed from: a */
        protected void m22877a(Bitmap bitmap) {
            if (bitmap == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Image at this URL could not be found ");
                stringBuilder.append(this.f18165b);
                Log.e("KmlRenderer", stringBuilder.toString());
                return;
            }
            this.f18164a.m22924a(this.f18165b, bitmap);
            if (this.f18164a.m22929a() != null) {
                this.f18164a.m32477a(this.f18165b, this.f18164a.f24773d, true);
                this.f18164a.m32475a(this.f18165b, this.f18164a.f24774e, true);
            }
        }
    }

    /* compiled from: KmlRenderer */
    /* renamed from: com.google.maps.android.a.b.m$b */
    private class C5390b extends AsyncTask<String, Void, Bitmap> {
        /* renamed from: a */
        final /* synthetic */ C6924m f18166a;
        /* renamed from: b */
        private final String f18167b;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m22878a((String[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m22879a((Bitmap) obj);
        }

        public C5390b(C6924m c6924m, String str) {
            this.f18166a = c6924m;
            this.f18167b = str;
        }

        /* renamed from: a */
        protected android.graphics.Bitmap m22878a(java.lang.String... r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r2 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0018, IOException -> 0x0012 }
            r0 = r1.f18167b;	 Catch:{ MalformedURLException -> 0x0018, IOException -> 0x0012 }
            r2.<init>(r0);	 Catch:{ MalformedURLException -> 0x0018, IOException -> 0x0012 }
            r2 = r2.getContent();	 Catch:{ MalformedURLException -> 0x0018, IOException -> 0x0012 }
            r2 = (java.io.InputStream) r2;	 Catch:{ MalformedURLException -> 0x0018, IOException -> 0x0012 }
            r2 = android.graphics.BitmapFactory.decodeStream(r2);	 Catch:{ MalformedURLException -> 0x0018, IOException -> 0x0012 }
            return r2;
        L_0x0012:
            r2 = move-exception;
            r2.printStackTrace();
            r2 = 0;
            return r2;
        L_0x0018:
            r2 = r1.f18167b;
            r2 = android.graphics.BitmapFactory.decodeFile(r2);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.a.b.m.b.a(java.lang.String[]):android.graphics.Bitmap");
        }

        /* renamed from: a */
        protected void m22879a(Bitmap bitmap) {
            if (bitmap == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Image at this URL could not be found ");
                stringBuilder.append(this.f18167b);
                Log.e("KmlRenderer", stringBuilder.toString());
                return;
            }
            this.f18166a.m22924a(this.f18167b, bitmap);
            if (this.f18166a.m22929a() != null) {
                this.f18166a.m32476a(this.f18167b, this.f18166a.m22930b());
                this.f18166a.m32474a(this.f18167b, this.f18166a.f24774e);
            }
        }
    }

    C6924m(C5125c c5125c, Context context) {
        super(c5125c, context);
    }

    /* renamed from: a */
    private static C5136a m32466a(Bitmap bitmap, Double d) {
        return C5137b.m21764a(Bitmap.createScaledBitmap(bitmap, (int) (((double) bitmap.getWidth()) * d.doubleValue()), (int) (((double) bitmap.getHeight()) * d.doubleValue()), false));
    }

    /* renamed from: a */
    static boolean m32479a(C5384b c5384b, boolean z) {
        c5384b = (c5384b.m22842c("visibility") && Integer.parseInt(c5384b.m22839b("visibility")) == null) ? null : true;
        if (!z || c5384b == null) {
            return false;
        }
        return true;
    }

    /* renamed from: j */
    public void mo4900j() {
        m22928a(true);
        this.f24773d = m22935g();
        this.f24774e = m22936h();
        m22937i();
        m22926a(m22933e(), m22932d());
        m32478a(this.f24773d, this.f24774e);
        m32473a(this.f24774e, true);
        m32482b(m22930b());
        if (!this.f24772c) {
            m32486m();
        }
        if (!this.f24771b) {
            m32485l();
        }
    }

    /* renamed from: b */
    void m32487b(HashMap<String, C6925n> hashMap, HashMap<String, String> hashMap2, HashMap<C6923j, Object> hashMap3, ArrayList<C5384b> arrayList, HashMap<C5387e, C5139g> hashMap4) {
        m22927a((HashMap) hashMap, (HashMap) hashMap2, (HashMap) hashMap3, (ArrayList) arrayList, (HashMap) hashMap4);
    }

    /* renamed from: k */
    public Iterable<C5384b> m32489k() {
        return this.f24774e;
    }

    /* renamed from: b */
    private void m32482b(HashMap<? extends C5392b, Object> hashMap) {
        hashMap = hashMap.keySet().iterator();
        while (hashMap.hasNext()) {
            m22922a((C5392b) hashMap.next());
        }
    }

    /* renamed from: a */
    private void m32473a(Iterable<C5384b> iterable, boolean z) {
        for (C5384b c5384b : iterable) {
            boolean a = C6924m.m32479a(c5384b, z);
            if (c5384b.m22837a() != null) {
                m22925a(c5384b.m22837a());
            }
            if (c5384b.m22840b() != null) {
                super.m22926a(c5384b.m22840b(), m22932d());
            }
            m32481b(c5384b, a);
            if (c5384b.m22844e()) {
                m32473a(c5384b.m22845f(), a);
            }
        }
    }

    /* renamed from: b */
    private void m32481b(C5384b c5384b, boolean z) {
        for (C5392b c5392b : c5384b.m22846g()) {
            boolean z2 = z && C5395h.m22913b(c5392b);
            if (c5392b.m22893c() != null) {
                String b = c5392b.m22891b();
                C5393c c = c5392b.m22893c();
                C6925n a = m22919a(b);
                C6923j c6923j = (C6923j) c5392b;
                Object a2 = m22920a(c6923j, c, a, c6923j.m32462f(), z2);
                c5384b.m22838a(c6923j, a2);
                m22923a(a2, c5392b);
            }
        }
    }

    /* renamed from: l */
    private void m32485l() {
        this.f24771b = true;
        Iterator it = m22931c().iterator();
        while (it.hasNext()) {
            new C5390b(this, (String) it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* renamed from: a */
    private void m32476a(String str, HashMap<C6923j, Object> hashMap) {
        for (C5392b c5392b : hashMap.keySet()) {
            C6925n c6925n = (C6925n) m22932d().get(c5392b.m22891b());
            C6923j c6923j = (C6923j) c5392b;
            C6925n f = c6923j.m32462f();
            if ("Point".equals(c5392b.m22893c().mo4901c())) {
                Object obj = 1;
                Object obj2 = (f == null || !str.equals(f.m32513g())) ? null : 1;
                if (c6925n == null || !str.equals(c6925n.m32513g())) {
                    obj = null;
                }
                if (obj2 != null) {
                    m32472a(f, (HashMap) hashMap, c6923j);
                } else if (obj != null) {
                    m32472a(c6925n, (HashMap) hashMap, c6923j);
                }
            }
        }
    }

    /* renamed from: a */
    private void m32472a(C6925n c6925n, HashMap<C6923j, Object> hashMap, C6923j c6923j) {
        double d = c6925n.m32506d();
        ((C5143l) hashMap.get(c6923j)).m21792a(C6924m.m32466a((Bitmap) m22934f().a(c6925n.m32513g()), Double.valueOf(d)));
    }

    /* renamed from: a */
    private void m32474a(String str, Iterable<C5384b> iterable) {
        for (C5384b c5384b : iterable) {
            m32476a(str, c5384b.m22843d());
            if (c5384b.m22844e()) {
                m32474a(str, c5384b.m22845f());
            }
        }
    }

    /* renamed from: a */
    private void m32478a(HashMap<C5387e, C5139g> hashMap, Iterable<C5384b> iterable) {
        m32484c((HashMap) hashMap);
        for (C5384b c5384b : iterable) {
            m32478a(c5384b.m22841c(), c5384b.m22845f());
        }
    }

    /* renamed from: c */
    private void m32484c(HashMap<C5387e, C5139g> hashMap) {
        hashMap = hashMap.keySet().iterator();
        while (hashMap.hasNext()) {
            C5387e c5387e = (C5387e) hashMap.next();
            String a = c5387e.m22866a();
            if (!(a == null || c5387e.m22867b() == null)) {
                if (m22934f().a(a) != null) {
                    m32477a(a, this.f24773d, true);
                } else if (!this.f24770a.contains(a)) {
                    this.f24770a.add(a);
                }
            }
        }
    }

    /* renamed from: m */
    private void m32486m() {
        this.f24772c = true;
        Iterator it = this.f24770a.iterator();
        while (it.hasNext()) {
            new C5389a(this, (String) it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* renamed from: a */
    private void m32477a(String str, HashMap<C5387e, C5139g> hashMap, boolean z) {
        C5136a a = C5137b.m21764a((Bitmap) m22934f().a(str));
        for (C5387e c5387e : hashMap.keySet()) {
            if (c5387e.m22866a().equals(str)) {
                C5139g a2 = m22915a(c5387e.m22868c().m38301a(a));
                if (!z) {
                    a2.m21778a(false);
                }
                hashMap.put(c5387e, a2);
            }
        }
    }

    /* renamed from: a */
    private void m32475a(String str, Iterable<C5384b> iterable, boolean z) {
        for (C5384b c5384b : iterable) {
            boolean a = C6924m.m32479a(c5384b, z);
            m32477a(str, c5384b.m22841c(), a);
            if (c5384b.m22844e()) {
                m32475a(str, c5384b.m22845f(), a);
            }
        }
    }
}
