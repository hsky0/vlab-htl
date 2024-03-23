install:
	nasm boot.asm -o boot.bin && \
	dd if=boot.bin of=hd16M.img bs=512 count=1 conv=notrunc
run:
	/home/ubuntu/Downloads/bochs/bin/bochs -q