package ru.isands.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Bank service. Represents a row in the &quot;Employee_Bank&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.isands.model.impl.BankModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.isands.model.impl.BankImpl}.
 * </p>
 *
 * @author Joe Bloggs
 * @see Bank
 * @see ru.isands.model.impl.BankImpl
 * @see ru.isands.model.impl.BankModelImpl
 * @generated
 */
public interface BankModel extends BaseModel<Bank> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a bank model instance should use the {@link Bank} interface instead.
     */

    /**
     * Returns the primary key of this bank.
     *
     * @return the primary key of this bank
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this bank.
     *
     * @param primaryKey the primary key of this bank
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the bank ID of this bank.
     *
     * @return the bank ID of this bank
     */
    public long getBankId();

    /**
     * Sets the bank ID of this bank.
     *
     * @param bankId the bank ID of this bank
     */
    public void setBankId(long bankId);

    /**
     * Returns the name of this bank.
     *
     * @return the name of this bank
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this bank.
     *
     * @param name the name of this bank
     */
    public void setName(String name);

    /**
     * Returns the bik of this bank.
     *
     * @return the bik of this bank
     */
    public long getBik();

    /**
     * Sets the bik of this bank.
     *
     * @param bik the bik of this bank
     */
    public void setBik(long bik);

    /**
     * Returns the street address of this bank.
     *
     * @return the street address of this bank
     */
    @AutoEscape
    public String getStreetAddress();

    /**
     * Sets the street address of this bank.
     *
     * @param streetAddress the street address of this bank
     */
    public void setStreetAddress(String streetAddress);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(Bank bank);

    @Override
    public int hashCode();

    @Override
    public CacheModel<Bank> toCacheModel();

    @Override
    public Bank toEscapedModel();

    @Override
    public Bank toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
