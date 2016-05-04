# sbt-swagger-test
A small study project on [sbt-swagger](https://github.com/hootsuite/sbt-swagger), a great open source sbt plugin by [Hootsuite](https://github.com/hootsuite)
see the [blogpost by Hootsuite](http://code.hootsuite.com/sbt-swagger-for-scala/#more-4135)

# Usage
Just annotate (document) your rest interface (a trait) with JAX-RS (jsr311) annotations and run `run sbt swagger` and you'll find the generated 
[swagger UI](https://github.com/swagger-api/swagger-ui) compatible output in the directory `target/swagger`.

Have fun!    