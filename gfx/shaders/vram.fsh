#version 330 core

smooth in vec2 vertUv;

out vec4 outColour;

uniform sampler2D tex;

void main() {
  float pixel = texture(tex, vertUv).r;
  outColour = vec4(pixel, pixel, pixel, 1.0);
}
