# Automated Stack Tests

## Configure Selenoid for UI-Testing

A lighting fast Selenium Protocol implementation running browsers in Docker
containers.

### Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Using an existing configuration file](#using-an-existing-configuration-file)

### Prerequisites

Before you start to configure Selenoid, Docker has to be installed.

### Installation

Download [Configuration Manager][aerokube-cm] (Selenoid quick installation
binary) for your platform from [releases][aerokube-git-cm] page.

Configuration Manager - a fully automated installation tool for Selenoid abd
Selenoid UI doing all the work for you

Give execution permissions to binary:
```shell
chmod +x cm
```

Run one command to start Selenoid:
```shell
./cm selenoid start --nvc
```

Optionally run one more command to start Selenoid UI:
```shell
./cm selenoid-ui start
```

### Using an existing configuration file

Create `browsers.json` configuration file with content:

_browsers.json_
```json
{
  "chrome": {
    "default": "latest",
    "versions": {
      "latest": {
        "images": "selenoid/chrome",
        "port": "4444",
        "path": "/",
        "tmpfs": {
          "/tmp": "size=256m"
        }
      }
    }
  }
}
```

Run `cm` with `--browsers-json` flag:
```shell
./cm selenoid start --nvc --browsers-json /path/to/browsers.json
```

[aerokube-cm]: http://aerokube.com/cm/latest/
[aerokube-git-cm]: https://github.com/aerokube/cm/releases/latest/
