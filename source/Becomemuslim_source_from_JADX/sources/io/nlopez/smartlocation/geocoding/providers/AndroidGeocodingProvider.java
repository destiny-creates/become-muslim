package io.nlopez.smartlocation.geocoding.providers;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.facebook.places.model.PlaceFields;
import io.nlopez.smartlocation.C6542b;
import io.nlopez.smartlocation.C6545e;
import io.nlopez.smartlocation.geocoding.C6553a;
import io.nlopez.smartlocation.geocoding.p365a.C6552a;
import io.nlopez.smartlocation.p364b.C6538b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class AndroidGeocodingProvider implements C6553a {
    /* renamed from: a */
    private static final String f26384a;
    /* renamed from: b */
    private static final String f26385b;
    /* renamed from: c */
    private Locale f26386c;
    /* renamed from: d */
    private C6542b f26387d;
    /* renamed from: e */
    private C6545e f26388e;
    /* renamed from: f */
    private HashMap<String, Integer> f26389f;
    /* renamed from: g */
    private HashMap<Location, Integer> f26390g;
    /* renamed from: h */
    private Context f26391h;
    /* renamed from: i */
    private C6538b f26392i;
    /* renamed from: j */
    private BroadcastReceiver f26393j;
    /* renamed from: k */
    private BroadcastReceiver f26394k;

    /* renamed from: io.nlopez.smartlocation.geocoding.providers.AndroidGeocodingProvider$1 */
    class C65541 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ AndroidGeocodingProvider f21070a;

        C65541(AndroidGeocodingProvider androidGeocodingProvider) {
            this.f21070a = androidGeocodingProvider;
        }

        public void onReceive(Context context, Intent intent) {
            if (AndroidGeocodingProvider.f26384a.equals(intent.getAction()) != null) {
                this.f21070a.f26392i.mo5497a("sending new direct geocoding response", new Object[0]);
                if (this.f21070a.f26387d != null) {
                    this.f21070a.f26387d.onLocationResolved(intent.getStringExtra("name"), intent.getParcelableArrayListExtra("result"));
                }
            }
        }
    }

    /* renamed from: io.nlopez.smartlocation.geocoding.providers.AndroidGeocodingProvider$2 */
    class C65552 extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ AndroidGeocodingProvider f21071a;

        C65552(AndroidGeocodingProvider androidGeocodingProvider) {
            this.f21071a = androidGeocodingProvider;
        }

        public void onReceive(Context context, Intent intent) {
            if (AndroidGeocodingProvider.f26385b.equals(intent.getAction()) != null) {
                this.f21071a.f26392i.mo5497a("sending new reverse geocoding response", new Object[0]);
                if (this.f21071a.f26388e != null) {
                    this.f21071a.f26388e.onAddressResolved((Location) intent.getParcelableExtra(PlaceFields.LOCATION), (ArrayList) intent.getSerializableExtra("result"));
                }
            }
        }
    }

    public static class AndroidGeocodingService extends IntentService {
        /* renamed from: a */
        private Geocoder f21072a;

        public AndroidGeocodingService() {
            super(AndroidGeocodingService.class.getSimpleName());
        }

        protected void onHandleIntent(Intent intent) {
            Locale locale = (Locale) intent.getSerializableExtra("locale");
            if (locale == null) {
                this.f21072a = new Geocoder(this);
            } else {
                this.f21072a = new Geocoder(this, locale);
            }
            if (intent.hasExtra("direct")) {
                HashMap hashMap = (HashMap) intent.getSerializableExtra("direct");
                for (String str : hashMap.keySet()) {
                    m26755a(str, m26753a(str, ((Integer) hashMap.get(str)).intValue()));
                }
            }
            if (intent.hasExtra("reverse")) {
                HashMap hashMap2 = (HashMap) intent.getSerializableExtra("reverse");
                for (Location location : hashMap2.keySet()) {
                    m26754a(location, m26752a(location, ((Integer) hashMap2.get(location)).intValue()));
                }
            }
        }

        /* renamed from: a */
        private void m26755a(String str, ArrayList<C6552a> arrayList) {
            Intent intent = new Intent(AndroidGeocodingProvider.f26384a);
            intent.putExtra("name", str);
            intent.putExtra("result", arrayList);
            sendBroadcast(intent);
        }

        /* renamed from: a */
        private void m26754a(Location location, ArrayList<Address> arrayList) {
            Intent intent = new Intent(AndroidGeocodingProvider.f26385b);
            intent.putExtra(PlaceFields.LOCATION, location);
            intent.putExtra("result", arrayList);
            sendBroadcast(intent);
        }

        /* renamed from: a */
        private java.util.ArrayList<android.location.Address> m26752a(android.location.Location r8, int r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r7 = this;
            r0 = new java.util.ArrayList;	 Catch:{ IOException -> 0x0015 }
            r1 = r7.f21072a;	 Catch:{ IOException -> 0x0015 }
            r2 = r8.getLatitude();	 Catch:{ IOException -> 0x0015 }
            r4 = r8.getLongitude();	 Catch:{ IOException -> 0x0015 }
            r6 = r9;	 Catch:{ IOException -> 0x0015 }
            r8 = r1.getFromLocation(r2, r4, r6);	 Catch:{ IOException -> 0x0015 }
            r0.<init>(r8);	 Catch:{ IOException -> 0x0015 }
            return r0;
        L_0x0015:
            r8 = new java.util.ArrayList;
            r8.<init>();
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.nlopez.smartlocation.geocoding.providers.AndroidGeocodingProvider.AndroidGeocodingService.a(android.location.Location, int):java.util.ArrayList<android.location.Address>");
        }

        /* renamed from: a */
        private java.util.ArrayList<io.nlopez.smartlocation.geocoding.p365a.C6552a> m26753a(java.lang.String r3, int r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = r2.f21072a;	 Catch:{ IOException -> 0x0025 }
            r3 = r0.getFromLocationName(r3, r4);	 Catch:{ IOException -> 0x0025 }
            r4 = new java.util.ArrayList;	 Catch:{ IOException -> 0x0025 }
            r4.<init>();	 Catch:{ IOException -> 0x0025 }
            r3 = r3.iterator();	 Catch:{ IOException -> 0x0025 }
        L_0x000f:
            r0 = r3.hasNext();	 Catch:{ IOException -> 0x0025 }
            if (r0 == 0) goto L_0x0024;	 Catch:{ IOException -> 0x0025 }
        L_0x0015:
            r0 = r3.next();	 Catch:{ IOException -> 0x0025 }
            r0 = (android.location.Address) r0;	 Catch:{ IOException -> 0x0025 }
            r1 = new io.nlopez.smartlocation.geocoding.a.a;	 Catch:{ IOException -> 0x0025 }
            r1.<init>(r0);	 Catch:{ IOException -> 0x0025 }
            r4.add(r1);	 Catch:{ IOException -> 0x0025 }
            goto L_0x000f;
        L_0x0024:
            return r4;
        L_0x0025:
            r3 = new java.util.ArrayList;
            r3.<init>();
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.nlopez.smartlocation.geocoding.providers.AndroidGeocodingProvider.AndroidGeocodingService.a(java.lang.String, int):java.util.ArrayList<io.nlopez.smartlocation.geocoding.a.a>");
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AndroidGeocodingProvider.class.getCanonicalName());
        stringBuilder.append(".DIRECT_GEOCODE_ACTION");
        f26384a = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(AndroidGeocodingProvider.class.getCanonicalName());
        stringBuilder.append(".REVERSE_GEOCODE_ACTION");
        f26385b = stringBuilder.toString();
    }

    public AndroidGeocodingProvider() {
        this(Locale.getDefault());
    }

    public AndroidGeocodingProvider(Locale locale) {
        this.f26393j = new C65541(this);
        this.f26394k = new C65552(this);
        if (locale != null) {
            this.f26386c = locale;
            this.f26389f = new HashMap();
            this.f26390g = new HashMap();
            if (Geocoder.isPresent() == null) {
                throw new RuntimeException("Android Geocoder not present. Please check if Geocoder.isPresent() before invoking the search");
            }
            return;
        }
        throw new RuntimeException("Locale is null");
    }

    /* renamed from: a */
    public void mo5503a(Context context, C6538b c6538b) {
        this.f26392i = c6538b;
        this.f26391h = context;
    }

    /* renamed from: a */
    public void mo5506a(String str, int i) {
        this.f26389f.put(str, Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo5504a(Location location, int i) {
        this.f26390g.put(location, Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo5505a(C6542b c6542b, C6545e c6545e) {
        this.f26387d = c6542b;
        this.f26388e = c6545e;
        if (this.f26389f.isEmpty() == null || this.f26390g.isEmpty() == null) {
            c6542b = new IntentFilter(f26384a);
            c6545e = new IntentFilter(f26385b);
            Intent intent = new Intent(this.f26391h, AndroidGeocodingService.class);
            intent.putExtra("locale", this.f26386c);
            if (!this.f26389f.isEmpty()) {
                this.f26391h.registerReceiver(this.f26393j, c6542b);
                intent.putExtra("direct", this.f26389f);
            }
            if (this.f26390g.isEmpty() == null) {
                this.f26391h.registerReceiver(this.f26394k, c6545e);
                intent.putExtra("reverse", this.f26390g);
            }
            this.f26391h.startService(intent);
            this.f26389f.clear();
            this.f26390g.clear();
            return;
        }
        this.f26392i.mo5500c("No direct geocoding or reverse geocoding points added", new Object[0]);
    }

    /* renamed from: a */
    public void mo5502a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.f26391h;	 Catch:{ IllegalArgumentException -> 0x0009 }
        r2 = r4.f26393j;	 Catch:{ IllegalArgumentException -> 0x0009 }
        r1.unregisterReceiver(r2);	 Catch:{ IllegalArgumentException -> 0x0009 }
        goto L_0x0012;
    L_0x0009:
        r1 = r4.f26392i;
        r2 = "Silenced 'receiver not registered' stuff (calling stop more times than necessary did this)";
        r3 = new java.lang.Object[r0];
        r1.mo5497a(r2, r3);
    L_0x0012:
        r1 = r4.f26391h;	 Catch:{ IllegalArgumentException -> 0x001a }
        r2 = r4.f26394k;	 Catch:{ IllegalArgumentException -> 0x001a }
        r1.unregisterReceiver(r2);	 Catch:{ IllegalArgumentException -> 0x001a }
        goto L_0x0023;
    L_0x001a:
        r1 = r4.f26392i;
        r2 = "Silenced 'receiver not registered' stuff (calling stop more times than necessary did this)";
        r0 = new java.lang.Object[r0];
        r1.mo5497a(r2, r0);
    L_0x0023:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.nlopez.smartlocation.geocoding.providers.AndroidGeocodingProvider.a():void");
    }
}
