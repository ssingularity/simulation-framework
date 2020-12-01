package cn.ist.dt.dtarchetype.models.production;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTProductionInput {
    public String id;
    public VirtualProduct product;
}
