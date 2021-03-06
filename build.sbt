/*
 * Copyright 2016 Dennis Vriend
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 
 
name := "sbt-swagger-test"

organization := "com.github.dnvriend"

version := "1.0.0"

resolvers += Resolver.typesafeRepo("releases")

scalaVersion := "2.11.8"

libraryDependencies ++= {
    Seq(
     "com.wordnik" % "swagger-annotations" % "1.3.10",
     "javax.ws.rs" % "jsr311-api" % "1.1.1"
    )
}

licenses +=("Apache-2.0", url("http://opensource.org/licenses/apache2.0.php"))

// enable scala code formatting //
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform

// Scalariform settings
SbtScalariform.autoImport.scalariformPreferences := SbtScalariform.autoImport.scalariformPreferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(RewriteArrowSymbols, true)

// enable updating file headers //
import de.heikoseeberger.sbtheader.license.Apache2_0

headers := Map(
  "scala" -> Apache2_0("2016", "Dennis Vriend"),
  "conf" -> Apache2_0("2016", "Dennis Vriend", "#")
)

// sbt swagger settings //
import com.hootsuite.sbt.swagger
com.hootsuite.sbt.swagger.Sbt.swaggerSettings
swagger.Sbt.apiVersion := "1.0"
swagger.Sbt.basePath := "http://localhost"
swagger.Sbt.apiPath := "/"
//swagger.Sbt.packages := swagger.Sbt.All
swagger.Sbt.packages := swagger.Sbt.WhitelistPrefixes(Seq("com.github.dnvriend.rest"))
swagger.Sbt.excludePropertyClassPrefixes := Set("play.api.libs.json")
 