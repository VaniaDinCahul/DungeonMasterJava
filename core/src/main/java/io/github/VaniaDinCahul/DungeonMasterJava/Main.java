package io.github.VaniaDinCahul.DungeonMasterJava;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.*;


///      I try and explain shit as I code:
///  assetManager is an libGDX object which makes managing assets easier, making sure one asset isn't deleted if it's needed somewhere, and it makes sure you only have one type of asset to stop memory hoarding
///
/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    int X_GRID_SIZE = 50;
    int Y_GRID_SZE = 50;
    int STARTER_POS = 25;

    public mapTile[][] map;
    List<mapTile> bag = new ArrayList<>();

    private Viewport viewport;
    public AssetManager assetManager;

    tileFactory tileFactory;

    private SpriteBatch batch;
    private Texture image;

    @Override
    public void create() {
        viewport = new ExtendViewport(600f, 350f);
        assetManager = new AssetManager();

        batch = new SpriteBatch();
        image = new Texture("icon.png");

        tileFactory = new tileFactory();
        map = new mapTile[X_GRID_SIZE][Y_GRID_SZE];

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = new mapTile();
                bag.add(map[x][y]);
            }
        }
        map[STARTER_POS][STARTER_POS].isPLayer = true;
        map[STARTER_POS][STARTER_POS] = tileFactory.generateTile();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
