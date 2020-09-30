# Aula 04 - Exercício da Camera FPS resolvido

Na solução dos exercícios:

##Robot

O braço do robô foi resolvido na classe Robot. Na resolução observe:

* Que um membro do robo (Limb) pode ser ligado a outro (Limb next);
* Que a matriz de um membro é usado como base para o desenho do próximo;
* Que a matriz de um membro leva em consideração o outro em coordenadas de modelo, 
isto é descartando qualquer rotação e translação.

## Camera

* Foi criado o pacote br.pucpr.mage.camera e a classe Camera foi movida para lá
* Foi adicionada a classe CameraFPS, filha da classe Camera

A classe Camera adiciona um vetor direction e passa a calcular o vetor target com base em position + direction.

Foram adicionados métodos para movimentação e strafe com base na direção da camera, velocidade e tempo.


