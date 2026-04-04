#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF)
# Maven Wrapper startup script, version 3.2.0
# ----------------------------------------------------------------------------

set -e

# OS specific support.
darwin=false
case "`uname`" in
  Darwin*) darwin=true ;;
esac

if [ -n "$JAVA_HOME" ] ; then
  JAVACMD="$JAVA_HOME/bin/java"
  if [ ! -x "$JAVACMD" ] ; then
    die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
  fi
else
  JAVACMD="`\\unset -f command; \\command -v java`"
fi

MAVEN_PROJECTBASEDIR="${MAVEN_BASEDIR:-.}"

if [ -z "$MAVEN_OPTS" ] ; then
  MAVEN_OPTS=""
fi

WRAPPER_JAR=".mvn/wrapper/maven-wrapper.jar"
WRAPPER_LAUNCHER=org.apache.maven.wrapper.MavenWrapperMain
WRAPPER_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar"

# Download the maven-wrapper.jar if missing
if [ ! -f "$MAVEN_PROJECTBASEDIR/$WRAPPER_JAR" ]; then
  if command -v wget > /dev/null; then
    wget "$WRAPPER_URL" -O "$MAVEN_PROJECTBASEDIR/$WRAPPER_JAR" >/dev/null 2>&1
  elif command -v curl > /dev/null; then
    curl -o "$MAVEN_PROJECTBASEDIR/$WRAPPER_JAR" "$WRAPPER_URL" >/dev/null 2>&1
  fi
fi

exec "$JAVACMD" \
  $MAVEN_OPTS \
  -classpath "$MAVEN_PROJECTBASEDIR/$WRAPPER_JAR" \
  "-Dmaven.multiModuleProjectDirectory=$MAVEN_PROJECTBASEDIR" \
  "$WRAPPER_LAUNCHER" "$@"
