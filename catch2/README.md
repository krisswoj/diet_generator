# Running

```bash
mkdir build
cd build
cmake ..
make check # short tests
CTEST_OUTPUT_ON_FAILURE=1 make check # tests with verbose output
./tests # directly run tests
```

# About c++ in VSCode

[cpp](https://code.visualstudio.com/docs/languages/cpp)


# Setup for VSCode


settings.json can look like this (these are my settings):

```json
{
    "C_Cpp.intelliSenseEngineFallback": "Enabled",
    "files.associations": {
        "cstdio": "cpp",
        "cstdlib": "cpp",
        "cwchar": "cpp",
        "exception": "cpp",
        "bitset": "cpp"
    },
    "clang.cxxflags": ["-std=c++14"]
}
```