for f in `ls -d */R/*`; do R CMD build $f; done
