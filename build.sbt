Global / lintUnusedKeysOnLoad := false

lazy val root = (project in file(".")).settings(
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.9",
  logLevel := Level.Warn,
  onLoadMessage := "BEAT NAVY",
  // name := "Homework",
  scalacOptions ++= Seq(
    "-deprecation", // Explain deprecation errors in more detail
    "-explaintypes", // Explain type errors in more detail
    "-feature", // Warn for features which should be exported implicitly
    "-unchecked", // Warn where generated code depends on assumptions
    "-Wdead-code", // Warn when dead code is identified
    "-Werror", // Fail the compilation if there are any warnings
    "-Wunused:linted", // Warn for unused imports, privates, locals, implicits
    "-Wvalue-discard", // Warn when non-Unit expression results are unused
    "-Xcheckinit" // Throw exception on unitialized access
  ),
  scalaVersion := "2.13.4",
  showSuccess := false,
  traceLevel := 0
)

// WartRemover
// https://www.wartremover.org/doc/install-setup.html
wartremoverErrors ++= Warts.allBut(
  Wart.Any,
  Wart.Equals,
  Wart.FinalCaseClass,
  Wart.MutableDataStructures,
  Wart.NonUnitStatements,
  Wart.Nothing,
  Wart.Recursion,
  Wart.StringPlusAny,
  Wart.TraversableOps,
  Wart.Var,
  Wart.While
)
