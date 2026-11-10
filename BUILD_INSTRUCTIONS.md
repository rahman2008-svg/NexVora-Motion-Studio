# Building NexVora Motion Studio

Same toolchain as upstream CapCraft (not verified in this delivery: see TEST_REPORT.md).

1. Prerequisites: JDK 17+, Android SDK (compileSdk 37) and NDK `29.0.14206865`, Rust per `src/rust-toolchain.toml` (1.93+) with the `aarch64-linux-android` target, `cargo-ndk`.
2. Native deps: build FFmpeg and fetch sherpa-onnx with `src/scripts/ffmpeg-mobile.sh` and `src/scripts/sherpa-mobile.sh`; `src/scripts/mobile-env.sh` exports the variables the build needs (see `.github/workflows/release.yml` for the exact CI order and cache keys).
3. Build:
   ```
   cd src/crates/capcraft-android/android
   ./gradlew assembleDebug      # applicationId com.nexvora.motionstudio.debug
   ./gradlew assembleRelease -Pcapcraft.abis=arm64-v8a
   ```
   Gradle runs `cargo ndk` and the UniFFI bindgen itself; the first build is long.
4. Release signing: set `CAPCRAFT_KEYSTORE`, `CAPCRAFT_KEYSTORE_PASSWORD`, `CAPCRAFT_KEY_ALIAS`, `CAPCRAFT_KEY_PASSWORD` (otherwise the debug key is used). Use your own key; do not reuse upstream's.
5. Version: edit `capcraft.version` and `capcraft.versionCode` together in `gradle.properties`.
