package ru.isands.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import ru.isands.service.BankLocalServiceUtil;
import ru.isands.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class BankClp extends BaseModelImpl<Bank> implements Bank {
    private long _bankId;
    private String _name;
    private long _bik;
    private String _streetAddress;
    private BaseModel<?> _bankRemoteModel;

    public BankClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Bank.class;
    }

    @Override
    public String getModelClassName() {
        return Bank.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _bankId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setBankId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _bankId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("bankId", getBankId());
        attributes.put("name", getName());
        attributes.put("bik", getBik());
        attributes.put("streetAddress", getStreetAddress());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long bankId = (Long) attributes.get("bankId");

        if (bankId != null) {
            setBankId(bankId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Long bik = (Long) attributes.get("bik");

        if (bik != null) {
            setBik(bik);
        }

        String streetAddress = (String) attributes.get("streetAddress");

        if (streetAddress != null) {
            setStreetAddress(streetAddress);
        }
    }

    @Override
    public long getBankId() {
        return _bankId;
    }

    @Override
    public void setBankId(long bankId) {
        _bankId = bankId;

        if (_bankRemoteModel != null) {
            try {
                Class<?> clazz = _bankRemoteModel.getClass();

                Method method = clazz.getMethod("setBankId", long.class);

                method.invoke(_bankRemoteModel, bankId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_bankRemoteModel != null) {
            try {
                Class<?> clazz = _bankRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_bankRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getBik() {
        return _bik;
    }

    @Override
    public void setBik(long bik) {
        _bik = bik;

        if (_bankRemoteModel != null) {
            try {
                Class<?> clazz = _bankRemoteModel.getClass();

                Method method = clazz.getMethod("setBik", long.class);

                method.invoke(_bankRemoteModel, bik);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStreetAddress() {
        return _streetAddress;
    }

    @Override
    public void setStreetAddress(String streetAddress) {
        _streetAddress = streetAddress;

        if (_bankRemoteModel != null) {
            try {
                Class<?> clazz = _bankRemoteModel.getClass();

                Method method = clazz.getMethod("setStreetAddress", String.class);

                method.invoke(_bankRemoteModel, streetAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getBankRemoteModel() {
        return _bankRemoteModel;
    }

    public void setBankRemoteModel(BaseModel<?> bankRemoteModel) {
        _bankRemoteModel = bankRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _bankRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_bankRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BankLocalServiceUtil.addBank(this);
        } else {
            BankLocalServiceUtil.updateBank(this);
        }
    }

    @Override
    public Bank toEscapedModel() {
        return (Bank) ProxyUtil.newProxyInstance(Bank.class.getClassLoader(),
            new Class[] { Bank.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BankClp clone = new BankClp();

        clone.setBankId(getBankId());
        clone.setName(getName());
        clone.setBik(getBik());
        clone.setStreetAddress(getStreetAddress());

        return clone;
    }

    @Override
    public int compareTo(Bank bank) {
        int value = 0;

        value = getName().compareTo(bank.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BankClp)) {
            return false;
        }

        BankClp bank = (BankClp) obj;

        long primaryKey = bank.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{bankId=");
        sb.append(getBankId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", bik=");
        sb.append(getBik());
        sb.append(", streetAddress=");
        sb.append(getStreetAddress());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("ru.isands.model.Bank");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>bankId</column-name><column-value><![CDATA[");
        sb.append(getBankId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bik</column-name><column-value><![CDATA[");
        sb.append(getBik());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>streetAddress</column-name><column-value><![CDATA[");
        sb.append(getStreetAddress());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
