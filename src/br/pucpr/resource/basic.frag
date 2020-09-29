#version 330

//Cor de saída, que será desenhada na tela.
in vec3 vColor;
out vec4 outColor;

void main() {
    outColor = vec4(vColor, 1.0);
}