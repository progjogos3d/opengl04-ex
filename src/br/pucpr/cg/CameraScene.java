package br.pucpr.cg;

import static org.joml.Math.toRadians;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import br.pucpr.mage.*;
import br.pucpr.mage.camera.CameraFPS;

public class CameraScene implements Scene {
    private Keyboard keys = Keyboard.getInstance();

    private Shader shader;
    private Robot robot;

    private CameraFPS camera = new CameraFPS();
    private final float WALK_SPEED = 7f;
    private final float TURN_SPEED = toRadians(120f);

    @Override
    public void init() {
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_CULL_FACE);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        shader = Shader.loadProgram("basic");
        robot = new Robot(new MeshFactory(shader).createCube());
        camera.getPosition().set(0.0f, 0.0f, 5.0f);
    }

    @Override
    public void update(float secs) {
        if (keys.isPressed(GLFW_KEY_ESCAPE)) {
            glfwSetWindowShouldClose(glfwGetCurrentContext(), true);
            return;
        }

        var strafe = keys.isDown(GLFW_KEY_LEFT_SHIFT);

        if (keys.isDown(GLFW_KEY_UP)) {
            camera.move(WALK_SPEED, secs);
        } else if (keys.isDown(GLFW_KEY_DOWN)) {
            camera.move(-WALK_SPEED, secs);
        }

        if (strafe) {
            if (keys.isDown(GLFW_KEY_LEFT)) {
                camera.strafe(WALK_SPEED, secs);
            } else if (keys.isDown(GLFW_KEY_RIGHT)) {
                camera.strafe(-WALK_SPEED, secs);
            }
        } else {
            if (keys.isDown(GLFW_KEY_LEFT)) {
                camera.turn(TURN_SPEED, secs);
            } else if (keys.isDown(GLFW_KEY_RIGHT)) {
                camera.turn(-TURN_SPEED, secs);
            }
        }

        robot.update(secs);
    }

    @Override
    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        shader.bind();
            //Criamos uma camera afastada em 2 no eixo z, e um pouco elevada
            camera.apply(shader);
        shader.unbind();

        //Como a camera está elevada, não precisamos mais girar o cubo no eixo x.
        robot.draw(shader);
    }

    @Override
    public void deinit() {
    }

    public static void main(String[] args) {
        new Window(new CameraScene(), "Rotating cube", 800, 600).show();
    }
}
