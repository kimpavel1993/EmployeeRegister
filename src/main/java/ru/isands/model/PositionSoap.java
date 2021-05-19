package ru.isands.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Joe Bloggs
 * @generated
 */
public class PositionSoap implements Serializable {
    private long _positionId;
    private String _name;
    private Boolean _isArchived;

    public PositionSoap() {
    }

    public static PositionSoap toSoapModel(Position model) {
        PositionSoap soapModel = new PositionSoap();

        soapModel.setPositionId(model.getPositionId());
        soapModel.setName(model.getName());
        soapModel.setIsArchived(model.getIsArchived());

        return soapModel;
    }

    public static PositionSoap[] toSoapModels(Position[] models) {
        PositionSoap[] soapModels = new PositionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static PositionSoap[][] toSoapModels(Position[][] models) {
        PositionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new PositionSoap[models.length][models[0].length];
        } else {
            soapModels = new PositionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static PositionSoap[] toSoapModels(List<Position> models) {
        List<PositionSoap> soapModels = new ArrayList<PositionSoap>(models.size());

        for (Position model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new PositionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _positionId;
    }

    public void setPrimaryKey(long pk) {
        setPositionId(pk);
    }

    public long getPositionId() {
        return _positionId;
    }

    public void setPositionId(long positionId) {
        _positionId = positionId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public Boolean getIsArchived() {
        return _isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        _isArchived = isArchived;
    }
}
