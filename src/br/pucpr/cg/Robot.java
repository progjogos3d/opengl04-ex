package br.pucpr.cg;

import br.pucpr.mage.Keyboard;
import br.pucpr.mage.Mesh;
import br.pucpr.mage.Shader;
import org.joml.Matrix4f;
import org.joml.Vector3f;

import static org.joml.Math.toRadians;
import static org.lwjgl.glfw.GLFW.*;

import static br.pucpr.mage.MathUtil.*;

public class Robot {
    private static final Keyboard keys = Keyboard.getInstance();
    private Mesh mesh;
    private Limb arm;

    public Robot(Mesh mesh) {
        this.mesh = mesh;

        var translation = new Vector3f(0.0f, 0.35f, 0.0f);
        var scale = new Vector3f(0.15f, 0.8f, 0.15f);
        var pivot = new Vector3f(0.0f, 0.3f, 0.0f);

        this.arm = new Limb(GLFW_KEY_Q, GLFW_KEY_E, new Vector3f(0.6f, 0.48f, 0.0f), scale, pivot);
        var forearm = new Limb(GLFW_KEY_A, GLFW_KEY_D, translation, scale, pivot);
        var hand = new Limb(GLFW_KEY_Z, GLFW_KEY_C, translation, scale, pivot);

        arm.setNext(forearm);
        forearm.setNext(hand);
    }

    public void update(float secs) {
        arm.update(secs);
    }

    public void draw(Shader shader) {
        var world = new Matrix4f();
        mesh.setUniform("uWorld", world).draw(shader);
        arm.draw(world, shader);
    }

    private class Limb {
        private Limb next;
        private int key1, key2;

        private Vector3f translation;
        private float rotation = toRadians(270f);
        private Vector3f scale;
        private Vector3f pivot;

        public Limb(int key1, int key2, Vector3f translation, Vector3f scale, Vector3f pivot) {
            this.key1 = key1;
            this.key2 = key2;

            this.translation = translation;
            this.scale = scale;
            this.pivot = pivot;
        }

        public void setNext(Limb next) {
            this.next = next;
        }

        public void update(float secs) {
            if (keys.isDown(key1)) {
                rotation += toRadians(360.0f) * secs;
            } else if (keys.isDown(key2)) {
                rotation -= toRadians(360.0f) * secs;
            }

            if (next != null) next.update(secs);
        }

        public void draw(Matrix4f parent, Shader shader) {
            var transform = new Matrix4f()
                    .translate(translation)  //posição
                    .rotateZ(rotation)       //rotação
                    .translate(pivot);       //pivot

            var world = mul(parent, transform);
            mesh.setUniform("uWorld", scale(world, scale))
                .draw(shader);


            if (next != null) next.draw(world, shader);
        }
    }
}


