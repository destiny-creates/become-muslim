package versioned.host.exp.exponent.modules.api.cognito;

import com.facebook.ads.internal.p088c.C1354a;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.events.TouchesHelper;
import java.math.BigInteger;

public class RNAWSCognitoModule extends ReactContextBaseJavaModule {
    private static final String HEX_N = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";
    /* renamed from: N */
    private static final BigInteger f32748N = new BigInteger(HEX_N, 16);
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "RNAWSCognito";
    }

    public RNAWSCognitoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void computeModPow(ReadableMap readableMap, Callback callback) {
        try {
            readableMap = new BigInteger(readableMap.getString(TouchesHelper.TARGET_KEY), 16).modPow(new BigInteger(readableMap.getString("value"), 16), new BigInteger(readableMap.getString("modifier"), 16));
            callback.invoke(new Object[]{null, readableMap.toString(16)});
        } catch (ReadableMap readableMap2) {
            callback.invoke(new Object[]{readableMap2.getMessage(), null});
        }
    }

    @ReactMethod
    public void computeS(ReadableMap readableMap, Callback callback) {
        try {
            BigInteger bigInteger = new BigInteger(readableMap.getString("g"), 16);
            BigInteger bigInteger2 = new BigInteger(readableMap.getString("x"), 16);
            BigInteger bigInteger3 = new BigInteger(readableMap.getString("k"), 16);
            BigInteger bigInteger4 = new BigInteger(readableMap.getString(C1354a.f3934a), 16);
            BigInteger bigInteger5 = new BigInteger(readableMap.getString("b"), 16);
            readableMap = bigInteger5.subtract(bigInteger3.multiply(bigInteger.modPow(bigInteger2, f32748N))).modPow(bigInteger4.add(new BigInteger(readableMap.getString("u"), 16).multiply(bigInteger2)), f32748N).mod(f32748N);
            callback.invoke(new Object[]{null, readableMap.toString(16)});
        } catch (ReadableMap readableMap2) {
            callback.invoke(new Object[]{readableMap2.getMessage(), null});
        }
    }
}
