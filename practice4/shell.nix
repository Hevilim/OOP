{ pkgs ? import <nixpkgs> {} }:
let
  runtimeLibs = with pkgs; lib.makeLibraryPath [
    glfw
    libGL
    libx11
    libxcursor
    libxext
    libxrandr
    libxxf86vm
  ];
in
pkgs.mkShell {
  buildInputs = [
    pkgs.jdk21
    pkgs.gradle
  ];
  shellHook = ''
    export LD_LIBRARY_PATH=${runtimeLibs}:$LD_LIBRARY_PATH
  '';
}

