package cn.ist.agent.logic;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ssingualrity
 * @Date: 2020/10/22 13:34
 */
@Data
public class DTInstruction {
    protected Map<String, Object> instructions = new HashMap<>();
}
