# Release Flow

This repository publishes Android library modules through JitPack.

## How a Version Is Released

1. Merge feature and fix pull requests into `main` using conventional commit messages.
2. The `Release` workflow opens or updates a release pull request.
3. Merge the release pull request.
4. GitHub creates a tag such as `v1.2.3` and a GitHub Release.
5. JitPack builds that tag with `./gradlew publishToMavenLocal`.

## Commit Message Rules

- `fix: message` creates a patch release.
- `feat: message` creates a minor release.
- `feat!: message` or `BREAKING CHANGE:` creates a major release.

## Consuming a Module

Add JitPack to dependency resolution:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Use the GitHub owner, repository, module artifact id, and tag:

```kotlin
dependencies {
    implementation("com.github.USER.REPO:core-common:v1.2.3")
    implementation("com.github.USER.REPO:firebase-auth-domain:v1.2.3")
}
```
