## IntelliJ setup

### Import Bazel Project

#### Select the workspace

<img src="select_workspace.png" width="300px">

#### Set the project view to `nua.bazelproject`

<img src="select_project_view.png" width="300px">

#### Setup dependencies

```bash
rm -rf lib
mkdir -p lib
bazel build intellij
tar xf bazel-bin/intellij/intellij.tar -C lib
```

#### Add Library...

<img src="add_library.png" width="200px">
<img src="add_library_confirm.png" width="300px">

#### Setup Scala SDK

<img src="setup_scala_sdk.png" width="300px">
<img src="add_scala_support.png" width="300px">

Make sure to select `scala-sdk-2.11` otherwise you might get errors when running single tests from within IntelliJ.

#### Fix project structure

##### Error

<img src="project_structure_path_error.png" width="300px">

##### Before

<img src="project_structure_path_before.png" width="300px">

##### After

<img src="project_structure_path_after.png" width="300px">

#### Changing Dependencies

When adding or removing dependencies, we need to also update the dependencies viewed by IntelliJ:
- Add or remove the dependency in question from `intellij/BUILD`
- [Refresh dependencies](#setup-dependencies)
- You may need to re-sync bazel (`IntelliJ -> Bazel -> Sync -> Sync Project with BUILD Files`) and follow the [above steps](#add-library) again
