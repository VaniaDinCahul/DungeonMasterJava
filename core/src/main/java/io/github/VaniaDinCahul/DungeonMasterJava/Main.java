package io.github.VaniaDinCahul.DungeonMasterJava;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;
import java.util.*;
import java.util.List;


///      I try and explain shit as I code:
///  assetManager is an libGDX object which makes managing assets easier, making sure one asset isn't deleted if it's needed somewhere, and it makes sure you only have one type of asset to stop memory hoarding
///
/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {

    Dimension MAP_SIZE = new Dimension(
        50,   //tiles
              50    //tiles
    );
    Dimension STARTER_POS = new Dimension(
        25,   //tiles
              25    //tiles
    );
    Dimension MAP_VIEWPORT_SIZE = new Dimension(
        10,   //tiles
              10    //tiles
    );

    int GRID_SIZE = 15;     //px

    public mapTile[][] map;

    // a viewport where the game will be displayed
    private Viewport viewport;

    // basic camera in which the map will be displayed
    private OrthographicCamera orthographicCamera;

    // asset manager, not sure how it works yet.
    public AssetManager assetManager;

    // makes the tiles and map kinda
    tileFactory tileFactory;

    private SpriteBatch batch;
    private Texture image;

    public Texture one_way_corridor_1;
    public Texture one_way_corridor_2;
    public Texture two_way_corridor;
    public Texture three_way_corridor;
    public Texture four_way_corridor;

    @Override
    public void create() {

        // Viewports and Cameras
        orthographicCamera = new OrthographicCamera();
        viewport = new FitViewport(600f, 350f);
        viewport.update(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight());


        // Managers
        assetManager = new AssetManager();
        batch = new SpriteBatch();


        // Textures
        image = new Texture("icon.png");

        one_way_corridor_1 = new Texture("1-way-corridor-1.png");
        one_way_corridor_2 = new Texture("1-way-corridor-2.png");


        // Etc
        tileFactory = new tileFactory();
        map = new mapTile[MAP_SIZE.width][MAP_SIZE.height];


        // Creates the map
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = new mapTile();

            }
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
//        batch.draw(image, 140, 210, 55, 55);
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y].tileTypeID == 1){
                    batch.draw(one_way_corridor_1, GRID_SIZE*x, GRID_SIZE*y, GRID_SIZE, GRID_SIZE);
                }
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
