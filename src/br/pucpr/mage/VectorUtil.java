package br.pucpr.mage;

import org.joml.Vector3f;
import org.joml.Vector3fc;

public class VectorUtil {
    public static Vector3f add(Vector3fc a, Vector3f b) {
        return new Vector3f(a).add(b);
    }

    public static Vector3f add(Vector3fc a, float x, float y, float z) {
        return new Vector3f(a).add(x, y, z);
    }

    public static Vector3f sub(Vector3fc a, Vector3f b) {
        return new Vector3f(a).sub(b);
    }

    public static Vector3f sub(Vector3fc a, float x, float y, float z) {
        return new Vector3f(a).sub(x, y, z);
    }

    public static Vector3f mul(Vector3fc v, float s) {
        return new Vector3f(v).mul(s);
    }

    public static Vector3f mul(Vector3fc a, Vector3fc b) {
        return new Vector3f(a).mul(b);
    }

    public static Vector3f mul(Vector3fc a, float x, float y, float z) {
        return new Vector3f(a).mul(x, y, z);
    }

    public static Vector3f cross(Vector3fc a, Vector3fc b) {
        return new Vector3f(a).cross(b);
    }

    public static Vector3f cross(Vector3fc a, float x, float y, float z) {
        return new Vector3f(a).cross(x, y, z);
    }

    public static Vector3f normalize(Vector3fc v) {
        return new Vector3f(v).normalize();
    }

    public static float dot(Vector3fc a, Vector3fc b) {
        return a.dot(b);
    }

    public static float dot(Vector3fc a, float x, float y, float z) {
        return a.dot(x, y, z);
    }

    public static Vector3f negate(Vector3fc vec) {
        return new Vector3f(vec);
    }

    public static Vector3f lerp(Vector3fc a, Vector3fc b, float t) {
        return a.lerp(b, t, new Vector3f());
    }

    public static Vector3f reflect(Vector3fc ray, Vector3fc normal) {
        return ray.reflect(normal, new Vector3f());
    }


}
