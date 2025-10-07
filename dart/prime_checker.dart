import 'dart:io';

void main() {
  print('--- Prime Number Checker ---');
  print('Enter a positive integer:');

  String? input = stdin.readLineSync();

  if (input == null || input.isEmpty) {
    print('Error: No input provided. Exiting.');
    return;
  }

  int? number = int.tryParse(input);

  if (number == null || number <= 0) {
    print('Error: Invalid number. Please enter a positive integer.');
    return;
  }

  if (isPrime(number)) {
    print('\nResult: $number IS a prime number.');
  } else {
    print('\nResult: $number is NOT a prime number.');
  }
}

bool isPrime(int n) {
  if (n <= 1) {
    return false;
  }

  if (n <= 3) {
    return true;
  }

  if (n % 2 == 0 || n % 3 == 0) {
    return false;
  }

  for (int i = 5; i * i <= n; i = i + 6) {
    if (n % i == 0 || n % (i + 2) == 0) {
      return false;
    }
  }

  return true;
}