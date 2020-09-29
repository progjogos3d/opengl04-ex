# Aula 04 - Exercício da Camera FPS resolvido

Na solução do exercício:
* Foi criado o pacote br.pucpr.mage.camera e a classe Camera foi movida para lá
* Foi adicionada a classe CameraFPS, filha da classe Camera

A classe Camera adiciona um vetor direction e passa a calcular o vetor target com base em position + direction.

Foram adicionados métodos para movimentação e strafe com base na direção da camera, velocidade e tempo.