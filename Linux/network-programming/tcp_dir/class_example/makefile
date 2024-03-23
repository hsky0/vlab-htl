# a:server.c server3.c client.c
# 	gcc server.c -o server -Wall -g &
# 	gcc client.c -o client -Wall -g

a:server.c client.c
	gcc server.c wrap.c -o server -Wall -g &
	gcc client.c wrap.c -o client -Wall -g