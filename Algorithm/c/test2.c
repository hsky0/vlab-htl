#include <stdio.h>
#include <time.h>
#include <sys/time.h>

// int main(){

//     double t1 = 0.0;
//     time_t timep;
//     t1 = time(&timep);
//     printf("time = %lf\n", t1); 

//     return 0;
// }

int main ()
{
    struct timeval start, end;
    gettimeofday( &start, NULL );
    sleep(2); 
    gettimeofday( &end, NULL );
    double timeuse = (end.tv_sec - start.tv_sec) + (end.tv_usec - start.tv_usec) / 1000000.0; 
    printf("time: %lf s\n", timeuse);
    return 0;
    
   
}