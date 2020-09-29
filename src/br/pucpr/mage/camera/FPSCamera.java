package br.pucpr.mage.camera;

import org.joml.Vector3f;

import static br.pucpr.mage.VectorUtil.*;

public class FPSCamera extends Camera {
    private float angleY = 0;

    public Vector3f getDirection() {
        return new Vector3f(0, 0, -1).rotateY(angleY);
    }

    @Override
    public Vector3f getTarget() {
        return add(getPosition(), getDirection());
    }

    public FPSCamera setAngleY(float angle) {
        this.angleY = angle;
        return this;
    }

    public FPSCamera turn(float angle, float speed) {
        this.angleY += angle * speed;
        return this;
    }

    public FPSCamera move(float speed, float time) {
        var displacement = mul(getDirection(), speed * time);
        getPosition().add(displacement);
        return this;
    }

    public FPSCamera strafe(float speed, float time) {
        var strafe =
                cross(getDirection(), getUp())
                .mul(speed * time);
        getPosition().add(strafe);
        return this;

    }
}
