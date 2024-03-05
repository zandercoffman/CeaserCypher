{ pkgs }: {
    deps = [
      pkgs.java CeaserCypherTest
      pkgs.java CeaserCypherTest
      pkgs.openjdk16-bootstrap
      pkgs.adoptopenjdk-hotspot-bin-8
      pkgs.java src/main/java CeaserCypherTest
      pkgs.adoptopenjdk-jre-bin
      pkgs.adoptopenjdk-hotspot-bin-15
      pkgs.temurin-bin-16
      pkgs.zulu
      pkgs.java -cp src/main/java CeaserCypherTest
      pkgs.imagemagick6
      pkgs.import java.util.Map;
        pkgs.graalvm17-ce
        pkgs.maven
        pkgs.replitPackages.jdt-language-server
        pkgs.replitPackages.java-debug
    ];
}