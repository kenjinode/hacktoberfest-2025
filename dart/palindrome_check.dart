bool isPalindrome(String str) {
  int left = 0;
  int right = str.length - 1;

  while (left < right) {
    if (str[left] != str[right]) {
      return false; // mismatch found
    }
    left++;
    right--;
  }
  return true; // all characters matched
}

void main() {
  List<String> testWords = ["madam", "level", "hello", "racecar", "dart"];

  for (var word in testWords) {
    if (isPalindrome(word)) {
      print("$word is a Palindrome ✅");
    } else {
      print("$word is NOT a Palindrome ❌");
    }
  }
}
