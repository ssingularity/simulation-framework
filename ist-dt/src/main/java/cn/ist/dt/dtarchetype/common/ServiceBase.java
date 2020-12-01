package cn.ist.dt.dtarchetype.common;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public abstract class ServiceBase implements EnvironmentAware {
    protected Environment env;

    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
    }
}
