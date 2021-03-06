package ru.isands.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Position service. Represents a row in the &quot;Employee_Position&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link ru.isands.model.impl.PositionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ru.isands.model.impl.PositionImpl}.
 * </p>
 *
 * @author Joe Bloggs
 * @see Position
 * @see ru.isands.model.impl.PositionImpl
 * @see ru.isands.model.impl.PositionModelImpl
 * @generated
 */
public interface PositionModel extends BaseModel<Position> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a position model instance should use the {@link Position} interface instead.
     */

    /**
     * Returns the primary key of this position.
     *
     * @return the primary key of this position
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this position.
     *
     * @param primaryKey the primary key of this position
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the position ID of this position.
     *
     * @return the position ID of this position
     */
    public long getPositionId();

    /**
     * Sets the position ID of this position.
     *
     * @param positionId the position ID of this position
     */
    public void setPositionId(long positionId);

    /**
     * Returns the name of this position.
     *
     * @return the name of this position
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this position.
     *
     * @param name the name of this position
     */
    public void setName(String name);

    /**
     * Returns the is archived of this position.
     *
     * @return the is archived of this position
     */
    public Boolean getIsArchived();

    /**
     * Sets the is archived of this position.
     *
     * @param isArchived the is archived of this position
     */
    public void setIsArchived(Boolean isArchived);

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
    public int compareTo(ru.isands.model.Position position);

    @Override
    public int hashCode();

    @Override
    public CacheModel<ru.isands.model.Position> toCacheModel();

    @Override
    public ru.isands.model.Position toEscapedModel();

    @Override
    public ru.isands.model.Position toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
