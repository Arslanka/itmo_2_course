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
CMAKE_SOURCE_DIR = /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug

# Include any dependencies generated for this target.
include solution/CMakeFiles/image-transformer.dir/depend.make

# Include the progress variables for this target.
include solution/CMakeFiles/image-transformer.dir/progress.make

# Include the compile flags for this target's objects.
include solution/CMakeFiles/image-transformer.dir/flags.make

solution/CMakeFiles/image-transformer.dir/src/io/bmp_header.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/io/bmp_header.c.o: ../solution/src/io/bmp_header.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object solution/CMakeFiles/image-transformer.dir/src/io/bmp_header.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/io/bmp_header.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/bmp_header.c

solution/CMakeFiles/image-transformer.dir/src/io/bmp_header.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/io/bmp_header.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/bmp_header.c > CMakeFiles/image-transformer.dir/src/io/bmp_header.c.i

solution/CMakeFiles/image-transformer.dir/src/io/bmp_header.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/io/bmp_header.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/bmp_header.c -o CMakeFiles/image-transformer.dir/src/io/bmp_header.c.s

solution/CMakeFiles/image-transformer.dir/src/io/bmp_io.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/io/bmp_io.c.o: ../solution/src/io/bmp_io.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building C object solution/CMakeFiles/image-transformer.dir/src/io/bmp_io.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/io/bmp_io.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/bmp_io.c

solution/CMakeFiles/image-transformer.dir/src/io/bmp_io.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/io/bmp_io.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/bmp_io.c > CMakeFiles/image-transformer.dir/src/io/bmp_io.c.i

solution/CMakeFiles/image-transformer.dir/src/io/bmp_io.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/io/bmp_io.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/bmp_io.c -o CMakeFiles/image-transformer.dir/src/io/bmp_io.c.s

solution/CMakeFiles/image-transformer.dir/src/io/file_io.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/io/file_io.c.o: ../solution/src/io/file_io.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building C object solution/CMakeFiles/image-transformer.dir/src/io/file_io.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/io/file_io.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/file_io.c

solution/CMakeFiles/image-transformer.dir/src/io/file_io.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/io/file_io.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/file_io.c > CMakeFiles/image-transformer.dir/src/io/file_io.c.i

solution/CMakeFiles/image-transformer.dir/src/io/file_io.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/io/file_io.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/file_io.c -o CMakeFiles/image-transformer.dir/src/io/file_io.c.s

solution/CMakeFiles/image-transformer.dir/src/io/image.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/io/image.c.o: ../solution/src/io/image.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building C object solution/CMakeFiles/image-transformer.dir/src/io/image.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/io/image.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/image.c

solution/CMakeFiles/image-transformer.dir/src/io/image.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/io/image.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/image.c > CMakeFiles/image-transformer.dir/src/io/image.c.i

solution/CMakeFiles/image-transformer.dir/src/io/image.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/io/image.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/image.c -o CMakeFiles/image-transformer.dir/src/io/image.c.s

solution/CMakeFiles/image-transformer.dir/src/io/printer.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/io/printer.c.o: ../solution/src/io/printer.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building C object solution/CMakeFiles/image-transformer.dir/src/io/printer.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/io/printer.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/printer.c

solution/CMakeFiles/image-transformer.dir/src/io/printer.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/io/printer.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/printer.c > CMakeFiles/image-transformer.dir/src/io/printer.c.i

solution/CMakeFiles/image-transformer.dir/src/io/printer.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/io/printer.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/io/printer.c -o CMakeFiles/image-transformer.dir/src/io/printer.c.s

solution/CMakeFiles/image-transformer.dir/src/main.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/main.c.o: ../solution/src/main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building C object solution/CMakeFiles/image-transformer.dir/src/main.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/main.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/main.c

solution/CMakeFiles/image-transformer.dir/src/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/main.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/main.c > CMakeFiles/image-transformer.dir/src/main.c.i

solution/CMakeFiles/image-transformer.dir/src/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/main.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/main.c -o CMakeFiles/image-transformer.dir/src/main.c.s

solution/CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.o: ../solution/src/utils/bmp_padding.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Building C object solution/CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/bmp_padding.c

solution/CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/bmp_padding.c > CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.i

solution/CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/bmp_padding.c -o CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.s

solution/CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.o: ../solution/src/utils/status_codes_mapping.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Building C object solution/CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/status_codes_mapping.c

solution/CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/status_codes_mapping.c > CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.i

solution/CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/status_codes_mapping.c -o CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.s

solution/CMakeFiles/image-transformer.dir/src/utils/transform.c.o: solution/CMakeFiles/image-transformer.dir/flags.make
solution/CMakeFiles/image-transformer.dir/src/utils/transform.c.o: ../solution/src/utils/transform.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Building C object solution/CMakeFiles/image-transformer.dir/src/utils/transform.c.o"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/image-transformer.dir/src/utils/transform.c.o   -c /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/transform.c

solution/CMakeFiles/image-transformer.dir/src/utils/transform.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/image-transformer.dir/src/utils/transform.c.i"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/transform.c > CMakeFiles/image-transformer.dir/src/utils/transform.c.i

solution/CMakeFiles/image-transformer.dir/src/utils/transform.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/image-transformer.dir/src/utils/transform.c.s"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution/src/utils/transform.c -o CMakeFiles/image-transformer.dir/src/utils/transform.c.s

# Object files for target image-transformer
image__transformer_OBJECTS = \
"CMakeFiles/image-transformer.dir/src/io/bmp_header.c.o" \
"CMakeFiles/image-transformer.dir/src/io/bmp_io.c.o" \
"CMakeFiles/image-transformer.dir/src/io/file_io.c.o" \
"CMakeFiles/image-transformer.dir/src/io/image.c.o" \
"CMakeFiles/image-transformer.dir/src/io/printer.c.o" \
"CMakeFiles/image-transformer.dir/src/main.c.o" \
"CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.o" \
"CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.o" \
"CMakeFiles/image-transformer.dir/src/utils/transform.c.o"

# External object files for target image-transformer
image__transformer_EXTERNAL_OBJECTS =

solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/io/bmp_header.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/io/bmp_io.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/io/file_io.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/io/image.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/io/printer.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/main.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/utils/bmp_padding.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/utils/status_codes_mapping.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/src/utils/transform.c.o
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/build.make
solution/image-transformer: solution/CMakeFiles/image-transformer.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_10) "Linking C executable image-transformer"
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/image-transformer.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
solution/CMakeFiles/image-transformer.dir/build: solution/image-transformer

.PHONY : solution/CMakeFiles/image-transformer.dir/build

solution/CMakeFiles/image-transformer.dir/clean:
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution && $(CMAKE_COMMAND) -P CMakeFiles/image-transformer.dir/cmake_clean.cmake
.PHONY : solution/CMakeFiles/image-transformer.dir/clean

solution/CMakeFiles/image-transformer.dir/depend:
	cd /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/solution /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution /Users/arslanginiatullin/Desktop/itmo2course/asm/assignment-3-image-rotation/cmake-build-debug/solution/CMakeFiles/image-transformer.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : solution/CMakeFiles/image-transformer.dir/depend

