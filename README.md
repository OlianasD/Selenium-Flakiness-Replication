# What Makes Web End-to-End Tests Flaky? An Empirical Study – Replication Package

This repository contains the code required to replicate the experiment described in **“What Makes Web End-to-End Tests Flaky? An Empirical Study”**.

The test suites used are part of the **BEWT** repository, that can be found [here](https://github.com/OlianasD/BEWT). The structure of the repository is described in its `README.md` file.

You can use the scripts included in this repository to replicate the experiment:
- `flakiness.bat` for Windows-based configurations
- `flakiness.sh` for Linux-based configurations

---

## Browser configuration

All test suites must be executed with **Google Chrome 127**.

### Containerized browser
To execute configurations with a containerized browser, use the Docker image:

```
selenium/standalone-chrome:127.0-chromedriver-127.0
```

Create the container with:

```bash
docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" --name=browser selenium/standalone-chrome:127.0-chromedriver-127.0
```

### Native browser with Selenium 4
For configurations that use a native (non-containerized) browser and **Selenium 4**, Selenium Manager can be used.  
The code that selects Google Chrome 127 is already present in the test suites.

### Native browser with Selenium 3
For configurations that use a native browser and **Selenium 3**, you must download **Chrome for Testing version 127.0.6533.119** and the corresponding ChromeDriver:

- [Chrome for Testing 127.0.6533.119 – Windows](https://storage.googleapis.com/chrome-for-testing-public/127.0.6533.119/win64/chrome-win64.zip)
- [Chrome for Testing 127.0.6533.119 – Linux](https://storage.googleapis.com/chrome-for-testing-public/127.0.6533.119/linux64/chrome-linux64.zip)
- [ChromeDriver 127.0.6533.119 – Windows](https://storage.googleapis.com/chrome-for-testing-public/127.0.6533.119/win64/chromedriver-win64.zip)
- [ChromeDriver 127.0.6533.119 – Linux](https://storage.googleapis.com/chrome-for-testing-public/127.0.6533.119/linux64/chromedriver-linux64.zip)

> **Note:** These URLs are not under our control and may change without notice.  
> If this happens, visit <https://googlechromelabs.github.io/chrome-for-testing/>.

For these configurations (Selenium 3, native browser), remember to update the paths in the method  
`BaseTest.setupNativeBrowserNoSeleniumManager()` at:
- `System.setProperty`
- `options.setBinary`

so that they point to the actual locations of ChromeDriver and Chrome for Testing 127 on your system.

---

## SUT container creation

Use the instructions available in the application directory of the [**BEWT** repository](https://github.com/OlianasD/BEWT).  
Strictly adhere to all commands and software versions used: any change may affect the results in unpredictable ways.

---

## Running the experiment

For each test suite and configuration, use the `flakiness` script provided in the test suite directory:
- `flakiness.bat` for Windows
- `flakiness.sh` for Linux

The following table summarizes the requirements for each configuration.

---

## Experimental configurations

| Conf. | Waiting strategy | Browser type | Selenium version | OS      | Test suite version |
|------:|------------------|--------------|------------------|---------|--------------------|
| 1 | implicit | native | 4.35.0 | Windows | implicitNativeSelenium4 |
| 2 | implicit | native | 4.35.0 | Linux | implicitNativeSelenium4 |
| 3 | implicit | native | 3.141.59 | Windows | implicitNativeSelenium3 |
| 4 | implicit | native | 3.141.59 | Linux | implicitNativeSelenium3 |
| 5 | implicit | docker | 4.35.0 | Windows | implicitDockerSelenium4 |
| 6 | implicit | docker | 4.35.0 | Linux | implicitDockerSelenium4 |
| 7 | implicit | docker | 3.141.59 | Windows | implicitDockerSelenium3 |
| 8 | implicit | docker | 3.141.59 | Linux | implicitDockerSelenium3 |
| 9 | explicit | native | 4.35.0 | Windows | explicitNativeSelenium4 |
|10 | explicit | native | 4.35.0 | Linux | explicitNativeSelenium4 |
|11 | explicit | native | 3.141.59 | Windows | explicitNativeSelenium3 |
|12 | explicit | native | 3.141.59 | Linux | explicitNativeSelenium3 |
|13 | explicit | docker | 4.35.0 | Windows | explicitDockerSelenium4 |
|14 | explicit | docker | 4.35.0 | Linux | explicitDockerSelenium4 |
|15 | explicit | docker | 3.141.59 | Windows | explicitDockerSelenium3 |
|16 | explicit | docker | 3.141.59 | Linux | explicitDockerSelenium3 |
