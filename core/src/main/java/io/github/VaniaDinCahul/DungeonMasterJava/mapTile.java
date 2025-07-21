package io.github.VaniaDinCahul.DungeonMasterJava;

import java.util.List;
import java.util.UUID;

public class mapTile {
    int tileTypeID;
    int tileGold;
    boolean isPLayer;
    UUID tileID;
    List<Mob> tileMobs;

    mobFactory mobFactory = new mobFactory();

    mapTile(){
        this.tileTypeID = 1;
        this.tileGold = 0;
        this.tileMobs = mobFactory.generateTileMobs();
        this.tileID = UUID.randomUUID();
        this.isPLayer = false;
    }
}
