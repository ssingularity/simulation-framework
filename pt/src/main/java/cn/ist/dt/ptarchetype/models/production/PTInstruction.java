package cn.ist.dt.ptarchetype.models.production;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class PTInstruction {
    protected Map<String, Object> instructions = new HashMap<>();
}
