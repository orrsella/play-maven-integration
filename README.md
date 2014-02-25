# play-maven-integration

A sample project showing how to integrate a [Play Framework](http://www.playframework.com/) with a [Maven](http://maven.apache.org/) build process. See [Integrating Play Framework And Maven](http://orrsella.com/) for more information.

## Capabilities

* Multi-module project (separate the play web app module and the "core" module)
* All configuration done via pom files, especially *dependencies*
* Allows working with Maven's [Dependency Management](http://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Dependency_Management) which centralizes dependency information in parent poms
* Allows building/testing/running thru `mvn`
* Allows building/testing/running thru `play`
* Access all the special play commands thru maven
