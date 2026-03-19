## This is the repo used to create my personal website: https://carlosgub.dev

![Image Preview](https://github.com/carlosgub/carlosgub.dev/blob/develop/design/readme_preview.webp)

## Getting Started

* Read the [README](https://github.com/varabyte/kobweb/blob/main/README.md) from the Kobweb repository to install the Kobweb binary.

* Run the development server by typing the following command in a terminal under the `site` folder:

```bash
$ cd site
$ kobweb run
```

* Open [http://localhost:8080](http://localhost:8080) with your browser to see the result.
* Access the Links page (Linktree-style) at [http://localhost:8080/links](http://localhost:8080/links).

You can use any editor you want for the project, but we recommend using **IntelliJ IDEA Community Edition** downloaded
using the [Toolbox App](https://www.jetbrains.com/toolbox-app/).

Press `Q` in the terminal to gracefully stop the server.

## Static Export

This project includes a specialized skill for exporting the site as a static website.

1. Navigate to the `site` folder.
2. Run the export command:
```bash
$ kobweb export --layout static
```
The exported site will be available in `site/.kobweb/site/`.

For more details, see the [Static Export Skill](.agents/skills/kobweb-static-export/SKILL.md).

# Credits
* This project use [Kobweb](https://github.com/varabyte)
* Inspired by [Brittany Chiang](https://v3.brittanychiang.com), [Kristina Volchek](https://kristi.digital) and [Linktree](https://linktr.ee/).
