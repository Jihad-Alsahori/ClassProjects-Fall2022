#include <iostream>
#include <iomanip>

using namespace std;
int Insert(int A[], int);

int main()
{
    cout << "Input size" << setw(23) << "Calculated average" << setw(19) << "Real average" << endl;
    cout << "..........................................................." << endl;

    srand(time(NULL));
    int n[] = { 100, 500, 1000, 2500, 3000, 3500 };
    double calculateAve, realAve;
    int bound = 10000;
    int repeat = 100000;



    for (int i = 0; i < sizeof(n); i++) {
        int range = n[i];
        int* array = new int[range];
        long long int totalNumSteps = 0;


        for (int j = 0; j < repeat; j++) {
            for (int k = 0; k < range; k++) {
                array[k] = rand() % bound;
            }

            int insertionFunc = Insert(array, range);
            totalNumSteps += insertionFunc;
        }

        calculateAve = (pow(range, 2) / 4) + (3 * range / 4);
        realAve = static_cast<double>(totalNumSteps) / repeat;

        cout << setprecision(2) << fixed;

        cout << setw(6) << range << setw(19) << calculateAve << setw(22) << realAve << endl;
    }
    return 0;
}
int Insert(int A[], int n)
{
    int i, j, temp;
    int steps = 0;
    A[0] = -32768;
    for (i = 1; i <= n; i++)
    {
        j = i;
        while (A[j] < A[j - 1])
        {
            temp = A[j];

            A[j] = A[j - 1];

            A[j - 1] = temp;
            j--;
            steps++;
        }
        steps++;
    }
    return steps;
}
