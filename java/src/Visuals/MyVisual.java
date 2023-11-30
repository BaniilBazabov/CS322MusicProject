package Visuals;
import main.*;

public class MyVisual extends Visual
{
    Ball[] balls = new Ball[200];
    BallAmp[] ballAmps = new BallAmp[150];

    int numCubes;
    Cube[] cubes;
    float angle = 0;
    float strength = 0.10f;
    float smoothedDiamondSize0 = 0;
    float smoothedDiamondSize1 = 0;

    public static Boolean isEven (Integer i) // boolean for circles
    {
        return (i % 2)  == 0;
    }

    public void settings()
    {
        size(800, 800, P3D); // canvas size
        println("CWD: " + System.getProperty("user.dir"));
    }

    public void keyPressed() // press space to start
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();

        }
    }

    public void setup()
    {
        startMinim();
        colorMode(RGB);

        setFrameSize(256);

        startMinim();
        loadAudio("ZHU.mp3"); // your favourite song

        numCubes = (int)(7 + getSpecSize() * strength); // number of cubes spawning
        cubes = new Cube[numCubes];

        for(int i = 0; i < numCubes; i++) // creates cube object
        {
            cubes[i] = new Cube(this);
        }

        for(int i = 0; i < balls.length; i++) // creates balls object
        {
            balls[i] = new Ball(this);
        }

        for(int i = 0; i < ballAmps.length; i++) // creates ballsamp object
        {
            ballAmps[i] = new BallAmp(this);
        }
    }

    public void draw()
    {
        colorMode(RGB);
        calculateAverageAmplitude();
        background(0);
        colorMode(RGB);
        for(int i = 0; i < numCubes; i++) // calls cube object
        {
            cubes[i].display();
        }

        translate(-550,-200,0);

        colorMode(RGB);

        for (Ball ball : balls) // calls balls (blue)
        {
            ball.movement();
            ball.display();

        }

        for (BallAmp ballAmp : ballAmps) // calls balls amp (pink)
        {
            ballAmp.movement();
            ballAmp.display();

        }

        translate(0,0,0);

    }
}