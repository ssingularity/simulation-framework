package cn.ist.dt.ptarchetype.models.production;

import lombok.Data;

@Data
public class RealProduct {
    protected String id;

    public enum ProductState{
        STATE0, STATE1, STATE2;
    }
}
