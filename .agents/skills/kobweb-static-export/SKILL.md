---
name: Kobweb Static Export
description: Compiles and exports the Kobweb project into a static website.
---

# Kobweb Static Export Skill

This skill provides instructions and tools to export a Kobweb project as a static website.

## Prerequisites

- Kobweb CLI installed.
- Gradle environment configured.

## Usage

### 1. Navigate to the site module
Ensure you are in the directory containing the Kobweb site (usually the `site/` folder).

### 2. Run the export command
Execute the following command to generate the static site:

```bash
kobweb export
```

> [!TIP]
> If your site doesn't have a backend (API routes), use `--layout static` to optimize the export:
> `kobweb export --layout static`

Alternatively, you can run it via Gradle:

```bash
./gradlew kobwebExport
```

### 3. Output Location
The exported static website will be located at:
`site/.kobweb/site/`

## Verification

To verify the exported site, you can use any static file server. For example:

```bash
npx serve site/.kobweb/site/
```

## Troubleshooting

- **Compilation Errors**: Ensure the project builds correctly with `./gradlew build` before exporting.
- **Missing Assets**: Verify that all assets are in `src/jsMain/resources/public/`.
