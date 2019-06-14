package com.amplitude.api;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Revenue {
    public static final String TAG = "com.amplitude.api.Revenue";
    private static AmplitudeLog logger = AmplitudeLog.getLogger();
    protected Double price = null;
    protected String productId = null;
    protected JSONObject properties = null;
    protected int quantity = 1;
    protected String receipt = null;
    protected String receiptSig = null;
    protected String revenueType = null;

    protected boolean isValidRevenue() {
        if (this.price != null) {
            return true;
        }
        logger.m3421w(TAG, "Invalid revenue, need to set price");
        return false;
    }

    public Revenue setProductId(String str) {
        if (TextUtils.isEmpty(str)) {
            logger.m3421w(TAG, "Invalid empty productId");
            return this;
        }
        this.productId = str;
        return this;
    }

    public Revenue setQuantity(int i) {
        this.quantity = i;
        return this;
    }

    public Revenue setPrice(double d) {
        this.price = Double.valueOf(d);
        return this;
    }

    public Revenue setRevenueType(String str) {
        this.revenueType = str;
        return this;
    }

    public Revenue setReceipt(String str, String str2) {
        this.receipt = str;
        this.receiptSig = str2;
        return this;
    }

    public Revenue setRevenueProperties(JSONObject jSONObject) {
        logger.m3421w(TAG, "setRevenueProperties is deprecated, please use setEventProperties instead");
        return setEventProperties(jSONObject);
    }

    public Revenue setEventProperties(JSONObject jSONObject) {
        this.properties = Utils.cloneJSONObject(jSONObject);
        return this;
    }

    protected JSONObject toJSONObject() {
        JSONObject jSONObject = this.properties == null ? new JSONObject() : this.properties;
        try {
            jSONObject.put(Constants.AMP_REVENUE_PRODUCT_ID, this.productId);
            jSONObject.put(Constants.AMP_REVENUE_QUANTITY, this.quantity);
            jSONObject.put(Constants.AMP_REVENUE_PRICE, this.price);
            jSONObject.put(Constants.AMP_REVENUE_REVENUE_TYPE, this.revenueType);
            jSONObject.put(Constants.AMP_REVENUE_RECEIPT, this.receipt);
            jSONObject.put(Constants.AMP_REVENUE_RECEIPT_SIG, this.receiptSig);
        } catch (JSONException e) {
            logger.m3415e(TAG, String.format("Failed to convert revenue object to JSON: %s", new Object[]{e.toString()}));
        }
        return jSONObject;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        if (r5 == 0) goto L_0x0096;
    L_0x0007:
        r2 = r4.getClass();
        r3 = r5.getClass();
        if (r2 == r3) goto L_0x0013;
    L_0x0011:
        goto L_0x0096;
    L_0x0013:
        r5 = (com.amplitude.api.Revenue) r5;
        r2 = r4.quantity;
        r3 = r5.quantity;
        if (r2 == r3) goto L_0x001c;
    L_0x001b:
        return r1;
    L_0x001c:
        r2 = r4.productId;
        if (r2 == 0) goto L_0x002b;
    L_0x0020:
        r2 = r4.productId;
        r3 = r5.productId;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0030;
    L_0x002a:
        goto L_0x002f;
    L_0x002b:
        r2 = r5.productId;
        if (r2 == 0) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r2 = r4.price;
        if (r2 == 0) goto L_0x003f;
    L_0x0034:
        r2 = r4.price;
        r3 = r5.price;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0044;
    L_0x003e:
        goto L_0x0043;
    L_0x003f:
        r2 = r5.price;
        if (r2 == 0) goto L_0x0044;
    L_0x0043:
        return r1;
    L_0x0044:
        r2 = r4.revenueType;
        if (r2 == 0) goto L_0x0053;
    L_0x0048:
        r2 = r4.revenueType;
        r3 = r5.revenueType;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0058;
    L_0x0052:
        goto L_0x0057;
    L_0x0053:
        r2 = r5.revenueType;
        if (r2 == 0) goto L_0x0058;
    L_0x0057:
        return r1;
    L_0x0058:
        r2 = r4.receipt;
        if (r2 == 0) goto L_0x0067;
    L_0x005c:
        r2 = r4.receipt;
        r3 = r5.receipt;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x006c;
    L_0x0066:
        goto L_0x006b;
    L_0x0067:
        r2 = r5.receipt;
        if (r2 == 0) goto L_0x006c;
    L_0x006b:
        return r1;
    L_0x006c:
        r2 = r4.receiptSig;
        if (r2 == 0) goto L_0x007b;
    L_0x0070:
        r2 = r4.receiptSig;
        r3 = r5.receiptSig;
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x0080;
    L_0x007a:
        goto L_0x007f;
    L_0x007b:
        r2 = r5.receiptSig;
        if (r2 == 0) goto L_0x0080;
    L_0x007f:
        return r1;
    L_0x0080:
        r2 = r4.properties;
        if (r2 == 0) goto L_0x008f;
    L_0x0084:
        r2 = r4.properties;
        r5 = r5.properties;
        r5 = com.amplitude.api.Utils.compareJSONObjects(r2, r5);
        if (r5 != 0) goto L_0x0095;
    L_0x008e:
        goto L_0x0094;
    L_0x008f:
        r5 = r5.properties;
        if (r5 != 0) goto L_0x0094;
    L_0x0093:
        goto L_0x0095;
    L_0x0094:
        r0 = 0;
    L_0x0095:
        return r0;
    L_0x0096:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.Revenue.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (((((((((((this.productId != null ? this.productId.hashCode() : 0) * 31) + this.quantity) * 31) + (this.price != null ? this.price.hashCode() : 0)) * 31) + (this.revenueType != null ? this.revenueType.hashCode() : 0)) * 31) + (this.receipt != null ? this.receipt.hashCode() : 0)) * 31) + (this.receiptSig != null ? this.receiptSig.hashCode() : 0)) * 31;
        if (this.properties != null) {
            i = this.properties.hashCode();
        }
        return hashCode + i;
    }
}
