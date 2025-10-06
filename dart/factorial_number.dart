// FactorialNumber.dart

class FactorialNumber {
  final int number;

  // Constructor
  FactorialNumber(this.number);

  // Iterative factorial calculation
  int calculate() {
    if (number < 0) {
      throw ArgumentError("Factorial is not defined for negative numbers");
    }
    int result = 1;
    for (int i = 1; i <= number; i++) {
      result *= i;
    }
    return result;
  }

  // Recursive factorial calculation (optional alternative)
  int calculateRecursive(int n) {
    if (n < 0) {
      throw ArgumentError("Factorial is not defined for negative numbers");
    }
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * calculateRecursive(n - 1);
  }
}

void main() {
  // Example usage
  var fact5 = FactorialNumber(5);
  print("5! (iterative) = ${fact5.calculate()}"); // Output: 120
  print("5! (recursive) = ${fact5.calculateRecursive(5)}"); // Output: 120

  var fact0 = FactorialNumber(0);
  print("0! = ${fact0.calculate()}"); // Output: 1

  try {
    var factNeg = FactorialNumber(-3);
    print(factNeg.calculate()); // This will throw an error
  } catch (e) {
    print("Error: $e");
  }
}
