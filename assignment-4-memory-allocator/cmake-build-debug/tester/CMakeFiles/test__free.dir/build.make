# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug

# Include any dependencies generated for this target.
include tester/CMakeFiles/test__free.dir/depend.make

# Include the progress variables for this target.
include tester/CMakeFiles/test__free.dir/progress.make

# Include the compile flags for this target's objects.
include tester/CMakeFiles/test__free.dir/flags.make

tester/CMakeFiles/test__free.dir/tests/_free.c.o: tester/CMakeFiles/test__free.dir/flags.make
tester/CMakeFiles/test__free.dir/tests/_free.c.o: ../tester/tests/_free.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object tester/CMakeFiles/test__free.dir/tests/_free.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/test__free.dir/tests/_free.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/tester/tests/_free.c

tester/CMakeFiles/test__free.dir/tests/_free.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/test__free.dir/tests/_free.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/tester/tests/_free.c > CMakeFiles/test__free.dir/tests/_free.c.i

tester/CMakeFiles/test__free.dir/tests/_free.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/test__free.dir/tests/_free.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/tester/tests/_free.c -o CMakeFiles/test__free.dir/tests/_free.c.s

# Object files for target test__free
test__free_OBJECTS = \
"CMakeFiles/test__free.dir/tests/_free.c.o"

# External object files for target test__free
test__free_EXTERNAL_OBJECTS = \
"/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester/CMakeFiles/test_stubs.dir/src/test_utils.c.o"

tester/test__free: tester/CMakeFiles/test__free.dir/tests/_free.c.o
tester/test__free: tester/CMakeFiles/test_stubs.dir/src/test_utils.c.o
tester/test__free: tester/CMakeFiles/test__free.dir/build.make
tester/test__free: src/libmemalloc.a
tester/test__free: tester/CMakeFiles/test__free.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable test__free"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/test__free.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
tester/CMakeFiles/test__free.dir/build: tester/test__free

.PHONY : tester/CMakeFiles/test__free.dir/build

tester/CMakeFiles/test__free.dir/clean:
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester && $(CMAKE_COMMAND) -P CMakeFiles/test__free.dir/cmake_clean.cmake
.PHONY : tester/CMakeFiles/test__free.dir/clean

tester/CMakeFiles/test__free.dir/depend:
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/tester /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-4-memory-allocator/cmake-build-debug/tester/CMakeFiles/test__free.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : tester/CMakeFiles/test__free.dir/depend

