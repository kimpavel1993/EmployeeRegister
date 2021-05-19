package ru.isands.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import ru.isands.model.Position;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Position in entity cache.
 *
 * @author Joe Bloggs
 * @see Position
 * @generated
 */
public class PositionCacheModel implements CacheModel<Position>, Externalizable {
    public long positionId;
    public String name;
    public Boolean isArchived;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{positionId=");
        sb.append(positionId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", isArchived=");
        sb.append(isArchived);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Position toEntityModel() {
        PositionImpl positionImpl = new PositionImpl();

        positionImpl.setPositionId(positionId);

        if (name == null) {
            positionImpl.setName(StringPool.BLANK);
        } else {
            positionImpl.setName(name);
        }

        positionImpl.setIsArchived(isArchived);

        positionImpl.resetOriginalValues();

        return positionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        positionId = objectInput.readLong();
        name = objectInput.readUTF();
        isArchived = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(positionId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeBoolean(isArchived);
    }
}
