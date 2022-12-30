package micromacrocrimedetectives.micromacrospaceship.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import micromacrocrimedetectives.micromacrospaceship.model.SpaceshipGameModel;
import micromacrocrimedetectives.micromacrospaceship.model.objects.*;
import micromacrocrimedetectives.micromacrospaceship.singletons.MicroMacroAssets;
import micromacrocrimedetectives.micromacrospaceship.view.MicroMacroGameScreen;
import micromacrocrimedetectives.micromacrospaceship.view.SpaceshipGameScreen;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipGameController {
    private final SpaceshipGameModel model;

    public SpaceshipGameController(SpaceshipGameModel model) {
        this.model = model;
    }

    public PlanetsBackground getPlanetsBackground() {
        return model.planetsBackground;
    }

    public void movePlanetsBackground(float delta) {
        model.planetsBackground.y -= delta * model.planetsBackground.velocity;

        if (model.planetsBackground.y < -model.planetsBackground.texture.getHeight() + Gdx.graphics.getHeight()) {
            model.planetsBackground.y = 0;
        }
    }

    public Ufo getUfo() {
        return model.ufo;
    }

    public void moveUfoLeft(float delta) {
        model.ufo.frame.x -= delta * model.ufo.velocity;

        if (model.ufo.frame.x < -model.ufo.frame.width) {
            model.ufo.frame.x = Gdx.graphics.getWidth();
        }
    }

    public void moveUfoRight(float delta) {
        model.ufo.frame.x += delta * model.ufo.velocity;

        if (model.ufo.frame.x > Gdx.graphics.getWidth()) {
            model.ufo.frame.x = -model.ufo.frame.width;
        }
    }

    public void shootFriendlyBullet() {
        if (TimeUtils.timeSinceMillis(model.ufo.lastShootTime) > model.ufo.shootDelay) {
            model.ufo.laserSound.play();

            FriendlyBullet friendlyBullet = new FriendlyBullet();

            friendlyBullet.frame.setX(model.ufo.frame.x + (model.ufo.frame.width - friendlyBullet.frame.width) / 2);
            friendlyBullet.frame.setY(model.ufo.frame.height + Ufo.bottomMargin);

            model.ufo.bullets.add(friendlyBullet);
            model.ufo.lastShootTime = TimeUtils.millis();
        }
    }

    public void moveFriendlyBullets(float delta) {
        ArrayList<FriendlyBullet> offScreenFriendlyBullets = new ArrayList<>();

        for (FriendlyBullet friendlyBullet : model.ufo.bullets) {
            friendlyBullet.frame.y += delta * friendlyBullet.velocity;

            if (friendlyBullet.frame.y > Gdx.graphics.getHeight()) {
                offScreenFriendlyBullets.add(friendlyBullet);
            }
        }
        model.ufo.bullets.removeAll(offScreenFriendlyBullets);
    }

    public void checkForCollisions() {
        List<FriendlyBullet> friendlyBulletsToRemove = new ArrayList<>();
        List<OpponentUfo> deadOpponentUfos = new ArrayList<>();

        for (FriendlyBullet friendlyBullet : model.ufo.bullets) {
            for (OpponentUfo opponentUfo : model.opponentUfos) {
                if (friendlyBullet.frame.overlaps(opponentUfo.frame)) {
                    friendlyBulletsToRemove.add(friendlyBullet);

                    opponentUfo.lives--;

                    if (opponentUfo.lives == 0) {
                        deadOpponentUfos.add(opponentUfo);
                    }

                    model.ufo.crumbleSound.play();
                }
            }
        }
        model.ufo.bullets.removeAll(friendlyBulletsToRemove);
        model.opponentUfos.removeAll(deadOpponentUfos);
    }

    public void dispose() {
        model.dispose();
    }

    public void playSpaceMusic() {
        model.spaceMusic.play();
    }

    public void drawElapsedTime(SpriteBatch batch) {
        int elapsedTimeInSeconds = (int) (model.elapsedTime / 1000);

        model.elapsedTimeLabel.setText(elapsedTimeInSeconds + " Sekunden");
        model.elapsedTimeLabel.draw(batch, 1);
    }

    public void decreaseElapsedTime(float delta, SpaceshipGameScreen screen) {
        if (model.elapsedTime < 0) {
            screen.game.setScreen(new MicroMacroGameScreen(screen.game));
            screen.dispose();
        }

        model.elapsedTime -= delta * 1000;
    }

    public void drawOpponentUfo(SpriteBatch batch) {
        for (OpponentUfo opponentUfo : model.opponentUfos) {

            if (opponentUfo.lives == 3) {
                opponentUfo.texture = MicroMacroAssets.getInstance().atlas.findRegion("OpponentUfo/threeLives");
            } else if (opponentUfo.lives == 2) {
                opponentUfo.texture = MicroMacroAssets.getInstance().atlas.findRegion("OpponentUfo/twoLives");
            } else {
                opponentUfo.texture = MicroMacroAssets.getInstance().atlas.findRegion("OpponentUfo/oneLife");
            }

            batch.draw(
                    opponentUfo.texture,
                    opponentUfo.frame.x,
                    opponentUfo.frame.y
            );
        }
    }

    public void moveOpponentUfos(float delta) {
        List<OpponentUfo> offScreenUfos = new ArrayList<>();

        for (OpponentUfo opponentUfo : model.opponentUfos) {
            opponentUfo.frame.y -= opponentUfo.verticalVelocity * delta;

            // only follow the player if the opponent is fully on screen
            if (opponentUfo.frame.y > Gdx.graphics.getHeight() - opponentUfo.frame.height) {
                return;
            }

            if (model.ufo.frame.x > opponentUfo.frame.x) {
                opponentUfo.frame.x += delta * opponentUfo.horizontalVelocity;
            }

            if (model.ufo.frame.x < opponentUfo.frame.x) {
                opponentUfo.frame.x -= delta * opponentUfo.horizontalVelocity;
            }

            if (opponentUfo.frame.y < -opponentUfo.frame.height) {
                offScreenUfos.add(opponentUfo);
            }
        }

        model.opponentUfos.removeAll(offScreenUfos);
    }

    public void generateOpponentUfos() {
        if (TimeUtils.timeSinceMillis(model.lastOpponentUfoSpawn) > model.opponentUfoSpawnDelay) {
            OpponentUfo opponentUfo = new OpponentUfo();
            model.opponentUfos.add(opponentUfo);

            model.lastOpponentUfoSpawn = TimeUtils.millis();
        }
    }

    public void drawBullets(SpriteBatch batch) {
        for (FriendlyBullet friendlyBullet : model.ufo.bullets) {
            batch.draw(
                    friendlyBullet.texture,
                    friendlyBullet.frame.x,
                    friendlyBullet.frame.y
            );
        }

        for (OpponentUfo opponentUfo : model.opponentUfos) {
            for (AngryBullet angryBullet : opponentUfo.bullets) {
                batch.draw(
                        angryBullet.texture,
                        angryBullet.frame.x,
                        angryBullet.frame.y
                );
            }
        }
    }

    public void generateAngryBullets() {
        for (OpponentUfo opponentUfo : model.opponentUfos) {
            // only begin to shoot if the opponent is fully on screen
            if (opponentUfo.frame.y > Gdx.graphics.getHeight() - opponentUfo.frame.height) {
                return;
            }

            if (TimeUtils.timeSinceMillis(opponentUfo.lastShootTime) > opponentUfo.shootDelay) {
                AngryBullet newBullet = new AngryBullet();

                newBullet.frame.setX(opponentUfo.frame.x + (opponentUfo.frame.width - newBullet.frame.width) / 2);
                newBullet.frame.setY(opponentUfo.frame.y - newBullet.frame.height);

                opponentUfo.bullets.add(newBullet);

                opponentUfo.lastShootTime = TimeUtils.millis();
            }
        }
    }

    public void moveAngryBullets(float delta) {
        for (OpponentUfo opponentUfo : model.opponentUfos) {
            List<AngryBullet> offScreenBullets = new ArrayList<>();

            for (AngryBullet bullet : opponentUfo.bullets) {
                bullet.frame.y -= bullet.velocity * delta;

                if (bullet.frame.y < -bullet.frame.height) {
                    offScreenBullets.add(bullet);
                }
            }

            opponentUfo.bullets.removeAll(offScreenBullets);
        }
    }
}
