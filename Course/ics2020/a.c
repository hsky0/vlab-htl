/*************************************************************************
 > File Name: a.c
 > Author: HuangTingling
 > Created Time: 2024��06��04�� ���ڶ� 16ʱ32��45��
 ************************************************************************/

extern int printf (const char *__restrict __format, ...);

int main(int argc, char *argv[])
{
    int aa = 1;
    int bb = 2;
    #if aa == bb
        printf("Yes\n");
    #else
        printf("No\n");
    #endif

     return 0;
}

