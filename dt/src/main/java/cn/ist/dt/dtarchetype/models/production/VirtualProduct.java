package cn.ist.dt.dtarchetype.models.production;

import lombok.Data;

@Data
public class VirtualProduct {
    protected String id;
    protected ProductState state;

    public enum ProductState{
        STATE0, STATE1, STATE2;
    }
}

