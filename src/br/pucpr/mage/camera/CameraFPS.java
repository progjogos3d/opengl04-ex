package br.pucpr.mage.camera;

import org.joml.Vector3f;

import static br.pucpr.mage.MathUtil.*;

public class CameraFPS extends Camera {
    private float angleY = 0;

    public Vector3f getDirection() {
        return new Vector3f(0, 0, -1).rotateY(angleY);
    }

    @Override
    public Vector3f getTarget() {
        return add(getPosition(), getDirection());
    }

    public CameraFPS setAngleY(float angle) {
        this.angleY = angle;
        return this;
    }

    public CameraFPS turn(float angle, float secs) {
        this.angleY += angle * secs;
        return this;
    }

    public CameraFPS move(float speed, float secs) {
        var displacement = mul(getDirection(), speed * secs);
        getPosition().add(displacement);
        return this;
    }

    public CameraFPS strafe(float speed, float secs) {
        var strafe =
                cross(getUp(), getDirection())
                .mul(speed * secs);
        getPosition().add(strafe);
        return this;

    }
}
