# Test report

Environment: Linux sandbox with OpenJDK 21 and Python/PIL. No Android SDK, NDK, Gradle distribution, Rust/cargo, emulator or network.

| Check | Result |
|---|---|
| Project root and structure inspected | Done |
| License inspected | AGPL-3.0-or-later confirmed (`LICENSE`, `NOTICE`, Cargo `license`) |
| All 11 Android XML resources parse as well-formed XML | Pass |
| Resource references (`@drawable`, `@mipmap`, `@color`, theme name in manifest) resolve to files defined | Pass (static grep) |
| applicationId, FileProvider authority, `packageName + ".files"` consistent | Pass (static) |
| JNI symbol, UniFFI package, ProGuard keep rule, `NativeContext` package still agree | Pass (unchanged, static) |
| versionCode matches the build script's formula for 1.0.0 (1000099) | Pass (computed) |
| Residual user-facing "CapCraft" strings | Only intentional attribution remains |
| Kotlin compilation | **Not run** |
| Rust build / `cargo test` | **Not run** |
| Gradle configuration / unit tests / lint | **Not run** |
| Debug APK, release APK | **Not built. No APK exists.** |
| Launch, home, project loading, import, editor, export | **Not tested** (no device/emulator) |

The Kotlin edits are string/colour changes plus one rewritten composable (About) that uses only imports already in that file; still, treat them as uncompiled until you run a build.
