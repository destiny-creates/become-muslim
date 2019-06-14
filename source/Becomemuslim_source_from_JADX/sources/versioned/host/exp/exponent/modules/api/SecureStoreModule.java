package versioned.host.exp.exponent.modules.api;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.facebook.common.time.Clock;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import host.exp.exponent.p346j.C6393j;
import host.exp.p333a.C6271b;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStore.SecretKeyEntry;
import java.security.KeyStoreException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableEntryException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.json.JSONObject;

public class SecureStoreModule extends ReactContextBaseJavaModule {
    private static final String ALIAS_PROPERTY = "keychainService";
    private static final String KEYSTORE_PROVIDER = "AndroidKeyStore";
    private static final String SCHEME_PROPERTY = "scheme";
    private static final String SHARED_PREFERENCES_NAME = "SecureStore";
    private static final String TAG = "SecureStoreModule";
    private AESEncrypter mAESEncrypter = new AESEncrypter();
    private HybridAESEncrypter mHybridAESEncrypter = new HybridAESEncrypter(this.mScopedContext, this.mAESEncrypter);
    private KeyStore mKeyStore;
    private C6393j mScopedContext;

    private interface KeyBasedEncrypter<E extends Entry> {
        JSONObject createEncryptedItem(String str, KeyStore keyStore, E e);

        String decryptItem(JSONObject jSONObject, E e);

        String getKeyStoreAlias(ReadableMap readableMap);

        E initializeKeyStoreEntry(KeyStore keyStore, ReadableMap readableMap);
    }

    private static class LegacySDK20Encrypter {
        private static final String DEFAULT_ALIAS = "MY_APP";
        private static final String RSA_CIPHER = "RSA/ECB/PKCS1Padding";

        private LegacySDK20Encrypter() {
        }

        public String getKeyStoreAlias(ReadableMap readableMap) {
            return readableMap.hasKey(SecureStoreModule.ALIAS_PROPERTY) ? readableMap.getString(SecureStoreModule.ALIAS_PROPERTY) : DEFAULT_ALIAS;
        }

        public String decryptItem(String str, PrivateKeyEntry privateKeyEntry) {
            str = Base64.decode(str, 0);
            Cipher instance = Cipher.getInstance(RSA_CIPHER);
            instance.init(2, privateKeyEntry.getPrivateKey());
            return new String(instance.doFinal(str), StandardCharsets.UTF_8);
        }
    }

    private static class AESEncrypter implements KeyBasedEncrypter<SecretKeyEntry> {
        private static final String AES_CIPHER = "AES/GCM/NoPadding";
        private static final int AES_KEY_SIZE_BITS = 256;
        private static final String CIPHERTEXT_PROPERTY = "ct";
        private static final String DEFAULT_ALIAS = "key_v1";
        private static final String GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY = "tlen";
        private static final String IV_PROPERTY = "iv";
        public static final String NAME = "aes";

        private AESEncrypter() {
        }

        public String getKeyStoreAlias(ReadableMap readableMap) {
            readableMap = readableMap.hasKey(SecureStoreModule.ALIAS_PROPERTY) ? readableMap.getString(SecureStoreModule.ALIAS_PROPERTY) : DEFAULT_ALIAS;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AES/GCM/NoPadding:");
            stringBuilder.append(readableMap);
            return stringBuilder.toString();
        }

        @TargetApi(23)
        public SecretKeyEntry initializeKeyStoreEntry(KeyStore keyStore, ReadableMap readableMap) {
            readableMap = getKeyStoreAlias(readableMap);
            KeyGenParameterSpec build = new Builder(readableMap, 3).setKeySize(AES_KEY_SIZE_BITS).setBlockModes(new String[]{"GCM"}).setEncryptionPaddings(new String[]{"NoPadding"}).build();
            KeyGenerator instance = KeyGenerator.getInstance("AES", keyStore.getProvider());
            instance.init(build);
            instance.generateKey();
            SecretKeyEntry secretKeyEntry = (SecretKeyEntry) keyStore.getEntry(readableMap, null);
            if (secretKeyEntry != null) {
                return secretKeyEntry;
            }
            throw new UnrecoverableEntryException("Could not retrieve the newly generated secret key entry");
        }

        public JSONObject createEncryptedItem(String str, KeyStore keyStore, SecretKeyEntry secretKeyEntry) {
            keyStore = secretKeyEntry.getSecretKey();
            secretKeyEntry = Cipher.getInstance(AES_CIPHER);
            secretKeyEntry.init(1, keyStore);
            return createEncryptedItem(str, secretKeyEntry);
        }

        JSONObject createEncryptedItem(String str, Cipher cipher) {
            str = Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
            GCMParameterSpec gCMParameterSpec = (GCMParameterSpec) cipher.getParameters().getParameterSpec(GCMParameterSpec.class);
            String encodeToString = Base64.encodeToString(gCMParameterSpec.getIV(), 0);
            return new JSONObject().put("ct", str).put(IV_PROPERTY, encodeToString).put(GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY, gCMParameterSpec.getTLen());
        }

        public String decryptItem(JSONObject jSONObject, SecretKeyEntry secretKeyEntry) {
            String string = jSONObject.getString("ct");
            String string2 = jSONObject.getString(IV_PROPERTY);
            jSONObject = jSONObject.getInt(GCM_AUTHENTICATION_TAG_LENGTH_PROPERTY);
            byte[] decode = Base64.decode(string, 0);
            AlgorithmParameterSpec gCMParameterSpec = new GCMParameterSpec(jSONObject, Base64.decode(string2, 0));
            jSONObject = Cipher.getInstance(AES_CIPHER);
            jSONObject.init(2, secretKeyEntry.getSecretKey(), gCMParameterSpec);
            return new String(jSONObject.doFinal(decode), StandardCharsets.UTF_8);
        }
    }

    private static class HybridAESEncrypter implements KeyBasedEncrypter<PrivateKeyEntry> {
        private static final String DEFAULT_ALIAS = "key_v1";
        private static final String ENCRYPTED_SECRET_KEY_PROPERTY = "esk";
        private static final int GCM_AUTHENTICATION_TAG_LENGTH_BITS = 128;
        private static final int GCM_IV_LENGTH_BYTES = 12;
        public static final String NAME = "hybrid";
        private static final String RSA_CIPHER = "RSA/None/PKCS1Padding";
        private static final String RSA_CIPHER_LEGACY_PROVIDER = "AndroidOpenSSL";
        private static final int X509_SERIAL_NUMBER_LENGTH_BITS = 160;
        private AESEncrypter mAESEncrypter;
        private Context mContext;
        private SecureRandom mSecureRandom = new SecureRandom();

        public HybridAESEncrypter(Context context, AESEncrypter aESEncrypter) {
            this.mContext = context;
            this.mAESEncrypter = aESEncrypter;
        }

        public String getKeyStoreAlias(ReadableMap readableMap) {
            readableMap = readableMap.hasKey(SecureStoreModule.ALIAS_PROPERTY) ? readableMap.getString(SecureStoreModule.ALIAS_PROPERTY) : DEFAULT_ALIAS;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RSA/None/PKCS1Padding:");
            stringBuilder.append(readableMap);
            return stringBuilder.toString();
        }

        public PrivateKeyEntry initializeKeyStoreEntry(KeyStore keyStore, ReadableMap readableMap) {
            readableMap = getKeyStoreAlias(readableMap);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('\"');
            stringBuilder.append(readableMap.replace("\\", "\\\\").replace("\"", "\\\""));
            stringBuilder.append('\"');
            String stringBuilder2 = stringBuilder.toString();
            KeyPairGeneratorSpec.Builder alias = new KeyPairGeneratorSpec.Builder(this.mContext).setAlias(readableMap);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("CN=");
            stringBuilder3.append(stringBuilder2);
            stringBuilder3.append(", OU=SecureStore");
            AlgorithmParameterSpec build = alias.setSubject(new X500Principal(stringBuilder3.toString())).setSerialNumber(new BigInteger(X509_SERIAL_NUMBER_LENGTH_BITS, this.mSecureRandom)).setStartDate(new Date(0)).setEndDate(new Date(Clock.MAX_TIME)).build();
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", keyStore.getProvider());
            instance.initialize(build);
            Provider e = C6271b.m25906e();
            int indexOf = Arrays.asList(Security.getProviders()).indexOf(e) + 1;
            if (indexOf > 0) {
                Security.removeProvider(e.getName());
            }
            try {
                instance.generateKeyPair();
                PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) keyStore.getEntry(readableMap, null);
                if (privateKeyEntry != null) {
                    return privateKeyEntry;
                }
                throw new UnrecoverableEntryException("Could not retrieve the newly generated private key entry");
            } finally {
                if (indexOf > 0) {
                    Security.insertProviderAt(e, indexOf);
                }
            }
        }

        public JSONObject createEncryptedItem(String str, KeyStore keyStore, PrivateKeyEntry privateKeyEntry) {
            keyStore = new byte[12];
            this.mSecureRandom.nextBytes(keyStore);
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(256);
            Object generateKey = instance.generateKey();
            AlgorithmParameterSpec gCMParameterSpec = new GCMParameterSpec(GCM_AUTHENTICATION_TAG_LENGTH_BITS, keyStore);
            Cipher instance2 = Cipher.getInstance("AES/GCM/NoPadding");
            instance2.init(1, generateKey, gCMParameterSpec);
            str = this.mAESEncrypter.createEncryptedItem(str, instance2);
            if (str.getString("iv").equals(Base64.encodeToString(keyStore, 0))) {
                keyStore = generateKey.getEncoded();
                Cipher rSACipher = getRSACipher();
                rSACipher.init(1, privateKeyEntry.getCertificate());
                return str.put(ENCRYPTED_SECRET_KEY_PROPERTY, Base64.encodeToString(rSACipher.doFinal(keyStore), 0));
            }
            Log.e(SecureStoreModule.TAG, String.format("HybridAESEncrypter generated two different IVs: %s and %s", new Object[]{keyStore, r1}));
            throw new AssertionException("HybridAESEncrypter must store the same IV as the one used to parameterize the secret key");
        }

        public String decryptItem(JSONObject jSONObject, PrivateKeyEntry privateKeyEntry) {
            byte[] decode = Base64.decode(jSONObject.getString(ENCRYPTED_SECRET_KEY_PROPERTY), 0);
            Cipher rSACipher = getRSACipher();
            rSACipher.init(2, privateKeyEntry.getPrivateKey());
            return this.mAESEncrypter.decryptItem(jSONObject, new SecretKeyEntry(new SecretKeySpec(rSACipher.doFinal(decode), "AES")));
        }

        private Cipher getRSACipher() {
            if (VERSION.SDK_INT < 23) {
                return Cipher.getInstance(RSA_CIPHER, RSA_CIPHER_LEGACY_PROVIDER);
            }
            return Cipher.getInstance(RSA_CIPHER);
        }
    }

    public String getName() {
        return "ExponentSecureStore";
    }

    public SecureStoreModule(ReactApplicationContext reactApplicationContext, C6393j c6393j) {
        super(reactApplicationContext);
        this.mScopedContext = c6393j;
    }

    @ReactMethod
    public void setValueWithKeyAsync(String str, String str2, ReadableMap readableMap, Promise promise) {
        try {
            setItemImpl(str2, str, readableMap, promise);
        } catch (String str3) {
            Log.e(TAG, "Caught unexpected exception when writing to SecureStore", str3);
            promise.reject("E_SECURESTORE_WRITE_ERROR", "An unexpected error occurred when writing to SecureStore", str3);
        }
    }

    private void setItemImpl(String str, String str2, ReadableMap readableMap, Promise promise) {
        if (str == null) {
            promise.reject("E_SECURESTORE_NULL_KEY", "SecureStore keys must not be null");
            return;
        }
        SharedPreferences sharedPreferences = this.mScopedContext.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
        if (str2 == null) {
            if (sharedPreferences.edit().putString(str, null).commit() != null) {
                promise.resolve(null);
            } else {
                promise.reject("E_SECURESTORE_WRITE_ERROR", "Could not write a null value to SecureStore");
            }
            return;
        }
        try {
            KeyStore keyStore = getKeyStore();
            if (VERSION.SDK_INT >= 23) {
                str2 = this.mAESEncrypter.createEncryptedItem(str2, keyStore, (SecretKeyEntry) getKeyEntry(SecretKeyEntry.class, this.mAESEncrypter, readableMap));
                str2.put(SCHEME_PROPERTY, AESEncrypter.NAME);
            } else {
                str2 = this.mHybridAESEncrypter.createEncryptedItem(str2, keyStore, (PrivateKeyEntry) getKeyEntry(PrivateKeyEntry.class, this.mHybridAESEncrypter, readableMap));
                str2.put(SCHEME_PROPERTY, HybridAESEncrypter.NAME);
            }
            str2 = str2.toString();
            if (str2 == null) {
                promise.reject("E_SECURESTORE_JSON_ERROR", "Could not JSON-encode the encrypted item for SecureStore");
                return;
            }
            if (sharedPreferences.edit().putString(str, str2).commit() != null) {
                promise.resolve(null);
            } else {
                promise.reject("E_SECURESTORE_WRITE_ERROR", "Could not write encrypted JSON to SecureStore");
            }
        } catch (String str3) {
            Log.w(TAG, str3);
            promise.reject("E_SECURESTORE_IO_ERROR", "There was an I/O error loading the keystore for SecureStore", str3);
        } catch (String str32) {
            Log.w(TAG, str32);
            promise.reject("E_SECURESTORE_ENCRYPT_ERROR", "Could not encrypt the value for SecureStore", str32);
        } catch (String str322) {
            Log.w(TAG, str322);
            promise.reject("E_SECURESTORE_ENCODE_ERROR", "Could not create an encrypted JSON item for SecureStore", str322);
        }
    }

    @ReactMethod
    public void getValueWithKeyAsync(String str, ReadableMap readableMap, Promise promise) {
        try {
            getItemImpl(str, readableMap, promise);
        } catch (String str2) {
            Log.e(TAG, "Caught unexpected exception when reading from SecureStore", str2);
            promise.reject("E_SECURESTORE_READ_ERROR", "An unexpected error occurred when reading from SecureStore", str2);
        }
    }

    private void getItemImpl(String str, ReadableMap readableMap, Promise promise) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences.contains(str)) {
            readJSONEncodedItem(str, sharedPreferences, readableMap, promise);
        } else {
            readLegacySDK20Item(str, readableMap, promise);
        }
    }

    private void readJSONEncodedItem(String str, SharedPreferences sharedPreferences, ReadableMap readableMap, Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject(sharedPreferences.getString(str, null));
            String optString = jSONObject.optString(SCHEME_PROPERTY);
            if (optString == null) {
                Log.e(TAG, String.format("Stored JSON object is missing a scheme (key = %s, value = %s)", new Object[]{str, sharedPreferences}));
                promise.reject("E_SECURESTORE_DECODE_ERROR", "Could not find the encryption scheme used for SecureStore item");
                return;
            }
            sharedPreferences = -1;
            try {
                int hashCode = optString.hashCode();
                if (hashCode != -1202757124) {
                    if (hashCode == 96463) {
                        if (optString.equals(AESEncrypter.NAME)) {
                            sharedPreferences = null;
                        }
                    }
                } else if (optString.equals(HybridAESEncrypter.NAME)) {
                    sharedPreferences = true;
                }
                switch (sharedPreferences) {
                    case null:
                        str = this.mAESEncrypter.decryptItem(jSONObject, (SecretKeyEntry) getKeyEntry(SecretKeyEntry.class, this.mAESEncrypter, readableMap));
                        break;
                    case 1:
                        str = this.mHybridAESEncrypter.decryptItem(jSONObject, (PrivateKeyEntry) getKeyEntry(PrivateKeyEntry.class, this.mHybridAESEncrypter, readableMap));
                        break;
                    default:
                        str = String.format("The item for key \"%s\" in SecureStore has an unknown encoding scheme (%s)", new Object[]{str, optString});
                        Log.e(TAG, str);
                        promise.reject("E_SECURESTORE_DECODE_ERROR", str);
                        return;
                }
                promise.resolve(str);
            } catch (String str2) {
                Log.w(TAG, str2);
                promise.reject("E_SECURESTORE_IO_ERROR", "There was an I/O error loading the keystore for SecureStore", str2);
            } catch (String str22) {
                Log.w(TAG, str22);
                promise.reject("E_SECURESTORE_DECRYPT_ERROR", "Could not decrypt the item in SecureStore", str22);
            } catch (String str222) {
                Log.w(TAG, str222);
                promise.reject("E_SECURESTORE_DECODE_ERROR", "Could not decode the encrypted JSON item in SecureStore", str222);
            }
        } catch (ReadableMap readableMap2) {
            Log.e(TAG, String.format("Could not parse stored value as JSON (key = %s, value = %s)", new Object[]{str222, sharedPreferences}), readableMap2);
            promise.reject("E_SECURESTORE_JSON_ERROR", "Could not parse the encrypted JSON item in SecureStore");
        }
    }

    private void readLegacySDK20Item(String str, ReadableMap readableMap, Promise promise) {
        str = PreferenceManager.getDefaultSharedPreferences(this.mScopedContext).getString(str, null);
        if (TextUtils.isEmpty(str)) {
            promise.resolve(null);
            return;
        }
        LegacySDK20Encrypter legacySDK20Encrypter = new LegacySDK20Encrypter();
        try {
            KeyStore keyStore = getKeyStore();
            readableMap = legacySDK20Encrypter.getKeyStoreAlias(readableMap);
            if (keyStore.containsAlias(readableMap)) {
                readableMap = keyStore.getEntry(readableMap, null);
                if (readableMap instanceof PrivateKeyEntry) {
                    promise.resolve(legacySDK20Encrypter.decryptItem(str, (PrivateKeyEntry) readableMap));
                    return;
                } else {
                    promise.reject("E_SECURESTORE_DECRYPT_ERROR", "The keystore entry for the legacy item is not a private key entry");
                    return;
                }
            }
            promise.reject("E_SECURESTORE_DECRYPT_ERROR", "Could not find the keystore entry to decrypt the legacy item in SecureStore");
        } catch (String str2) {
            Log.w(TAG, str2);
            promise.reject("E_SECURESTORE_IO_ERROR", "There was an I/O error loading the keystore for SecureStore", str2);
        } catch (String str22) {
            Log.w(TAG, str22);
            promise.reject("E_SECURESTORE_DECRYPT_ERROR", "Could not decrypt the item in SecureStore", str22);
        }
    }

    @ReactMethod
    public void deleteValueWithKeyAsync(String str, ReadableMap readableMap, Promise promise) {
        try {
            deleteItemImpl(str, readableMap, promise);
        } catch (String str2) {
            Log.e(TAG, "Caught unexpected exception when deleting from SecureStore", str2);
            promise.reject("E_SECURESTORE_DELETE_ERROR", "An unexpected error occurred when deleting item from SecureStore", str2);
        }
    }

    private void deleteItemImpl(String str, ReadableMap readableMap, Promise promise) {
        SharedPreferences defaultSharedPreferences;
        readableMap = getSharedPreferences();
        if (readableMap.contains(str)) {
            if (readableMap.edit().remove(str).commit() == null) {
                readableMap = null;
                defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mScopedContext);
                if (defaultSharedPreferences.contains(str)) {
                    readableMap = (defaultSharedPreferences.edit().remove(str).commit() != null || readableMap == null) ? null : true;
                }
                if (readableMap == null) {
                    promise.resolve(null);
                } else {
                    promise.reject("E_SECURESTORE_DELETE_ERROR", "Could not delete the item from SecureStore");
                }
            }
        }
        readableMap = true;
        defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mScopedContext);
        if (defaultSharedPreferences.contains(str)) {
            if (defaultSharedPreferences.edit().remove(str).commit() != null) {
            }
        }
        if (readableMap == null) {
            promise.reject("E_SECURESTORE_DELETE_ERROR", "Could not delete the item from SecureStore");
        } else {
            promise.resolve(null);
        }
    }

    private SharedPreferences getSharedPreferences() {
        return this.mScopedContext.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    private KeyStore getKeyStore() {
        if (this.mKeyStore == null) {
            KeyStore instance = KeyStore.getInstance(KEYSTORE_PROVIDER);
            instance.load(null);
            this.mKeyStore = instance;
        }
        return this.mKeyStore;
    }

    private <E extends Entry> E getKeyEntry(Class<E> cls, KeyBasedEncrypter<E> keyBasedEncrypter, ReadableMap readableMap) {
        KeyStore keyStore = getKeyStore();
        String keyStoreAlias = keyBasedEncrypter.getKeyStoreAlias(readableMap);
        if (!keyStore.containsAlias(keyStoreAlias)) {
            return keyBasedEncrypter.initializeKeyStoreEntry(keyStore, readableMap);
        }
        keyBasedEncrypter = keyStore.getEntry(keyStoreAlias, null);
        if (cls.isInstance(keyBasedEncrypter) != null) {
            return (Entry) cls.cast(keyBasedEncrypter);
        }
        throw new KeyStoreException(String.format("The entry for the keystore alias \"%s\" is not a %s", new Object[]{keyStoreAlias, cls.getSimpleName()}));
    }
}
