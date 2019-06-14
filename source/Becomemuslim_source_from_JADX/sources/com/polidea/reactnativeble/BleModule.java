package com.polidea.reactnativeble;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.polidea.p254a.C5631z;
import com.polidea.p254a.aa;
import com.polidea.p254a.aa.C5552a;
import com.polidea.p254a.ac;
import com.polidea.p254a.af;
import com.polidea.p254a.af.C5554a;
import com.polidea.p254a.ah;
import com.polidea.p254a.ai;
import com.polidea.p254a.p255a.C6971d;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5619b.C5618a;
import com.polidea.p254a.p263c.C5621d;
import com.polidea.p254a.p263c.C5624e.C5623a;
import com.polidea.reactnativeble.p266b.C7108b;
import com.polidea.reactnativeble.p267c.C5635a;
import com.polidea.reactnativeble.p267c.C5636b;
import com.polidea.reactnativeble.p267c.C5637c;
import com.polidea.reactnativeble.p267c.C5638d;
import com.polidea.reactnativeble.p268d.C5640a;
import com.polidea.reactnativeble.p269e.C5642b;
import com.polidea.reactnativeble.p269e.C5643c;
import com.polidea.reactnativeble.p269e.C5645e;
import com.polidea.reactnativeble.p269e.C5646f;
import com.polidea.reactnativeble.p269e.C5648h;
import com.polidea.reactnativeble.p269e.C5649i;
import com.polidea.reactnativeble.p269e.C7109g;
import com.polidea.reactnativeble.p270f.C5650a;
import com.polidea.reactnativeble.p270f.C5651b;
import com.polidea.reactnativeble.p270f.C5652c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import p289e.C5974e;
import p289e.C5982f;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;

public class BleModule extends ReactContextBaseJavaModule {
    private static final String NAME = "BleClientManager";
    private C5989l adapterStateChangesSubscription;
    private HashMap<String, C5651b> connectedDevices = new HashMap();
    private final C5642b connectingDevices = new C5642b();
    private int currentLogLevel = Integer.MAX_VALUE;
    private SparseArray<C5650a> discoveredCharacteristics = new SparseArray();
    private HashMap<String, C5651b> discoveredDevices = new HashMap();
    private SparseArray<C5652c> discoveredServices = new SparseArray();
    private final C5638d errorConverter = new C5638d();
    private ac rxBleClient;
    private final C7108b scanConverter = new C7108b();
    private C5989l scanSubscription;
    private final C5642b transactions = new C5642b();

    /* renamed from: com.polidea.reactnativeble.BleModule$2 */
    class C70992 implements C5919g<C5552a, String> {
        /* renamed from: a */
        final /* synthetic */ BleModule f25218a;

        C70992(BleModule bleModule) {
            this.f25218a = bleModule;
        }

        /* renamed from: a */
        public String m33087a(C5552a c5552a) {
            return this.f25218a.rxAndroidBleAdapterStateToReactNativeBluetoothState(c5552a);
        }
    }

    /* renamed from: com.polidea.reactnativeble.BleModule$3 */
    class C71003 implements C5914b<C5621d> {
        /* renamed from: a */
        final /* synthetic */ BleModule f25234a;

        C71003(BleModule bleModule) {
            this.f25234a = bleModule;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m33099a((C5621d) obj);
        }

        /* renamed from: a */
        public void m33099a(C5621d c5621d) {
            String c = c5621d.m23906a().mo5026c();
            if (!this.f25234a.discoveredDevices.containsKey(c)) {
                this.f25234a.discoveredDevices.put(c, new C5651b(c5621d.m23906a(), null));
            }
            this.f25234a.sendEvent(C5634b.ScanEvent, this.f25234a.scanConverter.m23948b(c5621d));
        }
    }

    /* renamed from: com.polidea.reactnativeble.BleModule$4 */
    class C71014 implements C5914b<Throwable> {
        /* renamed from: a */
        final /* synthetic */ BleModule f25235a;

        C71014(BleModule bleModule) {
            this.f25235a = bleModule;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m33101a((Throwable) obj);
        }

        /* renamed from: a */
        public void m33101a(Throwable th) {
            this.f25235a.sendEvent(C5634b.ScanEvent, this.f25235a.errorConverter.m23966a(th).m23953b());
        }
    }

    private String nativeAdapterStateToReactNativeBluetoothState(int i) {
        switch (i) {
            case 10:
                return "PoweredOff";
            case 11:
            case 13:
                return "Resetting";
            case 12:
                return "PoweredOn";
            default:
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    public String getName() {
        return NAME;
    }

    public BleModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        for (C5634b c5634b : C5634b.values()) {
            hashMap.put(c5634b.f18825f, c5634b.f18825f);
        }
        return hashMap;
    }

    @ReactMethod
    public void createClient(String str) {
        Context reactApplicationContext = getReactApplicationContext();
        this.rxBleClient = ac.m23618a(reactApplicationContext);
        this.adapterStateChangesSubscription = monitorAdapterStateChanges(reactApplicationContext);
        if (str != null) {
            sendEvent(C5634b.RestoreStateEvent, null);
        }
    }

    @ReactMethod
    public void destroyClient() {
        if (this.adapterStateChangesSubscription != null) {
            this.adapterStateChangesSubscription.U_();
            this.adapterStateChangesSubscription = null;
        }
        if (!(this.scanSubscription == null || this.scanSubscription.mo5121b())) {
            this.scanSubscription.U_();
            this.scanSubscription = null;
        }
        this.transactions.m23971a();
        this.connectingDevices.m23971a();
        this.discoveredServices.clear();
        this.discoveredCharacteristics.clear();
        this.connectedDevices.clear();
        this.discoveredDevices.clear();
        this.rxBleClient = null;
        C5643c.m23975a();
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        destroyClient();
    }

    @ReactMethod
    public void cancelTransaction(String str) {
        this.transactions.m23973a(str);
    }

    @ReactMethod
    public void setLogLevel(String str) {
        this.currentLogLevel = C5645e.m23976a(str);
        ac.m23619a(this.currentLogLevel);
    }

    @ReactMethod
    public void logLevel(Promise promise) {
        promise.resolve(C5645e.m23977a(this.currentLogLevel));
    }

    @ReactMethod
    public void enable(final String str, Promise promise) {
        Context reactApplicationContext = getReactApplicationContext();
        BluetoothManager bluetoothManager = (BluetoothManager) reactApplicationContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            new C5635a(C5636b.BluetoothStateChangeFailed, "BluetoothManager is null", null).m23951a(promise);
            return;
        }
        final C5648h c5648h = new C5648h(promise);
        promise = bluetoothManager.getAdapter();
        C5989l a = new aa(reactApplicationContext).m25043k(new C5919g<C5552a, Boolean>(this) {
            /* renamed from: a */
            final /* synthetic */ BleModule f25222a;

            {
                this.f25222a = r1;
            }

            /* renamed from: a */
            public Boolean m33089a(C5552a c5552a) {
                return Boolean.valueOf(C5552a.f18610a == c5552a ? true : null);
            }
        }).m25028e().m24819b(new C5913a(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25199c;

            /* renamed from: a */
            public void mo4985a() {
                C5637c.m23954a().m23952a(c5648h);
                this.f25199c.transactions.m23973a(str);
            }
        }).m24814a(new C5913a(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25185c;

            /* renamed from: a */
            public void mo4985a() {
                c5648h.m23980a(null);
                this.f25185c.transactions.m23973a(str);
            }
        }, new C5914b<Throwable>(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25164c;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m33047a((Throwable) obj);
            }

            /* renamed from: a */
            public void m33047a(Throwable th) {
                this.f25164c.errorConverter.m23966a(th).m23952a(c5648h);
                this.f25164c.transactions.m23973a(str);
            }
        });
        if (promise.enable() == null) {
            a.U_();
            new C5635a(C5636b.BluetoothStateChangeFailed, "Couldn't enable bluetooth adapter", null).m23952a(c5648h);
        } else {
            this.transactions.m23972a(str, a);
        }
    }

    @ReactMethod
    public void disable(final String str, Promise promise) {
        Context reactApplicationContext = getReactApplicationContext();
        BluetoothManager bluetoothManager = (BluetoothManager) reactApplicationContext.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            new C5635a(C5636b.BluetoothStateChangeFailed, "BluetoothManager is null", null).m23951a(promise);
            return;
        }
        final C5648h c5648h = new C5648h(promise);
        promise = bluetoothManager.getAdapter();
        C5989l a = new aa(reactApplicationContext).m25043k(new C5919g<C5552a, Boolean>(this) {
            /* renamed from: a */
            final /* synthetic */ BleModule f25232a;

            {
                this.f25232a = r1;
            }

            /* renamed from: a */
            public Boolean m33095a(C5552a c5552a) {
                return Boolean.valueOf(C5552a.f18611b == c5552a ? true : null);
            }
        }).m25028e().m24819b(new C5913a(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25231c;

            /* renamed from: a */
            public void mo4985a() {
                C5637c.m23954a().m23952a(c5648h);
                this.f25231c.transactions.m23973a(str);
            }
        }).m24814a(new C5913a(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25225c;

            /* renamed from: a */
            public void mo4985a() {
                c5648h.m23980a(null);
                this.f25225c.transactions.m23973a(str);
            }
        }, new C5914b<Throwable>(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25228c;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m33092a((Throwable) obj);
            }

            /* renamed from: a */
            public void m33092a(Throwable th) {
                this.f25228c.errorConverter.m23966a(th).m23952a(c5648h);
                this.f25228c.transactions.m23973a(str);
            }
        });
        if (promise.disable() == null) {
            a.U_();
            new C5635a(C5636b.BluetoothStateChangeFailed, "Couldn't enable bluetooth adapter", null).m23952a(c5648h);
        } else {
            this.transactions.m23972a(str, a);
        }
    }

    @ReactMethod
    public void state(Promise promise) {
        promise.resolve(getCurrentState());
    }

    private C5989l monitorAdapterStateChanges(Context context) {
        if (supportsBluetoothLowEnergy()) {
            return new aa(context).m25030e((C5919g) new C70992(this)).m25021c(new C5914b<String>(this) {
                /* renamed from: a */
                final /* synthetic */ BleModule f25233a;

                {
                    this.f25233a = r1;
                }

                /* renamed from: b */
                public /* synthetic */ void mo4974b(Object obj) {
                    m33097a((String) obj);
                }

                /* renamed from: a */
                public void m33097a(String str) {
                    this.f25233a.sendEvent(C5634b.StateChangeEvent, str);
                }
            });
        }
        return null;
    }

    private String getCurrentState() {
        if (!supportsBluetoothLowEnergy()) {
            return "Unsupported";
        }
        BluetoothManager bluetoothManager = (BluetoothManager) getReactApplicationContext().getSystemService("bluetooth");
        if (bluetoothManager == null) {
            return "PoweredOff";
        }
        return nativeAdapterStateToReactNativeBluetoothState(bluetoothManager.getAdapter().getState());
    }

    private boolean supportsBluetoothLowEnergy() {
        return getReactApplicationContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    private String rxAndroidBleAdapterStateToReactNativeBluetoothState(C5552a c5552a) {
        if (c5552a == C5552a.f18610a) {
            return "PoweredOn";
        }
        return c5552a == C5552a.f18611b ? "PoweredOff" : "Resetting";
    }

    @ReactMethod
    public void startDeviceScan(ReadableArray readableArray, ReadableMap readableMap) {
        int i = 0;
        int i2 = 1;
        if (readableMap != null) {
            if (readableMap.hasKey("scanMode") && readableMap.getType("scanMode") == ReadableType.Number) {
                i = readableMap.getInt("scanMode");
            }
            if (readableMap.hasKey("callbackType") && readableMap.getType("callbackType") == ReadableType.Number) {
                i2 = readableMap.getInt("callbackType");
            }
        }
        if (readableArray != null) {
            readableMap = C5649i.m23984a(readableArray);
            if (readableMap == null) {
                sendEvent(C5634b.ScanEvent, C5637c.m23959a(C5646f.m23978a(readableArray)).m23953b());
                return;
            }
        }
        readableMap = null;
        safeStartDeviceScan(readableMap, i, i2);
    }

    private void safeStartDeviceScan(UUID[] uuidArr, int i, int i2) {
        if (this.rxBleClient != null) {
            int i3;
            i = new C5623a().m23912a(i).m23914b(i2).m23913a();
            if (uuidArr == null) {
                i3 = 0;
            } else {
                i3 = uuidArr.length;
            }
            C5619b[] c5619bArr = new C5619b[i3];
            for (i2 = 0; i2 < i3; i2++) {
                c5619bArr[i2] = new C5618a().m23877a(ParcelUuid.fromString(uuidArr[i2].toString())).m23882a();
            }
            this.scanSubscription = this.rxBleClient.mo4978a(i, c5619bArr).m25005a(new C71003(this), new C71014(this));
            return;
        }
        throw new IllegalStateException("BleManager not created when tried to start device scan");
    }

    @ReactMethod
    public void stopDeviceScan() {
        if (this.scanSubscription != null) {
            if (!this.scanSubscription.mo5121b()) {
                this.scanSubscription.U_();
            }
            this.scanSubscription = null;
        }
    }

    @ReactMethod
    public void devices(ReadableArray readableArray, Promise promise) {
        if (this.rxBleClient != null) {
            WritableArray createArray = Arguments.createArray();
            for (int i = 0; i < readableArray.size(); i++) {
                String string = readableArray.getString(i);
                if (string == null) {
                    C5637c.m23955a(readableArray).m23951a(promise);
                    return;
                }
                C5651b c5651b = (C5651b) this.discoveredDevices.get(string);
                if (c5651b != null) {
                    createArray.pushMap(c5651b.m23992a(null));
                }
            }
            promise.resolve(createArray);
            return;
        }
        throw new IllegalStateException("BleManager not created when tried connecting to device");
    }

    @ReactMethod
    public void connectedDevices(ReadableArray readableArray, Promise promise) {
        if (this.rxBleClient != null) {
            UUID[] uuidArr = new UUID[readableArray.size()];
            int i = 0;
            while (i < readableArray.size()) {
                UUID a = C5649i.m23983a(readableArray.getString(i));
                if (a == null) {
                    C5637c.m23955a(readableArray).m23951a(promise);
                    return;
                } else {
                    uuidArr[i] = a;
                    i++;
                }
            }
            readableArray = Arguments.createArray();
            for (C5651b c5651b : this.connectedDevices.values()) {
                for (UUID a2 : uuidArr) {
                    if (c5651b.m23993a(a2) != null) {
                        readableArray.pushMap(c5651b.m23992a(null));
                        break;
                    }
                }
            }
            promise.resolve(readableArray);
            return;
        }
        throw new IllegalStateException("BleManager not created when tried connecting to device");
    }

    @ReactMethod
    public void requestConnectionPriorityForDevice(String str, int i, final String str2, Promise promise) {
        final C5651b deviceOrReject = getDeviceOrReject(str, promise);
        if (deviceOrReject != null) {
            af connectionOrReject = getConnectionOrReject(deviceOrReject, promise);
            if (connectionOrReject != null) {
                if (VERSION.SDK_INT >= 21) {
                    final C5648h c5648h = new C5648h(promise);
                    this.transactions.m23972a(str2, connectionOrReject.mo4986a(i, 1, TimeUnit.MILLISECONDS).m24819b(new C5913a(this) {
                        /* renamed from: c */
                        final /* synthetic */ BleModule f25245c;

                        /* renamed from: a */
                        public void mo4985a() {
                            C5637c.m23954a().m23952a(c5648h);
                            this.f25245c.transactions.m23973a(str2);
                        }
                    }).m24814a(new C5913a(this) {
                        /* renamed from: d */
                        final /* synthetic */ BleModule f25239d;

                        /* renamed from: a */
                        public void mo4985a() {
                            c5648h.m23980a(deviceOrReject.m23992a(null));
                            this.f25239d.transactions.m23973a(str2);
                        }
                    }, new C5914b<Throwable>(this) {
                        /* renamed from: c */
                        final /* synthetic */ BleModule f25242c;

                        /* renamed from: b */
                        public /* synthetic */ void mo4974b(Object obj) {
                            m33104a((Throwable) obj);
                        }

                        /* renamed from: a */
                        public void m33104a(Throwable th) {
                            this.f25242c.errorConverter.m23966a(th).m23952a(c5648h);
                            this.f25242c.transactions.m23973a(str2);
                        }
                    }));
                } else {
                    promise.resolve(deviceOrReject.m23992a((Integer) 0));
                }
            }
        }
    }

    @ReactMethod
    public void requestMTUForDevice(String str, int i, final String str2, Promise promise) {
        final C5651b deviceOrReject = getDeviceOrReject(str, promise);
        if (deviceOrReject != null) {
            af connectionOrReject = getConnectionOrReject(deviceOrReject, promise);
            if (connectionOrReject != null) {
                if (VERSION.SDK_INT >= 21) {
                    final C5648h c5648h = new C5648h(promise);
                    this.transactions.m23972a(str2, connectionOrReject.mo4988a(i).m25018c(new C5913a(this) {
                        /* renamed from: c */
                        final /* synthetic */ BleModule f25252c;

                        /* renamed from: a */
                        public void mo4985a() {
                            C5637c.m23954a().m23952a(c5648h);
                            this.f25252c.transactions.m23973a(str2);
                        }
                    }).m25006a(new C5982f<Integer>(this) {
                        /* renamed from: d */
                        final /* synthetic */ BleModule f25249d;

                        public void L_() {
                            this.f25249d.transactions.m23973a(str2);
                        }

                        /* renamed from: a */
                        public void mo5001a(Throwable th) {
                            this.f25249d.errorConverter.m23966a(th).m23952a(c5648h);
                            this.f25249d.transactions.m23973a(str2);
                        }

                        /* renamed from: a */
                        public void m33107a(Integer num) {
                            c5648h.m23980a(deviceOrReject.m23992a(null));
                        }
                    }));
                } else {
                    promise.resolve(deviceOrReject.m23992a((Integer) 0));
                }
            }
        }
    }

    @ReactMethod
    public void readRSSIForDevice(String str, final String str2, Promise promise) {
        final C5651b deviceOrReject = getDeviceOrReject(str, promise);
        if (deviceOrReject != null) {
            af connectionOrReject = getConnectionOrReject(deviceOrReject, promise);
            if (connectionOrReject != null) {
                final C5648h c5648h = new C5648h(promise);
                this.transactions.m23972a(str2, connectionOrReject.mo4993b().m25018c(new C5913a(this) {
                    /* renamed from: c */
                    final /* synthetic */ BleModule f25161c;

                    /* renamed from: a */
                    public void mo4985a() {
                        C5637c.m23954a().m23952a(c5648h);
                        this.f25161c.transactions.m23973a(str2);
                    }
                }).m25006a(new C5982f<Integer>(this) {
                    /* renamed from: d */
                    final /* synthetic */ BleModule f25158d;

                    public void L_() {
                        this.f25158d.transactions.m23973a(str2);
                    }

                    /* renamed from: a */
                    public void mo5001a(Throwable th) {
                        this.f25158d.errorConverter.m23966a(th).m23952a(c5648h);
                        this.f25158d.transactions.m23973a(str2);
                    }

                    /* renamed from: a */
                    public void m33043a(Integer num) {
                        c5648h.m23980a(deviceOrReject.m23992a(num));
                    }
                }));
            }
        }
    }

    @ReactMethod
    public void connectToDevice(String str, ReadableMap readableMap, Promise promise) {
        C5648h c5648h = new C5648h(promise);
        if (this.rxBleClient != null) {
            ah a = this.rxBleClient.mo4977a(str);
            if (a == null) {
                C5637c.m23956a(str).m23952a(c5648h);
                return;
            }
            Integer num;
            int i;
            int i2;
            C5639c c5639c;
            boolean z;
            str = null;
            if (readableMap != null) {
                boolean z2 = (readableMap.hasKey("autoConnect") && readableMap.getType("autoConnect") == ReadableType.Boolean) ? readableMap.getBoolean("autoConnect") : false;
                int i3 = (readableMap.hasKey("requestMTU") && readableMap.getType("requestMTU") == ReadableType.Number) ? readableMap.getInt("requestMTU") : 0;
                C5639c a2 = (readableMap.hasKey("refreshGatt") && readableMap.getType("refreshGatt") == ReadableType.String) ? C5639c.m23967a(readableMap.getString("refreshGatt")) : null;
                if (readableMap.hasKey("timeout") && readableMap.getType("timeout") == ReadableType.Number) {
                    str = Integer.valueOf(readableMap.getInt("timeout"));
                }
                if (readableMap.hasKey("connectionPriority") && readableMap.getType("connectionPriority") == ReadableType.Number) {
                    num = str;
                    i = readableMap.getInt("connectionPriority");
                    i2 = i3;
                    c5639c = a2;
                } else {
                    num = str;
                    i2 = i3;
                    c5639c = a2;
                    i = 0;
                }
                z = z2;
            } else {
                c5639c = null;
                num = c5639c;
                z = false;
                i2 = 0;
                i = 0;
            }
            safeConnectToDevice(a, z, i2, c5639c, num, i, new C5648h(promise));
            return;
        }
        throw new IllegalStateException("BleManager not created when tried connecting to device");
    }

    private void safeConnectToDevice(final ah ahVar, boolean z, final int i, C5639c c5639c, final Integer num, final int i2, final C5648h c5648h) {
        z = ahVar.mo5024a(z).m25018c(new C5913a(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25167c;

            /* renamed from: a */
            public void mo4985a() {
                C5637c.m23954a().m23952a(c5648h);
                this.f25167c.onDeviceDisconnected(ahVar, null);
            }
        });
        if (c5639c == C5639c.ON_CONNECTED) {
            z = z.m25019c(new C5919g<af, C5974e<af>>(this) {
                /* renamed from: a */
                final /* synthetic */ BleModule f25170a;

                {
                    this.f25170a = r1;
                }

                /* renamed from: a */
                public C5974e<af> m33052a(final af afVar) {
                    return afVar.mo4992a(new C7109g()).m25030e(new C5919g<Boolean, af>(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass14 f25169b;

                        /* renamed from: a */
                        public af m33050a(Boolean bool) {
                            return afVar;
                        }
                    });
                }
            });
        }
        if (i2 > 0 && VERSION.SDK_INT >= 21) {
            z = z.m25019c(new C5919g<af, C5974e<af>>(this) {
                /* renamed from: b */
                final /* synthetic */ BleModule f25172b;

                /* renamed from: a */
                public C5974e<af> m33054a(af afVar) {
                    return afVar.mo4986a(i2, 1, TimeUnit.MILLISECONDS).m24821b(C5974e.m24987c((Object) afVar));
                }
            });
        }
        if (i > 0 && VERSION.SDK_INT >= 21) {
            z = z.m25019c(new C5919g<af, C5974e<af>>(this) {
                /* renamed from: b */
                final /* synthetic */ BleModule f25176b;

                /* renamed from: a */
                public C5974e<af> m33058a(final af afVar) {
                    return afVar.mo4988a(i).m25030e(new C5919g<Integer, af>(this) {
                        /* renamed from: b */
                        final /* synthetic */ AnonymousClass16 f25174b;

                        /* renamed from: a */
                        public af m33056a(Integer num) {
                            return afVar;
                        }
                    });
                }
            });
        }
        if (num != null) {
            z = z.m24994a(new C5918f<C5974e<Long>>(this) {
                /* renamed from: b */
                final /* synthetic */ BleModule f25178b;

                public /* synthetic */ Object call() {
                    return m33060a();
                }

                /* renamed from: a */
                public C5974e<Long> m33060a() {
                    return C5974e.m24968a((long) num.intValue(), TimeUnit.MILLISECONDS);
                }
            }, new C5919g<af, C5974e<Long>>(this) {
                /* renamed from: a */
                final /* synthetic */ BleModule f25179a;

                {
                    this.f25179a = r1;
                }

                /* renamed from: a */
                public C5974e<Long> m33061a(af afVar) {
                    return C5974e.m24989g();
                }
            });
        }
        this.connectingDevices.m23972a(ahVar.mo5026c(), z.m25006a(new C5982f<af>(this) {
            /* renamed from: c */
            final /* synthetic */ BleModule f25182c;

            public void L_() {
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                th = this.f25182c.errorConverter.m23966a(th);
                th.m23952a(c5648h);
                this.f25182c.onDeviceDisconnected(ahVar, th);
            }

            /* renamed from: a */
            public void m33063a(af afVar) {
                C5651b c5651b = new C5651b(ahVar, afVar);
                this.f25182c.cleanServicesAndCharacteristicsForDevice(c5651b);
                this.f25182c.connectedDevices.put(ahVar.mo5026c(), c5651b);
                c5648h.m23980a(c5651b.m23992a(null));
            }
        }));
    }

    private void onDeviceDisconnected(ah ahVar, C5635a c5635a) {
        C5651b c5651b = (C5651b) this.connectedDevices.remove(ahVar.mo5026c());
        if (c5651b != null) {
            cleanServicesAndCharacteristicsForDevice(c5651b);
            WritableArray createArray = Arguments.createArray();
            if (c5635a != null) {
                createArray.pushString(c5635a.m23950a());
            } else {
                createArray.pushNull();
            }
            createArray.pushMap(c5651b.m23992a((Integer) null));
            sendEvent(C5634b.DisconnectionEvent, createArray);
            this.connectingDevices.m23973a(ahVar.mo5026c());
        }
    }

    @ReactMethod
    public void cancelDeviceConnection(String str, Promise promise) {
        if (this.rxBleClient != null) {
            ah a = this.rxBleClient.mo4977a(str);
            if (this.connectingDevices.m23973a(str) && a != null) {
                promise.resolve(new C5651b(a, null).m23992a(null));
                return;
            } else if (a == null) {
                C5637c.m23956a(str).m23951a(promise);
                return;
            } else {
                C5637c.m23960b(str).m23951a(promise);
                return;
            }
        }
        throw new IllegalStateException("BleManager not created when tried cancel device connection");
    }

    @ReactMethod
    public void isDeviceConnected(String str, Promise promise) {
        if (this.rxBleClient != null) {
            ah a = this.rxBleClient.mo4977a(str);
            if (a == null) {
                C5637c.m23956a(str).m23951a(promise);
                return;
            } else {
                promise.resolve(Boolean.valueOf(a.mo5023a().equals(C5554a.CONNECTED)));
                return;
            }
        }
        throw new IllegalStateException("BleManager not created when tried cancel device connection");
    }

    @ReactMethod
    public void discoverAllServicesAndCharacteristicsForDevice(String str, String str2, Promise promise) {
        str = getDeviceOrReject(str, promise);
        if (str != null) {
            safeDiscoverAllServicesAndCharacteristicsForDevice(str, str2, new C5648h(promise));
        }
    }

    private void safeDiscoverAllServicesAndCharacteristicsForDevice(final C5651b c5651b, final String str, final C5648h c5648h) {
        af connectionOrReject = getConnectionOrReject(c5651b, c5648h);
        if (connectionOrReject != null) {
            this.transactions.m23972a(str, connectionOrReject.mo4987a().m25018c(new C5913a(this) {
                /* renamed from: c */
                final /* synthetic */ BleModule f25192c;

                /* renamed from: a */
                public void mo4985a() {
                    C5637c.m23954a().m23952a(c5648h);
                    this.f25192c.transactions.m23973a(str);
                }
            }).m25006a(new C5982f<ai>(this) {
                /* renamed from: d */
                final /* synthetic */ BleModule f25189d;

                public void L_() {
                    c5648h.m23980a(c5651b.m23992a(null));
                    this.f25189d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void mo5001a(Throwable th) {
                    this.f25189d.errorConverter.m23966a(th).m23952a(c5648h);
                    this.f25189d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void m33067a(ai aiVar) {
                    List arrayList = new ArrayList();
                    for (BluetoothGattService bluetoothGattService : aiVar.m23638a()) {
                        C5652c c5652c = new C5652c(c5651b, bluetoothGattService);
                        this.f25189d.discoveredServices.put(c5652c.m23998a(), c5652c);
                        arrayList.add(c5652c);
                        for (BluetoothGattCharacteristic c5650a : bluetoothGattService.getCharacteristics()) {
                            C5650a c5650a2 = new C5650a(c5652c, c5650a);
                            this.f25189d.discoveredCharacteristics.put(c5650a2.m23987a(), c5650a2);
                        }
                    }
                    c5651b.m23995a(arrayList);
                }
            }));
        }
    }

    @ReactMethod
    public void servicesForDevice(String str, Promise promise) {
        str = getDeviceOrReject(str, promise);
        if (str != null) {
            String<C5652c> servicesOrReject = getServicesOrReject(str, promise);
            if (servicesOrReject != null) {
                WritableArray createArray = Arguments.createArray();
                for (C5652c e : servicesOrReject) {
                    createArray.pushMap(e.m24003e());
                }
                promise.resolve(createArray);
            }
        }
    }

    @ReactMethod
    public void characteristicsForDevice(String str, String str2, Promise promise) {
        UUID a = C5649i.m23983a(str2);
        if (a == null) {
            C5637c.m23959a(str2).m23951a(promise);
            return;
        }
        str = getDeviceOrReject(str, promise);
        if (str != null) {
            C5652c a2 = str.m23993a(a);
            if (a2 == null) {
                C5637c.m23962d(str2).m23951a(promise);
            } else {
                characteristicsForService(a2, promise);
            }
        }
    }

    @ReactMethod
    public void characteristicsForService(int i, Promise promise) {
        C5652c c5652c = (C5652c) this.discoveredServices.get(i);
        if (c5652c == null) {
            C5637c.m23962d(Integer.toString(i)).m23951a(promise);
        } else {
            characteristicsForService(c5652c, promise);
        }
    }

    private void characteristicsForService(C5652c c5652c, Promise promise) {
        WritableArray createArray = Arguments.createArray();
        for (C5650a a : c5652c.m24002d()) {
            createArray.pushMap(a.m23988a(null));
        }
        promise.resolve(createArray);
    }

    @ReactMethod
    public void writeCharacteristicForDevice(String str, String str2, String str3, String str4, Boolean bool, String str5, Promise promise) {
        C5650a characteristicOrReject = getCharacteristicOrReject(str, str2, str3, promise);
        if (characteristicOrReject != null) {
            writeCharacteristicWithValue(characteristicOrReject, str4, bool, str5, promise);
        }
    }

    @ReactMethod
    public void writeCharacteristicForService(int i, String str, String str2, Boolean bool, String str3, Promise promise) {
        C5650a characteristicOrReject = getCharacteristicOrReject(i, str, promise);
        if (characteristicOrReject != null) {
            writeCharacteristicWithValue(characteristicOrReject, str2, bool, str3, promise);
        }
    }

    @ReactMethod
    public void writeCharacteristic(int i, String str, Boolean bool, String str2, Promise promise) {
        C5650a characteristicOrReject = getCharacteristicOrReject(i, promise);
        if (characteristicOrReject != null) {
            writeCharacteristicWithValue(characteristicOrReject, str, bool, str2, promise);
        }
    }

    private void writeCharacteristicWithValue(com.polidea.reactnativeble.p270f.C5650a r2, java.lang.String r3, java.lang.Boolean r4, java.lang.String r5, com.facebook.react.bridge.Promise r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = com.polidea.reactnativeble.p269e.C5641a.m23970a(r3);	 Catch:{ Throwable -> 0x001d }
        r3 = r2.m23991c();
        r4 = r4.booleanValue();
        if (r4 == 0) goto L_0x0010;
    L_0x000e:
        r4 = 2;
        goto L_0x0011;
    L_0x0010:
        r4 = 1;
    L_0x0011:
        r3.setWriteType(r4);
        r3 = new com.polidea.reactnativeble.e.h;
        r3.<init>(r6);
        r1.safeWriteCharacteristicForDevice(r2, r0, r5, r3);
        return;
    L_0x001d:
        r2 = r2.m23991c();
        r2 = r2.getUuid();
        r2 = com.polidea.reactnativeble.p269e.C5649i.m23982a(r2);
        r2 = com.polidea.reactnativeble.p267c.C5637c.m23957a(r3, r2);
        r2.m23951a(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.reactnativeble.BleModule.writeCharacteristicWithValue(com.polidea.reactnativeble.f.a, java.lang.String, java.lang.Boolean, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    private void safeWriteCharacteristicForDevice(final C5650a c5650a, byte[] bArr, final String str, final C5648h c5648h) {
        af connectionOrReject = getConnectionOrReject(c5650a.m23990b().m24000b(), c5648h);
        if (connectionOrReject != null) {
            this.transactions.m23972a(str, connectionOrReject.mo4991a(c5650a.m23991c(), bArr).m25018c(new C5913a(this) {
                /* renamed from: c */
                final /* synthetic */ BleModule f25202c;

                /* renamed from: a */
                public void mo4985a() {
                    C5637c.m23954a().m23952a(c5648h);
                    this.f25202c.transactions.m23973a(str);
                }
            }).m25006a(new C5982f<byte[]>(this) {
                /* renamed from: d */
                final /* synthetic */ BleModule f25196d;

                public void L_() {
                    this.f25196d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void mo5001a(Throwable th) {
                    if (th instanceof C6971d) {
                        C5637c.m23961c(C5649i.m23982a(c5650a.m23991c().getUuid())).m23952a(c5648h);
                        return;
                    }
                    this.f25196d.errorConverter.m23966a(th).m23952a(c5648h);
                    this.f25196d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void m33073a(byte[] bArr) {
                    c5650a.m23989a("Write to", bArr);
                    c5648h.m23980a(c5650a.m23988a(bArr));
                }
            }));
        }
    }

    @ReactMethod
    public void readCharacteristicForDevice(String str, String str2, String str3, String str4, Promise promise) {
        str = getCharacteristicOrReject(str, str2, str3, promise);
        if (str != null) {
            safeReadCharacteristicForDevice(str, str4, new C5648h(promise));
        }
    }

    @ReactMethod
    public void readCharacteristicForService(int i, String str, String str2, Promise promise) {
        i = getCharacteristicOrReject(i, str, promise);
        if (i != 0) {
            safeReadCharacteristicForDevice(i, str2, new C5648h(promise));
        }
    }

    @ReactMethod
    public void readCharacteristic(int i, String str, Promise promise) {
        i = getCharacteristicOrReject(i, promise);
        if (i != 0) {
            safeReadCharacteristicForDevice(i, str, new C5648h(promise));
        }
    }

    private void safeReadCharacteristicForDevice(final C5650a c5650a, final String str, final C5648h c5648h) {
        af connectionOrReject = getConnectionOrReject(c5650a.m23990b().m24000b(), c5648h);
        if (connectionOrReject != null) {
            this.transactions.m23972a(str, connectionOrReject.mo4989a(c5650a.m23991c()).m25018c(new C5913a(this) {
                /* renamed from: c */
                final /* synthetic */ BleModule f25209c;

                /* renamed from: a */
                public void mo4985a() {
                    C5637c.m23954a().m23952a(c5648h);
                    this.f25209c.transactions.m23973a(str);
                }
            }).m25006a(new C5982f<byte[]>(this) {
                /* renamed from: d */
                final /* synthetic */ BleModule f25206d;

                public void L_() {
                    this.f25206d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void mo5001a(Throwable th) {
                    if (th instanceof C6971d) {
                        C5637c.m23961c(C5649i.m23982a(c5650a.m23991c().getUuid())).m23952a(c5648h);
                        return;
                    }
                    this.f25206d.errorConverter.m23966a(th).m23952a(c5648h);
                    this.f25206d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void m33078a(byte[] bArr) {
                    c5650a.m23989a("Read from", bArr);
                    c5648h.m23980a(c5650a.m23988a(bArr));
                }
            }));
        }
    }

    @ReactMethod
    public void monitorCharacteristicForDevice(String str, String str2, String str3, String str4, Promise promise) {
        str = getCharacteristicOrReject(str, str2, str3, promise);
        if (str != null) {
            safeMonitorCharacteristicForDevice(str, str4, new C5648h(promise));
        }
    }

    @ReactMethod
    public void monitorCharacteristicForService(int i, String str, String str2, Promise promise) {
        i = getCharacteristicOrReject(i, str, promise);
        if (i != 0) {
            safeMonitorCharacteristicForDevice(i, str2, new C5648h(promise));
        }
    }

    @ReactMethod
    public void monitorCharacteristic(int i, String str, Promise promise) {
        i = getCharacteristicOrReject(i, promise);
        if (i != 0) {
            safeMonitorCharacteristicForDevice(i, str, new C5648h(promise));
        }
    }

    private void safeMonitorCharacteristicForDevice(final C5650a c5650a, final String str, final C5648h c5648h) {
        final af connectionOrReject = getConnectionOrReject(c5650a.m23990b().m24000b(), c5648h);
        if (connectionOrReject != null) {
            final BluetoothGattCharacteristic c = c5650a.m23991c();
            this.transactions.m23972a(str, C5974e.m24971a(new C5918f<C5974e<C5974e<byte[]>>>(this) {
                /* renamed from: c */
                final /* synthetic */ BleModule f25221c;

                public /* synthetic */ Object call() {
                    return m33088a();
                }

                /* renamed from: a */
                public C5974e<C5974e<byte[]>> m33088a() {
                    int properties = c.getProperties();
                    C5631z c5631z = c.getDescriptor(C5650a.f18890a) != null ? C5631z.QUICK_SETUP : C5631z.COMPAT;
                    if ((properties & 16) != 0) {
                        return connectionOrReject.mo4990a(c, c5631z);
                    }
                    if ((properties & 32) != 0) {
                        return connectionOrReject.mo4994b(c, c5631z);
                    }
                    return C5974e.m24984b(new C5640a(c));
                }
            }).m25019c(new C5919g<C5974e<byte[]>, C5974e<byte[]>>(this) {
                /* renamed from: a */
                final /* synthetic */ BleModule f25217a;

                /* renamed from: a */
                public C5974e<byte[]> m33084a(C5974e<byte[]> c5974e) {
                    return c5974e;
                }

                {
                    this.f25217a = r1;
                }
            }).m25018c(new C5913a(this) {
                /* renamed from: c */
                final /* synthetic */ BleModule f25216c;

                /* renamed from: a */
                public void mo4985a() {
                    c5648h.m23980a(null);
                    this.f25216c.transactions.m23973a(str);
                }
            }).m25006a(new C5982f<byte[]>(this) {
                /* renamed from: d */
                final /* synthetic */ BleModule f25213d;

                public void L_() {
                    c5648h.m23980a(null);
                    this.f25213d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void mo5001a(Throwable th) {
                    this.f25213d.errorConverter.m23966a(th).m23952a(c5648h);
                    this.f25213d.transactions.m23973a(str);
                }

                /* renamed from: a */
                public void m33082a(byte[] bArr) {
                    c5650a.m23989a("Notification from", bArr);
                    WritableArray createArray = Arguments.createArray();
                    createArray.pushNull();
                    createArray.pushMap(c5650a.m23988a(bArr));
                    createArray.pushString(str);
                    this.f25213d.sendEvent(C5634b.ReadEvent, createArray);
                }
            }));
        }
    }

    private C5650a getCharacteristicOrReject(String str, String str2, String str3, Promise promise) {
        UUID[] a = C5649i.m23985a(str2, str3);
        if (a == null) {
            C5637c.m23959a(str2, str3).m23951a(promise);
            return null;
        }
        C5651b c5651b = (C5651b) this.connectedDevices.get(str);
        if (c5651b == null) {
            C5637c.m23960b(str).m23951a(promise);
            return null;
        }
        str = c5651b.m23993a(a[0]);
        if (str == null) {
            C5637c.m23962d(str2).m23951a(promise);
            return null;
        }
        str = str.m23999a(a[1]);
        if (str != null) {
            return str;
        }
        C5637c.m23961c(str3).m23951a(promise);
        return null;
    }

    private C5650a getCharacteristicOrReject(int i, String str, Promise promise) {
        UUID a = C5649i.m23983a(str);
        if (a == null) {
            C5637c.m23959a(str).m23951a(promise);
            return null;
        }
        C5652c c5652c = (C5652c) this.discoveredServices.get(i);
        if (c5652c == null) {
            C5637c.m23962d(Integer.toString(i)).m23951a(promise);
            return null;
        }
        i = c5652c.m23999a(a);
        if (i != 0) {
            return i;
        }
        C5637c.m23961c(str).m23951a(promise);
        return null;
    }

    private C5650a getCharacteristicOrReject(int i, Promise promise) {
        C5650a c5650a = (C5650a) this.discoveredCharacteristics.get(i);
        if (c5650a != null) {
            return c5650a;
        }
        C5637c.m23961c(Integer.toString(i)).m23951a(promise);
        return 0;
    }

    private af getConnectionOrReject(C5651b c5651b, Promise promise) {
        af c = c5651b.m23997c();
        if (c != null) {
            return c;
        }
        C5637c.m23960b(c5651b.m23996b().mo5026c()).m23951a(promise);
        return null;
    }

    private af getConnectionOrReject(C5651b c5651b, C5648h c5648h) {
        af c = c5651b.m23997c();
        if (c != null) {
            return c;
        }
        C5637c.m23960b(c5651b.m23996b().mo5026c()).m23952a(c5648h);
        return null;
    }

    private List<C5652c> getServicesOrReject(C5651b c5651b, Promise promise) {
        List<C5652c> a = c5651b.m23994a();
        if (a != null) {
            return a;
        }
        C5637c.m23963e(c5651b.m23996b().mo5026c()).m23951a(promise);
        return null;
    }

    private C5651b getDeviceOrReject(String str, Promise promise) {
        C5651b c5651b = (C5651b) this.connectedDevices.get(str);
        if (c5651b != null) {
            return c5651b;
        }
        C5637c.m23960b(str).m23951a(promise);
        return null;
    }

    private void sendEvent(C5634b c5634b, Object obj) {
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit(c5634b.f18825f, obj);
    }

    private void cleanServicesAndCharacteristicsForDevice(C5651b c5651b) {
        int size;
        for (size = this.discoveredServices.size() - 1; size >= 0; size--) {
            int keyAt = this.discoveredServices.keyAt(size);
            if (((C5652c) this.discoveredServices.get(keyAt)).m24000b().m23996b().mo5026c().equals(c5651b.m23996b().mo5026c())) {
                this.discoveredServices.remove(keyAt);
            }
        }
        for (size = this.discoveredCharacteristics.size() - 1; size >= 0; size--) {
            keyAt = this.discoveredCharacteristics.keyAt(size);
            if (((C5650a) this.discoveredCharacteristics.get(keyAt)).m23990b().m24000b().m23996b().mo5026c().equals(c5651b.m23996b().mo5026c())) {
                this.discoveredCharacteristics.remove(keyAt);
            }
        }
    }
}
