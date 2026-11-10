# NexVora Motion Studio 1.0.0: modification report

Base: `capcraft-android-main` (CapCraft for Android 0.0.4-beta, AGPL-3.0-or-later; engine from Concat 0.2.8).
Original upstream: https://github.com/artcraft-android/capcraft-android

Project root: the ZIP's single top folder. Android project: `src/crates/capcraft-android/android/`; Rust workspace: `src/`.
The original tree was copied before any edit; `NEXVORA_CHANGES.patch` is the exact diff against it.

## Identity
- Name NexVora Motion Studio (launcher label "NexVora Motion"), version 1.0.0 (`capcraft.version=1.0.0`, `capcraft.versionCode=1000099`; the build checks the two agree).
- `applicationId = com.nexvora.motionstudio` (debug builds add the original `.debug` suffix). FileProvider authority and the Kotlin code that builds it both follow `applicationId`.
- minSdk 29, targetSdk 36, compileSdk 37 unchanged.

## Deliberately NOT changed (and why)
- **Kotlin namespace / source packages stay `io.github.artcraftandroid.capcraft`.** The Rust library exports `Java_io_github_artcraftandroid_capcraft_NativeContext_init` and UniFFI generates bindings into `...capcraft.core`; renaming means changing Rust, `uniffi.toml`, ProGuard and every import together, and I cannot compile or run any of it here. `applicationId` is independent of the namespace, so the installed identity is fully NexVora.
- **Internal `capcraft*` identifiers** (project data keys such as `capcraftBackground`, effect ids such as `capcraft.outline`, native library `libcapcraft_android.so`, thread names): they are stored in users' project files and effect catalogues; renaming would break saved projects. They are not user-visible.
- Engine, FFmpeg/sherpa scripts, timeline, rendering, export code, encoder settings, SDK levels, dependencies: untouched. No new dependencies.

## Changes
- Branding: `strings.xml` (label, share target "Edit in NexVora Motion"), manifest comments and theme `Theme.NexVoraMotion`, export notification tip, media-picker banner, exported file names `NexVora_Motion_*.mp4/.gif/.jpg/.srt`, and save folders `Movies/NexVora Motion`, `Pictures/NexVora Motion` (previously `/CapCraft`).
- Design system: `ui/Theme.kt` palette remapped to the specified colours (#090B12 background, #111522 panel, #171D2B card, #00D5FF cyan, #8957FF purple, #F7F9FF / #9AA5B8 text, #283044 divider) with new `Palette.Purple`; effect clips use the purple; Material colour scheme gets `secondary`/`outline`. `res/values/colors.xml` holds the same tokens for XML. The Home pages now always use the dark palette; hero art gradient retuned to cyan-indigo-purple.
- Home: hero eyebrow reads "NexVora Motion Studio"; Settings entry "About NexVora Motion Studio". Layout and project logic unchanged.
- About screen rewritten: logo, name, version (read from the package), developer, publisher, the three credit lines, a plain statement that this is a modified version of CapCraft built on Concat, the AGPL notice, and a link to the original source. Licences screen keeps every original entry.
- Icons: original vector artwork (N inside cinematic frame corners, cyan to purple): adaptive foreground, background, monochrome (themed icon), `nexvora_logo.xml` (About), splash icon on Android 12+ (`values-v31/themes.xml`; older versions get the dark window background). Previously a hollow camera; `docs/images/nexvora-512.png` is a PNG render for documentation.
- Legal: `NOTICE`, `src/crates/capcraft-android/NOTICE.md` (shown in-app), `THIRD_PARTY_NOTICES.md` and `README.md` now state that this is a modified CapCraft/Concat work and keep all original text. `LICENSE` untouched.

## Not done / limits (be aware)
- **No compile, no APK, no tests.** This environment has Java only: no Android SDK/NDK, Gradle, Rust or network. Nothing here was built or run. See `TEST_REPORT.md`.
- **UI redesign is at design-system level, not a full relayout.** Colours, theme, splash, icon, Home hero/About/Settings text are changed; editor panels, timeline and export screens keep their layout and only inherit the new palette. A bolder redesign needs an emulator to check each screen, and I did not want to ship unverified layout rewrites of 21k lines of Compose.
- Some hard-coded colours (e.g. `Color(0xFF1C1C1C)` banners, white text on the hero) were left as they were.
- README screenshots still show the original interface.
- `.github/workflows/release.yml` still names artifacts `capcraft-android-<version>.apk` and says CapCraft in comments.
- Cargo workspace version stays 0.2.8 (engine version, separate from the app version).

## Before you distribute (AGPL-3.0-or-later)
1. Publish this modified source and change `SOURCE_URL` in `ui/home/HomeScreen.kt` (currently the original CapCraft repo) to where your modified source lives, so users of your build can get the corresponding source.
2. Keep `LICENSE`, `NOTICE`, both notice files and the in-app Licences screen.
3. "All Rights Reserved" applies only to your own changes; the combined work stays under AGPL, so it cannot be an all-rights-reserved proprietary app. Consider wording like "Copyright (c) 2026 NexVora Lab's Ofc, licensed under AGPL-3.0-or-later" in store listings.
4. Android lets only one app hold an application ID; installing this will not replace a CapCraft install.
