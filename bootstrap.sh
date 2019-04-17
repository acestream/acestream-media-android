#!/bin/sh
set -e

acestream-engine-android-core/bootstrap_appodeal.sh
connect-sdk/bootstrap_connect_sdk.sh
vlc-android/bootstrap_acestream_engine.sh

echo "* Bootstrap done"