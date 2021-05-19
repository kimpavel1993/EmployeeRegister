package ru.isands.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.isands.model.Bank;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Bank in entity cache.
 *
 * @author Joe Bloggs
 * @see Bank
 * @generated
 */
public class BankCacheModel implements CacheModel<Bank>, Externalizable {
    public long bankId;
    public String name;
    public long bik;
    public String streetAddress;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{bankId=");
        sb.append(bankId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", bik=");
        sb.append(bik);
        sb.append(", streetAddress=");
        sb.append(streetAddress);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Bank toEntityModel() {
        BankImpl bankImpl = new BankImpl();

        bankImpl.setBankId(bankId);

        if (name == null) {
            bankImpl.setName(StringPool.BLANK);
        } else {
            bankImpl.setName(name);
        }

        bankImpl.setBik(bik);

        if (streetAddress == null) {
            bankImpl.setStreetAddress(StringPool.BLANK);
        } else {
            bankImpl.setStreetAddress(streetAddress);
        }

        bankImpl.resetOriginalValues();

        return bankImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        bankId = objectInput.readLong();
        name = objectInput.readUTF();
        bik = objectInput.readLong();
        streetAddress = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(bankId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeLong(bik);

        if (streetAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(streetAddress);
        }
    }
}
