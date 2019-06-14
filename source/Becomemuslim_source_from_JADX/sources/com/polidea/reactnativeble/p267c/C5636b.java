package com.polidea.reactnativeble.p267c;

import com.facebook.stetho.server.http.HttpStatus;

/* compiled from: BleErrorCode */
/* renamed from: com.polidea.reactnativeble.c.b */
public enum C5636b {
    f18847a(0),
    BluetoothManagerDestroyed(1),
    OperationCancelled(2),
    OperationTimedOut(3),
    OperationStartFailed(4),
    InvalidIdentifiers(5),
    BluetoothUnsupported(100),
    BluetoothUnauthorized(101),
    BluetoothPoweredOff(102),
    BluetoothInUnknownState(103),
    BluetoothResetting(104),
    BluetoothStateChangeFailed(105),
    DeviceConnectionFailed(HttpStatus.HTTP_OK),
    DeviceDisconnected(201),
    DeviceRSSIReadFailed(202),
    DeviceAlreadyConnected(203),
    DeviceNotFound(204),
    DeviceNotConnected(205),
    DeviceMTUChangeFailed(206),
    ServicesDiscoveryFailed(300),
    IncludedServicesDiscoveryFailed(301),
    ServiceNotFound(302),
    ServicesNotDiscovered(303),
    CharacteristicsDiscoveryFailed(400),
    CharacteristicWriteFailed(401),
    CharacteristicReadFailed(402),
    CharacteristicNotifyChangeFailed(403),
    CharacteristicNotFound(HttpStatus.HTTP_NOT_FOUND),
    CharacteristicsNotDiscovered(405),
    CharacteristicInvalidDataFormat(406),
    DescriptorsDiscoveryFailed(HttpStatus.HTTP_INTERNAL_SERVER_ERROR),
    DescriptorWriteFailed(HttpStatus.HTTP_NOT_IMPLEMENTED),
    DescriptorReadFailed(502),
    DescriptorNotFound(503),
    DescriptorsNotDiscovered(504),
    DescriptorInvalidDataFormat(505),
    ScanStartFailed(600),
    LocationServicesDisabled(601);
    
    /* renamed from: M */
    public final int f18873M;

    private C5636b(int i) {
        this.f18873M = i;
    }
}
