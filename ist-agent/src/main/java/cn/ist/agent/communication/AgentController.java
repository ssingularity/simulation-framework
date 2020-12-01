package cn.ist.agent.communication;

import cn.ist.agent.communication.messages.DTProductionUpdateMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ssingualrity
 * @Date: 2020/10/9 19:29
 */
@RestController
public class AgentController {
    @PostMapping("/neighborInput")
    public void handleProductionUpdate(@RequestBody DTProductionUpdateMsg dtProductionInput) {

    }
}
