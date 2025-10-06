// Recursive Fibonacci
int fibonacciRecursive(int n) {
  if (n <= 1) return n;
  return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

// Iterative Fibonacci (returns a list of first n numbers)
List<int> fibonacciIterative(int n) {
  if (n <= 0) return [];
  if (n == 1) return [0];
  if (n == 2) return [0, 1];

  List<int> fib = [0, 1];
  for (int i = 2; i < n; i++) {
    fib.add(fib[i - 1] + fib[i - 2]);
  }
  return fib;
}

void main() {
  int n = 10; // how many Fibonacci numbers to generate

  // Iterative example
  print("First $n Fibonacci numbers (Iterative):");
  print(fibonacciIterative(n));

  // Recursive example
  print("\nFibonacci using recursion:");
  for (int i = 0; i < n; i++) {
    print("Fib($i) = ${fibonacciRecursive(i)}");
  }
}
