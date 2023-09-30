#include <iostream>
#include <iomanip>

using namespace std;
int dp[10000];
#define max 60

long FiboR(int n) {

	if (n == 0 || n == 1) {
		return (n);
	}
	else {
		return (FiboR(n - 1) + FiboR(n - 2));
	}
}

long FiboNR(int n) {
	long F[max];

	F[0] = 0; F[1] = 1;

	for (int i = 2; i <= n; i++) {
		F[i] = F[i - 1] + F[i - 2];
	}
	return F[n];
}

int MODFibR(int n)
{
	if (n == 0 || n == 1)
		return n;
	if (dp[n] != -1)
		return dp[n];
	dp[n] = MODFibR(n - 1) + MODFibR(n - 2);
	return dp[n];
}
int main() {

	memset(dp, -1, 10000);
	clock_t Beginning;
	clock_t Last;
	double Amount_sec;

	int nums[] = { 1, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60 };


	cout << " Fibonacci" << " Time Analysis *Recursive" << " VS. Non-Recursive*" << endl;
	cout << "------------------------------------------------------" << endl;
	cout << "__________________________________________________________________________________" << endl;
	cout << "Integer		     FiboR.sec		     FiboNR.sec	         Fibo.value" << endl;

	for (int i = 0; i < sizeof(nums) / sizeof(int); i++) {

		int n = nums[i];
		long FV;

		Beginning = clock();
		FV = FiboR(n);
		Last = clock();

		Amount_sec = ((double)(Last - Beginning)) / CLOCKS_PER_SEC;


		cout << setw(4) << n;
		cout << setw(24) << Amount_sec;

		Beginning = clock();
		FV = FiboNR(n);
		Last = clock();


		Amount_sec = ((double)(Last - Beginning)) / CLOCKS_PER_SEC;
		cout << setw(26) << Amount_sec;
		cout << setw(20) << FV << endl;
	
		
		
		


			Beginning = clock();
	
			Last = clock();
			Amount_sec = ((double)((double)Last - (double)Beginning)) / CLOCKS_PER_SEC;
			printf(" %.2f", Amount_sec);
			cout << endl;


		}
	
	return 0;
}
	

