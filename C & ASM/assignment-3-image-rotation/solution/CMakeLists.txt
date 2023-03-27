file(GLOB_RECURSE sources CONFIGURE_DEPENDS
    src/*.c
    src/*.h
    include/*.h
)

add_executable(image-transformer ${sources} include/bmp_header.h include/image.h include/bmp_io.h include/transform.h include/file_io.h include/file_io_status_codes.h src/io/file_io.c include/printer.h src/io/printer.c src/utils/bmp_padding.c include/bmp_padding.h src/io/bmp_io.c src/utils/transform.c src/io/image.c src/utils/status_codes_mapping.c src/io/bmp_header.c)
target_include_directories(image-transformer PRIVATE src include)
