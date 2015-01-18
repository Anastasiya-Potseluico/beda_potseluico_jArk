/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jark.model;

import com.golden.gamedev.object.Sprite;
import jark.collisionManagers.CollisionMan;
import jark.specifications.Buffer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author пользователь
 */
public class BallTest {

    public BallTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * мяч летит под прямым углом, ракетка не подвижна
     */
    @Test
    public void testRightAngleRacketNotMove() throws IOException {
        System.out.println("мяч летит под прямым углом, ракетка не подвижна");
        ElementField ball = new Ball(295, 200);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 295, 200);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(0, 0.3);
        racket.setSpeed(0, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(0.0, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит слева, ракетка не подвижна
     */
    @Test
    public void testLeftRacketNotMove() throws IOException {
        System.out.println("мяч летит слева, ракетка не подвижна");
        ElementField ball = new Ball(250, 430);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 250, 430);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(0.3, 0.3);
        racket.setSpeed(0, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(0.3, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит справа, ракетка не подвижна
     */
    @Test
    public void testRightRacketNotMove() throws IOException {
        System.out.println("мяч летит справа, ракетка не подвижна");
        ElementField ball = new Ball(340, 430);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 340, 430);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(-0.3, 0.3);
        racket.setSpeed(0, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(-0.3, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит под прямым углом, ракетка движется вправо
     */
    @Test
    public void testRightAngleRacketMoveRight() throws IOException {
        System.out.println("мяч летит под прямым углом, ракетка движется вправо");
        ElementField ball = new Ball(350, 420);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 350, 420);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(0, 0.3);
        racket.setSpeed(0.1, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(0.2, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит слева, ракетка движется вправо
     */
    @Test
    public void testLeftRacketMoveRight() throws IOException {
        System.out.println("мяч летит слева, ракетка движется вправо");
        ElementField ball = new Ball(250, 430);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 250, 430);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(0.3, 0.3);
        racket.setSpeed(0.1, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(0.3, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит справа, ракетка движется вправо
     */
    @Test
    public void testRightRacketMoveRight() throws IOException {
        System.out.println("мяч летит справа, ракетка движется вправо");
        ElementField ball = new Ball(340, 430);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 340, 430);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(-0.3, 0.3);
        racket.setSpeed(0.1, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(0.3, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит под прямым углом, ракетка движется влево
     */
    @Test
    public void testRightAngleRacketMoveLeft() throws IOException {
        System.out.println("мяч летит под прямым углом, ракетка движется влево");
        ElementField ball = new Ball(300, 420);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 300, 420);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(0, 0.3);
        racket.setSpeed(-0.1, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(-0.2, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит слева, ракетка движется влево
     */
    @Test
    public void testLeftRacketMoveLeft() throws IOException {
        System.out.println("мяч летит слева, ракетка движется влево");
        ElementField ball = new Ball(250, 430);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 250, 430);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(0.3, 0.3);
        racket.setSpeed(-0.1, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(-0.3, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }

    /**
     * мяч летит справа, ракетка движется влево
     */
    @Test
    public void testRightRacketMoveLeft() throws IOException {
        System.out.println("мяч летит справа, ракетка движется влево");
        ElementField ball = new Ball(340, 430);
        ElementField racket = new Racket(250, 500);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 340, 430);
        img = ImageIO.read(new File("src\\jark\\racket.png"));
        Sprite racketSprite = new Sprite(img, 250, 500);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(racket, racketSprite);
        ball.setSpeed(-0.3, 0.3);
        racket.setSpeed(-0.1, 0);
        ball.reactOnCollision(racket, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(-0.3, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
    }
    
    /**
     * мяч летит вертикально в кирпич с прочностью 1
     */
    @Test
    public void testBallIntoBreak1() throws IOException {
        System.out.println("мяч летит под прямым углом, кирпич с прочностью 1");
        ElementField ball = new Ball(300, 420);
        ElementField brick = new DestructibleBrick(1,250, 150);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 300, 420);
        img = ImageIO.read(new File("src\\jark\\brick1.png"));
        Sprite brickSprite = new Sprite(img, 250, 150);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(brick, brickSprite);
        ball.setSpeed(0, 0.3);
        ball.reactOnCollision(brick, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(0, ((DestructibleBrick)brick).hadrness(), 0.1);
    }
    
    /**
     * мяч летит вертикально в кирпич с прочностью 2
     */
    @Test
    public void testBallIntoBreak2() throws IOException {
        System.out.println("мяч летит под прямым углом, кирпич с прочностью 2");
        ElementField ball = new Ball(300, 420);
        ElementField brick = new DestructibleBrick(1,250, 150);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 300, 420);
        img = ImageIO.read(new File("src\\jark\\brick2.png"));
        Sprite brickSprite = new Sprite(img, 250, 150);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(brick, brickSprite);
        ball.setSpeed(0, 0.3);
        ball.reactOnCollision(brick, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(1, ((DestructibleBrick)brick).hadrness(), 0.1);
    }
    
    /**
     * мяч летит вертикально в кирпич с прочностью 3
     */
    @Test
    public void testBallIntoBreak3() throws IOException {
        System.out.println("мяч летит под прямым углом, кирпич с прочностью 3");
        ElementField ball = new Ball(300, 420);
        ElementField brick = new DestructibleBrick(1,250, 150);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 300, 420);
        img = ImageIO.read(new File("src\\jark\\brick3.png"));
        Sprite brickSprite = new Sprite(img, 250, 150);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(brick, brickSprite);
        ball.setSpeed(0, 0.3);
        ball.reactOnCollision(brick, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(2, ((DestructibleBrick)brick).hadrness(), 0.1);
    }
    
    /**
     * мяч летит вертикально в кирпич с прочностью 2
     */
    @Test
    public void testBallIntoBreaksBorder() throws IOException {
        System.out.println("мяч летит под прямым углом на границу двух кирпичей");
        ElementField ball = new Ball(300, 420);
        ElementField brick1 = new DestructibleBrick(1,300, 150);
        ElementField brick2 = new DestructibleBrick(1,210, 150);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 300, 420);
        img = ImageIO.read(new File("src\\jark\\brick2.png"));
        Sprite brick1Sprite = new Sprite(img, 300, 150);
        img = ImageIO.read(new File("src\\jark\\brick1.png"));
        Sprite brick2Sprite = new Sprite(img, 210, 150);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(brick1, brick1Sprite);
        Buffer.addElement(brick2, brick2Sprite);
        ball.setSpeed(0, 0.3);
        ball.reactOnCollision(brick1, CollisionMan.TYPE.DEFAULT);
        ball.reactOnCollision(brick2, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(1, ((DestructibleBrick)brick1).hadrness(), 0.1);
        assertEquals(0, ((DestructibleBrick)brick2).hadrness(), 0.1);
    }
    
    /**
     * мяч летит под углом и врезается в вертикальную стенку кирпича
     */
    @Test
    public void testBallIntoBreakBordedVertical() throws IOException {
        System.out.println("мяч летит под прямым углом, кирпич с прочностью 3");
        ElementField ball = new Ball(300, 420);
        ElementField brick = new DestructibleBrick(1,250, 250);
        BufferedImage img = ImageIO.read(new File("src\\jark\\ball.png"));
        Sprite ballSprite = new Sprite(img, 150, 150);
        img = ImageIO.read(new File("src\\jark\\brick3.png"));
        Sprite brickSprite = new Sprite(img, 250, 250);
        Buffer.addElement(ball, ballSprite);
        Buffer.addElement(brick, brickSprite);
        ball.setSpeed(0.3, 0.3);
        ball.reactOnCollision(brick, CollisionMan.TYPE.DEFAULT);
        assertEquals(-0.3, Buffer.findSprite(ball).getVerticalSpeed(), 0.1);
        assertEquals(-0.3, Buffer.findSprite(ball).getHorizontalSpeed(), 0.1);
        
    }

}
