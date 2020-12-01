package cn.ist.dt.ptarchetype.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class RandomUtil {
    final private long seed;

    private Random r;

    public void init() {
        log.info("Simulation seed: " + seed);
        r = new Random(seed);
    }

    public float getRandomFloat() {
        return r.nextFloat();
    }

    public int getRandomInteger(int bound) {
        return r.nextInt(bound);
    }
}
