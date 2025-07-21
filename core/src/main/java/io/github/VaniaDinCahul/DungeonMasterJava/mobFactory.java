package io.github.VaniaDinCahul.DungeonMasterJava;

import java.util.ArrayList;
import java.util.List;

public class mobFactory {

    public Mob generateMob() {

        return new Mob();
    }

    public List<Mob> generateTileMobs() {
        List<Mob> newMobs = new ArrayList<>();
        newMobs.add(generateMob());

        return newMobs;
    }
}
