package cn.ist.dt.ptarchetype.models.production;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PTProductionInput {
    protected String id;

    protected RealProduct product;
}
