package org.spongycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;

public class PKCS12BagAttributeCarrierImpl implements PKCS12BagAttributeCarrier {
    /* renamed from: a */
    private Hashtable f27437a;
    /* renamed from: b */
    private Vector f27438b;

    PKCS12BagAttributeCarrierImpl(Hashtable hashtable, Vector vector) {
        this.f27437a = hashtable;
        this.f27438b = vector;
    }

    public PKCS12BagAttributeCarrierImpl() {
        this(new Hashtable(), new Vector());
    }

    /* renamed from: a */
    public void mo5851a(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        if (this.f27437a.containsKey(aSN1ObjectIdentifier)) {
            this.f27437a.put(aSN1ObjectIdentifier, aSN1Encodable);
            return;
        }
        this.f27437a.put(aSN1ObjectIdentifier, aSN1Encodable);
        this.f27438b.addElement(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public ASN1Encodable mo5850a(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (ASN1Encodable) this.f27437a.get(aSN1ObjectIdentifier);
    }

    /* renamed from: a */
    public Enumeration mo5849a() {
        return this.f27438b.elements();
    }

    /* renamed from: a */
    public void m36022a(ObjectOutputStream objectOutputStream) {
        if (this.f27438b.size() == 0) {
            objectOutputStream.writeObject(new Hashtable());
            objectOutputStream.writeObject(new Vector());
            return;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        Enumeration a = mo5849a();
        while (a.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1ObjectIdentifier) a.nextElement();
            aSN1OutputStream.mo5713a(aSN1Encodable);
            aSN1OutputStream.mo5713a((ASN1Encodable) this.f27437a.get(aSN1Encodable));
        }
        objectOutputStream.writeObject(byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    public void m36021a(ObjectInputStream objectInputStream) {
        Object readObject = objectInputStream.readObject();
        if (readObject instanceof Hashtable) {
            this.f27437a = (Hashtable) readObject;
            this.f27438b = (Vector) objectInputStream.readObject();
            return;
        }
        objectInputStream = new ASN1InputStream((byte[]) readObject);
        while (true) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) objectInputStream.m34595d();
            if (aSN1ObjectIdentifier != null) {
                mo5851a(aSN1ObjectIdentifier, objectInputStream.m34595d());
            } else {
                return;
            }
        }
    }
}
