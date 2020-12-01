package cn.ist.dt.ptarchetype.models.production;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PTProductionOutput {
    protected String id;

    protected RealProduct product;
}

